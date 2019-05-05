FROM asqatasun/contrast-finder:pre-requisites_Alpine_tomcat-9

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
#   asqatasun/contrast-finder:pre-requisites_Alpine_tomcat-9  https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/pre-requisites/pre-requisites_Alpine_tomcat-9/Dockerfile
#   |-- tomcat:9-jre8-alpine     https://github.com/docker-library/tomcat/blob/master/9.0/jre8-alpine/Dockerfile
#       |-- openjdk:8-jre-alpine   https://github.com/docker-library/openjdk/blob/master/8-jre/alpine/Dockerfile
#           |-- alpine:3.7         https://github.com/gliderlabs/docker-alpine/blob/master/versions/library-3.7/x86_64/Dockerfile
###################################################################


# environment variables
ENV CONTRAST_FINDER_RELEASE="0.9.6-SNAPSHOT"

# Add contrast-finder .war
ADD contrast-finder-webapp_${CONTRAST_FINDER_RELEASE}.tar.gz  /root

# Install contrast-finder
RUN  cd      /root/contrast-*/install/                              && \
     mv -v   contrast-*.war contrast-finder.war                     && \
     mv -v   contrast-*.war ${TOMCAT_DIR}webapps                    && \
     rm -rf  /root/contrast-*                                       && \
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
# ----> see asqatasun/contrast-finder:pre-requisites_Alpine_tomcat-8.5


###### don't work ############################
# CMD  catalina.sh run ;                                \
#      tail -f -n 200 ${TOMCAT_DIR}logs/catalina.*.log  \
#                    ${LOG_FILE}
###################################################

    # in "tomcat:9-jre8-alpine" DockerFile
    #     CMD ["catalina.sh", "run"]
