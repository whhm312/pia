<!DOCTYPE html>
<html lang="en">
	<%@ include file="/include/head.jsp" %>
	<style>
		.table > tbody > tr > td, .table > tbody > tr > th {
			vertical-align: middle;
		}
	</style>
    <body>

        <!-- Aside Start-->
        <aside class="left-panel">

            <!-- brand -->
			<%@ include file="/include/brand.jsp" %>
            <!-- / brand -->
        
            <!-- Navbar Start -->
            <nav class="navigation">
                <ul class="list-unstyled">
                    <li class="has-submenu"><a href="#"><i class="zmdi zmdi-view-dashboard"></i> <span class="nav-label">Campus</span></a>
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
                            <li><a href="/notice/noticeList.jsp">Notice</a></li>
                            <li><a href="/freshman/freshmanList.jsp">Freshman's Guide</a></li>
                            <!-- <li><a href="/meal/meal.jsp">Meal Schedule</a></li> -->
                            <li><a href="/emergency/emergency.jsp">Emergency Contact</a></li>
                            <li><a href="/entrance/entranceRecordList.jsp">Entrance Records</a></li>
                        </ul>
                    </li>
                    <li class="has-submenu active"><a href="/study/studyList.jsp"><i class="zmdi zmdi-collection-text"></i> <span class="nav-label">Academy</span></a>
                        <ul class="list-unstyled">
                            <li><a href="/study/studyList.jsp">Class Schedule</a></li>
                            <li class="active"><a href="/exam/examList.jsp">Examination & Results</a></li>
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
                    <h3 class="title">Examination & Results</h3>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right ">
	                           <button type="button" class="btn btn-default m-b-5" id="historyBackButton">Back</button>
	                           <button type="button" class="btn btn-default m-b-5" id="sendMessageButton">Send Message</button>
	                           <button type="button" class="btn btn-default m-b-5" id="detailDeleteButton">Delete</button>
	                           <button type="button" class="btn btn-default m-b-5" id="applicantStudentsDownloadButton" style="display: none">Applied Students Download</button>
                            </div>
							<div class="panel-body">
								<div class="row">
									<div class="form-group">
										<div class="col-md-4 col-sm-4">
											<h4>Branch : <span id="detailBranchDiv"></span></h4> 
										</div>
										<div class="col-md-4 col-sm-4">
											<h4>Campus : <span id="detailCampusDiv"></span></h4> 
										</div>
										<div class="col-md-4 col-sm-4">
											<h4>Term : <span id="detailTermDiv"></span></h4> 
										</div>
										<input type="hidden" name="branchSeq" id="branchSeq"/>
										<input type="hidden" name="campusSeq" id="campusSeq"/>
										<input type="hidden" name="termSeq" id="termSeq"/>
									</div>
								</div>

								<div class="row">
									<div class="form-group">
										<div class="col-md-4 col-sm-4">
											<h4>Examination Date : <span id="examDateDiv"></span></h4> 
										</div>
										<div class="col-md-4 col-sm-4">
											<h4>Examination Type : <span id="examTypeDiv"></span></h4> 
										</div>
									</div>
								</div>								
							</div>
                        </div>
                    </div>
                </div>
                <!-- end row -->
                
				<div class="row">
					<div class="form-group text-center">
						** File uploading's Browser Support IE10+ / FIREFOX 4.0+ / CHROME 7.0+ / SAFARI 5+ / OPERA 12+ **
					</div>
				</div>
                <!-- end row -->
                
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<table class="table table-hover" id="listTable">
											<thead>
												<tr>
													<th class="text-center" width="10%">No</th>
													<th class="text-center" width="10%">Level</th>
													<th class="text-center" width="20%">Name of Student</th>
													<th class="text-center" width="10%">Birthdate</th>
													<th class="text-center" width="15%">Result</th>
													<th class="text-center" width="5%"></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
								</div>							
							</div>
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
								<input type="text" placeholder="" class="form-control" id="sendMessageMessage" required maxlength="50" value="Please check your schedule in Pines Portal.">
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
        <script src="/js/jquery.nicescroll.js" type="text/javascript"></script>

        <!-- sweet alerts -->
        <script src="/assets/sweet-alert/sweet-alert.min.js"></script>
        <script src="/assets/sweet-alert/sweet-alert.init.js"></script>

        <script src="/js/jquery.app.js"></script>

        <script src="/assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
        
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
        <script type="text/javascript">
            jQuery(document).ready(function() {
           		initPlugins();
	        		
        		$("#detailDeleteButton").on("click", deleteDetail);
				$("#applicantStudentsDownloadButton").on("click", function() {
					var examSeq = getUrlParameter("examSeq");
					var url = "<%=SERVER_URL%>/exams/" + examSeq + "/students/download";
					window.location = url;
				});
				
                $("#sendMessageButton").click(showSendMessage);
                $("#sendMessageSendButton").click(sendMessage);
                $("#sendMessageDiv").on("shown.bs.modal", function () {
                    $("#sendMessageMessage").focus();
                })
                
           		getDetailData();
            });

            function initPlugins() {
            }
            
			function getDetailData() {
				var branchSeq = getUrlParameter("branchSeq");
				var campusSeq = getUrlParameter("campusSeq");
				var termSeq = getUrlParameter("termSeq");
				var examSeq = getUrlParameter("examSeq");
				if (!examSeq || !campusSeq || !termSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}
				
				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termSeq + "/exams/" + examSeq; 
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
	        			console.log("data : ", $data);
	        			
		        		$("#registerDateWriter").text($data.registerDate + " - " + $data.writer);
	        			$("#detailBranchDiv").html($data.branch);
	            		$("#branchSeq").val($data.branchSeq);
	        			$("#detailCampusDiv").html($data.campus);
	            		$("#campusSeq").val($data.campusSeq);
		        		$("#detailTermDiv").html($data.term);
	            		$("#termSeq").val($data.termSeq);
	            		
	            		if ($data.examEndDate) {
			        		$("#examDateDiv").html($data.examStartDate + " ~ " + $data.examEndDate);
						} else {
			        		$("#examDateDiv").html($data.examStartDate);
						} 
		        		$("#examTypeDiv").html($data.examType);
		        		if ($data.examType == "OPT") {
		        			$("#applicantStudentsDownloadButton").show();
						}
		        		
	            		gridResults($data.results);
					}
        		} else if (response.head.status == 401) {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]", function() {
						window.location.replace("/login.jsp");
					});
				} else {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]");
				}
        	}
            
            function gridResults(data) {
        		//console.log(data);
        		//console.log(data.studentStudySchedules);
        		var html = "";
        		var totalCount = data.length;
        		$("#listTable tbody").empty();
        		if (data.length < 1) {
	        		$("#listTable tbody").append("<tr><td class=\"text-center\" colspan=\"6\">No data.</td></tr>");
				}
        		
           		$.each(data, function(index, item) {
           			html = "<tr>";
	        		html += "<td class=\"text-center\">" + (totalCount--) + "</td>";
	        		html += "<td class=\"text-center\">" + item.level + "</td>";
	        		html += "<td class=\"text-center\">" + item.studentName + "</td>";
	        		html += "<td class=\"text-center\">" + item.birthday + "</td>";
	        		if (item.resultFilePath) {
		        		html += "<td class=\"text-center\">";
	        			html += "<button type=\"button\" class=\"btn btn-default m-b-5\" id=\"downloadButton\" filePath=\"" + item.resultFilePath + "\" fileName=\"" + item.studentName + "\">Uploaded (" + item.registerDate + ")</button>";
		        		html += "<td class=\"text-center\">";
		        		html += "<i class=\"fa fa-trash-o\" style=\"cursor:pointer\" id=\"removeResultFile\" resultSeq=\"" + item.examResultSeq + "\" ></i>";
		        		html += "</td>";
					} else {
		        		html += "<td class=\"text-center\">";
		        		html += "<div class=\"fileUpload btn btn-default m-b-5\">";
		        		html += "<span>Upload</span>";
		        		html += "<input type=\"file\" class=\"upload\" name=\"resultsUploadButton\" levelSeq=\"" + item.levelSeq + "\" studentId=\"" + item.studentId + "\"/>";
		        		//html += "<input type=\"file\" class=\"upload\" id=\"resultsUploadButton\" accept=\".pdf\" levelSeq=\"" + item.levelSeq + "\" studentId=\"" + item.studentId + "\"/>";
		        		html += "</div>";
		        		html += "</td>";
		        		html += "<td class=\"text-center\">";
		        		html += "</td>";
					}
	        		html += "</tr>";
	        		$("#listTable tbody").append(html);
           		});
            		
           		$("[id=removeResultFile]").on("click", deleteExamResult);
           		$("[name=resultsUploadButton]").on("change", uploadResultFile);
       			$("#downloadButton").on("click", function() {
        			fileDownload($(this).attr("filePath"), $(this).attr("fileName"));
       			});
            }

            function uploadResultFile() {
        		if (!$(this)[0].files[0]) {
					return false;
				}
        		
				var branchSeq = getUrlParameter("branchSeq");
				var campusSeq = getUrlParameter("campusSeq");
				var termSeq = getUrlParameter("termSeq");
				var examSeq = getUrlParameter("examSeq");
				if (!examSeq || !campusSeq || !termSeq || !branchSeq) {
					alert("lack of data.");
					$(this).val("");
					return false;
				}

				var studentId = $(this).attr("studentId");
				var levelSeq = $(this).attr("levelSeq");
				if (!studentId || !levelSeq) {
					alert("lack of data.");
					$(this).val("");
					return false;
				}
				
				if ($(this)[0].files[0]) {
					if (isNotAcceptableFileSize('<%=MAXIMUM_FILE_UPLOAD_SIZE%>', $(this)[0].files[0].size)) {
						alert("Too Large Size of the File.");
						$(this).val("");
						return false;
					}
				}
				
				var formData = new FormData();
				formData.append("file", $(this)[0].files[0]);
				formData.append("studentId", studentId);
				formData.append("levelSeq", levelSeq);

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termSeq + "/exams/" + examSeq + "/results";
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "POST",
            		data : formData,
            		dataType : "json",
            		enctype: 'multipart/form-data',
            		processData: false,
            		contentType: false,
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
            		success : function(data, textStatus, jqXHR) {
		        		if (data.head.status == 200) {
							openSwal(data.head.message, "", function() {
								closeWindowByMask();
								getDetailData();
							});
		        		} else if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
							});
		        		} else if (data.head.status == 413) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function (){
								closeWindowByMask();
							});
						} else {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function (){
								closeWindowByMask();
							});
						}
            		},
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
            			closeWindowByMask();
					}
            	});
            }

            function deleteExamResult() {
				var branchSeq = getUrlParameter("branchSeq");
				var campusSeq = getUrlParameter("campusSeq");
				var termSeq = getUrlParameter("termSeq");
				var examSeq = getUrlParameter("examSeq");
				var resultSeq = $(this).attr("resultSeq");
				if (!resultSeq || !examSeq || !campusSeq || !termSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termSeq + "/exams/" + examSeq + "/results/" + resultSeq;
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
								closeWindowByMask();
								getDetailData();
							});
		        		} else if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
							});
						} else {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
							closeWindowByMask();
						}
            		},
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
						closeWindowByMask();
					}
            	});
            }
            
            function deleteDetail() {
				var branchSeq = getUrlParameter("branchSeq");
				var campusSeq = getUrlParameter("campusSeq");
				var termSeq = getUrlParameter("termSeq");
				var examSeq = getUrlParameter("examSeq");
				if (!examSeq || !campusSeq || !termSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termSeq + "/exams/" + examSeq;
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
								closeWindowByMask();
								window.location.replace("examList.jsp");
							});
						} else {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
							closeWindowByMask();
						}
            		},
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
						closeWindowByMask();
					}
            	});
            }

            function showSendMessage() {
            	if ($("#listTable").find("td").length <= 1) {
            		if ($("#listTable").find("td").first().text() == "No data.") {
	            		alert("Sending a message is not available without students.");
						return false;
					}
				}
            	
            	var branch = "<b>Branch</b> : " + $("#detailBranchDiv").html();
    			var campus = "<b>Campus</b> : " + $("#detailCampusDiv").html();
    			var term = "<b>Term</b> : " + $("#detailTermDiv").html();
    			var examDate = "<b>Examination Date</b> : " + $("#examDateDiv").html();
    			var examType = "<b>Examination Type</b> : " + $("#examTypeDiv").html();
        		
            	$("#rangesDiv").html(branch + "<br>" + campus + "<br>" + term + "<br>" + examDate + "<br>" + examType);
            	$("#sendMessageSiteUrl").val("<%=PORTAL_URL%>/02_03_00_education.html");
           		$("#sendMessageDiv").modal();
            }

            function sendMessage() {
            	if (!$("#sendMessageMessage").val()) {
            		alert("Please put message.");
            		$("#sendMessageMessage").focus();
					return false;
				}

				var params = {
					examSeq : getUrlParameter("examSeq"),
					message : $("#sendMessageMessage").val(),
					site : $("#sendMessageSiteUrl").val(),
					menu : "Academy > Examination & Results"
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
