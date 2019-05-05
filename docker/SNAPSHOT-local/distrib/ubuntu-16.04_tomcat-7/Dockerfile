FROM asqatasun/contrast-finder:pre-requisites_Ubuntu-16.04_tomcat-7

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
#   asqatasun/contrast-finder:pre-requisites_Ubuntu-16.04_tomcat-7  https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/pre-requisites/pre-requisites_Ubuntu-16.04_tomcat-7/Dockerfile
#   |-- ubuntu:16.04                                                https://github.com/tianon/docker-brew-ubuntu-core/blob/dist-amd64/xenial/Dockerfile
###################################################################

# environment variables
ENV CONTRAST_FINDER_RELEASE="0.9.6-SNAPSHOT"

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
# ----> see asqatasun/contrast-finder:pre-requisites_Ubuntu-16.04_tomcat-7

CMD  service tomcat7 start        ; \
     tail -f -n 50 ${TOMCAT_LOG}    \
                   ${LOG_FILE}




