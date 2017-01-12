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

package org.asqatasun.colorfinder.factory;

import org.apache.commons.lang3.StringUtils;
import org.asqatasun.color.finder.hsv.ColorFinderHsv;
import org.asqatasun.color.finder.hsv.ColorFinderRgb;
import org.asqatasun.colorfinder.ColorFinder;

/**
 *
 * @author alingua
 */
public class ColorFinderHsvFactory implements ColorFinderFactory {

    @Override
    public ColorFinder getColorFinder() {
        return new ColorFinderHsv();
    }

    @Override
    public ColorFinder getColorFinder(String colorFinderKey) {
        if (StringUtils.equals(colorFinderKey, "HSV")) {
            return new ColorFinderRgb();
        }
        return null;
    }

}