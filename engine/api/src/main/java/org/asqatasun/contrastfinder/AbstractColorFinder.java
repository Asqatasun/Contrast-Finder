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
package org.asqatasun.contrastfinder;

import java.awt.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.asqatasun.contrastfinder.result.ColorCombinaison;
import org.asqatasun.contrastfinder.result.ColorResult;
import org.asqatasun.contrastfinder.result.factory.ColorCombinaisonFactory;
import org.asqatasun.contrastfinder.result.factory.ColorResultFactory;
import org.asqatasun.utils.contrastchecker.ContrastChecker;

/**
 *
 * @author alingua
 */
public abstract class AbstractColorFinder implements ColorFinder {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractColorFinder.class);
    private static final float MAX_HUE = 360.0f;
    private static final float MIN_HUE = 1.0f;
    private static final float MAX_COEFFICIENT_LEVEL = 2.5f;
    protected static final float UNITARY_STEP_HUE = (MIN_HUE / MAX_HUE);
    private ColorResultFactory colorResultFactory;
    private ColorCombinaisonFactory colorCombinaisonFactory;
    private Color colorToKeep;       /* the color to keep, will not be modified during test */
    private Float coefficientLevel;  /* the coefficient level to apply*/
    private ColorResult colorResult; /* the colorResult that handles the results of the test*/

    public ColorResultFactory getColorResultFactory() {
            return colorResultFactory;
    }

    public ColorCombinaisonFactory getColorCombinaisonFactory() {
        return colorCombinaisonFactory;
    }

    public Color getColorToKeep() {
        return colorToKeep;
    }

    public Float getCoefficientLevel() {
        return coefficientLevel;
    }

    @Override
    public ColorResult getColorResult() {
        return colorResult;
    }

    /**
     * Constructor
     */
    public AbstractColorFinder(
            ColorResultFactory colorResultFactory,
            ColorCombinaisonFactory colorCombinaisonFactory) {
        super();
        this.colorResultFactory = colorResultFactory;
        this.colorCombinaisonFactory = colorCombinaisonFactory;
    }

    @Override
    public void findColors(Color foregroundColor,
            Color backgroundColor,
            boolean isBackgroundTested,
            Float coefficientLevel) {
        this.coefficientLevel = coefficientLevel;

        if (isBackgroundTested) {
            colorToKeep = foregroundColor;
            initColorResult(backgroundColor, foregroundColor, coefficientLevel);
        } else {
            colorToKeep = backgroundColor;
            initColorResult(foregroundColor, backgroundColor, coefficientLevel);
        }
        if (!colorResult.isCombinaisonValid()) {
            findColors();
        }

    }

    /**
     *
     * @param newColor
     * @return
     */
    protected boolean isNewColorValid(Color newColor) {
        ColorCombinaison colorCombinaison =
                colorCombinaisonFactory.getColorCombinaison(
                newColor,
                colorToKeep,
                Double.valueOf(coefficientLevel));

        if (colorCombinaison.isContrastValid()
                && colorCombinaison.getContrast() < (coefficientLevel + MAX_COEFFICIENT_LEVEL)) {

            LOGGER.debug("Adding a color to list : " + newColor.getRed() + " "
                    + newColor.getGreen() + " "
                    + newColor.getBlue() + " Contrast : "
                    + ContrastChecker.getConstrastRatio(newColor, colorToKeep));

            colorResult.addSuggestedColor(colorCombinaison);
            return true;
        }
        return false;
    }

    /**
     *
     * @param colorToChange
     * @param colorToKeep
     * @param coefficientLevel
     */
    protected void initColorResult(
            Color colorToChange,
            Color colorToKeep,
            Float coefficientLevel) {
        colorResult = colorResultFactory.getColorResult();
        colorResult.setSubmittedColors(colorToChange, colorToKeep, coefficientLevel);
    }

    /**
     * Concrete method that find the colors from one color to change, one to
     * keep, and a threshold.
     *
     * @param colorToChange
     * @param colorToKeep
     * @param coefficientLevel
     * @return
     */
    protected abstract void findColors();
}