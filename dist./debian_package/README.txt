
##### Tomcat 7 ##########################

    # install Contrast-Finder webapp  + dependencies
    dpkg    -i contrast-finder-webapp_*_tomcat7.deb
    apt-get -f install

              # in your browser
              # http://localhost:8080/contrast-finder/


    # uninstall Contrast-Finder webapp
    dpkg --purge contrast-finder_webapp-for-tomcat7

            # or
            # uninstall Contrast-Finder webapp  + dependencies
            dpkg --purge contrast-finder_webapp-for-tomcat7
            apt-get remove tomcat7 libspring-instrument-java
            apt-get autoremove


    # See package information
    dpkg -l contrast-finder_webapp-for-tomcat7 tomcat7 libspring-instrument-java

    # Check directories and files
    ls -l /var/lib/tomcat7/webapps
    ls -l /etc/contrast-finder
    ls -l /var/log/contrast-finder/
    ls -l /usr/share/tomcat7/lib/spring3-instrument-tomcat*

##### Tomcat 8 ###########################

    # install Contrast-Finder webapp  + dependencies
    dpkg    -i contrast-finder-webapp_*_tomcat8.deb
    apt-get -f install

              # in your browser
              # http://localhost:8080/contrast-finder/


    # uninstall Contrast-Finder webapp
    dpkg --purge contrast-finder_webapp-for-tomcat8

            # or
            # uninstall Contrast-Finder webapp  + dependencies
            dpkg --purge contrast-finder_webapp-for-tomcat8
            apt-get remove tomcat7
            apt-get autoremove


    # See package information
    dpkg -l tomcat8 contrast-finder_webapp-for-tomcat8


    # Check directories and files
    ls -l /var/lib/tomcat8/webapps
    ls -l /etc/contrast-finder
    ls -l /var/log/contrast-finder/
    ls -l /usr/share/tomcat8/lib/spring3-instrument-tomcat*


