#!/bin/bash

set -o errexit

#############################################
# Variables
#############################################
APP_NAME="Contrast-Finder"
TIMESTAMP=$(date +%Y-%m-%d) # format 2015-11-23, cf man date
SCRIPT=`basename ${BASH_SOURCE[0]}`

    #Set fonts for Help
        BOLD=$(tput bold)
      # STOT=$(tput smso)
      # UNDR=$(tput smul)
        REV=$(tput rev)
        RED=$(tput setaf 1)
        GREEN=$(tput setaf 2)
      # YELLOW=$(tput setaf 3)
      # MAGENTA=$(tput setaf 5)
      # WHITE=$(tput setaf 7)
        NORM=$(tput sgr0)

declare SOURCE_DIR
declare VAGRANT_DIR
declare HELP=false
declare FTESTS=false
declare SKIP_BUILD=false
declare SKIP_BUILD_TEST=false
declare USE_SUDO_DOCKER=false
declare ONLY_LOCALHOST=false
declare BUILD_ONLY_WEBAPP=false
declare BUILD_ONLY_DIR=false
declare LOG_BUILD=false
declare WEBAPP_DIR="webapp"

#############################################
# Usage
#############################################
usage () {
    cat <<EOF

  Help documentation for ${BOLD}${SCRIPT}${NORM}
  --------------------------------------------------------------
  This script launches a sequence that:
    - builds ${BOLD}${APP_NAME}${NORM} from sources
    - runs   a new VM
  --------------------------------------------------------------
  ${BOLD}${SCRIPT}${NORM} ${BOLD}${GREEN}-s${NORM} <directory> ${BOLD}${GREEN}-v${NORM} <directory> [OPTIONS]
  --------------------------------------------------------------
  ${BOLD}${GREEN}-s${NORM} | --source-dir     <directory> MANDATORY Absolute path to ${APP_NAME} sources directory
  ${BOLD}${GREEN}-v${NORM} | --vagrant-dir    <directory> MANDATORY Path to directory containing the VagrantFile.
                                              Path must be relative to SOURCE_DIR

  ${BOLD}-b${NORM} | --build-only-dir <directory> Build only webapp and <directory> (relative to SOURCE_DIR)
  ${BOLD}-w${NORM} | --build-only-webapp          Build only webapp (relies on previous build)
       --skip-build-test            Skip unit tests on Maven build
       --skip-build                 Skip Maven build (relies on previous build, that must exists)
       --log-build                  Log maven build

  ${BOLD}-h${NORM} | --help                      ${REV} Show this help ${NORM}
  ${BOLD}-f${NORM} | --functional-tests           Also execute functional tests. (not yet implemented)
EOF
    exit 2
}

#############################################
# Manage options and usage
#############################################
TEMP=`getopt -o s:v:b:whf --long source-dir:,vagrant-dir:,build-only-dir:,build-only-webapp,help,functional-tests,log-build,skip-build-test,skip-build -- "$@"`

if [[ $? != 0 ]] ; then
    echo "Terminating..." >&2 ;
    exit 1 ;
fi

# Note the quotes around `$TEMP': they are essential!
eval set -- "${TEMP}"

while true; do
  case "$1" in
    -s | --source-dir )         SOURCE_DIR="$2";             shift 2 ;;
    -v | --vagrant-dir )        VAGRANT_DIR="$2";             shift 2 ;;
    -b | --build-only-dir )     BUILD_ONLY_DIR="$2";         shift 2 ;;
    -w | --build-only-webapp )  BUILD_ONLY_WEBAPP=true;      shift ;;
    -h | --help )               HELP=true;                   shift ;;
    -f | --functional-tests )   FTESTS=true;                 shift ;;
    --log-build )               LOG_BUILD=true;              shift ;;
    --skip-build-test )         SKIP_BUILD_TEST=true;        shift ;;
    --skip-build )              SKIP_BUILD=true;             shift ;;
    * ) break ;;
  esac
done

if [[ -z "$SOURCE_DIR" || -z "$VAGRANT_DIR" || "$HELP" == "true" ]]; then
    usage
fi


#############################################
# Variables
#############################################

TGZ_EXT=".tar.gz"
TGZ_BASENAME="webapp/target/contrast-finder"
ADD_IP=''
URL_TOMCAT="http://localhost:8787"
URL_APP="${URL_TOMCAT}/contrast-finder/"


#############################################
# Functions
#############################################

fail() {
    ERROR_MSG=$*
    echo ""
    echo " ${RED}-----------------------------------------------------------${NORM}"
    echo " ${BOLD}FAILURE${NORM}: loading ${APP_NAME} is not possible."
    echo " ${RED}${ERROR_MSG}${NORM}"
    echo " ${RED}-----------------------------------------------------------${NORM}"
    exit -1
}

# display a step message
function display_step_msg() {
    echo " -------------------------------------------------------"
    echo " ${1}"
}

# ask the user to confirm (Y|y|yes|[enter]
function user_confirmation() {
    RUN_TESTS=false
    YES=false # -y option  not yet implemented
    if ${YES} ;  then
        RUN_TESTS=true
    else
        read -r -p " Are you sure? ... [Y/n] " REPLY
        REPLY=${REPLY,,} # tolower
        if [[ $REPLY =~ ^(yes|y| ) ]] || [[ -z $REPLY ]]; then
            RUN_TESTS=true
        fi
    fi
    echo    # (optional) move to a new line
}


