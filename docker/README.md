# Docker



##  Linux users

### Builds Contrast-Finder and runs a new Docker container

- builds Contrast-Finder from sources with maven,
- builds a new Docker image
- runs a container based the freshly built image

###  Linux users
```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd Contrast-finder
git checkout develop
docker/compile_and_build_docker_image.sh -l -s ${PWD} -d docker/SNAPSHOT-local_from-Ubuntu
```

In your browser, go to
`http://127.0.0.1:8087/contrast-finder/`

