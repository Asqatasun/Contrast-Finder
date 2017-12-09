# Build Docker images for Contrast-Finder


## Prerequisites

The following sofware are required :

* JDK **7** (at least)
* Maven **3.1** (at least)
* [Docker **1.12** (at least)](https://docs.docker.com/engine/installation/linux/docker-ce/ubuntu/) 


## Build with our automated script (recommended)

We have created a shell script to ease the tasks of building locally with Docker. Basically, the script:

1. compiles Contrast-Finder,
1. creates a new docker image,
1. runs a container from this image,
1. displays all info to connect to the container

To enjoy it, do:
```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd  Contrast-finder
git checkout develop
docker/build_and_run-with-docker.sh --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local
```

In your browser, go to
`http://127.0.0.1:8087/contrast-finder/`

Example of output:

```
  -------------------------------------------------------
  Tomcat server   is now running ........ HTTP code = 200
  -------------------------------------------------------
  Contrast-Finder is now running ........ HTTP code = 200
  -------------------------------------------------------
  maven FAILURE ... 0 
  maven WARN ...... 12 
  -------------------------------------------------------
  Container ... contrast.finder
  Dockerfile .. docker/SNAPSHOT-local
  Image ....... asqatasun/contrast-finder:2017-09-30
  CMD ......... docker run -p 8087:8080 --name contrast.finder -d asqatasun/contrast-finder:2017-09-30
  -------------------------------------------------------
  Shell ....... docker exec -ti contrast.finder /bin/bash
  Log ......... docker logs -f  contrast.finder
  URL ......... http://localhost:8087/contrast-finder/
  ------------------------------------------------------- 
```

A lot of useful options are also available to speed up the process 
when you want to build / test / iterate.
 
You may run `./docker/build_and_run-with-docker.sh -h` to see them.



## Build manually

Let say we want to compile Contrast-Finder "x.y.z-SNAPSHOT" release and create a Docker image with it.
By "locally", we mean we won't download Contrast-Finder as we will build it.


### 1. Grab source code

```shell
git clone https://github.com/Asqatasun/Contrast-Finder
```

### 2. Compile Contrast-finder

```shell
cd  Contrast-finder
git checkout develop  # Please always work on develop, see CONTRIBUTING.md
mvn clean install
```
Internet connection needed the very first time to download Maven dependencies.
In the meantime, enjoy your coffee break :) 

### 3. Copy Contrast-finder tar.gz to the suitable Docker directory

```shell
cp -v contrast-finder-webapp/target/*.tar.gz docker/SNAPSHOT-local
```

### 4. Build the Docker Image

```shell
cd docker/SNAPSHOT-local 
docker build -t asqatasun/contrast-finder:SNAPSHOT . 
```

Verify the image is actually built

```shell
docker images
```

You should see something like this:

```
REPOSITORY                   TAG                 IMAGE ID            CREATED             SIZE
asqatasun/contrast-finder    SNAPSHOT            84a5bf7bb437        2 minutes ago       338 MB
```


### 5. Remove old containers

In case you had older containers, just wipe them (so backup before if you want to keep your data)

```shell
docker stop contrast.finder 
docker rm   contrast.finder
```


### 6. Run Docker Image

```bash
docker run -p 8087:8080 --name contrast.finder -d asqatasun/contrast-finder:SNAPSHOT
```
In your browser, go to
`http://127.0.0.1:8087/contrast-finder/`


#### Check the logs

```bash
docker logs -f  contrast.finder
```

or 
```shell
docker exec -ti contrast.finder /bin/bash
cat /var/log/tomcat7/catalina.out 
cat /var/log/contrast-finder/contrast-finder.log
```




