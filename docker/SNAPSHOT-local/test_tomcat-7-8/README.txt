
----- build with jdk7 or jdk8

    ### JDK 7
    docker pull asqatasun/asqa.mvn:contrast.finder_jdk7
    docker run -it --rm  -v "$PWD":/usr/src/ -w /usr/src/ asqatasun/asqa.mvn:contrast.finder_jdk7 mvn clean install
    docker/build_and_run-with-docker.sh -l --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local/ --log-build
    docker run -it --rm  -v "$PWD":/usr/src/ -w /usr/src/ asqatasun/asqa.mvn:contrast.finder_jdk7 mvn clean
    docker exec -ti contrast.finder /bin/bash
         cat /var/lib/tomcat8/webapps/contrast-finder/META-INF/MANIFEST.MF

    ### JDK 8
    docker pull asqatasun/asqa.mvn:contrast.finder_jdk8
    docker run -it --rm  -v "$PWD":/usr/src/ -w /usr/src/ asqatasun/asqa.mvn:contrast.finder_jdk8 mvn clean install
    docker/build_and_run-with-docker.sh -l --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local/ --log-build
    docker run -it --rm  -v "$PWD":/usr/src/ -w /usr/src/ asqatasun/asqa.mvn:contrast.finder_jdk8 mvn clean
    docker exec -ti contrast.finder /bin/bash
         cat /var/lib/tomcat8/webapps/contrast-finder/META-INF/MANIFEST.MF


----- without libspring-instrument-java ---------------------------------------

OK   /distrib/debian-8_tomcat-7_legacy-debian
OK   /test_tomcat-7-8/Ubuntu_14.04_tomcat7_full
OK   /test_tomcat-7-8/Ubuntu_16.04_tomcat7_full
OK   /test_tomcat-7-8/Ubuntu_16.04_tomcat8_full
OK   /test_tomcat-7-8/Ubuntu_18.04_tomcat8_full

---------------------------------------------------------------------

UBUNTU 18.04 Tomcat 8.5
-----------------------------
docker/build_and_run-with-docker.sh -l --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local/test_tomcat-7-8/Ubuntu_18.04_tomcat8_full/ --log-build
docker exec -ti contrast.finder /bin/cat /softwares-version.txt
docker logs --since 24h contrast.finder &> log_UBUNTU-18.04_tomcat-8_without_SpringInstrumentClassLoader.log
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
docker logs --since 24h contrast.finder &> log_UBUNTU-16.04_tomcat-8_without_SpringInstrumentClassLoader.log
docker exec -ti contrast.finder /bin/bash
    ls -l /usr/share/java/spring3-instrument-tomcat.jar
    ls -l /usr/share/tomcat8/lib/spring3-instrument-tomcat.jar
    cat /var/lib/tomcat8/webapps/contrast-finder/META-INF/context.xml
    cat /var/lib/tomcat8/webapps/contrast-finder/META-INF/MANIFEST.MF

UBUNTU 16.04 Tomcat 7
-----------------------------
docker/build_and_run-with-docker.sh -l --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local/test_tomcat-7-8/Ubuntu_16.04_tomcat7_full/ --log-build
docker exec -ti contrast.finder /bin/cat /softwares-version.txt
docker logs --since 24h contrast.finder &> log_UBUNTU-16.04_tomcat-7_without_SpringInstrumentClassLoader.log
docker exec -ti contrast.finder /bin/bash
    ls -l /usr/share/java/spring3-instrument-tomcat.jar
    ls -l /usr/share/tomcat7/lib/spring3-instrument-tomcat.jar
    cat /var/lib/tomcat7/webapps/contrast-finder/META-INF/context.xml
    cat /var/lib/tomcat7/webapps/contrast-finder/META-INF/MANIFEST.MF

UBUNTU 14.04 Tomcat 7
-----------------------------
docker/build_and_run-with-docker.sh -l --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local/test_tomcat-7-8/Ubuntu_14.04_tomcat7_full --log-build
docker exec -ti contrast.finder /bin/cat /softwares-version.txt
docker logs --since 24h contrast.finder &> log_UBUNTU-14.04_without_SpringInstrumentClassLoader.log
docker exec -ti contrast.finder /bin/bash
    ls -l /usr/share/java/spring3-instrument-tomcat.jar
    ls -l /usr/share/tomcat7/lib/spring3-instrument-tomcat.jar
    cat /var/lib/tomcat7/webapps/contrast-finder/META-INF/context.xml
    cat /var/lib/tomcat7/webapps/contrast-finder/META-INF/MANIFEST.MF

DEBIAN 8    Tomcat 7
-----------------------------
docker/build_and_run-with-docker.sh -l --source-dir ${PWD} --docker-dir docker/SNAPSHOT-local/distrib/debian-8_tomcat-7_legacy-debian --log-build
docker exec -ti contrast.finder /bin/cat /softwares-version.txt
docker logs --since 24h contrast.finder &> log_DEBIAN-8_without_SpringInstrumentClassLoader.log
docker exec -ti contrast.finder /bin/bash
    cat /usr/local/tomcat/webapps/contrast-finder/META-INF/context.xml
    cat /usr/local/tomcat/webapps/contrast-finder/META-INF/MANIFEST.MF
    ls -l /usr/share/java/spring3-instrument-tomcat.jar
    ls -l /usr/local/tomcat/lib/spring3-instrument-tomcat.jar