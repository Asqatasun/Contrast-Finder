# CHANGELOG

Contrast-Finder 0.8.5, 2018-02-xx
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### New Feature
none

### Security
none

### Outdated dependencies
- [#130 - Updated .jsp file, form tag: use "modelAttribute" instead of deprecated "commandName"](https://github.com/Asqatasun/Contrast-Finder/issues/130)
- [#138 - Upgraded markdown-page-generator-plugin (2.1.0 instead of 2.0.1)](https://github.com/Asqatasun/Contrast-Finder/issues/138)
- [#135 - Upgraded owasp:dependency-check (3.1.1 instead of 3.0.2)](https://github.com/Asqatasun/Contrast-Finder/issues/135)
- [#137 - Upgraded spring-security (4.2.4 instead of 4.2.3)](https://github.com/Asqatasun/Contrast-Finder/issues/137)
- [#139 - Upgraded javaee-web-api (8.0 instead of 7.0)](https://github.com/Asqatasun/Contrast-Finder/issues/139)

### Bug
- [#128 - Webapp: added "charset=UTF-8" HTTP header for css, js, txt, json and xml files](https://github.com/Asqatasun/Contrast-Finder/issues/128)
- [#129 - Webapp: added custom HTTP error pages instead of Tomcat default pages](https://github.com/Asqatasun/Contrast-Finder/issues/129)

### Improvement
- [#132 - Added new Docker image: pre-requisites_Alpine_tomcat-9](https://github.com/Asqatasun/Contrast-Finder/issues/132)
- [#134 - Added new Docker image: pre-requisites_Debian_tomcat-9_jre9](https://github.com/Asqatasun/Contrast-Finder/issues/134)
- [#127 - Webapp: added contribute.json file](https://github.com/Asqatasun/Contrast-Finder/issues/127)
- [#133 - Webapp: allowed the HTTP header "Cache-Control: immutable" for asset files (css, js, png)](https://github.com/Asqatasun/Contrast-Finder/issues/133)

### Refactoring
none

### Configuration
- [#131 - Changed default docker image: ubuntu-16.04_tomcat-7 instead of ubuntu-14.04_tomcat-7](https://github.com/Asqatasun/Contrast-Finder/issues/131)

### Documentation
none

### Task
none


Contrast-Finder 0.8.4, 2018-01-24
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### Outdated dependencies
- [#108 - Upgraded SpringFramework (4.3.14 instead of 4.3.13)](https://github.com/Asqatasun/Contrast-Finder/issues/108)
- [#113 - Upgraded markdown-page-generator-plugin (2.0.1 instead of 2.0.0)](https://github.com/Asqatasun/Contrast-Finder/issues/113)
- [#119 - Upgraded maven-javadoc-plugin  (3.0.0 instead of 3.0.0-M1)](https://github.com/Asqatasun/Contrast-Finder/issues/119)
- [#120 - Upgraded jacoco-maven-plugin (0.8.0 instead of 0.7.9)](https://github.com/Asqatasun/Contrast-Finder/issues/120)
- [#121 - Upgraded maven-checkstyle-plugin (3.0.0 instead of 2.17)](https://github.com/Asqatasun/Contrast-Finder/issues/121)
- [#123 - Upgraded native2ascii-maven-plugin (2.0.0 instead of 1.0-beta-1)](https://github.com/Asqatasun/Contrast-Finder/issues/123)
- [#118 - Upgraded jdeb maven plugin (1.6 instead of 1.5)](https://github.com/Asqatasun/Contrast-Finder/issues/118)
   - [#125 - Contrast-Finder build need openjdk 8 (prerequisite jdeb)](https://github.com/Asqatasun/Contrast-Finder/issues/125)

### Improvement
- [#110 - Added new docker image: ubuntu 16.04 (tomcat-7)](https://github.com/Asqatasun/Contrast-Finder/issues/110) 
- [#112 - Added new docker image: alpine (tomcat-7)](https://github.com/Asqatasun/Contrast-Finder/issues/112)
- [#116 - Added new docker image: alpine (tomcat-8.5)](https://github.com/Asqatasun/Contrast-Finder/issues/116)
- [#117 - Added some new pre-requisites_* Docker images (debian 9, ubuntu 18.04)](https://github.com/Asqatasun/Contrast-Finder/issues/117)
- [#109 - Docker/pre-requisites/ - Added /softwares-version.txt](https://github.com/Asqatasun/Contrast-Finder/issues/109)
- [#124 - Create 2 Debian packages (.deb) at the maven build for tomcat7 and tomcat8](https://github.com/Asqatasun/Contrast-Finder/issues/124)

### Refactoring
- [#114 - Updated webapp/pom.xml - new name for .war, .tar.gz and .deb](https://github.com/Asqatasun/Contrast-Finder/issues/114)
- [#115 - Updated prerequisites : libspring-instrument-java is not needed](https://github.com/Asqatasun/Contrast-Finder/issues/115)

### Documentation
- [#114 - Updated documentation - new name for .war, .tar.gz and .deb](https://github.com/Asqatasun/Contrast-Finder/issues/114)
- [#115 - Updated prerequisites documentation](https://github.com/Asqatasun/Contrast-Finder/issues/115)

### Task
- [#106 - Added unit tests coverage report (cobertura-maven-plugin)](https://github.com/Asqatasun/Contrast-Finder/issues/106)
- /!\ see #125 - [#111 -.travis.yml - Added openjdk8 in addition to openjdk7](https://github.com/Asqatasun/Contrast-Finder/issues/111)


Contrast-Finder 0.8.3, 2017-11-28
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### Outdated dependencies
- [#100 - Upgraded SpringFramework (4.3.13 instead of 4.3.12)](https://github.com/Asqatasun/Contrast-Finder/issues/100) 
- [#101 - Upgraded commons-lang3 (3.7 instead of 3.6)](https://github.com/Asqatasun/Contrast-Finder/issues/101) 
- [#102 - Upgraded markdown-page-generator-plugin (2.0.0 instead of 1.0.0)](https://github.com/Asqatasun/Contrast-Finder/issues/102) 
- [#103 - Upgraded maven-javadoc-plugin (3.0.0-M1 instead of 2.10.4)](https://github.com/Asqatasun/Contrast-Finder/issues/103) 
- [#105 - Upgraded org.owasp:dependency-check (3.0.2 instead of 1.4.5)](https://github.com/Asqatasun/Contrast-Finder/issues/105) 

### Task
- [#104 - Added maven-jxr-plugin (needed for maven-checkstyle-plugin)](https://github.com/Asqatasun/Contrast-Finder/issues/104) 
- [#106 - Added unit tests coverage report (jacoco-maven-plugin)](https://github.com/Asqatasun/Contrast-Finder/issues/106) 
- [#107 - Added missing unit tests for engine/utils/*](https://github.com/Asqatasun/Contrast-Finder/issues/107) 


Contrast-Finder 0.8.2, 2017-10-28
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### Outdated dependencies
- [#93 - Upgraded maven-*-plugin (compiler, dependency, surefire and war)](https://github.com/Asqatasun/Contrast-Finder/issues/93) 
- [#94 - Upgraded SpringFramework (4.3.12 instead of 4.3.10)](https://github.com/Asqatasun/Contrast-Finder/issues/94) 

### Bugs
- fixed `build_and_run-with-docker.sh` script:
     - [#97, log_processing() fails when there is no WARNING](https://github.com/Asqatasun/Contrast-Finder/issues/97) 
     - [#95, "-t" option is used 2 times](https://github.com/Asqatasun/Contrast-Finder/issues/95) 

### Documentation
- refactor build documentation

### Task
- [fixed #99 / pom.xml file: replaced "-dev" by "-SNAPSHOT"](https://github.com/Asqatasun/Contrast-Finder/issues/99)  


Contrast-Finder 0.8.1, 2017-08-05
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### Improvement 
- [#90 - Added `<link rel="alternate" hreflang="">`](https://github.com/Asqatasun/Contrast-Finder/issues/90)
- [#88 - Added missing Korean translations](https://github.com/Asqatasun/Contrast-Finder/issues/88)


Contrast-Finder 0.8.0, 2017-08-03
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### New Feature
- [#85 - Added Korean translation](https://github.com/Asqatasun/Contrast-Finder/issues/85)

### Bug
- [#83 - i18n: fixed spelling error](https://github.com/Asqatasun/Contrast-Finder/issues/#83)

### Improvement 
- [#87 - build_and_run-with-docker.sh - Added new option (--log-build)](https://github.com/Asqatasun/Contrast-Finder/issues/#87)

### Documentation
- [#62 - Fixed of differences between documentation in English and French](https://github.com/Asqatasun/Contrast-Finder/issues/62)



Contrast-Finder 0.7.0, 2017-07-28
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### New Feature
- [#24 - Added color picker](https://github.com/Asqatasun/Contrast-Finder/issues/24)

### Documentation
- [#62 - Fixed of differences between documentation in English and French](https://github.com/Asqatasun/Contrast-Finder/issues/62)

### Task
- [#82 - Create a Debian package (.deb) at the maven build](https://github.com/Asqatasun/Contrast-Finder/issues/82)


Contrast-Finder 0.6.0, 2017-07-21
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### New Feature
- [#80 - i18n: added portuguese](https://github.com/Asqatasun/Contrast-Finder/issues/80)

### Outdated dependencies
- [#59 - Upgraded SpringFramework to v4.3.10](https://github.com/Asqatasun/Contrast-Finder/issues/59)

### Refactoring
- [#76 - i18n files in UTF8 character encoding](https://github.com/Asqatasun/Contrast-Finder/issues/76) 

### Task
- [#79 - Pom.xml: added maven-checkstyle-plugin](https://github.com/Asqatasun/Contrast-Finder/issues/79) 


Contrast-Finder 0.5.2, 2017-07-04
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### Security
- [#70 - Upgraded commons-lang3: 3.6 instead of 3.5](https://github.com/Asqatasun/Contrast-Finder/issues/70) 

### Bug
- [#74 - Javascript: allowed only valid RGB values](https://github.com/Asqatasun/Contrast-Finder/issues/74) 

### Improvement 
- [#72 - UI, used the CSS "user-select:all" property for color result](https://github.com/Asqatasun/Contrast-Finder/issues/72) 
- [#67 - UI, replaced radio button by drop-down list for algo](https://github.com/Asqatasun/Contrast-Finder/issues/67) 
- [#73 - UI, improved color sample when user use the color field](https://github.com/Asqatasun/Contrast-Finder/issues/73) 

### Refactoring
- [#75 - Remove unused dependencies: httpclient + json](https://github.com/Asqatasun/Contrast-Finder/issues/75)  

### Task
- [#68 - tar.gz - Changelog and readme files in html format](https://github.com/Asqatasun/Contrast-Finder/issues/68) 
- [#69 - tar.gz - Documentation files in html format](https://github.com/Asqatasun/Contrast-Finder/issues/69) 


Contrast-Finder 0.5.1, 2017-06-14
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### Security
- [#65 - Upgraded spring-security to v4.2.3](https://github.com/Asqatasun/Contrast-Finder/issues/65) 

### Bug
- [#61 - Added missing color names (*Grey + RebeccaPurple)](https://github.com/Asqatasun/Contrast-Finder/issues/61)
- [#63 - Allowed "rgb(255,255,255" value for "rgb(255,255,255)" in the form](https://github.com/Asqatasun/Contrast-Finder/issues/63)
- Fixed some codacy "error prone" + "code style" 

### Refactoring
- [#66 - Modified project directories](https://github.com/Asqatasun/Contrast-Finder/issues/66)  
- [#64 - Moved contrast-finder.log|.conf files into webapp directory](https://github.com/Asqatasun/Contrast-Finder/issues/64) 


Contrast-Finder 0.5.0, 2017-06-09
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### New Feature
- [#25 - Allowed RGB values in the form](https://github.com/Asqatasun/Contrast-Finder/issues/25)
- [#57 - Allowed color names (CSS3) in the form](https://github.com/Asqatasun/Contrast-Finder/issues/57)

### Security
- [#54 - Upgraded SpringFramework to v4.3.9](https://github.com/Asqatasun/Contrast-Finder/issues/54)

### Bug
- [#53 - White spaces allowed around the color in the form](https://github.com/Asqatasun/Contrast-Finder/issues/53)
- [#55 - Added "back to the homepage" link](https://github.com/Asqatasun/Contrast-Finder/issues/55)
- [#58 - Associated the user tips with the color fields](https://github.com/Asqatasun/Contrast-Finder/issues/58)
- [#60 - Added the "required" attribute to the color fields](https://github.com/Asqatasun/Contrast-Finder/issues/60)

### Configuration 
- [#52 - contrast-finder.conf: added option for debugging](https://github.com/Asqatasun/Contrast-Finder/issues/52)


Contrast-Finder 0.4.7, 2017-06-01
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### New Feature
- [#51 - Added a cookie to keep the user's choice on the algorithm to use](https://github.com/Asqatasun/Contrast-Finder/issues/51)

### Security
- [#44 - Upgrade outdated dependencies: SpringFramework, maven-surefire, maven-war, maven-dependency](https://github.com/Asqatasun/Contrast-Finder/issues/44)

### Bug
- [#45 - Fixed docker/pre-requisites: syntax error](https://github.com/Asqatasun/Contrast-Finder/issues/45)
- [#46 - Fixed maven warnings: 'version' contains an expression but should be a constant](https://github.com/Asqatasun/Contrast-Finder/issues/46)

### Configuration 
- [#50 - contrast-finder.conf: added option to override the default algorithm](https://github.com/Asqatasun/Contrast-Finder/issues/50) 
- [#47 - Added prerequisites for maven (version 3.1)](https://github.com/Asqatasun/Contrast-Finder/issues/47) 
- [#49 - Dockerfile: added HEALTHCHECK instruction](https://github.com/Asqatasun/Contrast-Finder/issues/49) 

### Documentation
- [#42 - Fixed Javadoc warnings](https://github.com/Asqatasun/Contrast-Finder/issues/42) 
- [#12 - Added documentation for releasing a new version](https://github.com/Asqatasun/Contrast-Finder/issues/12) 


Contrast-Finder 0.4.6, 2017-04-12
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### Security
- [#35 - Added HTTP security headers without HTTP no-cache headers](https://github.com/Asqatasun/Contrast-Finder/issues/35)
- [#36 - Added the maven plugin "OWASP Dependency-Check"](https://github.com/Asqatasun/Contrast-Finder/issues/36)
- [#38 - Upgraded maven-compiler-plugin and maven-surefire-plugin](https://github.com/Asqatasun/Contrast-Finder/issues/38) 
- [#41 - Upgraded the outdated dependencies](https://github.com/Asqatasun/Contrast-Finder/issues/41) 

### Bug
- [#43 - contrast-finder.conf is not required](https://github.com/Asqatasun/Contrast-Finder/issues/43) 

### Configuration
- [#37 - Added maven-javadoc-plugin](https://github.com/Asqatasun/Contrast-Finder/issues/37)
- [#39 - Changed source and target of the Java compiler: 1.7 instead of 1.6](https://github.com/Asqatasun/Contrast-Finder/issues/39)

### Documentation
- [#8 - Howto build & install: missing libspring-instrument-java](https://github.com/Asqatasun/Contrast-Finder/issues/8)



Contrast-Finder 0.4.5, 2017-03-30
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### Security
- [#33 - Upgraded SpringFramework to v4.3.7](https://github.com/Asqatasun/Contrast-Finder/issues/33)
- revert [#23 - Added HTTP security headers](https://github.com/Asqatasun/Contrast-Finder/issues/23)

### Bug
- [#34 - Fixed HTML errors](https://github.com/Asqatasun/Contrast-Finder/issues/34)
- [#29 - Fixed lang-switcher: error on the lang attribute](https://github.com/Asqatasun/Contrast-Finder/issues/29)
- [#30 - Fixed punctuation errors in english](https://github.com/Asqatasun/Contrast-Finder/issues/30)
- [#31 - Fixed front-end webperf regression (repeat view)](https://github.com/Asqatasun/Contrast-Finder/issues/31)
    - revert [#23 - Added HTTP security headers](https://github.com/Asqatasun/Contrast-Finder/issues/23)

### Configuration
- [#32 - Changed LOG dependency: logback + slf4j instead of log4j](https://github.com/Asqatasun/Contrast-Finder/issues/32)
- .jsp - Added appVersion


Contrast-Finder 0.4.4, 2017-02-12
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### New Feature
- [#20 - Added cookieMaxAge (2 months) for lang cookie](https://github.com/Asqatasun/Contrast-Finder/issues/20)
- [#26 - build_and_run-with-docker.sh : added --build-only-* options](https://github.com/Asqatasun/Contrast-Finder/issues/26)
- [#27 - build_and_run-with-docker.sh : added option to skip unit tests](https://github.com/Asqatasun/Contrast-Finder/issues/27)

### Security
- [#22 - Upgraded SpringFramework to v4.3.6](https://github.com/Asqatasun/Contrast-Finder/issues/22)
- [#23 - Added HTTP security headers](https://github.com/Asqatasun/Contrast-Finder/issues/23)

### Bug
- [#19 - Paths to image files should be relative](https://github.com/Asqatasun/Contrast-Finder/issues/19)
- [#21 - Added space between sampleText and sampleTextBold](https://github.com/Asqatasun/Contrast-Finder/issues/21)
- [#28 - Fixed color contrast falling for links :hover + :focus](https://github.com/Asqatasun/Contrast-Finder/issues/28)

### Documentation
- explained ratio


Contrast-Finder 0.4.3, 2017-01-25
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### New Feature
- [#18 - Webperf - Aggregate JS and CSS files](https://github.com/Asqatasun/Contrast-Finder/issues/18)

### Security
- [#9 Webapp - Don't expose session ID in the URL](https://github.com/Asqatasun/Contrast-Finder/issues/9)

### Bug
- [#17 - Revert "Webapp - Used input tag type=color instead off type=text"](https://github.com/Asqatasun/Contrast-Finder/issues/17)

### Documentation
- added docker/RELEASE/README.md for Docker Hub


Contrast-Finder 0.4.2, 2017-01-15
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### Security
- [#13 - Upgraded Apache.HttpComponents HttpClient to v4.3.6](https://github.com/Asqatasun/Contrast-Finder/issues/13)
- [#14 - Upgraded SpringFrameworkt to v3.2.12 and remove spring-asm](https://github.com/Asqatasun/Contrast-Finder/issues/14)
- [#15 - Removed commons-httpclient dependency](https://github.com/Asqatasun/Contrast-Finder/issues/15)
- [#16 - Changed JSTL artifact : jstl --> taglibs-standard-jstlel](https://github.com/Asqatasun/Contrast-Finder/issues/16)

### Bug
- [#10 Webapp - Color contrast falling for links](https://github.com/Asqatasun/Contrast-Finder/issues/10)
- [#11 Webapp - Color contrast failing for "the color should be between (…)"](https://github.com/Asqatasun/Contrast-Finder/issues/11)


Contrast-Finder 0.4.1, 2017-01-12
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### New Feature
- [#2 Webapp - Used input tag type=color instead off type=text](https://github.com/Asqatasun/Contrast-Finder/issues/2)
- Added descriptor.xml (building tar.gz with maven)
- Added SNAPSHOT-local_from-Tomcat/Dockerfile

### Security
- [#9 Webapp - Don't expose session ID in the URL](https://github.com/Asqatasun/Contrast-Finder/issues/9)



Contrast-Finder 0.4.0, 2016-12-30
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### New Feature
- Added build_and_run-with-docker.sh
- Added pre-requisites_from-Ubuntu/Dockerfile
- Added SNAPSHOT-local_from-Ubuntu/Dockerfile
- Added RELEASE/Dockerfile

### Security
- [#1 Upgrade Apache Commons Collections to v3.2.2](https://github.com/Asqatasun/Contrast-Finder/issues/1)



Contrast-Finder 0.3.5, 2016-12-18
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### Bug
- [#7 Paths to CSS files should be relative](https://github.com/Asqatasun/Contrast-Finder/issues/7)
- Added locally JQuery & JQuery-UI 

### Documentation
- Updated install doc 


Fork from Tanaguru/Contrast-Finder
----------------------------------

- Contrast-Finder 0.3.4, 2014-06-11
- Contrast-Finder 0.3.3, 2014-05-22
- Contrast-Finder 0.3.2, 2014-04-28
- Contrast-Finder 0.3.1, 2014-03-27
- Contrast-Finder 0.3.0, 2013-12-20
- Contrast-Finder 0.2.0, 2013-12-12

