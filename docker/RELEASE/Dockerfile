FROM asqatasun/contrast-finder:pre-requisites_from-Ubuntu

# #### usage ######################################################
#
#   --- Building this docker image
#   docker build -t asqatasun/contrast-finder  .
#   docker build -t asqatasun/contrast-finder  --build-arg CONTRAST_FINDER_RELEASE=0.4.2  .
#   docker build -t asqatasun/contrast-finder  --build-arg SRC_URL_PREFIX=https://github.com/Asqatasun/Contrast-Finder/releases/download/v0.4.2/   .
#   docker build -t asqatasun/contrast-finder  --build-arg SRC_URL=https://github.com/Asqatasun/Contrast-Finder/releases/download/v0.4.2/contrast-finder_0.4.2.i386.tar.gz   .
#
#   --- Launch a container
#   docker run -p 127.0.0.1:8087:8080 --name contrast.finder -d asqatasun/contrast-finder
#
#   --- Playing with this docker image
#   docker exec -ti contrast.finder  /bin/bash
#   docker logs -f contrast.finder
#
# #### source code  ###############################################
#   https://github.com/Asqatasun/Contrast-Finder/releases/download/v${CONTRAST_FINDER_RELEASE}/contrast-finder_${CONTRAST_FINDER_RELEASE}.i386.tar.gz
#     could be overridden with  --build-arg CONTRAST_FINDER_RELEASE=<release>
#     could be overridden with  --build-arg SRC_URL_PREFIX=<url_prefix>
#     could be overridden with  --build-arg SRC_URL=<url>
#
# #### FROM  ######################################################
#   asqatasun/contrast-finder:pre-requisites_from-Ubuntu   https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/pre-requisites/pre-requisites_from-Ubuntu/Dockerfile
#   |-- ubuntu:14.04                                       https://github.com/tianon/docker-brew-ubuntu-core/blob/dist/trusty/Dockerfile
###################################################################

# build variables
ARG CONTRAST_FINDER_RELEASE="0.4.2"
ARG SRC_URL_PREFIX="https://github.com/Asqatasun/Contrast-Finder/releases/download/v${CONTRAST_FINDER_RELEASE}"
ARG SRC_URL="${SRC_URL_PREFIX}/contrast-finder_${CONTRAST_FINDER_RELEASE}.i386.tar.gz"

# Install contrast-finder
RUN  cd         /root/                                      && \
     wget       ${SRC_URL}                                  && \
     tar  -xzvf contrast-*.tar.gz                           && \
     cd         /root/contrast-*/install/                   && \
     mv   -v    contrast-*.war    contrast-finder.war       && \
     mv   -v    contrast-*.war    /var/lib/tomcat7/webapps  && \
     rm   -rf   /root/contrast-*  && echo "-- Install: Ok"

# environment variables
ENV CONTRAST_FINDER=${CONTRAST_FINDER_RELEASE}
ENV SRC=${SRC_URL}

CMD  service tomcat7 start                                  ;      \
     tail -f /var/log/tomcat7/catalina.out                         \
             /var/log/contrast-finder/contrast-finder.log



