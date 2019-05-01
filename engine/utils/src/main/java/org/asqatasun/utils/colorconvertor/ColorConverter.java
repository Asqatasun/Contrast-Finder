/*
 * Contrast Finder
 * Copyright (C) 2008-2019   Contrast-Finder.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: asqatasun AT asqatasun DOT org
 */
package org.asqatasun.utils.colorconvertor;

import java.awt.Color;
import org.asqatasun.utils.colornamelookup.ColorNameLookup;

/**
 * @author alingua
 */
public final class ColorConverter {

    private static final int MAX_COMPONENT = 3;
    private static final int BRIGHTNESS = 2;
    private static final int SATURATION = 1;
    private static final int HUE = 0;
    private static final int R_BEGIN_COLOR = 0;
    private static final int G_BEGIN_COLOR = 2;
    private static final int B_BEGIN_COLOR = 4;
    private static final int RGB_HEXA_LENGTH = 6;
    private static final int RGB_SHORT_HEXA_LENGTH = 3;
    private static final int CONVERT_TO_BASE_16 = 16;
    private static final int MAX_ANGLE = 360;
    private static final int RGB_MIN = 0;
    private static final int RGB_MAX = 255;
    private static final int CONSTANT_SL_COMPONENTS_HUNDRED     = 100;
    private static final int CONSTANT_S_COMPONENTS_TWO_HUNDRED  = 200;
    private static final int CONSTANT_SL_COMPONENTS_TWO         = 2;
    private static final int CONSTANT_S_COMPONENTS_FIFTY        = 50;
    private static final String HEXADECIMAL_DICTIONNARY    = "[0-9A-Fa-f]+";   //  FFF,  FFFFFF
    private static final String HEXADECIMAL_DICTIONNARY_V2 = "^#?([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$"; // #FFF, #FFFFFF, FFF, FFFFFF (but not FF or FFFF)
    private static final String SHORT_RGB_DICTIONNARY      = "^[0-9]{1,3},[0-9]{1,3},[0-9]{1,3}$";          // ex: "255,255,255"
    private static final String RGB_DICTIONNARY            = "^rgb\\([0-9]{1,3},[0-9]{1,3},[0-9]{1,3}\\)?$"; // ex: "rgb(255,255,255)" and "rgb(255,255,255"

    /**
     * Private constructor, utility class
     */
    private ColorConverter() {
    }

    /**
     *
     * @param color
     * @param offsetHue
     * @param offsetSaturation
     * @param offsetBrightness
     * @return Color object
     */
    public static Color offsetHsbColor(Color color, float offsetHue, float offsetSaturation, float offsetBrightness) {
        float[] hsbValues = new float[MAX_COMPONENT];
        Float brightness;
        Float saturation;
        Float hue;

        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsbValues);

