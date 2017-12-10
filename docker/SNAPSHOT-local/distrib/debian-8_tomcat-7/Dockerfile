FROM tomcat:7.0-jre7
LABEL org.label-schema.schema-version = "1.0.0-rc.1"                                                         \
      org.label-schema.name           = "Contrast-Finder - WebApp (tomcat7 < jdk7 < debian 8 jessie)"        \
      org.label-schema.url            = "https://contrast-finder.org"                                        \
      org.label-schema.vcs-url        = "https://github.com/Asqatasun/Contrast-Finder"                       \
      org.label-schema.version        = "0.8.4-SNAPSHOT"
          # ----> documentation  http://label-schema.org/

# #### usage ######################################################
#
#   --- Building this docker image
#   docker build -t asqatasun/contrast-finder:SNAPSHOT_local  .
#
#   --- Launch a container
#   docker run -p 127.0.0.1:8087:8080 --name contrast.finder -d asqatasun/contrast-finder:SNAPSHOT_local
#
#   --- Playing with this docker image
#   docker exec -ti contrast.finder /bin/cat  /softwares-version.txt
#   docker exec -ti contrast.finder /bin/bash
#   docker logs -f contrast.finder
#
# #### FROM  ######################################################
#   tomcat:7.0-jre7                     https://github.com/docker-library/tomcat/blob/master/7/jre7/Dockerfile
#   |-- openjdk:7-jre                   https://github.com/docker-library/openjdk/blob/master/7-jre/Dockerfile
#       |-- buildpack-deps:jessie-curl  https://github.com/docker-library/buildpack-deps/blob/master/jessie/curl/Dockerfile
#         |-- debian:jessie             https://github.com/debuerreotype/docker-debian-artifacts/blob/dist-amd64/jessie/Dockerfile
###################################################################

######  PRE-REQUISITES ##########################################################

# build variables
ARG LOG_DIR="/var/log/contrast-finder/"
ARG CONF_DIR="/etc/contrast-finder/"

# environment variables
ENV     TOMCAT_DIR="/usr/local/tomcat/"
ENV     LOG_FILE="${LOG_DIR}contrast-finder.log"    \
        CONF_FILE="${CONF_DIR}contrast-finder.conf" \
        INFO_FILE="/softwares-version.txt"          \
        WWWPORT="8080"
EXPOSE  $WWWPORT

# build
RUN  apt-get update                                         && \
     apt-get -y --no-install-recommends                             \
             install libspring-instrument-java              && \
     apt-get clean                                          && \
     apt-get autoremove                                     && \
     rm      -rf /var/lib/apt/lists/*                       && \
     rm      -rvf /usr/share/man/*                          && \
     rm      -rvf /usr/share/doc/*                          && \
     mkdir   -p  ${LOG_DIR}                                 && \
     mkdir   -p  ${CONF_DIR}                                && \
     touch   ${LOG_FILE}                                    && \
     touch   ${CONF_FILE}                                   && \
     echo "\n--- OS -------------"     >> ${INFO_FILE}      && \
     cat /etc/os-release               >> ${INFO_FILE}      && \
     echo "\n--- Java -----------"     >> ${INFO_FILE}      && \
     java -version                    2>> ${INFO_FILE}      && \
     echo "\n--- Tomcat ---------"     >> ${INFO_FILE}      && \
     ${TOMCAT_DIR}bin/version.sh       >> ${INFO_FILE}      && \
     echo "\n--- Contrast-Finder ---"  >> ${INFO_FILE}      && \
     ln -s   /usr/share/java/spring3-instrument-tomcat.jar          \
             ${TOMCAT_DIR}lib/spring3-instrument-tomcat.jar

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

# in "tomcat:7.0-jre7" DockerFile
#     CMD ["catalina.sh", "run"]


######  WEBAPP ##########################################################

# environment variables
ENV CONTRAST_FINDER_RELEASE="0.8.4-SNAPSHOT"

# Add contrast-finder .war
ADD contrast-finder_${CONTRAST_FINDER_RELEASE}.i386.tar.gz  /root

# Install contrast-finder
RUN  cd      /root/contrast-*/install/                              && \
     mv -v   contrast-*.war contrast-finder.war                     && \
     mv -v   contrast-*.war ${TOMCAT_DIR}webapps                    && \
     rm -rf  /root/contrast-*                                       && \
     echo ${CONTRAST_FINDER_RELEASE}               >> ${INFO_FILE}  && \
     echo "\n--- ${CONF_FILE} ---"                 >> ${INFO_FILE}  && \
     cat  ${CONF_FILE}                             >> ${INFO_FILE}  && \
     echo "\n--- Logs -----------"                 >> ${INFO_FILE}  && \
     echo "${TOMCAT_DIR}logs/catalina.*.log"       >> ${INFO_FILE}  && \
     echo "${LOG_FILE}"                            >> ${INFO_FILE}  && \
     echo "--------------------"                   >> ${INFO_FILE}  && \
     cat  ${INFO_FILE} > ${LOG_FILE} && echo "-- Install: Ok"


# Health Check of the Docker Container
# ----> see asqatasun/contrast-finder:pre-requisites_(...)


###### don't work ############################
# CMD  catalina.sh run ;                                \
#      tail -f -n 200 ${TOMCAT_DIR}logs/catalina.*.log  \
#                    ${LOG_FILE}
###################################################

    # in "tomcat:7.0-jre7" DockerFile
    #     CMD ["catalina.sh", "run"]
