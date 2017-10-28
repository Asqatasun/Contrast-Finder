# Web application installation

You should have already [check pre-requisites](webapp_Pre-requisites.md)


## How to install

### Linux Ubuntu 14.04 and 16.04 

Once you've built, let say you have Tomcat 7 (change the number if you have Tomcat 8 or more):

```bash
cd /tmp
wget https://github.com/Asqatasun/Contrast-Finder/releases/download/v0.4.5/contrast-finder_0.4.5.i386.tar.gz
tar -xzvf contrast-finder*.tar.gz  
cd        contrast-finder_*.i386/
mv  -v    install/contrast-*.war contrast-finder.war

sudo cp -v     contrast-finder.war               /var/lib/tomcat7/webapps/
sudo cp -rv    install/var/log/contrast-finder/  /var/log/

sudo chown -Rv tomcat7 /var/log/contrast-finder/ 
sudo service   tomcat7 restart
```

Contrast-finder should be available at `http://localhost:8080/contrast-finder/`


#### Optional contract-finder.conf file 

```bash
tar -xzvf      contrast-finder*.tar.gz  
cd             contrast-finder_*.i386/
sudo cp -rv    install/etc/contrast-finder/      /etc/

cd             /etc/contrast-finder/
sudo cp -v     contrast-finder.conf.dist  contrast-finder.conf
sudo vim       contrast-finder.conf 
    (...)
sudo chown -Rv tomcat7 /etc/contrast-finder/
sudo service   tomcat7 restart
```