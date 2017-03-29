[![License : AGPL v3](https://img.shields.io/badge/License-AGPL3-blue.svg)](https://github.com/Asqatasun/Contrast-Finder/blob/master/LICENSE) [![Release](https://img.shields.io/github/release/asqatasun/Contrast-Finder.svg)](https://github.com/Asqatasun/Contrast-Finder/releases/latest) [![Build Status](https://travis-ci.org/Asqatasun/Contrast-Finder.svg)](https://travis-ci.org/Asqatasun/Contrast-Finder)

# Contrast-Finder
Tool to provide color combination for a good (accessible, WCAG-compliant) contrast.

## Supported tags 
Supported tags and respective `Dockerfile` links :

* [pre-requisites_from-Ubuntu](https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/pre-requisites/pre-requisites_from-Ubuntu/Dockerfile)
* [v0.4.5, latest](https://github.com/Asqatasun/Contrast-Finder/blob/master/docker/RELEASE/Dockerfile)
* [v0.4.4](https://github.com/Asqatasun/Contrast-Finder/blob/v0.4.4/docker/RELEASE/Dockerfile)
* [v0.4.3](https://github.com/Asqatasun/Contrast-Finder/blob/v0.4.3/docker/RELEASE/Dockerfile)
* [v0.4.2](https://github.com/Asqatasun/Contrast-Finder/blob/v0.4.2/docker/RELEASE/Dockerfile)

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

![Screenshot - Contrast-Finder v0.3.5](https://raw.githubusercontent.com/Asqatasun/Contrast-Finder/master/documentation/en/images/screenshot.EN_contrast-finder.v0.3.5_2016-12-19.png)

## Tips and tricks
### Container available only on 127.0.0.1 (Linux users) #### 
`docker run -d  -p 127.0.0.1:8080:8080 (...)` 

### Have your container launched at boot
Add the option **--restart always**
`docker run -d --restart always -p 8080:8080 (...)` 



## User Feedback

If you have any problems with or questions about this image or Contrast-Finder itself, please contact us :
* [Asqatasun forum](http://forum.asqatasun.org/) 
* [Twitter @Asqatasun](https://twitter.com/Asqatasun)

## Contributing

You are invited to contribute new features, fixes, or updates, large or small; we are always thrilled to receive pull requests, and do our best to process them as fast as we can.

Before you start to code, we recommend discussing your plans through a [GitHub issue](https://github.com/Asqatasun/Contrast-Finder/issues), especially for more ambitious contributions. This gives other contributors a chance to point you in the right direction, give you feedback on your design, and help you find out if someone else is working on the same thing.


