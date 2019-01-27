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

package org.asqatasun.utils.contrastchecker;

import java.awt.Color;
import junit.framework.TestCase;
import org.junit.Test;  // Junit 4 anotation @Test

/**
 *
 * @author alingua
 */
public class ContrastCheckerTest extends TestCase {

    public ContrastCheckerTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    ///////////////////////////////////////////////////////////////////
    @Test
    public void testisContrastValidWhiteBlack() {
        Color colorA  = Color.WHITE;
        Color colorB  = Color.BLACK;
        float coef    = (float) 3.5;
        System.out.println("ContrastChecker - isContrastValid WhiteBlack : [WHITE] and [BLACK] for ["+  coef  +"] = TRUE");
        boolean result = ContrastChecker.isContrastValid(colorA, colorB, coef);
        assertTrue(result);
    }

    @Test
    public void testisContrastValidTwoGreenFail() {
        Color colorA  = new Color(70, 136, 71);     // #468847
        Color colorB  = new Color(223, 240, 216);   // #DFF0D8
        float coef    = (float) 4;
        System.out.println("ContrastChecker - isContrastValid TwoGreenFail : [#468847] and [#DFF0D8] for ["+  coef  +"] = FALSE");
        boolean result = ContrastChecker.isContrastValid(colorA, colorB, coef);
        assertFalse(result);
    }

    @Test
    public void testisContrastValidTwoGreenPass() {
        Color colorA  = new Color(70, 136, 71);     // #468847
        Color colorB  = new Color(223, 240, 216);   // #DFF0D8
        float coef    = (float) 3.5;
        System.out.println("ContrastChecker - isContrastValid TwoGreenPass : [#468847] and [#DFF0D8] for ["+  coef  +"] = TRUE");
        boolean result = ContrastChecker.isContrastValid(colorA, colorB, coef);
        assertTrue(result);
    }

    ///////////////////////////////////////////////////////////////////
    @Test
    public void testgetConstrastRatio5DigitRound() {
        Color colorA  = new Color(70, 136, 71);     // #468847
        Color colorB  = new Color(223, 240, 216);   // #DFF0D8
        Color colorC  = new Color(138, 157, 138);   // #8A9D8A
        Color colorD  = new Color(156, 239, 123);   // #9CEF7B
        double result = ContrastChecker.getConstrastRatio5DigitRound(colorA, colorB);
        System.out.println("getConstrastRatio5DigitRound : [#468847] and [#DFF0D8] = ["+  result  +"] ");
        assertEquals(3.61029, result, 0.00000001);

        result = ContrastChecker.getConstrastRatio5DigitRound(colorB, colorA);
        System.out.println("getConstrastRatio5DigitRound : [#DFF0D8] and [#468847] = ["+  result  +"] ");
        assertEquals(3.61029, result, 0.00000001);

        result = ContrastChecker.getConstrastRatio5DigitRound(colorC, colorD);
        System.out.println("getConstrastRatio5DigitRound : [#8A9D8A] and [#9CEF7B] = ["+  result  +"] ");
        assertEquals(2.0695, result, 0.00000001);  // 2.0695032962424893

        result = ContrastChecker.getConstrastRatio5DigitRound(colorD, colorC);
        System.out.println("getConstrastRatio5DigitRound : [#9CEF7B] and [#8A9D8A] = ["+  result  +"] ");
        assertEquals(2.06950, result, 0.00000001); // 2.0695032962424893
    }

