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
package org.asqatasun.contrastFinder.webapp.controller;


import org.asqatasun.contrastFinder.webapp.model.ColorModel;
import org.asqatasun.contrastFinder.webapp.validator.ColorModelValidator;
import org.asqatasun.contrastFinder.ColorFinder;
import org.asqatasun.contrastFinder.factory.ColorFinderFactory;
import org.asqatasun.contrastFinder.result.ColorResult;
import org.asqatasun.utils.colorconvertor.ColorConverter;
import org.asqatasun.utils.contrastchecker.ContrastChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.awt.*;

/**
 * @author alingua
 */
@Controller
public class IndexController {

    /**
     * model name
     */
    private String commandName;
    /**
     * View containing the form
     */
    private String mainPageView;
    /**
     * piwik analytics key
     */
    @Value("${piwik_analytics_key}")
    private String piwikAnalyticsKey;

    @Autowired
    private ColorFinderFactory colorFinderFactory;

    /**
     * Validator initialisation
     */
    @InitBinder("colorModel")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ColorModelValidator());
    }

    /**
     * Form initialisation
     *
     * @param model model of the page
     * @return      page name to display
     */
    @RequestMapping(value = "form.html")
    public String initAccueil(final Model model) {
        ColorModel colorModel = new ColorModel();
        model.addAttribute("piwikKey", piwikAnalyticsKey);
        model.addAttribute(commandName, colorModel);
        return mainPageView;
    }

    /**
     * @param model
     * @param colorModel
     * @param result
     * @return
     */
    @RequestMapping(value = "result.html", method = RequestMethod.GET)
    public String getPageResultFromGet(final Model model, @Valid ColorModel colorModel, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return mainPageView;
        } else {

            /* get user's color selection */
            Color foregroundColor =
                    ColorConverter.hex2Rgb(colorModel.getForeground());
            Color backgroundColor =
                    ColorConverter.hex2Rgb(colorModel.getBackground());

            /* call the color finder with user's selection */
            ColorResult colorResult = getColorFinderAndExecute(
                    colorModel,
                    foregroundColor,
                    backgroundColor).getColorResult();

            /* Preparing the data and populating the model before returning the view */
            model.addAttribute("colorResult", colorResult);
            model.addAttribute("backgroundColor",
                    ColorConverter.hex2Rgb(backgroundColor));
            model.addAttribute("foregroundColor",
                    ColorConverter.hex2Rgb(foregroundColor));
            model.addAttribute("backgroundHSLColor",
                    ColorConverter.rgb2Hsl(backgroundColor));
            model.addAttribute("foregroundHSLColor",
                    ColorConverter.rgb2Hsl(foregroundColor));
            model.addAttribute("resultNumber",
                    colorResult.getNumberOfSuggestedColors());
            model.addAttribute("oldContrast",
                    ContrastChecker.getConstrastRatio5DigitRound(foregroundColor, backgroundColor));
            model.addAttribute("oldDistance",
                    colorResult.getSubmittedCombinaisonColor().getDistance());
            model.addAttribute("algo", colorModel.getAlgo());
            model.addAttribute("otherAlgo", getOppositeAlgo(colorModel.getAlgo())); 
            /* Analytics Keys*/
            model.addAttribute("piwikKey", piwikAnalyticsKey);
            return mainPageView;
        }

    }

    /**
     * @param algo  The algorithm used to compute (can be HSV or RGB)
     * @return      The other algorithm
     */
    private String getOppositeAlgo(String algo) {
        if (algo.equals("HSV")) {
            return "Rgb";
        } else if (algo.equals("Rgb")) {
            return "HSV";
        }
        return algo;
    }

    /**
     * Call the colorFinder implementation regarding the user selection and
     * return it (knowing it handles the results)
     *
     * @param colorModel
     * @param foregroundColor
     * @param backgroundColor
     * @return the chosen colorFinder implementation with its results
     */
    private ColorFinder getColorFinderAndExecute(
            ColorModel colorModel,
            Color foregroundColor,
            Color backgroundColor) {

        ColorFinder colorFinder =
                colorFinderFactory.getColorFinder(colorModel.getAlgo());

        colorFinder.findColors(
                foregroundColor,
                backgroundColor,
                colorModel.getIsBackgroundTested(),
                Float.valueOf(colorModel.getRatio())
        );

        return colorFinder;
    }

    /**
     * Setter sur le nom du modèle
     */
    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    /**
     * Setter du nom de la formView
     */
    public void setMainPageView(String formView) {
        this.mainPageView = formView;
    }
}