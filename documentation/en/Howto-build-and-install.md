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

Once you've built, let say you have Tomcat 7 (change the number if you have Tomcat 8 or more):

```bash
sudo cp contrast-finder-webapp/target/contrast-finder-webapp-1.0-SNAPSHOT.war /var/lib/tomcat7/webapps/
sudo mkdir -p \
        /var/log/contrast-finder/ \
        /etc/contrast-finder/
sudo touch /var/log/contrast-finder/contrast-finder.log
sudo touch /etc/contrast-finder/contrast-finder.conf
sudo echo "piwik_analytics_key=\"\"" >/etc/contrast-finder/contrast-finder.conf
sudo echo "google_analytics_key=\"\"" >/etc/contrast-finder/contrast-finder.conf
sudo chown -R tomcat7 \
        /var/log/contrast-finder/ \
        /etc/contrast-finder/
sudo invoke-rc.d tomcat7 restart
```

Contrast-finder should be available at `http://localhost:8080/contrast-finder-webapp-1.0-SNAPSHOT/`
