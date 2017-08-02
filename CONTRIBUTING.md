# Contributing to Contrast-Finder

:+1: First off, thanks for taking the time to contribute! :+1:

We are really glad to have you on board ! 
You can help in many ways:

1. Use Contrast-Finder !
1. Help translate Contrast-Finder
1. Give us [feedback on the forum](https://forum.asqatasun.org/c/contrast-finder) or [fill in bug report](https://github.com/Asqatasun/Contrast-Finder/issues)

[Pull Requests](https://github.com/Asqatasun/Contrast-Finder/pulls) are always welcome! 


## Fill in bug reports

[Fill in a bug report](https://github.com/Asqatasun/Contrast-Finder/issues)

* Please do not assign issue to anyone.
* You may assign an issue to yourself, meaning to others "I'm actually working on this issue".
* When closing an issue, please *always* add a comment explaining why you are closing it.


## Contribution to the code / Pull Request

Please always work on `develop` branch. 

`Master` is meant to be directly usable in production,
thus only contains tagged releases.

### Builds and runs a Docker container

- builds Contrast-Finder from sources,
- builds a Docker image
- runs a container based the freshly built image

```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd Contrast-finder
git checkout develop
docker/build_and_run-with-docker.sh -l -s ${PWD} -d docker/SNAPSHOT-local_from-Ubuntu
```

## Sources of inspiration for CONTRIBUTING.md

* For contributors doc [Gitlab Workflow](https://about.gitlab.com/handbook/#gitlab-workflow)
* [Atom's Contributing file](https://github.com/atom/atom/blob/master/CONTRIBUTING.md) that is really good and brightly written.