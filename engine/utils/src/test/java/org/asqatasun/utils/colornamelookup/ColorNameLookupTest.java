/*
 * Contrast Finder
 * Copyright (C) 2008-2017   Asqatasun.org
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

package org.asqatasun.utils.colornamelookup;

import java.awt.Color;
import junit.framework.TestCase;

/**
 *
 */
public class ColorNameLookupTest extends TestCase {
    public ColorNameLookupTest(String testName) {
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
    //////////////////////////////////////////////////////


    // @@@TODO add test for getColorNameFromStr

    public void testGetColorFromNameWhite() {
        String colorStr = "white";
        System.out.println("GetColorFromNameWhite ["+ colorStr +"]");
        ColorNameLookup c = new ColorNameLookup();
        Color expResult = Color.WHITE;
        Color result    = c.getColorFromName(colorStr);
        assertEquals(expResult, result);
    }

    public void testGetColorFromNameSilver() {
        String colorStr = "silver";
        System.out.println("GetColorFromNameSilver ["+ colorStr +"]");
        ColorNameLookup c = new ColorNameLookup();
        Color expResult = new Color(192,192,192);
        Color result    = c.getColorFromName(colorStr);
        assertEquals(expResult, result);
    }

    public void testGetColorFromNameDarkMagenta() {
        String colorStr = "DarkMagenta";
        System.out.println("GetColorFromNameDarkMagenta ["+ colorStr +"]");
        ColorNameLookup c = new ColorNameLookup();
        Color expResult = new Color(139,0,139);
        Color result    = c.getColorFromName(colorStr);
        assertEquals(expResult, result);
    }

    public void testGetColorFromNameBadCaseWidthSpaces() {
        String colorStr = " darkmagenta   ";
        System.out.println("GetColorFromNameBadCaseWidthSpaces ["+ colorStr +"]");
        ColorNameLookup c = new ColorNameLookup();
        Color expResult = new Color(139,0,139);
        Color result    = c.getColorFromName(colorStr);
        assertEquals(expResult, result);
    }


}
