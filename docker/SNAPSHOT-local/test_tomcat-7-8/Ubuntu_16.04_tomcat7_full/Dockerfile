FROM ubuntu:16.04
LABEL org.label-schema.schema-version = "1.0.0-rc.1"                                                         \
      org.label-schema.name           = "Contrast-Finder - WebApp pre-requisites (Ubuntu 16.04 - Tomcat 7)"  \
      org.label-schema.url            = "https://contrast-finder.org"                                        \
      org.label-schema.vcs-url        = "https://github.com/Asqatasun/Contrast-Finder"                       \
      org.label-schema.version        = "0.8.5-SNAPSHOT"
          # ----> documentation  http://label-schema.org/

# #### usage ######################################################
#
#   --- Building this docker image
#   docker build -t contrast-finder .
#
# #### FROM  ######################################################
#   ubuntu:16.04  https://github.com/tianon/docker-brew-ubuntu-core/blob/dist-amd64/xenial/Dockerfile
###################################################################

# build variables
ARG LOG_DIR="/var/log/contrast-finder/"
ARG CONF_DIR="/etc/contrast-finder/"

# environment variables
ENV     TOMCAT_LOG="/var/log/tomcat7/catalina.out"      \
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
                     tomcat7                                && \
     apt-get clean                                          && \
     apt-get autoremove                                     && \
     rm      -rf /var/lib/apt/lists/*                       && \
     rm      -rvf /usr/share/man/*                          && \
     rm      -rvf /usr/share/doc/*                          && \
     mkdir   -p  ${LOG_DIR}                                 && \
     mkdir   -p  ${CONF_DIR}                                && \
     touch   ${LOG_FILE}                                    && \
     touch   ${CONF_FILE}                                   && \
     chown   -R tomcat7:tomcat7 ${LOG_DIR}                  && \
     chown   -R tomcat7:tomcat7 ${CONF_DIR}                 && \
     echo "\n--- OS -------------"     >> ${INFO_FILE}      && \
     cat /etc/os-release               >> ${INFO_FILE}      && \
     echo "\n--- Java -----------"     >> ${INFO_FILE}      && \
     java -version                    2>> ${INFO_FILE}      && \
     echo "\n--- Tomcat ---------"     >> ${INFO_FILE}      && \
     /usr/share/tomcat7/bin/version.sh >> ${INFO_FILE}      && \
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

# environment variables
ENV CONTRAST_FINDER_RELEASE="0.8.5-SNAPSHOT"

# Add contrast-finder .war
ADD contrast-finder-webapp_${CONTRAST_FINDER_RELEASE}.tar.gz  /root

# Install contrast-finder
RUN  cd      /root/contrast-*/install/                              && \
     mv -v   contrast-*.war contrast-finder.war                     && \
     mv -v   contrast-*.war /var/lib/tomcat7/webapps                && \
     rm -rf  /root/contrast-*                                       && \
     echo ${CONTRAST_FINDER_RELEASE}               >> ${INFO_FILE}  && \
     echo "\n--- ${CONF_FILE} ---"                 >> ${INFO_FILE}  && \
     cat  ${CONF_FILE}                             >> ${INFO_FILE}  && \
     echo "\n--- Logs -----------"                 >> ${INFO_FILE}  && \
     echo "${TOMCAT_LOG}"                          >> ${INFO_FILE}  && \
     echo "${LOG_FILE}"                            >> ${INFO_FILE}  && \
     echo "--------------------"                   >> ${INFO_FILE}  && \
     cat  ${INFO_FILE} > ${LOG_FILE} && echo "-- Install: Ok"


# Health Check of the Docker Container
# ----> see asqatasun/contrast-finder:pre-requisites_*

CMD  service tomcat7 start        ; \
     tail -f -n 600 ${TOMCAT_LOG}    \
                    ${LOG_FILE}



