FROM tomcat:8.0-jre7
MAINTAINER Fabrice Gangler <fabrice@asqatasun.org>

# ##########################################################
#
#                      DISCLAIMER
#
# #### usage ######################################################
# 
#
# #### FROM  ######################################################
#   tomcat:8.0-jre7                     https://github.com/docker-library/tomcat/blob/master/8.0/jre7/Dockerfile
#   |-- openjdk:7-jre                   https://github.com/docker-library/openjdk/blob/master/7-jre/Dockerfile
#       |-- buildpack-deps:jessie-curl  https://github.com/docker-library/buildpack-deps/blob/master/jessie/curl/Dockerfile
#         |-- debian:jessie             https://github.com/tianon/docker-brew-debian/blob/master/jessie/Dockerfile
###################################################################

# build variables
ARG GIT_BRANCH=master

# Add .war
# ADD contrast-finder-webapp-0.3.6-dev.war /var/lib/tomcat8/webapps/
# ADD contrast-finder-webapp-0.3.6-dev.war /usr/local/tomcat/webapps

ADD contrast-finder-webapp-0.3.6-dev.war /root


# build
RUN cd /root && mv -v contrast-*.war contrast-finder.war 
RUN mv -v /root/contrast-finder.war  /usr/local/tomcat/webapps
RUN mkdir -p /var/log/contrast-finder/ 
RUN mkdir -p /etc/contrast-finder/
RUN touch /var/log/contrast-finder/contrast-finder.log
RUN touch /etc/contrast-finder/contrast-finder.conf
RUN echo "piwik_analytics_key=\"\""  >> /etc/contrast-finder/contrast-finder.conf
RUN echo "google_analytics_key=\"\"" >> /etc/contrast-finder/contrast-finder.conf
# RUN chown -R tomcat /var/log/contrast-finder/
# RUN chown -R tomcat /etc/contrast-finder/






