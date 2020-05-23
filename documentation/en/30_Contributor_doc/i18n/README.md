# Internationalization (i18n)

Contrast-Finder [i18n files](https://github.com/Asqatasun/Contrast-Finder/tree/develop/webapp/src/main/resources/i18n) use UTF-8 character encoding.

## Add a new language
@@@TODO

## Character encoding

- Java i18n files must be ISO-8859-1  character encoding (with unicode escapes, like `\u0104` instead of the `Ą` character).
- But, Contrast-Finder i18n files use UTF-8 character encoding.
- The compilation (`mvn clean install`) uses the *native2ascii* maven plugin to convert i18n files from UTF-8 encoding to ASCII encoding (with unicode escapes, like `\u0104` instead of the `Ą` character).

### Example

Before Maven build (UTF-8),
 [webapp/src/main/resources/i18n/contrast-finder_utf8_fr.properties](https://github.com/Asqatasun/Contrast-Finder/blob/develop/webapp/src/main/resources/i18n/contrast-finder_utf8_fr.properties) file in git repository:
```
form.contrastSolutionBackground=Arrière plan
form.sampleText=Ceci est un échantillon
```

After Maven build (ASCII with unicode escapes),
 `WEB-INF\classes\i18n\contrast-finder_utf8_fr.properties` file in the .war file or in Tomcat directory:
```
form.contrastSolutionBackground=Arri\u00E8re plan
form.sampleText=Ceci est un \u00E9chantillon
```

## Tips

### Warning: do not translate internal IDs
```bash
##### For [form.resultNumber]
##### ---> Do not translate "choice", it is an internal ID
form.resultNumber={0} {0,choice,1#result|1<results}
form.resultNumber={0} {0,choice,1#résultat|1<résultats}
form.resultNumber={0} {0,choice,1#resultado|1<resultados}
form.resultNumber={0} {0,choice,1#개의 결과|1<개의 결과}
```

### Multi-line value
```bash
# Use backslash (\) at the end of the line
# to continue the value on the next line
str1=first  line of str1  \
     second line of str1  \
     last   line of str1
```

### Single quote 

- In i18n files, the single quote [ `'` - apostrophe ] may be problematic.
- If you can, prefer to using [typographic apostrophe](https://en.wikipedia.org/wiki/Apostrophe#Entering_apostrophes) [ `’` ].
 
Some cases:

1. `str=L'audit du site`
    it works
2. `str=L''audit du site`
    appears like this: `L''audit du site`
    
    In this case, it is necessary to use one of the following elements:
    `str=L’audit du site`,
    `str=L'audit du site`,
    `str=L&apos;audit du site` or
    `str=L&#39;audit  du site`

3. `str=L'audit {0} du site et d'une page`
    appears like this: `Laudit {0} du site et dune page`
    
    In this case, it is necessary to use one of the following elements:
    `str=L’audit {0} du site et d’une page`,
    `str=L''audit {0} du site et d''une page`,
    `str=L&apos;audit {0} du site et d&apos;une page` or
    `str=L&#39;audit {0} du site et d&#39;une page`


## Tools and resources
- [Unicode character symbols table with escape sequences & HTML codes](https://www.rapidtables.com/code/text/unicode-characters.html)

### Online Translators / Dictionaries
- [deepl.com](https://www.deepl.com/translator)
- [linguee.com](https://www.linguee.com/)
- Korean dictionary [naver.com](https://en.dict.naver.com/)

### Translate Tools
* **Transvision** is a tool used to search translations extracted from Mozilla products and websites.
     * [transvision.mozfr.org](https://transvision.mozfr.org/)
     * [example for "contrast ratio"](https://transvision.mozfr.org/?recherche=contrast+ratio&repo=gecko_strings&sourcelocale=en-US&locale=fr&search_type=strings)
* **Pontoon** "enables localizers to translate web apps and web sites in place with context and spatial limitations right in front of them." (@@@TODO someone to test it ?)
    * https://pontoon.mozilla.org
    * https://github.com/mozilla/pontoon


### native2ascii-maven-plugin
- https://github.com/mojohaus/native2ascii-maven-plugin
- [Automated native2ascii character conversion for internationalisation ](https://davidsimpson.me/2015/03/04/automated-native2ascii-character-conversion-internationalization-atlassian-add-ons/)
- [in french: "fichiers .properties java en UTF-8 avec maven"](https://blog.crafting-labs.fr/2010/09/25/fichiers-properties-java-en-utf-8-avec-maven/)
- [Maven: How to configure native2ascii-maven-plugin](https://stackoverflow.com/questions/7105039/maven-how-to-configure-native2ascii-maven-plugin?rq=1)


### Convert a single file

[native2ascii.net](https://native2ascii.net/) allow you to convert national language characters to and from their Unicode equivalents in plain ASCII text.

#### UTF8 to ASCII with Unicode escapes
Converts a file encoded in UTF8 to a file in ASCII with Unicode escapes.
```bash
# native2ascii from JDK (no longer available since JDK9)
native2ascii -encoding utf8 example_utf8.txt example_ISO-8859-1.txt

# UTF8 to ASCII with Unicode escapes 
apt install uni2ascii
uni2ascii -q -a U example_utf8.txt > example_ASCII.txt
```

#### ASCII with Unicode escapes to UTF8
Converts a file encoded in ASCII with Unicode escapes to a file in UTF8 character encoding.
```bash
# native2ascii from JDK (no longer available since JDK9)
native2ascii -encoding utf8 -reverse example.propertie   example.reverse.utf8.txt

# ASCII with Unicode escapes to UTF8
apt install uni2ascii
ascii2uni -q -a U example_ASCII.txt > example_utf8.txt
```

### Convert multiple files

For convert all files in a i18n directory:
```
# convert all UTF8 files to ASCII with Unicode escapes
mkdir ../i18n_backup/
cp -v ./*.properties ../i18n_backup/
mkdir ../newFiles/
find -name "*.properties" -type f -exec bash -c "uni2ascii -q -a U  {} > ../newFiles/{}" \;
cp -v ../newFiles/* ./
rm -r ../newFiles/
```


