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
import junit.framework.TestCase;
import org.junit.Test;  // Junit 4 anotation @Test

/**
 *
 * @author alingua
 */
public class ColorConverterTest extends TestCase {

    public ColorConverterTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of offsetHsbColor method, of class ColorConverter.
     */
//    @Test
//    public void testOffsetHsbColor() {
//        System.out.println("offsetHsbColor");
//        Color bgColor = null;
//        float offsetHue = 0.0F;
//        float offsetSaturation = 0.0F;
//        float offsetBrightness = 0.0F;
//        Color expResult = null;
//        Color result = ColorConverter.offsetHsbColor(bgColor, offsetHue, offsetSaturation, offsetBrightness);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setBrightnessToColor method, of class ColorConverter.
//     */
//    @Test
//    public void testSetBrightnessToColor() {
//        System.out.println("setBrightnessToColor");
//        Float Brightness = null;
//        Color color = null;
//        Color expResult = null;
//        Color result = ColorConverter.setBrightnessToColor(Brightness, color);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of getBrightness method, of class ColorConverter.
     */
    @Test
    public void testGetBrightness() {
        System.out.println("---- getBrightness -----");

        Color colorA    = Color.BLACK;
        Float expResult = (float) 0.0;
        Float result = ColorConverter.getBrightness(colorA);
        System.out.println("BLACK - Brightness: ["+ result +"]");
        assertEquals(expResult, result);

        colorA    = Color.WHITE;
        expResult = (float) 1.0;
        result = ColorConverter.getBrightness(colorA);
        System.out.println("WHITE - Brightness: ["+ result +"]");
        assertEquals(expResult, result);

        colorA    = new Color(70, 136, 71); // #468847 = rgb(70, 136, 71) = hsl(120, 32%, 40%)
        expResult = (float) 0.53333336;
        result = ColorConverter.getBrightness(colorA);
        System.out.println("rgb(70, 136, 71) - Brightness: ["+ result +"]");
        assertEquals(expResult, result);
    }



    /**
     * Test of getSaturation method, of class ColorConverter.
     */
    @Test
    public void testGetSaturation() {
        System.out.println("---- getSaturation -----");

        Color colorA    = Color.BLACK;
        Float expResult = (float) 0.0;
        Float result = ColorConverter.getSaturation(colorA);
        System.out.println("BLACK - Saturation: ["+ result +"]");
        assertEquals(expResult, result);

        colorA    = Color.WHITE;
        expResult = (float) 0.0;
        result = ColorConverter.getSaturation(colorA);
        System.out.println("WHITE - Saturation: ["+ result +"]");
        assertEquals(expResult, result);

        colorA    = new Color(70, 136, 71); // #468847 = rgb(70, 136, 71) = hsl(120, 32%, 40%)
        expResult = (float) 0.4852941;
        result = ColorConverter.getSaturation(colorA);
        System.out.println("rgb(70, 136, 71) - Saturation: ["+ result +"]");
        assertEquals(expResult, result);

    }

    /**
     * Test of getHue method, of class ColorConverter.
     */
    @Test
    public void testGetHue() {
        System.out.println("---- getHue -----");

        Color colorA    = Color.BLACK;
        Float expResult = (float) 0.0;
        Float result = ColorConverter.getHue(colorA);
        System.out.println("BLACK - Hue: ["+ result +"]");
        assertEquals(expResult, result);

        colorA    = Color.WHITE;
        expResult = (float) 0.0;
        result = ColorConverter.getHue(colorA);
        System.out.println("WHITE - Hue: ["+ result +"]");
        assertEquals(expResult, result);

        colorA    = new Color(70, 136, 71); // #468847 = rgb(70, 136, 71) = hsl(120, 32%, 40%)
        expResult = (float) 0.33585858;
        result = ColorConverter.getHue(colorA);
        System.out.println("rgb(70, 136, 71) - Hue: ["+ result +"]");
        assertEquals(expResult, result);
    }


    /**
     * Test of getHue method, of class ColorConverter.
     */
    @Test
    public void testGetHueOld() {
      //  System.out.println("getHue");
      //  Color bgColor = new Color(128, 127, 127);
      //  Color result = ColorConverter.offsetHsbColor(bgColor, Float.valueOf(0.1f), Float.valueOf(0.0f), Float.valueOf(0.0f));
      //  System.out.println(result.toString());
      //  System.out.println("Hue : " + result);
    }

