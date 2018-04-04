# Bookmarks for potential features


## Contributing guidlines
* https://github.com/spring-projects/spring-security/blob/master/CONTRIBUTING.md
* https://github.com/moby/moby/blob/master/CONTRIBUTING.md

## UI / UX examples
* [Accessible Color Spaces](https://github.com/KevinGutowski/KevinGutowski.github.io)
    * src: http://kevingutowski.github.io/color.html

## schema.org
- http://schema.org/accessibilityAPI

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

# tag <meter>
- https://caniuse.com/#search=meter
- some tests : https://codepen.io/anon/pen/JLRZqZ?editors=1100
```html
<h1> min 0 / max 10 / optimum 4.5 / low 3</h1>
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
<h1>  min 1 / max 21 / optimum 4.5 / low 3 </h1>
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

<h1>  min 1 / max 21 / optimum 7 / low 4.5 </h1>
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

<h1>  min 1 / max 21 / optimum 7 / low 7 </h1>
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
<h1> min 1 / max 7 / optimum 4.5 / low 3 </h1>
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

<h1> min 1 / max 7 / optimum 7 / low 4.5 </h1>
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

<h1> min 1 / max 7 / optimum 7 / low 7 </h1>
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

<h1> min 0 / max 10 / high 4.5 / low 3</h1>
A <meter value="2.9" min="0" max="10" low="3" high="4.5" ></meter>
          value 2.9 - min 0 - max 10 - low 3 - optimun 4.5 <br>
B <meter value="3.3" min="0" max="10" low="3" high="4.5" ></meter>
          value 3.3 - min 0 - max 10 - low 3 - optimun 4.5 <br>
C <meter value="4.6" min="0" max="10" low="3" high="4.5" ></meter>
          value 4.6 - min 0 - max 10 - low 3 - optimun 4.5 <br>
D <meter value="7.0" min="0" max="10" low="3" high="4.5" ></meter>
          value 7.0 - min 0 - max 10 - low 3 - optimun 4.5 <br>
E <meter value="9.0" min="0" max="10" low="3" high="4.5" ></meter>
          value 9.0 - min 0 - max 10 - low 3 - optimun 4.5 <br>

<hr>
<h1>  min 1 / max 21 / high 4.5 / low 3 </h1>
A <meter value="2.9" min="1" max="21" low="3" high="4.5" ></meter>
          value 2.9 - min 1 - max 21 - low 3 - optimun 4.5  <br>
B <meter value="3.3" min="1" max="21" low="3" high="4.5" ></meter>
          value 3.3 - min 1 - max 21 - low 3 - optimun 4.5 <br>
D <meter value="4.6" min="1" max="21" low="3" high="4.5" ></meter>
          value 4.6 - min 1 - max 21 - low 3 - optimun 4.5  <br>
E <meter value="7.0" min="1" max="21" low="3" high="4.5" ></meter>
          value 7.0 - min 1 - max 21 - low 3 - optimun 4.5  <br>
F <meter value="9.0" min="1" max="21" low="3" high="4.5" ></meter>
          value 9.0 - min 1 - max 21 - low 3 - optimun 4.5  <br>

<h1>  min 1 / max 21 / high 7 / low 4.5 </h1>
A <meter value="2.9" min="1" max="21" low="4.5" high="7" ></meter>
          value 2.9 - min 1 - max 21 - low 4.5 - optimun 7  <br>
B <meter value="3.3" min="1" max="21" low="4.5" high="7" ></meter>
          value 3.3 - min 1 - max 21 - low 4.5 - optimun 7  <br>
D <meter value="4.6" min="1" max="21" low="4.5" high="7" ></meter>
          value 4.6 - min 1 - max 21 - low 4.5 - optimun 7  <br>
E <meter value="7.0" min="1" max="21" low="4.5" high="7" ></meter>
          value 7.0 - min 1 - max 21 - low 4.5 - optimun 7  <br>
F <meter value="9.0" min="1" max="21" low="4.5" high="7" ></meter>
          value 9.0 - min 1 - max 21 - low 4.5 - optimun 7  <br>

<h1>  min 1 / max 21 / high 7 / low 7 </h1>
A <meter value="2.9" min="1" max="21" low="7" high="7" ></meter>
          value 2.9 - min 1 - max 21 - low 7 - optimun 7  <br>
B <meter value="3.3" min="1" max="21" low="7" high="7" ></meter>
          value 3.3 - min 1 - max 21 - low 7 - optimun 7  <br>
D <meter value="4.6" min="1" max="21" low="7" high="7" ></meter>
          value 4.6 - min 1 - max 21 - low 7 - optimun 7  <br>
E <meter value="7.0" min="1" max="21" low="7" high="7" ></meter>
          value 7.0 - min 1 - max 21 - low 7 - optimun 7  <br>
F <meter value="9.0" min="1" max="21" low="7" high="7" ></meter>
          value 9.0 - min 1 - max 21 - low 7 - optimun 7  <br>

<hr>
<h1> min 1 / max 7 / high 4.5 / low 3 </h1>
A <meter value="2.9" min="1" max="7" low="3" high="4.5" ></meter>
          value 2.9 - min 1 - max 7 - low 3 - optimun 4.5  <br>
B <meter value="3.3" min="1" max="7" low="3" high="4.5" ></meter>
          value 3.3 - min 1 - max 7 - low 3 - optimun 4.5 <br>
C <meter value="4.6" min="1" max="7" low="3" high="4.5" ></meter>
          value 4.6 - min 1 - max 7 - low 3 - optimun 4.5 <br>
E <meter value="7.0" min="1" max="7" low="3" high="4.5" ></meter>
          value 7.0 - min 1 - max 7 - low 3 - optimun 4.5  <br>
F <meter value="9.0" min="1" max="7" low="3" high="4.5" ></meter>
          value 9.0 - min 1 - max 7 - low 3 - optimun 4.5  <br>

<h1> min 1 / max 7 / high 7 / low 4.5 </h1>
A <meter value="2.9" min="1" max="7" low="4.5" high="7" ></meter>
          value 2.9 - min 1 - max 7 - low 4.5 - optimun 7  <br>
B <meter value="3.3" min="1" max="7" low="4.5" high="7" ></meter>
          value 3.3 - min 1 - max 7 - low 4.5 - optimun 7 <br>
C <meter value="4.6" min="1" max="7" low="4.5" high="7" ></meter>
          value 4.6 - min 1 - max 7 - low 4.5 - optimun 7  <br>
D <meter value="7.0" min="1" max="7" low="4.5" high="7" ></meter>
          value 7.0 - min 1 - max 7 - low 4.5 - optimun 7  <br>
E <meter value="9.0" min="1" max="7" low="4.5" high="7" ></meter>
          value 9.0 - min 1 - max 7 - low 4.5 - optimun 7  <br>

<h1> min 1 / max 7 / high 7 / low 7 </h1>
A <meter value="2.9" min="1" max="7" low="7.0" high="7" ></meter>
          value 2.9 - min 1 - max 7 - low 7.0 - optimun 7  <br>
B <meter value="3.3" min="1" max="7" low="7.0" high="7" ></meter>
          value 3.3 - min 1 - max 7 - low 7.0 - optimun 7 <br>
C <meter value="4.6" min="1" max="7" low="7.0" high="7" ></meter>
          value 4.6 - min 1 - max 7 - low 7.0 - optimun 7  <br>
D <meter value="7.0" min="1" max="7" low="7.0" high="7" ></meter>
          value 7.0 - min 1 - max 7 - low 7.0 - optimun 7  <br>
E <meter value="9.0" min="1" max="7" low="7.0" high="7" ></meter>
          value 9.0 - min 1 - max 7 - low 7.0 - optimun 7  <br>
```

