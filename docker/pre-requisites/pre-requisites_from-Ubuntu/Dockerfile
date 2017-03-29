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
ENV     CONF_FILE="/etc/contrast-finder/contrast-finder.conf"  \
        WWWPORT="8080"
EXPOSE  $WWWPORT

# build
RUN  apt-get update                                         && \
     apt-get -y --no-install-recommends                             \
             install wget                                           \
                     ca-certificates                                \
                     tomcat7                                        \
                     libspring-instrument-java              && \
     apt-get clean                                          && \
     apt-get autoremove                                     && \
     rm      -rf /var/lib/apt/lists/*                       && \
     mkdir   -p  /var/log/contrast-finder/                  && \
     mkdir   -p  /etc/contrast-finder/                      && \
     touch   /var/log/contrast-finder/contrast-finder.log   && \
     touch   ${CONF_FILE}                                   && \
     chown   -R tomcat7:tomcat7 /var/log/contrast-finder/   && \
     chown   -R tomcat7:tomcat7 /etc/contrast-finder/       && \
     echo    "piwik_analytics_key="  >> ${CONF_FILE}        && \
     echo    "google_analytics_key=" >> ${CONF_FILE}        && \
     ln -s   /usr/share/java/spring3-instrument-tomcat.jar          \
             /usr/share/tomcat7/lib/spring3-instrument-tomcat.jar




CMD  service tomcat7 start                      ;  \
     tail -f /var/log/tomcat7/catalina.out
