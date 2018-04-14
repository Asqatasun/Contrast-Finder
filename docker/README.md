# Docker

## Build with our automated script (recommended)

We have created a shell script to ease the tasks of building locally with Docker. Basically, the script:

1. compiles Contrast-Finder,
1. creates a new docker image,
1. runs a container from this image,

To enjoy it, do:
```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd  Contrast-finder
git checkout develop
docker/build_and_run-with-docker.sh -l --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local
```
In your browser, go to
`http://127.0.0.1:8087/contrast-finder/`

A lot of useful options are also available to speed up the process
when you want to build / test / iterate.

You may run `./docker/build_and_run-with-docker.sh -h` to see them.

