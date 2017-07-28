FROM tomcat:7.0-jre7

# ##########################################################
#
#                      DISCLAIMER
#
# #### usage ######################################################
#
#   --- Building this docker image
#   docker build -t asqatasun/contrast-finder:SNAPSHOT_local_tomcat  .
#
#   --- Launch a container
#   docker run -p 127.0.0.1:8087:8080 --name contrast.finder -d asqatasun/contrast-finder:SNAPSHOT_local_tomcat
#
#   --- Playing with this docker image
#   docker exec -ti contrast.finder  /bin/bash
#   docker logs -f  contrast.finder
#
#
# #### FROM  ######################################################
#   tomcat:7.0-jre7                     https://github.com/docker-library/tomcat/blob/master/7/jre7/Dockerfile
#   |-- openjdk:7-jre                   https://github.com/docker-library/openjdk/blob/master/7-jre/Dockerfile
#       |-- buildpack-deps:jessie-curl  https://github.com/docker-library/buildpack-deps/blob/master/jessie/curl/Dockerfile
#         |-- debian:jessie             https://github.com/tianon/docker-brew-debian/blob/master/jessie/Dockerfile
###################################################################

# environment variables
ENV CONTRAST_FINDER_RELEASE="0.7.1-dev"
ENV TOMCAT_WEBAPP_DIR="/usr/local/tomcat/webapps"

# Prepare Contrast-Finder
RUN mkdir -p /var/log/contrast-finder/ \
    && mkdir -p /etc/contrast-finder/ \
    && touch /var/log/contrast-finder/contrast-finder.log \
    && touch /etc/contrast-finder/contrast-finder.conf \
    && echo "piwik_analytics_key="  >> /etc/contrast-finder/contrast-finder.conf \
    && echo "google_analytics_key=" >> /etc/contrast-finder/contrast-finder.conf

# Add Spring Instrument Tomcat for Tomcat 7 (as this image is based on Tomcat7)
#
# Remark: **not** working for Tomcat 8, see
# http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/instrument/classloading/tomcat/TomcatInstrumentableClassLoader.html
ADD spring3-instrument-tomcat-3.x.jar /usr/local/tomcat/lib

# Add Contrast-Finder .war
ADD contrast-finder_${CONTRAST_FINDER_RELEASE}.i386.tar.gz  /root

# Install Contrast-Finder
RUN  cd      /root/contrast-*/install/                  && \
     mv -v   contrast-*.war contrast-finder.war         && \
     mv -v   contrast-*.war ${TOMCAT_WEBAPP_DIR}        && \
     rm -rf  /root/contrast-*
