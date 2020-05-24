# Web application installation

You should have already [check pre-requisites](webapp_Pre-requisites.md)


## How to install (Linux)

### Tomcat 8 - Ubuntu 18.04

```bash
cd /tmp
wget https://github.com/Asqatasun/Contrast-Finder/releases/download/v1.0.0/contrast-finder-webapp_v1.0.0.tar.gz
tar -xzvf contrast-finder-webapp_*.tar.gz
cd        contrast-finder-webapp_*/
mv  -v    install/contrast-finder-webapp_*.war contrast-finder.war

sudo cp -v     contrast-finder.war               /var/lib/tomcat8/webapps
sudo cp -rv    install/var/log/contrast-finder/  /var/log/

sudo chown -Rv tomcat8:tomcat8 /var/log/contrast-finder/
sudo service   tomcat8 restart
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
sudo chown -Rv tomcat8:tomcat8 /etc/contrast-finder/
sudo service   tomcat8 restart
```



