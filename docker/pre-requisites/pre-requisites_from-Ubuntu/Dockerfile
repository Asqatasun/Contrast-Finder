FROM ubuntu:14.04

# #### usage ######################################################
#
#   --- Building this docker image
#   docker build -t contrast-finder:pre-requisites_from-Ubuntu .
#
# #### FROM  ######################################################
#   ubuntu:14.04  https://github.com/tianon/docker-brew-ubuntu-core/blob/dist/trusty/Dockerfile
###################################################################

# environment variables
ENV    WWWPORT="8080"
EXPOSE $WWWPORT

# build
RUN  apt-get update                               && \
     apt-get -y --no-install-recommends                             \
             install wget                                           \
                     ca-certificates                                \
                     tomcat7                                        \
                     libspring-instrument-java    && \
     apt-get clean                                && \
     apt-get autoremove                           && \
     rm -rf  /var/lib/apt/lists/*                 && \
     ln -s   /usr/share/java/spring3-instrument-tomcat.jar          \
             /usr/share/tomcat7/lib/spring3-instrument-tomcat.jar


CMD  service tomcat7 start                      ;  \
     tail -f /var/log/tomcat7/catalina.out
