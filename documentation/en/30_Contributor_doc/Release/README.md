# Release a version of Contrast-Finder

This is the documentation for releasing a new version for Contrast-Finder.
As an end user, you won't need it, it is just for developers.

## The process

### check dependencies, compile and test it
```bash
    # check dependencies (security)
    mvn dependency-check:aggregate  

    # compile and test it
    docker/compile_and_build_docker_image.sh -l -s ${PWD} -d docker/SNAPSHOT-local_from-Ubuntu

```

outdated dependencies:
https://www.versioneye.com/user/projects/58fb3e17c2ef423822580804?child=summary#tab-dependencies
 
### Prepare a Release
```bash
# change version ("x.y.z-dev" to "x.y.z")
# + commit
    # */pom.xml
    # */Dockerfile
    # CHANGELOG
    # Docker/REALESE/README
    # (...)/template_variables.jspf
git checkout develop
(...)
git add .
git commit -m  "set version to x.y.z"  

# Merge and commit
git checkout master
git merge --no-ff --log develop 
```
 
Plugin to do some of the work
http://maven.apache.org/maven-release/maven-release-plugin/index.html
 
### Test it
```bash
# compile and test it
docker/compile_and_build_docker_image.sh -l -s ${PWD} -d docker/SNAPSHOT-local_from-Ubuntu
```
 
### Release
```bash
# add tag
# push tag
# push master

# upload tar.gz (github)
# docker hub : manage new build
# check docker build
docker pull asqatasun/contrast-finder 
docker run -d -p 8080:8080 asqatasun/contrast-finder

# docker hub : manage new build for asqatasun/asqa.mvn:contrast.finder_jdk*
```
 

## Versioning

We tend to follow the [semantic versioning](http://semver.org/) recommendations.

## Changelog template

```
Contrast-Finder M.m.p, 2017-xx-xx
---------------------------------

Upgrade-o-meter: just replace the .war file and restart Tomcat

### New Feature
none

### Security
none

### Bug
none

### Improvement 
none

### Refactoring
none

### Configuration 
none

### Documentation
none

### Task
none

```