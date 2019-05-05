FROM tomcat:9-jre9
LABEL org.label-schema.schema-version = "1.0.0-rc.1"                                                                 \
      org.label-schema.name           = "Contrast-Finder - WebApp pre-requisites (tomcat 9 < jdk 9 < debian SID)"    \
      org.label-schema.url            = "https://contrast-finder.org"                                                \
      org.label-schema.vcs-url        = "https://github.com/Asqatasun/Contrast-Finder"                               \
      org.label-schema.version        = "0.9.6-SNAPSHOT"
          # ----> documentation  http://label-schema.org/

# #### usage ######################################################
#
#   --- Building this docker image
#   docker build -t contrast-finder:pre-requisites_Debian_tomcat-9_jre9  .
#
# #### FROM  ######################################################
#   tomcat:9-jre9                    https://github.com/docker-library/tomcat/blob/master/9.0/jre9/Dockerfile
#   |-- openjdk:9-jre                https://github.com/docker-library/openjdk/blob/master/9-jre/Dockerfile
#       |-- buildpack-deps:sid-curl  https://github.com/docker-library/buildpack-deps/blob/master/sid/curl/Dockerfile
#           |-- debian:sid           https://github.com/debuerreotype/docker-debian-artifacts/blob/dist-amd64/sid/Dockerfile
###################################################################

######  PRE-REQUISITES ##########################################################

# build variables
ARG LOG_DIR="/var/log/contrast-finder/"
ARG CONF_DIR="/etc/contrast-finder/"

# environment variables
ENV     TOMCAT_DIR="/usr/local/tomcat/"                              \
        LOG_FILE="${LOG_DIR}contrast-finder.log"                     \
        CONF_FILE="${CONF_DIR}contrast-finder.conf"                  \
        INFO_FILE="/softwares-version.txt"                           \
        WWWPORT="8080"
EXPOSE  $WWWPORT

# build
RUN  mkdir   -p  ${LOG_DIR}                                 && \
     mkdir   -p  ${CONF_DIR}                                && \
     touch   ${LOG_FILE}                                    && \
     touch   ${CONF_FILE}                                   && \
     echo "--- OS -------------"       >> ${INFO_FILE}      && \
     cat /etc/os-release               >> ${INFO_FILE}      && \
     echo ""                           >> ${INFO_FILE}      && \
     echo "--- Java -----------"       >> ${INFO_FILE}      && \
     echo ${JAVA_HOME}                 >> ${INFO_FILE}      && \
     java -version                    2>> ${INFO_FILE}      && \
     echo ""                           >> ${INFO_FILE}      && \
     echo "--- Tomcat ---------"       >> ${INFO_FILE}      && \
     ${TOMCAT_DIR}bin/version.sh       >> ${INFO_FILE}      && \
     echo ""                           >> ${INFO_FILE}      && \
     echo "--- Contrast-Finder ---"    >> ${INFO_FILE}


        #######################################################################################
        # The command line "java -version" returns the output data
        # at the STDERR stream (2 : error messages) rather than STDOUT (1).
        # -----> java -version 2> tmp.txt
        #
        # https://stackoverflow.com/questions/21453774/redirect-java-version-to-file-or-variable
        # https://stackoverflow.com/questions/39619087/how-to-write-output-of-java-version-to-a-text-file
        #######################################################################################


# Health Check of the Docker Container
HEALTHCHECK --timeout=3s    \
            CMD curl --fail http://localhost:8080/contrast-finder/ || exit 1
            ######################################################################
            # doc: https://docs.docker.com/engine/reference/builder/#healthcheck
            # options:  --interval=DURATION (default: 30s)
            #           --timeout=DURATION (default: 30s)
            #           --retries=N (default: 3)
            # can be overridden at the command line 'docker run --health-cmd (...)'
            ######################################################################


# in "tomcat:9-jre9" DockerFile
#     CMD ["catalina.sh", "run"]

