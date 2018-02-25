
# Howto use

## What is Contrast Finder?

* Contrast Finder is a tool which computes the contrast between two colors (background, foreground) and checks if the contrast is valid.
* When the contrast is not valid, the main target is to suggest some correct colors contrasts.

Contrast finder is designed to be used by webdesigners, webdeveloppers or e-accessibility professionals.

## How to use this tool?

The interface is a form, with five fields.
![Screenshot - Contrast-Finder v0.5.2](images/screenshot/screenshot.EN_contrast-finder.v0.5.2_2017-07-27_grey_kraken.io-lossy.png)

## Text color

It is the foreground color. You can fill in this field with an hexadecimal value.
i.e. #AABBCC color (Note that #ABC works also, we automatically complete the field with #AABBCC).
You can also use this field without the '#'character, so FFF or FFFFFF works perfectly.
The input value is then previewed on the right of the field.

## Background color

This field works just like the text color field.

## Minimum ratio

Three possible values 3, 4.5 and 7.

How to choose a ratio? It depends on the following elements:

* Level of accessibility wanted: AA or AAA.
* Size of the text.
* Is the text bold or not?

### Level AA

Two elements (size and bold) gives four combinations:

* Text not bold + text size < 18px => ratio = 4.5
* Text bold + text size < 14px => ratio = 4.5
* Text not bold + text size > 18px => ratio = 3
* Text bold + text size > 14px => ratio = 3

### Level AAA

For level AAA the logic is the same, only the ratios increase in the the following way:

* 4.5 ratio becomes 7
* 3 ratio becomes 4.5

Which gives extensively the following:

* Text not bold + text size < 18px => ratio = 7
* Text bold + text size < 14px => ratio = 7
* Text not bold + text size > 18px => ratio = 4.5
* Text bold + text size > 14px => ratio = 4.5

### Text size understanding

* The 14px criteria can be understood as equivalent of 14pt or 120% or 1.2em
* The 18px criteria can be understood as equivalent of 18pt or 150% or 1.5em

For a full and exhaustive understanding of how to interpret text size, one should read the [defintion of large-scale text from WCAG](https://www.w3.org/TR/WCAG20/#larger-scaledef)

### Other info

All details about the contrast ratio:

* https://www.w3.org/TR/WCAG20/#visual-audio-contrast-contrast
* https://www.w3.org/TR/WCAG20/#contrast-ratiodef
* https://www.w3.org/TR/WCAG20/relative-luminance.xml

## Color to edit

It is either the text or background color. Default is text color.
The component you choose will be modified until we find a valid color.
The other color won't change.

##  Gimme/The algorithms

The first value is "Valid colors and very close to initial color". The result is a list of colors close to the original color. The aim is to have a valid color with a contrast as close to the selected ratio as possible (At the 0.001 range).

The second value is "A range of valid colors". The result is a wide range of colors.
This algorithm is very helpful if you are not sure about the hue of your initial color. 

More informations about [the algorithms](The-algorithms.md) here.


