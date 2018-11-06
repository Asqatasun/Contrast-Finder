# Bookmarks for potential features


## Contributing guidlines
* https://github.com/spring-projects/spring-security/blob/master/CONTRIBUTING.md
* https://github.com/moby/moby/blob/master/CONTRIBUTING.md

## UI / UX examples
* https://www.colorbox.io/ (color tool to produce color sets)
* [Accessible Color Spaces](http://kevingutowski.github.io/color.html)
    * src: https://github.com/KevinGutowski/KevinGutowski.github.io

## schema.org
- https://www.w3.org/wiki/WebSchemas/Accessibility
- http://schema.org/accessibilityAPI
- http://schema.org/accessibilityHazard
- http://schema.org/accessibilityControl
- http://schema.org/accessMode
- http://schema.org/accessModeSufficient

## Ansible

- https://github.com/ansible/ansible-examples/tree/master/tomcat-standalone
- https://github.com/elacheche/ansible-war-deploy
- http://aseigneurin.github.io/2014/11/04/ansible-pour-deployer-des-applications.html
     - https://github.com/aseigneurin/ansible-sandbox

## Kootlin
- http://kotlinlang.org/
- https://docs.spring.io/spring/docs/current/spring-framework-reference/languages.html#kotlin
- https://spring.io/blog/2017/01/04/introducing-kotlin-support-in-spring-framework-5-0


# color space converter and conversion formula
- http://colorizer.org/
- [How to convert RGB to hex color](https://www.rapidtables.com/convert/color/how-rgb-to-hex.html)
- [How to convert hex to RGB color](https://www.rapidtables.com/convert/color/how-hex-to-rgb.html)
  - [Hex to RGB converter](https://www.rapidtables.com/convert/color/hex-to-rgb.html)
  - [HSL to RGB converter](https://www.rapidtables.com/convert/color/hsl-to-rgb.html)
  - [HSV to RGB converter](https://www.rapidtables.com/convert/color/hsv-to-rgb.html)
  - [RGB to Hex color converter](https://www.rapidtables.com/convert/color/rgb-to-hex.html)
  - [RGB to HSL converter](https://www.rapidtables.com/convert/color/rgb-to-hsl.html)
  - [RGB to HSV converter](https://www.rapidtables.com/convert/color/rgb-to-hsv.html)

# Javascript
- Converting jQuery to JavaScript
    - https://github.com/jackocnr/intl-tel-input/wiki/Converting-jQuery-to-JavaScript
    - http://sharedfil.es/js-48hIfQE4XK.html
    - http://youmightnotneedjquery.com/
    - http://putaindecode.io/fr/articles/js/de-jquery-a-vanillajs/
- http://mathjs.org math library for JavaScript
- key code
    - https://developer.mozilla.org/en-US/docs/Web/API/KeyboardEvent/code
    - https://developer.mozilla.org/en-US/docs/Web/API/KeyboardEvent/keyCode

## JS - Sorts tables

### Seems to be accessible but uses Jquery
- https://dequeuniversity.com/library/aria/tables/sf-sortable-grid
    - sorting rows with space key not works
- https://www.datatables.net/
    - sorting rows with space key not works
    - https://assets.cms.gov/resources/framework/2.0/Pages/datatables.html
        - use an older version of datatables.net
        - sorting rows with space key work correctly
- http://examples.simplyaccessible.com/table-sort/accessible.php
    - fixes **TabSorter** plugin accessibility
    - the demo page does not seem to work well
    - currently used by _Contrast-Finder_
        - works better on _Contrast-Finder_ than on the demo page
          for focusing headers cells and sorting rows with enter key
        - sorting rows with space key not works
- https://mottie.github.io/tablesorter/
    - fork of the TabSorter plugin
    - seems to have integrated accessibility issues
      (sorting columns with keyboard, role="row", "aria-sort", ...)
    - sorting rows with space key not works


### does not use Jquery but not accessible
- http://www.trucsweb.com/tutoriels/javascript/tableau-tri/
- https://kryogenix.org/code/browser/sorttable/
- https://github.com/tofsjonas/sortable/

# Java - i18n / URL
- https://stackoverflow.com/questions/45357121/spring-mvc-requestmapping-with-i18n-path-parts
- https://coderanch.com/t/625363/frameworks/URL-Locale-Spring-MVC
- http://www.oracle.com/us/technologies/java/locale-140624.html
- https://stackoverflow.com/questions/34628714/url-path-for-multi-language
- https://www.boraji.com/spring-mvc-5-internationalization-example
- https://www.mkyong.com/spring-mvc/spring-mvc-internationalization-example/
- https://memorynotfound.com/spring-mvc-internationalization-i18n-example/
- https://gokan-ekinci.developpez.com/tutoriels/java/spring-mvc-exception/

# Java - Build number
- https://raymondhlee.wordpress.com/2014/10/25/using-maven-build-number-plugin-to-load-code-revision-details/
- https://blog.jayway.com/2012/04/07/continuous-deployment-versioning-and-git/
- https://stackoverflow.com/questions/6947827/maven-build-number-plugin-how-to-save-the-build-number-in-a-file
- https://www.javacodegeeks.com/2012/10/maven-build-number-plugin-sample-usage.html
- https://github.com/ktoso/maven-git-commit-id-plugin

# tag `<meter>`
- https://caniuse.com/#search=meter
- https://css-tricks.com/html5-meter-element/
- some tests : https://codepen.io/anon/pen/eKPwpG?editors=1000
```html
<style> body{
           font-family: Verdana, Geneva, sans-serif;
        }
        h1 {
          margin-top: 1.5em;
          font-size: 100%
        }
</style>
<h1> I) min 0 / max 10 / optimum 4.5 / low 3</h1>
A <meter value="2.9" min="0" max="10" low="3" optimum="4.5" ></meter>
          value 2.9 - min 0 - max 10 - low 3 - optimun 4.5 <br>
B <meter value="3.3" min="0" max="10" low="3" optimum="4.5" ></meter>
          value 3.3 - min 0 - max 10 - low 3 - optimun 4.5 <br>
C <meter value="4.6" min="0" max="10" low="3" optimum="4.5" ></meter>
          value 4.6 - min 0 - max 10 - low 3 - optimun 4.5 <br>
D <meter value="7.0" min="0" max="10" low="3" optimum="4.5" ></meter>
          value 7.0 - min 0 - max 10 - low 3 - optimun 4.5 <br>
E <meter value="9.0" min="0" max="10" low="3" optimum="4.5" ></meter>
          value 9.0 - min 0 - max 10 - low 3 - optimun 4.5 <br>

<hr>
<h1> II) min 1 / max 21 / optimum 4.5 / low 3 </h1>
A <meter value="2.9" min="1" max="21" low="3" optimum="4.5" ></meter>
          value 2.9 - min 1 - max 21 - low 3 - optimun 4.5  <br>
B <meter value="3.3" min="1" max="21" low="3" optimum="4.5" ></meter>
          value 3.3 - min 1 - max 21 - low 3 - optimun 4.5 <br>
D <meter value="4.6" min="1" max="21" low="3" optimum="4.5" ></meter>
          value 4.6 - min 1 - max 21 - low 3 - optimun 4.5  <br>
E <meter value="7.0" min="1" max="21" low="3" optimum="4.5" ></meter>
          value 7.0 - min 1 - max 21 - low 3 - optimun 4.5  <br>
F <meter value="9.0" min="1" max="21" low="3" optimum="4.5" ></meter>
          value 9.0 - min 1 - max 21 - low 3 - optimun 4.5  <br>

<h1> III) min 1 / max 21 / optimum 7 / low 4.5 </h1>
A <meter value="2.9" min="1" max="21" low="4.5" optimum="7" ></meter>
          value 2.9 - min 1 - max 21 - low 4.5 - optimun 7  <br>
B <meter value="3.3" min="1" max="21" low="4.5" optimum="7" ></meter>
          value 3.3 - min 1 - max 21 - low 4.5 - optimun 7  <br>
D <meter value="4.6" min="1" max="21" low="4.5" optimum="7" ></meter>
          value 4.6 - min 1 - max 21 - low 4.5 - optimun 7  <br>
E <meter value="7.0" min="1" max="21" low="4.5" optimum="7" ></meter>
          value 7.0 - min 1 - max 21 - low 4.5 - optimun 7  <br>
F <meter value="9.0" min="1" max="21" low="4.5" optimum="7" ></meter>
          value 9.0 - min 1 - max 21 - low 4.5 - optimun 7  <br>

<h1> IV) min 1 / max 21 / optimum 7 / low 7 </h1>
A <meter value="2.9" min="1" max="21" low="7" optimum="7" ></meter>
          value 2.9 - min 1 - max 21 - low 7 - optimun 7  <br>
B <meter value="3.3" min="1" max="21" low="7" optimum="7" ></meter>
          value 3.3 - min 1 - max 21 - low 7 - optimun 7  <br>
D <meter value="4.6" min="1" max="21" low="7" optimum="7" ></meter>
          value 4.6 - min 1 - max 21 - low 7 - optimun 7  <br>
E <meter value="7.0" min="1" max="21" low="7" optimum="7" ></meter>
          value 7.0 - min 1 - max 21 - low 7 - optimun 7  <br>
F <meter value="9.0" min="1" max="21" low="7" optimum="7" ></meter>
          value 9.0 - min 1 - max 21 - low 7 - optimun 7  <br>

<hr>
<h1> V) min 1 / max 7 / optimum 4.5 / low 3 </h1>
A <meter value="2.9" min="1" max="7" low="3" optimum="4.5" ></meter>
          value 2.9 - min 1 - max 7 - low 3 - optimun 4.5  <br>
B <meter value="3.3" min="1" max="7" low="3" optimum="4.5" ></meter>
          value 3.3 - min 1 - max 7 - low 3 - optimun 4.5 <br>
C <meter value="4.6" min="1" max="7" low="3" optimum="4.5" ></meter>
          value 4.6 - min 1 - max 7 - low 3 - optimun 4.5 <br>
E <meter value="7.0" min="1" max="7" low="3" optimum="4.5" ></meter>
          value 7.0 - min 1 - max 7 - low 3 - optimun 4.5  <br>
F <meter value="9.0" min="1" max="7" low="3" optimum="4.5" ></meter>
          value 9.0 - min 1 - max 7 - low 3 - optimun 4.5  <br>

<h1> VI) min 1 / max 7 / optimum 7 / low 4.5 </h1>
A <meter value="2.9" min="1" max="7" low="4.5" optimum="7" ></meter>
          value 2.9 - min 1 - max 7 - low 4.5 - optimun 7  <br>
B <meter value="3.3" min="1" max="7" low="4.5" optimum="7" ></meter>
          value 3.3 - min 1 - max 7 - low 4.5 - optimun 7 <br>
C <meter value="4.6" min="1" max="7" low="4.5" optimum="7" ></meter>
          value 4.6 - min 1 - max 7 - low 4.5 - optimun 7  <br>
D <meter value="7.0" min="1" max="7" low="4.5" optimum="7" ></meter>
          value 7.0 - min 1 - max 7 - low 4.5 - optimun 7  <br>
E <meter value="9.0" min="1" max="7" low="4.5" optimum="7" ></meter>
          value 9.0 - min 1 - max 7 - low 4.5 - optimun 7  <br>

<h1> VII) min 1 / max 7 / optimum 7 / low 7 </h1>
A <meter value="2.9" min="1" max="7" low="7.0" optimum="7" ></meter>
          value 2.9 - min 1 - max 7 - low 7.0 - optimun 7  <br>
B <meter value="3.3" min="1" max="7" low="7.0" optimum="7" ></meter>
          value 3.3 - min 1 - max 7 - low 7.0 - optimun 7 <br>
C <meter value="4.6" min="1" max="7" low="7.0" optimum="7" ></meter>
          value 4.6 - min 1 - max 7 - low 7.0 - optimun 7  <br>
D <meter value="7.0" min="1" max="7" low="7.0" optimum="7" ></meter>
          value 7.0 - min 1 - max 7 - low 7.0 - optimun 7  <br>
E <meter value="9.0" min="1" max="7" low="7.0" optimum="7" ></meter>
          value 9.0 - min 1 - max 7 - low 7.0 - optimun 7  <br>

<hr>
<br>

<h1> VIII) min 0 / max 10 / high 4.5 / low 3</h1>
A <meter value="2.9" min="0" max="10" low="3" high="4.5" ></meter>
          value 2.9 - min 0 - max 10 - low 3 - high 4.5  <br>
B <meter value="3.3" min="0" max="10" low="3" high="4.5" ></meter>
          value 3.3 - min 0 - max 10 - low 3 - high 4.5  <br>
C <meter value="4.6" min="0" max="10" low="3" high="4.5" ></meter>
          value 4.6 - min 0 - max 10 - low 3 - high 4.5  <br>
D <meter value="7.0" min="0" max="10" low="3" high="4.5" ></meter>
          value 7.0 - min 0 - max 10 - low 3 - high 4.5  <br>
E <meter value="9.0" min="0" max="10" low="3" high="4.5" ></meter>
          value 9.0 - min 0 - max 10 - low 3 - high 4.5  <br>

<hr>
<h1> IX) min 1 / max 21 / high 4.5 / low 3 </h1>
A <meter value="2.9" min="1" max="21" low="3" high="4.5" ></meter>
          value 2.9 - min 1 - max 21 - low 3 - high 4.5  <br>
B <meter value="3.3" min="1" max="21" low="3" high="4.5" ></meter>
          value 3.3 - min 1 - max 21 - low 3 - high 4.5  <br>
D <meter value="4.6" min="1" max="21" low="3" high="4.5" ></meter>
          value 4.6 - min 1 - max 21 - low 3 - high 4.5  <br>
E <meter value="7.0" min="1" max="21" low="3" high="4.5" ></meter>
          value 7.0 - min 1 - max 21 - low 3 - high 4.5  <br>
F <meter value="9.0" min="1" max="21" low="3" high="4.5" ></meter>
          value 9.0 - min 1 - max 21 - low 3 - high 4.5  <br>

<h1> X) min 1 / max 21 / high 7 / low 4.5 </h1>
A <meter value="2.9" min="1" max="21" low="4.5" high="7" ></meter>
          value 2.9 - min 1 - max 21 - low 4.5 - high 7  <br>
B <meter value="3.3" min="1" max="21" low="4.5" high="7" ></meter>
          value 3.3 - min 1 - max 21 - low 4.5 - high 7  <br>
D <meter value="4.6" min="1" max="21" low="4.5" high="7" ></meter>
          value 4.6 - min 1 - max 21 - low 4.5 - high 7  <br>
E <meter value="7.0" min="1" max="21" low="4.5" high="7" ></meter>
          value 7.0 - min 1 - max 21 - low 4.5 - high 7  <br>
F <meter value="9.0" min="1" max="21" low="4.5" high="7" ></meter>
          value 9.0 - min 1 - max 21 - low 4.5 - high 7  <br>

<h1> XI) min 1 / max 21 / high 7 / low 7 </h1>
A <meter value="2.9" min="1" max="21" low="7" high="7" ></meter>
          value 2.9 - min 1 - max 21 - low 7 - high 7  <br>
B <meter value="3.3" min="1" max="21" low="7" high="7" ></meter>
          value 3.3 - min 1 - max 21 - low 7 - high 7  <br>
D <meter value="4.6" min="1" max="21" low="7" high="7" ></meter>
          value 4.6 - min 1 - max 21 - low 7 - high 7  <br>
E <meter value="7.0" min="1" max="21" low="7" high="7" ></meter>
          value 7.0 - min 1 - max 21 - low 7 - high 7  <br>
F <meter value="9.0" min="1" max="21" low="7" high="7" ></meter>
          value 9.0 - min 1 - max 21 - low 7 - high 7  <br>

<hr>
<h1> XII) min 1 / max 7 / high 4.5 / low 3</h1>
A <meter value="2.9" min="1" max="7" low="3" high="4.5" ></meter>
          value 2.9 - min 1 - max 7 - low 3 - high 4.5  <br>
B <meter value="3.3" min="1" max="7" low="3" high="4.5" ></meter>
          value 3.3 - min 1 - max 7 - low 3 - high 4.5  <br>
C <meter value="4.6" min="1" max="7" low="3" high="4.5" ></meter>
          value 4.6 - min 1 - max 7 - low 3 - high 4.5  <br>
E <meter value="7.0" min="1" max="7" low="3" high="4.5" ></meter>
          value 7.0 - min 1 - max 7 - low 3 - high 4.5  <br>
F <meter value="9.0" min="1" max="7" low="3" high="4.5" ></meter>
          value 9.0 - min 1 - max 7 - low 3 - high 4.5  <br>

<h1> XIII) min 1 / max 7 / high 7 / low 4.5  </h1>
A <meter value="2.9" min="1" max="7" low="4.5" high="7" ></meter>
          value 2.9 - min 1 - max 7 - low 4.5 - high 7  <br>
B <meter value="3.3" min="1" max="7" low="4.5" high="7" ></meter>
          value 3.3 - min 1 - max 7 - low 4.5 - high 7  <br>
C <meter value="4.6" min="1" max="7" low="4.5" high="7" ></meter>
          value 4.6 - min 1 - max 7 - low 4.5 - high 7  <br>
D <meter value="7.0" min="1" max="7" low="4.5" high="7" ></meter>
          value 7.0 - min 1 - max 7 - low 4.5 - high 7  <br>
E <meter value="9.0" min="1" max="7" low="4.5" high="7" ></meter>
          value 9.0 - min 1 - max 7 - low 4.5 - high 7  <br>

<h1> XIV) min 1 / max 7 / high 7 / low 7 </h1>
A <meter value="2.9" min="1" max="7" low="7.0" high="7" ></meter>
          value 2.9 - min 1 - max 7 - low 7.0 - high 7  <br>
B <meter value="3.3" min="1" max="7" low="7.0" high="7" ></meter>
          value 3.3 - min 1 - max 7 - low 7.0 - high 7  <br>
C <meter value="4.6" min="1" max="7" low="7.0" high="7" ></meter>
          value 4.6 - min 1 - max 7 - low 7.0 - high 7  <br>
D <meter value="7.0" min="1" max="7" low="7.0" high="7" ></meter>
          value 7.0 - min 1 - max 7 - low 7.0 - high 7  <br>
E <meter value="9.0" min="1" max="7" low="7.0" high="7" ></meter>
          value 9.0 - min 1 - max 7 - low 7.0 - high 7  <br>


```
