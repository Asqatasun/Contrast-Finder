# Web application installation

You should have already [check pre-requisites](webapp_Pre-requisites.md)


## How to install (Linux)

- Ubuntu 18.04 (Tomcat 8.5, Jdk11)
- Ubuntu 20.04 (Tomcat 9, Jdk11)
- Debian 10 (Tomcat 9, Jdk11)

### Ubuntu 18.04 (Tomcat 8.5, Jdk11)

```bash
cd /tmp
wget https://github.com/Asqatasun/Contrast-Finder/releases/download/v1.0.0/contrast-finder-webapp_v1.0.0.tar.gz
tar -xzvf contrast-finder-webapp_*.tar.gz
cd        contrast-finder-webapp_*/
sudo cp -rv    install/var/log/contrast-finder/  /var/log/
sudo chown -Rv tomcat8:tomcat8 /var/log/contrast-finder/

mv  -v    install/contrast-finder-webapp_*.war contrast-finder.war
sudo cp -v     contrast-finder.war               /var/lib/tomcat8/webapps

sudo service   tomcat8 restart
    # sudo systemctl restart tomcat8 
```

Contrast-finder should be available at `http://localhost:8080/contrast-finder/`


#### Optional contract-finder.conf file

```bash
tar -xzvf contrast-finder-webapp_*.tar.gz
cd        contrast-finder-webapp_*/
sudo cp -rv    install/etc/contrast-finder/      /etc/
sudo chown -Rv tomcat8:tomcat8 /etc/contrast-finder/

cd             /etc/contrast-finder/
sudo cp -v     contrast-finder.conf.dist  contrast-finder.conf
sudo vim       contrast-finder.conf
    (...)

sudo service   tomcat8 restart
    # sudo systemctl restart tomcat8 
```


### Ubuntu 20.04 | Debian 10 (Tomcat 9, Jdk11)

```bash
cd /tmp
wget https://github.com/Asqatasun/Contrast-Finder/releases/download/v1.0.0/contrast-finder-webapp_v1.0.0.tar.gz
tar -xzvf contrast-finder-webapp_*.tar.gz
cd        contrast-finder-webapp_*/

sudo cp -rv    install/var/log/contrast-finder/  /var/log/
sudo chown -Rv tomcat:tomcat /var/log/contrast-finder/

mv  -v      install/contrast-finder-webapp_*.war contrast-finder.war
sudo cp -v  contrast-finder.war  /var/lib/tomcat9/webapps

sudo systemctl restart tomcat9 
```

Contrast-finder should be available at `http://localhost:8080/contrast-finder/`


#### Optional contract-finder.conf file

```bash
tar -xzvf contrast-finder-webapp_*.tar.gz
cd        contrast-finder-webapp_*/
sudo cp -rv    install/etc/contrast-finder/      /etc/
sudo chown -Rv tomcat:tomcat /etc/contrast-finder/

cd             /etc/contrast-finder/
sudo cp -v     contrast-finder.conf.dist  contrast-finder.conf
sudo vim       contrast-finder.conf
    (...)

sudo systemctl restart tomcat9 
```





