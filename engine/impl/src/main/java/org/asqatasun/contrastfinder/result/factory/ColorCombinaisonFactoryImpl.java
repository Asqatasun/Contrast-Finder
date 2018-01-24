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

package org.asqatasun.contrastfinder.result.factory;

import java.awt.Color;
import org.asqatasun.contrastfinder.result.ColorCombinaison;
import org.asqatasun.contrastfinder.result.ColorCombinaisonImpl;

/**
 * 
 * @author alingua
 */
public class ColorCombinaisonFactoryImpl implements ColorCombinaisonFactory {

    @Override
    public ColorCombinaison getColorCombinaison(Color color1, Color color2, Double threashold) {
        return new ColorCombinaisonImpl(color1, color2, threashold);
    }
}