    /**
     * Test of offsetRgbColor method, of class ColorConverter.
     */
    @Test
    public void testOffsetRgbColor() {
        System.out.println("---------- offsetRgbColor ----------------");
        Color colorA;
        Color expResult;
        Color result;
        int   offsetRed;
        int   offsetGreen;
        int   offsetBlue;

        colorA = Color.BLACK;
        offsetRed   = 10;
        offsetGreen = 20;
        offsetBlue  = 30;
        expResult   = new Color(10, 20, 30);
        result      = ColorConverter.offsetRgbColor(colorA, offsetRed, offsetGreen, offsetBlue);
        System.out.println("OffsetRgbColor BLACK   + ["+ offsetRed  +", "+ offsetGreen +", "+ offsetBlue +"] = " + result.toString());
        assertEquals(expResult, result);

        colorA = new Color(70, 136, 71); // #468847
        offsetRed   = 100;
        offsetGreen = 100;
        offsetBlue  = 100;
        expResult   = new Color(170, 236, 171);
        result      = ColorConverter.offsetRgbColor(colorA, offsetRed, offsetGreen, offsetBlue);
        System.out.println("OffsetRgbColor #468847 + ["+ offsetRed  +", "+ offsetGreen +", "+ offsetBlue +"] = " + result.toString());
        assertEquals(expResult, result);

        colorA = Color.WHITE;
        offsetRed   = -10;
        offsetGreen = -20;
        offsetBlue  = -30;
        expResult   = new Color(245,235,225);
        result      = ColorConverter.offsetRgbColor(colorA, offsetRed, offsetGreen, offsetBlue);
        System.out.println("OffsetRgbColor WHITE   + ["+ offsetRed  +", "+ offsetGreen +", "+ offsetBlue +"] = " + result.toString());
        assertEquals(expResult, result);

        colorA = Color.WHITE;
        offsetRed   = 0;
        offsetGreen = 0;
        offsetBlue  = 0;
        expResult   = new Color(255,255,255);
        result      = ColorConverter.offsetRgbColor(colorA, offsetRed, offsetGreen, offsetBlue);
        System.out.println("OffsetRgbColor WHITE   + ["+ offsetRed  +", "+ offsetGreen +", "+ offsetBlue +"] = " + result.toString());
        assertEquals(expResult, result);

        System.out.println("--------------------------");
    }


    /**
     * Test of offsetRgbColor method, of class ColorConverter.
     *
     * @todo   check if offset* is valid for Color (ex: WHITE 255,255,255 with +10)
     * @todo   check if color is not null
     */
    @Test
    public void testOffsetRgbColorBadValue() {
        System.out.println("---------- offsetRgbColor BAD Value ----------------");
        System.out.println(" ------> @todo   check if offset* is valid for Color (ex: WHITE 255,255,255 with +10)");
        System.out.println("------> @todo   check if color is not null");
        Color colorA;

        Color result;
        int   offsetRed;
        int   offsetGreen;
        int   offsetBlue;

        colorA = null;
        offsetRed   = 10;
        offsetGreen = 0;
        offsetBlue  = 0;
        // result      = ColorConverter.offsetRgbColor(colorA, offsetRed, offsetGreen, offsetBlue);
        // ---------> java.lang.NullPointerException
        //            ------> @todo   check if color is not null

        colorA = Color.WHITE;
        offsetRed   = 10;
        offsetGreen = 0;
        offsetBlue  = 0;
        // result      = ColorConverter.offsetRgbColor(colorA, offsetRed, offsetGreen, offsetBlue);
        // ---------> color parameter outside of expected range:
        //            ------> @todo   check if offset* is valid for Color (ex: WHITE 255,255,255 with +10)

        System.out.println("--------------------------");
    }




// formatColor()
/////////////////////////////////////////////////////////////////////
    @Test
    public void testFormatColorStrRgbLastParenthesisIsMissing() {
        String expResult = "rgb(255,255,255)";
        String colorStr  = "rgb(255,255,255"; // # must be added
        System.out.println("formatColorStr - RgblastParenthesisIsMissing ["+ colorStr  +"]");
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);

