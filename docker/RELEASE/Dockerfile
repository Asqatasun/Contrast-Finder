FROM asqatasun/contrast-finder:pre-requisites_from-Ubuntu
LABEL org.label-schema.schema-version = "1.0.0-rc.1"                                            \
      org.label-schema.name           = "Contrast-Finder - WebApp"                              \
      org.label-schema.version        = "0.6.0"                                             \
      org.label-schema.url            = "https://contrast-finder.org"                           \
      org.label-schema.vcs-url        = "https://github.com/Asqatasun/Contrast-Finder"          \
      org.label-schema.docker.cmd     = "docker run -p 8087:8080 -d asqatasun/contrast-finder"  \
      org.label-schema.usage          = "https://github.com/Asqatasun/Contrast-Finder/tree/develop/documentation/" \
      org.label-schema.description    = "Contrast-Finder finds correct color contrasts for web accessibility."
          # ----> documentation  http://label-schema.org/

# #### usage ######################################################
#
#   --- Building this docker image
#   docker build -t asqatasun/contrast-finder  .
#   docker build -t asqatasun/contrast-finder  --build-arg CONTRAST_FINDER_RELEASE=0.6.0  .
#   docker build -t asqatasun/contrast-finder  --build-arg SRC_URL_PREFIX=https://github.com/Asqatasun/Contrast-Finder/releases/download/v0.6.0/   .
#   docker build -t asqatasun/contrast-finder  --build-arg SRC_URL=https://github.com/Asqatasun/Contrast-Finder/releases/download/v0.6.0/contrast-finder_0.6.0.i386.tar.gz   .
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
ARG CONTRAST_FINDER_RELEASE="0.6.0"
ARG SRC_URL_PREFIX="https://github.com/Asqatasun/Contrast-Finder/releases/download/v${CONTRAST_FINDER_RELEASE}"
ARG SRC_URL="${SRC_URL_PREFIX}/contrast-finder_${CONTRAST_FINDER_RELEASE}.i386.tar.gz"

# Install contrast-finder
RUN  cd         /root/                                        && \
     wget       ${SRC_URL}                                    && \
     tar  -xzvf contrast-*.tar.gz                             && \
     cd         /root/contrast-*/install/                     && \
     mv   -v    contrast-*.war    contrast-finder.war         && \
     mv   -v    contrast-*.war    /var/lib/tomcat7/webapps    && \
     touch      /var/log/contrast-finder/contrast-finder.log  && \
     rm   -rf   /root/contrast-*  && echo "-- Install: Ok"

# environment variables
ENV CONTRAST_FINDER=${CONTRAST_FINDER_RELEASE}
ENV SRC=${SRC_URL}

# Health Check of the Docker Container
# ----> see asqatasun/contrast-finder:pre-requisites_from-Ubuntu

CMD  service tomcat7 start                                  ;      \
     tail -f /var/log/tomcat7/catalina.out                         \
             /var/log/contrast-finder/contrast-finder.log



