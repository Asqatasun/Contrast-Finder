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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * abstract controller
 */
@Controller
public abstract class AbstractController {

    /**
     * logger for current class
     * usage :  LOGGER.info("log message");
     *          LOGGER.warn("warning message");
     *          LOGGER.debug("debug message");
     *          LOGGER.error("error message");
     */
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    /**
     * main view name
     */
    protected String mainPageView;

    /**
     * piwik analytics key
     *      default is ''
     *      can be override in the following file:
     *      /etc/contrast-finder/contrast-finder.conf
     */
    @Value("${piwik_analytics_key:}")
    protected String piwikAnalyticsKey;

    /**
     * piwik analytics server URL
     *      default is ''
     *      can be override in the following file:
     *      /etc/contrast-finder/contrast-finder.conf
     */
    @Value("${piwik_analytics_server:}")
    protected String piwikAnalyticServer;

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
    protected String defaultAlgorithm;


    /**
     * Give crawlers instructions
     *      searchEngineInclude = "yes"
     *      searchEngineInclude = "no"   (default)
     *          = disallow search engines from showing HTML pages in their results
     *
     *      can be override in the following file:
     *      /etc/contrast-finder/contrast-finder.conf
     */
    @Value("${searchEngineInclude:no}")
    protected String searchEngineInclude;

    /**
     * environment
     *      env = debug
     *      env = prod    (default)
     *
     *      can be override in the following file:
     *      /etc/contrast-finder/contrast-finder.conf
     */
    @Value("${env:prod}")
    protected String env;

    /**
     * logging colors result
     *      compact = log message on 1 line
     *      full    = log message on several lines
     *      no      = no logging     (default)
     *
     *      can be override in the following file:
     *      /etc/contrast-finder/contrast-finder.conf
     */
    @Value("${loggingColorsResult:no}")
 // @Value("${loggingColorsResult:compact}")
 // @Value("${loggingColorsResult:full}")
 // @Value("${loggingColorsResult:no}")
    protected String loggingColorsResult;



    public AbstractController() {}


    /**
     * - set main view name (this.mainPageView)
     * - log the config values
     *
     * notice: called at the launch of servlet
     */
    public void setMainPageView(String formView) {
        this.mainPageView = formView;
        LOGGER.info("config  env                 : " + env                 );
        LOGGER.info("config  piwikKey            : " + piwikAnalyticsKey   );
        LOGGER.info("config  piwikServer         : " + piwikAnalyticServer );
        LOGGER.info("config  defaultAlgorithm    : " + defaultAlgorithm    );
        LOGGER.info("config  searchEngineInclude : " + searchEngineInclude );
        LOGGER.info("config  loggingColorsResult : " + loggingColorsResult );
    }

    /**
     * Preparing the common data and populating the model before returning the view
     * @param  model     model of the page
     */
    protected void addCommonViewData(final Model model, String pageName) {
        model.addAttribute("env",                   env);
        model.addAttribute("piwikKey",              piwikAnalyticsKey);
        model.addAttribute("piwikServer",           piwikAnalyticServer);
        model.addAttribute("searchEngineInclude",   searchEngineInclude);
        model.addAttribute("defaultAlgorithm",      defaultAlgorithm);
        model.addAttribute("pageName",              pageName);
    }

}
