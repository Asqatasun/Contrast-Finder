# Howto build & install

Tested on Linux Ubuntu 12.04 LTS

## Prerequesites

* Tomcat
* Maven
* Git

## Howto actually build

```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd Contrast-finder
mvn clean install
```

## How to install

Once you've built, let say you have Tomcat 6 (change the number if you have Tomcat 7 or 8):

```bash
sudo cp color-finder-webapp/target/contrast-finder-webapp-1.0-SNAPSHOT.war /var/lib/tomcat6/webapps/
sudo mkdir /var/log/contrast-finder/
sudo chown -R tomcat6 contrast-finder/
sudo invoke-rc.d tomcat6 restart
```

Contrast-finder should be available at [http://localhost:8080/contrast-finder-webapp-1.0-SNAPSHOT/](http://localhost:8080/contrast-finder-webapp-1.0-SNAPSHOT/)
