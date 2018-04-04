
# The algorithms

## Valid colors

It is based on the HSV (hue, saturation, value) color's components.
The hue value ranges from 0 to 360. The saturation and brightness range from 0 to 100 percent.

Every component is modified of more or less 10 percent.

```java

Color computeHsvColor(Color initialColor, Color keptColor) {
  Color modifiedColor = initialColor;

  while (modifiedColor.getHue() < 360 && modifiedColor.getHue() > 0) {
     modifiedColor.setHue += 10%
     while (modifiedColor.getSaturation() < 100 && modifiedColor.getSaturation() > 0) {
             varySaturationAndTestColor(modifiedColor, +10%);
             varySaturationAndTestColor(modifiedColor, -10%);
        while (modifiedColor.getBrightness() < 100 && modifiedColor.getBrightness() > 0) {
                varyBrightnessAndTestColor(modifiedColor, +10%);
                varyBrightnessAndTestColor(modifiedColor, -10%);
        }
     }

     modifiedColor.setHue -= 10%
     while (modifiedColor.getSaturation() < 100 && modifiedColor.getSaturation() > 0) {
             varySaturationAndTestColor(modifiedColor, +10%);
             varySaturationAndTestColor(modifiedColor, -10%);
        while (modifiedColor.getBrightness() < 100 && modifiedColor.getBrightness() > 0) {
                varyBrightnessAndTestColor(modifiedColor, +10%);
                varyBrightnessAndTestColor(modifiedColor, -10%);
        }
     }
  }
  return (modifiedColor);
}

Color varySaturationAndTestColor(Color modifiedColor, int variation) {
  modifiedColor.setSaturation(variation);
  testContrast(modifiedColor, keptColor);
  return modifiedColor;
}

Color varyBrightnessAndTestColor(Color modifiedColor, int variation) {
  modifiedColor.setBrightness(variation);
  testContrast(modifiedColor, keptColor);
  return modifiedColor;
}
```


Each component is modified until a valid contrast is found.

For example : a color with this components : Hue (36), Saturation (32%), Brightness (45%), can be modify to obtain : Hue (72), Saturation (42%), Brightness (55%) or Hue (0), Saturation (22%), Brightness (35%), etc.

Then, we test the contrast between each modified color against the initial one. If the contrast is valid, the modified color is stored in the results table.


## Valid colors and very close to initial color

It is based on the RGB (red, green, blue) color's components. Like the first algorithm, each component is modified until we find a valid contrast.

The red, green and blue values must be between 0 and 255.

For this algorithm, the principle is similar to the first one. After many tests, we have identified the following constraints :
* The component's step in one loop. We have decided to step the component values one by one.
* The max shift for one component. We have decided to limit the maximum shift :
   - to 60 when the gap between initial contrast ratio and the choosen contrast ratio is between 0 and 1
   - to 80 when the gap between initial contrast ratio and the choosen contrast ratio is between 1 and 2
   - to 110 when the gap between initial contrast ratio and the choosen contrast ratio is between 2 and 3
* The hue bounder, set to 5%. Its aim is to limit the hue. If the initial color (to modify) is blue, we don't want to suggest a green, so we stay close to the initial hue.
* The maximum coefficient. Its target is to limit the contrast ratio. For instance, if the selected ratio is 4.5, we want color that are 4.5 + this maximum coefficient. The value we chose is 0.001 (thus a color must have a ratio between 4.5 and 4.501, which is very very closed, but also what we want).

For example : an initial color with this components : Red (35), Green (74), Blue (87) is limited between : Red (0-95), Green (14-134), Blue (27-147). The initial color's hue is 194. The hue bounder will limit the result's hue between  146 and 212 (194 +- 5%). In this example, the initial color is the foreground and its background is black, the contrast ratio is 2.1886. If you want a ratio 3, the maximum shift is 60 (3 - 2.1886 < 1), the maximum coefficient limit the result between 3 and 3.001.
