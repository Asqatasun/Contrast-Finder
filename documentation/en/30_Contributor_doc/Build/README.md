# Building Contrast-Finder

## Prerequesites

* JDK-7 (at least) is required
* Maven 3.1 (at least) is required
* Git

## Builds Contrast-Finder and runs with Tomcat

* [Check pre-requisites](../../10_Install_doc/webapp_Pre-requisites.md)
* [Install](../../10_Install_doc/webapp_Installation.md)

Replace only this following command line:
```bash
wget https://github.com/Asqatasun/Contrast-Finder/releases/download/(...).i386.tar.gz
```

by these following command lines:
```bash
git  clone https://github.com/Asqatasun/Contrast-Finder
cd   Contrast-finder
git  checkout develop
mvn  clean install
cp   contrast-finder-webapp/target/contrast-finder_*-dev.i386.tar.gz /tmp
cd   /tmp
```

## Builds Contrast-Finder and runs a new Docker container

- builds Contrast-Finder from sources with maven,
- builds a new Docker image
- runs a container based the freshly built image

###  quick method
```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd  Contrast-finder
git checkout develop
docker/build_and_run-with-docker.sh -l -s ${PWD} -d docker/SNAPSHOT-local_from-Ubuntu
```

In your browser, go to
`http://127.0.0.1:8087/contrast-finder/`

###  classic method

```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd  Contrast-finder
git checkout develop
mvn clean install
cp -v contrast-finder-webapp/target/*.tar.gz docker/SNAPSHOT-local_from-Ubuntu
cd docker/SNAPSHOT-local_from-Ubuntu 
docker build -t asqatasun/contrast-finder:SNAPSHOT . 
docker stop contrast.finder 
docker rm   contrast.finder
docker run -p 8087:8080 --name contrast.finder -d asqatasun/contrast-finder:SNAPSHOT
```
In your browser, go to
`http://127.0.0.1:8087/contrast-finder/`