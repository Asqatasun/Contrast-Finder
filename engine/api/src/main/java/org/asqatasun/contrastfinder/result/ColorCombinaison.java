/*
 * Contrast Finder
 * Copyright (C) 2008-2018   Asqatasun.org
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

package org.asqatasun.contrastfinder.result;

import java.awt.Color;

/**
 * Interface that defines a couple of colour and its resulting contrast
 *
 * @author alingua
 */
public interface ColorCombinaison {


    /**
     * @return Gap
     */
    Float getGap();

    /**
     * @return Color object
     */
    Color getColor();

    /**
     * @param color
     */
    void setColor(Color color);

    /**
     * @return contrast
     */
    Double getContrast();

    /**
     * @param distance from initial color
     */
    void setDistanceFromInitialColor(Double distance);

    /**
     * @return distance
     */
    Double getDistance();

    /**
     * @param threshold
     */
    void setThreshold(Double threshold);

    /**
     * @return threshold
     */
    Double getThreshold();

    /**
     * @return true if is valid contrast
     */
    boolean isContrastValid();

    /**
     * @return Color object
     */
    Color getComparisonColor();

    /**
     * @param color
     */
    void setComparisonColor(Color color);

    /**
     * @return color in hexadecimal format, example: #FFFFFF
     */
    String getHexaColor();

    /**
     *
     * @return color in HSL format, example: hsl(0, 0%, 100%)
     */
    String getHslColor();

    /**
     * @return color in hexadecimal format, example: #FFFFFF
     */
    String getHexaColorComp();

    /**
     * @return color in HSL format, example: hsl(0, 0%, 100%)
     */
    String getHslColorComp();
}