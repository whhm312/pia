/** 체크된 체크박스 값을 Array 형태로 변환 */
function getCheckedValues(checkboxName) {
	var checkedValues = $("input:checkbox[name='" + checkboxName + "']:checked").map(function(){
		return $(this).val();
	}).get();
	//console.log(checkedValues);
	return checkedValues;
}

/** 엔터키를 눌렀을때 함수 실행하도록 설정 */
function setEnterKeyEvent($obj, searchFunc) {
		$obj.keypress(function(event){
        if(event.keyCode == 13){
        		searchFunc();
        }
    });
}

function getBoolean(str) {
	if (str) {
		return JSON.parse(str);
	} else {
		return false;
	}
}

/** form 초기화 **/
$.fn.clearForm = function() {
	return this.each( function() {
		var type = this.type, tag = this.tagName.toLowerCase();
		if (tag == 'form') return $(':input',this).clearForm();
		if (type == 'text' || type == 'password' || type == 'hidden' || type == 'file' || tag == 'textarea') this.value = '';
		else if (type == 'checkbox' || type == 'radio') this.checked = false;
		else if (tag == 'select') this.selectedIndex = -1;
	});
};

/*
@author https://github.com/macek/jquery-serialize-object
@example $('#form').serializeObject();

*/
$.fn.serializeObject = function () {
    "use strict";
    var result = {};
    var extend = function (i, element) {
        var node = result[element.name];
        if ('undefined' !== typeof node && node !== null) {
           if ($.isArray(node)) {
               node.push(element.value);
           } else {
               result[element.name] = [node, element.value];
           }
        } else {
            result[element.name] = element.value;
        }
    };
 
    $.each(this.serializeArray(), extend);
    return result;
};


/** 확인창 띄우기 *********************************************************************************/
function openSwal(boldText, smallText, func) {
	swal({
		title : boldText,
		text : smallText
	}, func);
}


/** 브랜치, 언어 그리기 *********************************************************************************/
function gridCookieData($cookie, inputType, inputName, $gridDiv) {
	var html = "";
	$gridDiv.empty();
	$.each(JSON.parse($cookie), function(index, item) {
		html += "<div class=\"" + inputType + "-inline\">";
		html += "<label class=\"cr-styled\">";
		html += "<input type=\"" + inputType + "\" name=\"" + inputName + "\" value=\""+item.seq+"\"> ";
		html += "<i class=\"fa\"></i>";
		html += item.name;
		html += "</label>";
		html += "</div>";
	});
	$gridDiv.append(html);
}

function gridBranches(inputType, inputName, $gridDiv) {
	if (!$.cookie("branches")) {
		alert("Lack of Cookies.");
		window.location.replace("/login.jsp"); 
	}
	gridCookieData($.cookie("branches"), inputType, inputName, $gridDiv);
}

function gridLanguage(inputType, inputName, $gridDiv) {
	if (!$.cookie("languages")) {
		alert("Lack of Cookies.");
		window.location.replace("/login.jsp"); 
	}
	gridCookieData($.cookie("languages"), inputType, inputName, $gridDiv);
}

function gridNationality(inputType, inputName, $gridDiv) {
	if (!$.cookie("nationality")) {
		alert("Lack of Cookies.");
		window.location.replace("/login.jsp"); 
	}
	gridCookieData($.cookie("nationality"), inputType, inputName, $gridDiv);
}

function gridSearchBranchesWithoutChecked() {
	gridBranches("radio", "branch", $("#searchBranchesDiv"));
}

function gridSearchBranches() {
	gridBranches("radio", "branch", $("#searchBranchesDiv"));
	$("input:radio[name='branch']").eq(0).attr("checked", true);
}

function gridSearchLanguage() {
	gridLanguage("checkbox", "language", $("#searchLanguageDiv"));
}


/** 페이징 관련 *********************************************************************************/
/** 페이지 초기화 ready에서 호출 할 것 */
function initPaging() {
		$("#pagination").twbsPagination({
    		next: ">",
    		prev: "<",
    		visiblePages : 10,
    		initiateStartPageClick : false,
    		onPageClick : function(event, page) {
    			paramSelectedPage = page;
    			paginSearch();
    		}
    });
}

/** 데이터 통신 성공 후 호출 할 것 */
function gridPage(totalCount) {
	if (totalCount < 1) {
		totalCount = 1;
	}
    	$("#pagination").twbsPagination($.extend({}, defaultOpts, {
			startPage: paramSelectedPage, 
			totalPages : Math.ceil(parseInt(totalCount) / parseInt($("#offset option:selected").text()))
		}));
}

/** 페이징 처리 기본 옵션 값 - onPageClick 을 설정할 경우 호출 됨. */
var defaultOpts = {
		next: ">",
		prev: "<",
		visiblePages : 10,
		initiateStartPageClick : false
}






/** 쿼리 스트링 가져오기 **/
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
	$("input:radio[name="+objName+"]").filter("[value='" + value + "']").attr('checked', true);
}

function setCheckboxValue(objName, value) {
	$("input:checkbox[name="+objName+"]").filter("[value='" + value + "']").attr('checked', true);
}


function setDisabledByName(elementName) {
	$("[name="+elementName+"]").parent().css("cursor", "not-allowed");
	$("[name="+elementName+"]").attr("disabled", true);
	$("[name="+elementName+"]").addClass("disabled");
}

function setDisabled(elementId) {
	$("#"+elementId+"]").parent().css("cursor", "not-allowed");
	$("#"+elementId+"]").attr("disabled", true);
	$("#"+elementId+"]").addClass("disabled");
}


/** 뒤로가기 버튼 공통 **/
$("#historyBackButton").on("click", function() {
	window.history.back(1);
});

function fileDownload(filePath, fileName) {
	window.location = "http://192.168.31.203:12001/filedownload?filePath="+filePath+"&fileName="+encodeURI(encodeURIComponent(fileName));
}

function isNotAcceptableFileSize(maximumSize, fileSize) {
	//console.log("maximumSize : ", maximumSize, "fileSize : ", fileSize);
	if (!maximumSize || !fileSize) {
		return true;
	}
	
	if (maximumSize < fileSize) {
		return true;
	}
	return false;
}



/** Jquery Validate 를 사용하기 위한 기초 작업 1. css 변경, 2. reuired 추가 **/
function initValidateRadioButtons(radioButtonsName) {
	$.each(radioButtonsName, function(idx, val) {
		$("[name=" + val + "]").css({
			"min-width":"20px",
			"opacity":"0",
			"display":"inline"
		});
		
		$("[name=" + val + "]").rules("add", {required: true});
	});
}

function initValidateRadioButtonsById(radioButtonsIds) {
	$.each(radioButtonsIds, function(idx, val) {
		$("[id=" + val + "]").css({
			"min-width":"20px",
			"opacity":"0",
			"display":"inline"
		});
		
		$("[id=" + val + "]").rules("add", {required: true});
	});
}

function setStaffNameOnHeader() {
	$("#loginStaffName").text($.cookie("staffName"));
}

function copyToClipboard(element) {
	var $temp = $("<input>");
	$("body").append($temp);
	$temp.val($(element).text()).select();
	document.execCommand("copy");
	$temp.remove();
}

