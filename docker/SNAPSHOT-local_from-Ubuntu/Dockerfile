FROM asqatasun/contrast-finder:pre-requisites_from-Ubuntu

# #### usage ######################################################
#
#   --- Building this docker image
#   docker build -t asqatasun/contrast-finder:SNAPSHOT_local  .
#
#   --- Launch a container
#   docker run -p 127.0.0.1:8087:8080 --name contrast.finder -d asqatasun/contrast-finder:SNAPSHOT_local
#
#   --- Playing with this docker image
#   docker exec -ti contrast.finder  /bin/bash
#   docker logs -f contrast.finder
#
#
# #### FROM  ######################################################
#   asqatasun/contrast-finder:pre-requisites_from-Ubuntu   https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/pre-requisites/pre-requisites_from-Ubuntu/Dockerfile
#   |-- ubuntu:14.04                                       https://github.com/tianon/docker-brew-ubuntu-core/blob/dist/trusty/Dockerfile
###################################################################

# environment variables
ENV CONTRAST_FINDER_RELEASE="0.4.6-dev"

# Add contrast-finder .war
ADD contrast-finder_${CONTRAST_FINDER_RELEASE}.i386.tar.gz  /root

# Install contrast-finder
RUN  cd      /root/contrast-*/install/                      && \
     mv -v   contrast-*.war contrast-finder.war             && \
     mv -v   contrast-*.war /var/lib/tomcat7/webapps        && \
     touch   /var/log/contrast-finder/contrast-finder.log   && \
     rm -rf  /root/contrast-*  && echo "-- Install: Ok"

CMD  service tomcat7 start                                  ;      \
     tail -f /var/log/tomcat7/catalina.out                         \
             /var/log/contrast-finder/contrast-finder.log