    @Test
    public void testgetConstrastRatio2DigitRound() {
        Color colorA  = new Color(70, 136, 71);     // #468847
        Color colorB  = new Color(223, 240, 216);   // #DFF0D8
        Color colorC  = new Color(138, 157, 138);   // #8A9D8A
        Color colorD  = new Color(156, 239, 123);   // #9CEF7B
        double result = ContrastChecker.getConstrastRatio2DigitRound(colorA, colorB);
        System.out.println("getConstrastRatio2DigitRound : [#468847] and [#DFF0D8] = ["+  result  +"] ");
        assertEquals(3.61, result, 0.00000001);

        result = ContrastChecker.getConstrastRatio2DigitRound(colorB, colorA);
        System.out.println("getConstrastRatio2DigitRound : [#DFF0D8] and [#468847] = ["+  result  +"] ");
        assertEquals(3.61, result, 0.00000001);

        result = ContrastChecker.getConstrastRatio2DigitRound(colorC, colorD);
        System.out.println("getConstrastRatio2DigitRound : [#8A9D8A] and [#9CEF7B] = ["+  result  +"] ");
        assertEquals(2.07, result, 0.00000001); // 2.0695032962424893

        result = ContrastChecker.getConstrastRatio2DigitRound(colorD, colorC);
        System.out.println("getConstrastRatio2DigitRound : [#9CEF7B] and [#8A9D8A] = ["+  result  +"] ");
        assertEquals(2.07, result, 0.00000001); // 2.0695032962424893


    }
    ///////////////////////////////////////////////////////////////////
    @Test
    public void testDistanceColor() {
        Color colorA  = new Color(70, 136, 71); // #468847
        Color colorB  = new Color(66, 118, 69); // #427645
        float result = (float) ContrastChecker.distanceColor(colorA, colorB);
        System.out.println("DistanceColor : [#468847] and [#DFF0D8] = ["+  result  +"] ");
        assertEquals(18.547237, result, 0.000001);

        result =  (float) ContrastChecker.distanceColor(colorB, colorA);
        System.out.println("DistanceColor : [#468847] and [#DFF0D8] = ["+  result  +"] ");
        assertEquals(18.547237, result, 0.000001);

        colorA  = Color.WHITE;
        colorB  = new Color(192,192,192); // Silver
        result  =  (float) ContrastChecker.distanceColor(colorB, colorA);
        System.out.println("DistanceColor : [WHITE] and [silver] = ["+  result  +"] ");
        assertEquals(109.119201, result, 0.000001);

        colorA  = Color.BLACK;
        colorB  = Color.WHITE;
        result  =  (float) ContrastChecker.distanceColor(colorB, colorA);
        System.out.println("DistanceColor : [BLACK] and [WHITE] = ["+  result  +"] ");
        assertEquals(441.672943, result, 0.000001);
    }


    /**
     * Test of getConstrastRatio method, of class ContrastChecker.
     */
    @Test
    public void testGetConstrastRatio() {
        System.out.println("---- getConstrastRatio --------------");
        ///////////////////////////////////////////////////////////////////////
        Color fgColor = new Color(70, 136, 71);
        Color bgColor = new Color(223, 240, 216);
        double result = ContrastChecker.getConstrastRatio(bgColor, fgColor);
        System.out.println("result :" + result);
        assertEquals(3.6102927, result, 0.0000001);
        ///////////////////////////////////////////////////////////////////////
        fgColor = new Color(223, 240, 216);
        bgColor = new Color(70, 136, 71);
        result = ContrastChecker.getConstrastRatio(bgColor, fgColor);
        System.out.println("result :" + result);
        assertEquals(3.6102927, result, 0.0000001);
        ///////////////////////////////////////////////////////////////////////
        bgColor = new Color(255, 255, 255);
        fgColor = new Color(0, 0, 0);
        result = ContrastChecker.getConstrastRatio(fgColor, bgColor);
        System.out.println("result :" + result);
        assertEquals(21.0000000, result, 0.0000001);
        ///////////////////////////////////////////////////////////////////////
        fgColor = new Color(255, 53, 255);
        bgColor = new Color(18, 52, 95);
        result = ContrastChecker.getConstrastRatio(fgColor, bgColor);
        System.out.println("result :" + result);
        assertEquals(4.2833245, result, 0.0000001);
        ///////////////////////////////////////////////////////////////////////
        bgColor = new Color(255, 53, 255);
        fgColor = new Color(18, 52, 95);
        result = ContrastChecker.getConstrastRatio(fgColor, bgColor);
        System.out.println("result :" + result);
        assertEquals(4.2833245, result, 0.0000001);
        ///////////////////////////////////////////////////////////////////////
        bgColor = new Color(255, 255, 255);
        fgColor = new Color(255, 255, 255);
        result = ContrastChecker.getConstrastRatio(fgColor, bgColor);
        System.out.println("result :" + result);
        assertEquals(1.0000000, result, 0.0000001);
        ///////////////////////////////////////////////////////////////////////
        bgColor = new Color(53, 53, 53);
        fgColor = new Color(53, 53, 53);
        result = ContrastChecker.getConstrastRatio(fgColor, bgColor);
        System.out.println("result :" + result);
        assertEquals(1.0000000, result, 0.0000001);
    }
}
