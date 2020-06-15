<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<%@ include file="/include/head.jsp" %>
    <body>

        <!-- Aside Start-->
        <aside class="left-panel">

            <!-- brand -->
			<%@ include file="/include/brand.jsp" %>
            <!-- / brand -->
        
            <!-- Navbar Start -->
            <nav class="navigation">
                <ul class="list-unstyled">
                    <li class="has-submenu active"><a href="#"><i class="zmdi zmdi-view-dashboard"></i> <span class="nav-label">Campus</span></a>
                        <ul class="list-unstyled">
                        <!-- 
                            <li><a href="#">Room</a></li>
                            <li><a href="#">Classroom</a></li>
                            <li><a href="#">Consulting</a></li>
                            <li><a href="#">Request</a></li>
                            <li><a href="#">Activity</a></li>
                            <li><a href="#">Student Policy</a></li>
                            <li><a href="#">Travel Plan</a></li>
                        -->
                            <li><a href="/request/requestList.jsp">Request</a></li>
                            <li class="active"><a href="/notice/noticeList.jsp">Notice</a></li>
                            <li><a href="/freshman/freshmanList.jsp">Freshman's Guide</a></li>
                            <!-- <li><a href="/meal/meal.jsp">Meal Schedule</a></li> -->
                            <li><a href="/emergency/emergency.jsp">Emergency Contact</a></li>
                            <li><a href="/entrance/entranceRecordList.jsp">Entrance Records</a></li>
                        </ul>
                    </li>
                    <li class="has-submenu"><a href="/study/studyList.jsp"><i class="zmdi zmdi-collection-text"></i> <span class="nav-label">Academy</span></a>
                        <ul class="list-unstyled">
                            <li><a href="/study/studyList.jsp">Class Schedule</a></li>
                            <li><a href="/exam/examList.jsp">Examination & Results</a></li>
                            <li><a href="/attendance/attendanceList.jsp">Attendance</a></li>
                            <!--<li><a href="/evaluation/evaluationList.jsp">Evaluation</a></li>-->
                            <!-- <li><a href="#">Weekend Study</a></li>
                            <li><a href="#">Option Class</a></li> -->
                        </ul>
                    </li>
                    <li class="has-submenu"><a href="/student/studentList.jsp"><i class="zmdi zmdi-accounts"></i> <span class="nav-label">Student</span></a>
                    </li>
                    <li class="has-submenu"><a href="/staff/staffList.jsp"><i class="zmdi zmdi-run"></i> <span class="nav-label">Staff</span></a>
                    </li>
                    <!-- 
                    <li class="has-submenu"><a href="#"><i class="zmdi zmdi-format-list-bulleted"></i> <span class="nav-label">Tutor</span></a>
                    </li>
                    <li class="has-submenu"><a href="#"><i class="ion-grid"></i> <span class="nav-label">Staff</span></a>
                    </li>
                    -->
                </ul>
            </nav>

        </aside>
        <!-- Aside Ends-->


        <!--Main Content Start -->
        <section class="content">
            
            <!-- Header -->
            <%@ include file="/include/header.jsp" %>
            <!-- Header Ends -->


            <!-- Page Content Start -->
            <!-- ================== -->

            <div class="wraper container-fluid">
                <div class="page-title"> 
                    <h3 class="title">Notice</h3> 
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right ">
	                           <button type="button" class="btn btn-default m-b-5" id="historyBackButton">Back</button>
	                           <button type="button" class="btn btn-default m-b-5" id="sendMessageButton">Send Message</button>
	                           <button type="button" class="btn btn-default m-b-5" id="detailSaveButton">Save</button>
	                           <button type="button" class="btn btn-default m-b-5" id="detailDeleteButton">Delete</button>
                            </div>
			                
							<form class="cmxform form-horizontal tasi-form" role="form" id="detailForm" novalidate="novalidate">
                   			<div class="panel-body">
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Branch</label>
                                        <div class="col-md-7 control-label" id="detailBranchDiv" style="text-align:left;margin-left:10px">
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">Language</label>
                                        <div class="col-md-7 control-label" id="detailLanguageDiv" style="text-align:left;margin-left:10px">
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">Top of List</label>
                                        <div class="col-md-10">
                                            <div class="radio-inline">
                                                <label class="cr-styled">
                                                    <input type="radio" name="isTopOfList" value="true"> 
                                                    <i class="fa"></i>
                                                    Top 
                                                </label>
                                            </div>
                                            <div class="radio-inline">
                                                <label class="cr-styled">
                                                    <input type="radio" name="isTopOfList" value="false"> 
                                                    <i class="fa"></i> 
                                                    General
                                                </label>
                                            </div> 
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">Type</label>
                                        <div class="col-md-10">
                                            <div class="radio-inline">
                                                <label class="cr-styled">
                                                    <input type="radio" name="isPopup" value="true"> 
                                                    <i class="fa"></i>
                                                    Popup 
                                                </label>
                                            </div>
                                            <div class="radio-inline">
                                                <label class="cr-styled">
                                                    <input type="radio" name="isPopup" value="false"> 
                                                    <i class="fa"></i> 
                                                    General
                                                </label>
                                            </div>
                                        </div>
                                    </div> <!-- form-group -->
                                </div>

                                <div class="row" id="popupPeriodDiv">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Popup Period</label>
                                        <div class="col-md-10 form-inline" style="padding-left:20px">
			                                <div class="col-md-3 input-group">
			                                    <input type="text" class="form-control input-sm" placeholder="mm/dd/yyyy" id="popupStartDate" name="popupStartDate" required>
			                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                                </div><!-- input-group -->
			                                ~
			                                <div class="col-md-3 input-group">
			                                    <input type="text" class="form-control input-sm" placeholder="mm/dd/yyyy" id="popupEndDate" name="popupEndDate" required>
			                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                                </div><!-- input-group -->
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Writer</label>
                                        <div class="col-md-7 control-label" id="writer" style="text-align:left;margin-left:10px">
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Title</label>
                                        <div class="col-md-10">
	                                        <div class="col-md-12">
	                                            <input type="text" class="form-control input-sm" value="" placeholder="" name="title" id="title" required>
	                                        </div>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Attachement</label>
                                        <div class="col-md-10">
	                                        <div class="col-md-12 icon-list" id="attachmentDiv">
	                                        </div>
                                        </div>
                                        <input type="hidden" name="isDeleteAttachment" value="false"/>
                                    </div>
                                </div>
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">**</label>
                                        <div class="col-md-9" style="margin-left: 10px;">
                                        File uploading's Browser Support <br>IE10+ / FIREFOX 4.0+ / CHROME 7.0+ / SAFARI 5+ / OPERA 12+
                                        </div>
                                    </div>
                                </div>
                                                                
				                <div class="row">
                                    <div class="" style="display:none">
                                    		<label id="contentNote-error" class="error" for="contentNote"></label>
                                    </div>
				                    <div class="col-sm-12">
		                                <div class="summernote" id="contentNote"></div>
				                    </div>
				                </div>
                            </div>
	                   </form>
                        </div>
                    </div>
                </div>
                <!-- end row -->

            </div>
            <!-- Page Content Ends -->
            <!-- ================== -->
            
