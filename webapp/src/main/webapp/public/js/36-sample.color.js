

// only run when the substr() function is broken
//      Microsoft's JScript does not support negative values for the start index.
//      https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/substr
if ("ab".substr(-1) !== "b") {
    /**
     *  Get the substring of a string
     *  @param  {integer}  start   where to start the substring
     *  @param  {integer}  length  how many characters to return
     *  @return {string}
     */
    String.prototype.substr = (function(substr) {
        return function(start, length) {
            // call the original method
            return substr.call(this,
                // did we get a negative start, calculate how much it is from the beginning of the string
                // adjust the start parameter for negative value
                start < 0 ? this.length + start : start,
                length);
        };
    }(String.prototype.substr));
}

function precisionRound(number, precision) {
    var factor = Math.pow(10, precision);
    return Math.round(number * factor) / factor;
}


var colorType = ""; // rgb, hex, name




/********************************************************************/
// Compute the contrast ratio functions
/********************************************************************/

function getContrastRatio(fgColor, bgColor) {
    var fgLuminosity = getLuminosity(fgColor);
    var bgLuminosity = getLuminosity(bgColor);
    if (fgLuminosity > bgLuminosity) {
        return computeContrast(fgLuminosity, bgLuminosity);
    } else {
        return computeContrast(bgLuminosity, fgLuminosity);
    }
}

function getLuminosity(color) {
    var digits = /(.*?)rgb\((\d+),(\d+),(\d+)\)/.exec(color);
    var red   = parseInt(digits[2]);
    var green = parseInt(digits[3]);
    var blue  = parseInt(digits[4]);
    var luminosity =
        getComposantValue(red)  * 0.2126
        + getComposantValue(green) * 0.7152
        + getComposantValue(blue) * 0.0722;
    return luminosity;
}

function getComposantValue(composant) {
    var rsgb = composant / 255;
    if (rsgb <= 0.03928) {
        return rsgb / 12.92;
    } else {
        return Math.pow(((rsgb + 0.055) / 1.055), 2.4);
    }
}

function computeContrast(lighter, darker) {
    return ((lighter + 0.05) / (darker + 0.05));
}


/********************************************************************/
// Color validator
/********************************************************************/



/**
 * convert hex to rgb
 *      before, use isValidateColorHex()
 * @param str  example: #FFFFFF
 * @returns {string}   rgb(255,255,255)
 */
