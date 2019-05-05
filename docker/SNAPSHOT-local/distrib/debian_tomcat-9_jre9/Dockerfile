FROM asqatasun/contrast-finder:pre-requisites_Debian_tomcat-9_jre9

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
#   asqatasun/contrast-finder:pre-requisites_Debian_tomcat-9_jre9   https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/pre-requisites/pre-requisites_Debian_tomcat-9_jre9/Dockerfile
#   |-- tomcat:9-jre9                    https://github.com/docker-library/tomcat/blob/master/9.0/jre9/Dockerfile
#       |-- openjdk:9-jre                https://github.com/docker-library/openjdk/blob/master/9-jre/Dockerfile
#           |-- buildpack-deps:sid-curl  https://github.com/docker-library/buildpack-deps/blob/master/sid/curl/Dockerfile
#               |-- debian:sid           https://github.com/debuerreotype/docker-debian-artifacts/blob/dist-amd64/sid/Dockerfile
###################################################################

# environment variables
ENV CONTRAST_FINDER_RELEASE="0.9.6-SNAPSHOT"
ENV CONF_ENV="debug"

# Add contrast-finder .war
ADD contrast-finder-webapp_${CONTRAST_FINDER_RELEASE}.tar.gz  /root

# Install contrast-finder
RUN  cd      /root/contrast-*/install/                              && \
     mv -v   contrast-*.war contrast-finder.war                     && \
     mv -v   contrast-*.war ${TOMCAT_DIR}webapps                    && \
     rm -rf  /root/contrast-*                                       && \
echo "env=${CONF_ENV}"  >> ${CONF_FILE}                             && \
     echo ${CONTRAST_FINDER_RELEASE}               >> ${INFO_FILE}  && \
     echo ""                                       >> ${INFO_FILE}  && \
     echo "--- ${CONF_FILE} ---"                   >> ${INFO_FILE}  && \
     cat  ${CONF_FILE}                             >> ${INFO_FILE}  && \
     echo ""                                       >> ${INFO_FILE}  && \
     echo "--- Logs -----------"                   >> ${INFO_FILE}  && \
     echo "${TOMCAT_DIR}logs/catalina.*.log"       >> ${INFO_FILE}  && \
     echo "${LOG_FILE}"                            >> ${INFO_FILE}  && \
     echo "--------------------"                   >> ${INFO_FILE}  && \
     cat  ${INFO_FILE} > ${LOG_FILE} && echo "-- Install: Ok"


# Health Check of the Docker Container
# ----> see asqatasun/contrast-finder:pre-requisites_debian-sid_tomcat-9_jre9


###### don't work ############################
# CMD  catalina.sh run ;                                \
#      tail -f -n 200 ${TOMCAT_DIR}logs/catalina.*.log  \
#                    ${LOG_FILE}
###################################################

    # in "tomcat:9-jre9" DockerFile
    #     CMD ["catalina.sh", "run"]
