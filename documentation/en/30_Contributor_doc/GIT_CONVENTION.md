
# Versioning, Changelog and GIT Commit message

## Versioning

We tend to follow the [semantic versioning](http://semver.org/) recommendations:
 ```shell script
 MAJOR.MINOR.PATCH
    # MAJOR ---> a breaking change (incompatible API changes)
    # MINOR ---> add a new feature
    # PATCH ---> fix a bug
```

## Changelog

We use a changelog file which contains a curated, chronologically
ordered list of notable changes for each version of a project.

see: [Keep a Changelog](https://keepachangelog.com/)


## Git Commit message convention

We follow [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) :

```
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

### Type
- `build`: changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm).
- `ci`: changes to the CI configuration files and scripts
- `chore`: update something without impacting the user (ex: bump a dependency in composer.json).
- `docs`: documentation only changes
- `feat`: add a new feature (equivalent to a `MINOR` in Semantic Versioning)
- `fix`: fix a bug (equivalent to a `PATCH` in Semantic Versioning).
- `perf`: a code change that improves performance.
- `refactor`: a code change that neither fixes a bug nor adds a feature.
- `revert`: revert a commit.
- `style`: Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc).
- `test`: adding missing tests, refactoring tests; no production code change.


### Regex

The commit message should follow this regex:

```perl
/^(revert: )?(build|ci|chore|docs|feat|fix|perf|refactor|style|refactor|revert|style|test|)(\(.+\))?: .{1,50}/
```

### See also

- [Git Commit Msg](http://karma-runner.github.io/1.0/dev/git-commit-msg.html)
- [Semantic Commit Messages](https://seesparkbox.com/foundry/semantic_commit_messages)
- [Enhance your git log with conventional commits](https://dev.to/maxpou/enhance-your-git-log-with-conventional-commits-3ea4)
- [Working with Git : conventional commits, branch model naming](https://slides.com/damianopetrungaro/working-with-git#/)
- [fr / Comment écrire un bon message de commit ?](https://www.dotnetdojo.com/git-commit/)
- examples:
    - [Angular commit guidelines](https://github.com/angular/angular/blob/master/CONTRIBUTING.md#-commit-message-guidelines)
    - [Vue.js commit guidelines](https://github.com/vuejs/vue/blob/dev/.github/COMMIT_CONVENTION.md)




