#  Developer documentation 

* JavaDoc
* OWASP Dependency-Check
* [Release a version of Contrast-Finder](Release/README.md) 

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

##  OWASP Dependency-Check
Scan Contrast-Finder to identify the use of known vulnerable components. 

```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd Contrast-finder
```

One of the following command lines:
```bash
mvn dependency-check:check
mvn dependency-check:agregated
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