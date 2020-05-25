# Ubuntu packages

Debian and Ubuntu packages are automatically created by Maven in the `dist./debian_package/target` directory.
- Ubuntu 18.04 (Tomcat 8.5, Jdk11)
- Ubuntu 20.04 (Tomcat 9, Jdk11)
- Debian 10 (Tomcat 9, Jdk11)

```bash
git  clone https://github.com/Asqatasun/Contrast-Finder
cd   Contrast-finder
git  checkout develop
mvn  clean install
cd   dist./debian_package/target
```

## Pre-requisites
You should have already [check pre-requisites](webapp_Pre-requisites.md)


## Ubuntu 18.04 (Tomcat 8.5, Jdk11)

### Install Contrast-Finder webapp  + dependencies
```bash
sudo dpkg    -i contrast-finder-webapp_*_ubuntu.18.04.deb
sudo apt-get -f install
```
Contrast-finder should be available at `http://localhost:8080/contrast-finder/`

### Uninstall Contrast-Finder webapp
```bash
sudo dpkg --purge contrast-finder_webapp-for-ubuntu.18.04
```

#### Uninstall Contrast-Finder webapp  + dependencies
```bash
sudo dpkg --purge contrast-finder_webapp-for-ubuntu.18.04
sudo apt-get remove tomcat8
sudo apt-get autoremove
```

### See package information
```bash
dpkg -l tomcat8 contrast-finder_webapp-for-ubuntu.18.04
```

### Check directories and files
```bash
ls -l /var/lib/tomcat8/webapps
ls -l /etc/contrast-finder
ls -l /var/log/contrast-finder/
```

## Ubuntu 20.04 (Tomcat 9, Jdk11)

### Install Contrast-Finder webapp  + dependencies
```bash
sudo dpkg    -i contrast-finder-webapp_*_ubuntu.20.04.deb
sudo apt-get -f install
```
Contrast-finder should be available at `http://localhost:8080/contrast-finder/`

### Uninstall Contrast-Finder webapp
```bash
sudo dpkg --purge contrast-finder_webapp-for-ubuntu.20.04
```

#### Uninstall Contrast-Finder webapp  + dependencies
```bash
sudo dpkg --purge contrast-finder_webapp-for-ubuntu.20.04
sudo apt-get remove tomcat9
sudo apt-get autoremove
```

### See package information
```bash
dpkg -l tomcat9 contrast-finder_webapp-for-ubuntu.20.04
```

### Check directories and files
```bash
ls -l /var/lib/tomcat9/webapps
ls -l /etc/contrast-finder
ls -l /var/log/contrast-finder/
```


## Debian 10 (Tomcat 9, Jdk11)

### Install Contrast-Finder webapp  + dependencies
```bash
sudo dpkg    -i contrast-finder-webapp_*_debian.10.deb
sudo apt-get -f install
```
Contrast-finder should be available at `http://localhost:8080/contrast-finder/`

### Uninstall Contrast-Finder webapp
```bash
sudo dpkg --purge contrast-finder_webapp-for-debian.10
```

#### Uninstall Contrast-Finder webapp  + dependencies
```bash
sudo dpkg --purge contrast-finder_webapp-for-debian.10
sudo apt-get remove tomcat9
sudo apt-get autoremove
```

### See package information
```bash
dpkg -l tomcat9 contrast-finder_webapp-for-debian.10
```

### Check directories and files
```bash
ls -l /var/lib/tomcat9/webapps
ls -l /etc/contrast-finder
ls -l /var/log/contrast-finder/
```

