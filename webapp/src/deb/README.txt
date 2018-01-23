
##### Tomcat 7 ##########################

    # install contrast-finder-webapp + dependencies
    dpkg    -i contrast-finder-webapp_*_tomcat7.deb
    apt-get -f install

              # in your browser
              # http://localhost:8080/contrast-finder/


    # uninstall  contrast-finder
    dpkg  --purge  contrast-finder-webapp

            # or
            # uninstall contrast-finder + dependencies
            dpkg  --purge   contrast-finder-webapp
            apt-get remove tomcat7 libspring-instrument-java
            apt-get autoremove


    # See package information
    dpkg -l contrast-finder-webapp tomcat7 libspring-instrument-java

    # Check directories and files
    ls -l /var/lib/tomcat7/webapps
    ls -l /etc/contrast-finder
    ls -l /var/log/contrast-finder/
    ls -l /usr/share/tomcat7/lib/spring3-instrument-tomcat*

##### Tomcat 8 ###########################

    # install contrast-finder-webapp + dependencies
    dpkg    -i contrast-finder-webapp_*_tomcat8.deb
    apt-get -f install

              # in your browser
              # http://localhost:8080/contrast-finder/


    # uninstall  contrast-finder
    dpkg  --purge  contrast-finder-webapp

            # or
            # uninstall contrast-finder + dependencies
            dpkg  --purge   contrast-finder-webapp
            apt-get remove tomcat8 libspring-instrument-java 
            apt-get autoremove


    # See package information
    dpkg -l contrast-finder-webapp tomcat8 libspring-instrument-java 

    # Check directories and files
    ls -l /var/lib/tomcat8/webapps
    ls -l /etc/contrast-finder
    ls -l /var/log/contrast-finder/
    ls -l /usr/share/tomcat8/lib/spring3-instrument-tomcat* 


