
# QA tools

## Online QA tools for app.contrast-finder.org

`*` preconfigured tools

* Security
    * [Hardenize](https://www.hardenize.com) (DNS, SMTP, web server)
    * [Mozilla Observatory](https://observatory.mozilla.org/analyze.html?host=app.contrast-finder.org) `*` (HTTP header, SSL, cookies, ...)
    * [Security Headers](https://securityheaders.io/?q=https://app.contrast-finder.org) `*` (HTTP header)
    * Content-Security-Policy (CSP)
        * [cspvalidator.org](https://cspvalidator.org/#url=https://app.contrast-finder.org) `*`
        * [csp-evaluator.withgoogle.com](https://csp-evaluator.withgoogle.com/?csp=https://app.contrast-finder.org) `*`
    * SSL
        * [ssllabs.com](https://www.ssllabs.com/ssltest/analyze?d=app.contrast-finder.org) `*`
        * [tls.imirhil.fr](https://tls.imirhil.fr/https/app.contrast-finder.org) `*`
* W3C tools
    * [HTML validator](https://validator.w3.org/nu/?doc=https://app.contrast-finder.org&showsource=yes&showoutline=yes&showimagereport=yes) `*`
    * [CSS validator](https://jigsaw.w3.org/css-validator/validator?uri=https://app.contrast-finder.org&profile=css3) `*`
    * [Link checker](https://validator.w3.org/checklink?uri=https://app.contrast-finder.org&hide_type=all&depth=&check=Check) `*`
    * [i18n checker](https://validator.w3.org/i18n-checker/check?uri=https://app.contrast-finder.org) `*`
        * [i18n checker for **/?lang=en**](https://validator.w3.org/i18n-checker/check?uri=https://app.contrast-finder.org/?lang=en) `*`
        * [i18n checker for **/?lang=fr**](https://validator.w3.org/i18n-checker/check?uri=https://app.contrast-finder.org/?lang=fr) `*`
        * [i18n checker for **/?lang=pt**](https://validator.w3.org/i18n-checker/check?uri=https://app.contrast-finder.org/?lang=pt) `*`
        * [i18n checker for **/?lang=ko**](https://validator.w3.org/i18n-checker/check?uri=https://app.contrast-finder.org/?lang=ko) `*`
* Web accessibility
    * [Asqatasun](https://app.asqatasun.org)
* Web perf
    * [Yellowlab](http://yellowlab.tools)
    * [Webpagetest](https://www.webpagetest.org/)
    * [Sitespeed.io](https://www.sitespeed.io/) (npm or docker is needed)
* Global tools (webperf, accessibility, security, ...)
    * [Dareboost](https://www.dareboost.com)
    * [Sonarwhal](https://sonarwhal.com/scanner/)