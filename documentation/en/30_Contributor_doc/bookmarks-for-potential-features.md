# Bookmarks for potential features


## Tomcat 8

For  Tomcat 7, Contrast-Finder need "Spring Instrument Tomcat":
```
apt-get --no-install-recommends install  libspring-instrument-java      
ln -s   /usr/share/java/spring3-instrument-tomcat.jar          \
        /usr/share/tomcat7/lib/spring3-instrument-tomcat.jar    
```

but it's **not** working for Tomcat 8

- https://forum.asqatasun.org/t/lib-spring-instrument-java-tomcat8/258/2
- https://docs.spring.io/spring/docs/4.3.13.RELEASE/spring-framework-reference/htmlsingle/#aop-aj-ltw-environment-tomcat

```
Historically, Tomcat's default class loader did not support class transformation 
which is why Spring provides an enhanced implementation that addresses this need. 
Named TomcatInstrumentableClassLoader, the loader works on Tomcat 6.0 and above.

Do not define TomcatInstrumentableClassLoader anymore on Tomcat 8.0 and higher. 
Instead, let Spring automatically use Tomcat’s new native InstrumentableClassLoader 
facility through the TomcatLoadTimeWeaver strategy.
```

For Tomcat 8, don't install libspring-instrument-java  
and remove the following line from the [webapp/src/main/webapp/META-INF/context.xml](https://github.com/Asqatasun/Contrast-Finder/blob/develop/webapp/src/main/webapp/META-INF/context.xml#L3) file 
and it's works:
>     <Loader loaderClass="org.springframework.instrument.classloading.tomcat.TomcatInstrumentableClassLoader" useSystemClassLoaderAsParent="false"/>


## Ansible 

- https://github.com/ansible/ansible-examples/tree/master/tomcat-standalone
- https://github.com/elacheche/ansible-war-deploy
- http://aseigneurin.github.io/2014/11/04/ansible-pour-deployer-des-applications.html
     - https://github.com/aseigneurin/ansible-sandbox