# i18n

Contrast-Finder i18n files use UTF-8 character encoding.

## Warning: do not translate internal IDs
```bash
##### For [form.resultNumber]
##### ---> Do not translate "choice", it is an internal ID
form.resultNumber={0} {0,choice,1#result|1<results}
form.resultNumber={0} {0,choice,1#résultat|1<résultats}
form.resultNumber={0} {0,choice,1#resultado|1<resultados}
form.resultNumber={0} {0,choice,1#개의 결과|1<개의 결과}
```


## Character encoding

Java i18n files however must be ISO-8859-1.
But Contrast-Finder i18n files use UTF-8 character encoding.

### native2ascii-maven-plugin

- https://davidsimpson.me/2015/03/04/automated-native2ascii-character-conversion-internationalization-atlassian-add-ons/
- https://blog.crafting-labs.fr/2010/09/25/fichiers-properties-java-en-utf-8-avec-maven/
- https://stackoverflow.com/questions/7105039/maven-how-to-configure-native2ascii-maven-plugin?rq=1
  - http://grepcode.com/project/repo1.maven.org/maven2/org.codehaus.mojo/native2ascii-maven-plugin/

### Convert a single file

#### UTF8 to ISO-8859-1 with Unicode escapes
Converts a file encoded in UTF8 to a file in in ISO-8859-1 with Unicode escapes.
```bash
native2ascii -encoding utf8 example.utf8.txt example.propertie
```

#### ISO-8859-1 with Unicode escapes to UTF8
Converts a file encoded in ISO-8859-1 with Unicode escapes to a file in UTF8 character encoding.
```bash
native2ascii -encoding utf8 -reverse example.propertie   example.reverse.utf8.txt
```

## Tools and resources
* **Transvision** is a tool used to search translations extracted from Mozilla products and websites.
     * [transvision.mozfr.org](https://transvision.mozfr.org/)
     * [example for "contrast ratio"](https://transvision.mozfr.org/?recherche=contrast+ratio&repo=gecko_strings&sourcelocale=en-US&locale=fr&search_type=strings)
* **Pontoon** "enables localizers to translate web apps and web sites in place with context and spatial limitations right in front of them." (@@@TODO someone to test it ?)
    * https://pontoon.mozilla.org
    * https://github.com/mozilla/pontoon
