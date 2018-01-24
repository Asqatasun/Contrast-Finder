

----- with libspring-instrument-java ---------------------------------------

    commit 527be04da1385e05940051de27e2c356d9cedc5d

OK   /distrib/debian-8_tomcat-7_legacy-debian
OK   /test_tomcat-7-8/Ubuntu_14.04_tomcat7_full
OK   /test_tomcat-7-8/Ubuntu_16.04_tomcat7_full
OK   /test_tomcat-7-8/Ubuntu_16.04_tomcat8_full
FAIL /test_tomcat-7-8/Ubuntu_18.04_tomcat8_full

---------------------------------------------------------------------

UBUNTU 18.04 Tomcat 8.5   
-----------------------------
docker/build_and_run-with-docker.sh -l --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local/test_tomcat-7-8/Ubuntu_18.04_tomcat8_full/ --log-build
docker exec -ti contrast.finder /bin/cat /softwares-version.txt
docker logs --since 24h contrast.finder &> log_UBUNTU-18.04_tomcat-8_withSpringInstrumentClassLoader.log
docker exec -ti contrast.finder /bin/bash
    ls -l /usr/share/java/spring3-instrument.jar
    ls -l /usr/share/tomcat8/lib/spring3-instrument-tomcat.jar
    cat /var/lib/tomcat8/webapps/contrast-finder/META-INF/context.xml
    cat /var/lib/tomcat8/webapps/contrast-finder/META-INF/MANIFEST.MF

    ----------------------------------------------------------------------------------
    18.04 vs 16.04  for  libspring-instrument-java
            https://packages.ubuntu.com/bionic/all/libspring-instrument-java/filelist
        vs  https://packages.ubuntu.com/xenial/all/libspring-instrument-java/filelist
    ----------------------------------------------------------------------------------

UBUNTU 16.04 Tomcat 8.0  
-----------------------------
docker/build_and_run-with-docker.sh -l --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local/test_tomcat-7-8/Ubuntu_16.04_tomcat8_full/ --log-build
docker exec -ti contrast.finder /bin/cat /softwares-version.txt
docker logs --since 24h contrast.finder &> log_UBUNTU-16.04_tomcat-8_withSpringInstrumentClassLoader.log
docker exec -ti contrast.finder /bin/bash
    ls -l /usr/share/java/spring3-instrument-tomcat.jar
    ls -l /usr/share/tomcat8/lib/spring3-instrument-tomcat.jar
    cat /var/lib/tomcat8/webapps/contrast-finder/META-INF/context.xml
    cat /var/lib/tomcat8/webapps/contrast-finder/META-INF/MANIFEST.MF

UBUNTU 16.04 Tomcat 7   
-----------------------------
docker/build_and_run-with-docker.sh -l --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local/test_tomcat-7-8/Ubuntu_16.04_tomcat7_full/ --log-build
docker exec -ti contrast.finder /bin/cat /softwares-version.txt
docker logs --since 24h contrast.finder &> log_UBUNTU-16.04_tomcat-7_withSpringInstrumentClassLoader.log
docker exec -ti contrast.finder /bin/bash
    ls -l /usr/share/java/spring3-instrument-tomcat.jar
    ls -l /usr/share/tomcat7/lib/spring3-instrument-tomcat.jar
    cat /var/lib/tomcat7/webapps/contrast-finder/META-INF/context.xml
    cat /var/lib/tomcat7/webapps/contrast-finder/META-INF/MANIFEST.MF

UBUNTU 14.04 Tomcat 7   
-----------------------------
docker/build_and_run-with-docker.sh -l --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local/test_tomcat-7-8/Ubuntu_14.04_tomcat7_full --log-build
docker exec -ti contrast.finder /bin/cat /softwares-version.txt
docker logs --since 24h contrast.finder &> log_UBUNTU-14.04_withSpringInstrumentClassLoader.log
docker exec -ti contrast.finder /bin/bash
    ls -l /usr/share/java/spring3-instrument-tomcat.jar
    ls -l /usr/share/tomcat7/lib/spring3-instrument-tomcat.jar
    cat /var/lib/tomcat7/webapps/contrast-finder/META-INF/context.xml
    cat /var/lib/tomcat7/webapps/contrast-finder/META-INF/MANIFEST.MF

DEBIAN 8     Tomcat 7
-----------------------------
docker/build_and_run-with-docker.sh -l --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local/distrib/debian-8_tomcat-7_legacy-debian --log-build
docker exec -ti contrast.finder /bin/cat /softwares-version.txt
docker logs --since 24h contrast.finder &> log_DEBIAN-8_withSpringInstrumentClassLoader.log
docker exec -ti contrast.finder /bin/bash
    cat /usr/local/tomcat/webapps/contrast-finder/META-INF/context.xml
    cat /usr/local/tomcat/webapps/contrast-finder/META-INF/MANIFEST.MF
    ls -l /usr/share/java/spring3-instrument-tomcat.jar
    ls -l /usr/local/tomcat/lib/spring3-instrument-tomcat.jar
