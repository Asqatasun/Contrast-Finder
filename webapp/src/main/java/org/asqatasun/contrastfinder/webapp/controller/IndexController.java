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
package org.asqatasun.contrastfinder.webapp.controller;


import org.asqatasun.contrastfinder.webapp.model.ColorModel;
import org.asqatasun.contrastfinder.webapp.validator.ColorModelValidator;
import org.asqatasun.contrastfinder.ColorFinder;
import org.asqatasun.contrastfinder.factory.ColorFinderFactory;
import org.asqatasun.contrastfinder.result.ColorResult;
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
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.validation.Valid;
import java.awt.Color;

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
     *      default is ''
     *      can be override in the following file:
     *      /etc/contrast-finder/contrast-finder.conf
     */
    @Value("${piwik_analytics_key:}")
    private String piwikAnalyticsKey;

    /**
     * piwik analytics server URL
     *      default is ''
     *      can be override in the following file:
     *      /etc/contrast-finder/contrast-finder.conf
     */
    @Value("${piwik_analytics_server:}")
    private String piwikAnalyticServer;

    /**
     * default algorithm  ("HSV")
     * used only in this.initAccueil()
     *      HSV = a range of valid colors
     *      Rgb = valid colors and very close to initial color
     *
     *      can be override in the following file:
     *      /etc/contrast-finder/contrast-finder.conf
     *
     *      a bad value is fixed by the default algo ("HSV") in ColorModel class
     */
    @Value("${default_algorithm:HSV}")
    // @Value("${default_algorithm:HSV}")
    // @Value("${default_algorithm:Rgb}")
    private String defaultAlgorithm;


    /**
     * environment
     *      env = debug
     *      env = prod    (default)
     *
     *      can be override in the following file:
     *      /etc/contrast-finder/contrast-finder.conf
     */
    @Value("${env:prod}")
    private String env;


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
     * @return HTML
     */
    @RequestMapping(value = "form.html")
    public String initAccueil(final Model model,
                              @CookieValue(value = "algo", defaultValue = "") String algoCookie) {
        ColorModel colorModel = new ColorModel();
        if ("HSV".equals(algoCookie) || "Rgb".equals(algoCookie)) {
            colorModel.setAlgo(algoCookie);
        }
        else if ("HSV".equals(defaultAlgorithm) || "Rgb".equals(defaultAlgorithm)) {
            colorModel.setAlgo(defaultAlgorithm);
        }  // Default algo in ColorModel class is "HSV"
        model.addAttribute("defaultAlgorithm", defaultAlgorithm);
        model.addAttribute("algo", colorModel.getAlgo());
        model.addAttribute("env",  env);
        model.addAttribute("piwikKey",    piwikAnalyticsKey);
        model.addAttribute("piwikServer", piwikAnalyticServer);
        model.addAttribute(commandName, colorModel);
        return mainPageView;
    }




    /**
     * @param model
     * @param colorModel
     * @param result
     * @return HTML
     */
    @RequestMapping(value = "result.html", method = RequestMethod.GET)
    public String getPageResultFromGet( final Model model,
                                        @Valid ColorModel colorModel,
                                        BindingResult result,
                                        @CookieValue(value = "algo", defaultValue = "") String algoCookie,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
        model.addAttribute("env",  env);
        model.addAttribute("piwikKey",    piwikAnalyticsKey);   /* Analytics Keys*/
        model.addAttribute("piwikServer", piwikAnalyticServer);
        model.addAttribute("defaultAlgorithm", defaultAlgorithm);
        model.addAttribute("algo", colorModel.getAlgo());
        if (result.hasErrors()) {
            model.addAttribute("errorResult", "result.hasErrors");
            return mainPageView;
        } else {

            // Add cookie
            if(!(algoCookie.equals(colorModel.getAlgo()))){
                Cookie cookie = new Cookie("algo", colorModel.getAlgo());
                cookie.setMaxAge(30*24*60*60); // set expire time to 30 days
                response.addCookie(cookie);
            }


            /* get user's color selection */
            Color foregroundColor = ColorConverter.colorFromStr(colorModel.getForeground());
            Color backgroundColor = ColorConverter.colorFromStr(colorModel.getBackground());

            /* call the color finder with user's selection */
            ColorResult colorResult = getColorFinderAndExecute(
                    colorModel,
                    foregroundColor,
                    backgroundColor).getColorResult();

            /* Preparing the data and populating the model before returning the view */
            model.addAttribute("colorResult", colorResult);

            model.addAttribute("backgroundHEX",
                ColorConverter.rgb2Hex(backgroundColor));
            model.addAttribute("foregroundHEX",
                ColorConverter.rgb2Hex(foregroundColor));
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
            // model.addAttribute("algo", colorModel.getAlgo());
            model.addAttribute("otherAlgo", getOppositeAlgo(colorModel.getAlgo()));
            return mainPageView;
        }

    }

    /**
     * @param algo  The algorithm used to compute (can be HSV or RGB)
     * @return      The other algorithm
     */
    private String getOppositeAlgo(String algo) {
        if ("HSV".equals(algo)) {
            return "Rgb";
        } else if ("Rgb".equals(algo)) {
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