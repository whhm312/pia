<%@ page import="java.net.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>

<%
String ipAddress="",
	   macAddress="",
	   EAP_SERVER = "http://192.168.31.1:9090",
	   AP = "ap_mac",
	   SSID = "ssid_name",
	   T = "time_since_epoch",
	   RID = "Radio_id",
	   SITE = "PinesPortal"
	   ;

InetAddress inetAddress;
StringBuilder sb = new StringBuilder();
int i=0;
try {
    inetAddress=InetAddress.getLocalHost();
    ipAddress=inetAddress.getHostAddress();
    NetworkInterface network=NetworkInterface.getByInetAddress(inetAddress);
     byte[] hw=network.getHardwareAddress();
     for(i=0; i<hw.length; i++)
        sb.append(String.format("%02X%s", hw[i], (i < hw.length - 1) ? "-" : 
         ""));    
    macAddress=sb.toString();
  } catch(Exception e) {
   out.print("<br/>"+e.toString());
    macAddress="-";
  }
  out.print("<br/>"+ipAddress);
  out.print("<br/>"+macAddress);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
    <meta name="viewport" content="width=device-width, initial-scale=1.0 ,maximum-scale=1.0, minimum-scale=1.0,user-scalable=no,target-densitydpi=medium-dpi">        
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/i18next/1.9.0/i18next.min.js"></script>
	<script type="text/javascript" src="js/common.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<script type="text/javascript" src="js/md5.min.js"></script>
	<script type="text/javascript" src="js/base64.js"></script>
	<script type="text/javascript" src="js/jquery.cookie.js"></script>
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link href="css/common.css" rel="stylesheet" type="text/css">	
	<link href="css/reset.css" rel="stylesheet" type="text/css">
	<script>
	$(document).ready(function() {
		$.cookie("token", "");
		$.cookie("userId", "");
		$.cookie("token", "");
		$.cookie("name", "");
		$.cookie("branchSeq", "");
		$.cookie("nationalitySeq", "");
		$.cookie("languageSeq", "");
		$.cookie("showEmergencyContactPopup", true, {expires : 1});
		
		//$("#signinButton").click(signin);
		$("#signinButton").click(eapAdminSignin);
		$("#donotShowEmergencyButton").click(donotShowEmergency);
		
		var cookieChangeLang = $.cookie("changeLang");
		if (!cookieChangeLang) {
			cookieChangeLang = "en";
		}
		changeLang(cookieChangeLang);
	});
	
	function eapAdminSignin() {
		var eapUrl = "<%=EAP_SERVER%>" + "?";
		eapUrl += "cid=" + "<%=macAddress%>";
		eapUrl += "&";
		eapUrl += "ap=" + "<%=AP%>";
		eapUrl += "&";
		eapUrl += "ssid=" + "<%=SSID%>";
		eapUrl += "&";
		eapUrl += "t=" + "<%=T%>";
		eapUrl += "&";
		eapUrl += "rid=" + "<%=RID%>";
		eapUrl += "&";
		eapUrl += "site=" + "<%=SITE%>";
		alert(eapUrl);
		return false;
		
		$.ajax({
			headers : "",
			url : eapUrl,
			type : "POST",
			data : getJsonData(),
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			beforeSend : function(jqXHR, settings) {
				blockScreen();
			},
			success : function(data, textStatus, jqXHR) {
				if (data.head.status == 200) {
					var $result = data.body.data;
					//console.log($result);
					
					if ($result.isBlocked) {
						$("#popupT02").css("display", "");
						$(".popup_over").css("display", "");
					} else {
						var token_id = $("#username").val();
						var token_pw = md5($("#password").val());
						var token = "Basic " + Base64.encode(token_id + ":" + token_pw);
						$.cookie("userId", token_id);
						$.cookie("token", token);
						$.cookie("name", $result.name);
						$.cookie("branchSeq", $result.branchSeq);
						$.cookie("nationalitySeq", $result.nationalitySeq);
						$.cookie("languageSeq", $result.languageSeq);
						setLanguage($result.language);
						
						if ($result.isTraveling) {
							gridEmergencyContact($result.emergencyContacts, $result.notices);
						} else {
							if ($result.notices.length > 0) {
								gridNotices($result.notices);
							} else {
								window.location.replace("02_03_00_education.html");
							}
						}
						
					}
				} else {
					alert("Login Failed!!");
					$("#password").val("");
					console.log("ERROR -----------\n ", data.head.status, data.head.message);
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log("error", jqXHR, textStatus, errorThrown);
				alert("Server Error. Please try again later.");
			},
			complete : function(jqXHR, textStatus) {
				unBlockScreen();
			}
		});
	}
	function signin() {
		//console.log(getJsonData());
		$.ajax({
			headers : "",
			url : SERVER_URI + "/login",
			type : "POST",
			data : getJsonData(),
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			beforeSend : function(jqXHR, settings) {
				blockScreen();
			},
			success : function(data, textStatus, jqXHR) {
				if (data.head.status == 200) {
					var $result = data.body.data;
					//console.log($result);
					
					if ($result.isBlocked) {
						$("#popupT02").css("display", "");
						$(".popup_over").css("display", "");
					} else {
						var token_id = $("#username").val();
						var token_pw = md5($("#password").val());
						var token = "Basic " + Base64.encode(token_id + ":" + token_pw);
						$.cookie("userId", token_id);
						$.cookie("token", token);
						$.cookie("name", $result.name);
						$.cookie("branchSeq", $result.branchSeq);
						$.cookie("nationalitySeq", $result.nationalitySeq);
						$.cookie("languageSeq", $result.languageSeq);
						setLanguage($result.language);
						
						if ($result.isTraveling) {
							gridEmergencyContact($result.emergencyContacts, $result.notices);
						} else {
							if ($result.notices.length > 0) {
								gridNotices($result.notices);
							} else {
								window.location.replace("02_03_00_education.html");
							}
						}
						
					}
				} else {
					alert("Login Failed!!");
					$("#password").val("");
					console.log("ERROR -----------\n ", data.head.status, data.head.message);
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log("error", jqXHR, textStatus, errorThrown);
				alert("Server Error. Please try again later.");
			},
			complete : function(jqXHR, textStatus) {
				unBlockScreen();
			}
		});
	}
	
	function gridNotices($notices) {
		var html = "";
		$.each($notices, function(index, item) {
			html = "";
			html += "<div class=\"popup\" style=\"min-height: 300px; display:none;\" name=\"popupNotices\">";
			html += "<h4>" + item.title + "</h4>";
			html += "<div class=\"popupContents\">";
			html += "<p>" + item.content + "</p>";
			html += "<p class=\"date\"><span data-i18n=\"popup:registration\"></span><b>" + item.registerDate + " (" + item.writer + ")</b></p>";
			html += "</div>";
			html += "<div class=\"popupFooter\">";
			html += "<div class=\"popupFooter_close\" data-i18n=\"common:close\" name=\"closePopupNoticesButton\"></div>";
			html += "</div>";
			html += "</div>";
			
			$(".popup_over").after(html);
		});
		
		if ($notices.length > 0) {
			$("[name=popupNotices]").i18n();
			$(".popup_over").css("display", "");
			$("[name=popupNotices]").css("display", "");
		}
		
		$("[name=closePopupNoticesButton]").click(function() {
			$(this).parent().parent().css("display", "none");
			$(this).parent().parent().remove();
			
			if (isLastNoticePopup()) {
				$(".popup_over").css("display", "none");
				window.location.replace("02_03_00_education.html");
			}
		});
	}
	
	function isLastNoticePopup() {
		if ($("[name=closePopupNoticesButton]").length == 0) {
			return true;
		}
		return false;
	}

	function gridEmergencyContact($contacts, $notice) {
		if ($.cookie("showEmergencyContactPopup") == "true") {
			$("#emergencyContacts").empty();
			$.each($contacts, function(index, item) {
				var html = "";
				html += "<li>";
				html += "<a href=\"tel:" + item.contact + "\">";
				html += "<h5>" + item.name + " (" + item.nationality + ")</h5>";
				html += "<p>" + item.contact + "</p>";
				html += "</a>";
				html += "</li>";
				$("#emergencyContacts").append(html);
			});
			
			unBlockScreen();
			
			$("body").scrollTop(0);
			$(".popup_over").css("display", "");
			$("#popupEmergencyContacts").css("display", "");
			
			$("#closeEmergencyContactPopupButton").click(function() {
				$("#popupEmergencyContacts").css("display", "none");
				
				if ($notice.length < 1) {
					$(".popup_over").css("display", "none");
					window.location.replace("02_03_00_education.html");
				} else {
					gridNotices($notice);
				}
			});	
			
		}
	}
	
	function blockScreen() {
		$(".loading_popup_over").css("display", "");
		$(".loading").css("display", "");
	}

	function unBlockScreen() {
		$(".loading_popup_over").css("display", "none");
		$(".loading").css("display", "none");
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
		}
	}
	
	function getJsonData() {
		return JSON.stringify({
			studentId : $("#username").val(),
			password : md5($("#password").val())
		});
	}
	
	function donotShowEmergency() {
		if ($("#donotShowEmergencyButton").attr("class") == "on") {
			$("#donotShowEmergencyButton").attr("class", "");
			$.cookie("showEmergencyContactPopup", true, {expires : 1});
		} else {
			$("#donotShowEmergencyButton").attr("class", "on");
			$.cookie("showEmergencyContactPopup", false, {expires : 1});
		}
	}
	</script>
</head>
<body class="translation" style="background-color: #e9ebef;">
	
	<div id="singIn">
		<h2 id="signinLogo"><img src="img/logo.png" /></h2>
		<hr />
		<input type="text" data-i18n="[placeholder]signin:id" id="username" value=""/>	
		<input type="password" data-i18n="[placeholder]signin:pw" id="password" value=""/>			
		<button type="button" class="basic" data-i18n="signin:signIn" id="signinButton"></button>
		<p class="SignINpw" data-i18n="signin:SignINpw"></p>
	</div>
		<p class="copyright">COPYRIGHT 2017 PINES ALL RIGHT RESERVED</p>	


    <div class="popup_over" style="display:none"></div>
    
    <!-- Popup Emergency contacts -->
    <div class="popup" id="popupEmergencyContacts" style="display:none">
    
        <h4 data-i18n="popup:tourContact"></h4>
        <div class="popupContents">
            <ul class="listT01" id="emergencyContacts">
            </ul>
        </div>
        
        <div class="popupFooter">
            <div class="popupFooter_check"><span id="donotShowEmergencyButton"></span><b style="font-weight: normal; " data-i18n="popup:dontShow"></b></div>
            <div class="popupFooter_close" data-i18n="common:close" id="closeEmergencyContactPopupButton"></div>
        </div>
    
    </div>
    
    <!-- Block student sign in -->
    <div id="popupT02" style="display:none">
      <h4><i class="fa fa-exclamation-triangle" aria-hidden="true"></i><p data-i18n="popup:essential"></p></h4>
        <div>
        <p data-i18n="popup:blockMessage1"></p>
        <p data-i18n="popup:blockMessage2"></p><br>
        <p data-i18n="popup:blockMessage3"></p>
        <p data-i18n="popup:blockMessage4"></p>
        </div>
    </div>    
        
    <div class="loading_popup_over" style="display:none"></div>
	<img src="img/loading.svg" class="loading" style="display:none"/>
</body>
</html>