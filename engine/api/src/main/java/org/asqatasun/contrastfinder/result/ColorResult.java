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

package org.asqatasun.contrastfinder.result;

import java.awt.Color;
import java.util.Collection;

/**
 *
 * @author alingua
 */
public interface ColorResult {

    /**
     * @param foreground
     * @param backgroud
     * @param threashold
     */
    void setSubmittedColors(Color foreground, Color backgroud, Float threashold);

    /**
     * @return ColorCombinaison object
     */
    ColorCombinaison getSubmittedCombinaisonColor();

    /**
     * @return true if is valid combinaison
     */
    boolean isCombinaisonValid();

    /**
     *
     * @return Collection object of ColorCombinaison objects
     */
    Collection<ColorCombinaison> getSuggestedColors();

    /**
     * @return the number of suggested colors
     */
    int getNumberOfSuggestedColors();

    /**
     * @param combinaison
     */
    void addSuggestedColor(ColorCombinaison combinaison);

    /**
     * @return Threashold
     */
    Float getThreashold();

    /**
     * @return the number of tested colors
     */
    int getNumberOfTestedColors();

    /**
     * set the number of tested colors
     * @param testedColors
     */
    void setNumberOfTestedColors(int testedColors);

}
