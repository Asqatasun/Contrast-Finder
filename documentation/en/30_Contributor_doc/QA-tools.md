
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
    * [Test a single asset from 14 locations](https://tools.keycdn.com/performance?url=https://app.contrast-finder.org) `*`
* HTTP/2
    * [Http2.pro](https://http2.pro/check?url=https://app.contrast-finder.org) `*` (check server HTTP/2, ALPN, and Server-push support)
* Global tools (webperf, accessibility, security, ...)
    * [Dareboost](https://www.dareboost.com)  (free trial)
    * [Sonarwhal](https://sonarwhal.com/scanner/)

* Social networks
  * [Twitter card validator](https://cards-dev.twitter.com/validator)
* structured data (JSON-LD, rdf, schema.org, microformats.org, ...)
  * [Google structured data testing tool](https://search.google.com/structured-data/testing-tool#url=https://app.contrast-finder.org/)  `*`
  * [Yandex structured data testing tool](https://webmaster.yandex.com/tools/microtest/)
  * [Structured Data Linter](http://linter.structured-data.org/?url=https://app.contrast-finder.org)  `*`
  * [Microdata Parser](http://tools.seomoves.org/microdata/)
* Google image
  * [images used on the website](https://www.google.fr/search?tbm=isch&q=site:app.contrast-finder.org)  `*`  (site:app.contrast-finder.org)
  * [images used on the website but hosted on other domains](https://www.google.fr/search?tbm=isch&q=site:app.contrast-finder.org+-src:app.contrast-finder.org) `*`  (site:app.contrast-finder.org -src:app.contrast-finder.org)
  * [images hosted on the domain name](https://www.google.fr/search?tbm=isch&q=src:app.contrast-finder.org)  `*`    (src:app.contrast-finder.org)
  * [images hosted on the domain name and used by other domain names (hotlinks)](https://www.google.fr/search?tbm=isch&q=src:app.contrast-finder.org+-site:app.contrast-finder.org)  `*`   (src:app.contrast-finder.org -site:app.contrast-finder.org)

## Open-source softwares

* [W3C tools](https://w3c.github.io/developers/tools/#tools)
* Security
    * [Arachni](https://github.com/Arachni/arachni) (web application security scanner framework)
    * Content-Security-Policy (CSP)
        * [salvation](https://github.com/shapesecurity/salvation) (Java parser, warn about policy errors)
    * Mozilla Observatory
        * [CLI client for Mozilla Observatory](https://github.com/mozilla/observatory-cli)
        * [HTTP Observatory](https://github.com/mozilla/http-observatory) (local scanner : CLI and CI)
* Web accessibility
    * Asqatasun
        * [Asqatsun Docker image](https://hub.docker.com/r/asqatasun/asqatasun/)
        * [Install Asqatasun on a server](https://doc.asqatasun.org/en/10_Install_doc/Asqatasun/)
* Web perf
    * Webpagetest
    * [Yellowlab](https://github.com/gmetais/YellowLabTools/) (API, npm CLI, Grunt task, ...)
    * [Sitespeed.io](https://www.sitespeed.io/) (npm or docker is needed)
* Global tools
    * [Sonarwhal](https://github.com/sonarwhal/sonarwhal) (Node.js v8)

## Audit history

### 0.8.3
* Security
   * https://www.hardenize.com/report/app.contrast-finder.org/1516756341
* Web perf
   * https://www.webpagetest.org/result/180124_KC_d6495475e9d7beed0e79583dd9e207b2/
   * http://yellowlab.tools/result/exn8ef7di1
* Global tools (webperf, accessibility, security, ...)
    * https://www.dareboost.com/fr/report/5a66a3fe0cf2b528a73e562a
    * https://sonarwhal.com/scanner/6699688c-0363-4d0b-a636-add8a2f9d909







    