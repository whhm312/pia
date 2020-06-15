function gridValidDiv(inputName, $appendDiv) {
	var html = "";
	html += "<div class=\"radio-inline\" style=\"display:none\">";
	html += "<label id=\""+inputName+"-error\" class=\"error\" for=\""+inputName+"\"></label>";
	html += "</div>";
	$appendDiv.append(html);
}

function noticeSetChangeEvent(formName) {
	if (formName == "newForm") {
		$("#"+formName+" [name=branch]").on("change", function() {
			$("#"+formName+" label[for=branch]").append("");
			$("#"+formName+" label[for=branch]").css("display", "none");
			$("#"+formName+" label[for=branch]").parent().css("display", "none");
		});
	}
	$("#"+formName+" [name=language]").on("change", function() {
		$("#"+formName+" label[for=language]").append("");
		$("#"+formName+" label[for=language]").css("display", "none");
		$("#"+formName+" label[for=language]").parent().css("display", "none");
	});
	$("#"+formName+" [name=isTopOfList]").on("change", function() {
		$("#"+formName+" label[for=isTopOfList]").append("");
		$("#"+formName+" label[for=isTopOfList]").css("display", "none");
		$("#"+formName+" label[for=isTopOfList]").parent().css("display", "none");
	});
    $("#"+formName+" [name=isPopup]").on("change", function() {
    		$("#"+formName+" label[for=isPopup]").append("");
    		$("#"+formName+" label[for=isPopup]").css("display", "none");
    		$("#"+formName+" label[for=isPopup]").parent().css("display", "none");
    });
}

function resetNoticeValidate(formName) {
	if (formName == "newForm") {
		$("#"+formName+" label[for=branch]").append("");
		$("#"+formName+" label[for=branch]").css("display", "none");
		$("#"+formName+" label[for=branch]").parent().css("display", "none");
	}
	
	$("#"+formName+" label[for=language]").append("");
	$("#"+formName+" label[for=language]").css("display", "none");
	$("#"+formName+" label[for=language]").parent().css("display", "none");
	
	$("#"+formName+" label[for=isTopOfList]").append("");
	$("#"+formName+" label[for=isTopOfList]").css("display", "none");
	$("#"+formName+" label[for=isTopOfList]").parent().css("display", "none");
	
	$("#"+formName+" label[for=isPopup]").append("");
	$("#"+formName+" label[for=isPopup]").css("display", "none");
	$("#"+formName+" label[for=isPopup]").parent().css("display", "none");
	
	$("#"+formName+" label[for=content]").append("");
	$("#"+formName+" label[for=content]").css("display", "none");
	$("#"+formName+" label[for=content]").parent().css("display", "none");
}

function resetNewNoticeValidate() {
	resetNoticeValidate("newForm");
}

function noticeValidate(formName) {
	var returnVal = true;
	
	if (formName == "newForm") {
		if (!$("#"+formName+" [name=branch]").is(":checked")) {
			$("#"+formName+" label[for=branch]").append("This field is required.");
			$("#"+formName+" label[for=branch]").css("display", "");
			$("#"+formName+" label[for=branch]").parent().css("display", "");
			returnVal = false;
		}
	}
	if (!$("#"+formName+" [name=language]").is(":checked")) {
		$("#"+formName+" label[for=language]").append("This field is required.");
		$("#"+formName+" label[for=language]").css("display", "");
		$("#"+formName+" label[for=language]").parent().css("display", "");
		returnVal = false;
	}
	if (!$("#"+formName+" [name=isTopOfList]").is(":checked")) {
		$("#"+formName+" label[for=isTopOfList]").append("This field is required.");
		$("#"+formName+" label[for=isTopOfList]").css("display", "");
		$("#"+formName+" label[for=isTopOfList]").parent().css("display", "");
		returnVal = false;
	}
	if (!$("#"+formName+" [name=isPopup]").is(":checked")) {
		$("#"+formName+" label[for=isPopup]").append("This field is required.");
		$("#"+formName+" label[for=isPopup]").css("display", "");
		$("#"+formName+" label[for=isPopup]").parent().css("display", "");
		returnVal = false;
	}
	if (!$("#"+formName+" #content").code()) {
		$("#"+formName+" label[for=content]").append("This field is required.");
		$("#"+formName+" label[for=content]").css("display", "");
		$("#"+formName+" label[for=content]").parent().css("display", "");
		returnVal = false;
	}
	return returnVal;
}

function newNoticeValidate() {
	return noticeValidate("newForm");
}