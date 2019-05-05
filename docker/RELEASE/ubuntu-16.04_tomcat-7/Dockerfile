FROM asqatasun/contrast-finder:pre-requisites_Ubuntu-16.04_tomcat-7
LABEL org.label-schema.schema-version = "1.0.0-rc.1"                                            \
      org.label-schema.name           = "Contrast-Finder - WebApp (Ubuntu 16.04 - Tomcat 7)"    \
      org.label-schema.version        = "0.9.6-SNAPSHOT"                                        \
      org.label-schema.url            = "https://contrast-finder.org"                           \
      org.label-schema.vcs-url        = "https://github.com/Asqatasun/Contrast-Finder"          \
      org.label-schema.docker.cmd     = "docker run -p 8087:8080 -d asqatasun/contrast-finder"  \
      org.label-schema.usage          = "https://github.com/Asqatasun/Contrast-Finder/tree/develop/documentation/"  \
      org.label-schema.description    = "Contrast-Finder finds correct color contrasts for web accessibility."
          # ----> documentation  http://label-schema.org/

# #### usage ######################################################
#
#   --- Building this docker image
#   docker build -t asqatasun/contrast-finder  .
#   docker build -t asqatasun/contrast-finder  --build-arg CONTRAST_FINDER_RELEASE=0.9.6-SNAPSHOT  .
#   docker build -t asqatasun/contrast-finder  --build-arg SRC_URL_PREFIX=https://github.com/Asqatasun/Contrast-Finder/releases/download/v0.9.6-SNAPSHOT/   .
#   docker build -t asqatasun/contrast-finder  --build-arg SRC_URL=https://github.com/Asqatasun/Contrast-Finder/releases/download/v0.9.6-SNAPSHOT/contrast-finder-webapp_0.9.6-SNAPSHOT.tar.gz   .
#
#   --- Launch a container
#   docker run -p 127.0.0.1:8087:8080 --name contrast.finder -d asqatasun/contrast-finder
#
#   --- Playing with this docker image
#   docker exec -ti contrast.finder /bin/cat  /softwares-version.txt
#   docker exec -ti contrast.finder /bin/bash
#   docker logs -f contrast.finder
#
# #### source code  ###############################################
#   https://github.com/Asqatasun/Contrast-Finder/releases/download/v${CONTRAST_FINDER_RELEASE}/contrast-finder-webapp_${CONTRAST_FINDER_RELEASE}.tar.gz
#     could be overridden with  --build-arg CONTRAST_FINDER_RELEASE=<release>
#     could be overridden with  --build-arg SRC_URL_PREFIX=<url_prefix>
#     could be overridden with  --build-arg SRC_URL=<url>
#
# #### FROM  ######################################################
#   asqatasun/contrast-finder:pre-requisites_Ubuntu-16.04_tomcat-7  https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/pre-requisites/pre-requisites_Ubuntu-16.04_tomcat-7/Dockerfile
#   |-- ubuntu:16.04                                                https://github.com/tianon/docker-brew-ubuntu-core/blob/dist-amd64/xenial/Dockerfile
###################################################################

# build variables
ARG CONTRAST_FINDER_RELEASE="0.9.6-SNAPSHOT"
ARG SRC_URL_PREFIX="https://github.com/Asqatasun/Contrast-Finder/releases/download/v${CONTRAST_FINDER_RELEASE}"
ARG SRC_URL="${SRC_URL_PREFIX}/contrast-finder-webapp_${CONTRAST_FINDER_RELEASE}.tar.gz"

# Install contrast-finder
RUN  cd         /root/                                              && \
     wget       ${SRC_URL}                                          && \
     tar  -xzvf contrast-*.tar.gz                                   && \
     cd         /root/contrast-*/install/                           && \
     mv   -v    contrast-*.war    contrast-finder.war               && \
     mv   -v    contrast-*.war    /var/lib/tomcat7/webapps          && \
     rm   -rf  /root/contrast-*                                     && \
     echo ${CONTRAST_FINDER_RELEASE}               >> ${INFO_FILE}  && \
     echo "\n--- ${CONF_FILE} ---"                 >> ${INFO_FILE}  && \
     cat  ${CONF_FILE}                             >> ${INFO_FILE}  && \
     echo "\n--- Logs -----------"                 >> ${INFO_FILE}  && \
     echo "${TOMCAT_LOG}"                          >> ${INFO_FILE}  && \
     echo "${LOG_FILE}"                            >> ${INFO_FILE}  && \
     echo "--------------------"                   >> ${INFO_FILE}  && \
     cat  ${INFO_FILE} > ${LOG_FILE} && echo "-- Install: Ok"

# environment variables
ENV CONTRAST_FINDER=${CONTRAST_FINDER_RELEASE}
ENV SRC=${SRC_URL}

# Health Check of the Docker Container
# ----> see asqatasun/contrast-finder:pre-requisites_Ubuntu-16.04_tomcat-7

CMD  service tomcat7 start        ; \
     tail -f -n 50 ${TOMCAT_LOG}    \
                   ${LOG_FILE}

