

String.prototype.splice = function(idx, rem, s) {
    return (this.slice(0, idx) + s + this.slice(idx + Math.abs(rem)));
};

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

function setValidColor(str) {
    var result = str.splice(0, 0, "#");
    return result;
}

function isValidateColor(str) {
    str = str.trim();
    if(str.match(/^rgb\((\d{1,3}),(\d{1,3}),(\d{1,3})\)?$/) !== null){
        if(str.substr(-1) !== ")"){
            str = str + ")";
        }
        return str;
    }
    else if (str.match(/^(\d{1,3}),(\d{1,3}),(\d{1,3})$/) !== null){
        return "rgb("+ str + ")";
    }
    else if (str.match(/^#[a-fA-F0-9]{6}$/i) !== null
            || str.match(/^#[a-fA-F0-9]{3}$/i) !== null){
        return str;
    }
    else if (str.match(/^#?([a-fA-F0-9]{6})$/) !== null
            || str.match(/^#?([a-fA-F0-9]{3})$/) !== null) {
        str = setValidColor(str);
        return str;
    }
    else {
        // source: https://gist.github.com/bobspace/2712980
        var CssColorNames = ["AliceBlue","AntiqueWhite","Aqua","Aquamarine","Azure","Beige","Bisque","Black","BlanchedAlmond","Blue","BlueViolet","Brown","BurlyWood","CadetBlue","Chartreuse","Chocolate","Coral","CornflowerBlue","Cornsilk","Crimson","Cyan","DarkBlue","DarkCyan","DarkGoldenRod","DarkGray","DarkGrey","DarkGreen","DarkKhaki","DarkMagenta","DarkOliveGreen","DarkOrange","DarkOrchid","DarkRed","DarkSalmon","DarkSeaGreen","DarkSlateBlue","DarkSlateGray","DarkSlateGrey","DarkTurquoise","DarkViolet","DeepPink","DeepSkyBlue","DimGray","DimGrey","DodgerBlue","FireBrick","FloralWhite","ForestGreen","Fuchsia","Gainsboro","GhostWhite","Gold","GoldenRod","Gray","Grey","Green","GreenYellow","HoneyDew","HotPink","IndianRed","Indigo","Ivory","Khaki","Lavender","LavenderBlush","LawnGreen","LemonChiffon","LightBlue","LightCoral","LightCyan","LightGoldenRodYellow","LightGray","LightGrey","LightGreen","LightPink","LightSalmon","LightSeaGreen","LightSkyBlue","LightSlateGray","LightSlateGrey","LightSteelBlue","LightYellow","Lime","LimeGreen","Linen","Magenta","Maroon","MediumAquaMarine","MediumBlue","MediumOrchid","MediumPurple","MediumSeaGreen","MediumSlateBlue","MediumSpringGreen","MediumTurquoise","MediumVioletRed","MidnightBlue","MintCream","MistyRose","Moccasin","NavajoWhite","Navy","OldLace","Olive","OliveDrab","Orange","OrangeRed","Orchid","PaleGoldenRod","PaleGreen","PaleTurquoise","PaleVioletRed","PapayaWhip","PeachPuff","Peru","Pink","Plum","PowderBlue","Purple","Red","RosyBrown","RoyalBlue","SaddleBrown","Salmon","SandyBrown","SeaGreen","SeaShell","Sienna","Silver","SkyBlue","SlateBlue","SlateGray","SlateGrey","Snow","SpringGreen","SteelBlue","Tan","Teal","Thistle","Tomato","Turquoise","Violet","Wheat","White",
                             "WhiteSmoke","Yellow","YellowGreen","RebeccaPurple"];
        var query     = str.toLowerCase();
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
        return "false";
    }
}

function changeColorSample(colorPrefix, showError) {
    var input = document.getElementById(colorPrefix + "-input");
    var color = input.value.toLowerCase();
    var sample = document.getElementById(colorPrefix + "-sample");
    color = color.toString().replace(/\s/g,""); // replace ' ', \t, \n, ...
    color = isValidateColor(color.toString());
    if (color !== "false") {
        sample.style.backgroundColor = color;
        sample.classList.add("color-sample");
        sample.classList.add("sample-bordered");
        document.getElementById(colorPrefix + "-sample-invalid").style.display = "none";
        input.classList.remove("error");
    }
    else if(showError === true) {
        sample.style.backgroundColor = "rgba(0,0,0,0)";
        sample.classList.remove("color-sample");
        sample.classList.remove("sample-bordered");
        document.getElementById(colorPrefix + "-sample-invalid").style.display = "inherit";
        input.classList.add("error");
    }
}


$(document).ready(function() {

    // when the color inputs lost focus
    document.getElementById("foreground-input").onchange = function() {
        changeColorSample("foreground",true); // show error
    };
    document.getElementById("background-input").onchange = function() {
        changeColorSample("background",true); // show error
    };

    // when the user change the value of color inputs
    $("#foreground-input").on("paste keyup", function() {
        changeColorSample("foreground",false); // don't show error
    });
    $("#background-input").on("paste keyup", function() {
        changeColorSample("background",false); // don't show error
    });

});