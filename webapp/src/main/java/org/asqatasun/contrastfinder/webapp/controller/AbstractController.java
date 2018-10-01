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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
     * adding config to logs at the launch of servlet
     */
    private boolean addConfigToLogs;

    /**
     * available languages
     * see: this.languages
     */
    private Map<String, String> availableLanguages;


    /**
     * ordered languages list
     * see: this.languages
     */
    private List<String> orderedLanguagesList;

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
     * list of languages available in the webapp
     * - comma-separated language codes (ISO 639-1: two-letter codes)
     * - order will be the same in the webapp menu
     *
     *      currently : "en,fr,es,pt,ko"
     *      can be override in the following file:
     *      /etc/contrast-finder/contrast-finder.conf
     */
    @Value("${languages:en,fr,es,pt,ko}")
    private String languages;

    /**
     * default Language  (ISO 639-1: two-letter codes)
     *
     *      currently : "en"
     *      can be override in the following file:
     *      /etc/contrast-finder/contrast-finder.conf
     */
    @Value("${defaultLanguage:en}")
    private String defaultLanguage;


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


    /*
     * notice: called only at the launch of servlet
     */
    public AbstractController() {
        LOGGER.debug("calling AbstractController()");
    }

    /**
     * Preparing the common data and populating the model before returning the view
     * @param  model     model of the page
     * @param  pageName  name of the page (ex: page-home) using by jsp, css and js
     */
    protected void addCommonViewData(final Model model, String pageName) {
        model.addAttribute("env",                   env);
        model.addAttribute("piwikKey",              piwikAnalyticsKey);
        model.addAttribute("piwikServer",           piwikAnalyticServer);
        model.addAttribute("searchEngineInclude",   searchEngineInclude);
        model.addAttribute("defaultAlgorithm",      defaultAlgorithm);
        model.addAttribute("availableLanguages",    availableLanguages);
        model.addAttribute("orderedLanguagesList",  orderedLanguagesList);
        model.addAttribute("defaultLanguage",       defaultLanguage);
        model.addAttribute("pageName",              pageName);
    }

    /**
     * adds the following configuration options to the log :
     *      - env
     *      - piwikKey
     *      - piwikServer
     *      - defaultAlgorithm
     *      - searchEngineInclude
     *      - loggingColorsResult
     *      - defaultLanguage
     *      - languages
     *
     * see: /etc/contrast-finder/contrast-finder.conf
     */
    protected void addConfigToLogs(){
        LOGGER.debug("calling addConfigToLogs()");
        LOGGER.info("config  env                 : " + env                 );
        LOGGER.info("config  piwikKey            : " + piwikAnalyticsKey   );
        LOGGER.info("config  piwikServer         : " + piwikAnalyticServer );
        LOGGER.info("config  defaultAlgorithm    : " + defaultAlgorithm    );
        LOGGER.info("config  searchEngineInclude : " + searchEngineInclude );
        LOGGER.info("config  loggingColorsResult : " + loggingColorsResult );
        LOGGER.info("config  defaultLanguage     : " + defaultLanguage     );
        LOGGER.info("config  languages           : " + languages           );
    }

    /**
     * set this.addConfigToLogs
     * and calling addConfigToLogs() for adding config to the logs
     *
     * notice: called only at the launch of servlet after the contructor
     * see:    webapp/src/main/webapp/WEB-INF/conf/mvc/cf-beans-controller.xml
     */
    public void setAddConfigToLogs(String addConfigToLogs) {
     // LOGGER.debug("calling setAddConfigToLogs()");
        if( "true".equals(addConfigToLogs)){
            this.addConfigToLogs = true;
            addConfigToLogs();
        }
        else {
            this.addConfigToLogs = false;
        }
    }


    /**
     * set this.availableLanguages
     *
     * notice: called only at the launch of servlet after the contructor
     * see:    webapp/src/main/webapp/WEB-INF/conf/mvc/cf-beans-controller.xml
     */
    public void setLoadAvailableLanguages(String loadAvailableLanguages) {
        // LOGGER.debug("calling setLoadAvailableLanguages()");
        List<String>        languagesList;
        Map<String, String> languagesMap = new HashMap<>();
        languagesList = Arrays.asList(languages.split(","));
        for(String lang : languagesList) {
            Locale locale = new Locale(lang);
            languagesMap.put(locale.getLanguage(), locale.getDisplayLanguage(locale));
            // LOGGER.debug("locale                           : " + locale);
            // LOGGER.debug("locale.getLanguage()             : " + locale.getLanguage());
            // LOGGER.debug("locale.getDisplayLanguage()      : " + locale.getDisplayLanguage());
            // LOGGER.debug("locale.getDisplayLanguage(locale): " + locale.getDisplayLanguage(locale));
        }
        this.availableLanguages   = languagesMap;
        this.orderedLanguagesList = languagesList;
        LOGGER.debug(availableLanguages.toString());
        LOGGER.debug(orderedLanguagesList.toString());
    }

}
