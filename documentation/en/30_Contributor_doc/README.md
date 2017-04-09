#  Developer documentation 

* [Release a version of Contrast-Finder](Release/README.md) 

## JavaDoc

```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd Contrast-finder
mvn site
```

JavaDoc is available in the following directory:
```bash
target/site/apidocs
```

##  OWASP Dependency-Check
Scan Contrast-Finder to identify the use of known vulnerable components. 
* https://www.owasp.org/index.php/OWASP_Dependency_Check
* http://jeremylong.github.io/DependencyCheck/
* http://jeremylong.github.io/DependencyCheck/dependency-check-maven/

```bash
git clone https://github.com/Asqatasun/Contrast-Finder
cd Contrast-finder
```

One of the following command lines:
```bash
mvn site
mvn org.owasp:dependency-check-maven:check
mvn org.owasp:dependency-check-maven:aggregate 
```

The dependencies report is available in this file:
```bash
target/dependency-check-report.html 
```
