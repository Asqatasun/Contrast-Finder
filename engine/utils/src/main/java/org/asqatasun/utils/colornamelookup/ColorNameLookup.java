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
package org.asqatasun.utils.colornamelookup;

import java.awt.Color;
import java.util.ArrayList;

public class ColorNameLookup {

    private  ArrayList<ColorName> colorList;
    public ColorNameLookup() {
        this.colorList = initColorList();
    }

    /**
     * @param colorStr  color name  (ex: silver, darkmagenta, SIVLER, ...)
     * @return empty or color name width correct case (ex: Silver, DarkMagenta, Silver, ...)
     */
    public String getColorNameFromStr(String colorStr) {
        String str = colorStr.trim();
        for (ColorName c : colorList) {
            if (c.getName().equalsIgnoreCase(str)) {
                return c.getName();
            }
        }
        return "";
    }

    /**
     * @param colorStr color name  (ex: red, silver, DarkMagenta, BLACK, ...)
     * @return Color object or NULL
     */
    public Color getColorFromName(String colorStr) {
        String str = colorStr.trim();
        for (ColorName c : colorList) {
            if (c.getName().equalsIgnoreCase(str)) {
                return new Color(c.getRed(), c.getGreen(), c.getBlue());
            }
        }
        return null;
    }


    /**
     * Initialize the color list
     *      https://developer.mozilla.org/fr/docs/Web/CSS/Type_color
     *      https://www.w3schools.com/colors/colors_names.asp
     *      http://htmlcolorcodes.com/fr/noms-de-couleur/
     */
    private ArrayList<ColorName> initColorList() {
        ArrayList<ColorName> colors = new ArrayList<ColorName>();
        colors.add(new ColorName("AliceBlue", 0xF0, 0xF8, 0xFF));
        colors.add(new ColorName("AntiqueWhite", 0xFA, 0xEB, 0xD7));
        colors.add(new ColorName("Aqua", 0x00, 0xFF, 0xFF));
        colors.add(new ColorName("Aquamarine", 0x7F, 0xFF, 0xD4));
        colors.add(new ColorName("Azure", 0xF0, 0xFF, 0xFF));
        colors.add(new ColorName("Beige", 0xF5, 0xF5, 0xDC));
        colors.add(new ColorName("Bisque", 0xFF, 0xE4, 0xC4));
        colors.add(new ColorName("Black", 0x00, 0x00, 0x00));
        colors.add(new ColorName("BlanchedAlmond", 0xFF, 0xEB, 0xCD));
        colors.add(new ColorName("Blue", 0x00, 0x00, 0xFF));
        colors.add(new ColorName("BlueViolet", 0x8A, 0x2B, 0xE2));
        colors.add(new ColorName("Brown", 0xA5, 0x2A, 0x2A));
        colors.add(new ColorName("BurlyWood", 0xDE, 0xB8, 0x87));
        colors.add(new ColorName("CadetBlue", 0x5F, 0x9E, 0xA0));
        colors.add(new ColorName("Chartreuse", 0x7F, 0xFF, 0x00));
        colors.add(new ColorName("Chocolate", 0xD2, 0x69, 0x1E));
        colors.add(new ColorName("Coral", 0xFF, 0x7F, 0x50));
        colors.add(new ColorName("CornflowerBlue", 0x64, 0x95, 0xED));
        colors.add(new ColorName("Cornsilk", 0xFF, 0xF8, 0xDC));
        colors.add(new ColorName("Crimson", 0xDC, 0x14, 0x3C));
        colors.add(new ColorName("Cyan", 0x00, 0xFF, 0xFF));
        colors.add(new ColorName("DarkBlue", 0x00, 0x00, 0x8B));
        colors.add(new ColorName("DarkCyan", 0x00, 0x8B, 0x8B));
        colors.add(new ColorName("DarkGoldenRod", 0xB8, 0x86, 0x0B));
        colors.add(new ColorName("DarkGray", 0xA9, 0xA9, 0xA9));
        colors.add(new ColorName("DarkGrey", 0xA9, 0xA9, 0xA9));
        colors.add(new ColorName("DarkGreen", 0x00, 0x64, 0x00));
        colors.add(new ColorName("DarkKhaki", 0xBD, 0xB7, 0x6B));
        colors.add(new ColorName("DarkMagenta", 0x8B, 0x00, 0x8B));
        colors.add(new ColorName("DarkOliveGreen", 0x55, 0x6B, 0x2F));
        colors.add(new ColorName("DarkOrange", 0xFF, 0x8C, 0x00));
        colors.add(new ColorName("DarkOrchid", 0x99, 0x32, 0xCC));
        colors.add(new ColorName("DarkRed", 0x8B, 0x00, 0x00));
        colors.add(new ColorName("DarkSalmon", 0xE9, 0x96, 0x7A));
        colors.add(new ColorName("DarkSeaGreen", 0x8F, 0xBC, 0x8F));
        colors.add(new ColorName("DarkSlateBlue", 0x48, 0x3D, 0x8B));
        colors.add(new ColorName("DarkSlateGray", 0x2F, 0x4F, 0x4F));
        colors.add(new ColorName("DarkSlateGrey", 0x2F, 0x4F, 0x4F));
        colors.add(new ColorName("DarkTurquoise", 0x00, 0xCE, 0xD1));
        colors.add(new ColorName("DarkViolet", 0x94, 0x00, 0xD3));
        colors.add(new ColorName("DeepPink", 0xFF, 0x14, 0x93));
        colors.add(new ColorName("DeepSkyBlue", 0x00, 0xBF, 0xFF));
        colors.add(new ColorName("DimGray", 0x69, 0x69, 0x69));
        colors.add(new ColorName("DimGrey", 0x69, 0x69, 0x69));
        colors.add(new ColorName("DodgerBlue", 0x1E, 0x90, 0xFF));
        colors.add(new ColorName("FireBrick", 0xB2, 0x22, 0x22));
        colors.add(new ColorName("FloralWhite", 0xFF, 0xFA, 0xF0));
        colors.add(new ColorName("ForestGreen", 0x22, 0x8B, 0x22));
        colors.add(new ColorName("Fuchsia", 0xFF, 0x00, 0xFF));
        colors.add(new ColorName("Gainsboro", 0xDC, 0xDC, 0xDC));
        colors.add(new ColorName("GhostWhite", 0xF8, 0xF8, 0xFF));
        colors.add(new ColorName("Gold", 0xFF, 0xD7, 0x00));
        colors.add(new ColorName("GoldenRod", 0xDA, 0xA5, 0x20));
        colors.add(new ColorName("Gray", 0x80, 0x80, 0x80));
        colors.add(new ColorName("Grey", 0x80, 0x80, 0x80));
        colors.add(new ColorName("Green", 0x00, 0x80, 0x00));
        colors.add(new ColorName("GreenYellow", 0xAD, 0xFF, 0x2F));
        colors.add(new ColorName("HoneyDew", 0xF0, 0xFF, 0xF0));
        colors.add(new ColorName("HotPink", 0xFF, 0x69, 0xB4));
        colors.add(new ColorName("IndianRed", 0xCD, 0x5C, 0x5C));
        colors.add(new ColorName("Indigo", 0x4B, 0x00, 0x82));
        colors.add(new ColorName("Ivory", 0xFF, 0xFF, 0xF0));
        colors.add(new ColorName("Khaki", 0xF0, 0xE6, 0x8C));
        colors.add(new ColorName("Lavender", 0xE6, 0xE6, 0xFA));
        colors.add(new ColorName("LavenderBlush", 0xFF, 0xF0, 0xF5));
        colors.add(new ColorName("LawnGreen", 0x7C, 0xFC, 0x00));
        colors.add(new ColorName("LemonChiffon", 0xFF, 0xFA, 0xCD));
        colors.add(new ColorName("LightBlue", 0xAD, 0xD8, 0xE6));
        colors.add(new ColorName("LightCoral", 0xF0, 0x80, 0x80));
        colors.add(new ColorName("LightCyan", 0xE0, 0xFF, 0xFF));
        colors.add(new ColorName("LightGoldenRodYellow", 0xFA, 0xFA, 0xD2));
        colors.add(new ColorName("LightGray", 0xD3, 0xD3, 0xD3));
        colors.add(new ColorName("LightGrey", 0xD3, 0xD3, 0xD3));
        colors.add(new ColorName("LightGreen", 0x90, 0xEE, 0x90));
        colors.add(new ColorName("LightPink", 0xFF, 0xB6, 0xC1));
        colors.add(new ColorName("LightSalmon", 0xFF, 0xA0, 0x7A));
        colors.add(new ColorName("LightSeaGreen", 0x20, 0xB2, 0xAA));
        colors.add(new ColorName("LightSkyBlue", 0x87, 0xCE, 0xFA));
        colors.add(new ColorName("LightSlateGray", 0x77, 0x88, 0x99));
        colors.add(new ColorName("LightSlateGrey", 0x77, 0x88, 0x99));
        colors.add(new ColorName("LightSteelBlue", 0xB0, 0xC4, 0xDE));
        colors.add(new ColorName("LightYellow", 0xFF, 0xFF, 0xE0));
        colors.add(new ColorName("Lime", 0x00, 0xFF, 0x00));
        colors.add(new ColorName("LimeGreen", 0x32, 0xCD, 0x32));
        colors.add(new ColorName("Linen", 0xFA, 0xF0, 0xE6));
        colors.add(new ColorName("Magenta", 0xFF, 0x00, 0xFF));
        colors.add(new ColorName("Maroon", 0x80, 0x00, 0x00));
        colors.add(new ColorName("MediumAquaMarine", 0x66, 0xCD, 0xAA));
        colors.add(new ColorName("MediumBlue", 0x00, 0x00, 0xCD));
        colors.add(new ColorName("MediumOrchid", 0xBA, 0x55, 0xD3));
        colors.add(new ColorName("MediumPurple", 0x93, 0x70, 0xDB));
        colors.add(new ColorName("MediumSeaGreen", 0x3C, 0xB3, 0x71));
        colors.add(new ColorName("MediumSlateBlue", 0x7B, 0x68, 0xEE));
        colors.add(new ColorName("MediumSpringGreen", 0x00, 0xFA, 0x9A));
        colors.add(new ColorName("MediumTurquoise", 0x48, 0xD1, 0xCC));
        colors.add(new ColorName("MediumVioletRed", 0xC7, 0x15, 0x85));
        colors.add(new ColorName("MidnightBlue", 0x19, 0x19, 0x70));
        colors.add(new ColorName("MintCream", 0xF5, 0xFF, 0xFA));
        colors.add(new ColorName("MistyRose", 0xFF, 0xE4, 0xE1));
        colors.add(new ColorName("Moccasin", 0xFF, 0xE4, 0xB5));
        colors.add(new ColorName("NavajoWhite", 0xFF, 0xDE, 0xAD));
        colors.add(new ColorName("Navy", 0x00, 0x00, 0x80));
        colors.add(new ColorName("OldLace", 0xFD, 0xF5, 0xE6));
        colors.add(new ColorName("Olive", 0x80, 0x80, 0x00));
        colors.add(new ColorName("OliveDrab", 0x6B, 0x8E, 0x23));
        colors.add(new ColorName("Orange", 0xFF, 0xA5, 0x00));
        colors.add(new ColorName("OrangeRed", 0xFF, 0x45, 0x00));
        colors.add(new ColorName("Orchid", 0xDA, 0x70, 0xD6));
        colors.add(new ColorName("PaleGoldenRod", 0xEE, 0xE8, 0xAA));
        colors.add(new ColorName("PaleGreen", 0x98, 0xFB, 0x98));
        colors.add(new ColorName("PaleTurquoise", 0xAF, 0xEE, 0xEE));
        colors.add(new ColorName("PaleVioletRed", 0xDB, 0x70, 0x93));
        colors.add(new ColorName("PapayaWhip", 0xFF, 0xEF, 0xD5));
        colors.add(new ColorName("PeachPuff", 0xFF, 0xDA, 0xB9));
        colors.add(new ColorName("Peru", 0xCD, 0x85, 0x3F));
        colors.add(new ColorName("Pink", 0xFF, 0xC0, 0xCB));
        colors.add(new ColorName("Plum", 0xDD, 0xA0, 0xDD));
        colors.add(new ColorName("PowderBlue", 0xB0, 0xE0, 0xE6));
        colors.add(new ColorName("Purple", 0x80, 0x00, 0x80));
        colors.add(new ColorName("Red", 0xFF, 0x00, 0x00));
        colors.add(new ColorName("RosyBrown", 0xBC, 0x8F, 0x8F));
        colors.add(new ColorName("RoyalBlue", 0x41, 0x69, 0xE1));
        colors.add(new ColorName("SaddleBrown", 0x8B, 0x45, 0x13));
        colors.add(new ColorName("Salmon", 0xFA, 0x80, 0x72));
        colors.add(new ColorName("SandyBrown", 0xF4, 0xA4, 0x60));
        colors.add(new ColorName("SeaGreen", 0x2E, 0x8B, 0x57));
        colors.add(new ColorName("SeaShell", 0xFF, 0xF5, 0xEE));
        colors.add(new ColorName("Sienna", 0xA0, 0x52, 0x2D));
        colors.add(new ColorName("Silver", 0xC0, 0xC0, 0xC0));
        colors.add(new ColorName("SkyBlue", 0x87, 0xCE, 0xEB));
        colors.add(new ColorName("SlateBlue", 0x6A, 0x5A, 0xCD));
        colors.add(new ColorName("SlateGray", 0x70, 0x80, 0x90));
        colors.add(new ColorName("SlateGrey", 0x70, 0x80, 0x90));
        colors.add(new ColorName("Snow", 0xFF, 0xFA, 0xFA));
        colors.add(new ColorName("SpringGreen", 0x00, 0xFF, 0x7F));
        colors.add(new ColorName("SteelBlue", 0x46, 0x82, 0xB4));
        colors.add(new ColorName("Tan", 0xD2, 0xB4, 0x8C));
        colors.add(new ColorName("Teal", 0x00, 0x80, 0x80));
        colors.add(new ColorName("Thistle", 0xD8, 0xBF, 0xD8));
        colors.add(new ColorName("Tomato", 0xFF, 0x63, 0x47));
        colors.add(new ColorName("Turquoise", 0x40, 0xE0, 0xD0));
        colors.add(new ColorName("Violet", 0xEE, 0x82, 0xEE));
        colors.add(new ColorName("Wheat", 0xF5, 0xDE, 0xB3));
        colors.add(new ColorName("White", 0xFF, 0xFF, 0xFF));
        colors.add(new ColorName("WhiteSmoke", 0xF5, 0xF5, 0xF5));
        colors.add(new ColorName("Yellow", 0xFF, 0xFF, 0x00));
        colors.add(new ColorName("YellowGreen", 0x9A, 0xCD, 0x32));
        colors.add(new ColorName("RebeccaPurple", 0x66, 0x33, 0x99)); // CCS 4 #663399
        return colors;
    }


    /**
     * SubClass of ColorNameLookup
     */
    public class ColorName {
        private int r, g, b;
        private String name;
        public ColorName(String name, int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public int getRed() {
            return r;
        }
        public int getGreen() {
            return g;
        }
        public int getBlue() {
            return b;
        }
    }

}