        colorStr  = " rgb( 255, 255, 255  "; // # must be added
        System.out.println("formatColorStr - RgblastParenthesisIsMissing ["+ colorStr  +"]");
        result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrRgbToLowerCase() {
        System.out.println("fformatColorStr - RgbToLowerCase [RGB(255,255,255)]");
        String colorStr  = "RGB(255,255,255)";
        String expResult = "rgb(255,255,255)";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrRgb() {
        System.out.println("formatColorStr - Rgb [ rgb( 255, 255, 255 ) ]");
        String colorStr  = " rgb( 255, 255, 255 ) ";
        String expResult = "rgb(255,255,255)";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }


    @Test
    public void testFormatColorStrRgbShortWidthSpace() {
        System.out.println("formatColorStr - RgbShortWidthSpace [ 255, 255, 255  ]");
        String colorStr  = " 255, 255, 255  ";
        String expResult = "rgb(255,255,255)";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrRgbShort() {
        System.out.println("formatColorStr - RgbShort [255,255,255]");
        String colorStr  = "255,255,255";
        String expResult = "rgb(255,255,255)";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrNotValidHex() {
        System.out.println("formatColorStr - NotValidHex [Ff]");
        String colorStr  = "Ff"; // # must be added
        String expResult = "Ff";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrNotValidHex2() {
        System.out.println("formatColorStr - NotValidHex2 [FfFf]");
        String colorStr  = "FfFf"; // # must be added
        String expResult = "FfFf";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrNotValidHexLetter2() {
        System.out.println("formatColorStr - NotValidHexLetter2 [#ZzZ]");
        String colorStr  = "#ZzZ"; // # must be added
        String expResult = "#ZzZ";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrNotValidHexLetter() {
        System.out.println("formatColorStr - NotValidHexLetter [ZzZ]");
        String colorStr  = "ZzZ"; // # must be added
        String expResult = "ZzZ";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrHexAddHash() {
        System.out.println("formatColorStr - HexAddHash [000000]");
        String colorStr  = "000000"; // # must be added
        String expResult = "#000000";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrHexNotAddHash() {
        System.out.println("formatColorStr - HexNotAddHash [#000000]");
        String colorStr  = "#000000"; // # must not be added
        String expResult = "#000000";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrHexTrim() {
        System.out.println("formatColorStr - HexTrim [ #000000 ]");
        String colorStr  = " #000000 ";
        String expResult = "#000000";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrHexToUpperCase() {
        System.out.println("formatColorStr - HexToUpperCase [#ffffff]");
        String colorStr  = "#ffffff";
        String expResult = "#FFFFFF";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrHex() {
        System.out.println("formatColorStr - Hex [ ffffff ]");
        String colorStr  = " ffffff ";
        String expResult = "#FFFFFF";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrNameBadCase() {
        System.out.println("formatColorStr - Name [ wHite ]");
        String colorStr  = " wHite ";
        String expResult = "White";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrNameWithSpace() {
        System.out.println("formatColorStr - Name [ dark magenta ]");
        String colorStr  = " dark magenta ";
        String expResult = "DarkMagenta";
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatColorStrBadName() {
        System.out.println("formatColorStr - BadName [wHite_BadName]");
        String colorStr  = "wHite_BadName";
        String expResult = colorStr;
        String result    = ColorConverter.formatColorStr(colorStr);
        assertEquals(expResult, result);
    }


// Color  colorFromRgbStr()
/////////////////////////////////////////////////////////////////////

    @Test
    public void testColorFromRgbStrBadFormat() {
        String colorStr = "#255,0,0";
        System.out.println("colorFromRgbStrBadRedValue ["+ colorStr +"]");
        Color expResult = null;
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testColorFromRgbStrBadValue() {
        String colorStr = "-1, 0, 0";
        System.out.println("colorFromRgbStrBadValue ["+ colorStr +"]");
        Color expResult = null;
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testColorFromRgbStrBadRedValue() {
        String colorStr = "256, 0, 0";
        System.out.println("colorFromRgbStrBadRedValue ["+ colorStr +"]");
        Color expResult = null;
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testColorFromRgbStrBadGreenValue() {
        String colorStr = "0, 256, 0";
        System.out.println("colorFromRgbStrBadGreenValue ["+ colorStr +"]");
        Color expResult = null;
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testColorFromRgbStrBadBlueValue() {
        String colorStr = "0, 0, 256";
        System.out.println("colorFromRgbStrBadBlueValue ["+ colorStr +"]");
        Color expResult = null;
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testColorFromRgbStr() {
        String colorStr = " rgb(175, 175, 175) ";
        System.out.println("colorFromRgbStr ["+ colorStr +"]");
        Color expResult = new Color(175,175,175);
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testColorFromRgbStrShort() {
        String colorStr = "175, 175, 175";
        System.out.println("colorFromRgbStrShort ["+ colorStr +"]");
        Color expResult = new Color(175,175,175);
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testColorFromRgbStrBlack() {
        String colorStr = "rgb(0,0,0)";
        System.out.println("colorFromRgbStrBlack ["+ colorStr +"]");
        Color expResult = Color.BLACK;
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testColorFromRgbStrWhite() {
        String colorStr = "rgb(255,255,255)";
        System.out.println("colorFromRgbStrWhite ["+ colorStr +"]");
        Color expResult = Color.WHITE;
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testColorFromRgbStrPink() {
        String colorStr = "rgb(255,175,175)";
        System.out.println("colorFromRgbStrPink ["+ colorStr +"]");
        Color expResult = Color.PINK;
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testColorFromRgbStrBlackShort() {
        String colorStr = "0,0,0";
        System.out.println("colorFromRgbStrBlackShort ["+ colorStr +"]");
        Color expResult = Color.BLACK;
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testColorFromRgbStrWhiteShort() {
        String colorStr = "255,255,255";
        System.out.println("colorFromRgbStrWhiteShort ["+ colorStr +"]");
        Color expResult = Color.WHITE;
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }

    @Test
    public void testColorFromRgbStrPinkShort() {
        String colorStr = "255,175,175";
        System.out.println("colorFromRgbStrPinkShort ["+ colorStr +"]");
        Color expResult = Color.PINK;
        Color result = ColorConverter.colorFromRgbStr(colorStr);
        assertEquals(expResult, result);
    }


//  String hex2Rgb(Color color)
/////////////////////////////////////////////////////////////////////

    /**
     * Test of hex2Rgb method, of class ColorConverter.
     *      String hex2Rgb(Color color)
     */
    @Test
    public void testHex2RgbColor() {
        System.out.println("---- Hex2Rgb_color --------------------");
        Color  colorA;
        String expResult;
        String result;

        colorA  = Color.WHITE;
        System.out.println("hex2Rgb [Color.WHITE]");
        expResult = "rgb(255, 255, 255)";
        result    = ColorConverter.hex2Rgb(colorA);
        assertEquals(expResult, result);

        colorA  = Color.BLACK;
        System.out.println("hex2Rgb [Color.BLACK]");
        expResult = "rgb(0, 0, 0)";
        result    = ColorConverter.hex2Rgb(colorA);
        assertEquals(expResult, result);

        System.out.println("--------------------------");
    }


//  Color hex2Rgb(String colorStr)
/////////////////////////////////////////////////////////////////////

    /**
     * Test of hex2Rgb method, of class ColorConverter.
     *      Color hex2Rgb(String colorStr)
     */
    @Test
    public void testHex2RgbStr() {
        System.out.println("---- Hex2RgbStr --------------------");
        String colorStr = "FFFFFF";
        System.out.println("hex2Rgb string ["+ colorStr +"]");
        Color expResult = Color.WHITE;
        Color result    = ColorConverter.hex2Rgb(colorStr);
        assertEquals(expResult, result);

        colorStr = "FFF";
        System.out.println("hex2Rgb string ["+ colorStr +"]");
        expResult = Color.WHITE;
        result    = ColorConverter.hex2Rgb(colorStr);
        assertEquals(expResult, result);

        colorStr = "#FFFFFF";
        System.out.println("hex2Rgb string ["+ colorStr +"]");
        expResult = Color.WHITE;
        result    = ColorConverter.hex2Rgb(colorStr);
        assertEquals(expResult, result);

        colorStr = "#FFF";
        System.out.println("hex2Rgb string ["+ colorStr +"]");
        expResult = Color.WHITE;
        result    = ColorConverter.hex2Rgb(colorStr);
        assertEquals(expResult, result);

        System.out.println("--------------------------");
    }

    public void testHex2RgbStrBadValue() {
        System.out.println("---- Hex2RgbStrBadValue --------------------");
        String colorStr = "";
        Color result    = null;

        colorStr  = "";
        System.out.println("hex2Rgb string ["+ colorStr +"]");
        result    = ColorConverter.hex2Rgb(colorStr);
        assertNull(result);

        colorStr = "#ZZZ";
        System.out.println("hex2Rgb string ["+ colorStr +"]");
        result    = ColorConverter.hex2Rgb(colorStr);
        assertNull(result);

        colorStr = "ZZZ";
        System.out.println("hex2Rgb string ["+ colorStr +"]");
        result    = ColorConverter.hex2Rgb(colorStr);
        assertNull(result);

        colorStr = "#FF";
        System.out.println("hex2Rgb string ["+ colorStr +"]");
        result    = ColorConverter.hex2Rgb(colorStr);
        assertNull(result);

        colorStr = "FF";
        System.out.println("hex2Rgb string ["+ colorStr +"]");
        result    = ColorConverter.hex2Rgb(colorStr);
        assertNull(result);

        colorStr = "#FFFF";
        System.out.println("hex2Rgb string ["+ colorStr +"]");
        result    = ColorConverter.hex2Rgb(colorStr);
        assertNull(result);

        colorStr = "FFFF";
        System.out.println("hex2Rgb string ["+ colorStr +"]");
        result    = ColorConverter.hex2Rgb(colorStr);
        assertNull(result);

        System.out.println("--------------------------");
    }



// String   rgb2Hex()
/////////////////////////////////////////////////////////////////////

    @Test
    public void testRgb2hexBlack() {
        System.out.println("Rgb2hexBlack");
        Color color = Color.BLACK;
        String expResult = "#000000";
        String result = ColorConverter.rgb2Hex(color);
        assertEquals(expResult, result);
    }

    @Test
    public void testRgb2hexWhite() {
        System.out.println("Rgb2hexWhite");
        Color color = Color.WHITE;
        String expResult = "#FFFFFF";
        String result = ColorConverter.rgb2Hex(color);
        assertEquals(expResult, result);
    }

    @Test
    public void testRgb2hexPink() {
        System.out.println("Rgb2hexPink");
        Color color = Color.PINK;
        String expResult = "#FFAFAF";
        String result = ColorConverter.rgb2Hex(color);
        assertEquals(expResult, result);
    }

// String   rgb2Hsl()
/////////////////////////////////////////////////////////////////////

    @Test
    public void testRgb2Hsl() {
        System.out.println("------------ rgb2Hsl ----------------");
        Color  colorA;
        String result;
        String expResult;

        colorA    = Color.BLACK;
        result    = ColorConverter.rgb2Hsl(colorA);
        expResult = "hsl(0, 0%, 0%)";
        assertEquals(expResult, result);
        System.out.println("rgb2Hsl BLACK   to ["+ expResult +"]");

        colorA    = Color.WHITE;
        result    = ColorConverter.rgb2Hsl(colorA);
        expResult = "hsl(0, 0%, 100%)";
        System.out.println("rgb2Hsl WHITE   to ["+ expResult +"]");
        assertEquals(expResult, result);

        colorA  = new Color(70, 136, 71); // #468847
        result    = ColorConverter.rgb2Hsl(colorA);
        expResult = "hsl(120, 32%, 40%)";
        System.out.println("rgb2Hsl #468847 to ["+ expResult +"]");
        assertEquals(expResult, result);

        System.out.println("--------------------------");
    }


//   colorFromStr
/////////////////////////////////////////////////////////////////////

    @Test
    public void testColorFromStr() {
        System.out.println("------------ ColorFromStr ----------------");
        String  colorStr;
        Color   result;
        Color   expResult;

        colorStr  = "#FFF";
        expResult = Color.WHITE;
        result    = ColorConverter.colorFromStr(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromStr ["+ colorStr +"]");

        colorStr  = "#FFFFFF";
        expResult = Color.WHITE;
        result    = ColorConverter.colorFromStr(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromStr ["+ colorStr +"]");

        colorStr  = "FFF";
        expResult = Color.WHITE;
        result    = ColorConverter.colorFromStr(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromStr ["+ colorStr +"]");

        colorStr  = "FFFFFF";
        expResult = Color.WHITE;
        result    = ColorConverter.colorFromStr(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromStr ["+ colorStr +"]");

        colorStr  = "rgb(255,255,255)";
        expResult = Color.WHITE;
        result    = ColorConverter.colorFromStr(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromStr ["+ colorStr +"]");

        colorStr  = "rgb(139,0,139";
        expResult = new Color(139,0,139);
        result    = ColorConverter.colorFromStr(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromStr ["+ colorStr +"]");

        colorStr  = "139,0,139";
        expResult = new Color(139,0,139);
        result    = ColorConverter.colorFromStr(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromStr ["+ colorStr +"]");

        colorStr  = " wHite   ";
        expResult = Color.WHITE;
        result    = ColorConverter.colorFromStr(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromStr ["+ colorStr +"]");

        colorStr  = " BlaCK   ";
        expResult = Color.BLACK;
        result    = ColorConverter.colorFromStr(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromStr ["+ colorStr +"]");

        colorStr  = "darkmagenta";
        expResult = new Color(139,0,139);
        result    = ColorConverter.colorFromStr(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromStr ["+ colorStr +"]");

        System.out.println("--------------------------");
    }

    @Test
    public void testColorFromStrBadValue() {
        System.out.println("------------ ColorFromStr BAD value ----------------");
        String  colorStr;
        Color   result;
        Color   expResult;

        colorStr  = "256,0,0";
        result    = ColorConverter.colorFromColorName(colorStr);
        assertNull(result);
        System.out.println("colorFromColorName BAD value ["+ colorStr +"]");

        colorStr  = "rgb(256,0,0)";
        result    = ColorConverter.colorFromColorName(colorStr);
        assertNull(result);
        System.out.println("colorFromColorName BAD value ["+ colorStr +"]");

        colorStr  = "rgb(256,0,0";
        result    = ColorConverter.colorFromColorName(colorStr);
        assertNull(result);
        System.out.println("colorFromColorName BAD value ["+ colorStr +"]");

        colorStr  = "FF";
        result    = ColorConverter.colorFromColorName(colorStr);
        assertNull(result);
        System.out.println("colorFromColorName BAD value ["+ colorStr +"]");

        colorStr  = "FFFFFFFFFFFFF";
        result    = ColorConverter.colorFromColorName(colorStr);
        assertNull(result);
        System.out.println("colorFromColorName BAD value ["+ colorStr +"]");

        colorStr  = "#FF";
        result    = ColorConverter.colorFromColorName(colorStr);
        assertNull(result);
        System.out.println("colorFromColorName BAD value ["+ colorStr +"]");

        colorStr  = "#FFFFFFFFFFFFF";
        result    = ColorConverter.colorFromColorName(colorStr);
        assertNull(result);
        System.out.println("colorFromColorName BAD value ["+ colorStr +"]");

        colorStr  = "badColorName_WHITE";
        result    = ColorConverter.colorFromColorName(colorStr);
        assertNull(result);
        System.out.println("colorFromColorName BAD value ["+ colorStr +"]");

        colorStr  = "";
        result    = ColorConverter.colorFromColorName(colorStr);
        assertNull(result);
        System.out.println("colorFromColorName BAD value ["+ colorStr +"]");

        System.out.println("--------------------------");
    }

//   colorFromColorName()
/////////////////////////////////////////////////////////////////////

    @Test
    public void testColorFromColorName() {
        System.out.println("------------ colorFromColorName ----------------");
        String  colorStr;
        Color   result;
        Color   expResult;

        colorStr  = " wHite   ";
        expResult = Color.WHITE;
        result    = ColorConverter.colorFromColorName(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromColorName ["+ colorStr +"]");

        colorStr  = " BlaCK   ";
        expResult = Color.BLACK;
        result    = ColorConverter.colorFromColorName(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromColorName ["+ colorStr +"]");

        colorStr  = "darkmagenta";
        expResult = new Color(139,0,139);
        result    = ColorConverter.colorFromColorName(colorStr);
        assertEquals(expResult, result);
        System.out.println("colorFromColorName ["+ colorStr +"]");

        System.out.println("--------------------------");
    }

    @Test
    public void testColorFromColorNameBadValue() {
        System.out.println("------------ colorFromColorName BAD value----------------");
        String  colorStr;
        Color   result;

        colorStr  = "badColorName_WHITE";
        result    = ColorConverter.colorFromColorName(colorStr);
        assertNull(result);
        System.out.println("colorFromColorName BAD value ["+ colorStr +"]");

        colorStr  = "";
        result    = ColorConverter.colorFromColorName(colorStr);
        assertNull(result);
        System.out.println("colorFromColorName BAD value ["+ colorStr +"]");

        System.out.println("--------------------------");
    }




}