        // OFFSETING RSB VALUES
        hue = hsbValues[HUE] + offsetHue;
        saturation = hsbValues[SATURATION] + offsetSaturation;
        brightness = hsbValues[BRIGHTNESS] + offsetBrightness;
        return Color.getHSBColor(hue, saturation, brightness);
    }

    /**
     * @param color
     * @return the brightness (hsb) of the given color
     */
    public static Float getBrightness(Color color) {
        float[] hsbValues = new float[MAX_COMPONENT];
        Float brightness;
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsbValues);
        brightness = hsbValues[BRIGHTNESS];
        return brightness;
    }

    /**
     * @param color
     * @return the saturation (hsb) of the given color
     */
    public static Float getSaturation(Color color) {
        float[] hsbValues = new float[MAX_COMPONENT];
        Float saturation;
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsbValues);
        saturation = hsbValues[SATURATION];
        return saturation;
    }

    /**
     * @param color
     * @return the hue (hsb) of the given color
     */
    public static Float getHue(Color color) {
        float[] hsbValues = new float[MAX_COMPONENT];
        Float hue;
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsbValues);
        hue = hsbValues[HUE];
        return hue;
    }

    /**
     * @todo   check if offset* is valid for Color (ex: WHITE 255,255,255 with +10)
     * @todo   check if color is not null
     *
     * @param bgColor
     * @param offsetRed
     * @param offsetGreen
     * @param offsetBlue
     * @return Color object
     */
    public static Color offsetRgbColor(Color bgColor, int offsetRed, int offsetGreen, int offsetBlue) {
        return new Color(bgColor.getRed() + offsetRed, bgColor.getGreen() + offsetGreen, bgColor.getBlue() + offsetBlue);
    }

    /**
     * @param  colorStr ex: fff, FFF, #fff, #FFF, ffffff, rgb(255,255,255) or 255,255,255, color name (black, darkmagenta, ...)
     * @return color in hexadecimal, with '#' appended if necessary, in upper case
     */
    public static String formatColorStr(String colorStr) {
        String str = colorStr.replaceAll("\\s", ""); // replace ' ', \t, \n, ...
        if (str.toLowerCase().matches(RGB_DICTIONNARY)){  // ex: "rgb(255,255,255)" and "rgb(255,255,255"
            str = str.toLowerCase();
            if(!str.endsWith(")")){
                str = str + ")";
            }
        }
        else if(str.matches(SHORT_RGB_DICTIONNARY)){ // ex: "255,255,255"
            str = "rgb(" + str + ")";
        }
        else if(str.matches(HEXADECIMAL_DICTIONNARY_V2)) {
            if (str.charAt(0) != '#') {
                str = "#" + str;
            }
            str = str.toUpperCase();
        }
        else {
            ColorNameLookup c = new ColorNameLookup();
            String name  = c.getColorNameFromStr(str);
            String empty = "";
            if(!name.equals(empty)){
                str = name;
            }
        }
        return str;
    }


    /**
     * @param  colorStr ex: fff, FFF, #fff, #FFF, ffffff, rgb(255,255,255) or 255,255,255, color name (black, darkmagenta, ...)
     * @return Color object or NULL
     */
    public static Color colorFromStr(String colorStr) {
        Color  color = hex2Rgb(colorStr);
        if (color == null) {
            color = colorFromRgbStr(colorStr);
            if (color == null) {
                color = colorFromColorName(colorStr);
            }
        }
        return color;
    }


    /**
     * @param  colorStr color name (ex: silver, red, SteelBlue, ...)
     * @return Color object or NULL
     */
    public static Color colorFromColorName(String colorStr) {
        String str        = colorStr.replaceAll("\\s", ""); // replace ' ', \t, \n, ...
        ColorNameLookup c = new ColorNameLookup();
        return c.getColorFromName(str);
    }


    /**
     * @param  colorStr ex: rgb(255,255,255) or 255,255,255
     * @return Color object or NULL
     */
    public static Color colorFromRgbStr(String colorStr) {
        Color  color = null;
        String str   = colorStr.toLowerCase().replaceAll("\\s", ""); // replace ' ', \t, \n, ...
        if (str.matches(RGB_DICTIONNARY) | str.matches(SHORT_RGB_DICTIONNARY)){  // ex: rgb(255,255,255) or 255,255,255
            str = str.replaceAll("rgb\\(", "");
            str = str.replaceAll("\\)", "");
            String[] strList = str.split(",");
            int r = Integer.parseInt(strList[0]);
            int g = Integer.parseInt(strList[1]);
            int b = Integer.parseInt(strList[2]);
            if(     r <= RGB_MAX && g <= RGB_MAX && b <= RGB_MAX
                &&  r >= RGB_MIN && g >= RGB_MIN && b >= RGB_MIN){
                color = new Color(r, g, b);
            }
        }
        return color;
    }


    /**
     * @param colorStr color in short hexadecimal format, example: #FFF or #FFFFFF
     * @return the RGB Color from hex Color
     */
    public static Color hex2Rgb(String colorStr) {
        if(colorStr.length() > 0){
            if (colorStr.charAt(0) == '#') {
                String str = colorStr.substring(1);
                if (str.matches(HEXADECIMAL_DICTIONNARY)
                    && str.length() == RGB_HEXA_LENGTH) {
                    return getNewColor(str);
                } else if (str.matches(HEXADECIMAL_DICTIONNARY)
                    && str.length() == RGB_SHORT_HEXA_LENGTH) {
                    return getNewColorShortHexa(str);
                }
            } else if (colorStr.matches(HEXADECIMAL_DICTIONNARY)) {
                if (colorStr.length() == RGB_HEXA_LENGTH) {
                    return getNewColor(colorStr);
                } else if (colorStr.length() == RGB_SHORT_HEXA_LENGTH) {
                    return getNewColorShortHexa(colorStr);
                }
            }
        }
        return null;
    }

    /**
     * @param colorStr color in short hexadecimal format, example: #FFF
     * @return Color object
     */
    private static Color getNewColorShortHexa(String colorStr) {
        StringBuilder newColor = new StringBuilder();
        newColor.append(colorStr.charAt(0)).append(colorStr.charAt(0))
                .append(colorStr.charAt(1)).append(colorStr.charAt(1))
                .append(colorStr.charAt(2)).append(colorStr.charAt(2));
        return getNewColor(newColor.toString());
    }

    /**
     * @param colorStr
     * @return Color object
     */
    private static Color getNewColor(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(R_BEGIN_COLOR, G_BEGIN_COLOR), CONVERT_TO_BASE_16),
                Integer.valueOf(colorStr.substring(G_BEGIN_COLOR, B_BEGIN_COLOR), CONVERT_TO_BASE_16),
                Integer.valueOf(colorStr.substring(B_BEGIN_COLOR, RGB_HEXA_LENGTH), CONVERT_TO_BASE_16));
    }

    /**
     * @param color
     * @return color in RGB format, example: rgb(255, 255, 255)
     */
    public static String hex2Rgb(Color color) {
        Integer red = color.getRed();
        Integer green = color.getGreen();
        Integer blue = color.getBlue();
        return ("rgb(" + red.toString() + ", " + green.toString() + ", " + blue.toString() + ")");
    }

    /**
     * @param color
     * @return color in hexadecimal format, example: #FFFFFF
     */
    public static String rgb2Hex(Color color) {
        return (String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue())).toUpperCase();
    }


    /**
     * @param color
     * @return color in HSL format, example: hsl(0, 0%, 100%)
     */
    public static String rgb2Hsl(Color color) {
        float[] hsvTab = new float[MAX_COMPONENT];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsvTab);
        float h = hsvTab[HUE] * MAX_ANGLE;
        float l = (CONSTANT_SL_COMPONENTS_TWO - (hsvTab[SATURATION] * CONSTANT_SL_COMPONENTS_HUNDRED) / CONSTANT_SL_COMPONENTS_HUNDRED)
                * (hsvTab[BRIGHTNESS] * CONSTANT_SL_COMPONENTS_HUNDRED) / CONSTANT_SL_COMPONENTS_TWO;
        float s = (hsvTab[SATURATION] * CONSTANT_SL_COMPONENTS_HUNDRED) * (hsvTab[BRIGHTNESS] * CONSTANT_SL_COMPONENTS_HUNDRED)
                / (l < CONSTANT_S_COMPONENTS_FIFTY ? l * CONSTANT_SL_COMPONENTS_TWO : CONSTANT_S_COMPONENTS_TWO_HUNDRED - l * CONSTANT_SL_COMPONENTS_TWO);
        return ("hsl(" + Float.valueOf(h).intValue()
                + ", " + Float.valueOf(s).intValue() + "%"
                + ", " + Float.valueOf(l).intValue() + "%" + ")");
    }
}
