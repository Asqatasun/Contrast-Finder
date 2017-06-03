
Contrast-Finder 0.4.8, 2017-06-xx
---------------------------------

Features:
none

Security:
none

Bugs:
- [#53 - White space allowed around the color in the form](https://github.com/Asqatasun/Contrast-Finder/issues/53)

Configuration: 
- [#52 - contrast-finder.conf: added option for debugging](https://github.com/Asqatasun/Contrast-Finder/issues/52)

Documentation:
none

Upgrade-o-meter:
just replace the .war file and restart Tomcat


Contrast-Finder 0.4.7, 2017-06-01
---------------------------------

Features:
- [#51 - Added a cookie to keep the user's choice on the algorithm to use](https://github.com/Asqatasun/Contrast-Finder/issues/51)

Security:
- [#44 - Upgrade outdated dependencies: SpringFramework, maven-surefire, maven-war, maven-dependency](https://github.com/Asqatasun/Contrast-Finder/issues/44)

Bugs:
- [#45 - Fixed docker/pre-requisites: syntax error](https://github.com/Asqatasun/Contrast-Finder/issues/45)
- [#46 - Fixed maven warnings: 'version' contains an expression but should be a constant](https://github.com/Asqatasun/Contrast-Finder/issues/46)

Configuration: 
- [#50 - contrast-finder.conf: added option to override the default algorithm](https://github.com/Asqatasun/Contrast-Finder/issues/50) 
- [#47 - Added prerequisites for maven (version 3.1)](https://github.com/Asqatasun/Contrast-Finder/issues/47) 
- [#49 - Dockerfile: added HEALTHCHECK instruction](https://github.com/Asqatasun/Contrast-Finder/issues/49) 

Documentation:
- [#42 - Fixed Javadoc warnings](https://github.com/Asqatasun/Contrast-Finder/issues/42) 
- [#12 - Added documentation for releasing a new version](https://github.com/Asqatasun/Contrast-Finder/issues/12) 

Upgrade-o-meter: just replace the .war file and restart Tomcat


Contrast-Finder 0.4.6, 2017-04-12
---------------------------------

Features:
none

Security:
- [#35 - Added HTTP security headers without HTTP no-cache headers](https://github.com/Asqatasun/Contrast-Finder/issues/35)
- [#36 - Added the maven plugin "OWASP Dependency-Check"](https://github.com/Asqatasun/Contrast-Finder/issues/36)
- [#38 - Upgraded maven-compiler-plugin and maven-surefire-plugin](https://github.com/Asqatasun/Contrast-Finder/issues/38) 
- [#41 - Upgraded the outdated dependencies](https://github.com/Asqatasun/Contrast-Finder/issues/41) 

Bugs:
- [#43 - contrast-finder.conf is not required](https://github.com/Asqatasun/Contrast-Finder/issues/43) 

Configuration:
- [#37 - Added maven-javadoc-plugin](https://github.com/Asqatasun/Contrast-Finder/issues/37)
- [#39 - Changed source and target of the Java compiler: 1.7 instead of 1.6](https://github.com/Asqatasun/Contrast-Finder/issues/39)

Documentation:
- [#8 - Howto build & install: missing libspring-instrument-java](https://github.com/Asqatasun/Contrast-Finder/issues/8)

Upgrade-o-meter:
just replace the .war file and restart Tomcat


Contrast-Finder 0.4.5, 2017-03-30
---------------------------------

Features:
none

Security:
- [#33 - Upgraded SpringFramework to v4.3.7](https://github.com/Asqatasun/Contrast-Finder/issues/33)
- revert [#23 - Added HTTP security headers](https://github.com/Asqatasun/Contrast-Finder/issues/23)

Bugs:
- [#34 - Fixed HTML errors](https://github.com/Asqatasun/Contrast-Finder/issues/34)
- [#29 - Fixed lang-switcher: error on the lang attribute](https://github.com/Asqatasun/Contrast-Finder/issues/29)
- [#30 - Fixed punctuation errors in english](https://github.com/Asqatasun/Contrast-Finder/issues/30)
- [#31 - Fixed front-end webperf regression (repeat view)](https://github.com/Asqatasun/Contrast-Finder/issues/31)
  - revert [#23 - Added HTTP security headers](https://github.com/Asqatasun/Contrast-Finder/issues/23)

Configuration:
- [#32 - Changed LOG dependency: logback + slf4j instead of log4j](https://github.com/Asqatasun/Contrast-Finder/issues/32)
- .jsp - Added appVersion
      
Documentation:
none

Upgrade-o-meter:
just replace the .war file and restart Tomcat


Contrast-Finder 0.4.4, 2017-02-12
---------------------------------

Features:
- [#20 - Added cookieMaxAge (2 months) for lang cookie](https://github.com/Asqatasun/Contrast-Finder/issues/20)
- [#26 - compile_and_build_docker_image.sh : added --build-only-* options](https://github.com/Asqatasun/Contrast-Finder/issues/26)
- [#27 - compile_and_build_docker_image.sh : added option to skip unit tests](https://github.com/Asqatasun/Contrast-Finder/issues/27)

Security:
- [#22 - Upgraded SpringFramework to v4.3.6](https://github.com/Asqatasun/Contrast-Finder/issues/22)
- [#23 - Added HTTP security headers](https://github.com/Asqatasun/Contrast-Finder/issues/23)

Bugs:
- [#19 - Paths to image files should be relative](https://github.com/Asqatasun/Contrast-Finder/issues/19)
- [#21 - Added space between sampleText and sampleTextBold](https://github.com/Asqatasun/Contrast-Finder/issues/21)
- [#28 - Fixed color contrast falling for links :hover + :focus](https://github.com/Asqatasun/Contrast-Finder/issues/28)

Configuration:
none

Documentation:
- explained ratio

Upgrade-o-meter:
just replace the .war file and restart Tomcat


Contrast-Finder 0.4.3, 2017-01-25
---------------------------------

Features:
- [#18 - Webperf - Aggregate JS and CSS files](https://github.com/Asqatasun/Contrast-Finder/issues/18)

Security:
- [#9 Webapp - Don't expose session ID in the URL](https://github.com/Asqatasun/Contrast-Finder/issues/9)

Bugs:
- [#17 - Revert "Webapp - Used input tag type=color instead off type=text"](https://github.com/Asqatasun/Contrast-Finder/issues/17)


Configuration:
none

Documentation:
- added docker/RELEASE/README.md for Docker Hub

Upgrade-o-meter:
just replace the .war file and restart Tomcat


Contrast-Finder 0.4.2, 2017-01-15
---------------------------------

Features:
none

Security:
- [#13 - Upgraded Apache.HttpComponents HttpClient to v4.3.6](https://github.com/Asqatasun/Contrast-Finder/issues/13)
- [#14 - Upgraded SpringFrameworkt to v3.2.12 and remove spring-asm](https://github.com/Asqatasun/Contrast-Finder/issues/14)
- [#15 - Removed commons-httpclient dependency](https://github.com/Asqatasun/Contrast-Finder/issues/15)
- [#16 - Changed JSTL artifact : jstl --> taglibs-standard-jstlel](https://github.com/Asqatasun/Contrast-Finder/issues/16)

Bugs:
- [#10 Webapp - Color contrast falling for links](https://github.com/Asqatasun/Contrast-Finder/issues/10)
- [#11 Webapp - Color contrast failing for "the color should be between (…)"](https://github.com/Asqatasun/Contrast-Finder/issues/11)

Configuration:
none

Documentation:
none

Upgrade-o-meter:
just replace the .war file and restart Tomcat


Contrast-Finder 0.4.1, 2017-01-12
---------------------------------

Features:
- [#2 Webapp - Used input tag type=color instead off type=text](https://github.com/Asqatasun/Contrast-Finder/issues/2)
- Added descriptor.xml (building tar.gz with maven)
- Added SNAPSHOT-local_from-Tomcat/Dockerfile

Security:
- [#9 Webapp - Don't expose session ID in the URL](https://github.com/Asqatasun/Contrast-Finder/issues/9)

Bugs:
none

Configuration:
none

Documentation:
none

Upgrade-o-meter:
just replace the .war file and restart Tomcat


Contrast-Finder 0.4.0, 2016-12-30
---------------------------------

Features:
- Added compile_and_build_docker_image.sh
- Added pre-requisites_from-Ubuntu/Dockerfile
- Added SNAPSHOT-local_from-Ubuntu/Dockerfile
- Added RELEASE/Dockerfile

Security:
- [#1 Upgrade Apache Commons Collections to v3.2.2](https://github.com/Asqatasun/Contrast-Finder/issues/1)

Bugs:
none

Configuration:
none

Documentation:
none


Contrast-Finder 0.3.5, 2016-12-18
---------------------------------

- [#7 Paths to CSS files should be relative](https://github.com/Asqatasun/Contrast-Finder/issues/7)
- Added locally JQuery & JQuery-UI 
- Updated install doc 


Fork from Tanaguru/Contrast-Finder
----------------------------------

- Contrast-Finder 0.3.4, 2014-06-11
- Contrast-Finder 0.3.3, 2014-05-22
- Contrast-Finder 0.3.2, 2014-04-28
- Contrast-Finder 0.3.1, 2014-03-27
- Contrast-Finder 0.3.0, 2013-12-20
- Contrast-Finder 0.2.0, 2013-12-12