function hexToRgb(str) {
    // see https://stackoverflow.com/questions/5623838/rgb-to-hex-and-hex-to-rgb
    if( str.match(/^#?[a-f0-9]{3}$/i) !== null){ // ex: #FFF, #CCC #ABC
        var resultShort = /^#?([a-f\d]{1})([a-f\d]{1})([a-f\d]{1})$/i.exec(str);
        str =   resultShort[1] + resultShort[1]
              + resultShort[2] + resultShort[2]
              + resultShort[3] + resultShort[3];
    }

    var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(str); // ex: #FFFFFF, #CCC
    return 'rgb(' + parseInt(result[1], 16)
            + ',' + parseInt(result[2], 16)
            + ',' + parseInt(result[3], 16) + ')';
            /*  return result ? {   r: parseInt(result[1], 16),
                                    g: parseInt(result[2], 16),
                                    b: parseInt(result[3], 16)
                                } : null;       */
}

/**
 * convert rgb to hex
 *      before, use isValidateColorRgb()
 * @param str  example: rgb(255,255,255)
 * @returns {string}
 */
function rgbToHex(str){
    a = str.replace(/[^\d,]/g,"").split(",");
    return "#"+((1<<24)+(+a[0]<<16)+(+a[1]<<8)+ +a[2]).toString(16).slice(1)
}

/**
 * convert color name to hex
 *      before, use isValidateColorName()  *
 * @param colorStr  color name
 * @returns {string}   example: #FFFFFF
 */
function ColorNameToHex(str) {
    str = str.trim().toLowerCase();
    var e = document.createElement('div');
    e.style.color = str;
    var colors = window.getComputedStyle( document.body.appendChild(e) ).color.match(/\d+/g).map(function(e){ return parseInt(e,10); });
    document.body.removeChild(e);
    return (colors.length >= 3) ? '#' + (((1 << 24) + (colors[0] << 16) + (colors[1] << 8) + colors[2]).toString(16).substr(1)) : false;
}


function isValidateColorName(str) {
    // source: https://gist.github.com/bobspace/2712980
    var CssColorNames = ["AliceBlue","AntiqueWhite","Aqua","Aquamarine","Azure","Beige","Bisque","Black","BlanchedAlmond","Blue","BlueViolet","Brown","BurlyWood","CadetBlue","Chartreuse","Chocolate","Coral","CornflowerBlue","Cornsilk","Crimson","Cyan","DarkBlue","DarkCyan","DarkGoldenRod","DarkGray","DarkGrey","DarkGreen","DarkKhaki","DarkMagenta","DarkOliveGreen","DarkOrange","DarkOrchid","DarkRed","DarkSalmon","DarkSeaGreen","DarkSlateBlue","DarkSlateGray","DarkSlateGrey","DarkTurquoise","DarkViolet","DeepPink","DeepSkyBlue","DimGray","DimGrey","DodgerBlue","FireBrick","FloralWhite","ForestGreen","Fuchsia","Gainsboro","GhostWhite","Gold","GoldenRod","Gray","Grey","Green","GreenYellow","HoneyDew","HotPink","IndianRed","Indigo","Ivory","Khaki","Lavender","LavenderBlush","LawnGreen","LemonChiffon","LightBlue","LightCoral","LightCyan","LightGoldenRodYellow","LightGray","LightGrey","LightGreen","LightPink","LightSalmon","LightSeaGreen","LightSkyBlue","LightSlateGray","LightSlateGrey","LightSteelBlue","LightYellow","Lime","LimeGreen","Linen","Magenta","Maroon","MediumAquaMarine","MediumBlue","MediumOrchid","MediumPurple","MediumSeaGreen","MediumSlateBlue","MediumSpringGreen","MediumTurquoise","MediumVioletRed","MidnightBlue","MintCream","MistyRose","Moccasin","NavajoWhite","Navy","OldLace","Olive","OliveDrab","Orange","OrangeRed","Orchid","PaleGoldenRod","PaleGreen","PaleTurquoise","PaleVioletRed","PapayaWhip","PeachPuff","Peru","Pink","Plum","PowderBlue","Purple","Red","RosyBrown","RoyalBlue","SaddleBrown","Salmon","SandyBrown","SeaGreen","SeaShell","Sienna","Silver","SkyBlue","SlateBlue","SlateGray","SlateGrey","Snow","SpringGreen","SteelBlue","Tan","Teal","Thistle","Tomato","Turquoise","Violet","Wheat","White",
        "WhiteSmoke","Yellow","YellowGreen","RebeccaPurple"];
    var query     = str.trim().toLowerCase();
    var colorName = "";
    CssColorNames.some(function(element, i) {
        if (query === element.toLowerCase()) {
            colorName = element;
            return true;
        }
    });
    if(colorName !== ""){
        return colorName;
    }
    return false;
}

function isValideRgbMaxValue(str) {
    var numbers = str.match(/(\d{1,3})/g);
    if(numbers !== null){
        var isValid = true;
        for (var i = 0, c = numbers.length; i < c; i++) {
            if( numbers[i] > 255){
                isValid = false;
            }
        }
        return isValid;
    }
    return false;
}

function isValidateColorRgb(str) {
    str = str.trim();
    if(str.match(/^rgb\((\d{1,3}),(\d{1,3}),(\d{1,3})\)?$/i) !== null){ // "rbg(x,x,x)" or "rgb(x,x,x"
        if(isValideRgbMaxValue(str) === true){
            if(str.substr(-1) !== ")"){
                str = str + ")";
            }
            return str;
        }
    }
    else if (str.match(/^(\d{1,3}),(\d{1,3}),(\d{1,3})$/i) !== null){ // "x,x,x"
        if(isValideRgbMaxValue(str) === true){
            return "rgb("+ str + ")";
        }
    }
    return false;
}

function isValidateColorHex(str) {
    str = str.trim();
    if (   str.match(/^#?[a-f0-9]{6}$/i) !== null
        || str.match(/^#?[a-f0-9]{3}$/i) !== null){
        if(str.substr(0,1) !== "#"){
            str = "#" + str ;
        }
        return str;
    }
    return false;
}


function isValidateColor(str) {
    str = str.trim();
    var checkCommas = str.match(/,/g);
    var color       = false;
    if(checkCommas !== null){
        if(checkCommas.length === 2){
            color = isValidateColorRgb(str); // FALSE or rbg color string
            if( color !== false) {
                colorType = "rgb";
            }
        }
    }
    else {
        color = isValidateColorHex(str); // FALSE or hex color string
        if( color !== false) {
            colorType = "hex";
        }
        else  {
            color = isValidateColorName(str); // FALSE or color name
            if( color !== false) {
                colorType = "name";
            }
        }
    }
    return color;
}

/********************************************************************/
// UI
/********************************************************************/

function checkConstrast(showError){
    var checkRatioUI  = document.getElementById("help-block-colors");
    // var selectRatio   = document.getElementById("ratio");
    var inputFg       = document.getElementById("foreground-input");
    var inputBg       = document.getElementById("background-input");

    var select   = document.getElementById("ratio");
    var choice   = select.selectedIndex;
    var minRatio = select.options[choice].value;

    var colorFg = inputFg.value.toLowerCase();
    var colorBg = inputBg.value.toLowerCase();
    colorFg     = colorFg.toString().replace(/\s/g,""); // replace ' ', \t, \n, ...
    colorBg     = colorBg.toString().replace(/\s/g,""); // replace ' ', \t, \n, ...

    colorFg     = isValidateColor(colorFg.toString());
    if (colorFg !== false) {
        if(colorType === "hex"){
            colorFg = hexToRgb(colorFg);
        }
        else if(colorType === "name"){
            colorFg = hexToRgb(ColorNameToHex(colorFg));
        }

        colorBg = isValidateColor(colorBg.toString());
        if (colorBg !== false) {
            if(colorType === "hex"){
                colorBg = hexToRgb(colorBg);
            }
            else if(colorType === "name"){
                colorBg = hexToRgb(ColorNameToHex(colorBg));
            }
            var ratio = getContrastRatio(colorBg,colorFg);
            ratio     = precisionRound(ratio, 2);
            var txtResult = 'Ok';
            if(ratio < minRatio ){
                checkRatioUI.classList.add("error");
                txtResult = 'Fail';
            }
            checkRatioUI.innerHTML = 'Ratio : '+ ratio +  ' ---> ' + txtResult;
            console.log(txtResult + ' : min ratio' + minRatio + ' vs ratio '+ ratio
                        + ' --- '+ colorBg +' / '+ colorFg );
            return true;
        }
    }

    if(showError === true) {
        sample.innerHTML = '';
    }
    return false;
}


function changeColorSample(colorPrefix, showError) {
    var input = document.getElementById(colorPrefix + "-input");
    var color = input.value.toLowerCase();
    var sample = document.getElementById(colorPrefix + "-sample");
    color = color.toString().replace(/\s/g,""); // replace ' ', \t, \n, ...
    color = isValidateColor(color.toString());
    if (color !== false) {
        sample.style.backgroundColor = color;
        sample.classList.add("color-sample");
        sample.classList.add("sample-bordered");
        input.classList.remove("error");
        document.getElementById(colorPrefix + "-sample-invalid").style.display = "none";
        var colorHEX = color;
        if(colorType === "rgb"){
            colorHEX = rgbToHex(color);
        }
        else if(colorType === "name"){
            colorHEX = ColorNameToHex(color);
        }
        var colorPicker = document.getElementById(colorPrefix + "_imputColorPicker");
        colorPicker.value = colorHEX;
        document.getElementById(colorPrefix + "_ColorPicker").style.display    = "inherit";
    }
    else if(showError === true) {
        sample.style.backgroundColor = "rgba(0,0,0,0)";
        sample.classList.remove("color-sample");
        sample.classList.remove("sample-bordered");
        document.getElementById(colorPrefix + "_ColorPicker").style.display = "none";
        document.getElementById(colorPrefix + "-sample-invalid").style.display = "inherit";
        input.classList.add("error");
    }
}


function changeColorPicker(colorPrefix) {
    var input       = document.getElementById(colorPrefix + "-input");
    var sample      = document.getElementById(colorPrefix + "-sample");
    var colorPicker = document.getElementById(colorPrefix + "_imputColorPicker");
    var color       = colorPicker.value.toLowerCase();
    color = color.toString().replace(/\s/g,""); // replace ' ', \t, \n, ...
    color = isValidateColor(color.toString());
    if (color !== false) {
        input.value = color.toUpperCase();
        sample.style.backgroundColor = color;
        sample.classList.add("color-sample");
        sample.classList.add("sample-bordered");
        document.getElementById(colorPrefix + "-sample-invalid").style.display = "none";
        input.classList.remove("error");
    }
}



$(document).ready(function() {

    // Color picker
    document.getElementById("background_imputColorPicker").onchange = function() {
        changeColorPicker("background");
        checkConstrast(false); // don't show error
    };
    document.getElementById("foreground_imputColorPicker").onchange = function() {
        changeColorPicker("foreground");
        checkConstrast(false); // don't show error
    };

    // when the color inputs lost focus
    document.getElementById("foreground-input").onchange = function() {
        changeColorSample("foreground",true); // show error
        checkConstrast(true); // show error
    };
    document.getElementById("background-input").onchange = function() {
        changeColorSample("background",true); // show error
        checkConstrast(true); // show error
    };

    // when the user change the ratio min
    document.getElementById("ratio").onchange = function() {
        checkConstrast(true); // show error
    };

    // when the user change the value of color inputs
    $("#foreground-input").on("paste keyup", function() {
        changeColorSample("foreground",false); // don't show error
        checkConstrast(false); // don't show error
    });
    $("#background-input").on("paste keyup", function() {
        changeColorSample("background",false); // don't show error
        checkConstrast(false); // don't show error
    });

    // changeColorSample("foreground",true); // show error
    // changeColorSample("background",true); // show error
    // checkConstrast(true); // show error
});