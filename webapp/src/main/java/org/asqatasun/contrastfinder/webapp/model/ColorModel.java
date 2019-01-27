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
package org.asqatasun.contrastfinder.webapp.model;

import org.apache.commons.lang3.StringUtils;
import org.asqatasun.utils.colorconvertor.ColorConverter;

/**
 * @author alingua
 */
public class ColorModel {

 // private static final String DEFAULT_FOREGROUND = "#468847";
    private static final String DEFAULT_FOREGROUND = "rgb(70,136,71)"; // = #468847
    private static final String DEFAULT_BACKGROUND = "#DFF0D8";
    private static final String DEFAULT_RATIO = "4.5";
    private String foreground = DEFAULT_FOREGROUND;
    private String background = DEFAULT_BACKGROUND;
    private String ratio = DEFAULT_RATIO;
    private String algo = "HSV";
    private boolean isBackgroundTested = false;

    /**
     * @return The algorithm used to compute (can be HSV or RGB)
     */
    public String getAlgo() {
        return algo;
    }

    /**
     * @param algo The algorithm used to compute (can be HSV or RGB)
     */
    public void setAlgo(String algo) {
        this.algo = algo;
    }

    /**
     * @return Foreground color in hexadecimal with '#' appended if necessary
     */
    public String getForeground() {
        if (StringUtils.isBlank(foreground)) {
            return null;
        }
        return foreground;
    }

    /**
     * @param foreground Set foregound color (expected as string) in hexadecimal format, beginning with '#'
     */
    public void setForeground(String foreground) {
        this.foreground = ColorConverter.formatColorStr(foreground);
    }

    /**
     * @return Background color in hexadecimal with '#' appended if necessary
     */
    public String getBackground() {
        if (StringUtils.isBlank(background)) {
            return null;
        }
        return background;
    }

    public void setBackground(String background) {
        this.background = ColorConverter.formatColorStr(background);
    }

    public boolean getIsBackgroundTested() {
        return isBackgroundTested;
    }

    public void setIsBackgroundTested(boolean isBackgroundTested) {
        this.isBackgroundTested = isBackgroundTested;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }
}
