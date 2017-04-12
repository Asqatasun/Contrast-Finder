# Prerequisites for Contrast-Finder web application installation

## Prerequesites

* Tomcat
* libspring-instrument-java 

### Linux Ubuntu 14.04 and 16.04 

```bash
apt-get --no-install-recommends install  tomcat7   
apt-get --no-install-recommends install  libspring-instrument-java      
ln -s   /usr/share/java/spring3-instrument-tomcat.jar          \
        /usr/share/tomcat7/lib/spring3-instrument-tomcat.jar    
```

