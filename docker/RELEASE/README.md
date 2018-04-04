[![License : AGPL v3](https://img.shields.io/badge/License-AGPL3-blue.svg)](https://github.com/Asqatasun/Contrast-Finder/blob/master/LICENSE) [![Release](https://img.shields.io/github/release/asqatasun/Contrast-Finder.svg)](https://github.com/Asqatasun/Contrast-Finder/releases/latest) [![Build Status](https://travis-ci.org/Asqatasun/Contrast-Finder.svg)](https://travis-ci.org/Asqatasun/Contrast-Finder) [![Code of Conduct](https://img.shields.io/badge/code%20of-conduct-ff69b4.svg?style=flat-square)](https://github.com/Asqatasun/Contrast-Finder/blob/develop/CODE_OF_CONDUCT.md) [![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](https://github.com/Asqatasun/Contrast-Finder/blob/develop/CONTRIBUTING.md)

# Contrast-Finder
Tool to provide color combination for a good (accessible, WCAG-compliant) contrast.

## Supported tags
Supported tags and respective `Dockerfile` links :

### Pre-requisites
* [pre-requisites_Ubuntu-14.04_tomcat-7](https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/pre-requisites/pre-requisites_Ubuntu-14.04_tomcat-7/Dockerfile)
* [pre-requisites_Ubuntu-16.04_tomcat-7](https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/pre-requisites/pre-requisites_Ubuntu-16.04_tomcat-7/Dockerfile)
* [pre-requisites_Alpine_tomcat-7](https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/pre-requisites/pre-requisites_Alpine_tomcat-7/Dockerfile)
* [pre-requisites_Alpine_tomcat-8.5](https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/pre-requisites/pre-requisites_Alpine_tomcat-8.5/Dockerfile)

### Releases
* [latest, v0.8.6-SNAPSHOT, ubuntu-16.04](https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/RELEASE/ubuntu-16.04_tomcat-7/Dockerfile)
* [alpine, v0.8.6-SNAPSHOT_alpine, alpine_tomcat-8.5](https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/RELEASE/alpine_tomcat-8.5/Dockerfile)
* [v0.8.5](https://github.com/Asqatasun/Contrast-Finder/blob/v0.8.5/docker/RELEASE/Dockerfile), [v0.8.4](https://github.com/Asqatasun/Contrast-Finder/blob/v0.8.4/docker/RELEASE/Dockerfile), [v0.8.3](https://github.com/Asqatasun/Contrast-Finder/blob/v0.8.3/docker/RELEASE/Dockerfile), [v0.8.2](https://github.com/Asqatasun/Contrast-Finder/blob/v0.8.2/docker/RELEASE/Dockerfile), [v0.8.1](https://github.com/Asqatasun/Contrast-Finder/blob/v0.8.1/docker/RELEASE/Dockerfile), [v0.8.0](https://github.com/Asqatasun/Contrast-Finder/blob/v0.8.0/docker/RELEASE/Dockerfile)
* [v0.7.0](https://github.com/Asqatasun/Contrast-Finder/blob/v0.7.0/docker/RELEASE/Dockerfile), [v0.6.0](https://github.com/Asqatasun/Contrast-Finder/blob/v0.6.0/docker/RELEASE/Dockerfile), [v0.5.2](https://github.com/Asqatasun/Contrast-Finder/blob/v0.5.2/docker/RELEASE/Dockerfile)

## How to use this image
`docker pull asqatasun/contrast-finder`
`docker run -d -p 8080:8080 asqatasun/contrast-finder`

### Linux users
In your browser, go to `http://localhost:8080/contrast-finder/`

### MacOSX and Windows users
* Get the IP address with command `docker-machine ip default`
* In your browser, go to `http://<the_IP_address>:8080/contrast-finder/`

## What is Contrast-Finder?
* More information on the website [Contrast-Finder.org](https://contrast-finder.org)
* Demo : https://app.contrast-finder.org

![Screenshot - Contrast-Finder v0.5.2](https://raw.githubusercontent.com/Asqatasun/Contrast-Finder/develop/documentation/en/images/screenshot/screenshot.EN_contrast-finder.v0.5.2_2017-07-27_grey_kraken.io-lossy.png)

## Tips and tricks
### Container available only on 127.0.0.1 (Linux users) ####
`docker run -d  -p 127.0.0.1:8080:8080 (...)`

### Have your container launched at boot
Add the option **--restart always**
`docker run -d --restart always -p 8080:8080 (...)`



## User Feedback

If you have any problems with or questions about this image or Contrast-Finder itself, please contact us :
* [Asqatasun forum](https://forum.asqatasun.org/c/contrast-finder)
* [Twitter @Asqatasun](https://twitter.com/Asqatasun)

## Contributing

You are invited to contribute new features, fixes, or updates, large or small; we are always thrilled to receive pull requests, and do our best to process them as fast as we can.

Before you start to code, we recommend discussing your plans through a [GitHub issue](https://github.com/Asqatasun/Contrast-Finder/issues), especially for more ambitious contributions. This gives other contributors a chance to point you in the right direction, give you feedback on your design, and help you find out if someone else is working on the same thing.


