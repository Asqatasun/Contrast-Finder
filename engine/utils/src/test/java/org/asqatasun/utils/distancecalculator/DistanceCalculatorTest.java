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
package org.asqatasun.utils.distancecalculator;

//import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNotSame;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertSame;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;

import java.awt.Color;
import org.junit.Test;  // Junit 4 anotation @Test

/**
 * use Junit 4 syntax
 */
public class DistanceCalculatorTest {

    @Test
    public void testCalculateWhiteBlack() {
        Color colorA  = Color.WHITE;
        Color colorB  = Color.BLACK;
        System.out.println("DistanceCalculator - CalculateWhiteBlack : [WHITE] and [BLACK]");
        double result = DistanceCalculator.calculate(colorA, colorB);
        assertEquals(367.77, result, 0.001);
    }

    @Test
    public void testCalculateBlackWhite() {
        Color colorA  = Color.BLACK;
        Color colorB  = Color.WHITE;
        System.out.println("DistanceCalculator - CalculateBlackWhite : [BLACK] and [WHITE]");
        double result = DistanceCalculator.calculate(colorA, colorB);
        assertEquals(367.77, result, 0.001);
    }

    @Test
    public void testCalculateWhiteSilverRgb() {
        Color colorA  = Color.WHITE;
        Color colorB  = new Color(192,192,192); // Silver
        System.out.println("DistanceCalculator - CalculateWhiteSilverRgb : [WHITE] and [rgb(192,192,192) = SILVER]");
        double result = DistanceCalculator.calculate(colorA, colorB);
        assertEquals(90.86, result, 0.001);
    }

    @Test
    public void testCalculateTwoGreenRgb() {
        Color colorA  = new Color(70, 136, 71); // #468847
        Color colorB  = new Color(66, 118, 69); // #427645
        System.out.println("DistanceCalculator - CalculateTwoGreenRgb : [rgb(70, 136, 71) = #468847] and [rgb(66, 118, 69) = #427645]");
        double result = DistanceCalculator.calculate(colorA, colorB);
        assertEquals(18.07, result, 0.001);
    }

}