<form id="sendMessageForm">
<div id="sendMessageDiv" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
	<div class="modal-dialog modal-lg"> 
		<div class="modal-content"> 
			<div class="modal-header"> 
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button> 
				<h4 class="modal-title">Send a Message to the students</h4> 
			</div> 
			<div class="modal-body">
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-3" class="col-md-3 control-label">Ranges of Receiver</label> 
							<div class="col-md-8 radio-inline" id="rangesDiv">
							</div>
						</div> 
					</div> 
				</div>
				<div class="row">
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-4" class="col-md-3 control-label">Message</label> 
							<div class="col-md-8 radio-inline">
								<input type="text" placeholder="" class="form-control" id="sendMessageMessage" required maxlength="50" value="Please check the announcement in Pines Portal.">
								<input type="hidden" id="isForAllStudents">
								<input type="hidden" id="languageSeq">
								<input type="hidden" id="sendMessageSiteUrl">
							</div>
						</div> 
					</div> <!-- form-group -->
				</div>
			</div> 
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="sendMessageSendButton">Send</button>
			</div>			
		</div> 
	</div>
</div><!-- /.modal -->
</form>

            <!-- Footer Start -->
	        <%@ include file = "/include/footer.jsp" %>
            <!-- Footer Ends -->



        </section>
        <div id="api_mask"></div>
        <!-- Main Content Ends -->

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="/js/jquery.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="/js/modernizr.min.js"></script>
        <script src="/js/pace.min.js"></script>
        <script src="/js/wow.min.js"></script>
        <script src="/js/jquery.scrollTo.min.js"></script>
        <script src="/js/jquery.nicescroll.js"></script>

        <!-- sweet alerts -->
        <script src="/assets/sweet-alert/sweet-alert.min.js"></script>
        <script src="/assets/sweet-alert/sweet-alert.init.js"></script>

        <script src="/js/jquery.app.js"></script>

        <script src="/assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>

        <script src="/assets/timepicker/bootstrap-datepicker.js"></script>
        
        <!--form validation -->
        <script src="/assets/jquery.validate/jquery.validate.js"></script>
        
        <script src="/assets/summernote/summernote.min.js"></script>
        
        <!-- Modal-Effect -->
        <script src="/assets/modal-effect/js/classie.js"></script>
        <script src="/assets/modal-effect/js/modalEffects.js"></script>
        
        <script src="/js/jquery.session.js"></script>
        <script src="/js/jquery.cookie.js"></script>
        <script src="/custom/pia-ajaxs.js"></script>
        <script src="/custom/pia-tools.js"></script>
        <script src="/custom/pia-validate.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function() {

                $("#detailSaveButton").on("click", changeDetail);
                $("#detailDeleteButton").on("click", deleteDetail);

                $("#sendMessageButton").click(showSendMessage);
                $("#sendMessageSendButton").click(sendMessage);
                $("#sendMessageDiv").on("shown.bs.modal", function () {
                    $("#sendMessageMessage").focus();
                })
                
                setPopupRadioEvent();
                
        		getDetailData();
	        		
           		initPlugins();
            });
            
            function initPlugins() {
           		$("#detailForm").validate({
    	            errorPlacement: function(error, element) {
   	            		if (element.attr("name") == 'isTopOfList') {
   	            			error.insertBefore($("[name=isTopOfList]").first().parent().parent());
   	            		} else if (element.attr("name") == 'isPopup') {
   	            			error.insertBefore($("[name=isPopup]").first().parent().parent());
   	            		} else if (element.attr("name") == 'popupStartDate') {
   	            			error.insertAfter($("[name=popupStartDate]").parent());
   	            		} else if (element.attr("name") == 'popupEndDate') {
   	            			error.insertAfter($("[name=popupEndDate]").parent());
    					} else {
    		                error.insertBefore(element);
    					}
    	            }
    	        });
           		
           		var defaultDetepickerOptions = {format : "yyyy/mm/dd"};
        		$("#popupStartDate").datepicker(defaultDetepickerOptions).on("changeDate", function(e){
       			    $(this).datepicker("hide");
       			});
        		$("#popupEndDate").datepicker(defaultDetepickerOptions).on("changeDate", function(e){
       			    $(this).datepicker("hide");
       			});
        		
        		$("#popupStartDate").change(function() {
	        		$(this).valid();
        		});
        		$("#popupEndDate").change(function() {
	        		$(this).valid();
        		});
        		
        		var defaultSummernoteOptions = {
   	                height: 400,                 // set editor height
   	                minHeight: null,             // set minimum height of editor
   	                maxHeight: null,             // set maximum height of editor
   	                focus: true                 // set focus to editable area after initializing summernote
   	            };
        		
        		$("#contentNote").summernote($.extend({}, defaultSummernoteOptions, {
        			onChange: function() {
	        	    	$("label[for=contentNote]").append("");
	        	    	$("label[for=contentNote]").css("display", "none");
	        	    	$("label[for=contentNote]").parent().css("display", "none");
	            }}));
            }

            function setPopupRadioEvent() {
    			$("[name=isPopup]").on("change", function () {
    				if (getBoolean($(this).val())) {
	        			$("#popupPeriodDiv").css("display", "");
		        		$("#popupStartDate").attr("required", true);
		        		$("#popupEndDate").attr("required", true);
					} else {
        				$("#popupPeriodDiv").css("display", "none");
		        		$("#popupStartDate").datepicker("setDate", "");
		        		$("#popupEndDate").datepicker("setDate", "");
		        		$("#popupStartDate").attr("required", false);
		        		$("#popupEndDate").attr("required", false);
					}
    			});
            }
            
            function getDetailData() {
				var branchSeq = getUrlParameter("branchSeq");
				var noticeSeq = getUrlParameter("noticeSeq");
				if (!noticeSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}
				
                var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/notices/" + noticeSeq;
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "GET",
            		dataType : "json",
            		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
            		success : getDetailSuccessFnc,
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
            		},
					complete : function(jqXHR, textStatus) {
						closeWindowByMask();
					}
            	});
            }
            
            function getDetailSuccessFnc(response) {
        		if (response.head.status == 200) {
        			var $data = response.body.data;
        			if (response.body.totalCount > 0) {
	        			//console.log("data : ", $data);
		        		$("#registerDateWriter").text($data.registerDate + " - " + $data.writer);
	        			$("#detailBranchDiv").html($data.branch);
	        			var languageHtml = $data.language;
	        			if (getBoolean($data.isForAll)) {
	        				languageHtml += " <b>(For All of Students)</b>";
						}
			        			
	        			$("#detailLanguageDiv").html(languageHtml);
	        			$("#writer").text($data.writer);
	        			
	        			setRadioValue("isTopOfList", $data.isTopOfList);
	        			setRadioValue("isPopup", $data.isPopup);
			        			
	        			if ($data.isPopup) {
	        				$("#popupPeriodDiv").css("display", "");
			        		$("#popupStartDate").datepicker("setDate", $data.popupStartDate);
			        		$("#popupEndDate").datepicker("setDate", $data.popupEndDate);
			        		$("#popupStartDate").attr("required", true);
			        		$("#popupEndDate").attr("required", true);
						} else {
	        				$("#popupPeriodDiv").css("display", "none");
			        		$("#popupStartDate").attr("required", false);
			        		$("#popupEndDate").attr("required", false);
						}
		        			
		        		$("#title").val($data.title);
		        		$("#contentNote").code($data.content);
				        		
		        		if(getBoolean($data.hasAttachment)) {
		        			$("#attachmentDiv").html("<i class=\"fa fa-paperclip\"></i> <a href=\"#\" style=\"cursor:pointer\" id=\"attachDownloadButton\" filePath=\"" + $data.fileDownloadUrl + "\">" + $data.downloadFilename + "</a>");
			        		$("#attachmentDiv").append("<i class=\"fa fa-trash-o\" style=\"cursor:pointer\" id=\"removeOriginalFile\"></i>");
	
			        		$("#attachDownloadButton").on("click", function() {
			        			fileDownload($(this).attr("filePath"), $(this).text());
			        		});
			        		$("#removeOriginalFile").on("click", removeOriginalFile);
		        		} else {
		        			$("#attachmentDiv").html("<input type=\"file\" name=\"attachmentFile\" class=\"form-control input-sm\"/>");
		        		}
		        		

		            	$("#isForAllStudents").val(getBoolean($data.isForAll));
		            	$("#languageSeq").val($data.languageSeq);
					}
	        			
        			initValidateRadioButtons(["isTopOfList", "isPopup"]);
        		} else if (response.head.status == 401) {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]", function() {
						window.location.replace("/login.jsp");
					});
				} else {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]");
				}
        	}

            function removeOriginalFile() {
           		$("[name=isDeleteAttachment]").val(true);
        		$("#attachmentDiv").html("<input type=\"file\" name=\"attachmentFile\" class=\"form-control input-sm\"/>");
            }
            
            function changeDetail() {
           		var firstCheck = $("#detailForm").valid();
           		var secodCheck = noticeValidate(); 
           		if (!firstCheck || !secodCheck) {
					return false;	
				}
           		
				var branchSeq = getUrlParameter("branchSeq");
				var noticeSeq = getUrlParameter("noticeSeq");
				if (!noticeSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				if ($("[name=attachmentFile]")[0] && $("[name=attachmentFile]")[0].files[0]) {
					if (isNotAcceptableFileSize('<%=MAXIMUM_FILE_UPLOAD_SIZE%>', $("[name=attachmentFile]")[0].files[0].size)) {
						alert("Too Large Size of the File.");
						$(this).val("");
						return false;
					}
				}
				
                var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/notices/" + noticeSeq;
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "POST",
            		data : getFormData(),
            		dataType : "json",
            		enctype: 'multipart/form-data',
            		processData: false,
            		contentType: false,
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
            		success : function(data, textStatus, jqXHR) {
		        		if (data.head.status == 200) {
						openSwal(data.head.message, "");
						getDetailData();
					} else {
						openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
					}
            		},
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
            		},
					complete : function(jqXHR, textStatus) {
						closeWindowByMask();
					}
            	});
            }
            
            function getFormData() {
				var formData = new FormData();
				formData.append("title", $("#title").val());
				formData.append("isTopOfList", $("[name=isTopOfList]:checked").val());
				formData.append("isPopup", $("[name=isPopup]:checked").val());
				if (getBoolean($("[name=isPopup]:checked").val())) {
					formData.append("popupStartDate", $("#popupStartDate").val());
					formData.append("popupEndDate", $("#popupEndDate").val());
				} else {
					formData.append("popupStartDate", "");
					formData.append("popupEndDate", "");
				}
				if ($("[name=attachmentFile]")[0]) {
					if ($("[name=attachmentFile]")[0].files[0]) {
						formData.append("attachment", $("[name=attachmentFile]")[0].files[0]);
						formData.append("hasAttachment", true);
					}
				} else {
					formData.append("hasAttachment", false);
				}
				formData.append("content", $("#contentNote").code());
				formData.append("isDeleteAttachment", $("[name=isDeleteAttachment]").val());
				return formData;
            }
            
            function noticeValidate() {
            	var returnVal = true;
            	if (!$("#contentNote").code()) {
            		$("label[for=contentNote]").append("This field is required.");
            		$("label[for=contentNote]").css("display", "");
            		$("label[for=contentNote]").parent().css("display", "");
            		returnVal = false;
            	}
            	return returnVal;
            }            
            
            function deleteDetail() {
				var branchSeq = getUrlParameter("branchSeq");
				var noticeSeq = getUrlParameter("noticeSeq");
				if (!noticeSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}
				
                var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/notices/" + noticeSeq;
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "DELETE",
            		dataType : "json",
            		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
            		success : function(data, textStatus, jqXHR) {
		        		if (data.head.status == 200) {
						openSwal(data.head.message, "", function() {
							window.history.back(1);
						});
					} else {
						openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
					}
            		},
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
            		},
					complete : function(jqXHR, textStatus) {
						closeWindowByMask();
					}
            	});
            }

            function showSendMessage() {
            	var branch = "<b>Branch</b> : " + $("#detailBranchDiv").html();
    			var language = "<b>Language</b> : " + $("#detailLanguageDiv").html();
            	$("#rangesDiv").html(branch + "<br>" + language);
            	$("#sendMessageSiteUrl").val("<%=PORTAL_URL%>/02_04_00_campus.html");
           		$("#sendMessageDiv").modal();
            }

            function sendMessage() {
            	if (!$("#sendMessageMessage").val()) {
            		alert("Please put message.");
            		$("#sendMessageMessage").focus();
					return false;
				}

				var params = {
					noticeSeq : getUrlParameter("noticeSeq"),
					message : $("#sendMessageMessage").val(),
					site : $("#sendMessageSiteUrl").val(),
					menu : "Campus > Notice",
					site : "<%=PORTAL_URL%>/02_04_00_campus.html"
				};
				
				var jsonParams = JSON.stringify(params);
        		var url = "<%=SERVER_URL%>/students/push";
	           	$.ajax({
	           		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	           		url : url,
	           		data : jsonParams,
	           		type : "POST",
	           		dataType : "json",
	           		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
	   				success : function(data, textStatus, jqXHR) {
        				if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
		   						return false;
							});
       					}
        				
        				openSwal(data.head.message, "Sending Messages Success : " + data.body.data.success + ", Failure : " + data.body.data.failure, function () {
        					$("#sendMessageDiv").modal("hide");
        				});
   	        		},
	           		error : function(jqXHR, textStatus, errorThrown) {
	           			console.log(jqXHR, textStatus, errorThrown);
	           		},
	   				complete : function(jqXHR, textStatus) {
       					$("#sendMessageDiv").modal("hide");
	   					closeWindowByMask();
	   				}
	           	});
            }
            
            setStaffNameOnHeader();
        </script>
    

    </body>
</html>
