# Release a version of Contrast-Finder

This is the documentation for releasing a new version for Contrast-Finder.
As an end user, you won't need it, it is just for developers.

## The process

### check dependencies, compile and test it
```bash
    # check dependencies (security)
    mvn dependency-check:aggregate

    # compile and test it
    docker/build_and_run-with-docker.sh -l -s ${PWD} -d docker/SNAPSHOT-local

```

outdated dependencies:
https://www.versioneye.com/user/projects/58fb3e17c2ef423822580804?child=summary#tab-dependencies

Some dependencies must not be updated with the latest release (SpringFramework 5.xx, ...)
because these dependencies need Jdk 8 and do not work on our tomcat 7 for the official demo.

### Prepare a Release
```bash
# 1. change version ("x.y.z-SNAPSHOT" to "x.y.z")
    # */pom.xml
    # */Dockerfile
    # CHANGELOG
    # Docker/REALESE/README
    # (...)/template_variables.jspf
git checkout develop

# for pom.xml files
mvn versions:set -DnewVersion=x.y.z
mvn versions:commit  # remove pom.xml.versionsBackup files

# for these following files
    # */Dockerfile
    # CHANGELOG
    # Docker/REALESE/README
    # (...)/template_variables.jspf
(...)

# 2. commit
git add .
git commit -m  "set version to x.y.z"

# 3. Merge and commit
git checkout master
git merge --no-ff --log develop
```

versions-maven-plugin (`mvn versions:set -DnewVersion=x.y.z`) :

- http://www.mojohaus.org/versions-maven-plugin/examples/set.html
- http://www.mojohaus.org/versions-maven-plugin/examples/setaggregator.html

Another plugin to do some of the work (not tested):

- http://maven.apache.org/maven-release/maven-release-plugin/index.html

### Test it
```bash
# compile and test it
docker/build_and_run-with-docker.sh -l -s ${PWD} -d docker/SNAPSHOT-local
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

### Prepare develop branch for the next release
```bash
# 1. change version ("x.y.z" to "x.y.z+1-SNAPSHOT")
    # */pom.xml
    # */Dockerfile
    # CHANGELOG
    # Docker/REALESE/README
    # (...)/template_variables.jspf
git checkout develop

# for pom.xml files
mvn versions:set -DnewVersion=x.y.z+1
mvn versions:commit  # remove pom.xml.versionsBackup files

# for these following files
    # */Dockerfile
    # CHANGELOG
    # Docker/REALESE/README
    # (...)/template_variables.jspf
(...)

# 2. commit
git add .
git commit -m  "set version to x.y.z+1-SNAPSHOT"
```

## Versioning

We tend to follow the [semantic versioning](http://semver.org/) recommendations.

