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
package org.asqatasun.contrastfinder.hsv;

/**
 *
 * @author alingua
 */
public class Boundary {

    private Float minValue;
    private Float maxValue;

    public Float getMinValue() {
        return minValue;
    }

    public Float getMaxValue() {
        return maxValue;
    }


    /**
     *
     * @param minValue
     */
    public void setMinValue(Float minValue) {
        this.minValue = minValue;
    }

    /**
     *
     * @param maxValue
     */
    public void setMaxValue(Float maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * @param gap
     * @return true if minValue < gap < maxValue
     */
    public boolean isBounded(Float gap) {
        if (gap >= minValue && gap < maxValue) {
            return true;
        }
        return false;
    }
}
