
var SERVER_URI = "http://pinesportal.com:12001";
//var SERVER_URI = "http://172.30.1.1:12001";
//var SERVER_URI = "http://182.50.19.211:12001";

function signout() {
	$.removeCookie("token", { path: "/" });
	$.removeCookie("userId", { path: "/" });
	$.removeCookie("name", { path: "/" });
	$.removeCookie("branchSeq", { path: "/" });
	$.removeCookie("nationalitySeq", { path: "/" });
	$.removeCookie("languageSeq", { path: "/" });
	$.cookie("showEmergencyContactPopup", true);
	$.removeCookie("md5Password", { path: "/" });

	window.location.replace("/");
	
	return false;
}

function freshmanSignout() {
	$.removeCookie("token", { path: "/" });
	$.removeCookie("userId", { path: "/" });
	$.removeCookie("name", { path: "/" });
	$.removeCookie("branchSeq", { path: "/" });
	$.removeCookie("nationalitySeq", { path: "/" });
	$.removeCookie("languageSeq", { path: "/" });
	$.removeCookie("showEmergencyContactPopup", { path: "/" });
	
	window.location.replace("/freshman");
	
	return false;
}

function setLanguage(languageName) {
	if (languageName == "Korean") {
		$.cookie("changeLang", "ko");
	} else if (languageName == "English") {
		$.cookie("changeLang", "en");
	} else if (languageName == "Japanese") {
		$.cookie("changeLang", "jp");
	} else if (languageName == "Chinese") {
		$.cookie("changeLang", "cn");
	} else if (languageName == "Vietnamese") {
		$.cookie("changeLang", "dn");
	} else {
		$.cookie("changeLang", "en");
	}
}

function getLanguageInCookie() {
	var languageName = $.cookie("changeLang");
	if (languageName == "ko") {
		return "Korean";
	} else if (languageName == "en") {
		return "English";
	} else if (languageName == "jp") {
		return "Japanese";
	} else if (languageName == "cn") {
		return "Chinese";
	} else if (languageName == "dn") {
		return "Vietnamese";
	}
}




function openPopup() {
	$("html, body").animate({scrollTop:0}, 100);
	$(".popup_over").css("display", "");
	$(".popup").css("display", "");
}

function closePopup() {
	$(".popup_over").css("display", "none");
	$(".popup").css("display", "none");
}


function blockScreen() {
	$(".loading_popup_over").css("display", "");
	$(".loading").css("display", "");
}

function unBlockScreen() {
	$(".loading_popup_over").css("display", "none");
	$(".loading").css("display", "none");
}

function getHeaders(key, value) { 
    var headers = {};
    headers[key] = value;
    return headers;
} 






function setSelecValue(objId, value) {
	$("#" +objId +" option").filter(function() {
		return this.value == value; 
	}).attr('selected', true);
}

function setSelecText(objId, text) {
	$("#" +objId +" option").filter(function() {
	    return this.text == text; 
	}).attr('selected', true);
}

function setRadioValue(objName, value) {
	$("input:radio[name="+objName+"]").filter("[value=" + value + "]").attr('checked', true);
}





function alertSuccess() {
	alert("Success.");
}

function alertError(status, message) {
	alert("[" + status + "] : " + message);
}




function getBoolean(str) {
	if (str) {
		return JSON.parse(str);
	} else {
		return false;
	}
}



function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
}

function fileDownload(filePath, fileName) {
	window.location = SERVER_URI + "/filedownload?filePath="+filePath+"&fileName="+encodeURI(encodeURIComponent(fileName));
}

function changeUpperCase(event, obj) {
	obj.value = obj.value.toUpperCase();
}