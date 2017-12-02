FROM ubuntu:16.04
LABEL org.label-schema.schema-version = "1.0.0-rc.1"                                                         \
      org.label-schema.name           = "Contrast-Finder - WebApp pre-requisites (Ubuntu 16.04 - Tomcat 7)"  \
      org.label-schema.url            = "https://contrast-finder.org"                                        \
      org.label-schema.vcs-url        = "https://github.com/Asqatasun/Contrast-Finder"                       \
      org.label-schema.version        = "0.8.4-SNAPSHOT"
          # ----> documentation  http://label-schema.org/

# #### usage ######################################################
#
#   --- Building this docker image
#   docker build -t contrast-finder:pre-requisites_Ubuntu-16.04 .
#
# #### FROM  ######################################################
#   ubuntu:16.04  https://github.com/tianon/docker-brew-ubuntu-core/blob/dist-amd64/xenial/Dockerfile
###################################################################

# build variables
ARG LOG_DIR="/var/log/contrast-finder/"
ARG CONF_DIR="/etc/contrast-finder/"

# environment variables
ENV     LOG_FILE="${LOG_DIR}contrast-finder.log" \
        INFO_FILE="${CONF_DIR}softwares-version.txt"  \
        CONF_FILE="${CONF_DIR}contrast-finder.conf"   \
        WWWPORT="8080"
EXPOSE  $WWWPORT

# build
RUN  apt-get update                                         && \
     apt-get -y --no-install-recommends                             \
             install wget                                           \
                     curl                                           \
                     ca-certificates                                \
                     tomcat7                                        \
                     libspring-instrument-java              && \
     apt-get clean                                          && \
     apt-get autoremove                                     && \
     rm      -rf /var/lib/apt/lists/*                       && \
     mkdir   -p  ${LOG_DIR}                                 && \
     mkdir   -p  ${CONF_DIR}                                && \
     touch   ${LOG_FILE}                                    && \
     touch   ${CONF_FILE}                                   && \
     chown   -R tomcat7:tomcat7 ${LOG_DIR}                  && \
     chown   -R tomcat7:tomcat7 ${CONF_DIR}                 && \
     echo "\n--- OS -------------"     >> ${INFO_FILE}      && \
     cat /etc/os-release               >> ${INFO_FILE}      && \
     echo "\n--- Tomcat ---------"     >> ${INFO_FILE}      && \
     /usr/share/tomcat7/bin/version.sh >> ${INFO_FILE}      && \
     echo "\n--- Contrast-Finder ---"  >> ${INFO_FILE}      && \
     ln -s   /usr/share/java/spring3-instrument-tomcat.jar          \
             /usr/share/tomcat7/lib/spring3-instrument-tomcat.jar


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

CMD  service tomcat7 start                      ;  \
     tail -f /var/log/tomcat7/catalina.out


