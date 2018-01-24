FROM asqatasun/contrast-finder:pre-requisites_Fedora-27_tomcat-8.0

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
#   asqatasun/contrast-finder:pre-requisites_Fedora-27_tomcat-8.0 https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/pre-requisites/pre-requisites_Fedora-27_tomcat-8.0/Dockerfile
#   |-- fedora:27                                                 https://github.com/fedora-cloud/docker-brew-fedora/blob/27/x86_64/Dockerfile
###################################################################

# environment variables
ENV CONTRAST_FINDER_RELEASE="0.8.5-SNAPSHOT"

# Add contrast-finder .war
ADD contrast-finder-webapp_${CONTRAST_FINDER_RELEASE}.tar.gz  /root

# Install contrast-finder
RUN  cd      /root/contrast-*/install/                              && \
     mv -v   contrast-*.war contrast-finder.war                     && \
     mv -v   contrast-*.war /var/lib/tomcat/webapps                 && \
     rm -rf  /root/contrast-*                                       && \
     echo ${CONTRAST_FINDER_RELEASE}               >> ${INFO_FILE}  && \
     echo "--- ${CONF_FILE} ---"                   >> ${INFO_FILE}  && \
     cat  ${CONF_FILE}                             >> ${INFO_FILE}  && \
     echo "--- Logs -----------"                   >> ${INFO_FILE}  && \
     echo "${TOMCAT_LOG}"                          >> ${INFO_FILE}  && \
     echo "${LOG_FILE}"                            >> ${INFO_FILE}  && \
     echo "--------------------"                   >> ${INFO_FILE}  && \
     cat  ${INFO_FILE} > ${LOG_FILE} && echo "-- Install: Ok"


# Health Check of the Docker Container
# ----> see asqatasun/contrast-finder:pre-requisites_Fedora-27_tomcat-8.0

# /usr/sbin/tomcat start  ;      \


CMD  echo "BANCO" ;                 \
     systemctl start tomcat  ;      \
     tail -f -n 50 ${TOMCAT_LOG}    \
                   ${LOG_FILE}
