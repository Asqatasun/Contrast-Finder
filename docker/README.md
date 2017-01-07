# Docker

## Builds and runs a container

- builds Contrast-Finder from sources,
- builds a Docker image
- runs a container based the freshly built image

```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd Contrast-finder
docker/compile_and_build_docker_image.sh -l -s ${PWD} -d docker/SNAPSHOT-local_from-Ubuntu
```


