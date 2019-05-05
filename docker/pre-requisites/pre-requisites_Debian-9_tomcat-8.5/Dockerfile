FROM debian:9
LABEL org.label-schema.schema-version = "1.0.0-rc.1"                                                           \
      org.label-schema.name           = "Contrast-Finder - WebApp pre-requisites (Debian 9 - Tomcat 8.5)"      \
      org.label-schema.url            = "https://contrast-finder.org"                                          \
      org.label-schema.vcs-url        = "https://github.com/Asqatasun/Contrast-Finder"                         \
      org.label-schema.version        = "0.9.6-SNAPSHOT"
          # ----> documentation  http://label-schema.org/

# #### usage ######################################################
#
#   --- Building this docker image
#   docker build -t contrast-finder:pre-requisites_Debian-9_tomcat-8.5  .
#
# #### FROM  ######################################################
#   debian:9  https://github.com/debuerreotype/docker-debian-artifacts/blob/dist-amd64/stretch/Dockerfile
###################################################################

# build variables
ARG LOG_DIR="/var/log/contrast-finder/"
ARG CONF_DIR="/etc/contrast-finder/"

# environment variables
ENV     TOMCAT_LOG="/var/log/tomcat8/catalina.out"      \
        LOG_FILE="${LOG_DIR}contrast-finder.log"        \
        CONF_FILE="${CONF_DIR}contrast-finder.conf"     \
        INFO_FILE="/softwares-version.txt"              \
        WWWPORT="8080"
EXPOSE  $WWWPORT

# build
RUN  apt-get update                                         && \
     apt-get -y --no-install-recommends                 \
             install wget                               \
                     curl                               \
                     ca-certificates                    \
                     tomcat8                                && \
     apt-get clean                                          && \
     apt-get autoremove                                     && \
     rm      -rvf /var/lib/apt/lists/*                       && \
     rm      -rvf /usr/share/man/*                          && \
     rm      -rvf /usr/share/doc/*                          && \
     mkdir   -p  ${LOG_DIR}                                 && \
     mkdir   -p  ${CONF_DIR}                                && \
     touch   ${LOG_FILE}                                    && \
     touch   ${CONF_FILE}                                   && \
     chown   -R tomcat8:tomcat8 ${LOG_DIR}                  && \
     chown   -R tomcat8:tomcat8 ${CONF_DIR}                 && \
     echo "\n--- OS -------------"     >> ${INFO_FILE}      && \
     cat /etc/os-release               >> ${INFO_FILE}      && \
     echo "\n--- Java -----------"     >> ${INFO_FILE}      && \
     java -version                    2>> ${INFO_FILE}      && \
     echo "\n--- Tomcat ---------"     >> ${INFO_FILE}      && \
     /usr/share/tomcat8/bin/version.sh >> ${INFO_FILE}      && \
     echo "\n--- Contrast-Finder ---"  >> ${INFO_FILE}

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

CMD  service tomcat8 start   ;  \
     tail -f ${TOMCAT_LOG}