function kill_previous_vm() {
    display_step_msg "Stop and remove the previous ${BOLD}${GREEN}Vagrant${NORM} VM"
    cd ${SOURCE_DIR}
    cd ${VAGRANT_DIR}
    set +e
    vagrant destroy -f
    set -e
}

function build() {
    MAVEN_OPTION=''
    if ${SKIP_BUILD_TEST} ; then
        MAVEN_OPTION=' -Dmaven.test.skip=true '; # skip unit tests
    fi

    MAVEN_LOG=''
    if ${LOG_BUILD}; then
        MAVEN_LOG=" | tee log_maven.log";
    fi

    BUILD_CMD="mvn clean install ${MAVEN_OPTION} ${MAVEN_LOG}"
    BUILD_DIR=$*
    if [[ -d "${BUILD_DIR}" ]] ; then
        (cd  "${BUILD_DIR}"; eval ${BUILD_CMD}) || fail "Error at build ${BUILD_DIR}"
    else
        fail "not valid directory ${BUILD_DIR}"
    fi
}

function do_build() {
    display_step_msg "Maven ${BOLD}${GREEN}build${NORM}"
    if [[ -n "$BUILD_ONLY_DIR" && "$BUILD_ONLY_DIR" != "false" ]]  ; then
        build "${SOURCE_DIR}/${BUILD_ONLY_DIR}"
        build "${SOURCE_DIR}/${WEBAPP_DIR}"
    elif ${BUILD_ONLY_WEBAPP} ; then
        build "${SOURCE_DIR}/${WEBAPP_DIR}"
    else
        build "${SOURCE_DIR}"
    fi
}

# copy TAR.GZ to docker dir
function do_copy_targz() {
    display_step_msg "Copy ${BOLD}${GREEN}tar.gz${NORM} to the docker directory"
    cp -vf "${SOURCE_DIR}/${TGZ_BASENAME}"*"${TGZ_EXT}" "${SOURCE_DIR}/${DOCKER_DIR}/" ||
        fail "Error copying ${SOURCE_DIR}/${TGZ_BASENAME}"
}

# copy TAR.GZ to docker dir
function do_copy_deb() {
    DEB_BASENAME="dist./debian_package/target/"
    DEB_EXT=".deb"
    display_step_msg "Copy ${BOLD}${GREEN}.deb${NORM} to the VM directory"
    cp -vf "${SOURCE_DIR}/${DEB_BASENAME}"*"${DEB_EXT}" "${SOURCE_DIR}/${VAGRANT_DIR}/" ||
        fail "Error copying ${SOURCE_DIR}/${DEB_BASENAME}"
}

function do_vagrant_run() {
    kill_previous_vm

    display_step_msg "Start ${BOLD}${GREEN}Vagrant${NORM} VM"
    cd ${SOURCE_DIR}
    cd ${VAGRANT_DIR}
    vagrant up
}

function do_maven_log_processing() {
    if [[ ${LOG_BUILD} && "${SKIP_BUILD}" == "false" ]] ; then
        LOG_DIR_SRC="${SOURCE_DIR}"
        if ${BUILD_ONLY_WEBAPP} ; then
            LOG_DIR_SRC="${SOURCE_DIR}/${WEBAPP_DIR}";
        fi
        LOG_DIR_SRC="${LOG_DIR_SRC}";
        LOG_DIR="${LOG_DIR_SRC}/target";
        mkdir -p "${LOG_DIR}"
        if [ -f "${LOG_DIR_SRC}/log_maven.log" ];then
            mv  "${LOG_DIR_SRC}/log_maven.log" "${LOG_DIR}/"
        fi
        echo " -------------------------------------------------------"
        grep "<<< FAILURE! -" < "${LOG_DIR}/log_maven.log" | tee "${LOG_DIR}/log_maven-FAIL.log" ;
        grep "WARN"           < "${LOG_DIR}/log_maven.log" | tee "${LOG_DIR}/log_maven-WARM.log" > "/dev/null" ;
        FAIL=`wc -l < "${LOG_DIR}/log_maven-FAIL.log"` ;
        WARM=`wc -l < "${LOG_DIR}/log_maven-WARM.log"` ;
        echo " maven FAILURE ... ${FAIL} ";
        echo " maven WARN ...... ${WARM} ";
    fi
}

# functional testing
function do_functional_testing() {
    display_step_msg "Functional ${BOLD}${GREEN}testing ${NORM}"
    user_confirmation
    if ${RUN_TESTS} ; then
        fail  " The functional tests are not yet implemented"
        # see http://docs.seleniumhq.org/download/maven.jsp
        view_build_summary
    fi
}

# view build summary
function view_build_summary () {
    if   ${LOG_BUILD}; then
        do_maven_log_processing;
    fi
    echo " -------------------------------------------------------"
    echo " -------------------------------------------------------"
    echo " URL ......... ${BOLD}${GREEN}${URL_APP}${NORM}"
}

#############################################
# Do the actual job
#############################################

if ! ${SKIP_BUILD};        then  do_build;                  fi
                                 do_copy_deb
                                 do_vagrant_run
                                 view_build_summary
if   ${FTESTS};            then  do_functional_testing;     fi
