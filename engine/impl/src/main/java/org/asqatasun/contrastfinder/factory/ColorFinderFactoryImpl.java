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

package org.asqatasun.contrastfinder.factory;

import java.util.HashMap;
import java.util.Map;
import org.asqatasun.contrastfinder.ColorFinder;

/**
 *
 * @author alingua
 */
public class ColorFinderFactoryImpl implements ColorFinderFactory {

    private Map<String, ColorFinderFactory> colorFinderMap =
            new HashMap<String, ColorFinderFactory>();

    public void setColorFinderMap(Map<String, ColorFinderFactory> colorFinderMap) {
        this.colorFinderMap = colorFinderMap;
    }

    @Override
    public ColorFinder getColorFinder(String colorFinderKey) {
        if (colorFinderMap.containsKey(colorFinderKey)) {
            return colorFinderMap.get(colorFinderKey).getColorFinder();
        }
        return null;
    }

    @Override
    public ColorFinder getColorFinder() {
        // not supposed to be called, just to provide an implementation
        return colorFinderMap.entrySet().iterator().next().getValue().getColorFinder();
    }

}
