function piaFilePostAjax(headers, url, data, fncSuccess, fncError, fncComplete) {
	piaFileAjax(headers, url, "POST", data, "json", fncSuccess, fncError, fncComplete);
}

function piaFileAjax(headers, url, type, data, dataType, fncSuccess, fncError, fncComplete) {
	//console.log("headers : ", headers);
	console.log(type, " : ", url);
	$.ajax({
		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
		url : url,
		type : type,
		data : data,
		dataType : dataType,
		enctype: 'multipart/form-data',
		processData: false,
		contentType: false,
		beforeSend : basicFncBeforeSend,
		success : function(data, textStatus, jqXHR) {
//			console.log("success data : ", data);
//			console.log("success textStatus : ", textStatus);
//			console.log("success jqXHR : ", jqXHR);
			if (typeof fncSuccess == 'function') {
				fncSuccess(data);
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log("printLogfncError - jqXHR ", jqXHR);
			console.log("printLogfncError - textStatus ", textStatus);
			console.log("printLogfncError - errorThrown ", errorThrown);
			if (typeof fncError == 'function') {
				fncError(jqXHR, textStatus, errorThrown);
			}
		},
		complete : function(jqXHR, textStatus) {
			basicFncComplete(jqXHR, textStatus);
			
			//console.log("printLogfncComplete - jqXHR ", jqXHR);
			//console.log("printLogfncComplete - textStatus ", textStatus);
			if (typeof fncComplete == 'function') {
				console.log("fncComplete");
				fncComplete(jqXHR, textStatus);
			}
		}
	});
}

function piaAjax(headers, url, type, data, dataType, contentType, fncSuccess, fncError, fncComplete) {
	//console.log("headers : ", headers);
	console.log(type, " : ", url);
	wrapWindowByMask();
	
	$.ajax({
		headers : headers,
		url : url,
		type : type,
		data : data,
		dataType : dataType,
		contentType : contentType,
//		beforeSend : basicFncBeforeSend,
		success : function(data, textStatus, jqXHR) {
			//console.log("printLogfncSuccess");
//			 console.log(data);
//			 console.log(textStatus);
//			 console.log(jqXHR);
			if (typeof fncSuccess == 'function') {
				if (data.head.status != 200) {
					console.log("ERROR -----------\n ", data.head.status, data.head.message);
				}
				
				fncSuccess(data, textStatus, jqXHR);
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log("printLogfncError - jqXHR ", jqXHR);
			console.log("printLogfncError - textStatus ", textStatus);
			console.log("printLogfncError - errorThrown ", errorThrown);
			if (typeof fncError == 'function') {
				//console.log("fncError");
				fncError(jqXHR, textStatus, errorThrown);
			}
		},
		complete : function(jqXHR, textStatus) {
			basicFncComplete(jqXHR, textStatus);
			
			//console.log("printLogfncComplete - jqXHR ", jqXHR);
			//console.log("printLogfncComplete - textStatus ", textStatus);
			if (typeof fncComplete == 'function') {
				console.log("fncComplete");
				fncComplete(jqXHR, textStatus);
			}
		}
	});
}

function basicFncComplete(jqXHR, textStatus) {
	// jqXHR jqXHR, String textStatus
	//console.log("basicFncComplete");
	closeWindowByMask();
}

function basicFncBeforeSend(jqXHR, settings) {
	// jqXHR jqXHR, PlainObject settings
	// console.log("basicFncBeforeSend");
	// wrapWindowByMask();
}

function piaLoginAjax(url, data, fncSuccess) {
	piaAjax("", url, "POST", data, "json", "application/json; charset=UTF-8", fncSuccess, "");
}

function piaPostAjax(headers, url, data, fncSuccess, fncError, fncComplete) {
	piaAjax(headers, url, "POST", data, "json", "application/json; charset=UTF-8", fncSuccess, fncError, fncComplete);
}

function piaGetAjax(headers, url, data, fncSuccess, fncError, fncComplete) {
	piaAjax(headers, url, "GET", data, "json", "application/json; charset=UTF-8", fncSuccess, fncError, fncComplete);
}

function piaPutAjax(headers, url, data, fncSuccess, fncError, fncComplete) {
	piaAjax(headers, url, "PUT", data, "json", "application/json; charset=UTF-8", fncSuccess, fncError, fncComplete);
}

function piaDeleteAjax(headers, url, data, fncSuccess, fncError, fncComplete) {
	piaAjax(headers, url, "DELETE", data, "json", "application/json; charset=UTF-8", fncSuccess, fncError, fncComplete);
}

function getAuthorization(value) {
	return getAjaxHeaders("Authorization", value);
} 

function getAjaxHeaders(key, value) { 
    var headers = {};
    headers[key] = value;
    return headers;
} 

function wrapWindowByMask() {
	var maskHeight = $(window).height();
	var maskWidth = $(window).width();

	$('#api_mask').css({
		'width' : maskWidth,
		'height' : maskHeight
	});

	$('#api_mask').fadeIn(500);
	$(".pace-inactive").show();
	$(".window").show();
}

function closeWindowByMask() {
	var api_mask = document.getElementById("api_mask");
    if (api_mask.style.display === "none") {
	    	return false;
    } 
	
    $('#api_mask').fadeOut(500);
	$(".window").hide();
	$(".pace-inactive").hide();
}