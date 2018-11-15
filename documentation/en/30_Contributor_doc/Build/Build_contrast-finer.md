# Building Contrast-Finder

## Prerequesites

* JDK-8 (at least) is required
* Maven 3.3.9 (at least) is required
* Git

## Builds Contrast-Finder and runs with Tomcat

* [Check pre-requisites](../../10_Install_doc/webapp_Pre-requisites.md)
* [Install](../../10_Install_doc/webapp_Installation.md)

Replace only this following command line:
```bash
wget https://github.com/Asqatasun/Contrast-Finder/releases/download/(...).tar.gz
```

by these following command lines:
```bash
git  clone https://github.com/Asqatasun/Contrast-Finder
cd   Contrast-finder
git  checkout develop
mvn  clean install
cp   contrast-finder-webapp/target/contrast-finder-webapp_*-SNAPSHOT.tar.gz /tmp
cd   /tmp
```
