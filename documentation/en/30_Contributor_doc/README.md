#  Developer documentation 

* [Building Contrast-Finder](Build/README.md)
* [Release a version of Contrast-Finder](Release/README.md) 

-----
* Checking for new dependency / plugin updates
* OWASP Dependency-Check
* Code coverage
* Checkstyle
* JavaDoc

## Checking for new dependency / plugin updates
```bash
# Checking for new dependency updates
mvn versions:display-dependency-updates 

# Checking for new plugin updates
mvn versions:display-plugin-updates  

# Checking for new property-linked updates
mvn versions:display-property-updates 
```

### Documentation
* http://www.mojohaus.org/versions-maven-plugin/examples/display-dependency-updates.html
* http://www.mojohaus.org/versions-maven-plugin/examples/display-plugin-updates.html
* http://www.mojohaus.org/versions-maven-plugin/examples/display-property-updates.html


##  OWASP Dependency-Check
Scan Contrast-Finder to identify the use of known vulnerable components. 

```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd Contrast-finder
```

One of the following command lines:
```bash
mvn dependency-check:check
mvn dependency-check:aggregate
mvn site
```

The dependencies report is available in this file:
```bash
target/dependency-check-report.html 
```

Others command lines:
```bash
mvn dependency-check:help
mvn dependency-check:help -Ddetail=true -Dgoal=aggregate 
```

### Documentation
* https://www.owasp.org/index.php/OWASP_Dependency_Check
* http://jeremylong.github.io/DependencyCheck/
* http://jeremylong.github.io/DependencyCheck/dependency-check-maven/

## Code coverage

no aggregate report (if you know how to do it…)

### Jacoco

#### Documentation
* http://www.jacoco.org/jacoco/
* https://github.com/jacoco/jacoco/

#### Usage
```bash
mvn clean install
     # report: engine/*/target/site/jacoco
```

### Cobertura 

#### Documentation
* http://www.mojohaus.org/cobertura-maven-plugin/
* https://github.com/cobertura/cobertura

#### Usage
```bash
mvn cobertura:cobertura
     # report: engine/*/target/site/cobertura
```
                
                        

## Checkstyle
Scan Contrast-Finder to check the violations of a coding standard.

### Documentation
* http://checkstyle.sourceforge.net/
* http://maven.apache.org/plugins/maven-checkstyle-plugin/

### maven-checkstyle-plugin
```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd Contrast-finder

# Performs Checkstyle analysis and outputs violations or a count of violations
# to the console, potentially failing the build.
mvn checkstyle:check

# A reporting task that performs Checkstyle analysis 
# and generates an HTML report for each module
mvn checkstyle:checkstyle

# a reporting task that performs Checkstyle analysis
# and generates an aggregate HTML report 
mvn checkstyle:checkstyle-aggregate
mvn site

# Checking for violations as part of the Build
mvn clean install 
    # Before, remove comments 
    # around <goal>check</goal> in pom.xml file
```

### checkstyle CLI
```bash
apt-get install checkstyle
git clone https://github.com/Asqatasun/Contrast-Finder
checkstyle  -c checkstyle.xml Contrast-Finder/**/*.java 
```


### CI (Travis, Gitlab, Jenkins)
...



## JavaDoc

```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd Contrast-finder
```

One of the following command lines:
```bash
mvn javadoc:javadoc
mvn javadoc:aggregate
mvn javadoc:test-javadoc
mvn javadoc:test-aggregate 
mvn site
```

JavaDoc is available in the following directories:
```bash
target/site/apidocs
target/site/testapidocs
```

### Documentation
* [Apache Maven Javadoc Plugin](https://maven.apache.org/plugins/maven-javadoc-plugin/)
* [Generate Javadocs](https://maven.apache.org/plugins/maven-javadoc-plugin/usage.html)
* [Javadoc Plugin Documentation](https://maven.apache.org/plugins/maven-javadoc-plugin/javadoc-mojo.html)

