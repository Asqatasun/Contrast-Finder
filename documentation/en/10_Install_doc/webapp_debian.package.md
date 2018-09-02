# Debian packages

Debian packages are automatically created by Maven in the `dist./debian_package/target` directory.

```bash
git  clone https://github.com/Asqatasun/Contrast-Finder
cd   Contrast-finder
git  checkout develop
mvn  clean install
cd   dist./debian_package/target
```


## Pre-requisites
You should have already [check pre-requisites](webapp_Pre-requisites.md)

## Tomcat 7

### Install Contrast-Finder webapp  + dependencies
```bash
dpkg    -i contrast-finder-webapp_*_tomcat7.deb
apt-get -f install
```
Contrast-finder should be available at `http://localhost:8080/contrast-finder/`

### Uninstall Contrast-Finder webapp
```bash
dpkg --purge contrast-finder_webapp-for-tomcat7
```

#### Uninstall Contrast-Finder webapp  + dependencies
```bash
dpkg --purge contrast-finder_webapp-for-tomcat7
apt-get remove tomcat7
apt-get autoremove
```

### See package information
```bash
dpkg -l contrast-finder_webapp-for-tomcat7 tomcat7
```

### Check directories and files
```bash
ls -l /var/lib/tomcat7/webapps
ls -l /etc/contrast-finder
ls -l /var/log/contrast-finder/
```


## Tomcat 8

### Install Contrast-Finder webapp  + dependencies
```bash
dpkg    -i contrast-finder-webapp_*_tomcat8.deb
apt-get -f install
```
Contrast-finder should be available at `http://localhost:8080/contrast-finder/`

### Uninstall Contrast-Finder webapp
```bash
dpkg --purge contrast-finder_webapp-for-tomcat8
```

#### Uninstall Contrast-Finder webapp  + dependencies
```bash
dpkg --purge contrast-finder_webapp-for-tomcat8
apt-get remove tomcat8
apt-get autoremove
```

### See package information
```bash
dpkg -l tomcat8 contrast-finder_webapp-for-tomcat8
```

### Check directories and files
```bash
ls -l /var/lib/tomcat8/webapps
ls -l /etc/contrast-finder
ls -l /var/log/contrast-finder/
```

