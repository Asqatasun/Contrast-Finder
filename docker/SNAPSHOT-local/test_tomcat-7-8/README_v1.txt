---- avant suppression libspring-instrument-java ---------------------------------

                            v0.8.3  150 MB
                            v0.8.2  146 MB
pre-requisites_Alpine_tomcat-7   80 MB  --->  76 MB
pre-requisites_Ubuntu-16.04         115 MB  ---> 107 MB
pre-requisites_Ubuntu-14.04         141 MB  ---> 138 MB
pre-requisites_from-Ubuntu          141 MB  ---> 138 MB
-------------------------------------






    test:
        - Build-Jdk: 1.8  @@@ IN PROGRESSS
        - Build-Jdk: 1.7  @@@ TODO 
    check log @@@ TODO 


Build-Jdk: 1.8.0_151
----------------------------------------------

Docker ubuntu:14.04 Tomcat 7
       ----> libspring-instrument-java   not needed

Docker ubuntu:16.04 Tomcat 7
       ----> libspring-instrument-java   not needed

Docker ubuntu:18.04 Tomcat 8.5 (next Ubuntu LTS)
       ----> libspring-instrument-java   not needed


Build-Jdk: 1.7.0_151
----------------------------------------------

Docker ubuntu:14.04 Tomcat 7
       ----> libspring-instrument-java   not needed

Docker ubuntu:16.04 Tomcat 7
       ----> libspring-instrument-java   not needed

Docker ubuntu:16.04 Tomcat 8.0
       -v2---> libspring-instrument-java declared in context.xml

Docker ubuntu:18.04 Tomcat 8.5 (next Ubuntu LTS)
       ----> libspring-instrument-java   not needed
