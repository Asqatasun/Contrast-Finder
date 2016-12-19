
# Howto use

## What is Asqatasun Contrast Finder ?

There are lot of tools to find a good contrast on the web, but no one to suggest valid contrasts.

Asqatasun Contrast Finder is a tool which computes the contrast between two colors (background, foreground) and checks if the contrast is valid.

Contrast finder is designed to be used by webdesigner, webdeveloppers or e-accessibility professionals.

When the contrast is not valid, the main target is to suggest some correct colors contrasts.

## How to use this tool ?

The interface is a form, with five fields.
![Screenshot - Contrast-Finder v0.3.5](images/screenshot--contrast-finder--v0.3.5--2016-12-19.png)

###   The foreground

It is the text color. You can fill in this field with an hexadecimal value.
i.e. #AABBCC color (Note that #ABC works also, we automatically complete the field with #AABBCC).
You can also use this field without the '#'character, so FFF or FFFFFF works perfectly.
The input value is then previewed on the right of the field.

###   The background

It is the background color.
This field works as the foreground fields.

###  Component to edit

It is either the foreground or the background. Default is foreground.
The component you choose will be modified until we find a valid color.
The other color won't change.

###  The ratio

Three possible values 3, 4.5 and 7.

All details about the contrast ratio :

* http://www.w3.org/TR/WCAG20/#visual-audio-contrast-contrast
* http://www.w3.org/TR/WCAG20/#contrast-ratiodef
* http://www.w3.org/TR/WCAG20/relative-luminance.xml

###  The algorithms

The first one is "valid colors". The result is a wide range of colors.
This algorithm is very helpful if you are not sure about the hue of your initial color.

The second one is "valid colors and very close to initial color". The result is a list of colors close to the original color. The aim is to have a valid color with a contrast as close to the selected ratio as possible (At the 0.001 range). 

More informations about  [the algorithms](The-algorithms.md) here.
