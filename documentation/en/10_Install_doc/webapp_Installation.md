# Web application installation

You should have already [check pre-requisites](webapp_Pre-requisites.md)


## How to install (Linux)

### Tomcat 8 - Debian 9, Ubuntu 16.04 or Ubuntu 18.04  (next LTS)

You just need to replace `tomcat7` with `tomcat8` in the following command lines.


### Tomcat 7 - Ubuntu 14.04 or Ubuntu 16.04

```bash
cd /tmp
wget https://github.com/Asqatasun/Contrast-Finder/releases/download/v0.8.7-SNAPSHOT/contrast-finder-webapp_0.8.7-SNAPSHOT.tar.gz
tar -xzvf contrast-finder-webapp_*.tar.gz
cd        contrast-finder-webapp_*/
mv  -v    install/contrast-finder-webapp_*.war contrast-finder.war

sudo cp -v     contrast-finder.war               /var/lib/tomcat7/webapps/
sudo cp -rv    install/var/log/contrast-finder/  /var/log/

sudo chown -Rv tomcat7 /var/log/contrast-finder/
sudo service   tomcat7 restart
```

Contrast-finder should be available at `http://localhost:8080/contrast-finder/`


#### Optional contract-finder.conf file

```bash
tar -xzvf contrast-finder-webapp_*.tar.gz
cd        contrast-finder-webapp_*/
sudo cp -rv    install/etc/contrast-finder/      /etc/

cd             /etc/contrast-finder/
sudo cp -v     contrast-finder.conf.dist  contrast-finder.conf
sudo vim       contrast-finder.conf
    (...)
sudo chown -Rv tomcat7 /etc/contrast-finder/
sudo service   tomcat7 restart
```



