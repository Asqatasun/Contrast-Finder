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
public class IndexController  extends AbstractController {

    /**
     * model name
     */
    private String commandName;




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
     * Page about.html
     * @param model model of the page
     * @return view name  like "page/form"
     */
    @RequestMapping(value = "about.html")
    public String getPageAbout(final Model model) {
        addCommonViewData(model, "page-about");
        return "pages/about";
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

        /* get default colors */
        Color foregroundColor = ColorConverter.colorFromStr(colorModel.getForeground());
        Color backgroundColor = ColorConverter.colorFromStr(colorModel.getBackground());

        /* Preparing the data and populating the model before returning the view */
        model.addAttribute("formCurrrentRatio",   "");
        model.addAttribute("formCurrentMinRatio", "");
        model.addAttribute("formCurrentIsValidContrast",false);
        model.addAttribute("backgroundHEX", ColorConverter.rgb2Hex(backgroundColor));
        model.addAttribute("foregroundHEX", ColorConverter.rgb2Hex(foregroundColor));
        model.addAttribute("algo", colorModel.getAlgo());
        model.addAttribute(commandName, colorModel);
        addCommonViewData(model, "page-home");
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
        model.addAttribute("algo", colorModel.getAlgo());
        if (result.hasErrors()) {
            model.addAttribute("errorResult", "result.hasErrors");
            addCommonViewData(model, "page-result-error");
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
            model.addAttribute("formCurrentMinRatio",
                    colorModel.getRatio());
            model.addAttribute("formCurrentIsValidContrast",
                    ContrastChecker.isContrastValid(foregroundColor,
                                                    backgroundColor,
                                                    Float.parseFloat(colorModel.getRatio())));
            model.addAttribute("formCurrrentRatio",
                    ContrastChecker.getConstrastRatio2DigitRound(foregroundColor, backgroundColor));
            model.addAttribute("oldContrast",
                    ContrastChecker.getConstrastRatio5DigitRound(foregroundColor, backgroundColor));
            model.addAttribute("oldDistance",
                    colorResult.getSubmittedCombinaisonColor().getDistance());
            // model.addAttribute("algo", colorModel.getAlgo());
            model.addAttribute("otherAlgo", getOppositeAlgo(colorModel.getAlgo()));

            // Logging color results
            if("full".equals(loggingColorsResult) | "debug".equals(env)){
                LOGGER.info("---------------------");
                LOGGER.info("get  TXT       : " + colorModel.getForeground()               );
                LOGGER.info("get  BG        : " + colorModel.getBackground()               );
                LOGGER.info("get  ratio     : " + colorModel.getRatio()                    );
                LOGGER.info("get  algo      : " + colorModel.getAlgo()                     );
                LOGGER.info("get  BG tested : " + colorModel.getIsBackgroundTested()       );
                LOGGER.info("tested         : " + colorResult.getNumberOfTestedColors()    );
                LOGGER.info("result         : " + colorResult.getNumberOfSuggestedColors() );
                LOGGER.info("ratio          : " + ContrastChecker.getConstrastRatio2DigitRound(foregroundColor, backgroundColor) );
            }
            else if("compact".equals(loggingColorsResult)){
                LOGGER.info("START|" + colorModel.getForeground()
                               + "|" + colorModel.getBackground()
                               + "|" + colorModel.getRatio()
                               + "|" + colorModel.getAlgo()
                               + "|" + colorModel.getIsBackgroundTested()
                               + "|" + colorResult.getNumberOfTestedColors()
                               + "|" + colorResult.getNumberOfSuggestedColors()
                               + "|" + ContrastChecker.getConstrastRatio2DigitRound(foregroundColor, backgroundColor)
                               + "|END");
            }
            addCommonViewData(model, "page-result");
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

}
