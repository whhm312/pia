<!DOCTYPE html>
<html lang="en">
	<%@ include file="/include/head.jsp" %>
	<style>
		.table > tbody > tr > td, .table > tbody > tr > th {
			vertical-align: middle;
		}
/* 		.clearfix > div {
			cursor : default;
		} */
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
                            <li class="active"><a href="/study/studyList.jsp">Class Schedule</a></li>
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
                    <h3 class="title">Class Schedule</h3> 
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right ">
	                           <button type="button" class="btn btn-default m-b-5" id="studyBackButton">Back</button>
	                           <button type="button" class="btn btn-default m-b-5" id="detailDeleteButton">Delete</button>
	                           <button type="button" class="btn btn-default m-b-5" id="sendMessageButton">Send Message</button>
	                           <button type="button" class="btn btn-default m-b-5" id="detailDownloadStudentsButton">Download Students</button>
	                           <button type="button" class="btn btn-default m-b-5" id="detailValidateButton">Validate</button>
	                           <button type="button" class="btn btn-default m-b-5" id="detailDownloadTeachersButton">Download Teachers Schedule</button>
                            </div>
							<div class="panel-body">
								<div class="row text-center">
									<div class="form-group">
										<div class="col-md-4 col-sm-4">
											<h4>Branch : <span id="detailBranchDiv"></span></h4> 
										</div>
										<div class="col-md-4 col-sm-4">
											<h4>Campus : <span id="detailCampusDiv"></span></h4> 
										</div>
										<div class="col-md-4 col-sm-4">
											<h4>Term of Schedule : <span id="detailTermDiv"></span></h4> 
										</div>
										<input type="hidden" name="branchSeq" id="branchSeq"/>
										<input type="hidden" name="campusSeq" id="campusSeq"/>
										<input type="hidden" name="termDetailSeq" id="termDetailSeq"/>
									</div>
								</div>
							</div>
                        </div>
                    </div>
                </div>
                <!-- end row -->
                
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right">
                                <div class="fileUpload btn btn-default m-b-5">
                                    <span>Levels Upload</span>
                                    <input type="file" class="upload" id="levelUploadButton" accept=".xlsx,.xls"/>
                                </div>                            
                            </div>
                            <div class="panel-body">
								<section class="icon-list ionicon-list" id="failedLevelGroupingsSection">
								</section>
							</div>                            
                            <div class="panel-body">
								<section class="icon-list ionicon-list" id="levelGroupingsSection">
								</section>                            
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end row -->
                
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right">
                            		<input type="button" class="btn btn-default m-b-5"  id="showIimetableUploadButton" value="Timetable Upload">
                                <div class="fileUpload btn btn-default m-b-5" style="display:none;">
                                    <span>Timetable Upload</span>
                                    <input type="file" class="upload" id="timetableUploadButton" accept=".xlsx,.xls"/>
                                </div>                            
                            </div>
                            
                            <div class="panel-body">
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<table class="table table-bordered" id="timetableTable">
											<thead>
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
                
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right">
                            		<div style="display: none; float: left" id="informingDiv">
                            			<h4 style="color: red">Please fix "Unmatched Students" first.</h4>
                            		</div>
                                <div class="fileUpload btn btn-default m-b-5">
                                    <span>Schedule Upload</span>
                                    <input type="file" class="upload" id="scheduleUploadButton" accept=".xlsx,.xls"/>
                                </div>
                            </div>
                            
                            <div class="panel-body">
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<table class="table table-bordered" id="scheduleTable">
											<thead>
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

        
		<div class="modal fade bs-example-modal-sm" id="changeStudentNameDiv" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: none;">
			<div class="modal-dialog modal-sm" style="width:500px">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close md-close" data-dismiss="modal" aria-hidden="true">x</button>
						<h4 class="modal-title" id="mySmallModalLabel">Changing Student Name</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<div class="col-sm-10">
								<input type="text" class="form-control" id="newStudentName" style="ime-mode:inactive;text-transform:uppercase">
							</div>
							<div class="col-sm-2">
								<input type="button" value="Save" class="btn btn-primary" id="saveNewStudentNameButton">
							</div>
						</div>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
        
		<div class="modal fade bs-example-modal-sm" id="studentScheduleDiv" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
			<div class="modal-dialog modal-lg" style="width:750px;">
				<div class="modal-content" style="height: 400px;">
					<div class="modal-header">
						<button type="button" class="close md-close" data-dismiss="modal" aria-hidden="true">x</button>
						<h4 class="modal-title" id="mySmallModalLabel">Schedule of Student's View</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<table style="border: 1px;border-color: black; width: 100%">
								<thead>
									<tr>
										<td class="text-center"><b>Time</b></td>
										<td class="text-center"><b>Room</b></td>
										<td class="text-center"><b>Subject</b></td>
										<td class="text-center"><b>Teacher</b></td>
									</tr>
								</thead>
								<tbody id="studentSchedule">
								</tbody>
							</table>
						</div>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
        
		<div class="modal fade bs-example-modal-sm" id="timetableFormatDiv" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
			<div class="modal-dialog modal-lg" style="width:750px;">
				<div class="modal-content" style="height: 260px;">
					<div class="modal-header">
						<button type="button" class="close md-close" data-dismiss="modal" aria-hidden="true">x</button>
						<h4 class="modal-title" id="mySmallModalLabel">Choose Form of Timetable</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<div class="col-sm-6 text-center">
								<input type="button" id="aLevelFormButton" style="background: url(/custom/img/a-level.png); width: 356px; height: 105px">
							</div>
							<div class="col-sm-6 text-center">
								<input type="button" id="aTimeFormButton" style="background: url(/custom/img/a-time.png); width: 235px; height: 147px">
							</div>
						</div>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
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
        		
        		$("#detailValidateButton").click(function() {
        			if (isNotUploadedAllFiles()) {
						return false;
					}
        			
    				var branchSeq = getUrlParameter("branchSeq");
    				var campusSeq = getUrlParameter("campusSeq");
    				var termDetailSeq = getUrlParameter("termDetailSeq");
    				var studySeq = getUrlParameter("studySeq");
    				if (!studySeq || !campusSeq || !termDetailSeq || !branchSeq) {
    					alert("lack of data.");
    				}
    				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termDetailSeq + "/studies/" + studySeq + "/schedule/validate";
    				window.location = url;
        		});
        		
        		
        		$("#detailDownloadTeachersButton").click(function() {
        			if (isNotUploadedAllFiles()) {
						return false;
					}
        			
    				var branchSeq = getUrlParameter("branchSeq");
    				var campusSeq = getUrlParameter("campusSeq");
    				var termDetailSeq = getUrlParameter("termDetailSeq");
    				var studySeq = getUrlParameter("studySeq");
    				if (!studySeq || !campusSeq || !termDetailSeq || !branchSeq) {
    					alert("lack of data.");
    				}
    				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termDetailSeq + "/studies/" + studySeq + "/schedule/teachers";
    				window.location = url;
        		});
        		
        		$("#detailDownloadStudentsButton").click(function() {
        			if (isNotUploadedAllFiles()) {
						return false;
					}
        			
    				var branchSeq = getUrlParameter("branchSeq");
    				var campusSeq = getUrlParameter("campusSeq");
    				var termDetailSeq = getUrlParameter("termDetailSeq");
    				var studySeq = getUrlParameter("studySeq");
    				if (!studySeq || !campusSeq || !termDetailSeq || !branchSeq) {
    					alert("lack of data.");
    				}
    				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termDetailSeq + "/studies/" + studySeq + "/schedule/students";
    				window.location = url;
        		});
        		
        		$("#detailDeleteButton").click(deleteDetail);
        		$("#studyBackButton").click(function() {
        			var backPage = getUrlParameter("backPage");
        			if (backPage == "list") {
        				window.location.replace("studyList.jsp");		
					} else {
						window.history.back(1);
					}
        		});
        		
        		$("#showIimetableUploadButton").click(showTimetableFormat);
        		$("#aLevelFormButton").click(showALevelTimetableFormat);
        		$("#aTimeFormButton").click(showATimeTimetableFormat);
        		
        		$("#levelUploadButton").change(uploadLevelFile);
        		$("#timetableUploadButton").change(uploadTimetableFile);
        		$("#scheduleUploadButton").change(uploadScheduleFile);
        		$("#saveNewStudentNameButton").click(saveNewStduentName);

                $("#sendMessageButton").click(showSendMessage);
                $("#sendMessageSendButton").click(sendMessage);
                $("#sendMessageDiv").on("shown.bs.modal", function () {
                    $("#sendMessageMessage").focus();
                })
                
           		getDetailData();
            });

            function initPlugins() {
                $("#newStudentName").keyup(function(event){
                    if (!(event.keyCode >=37 && event.keyCode<=40)) {
                        var inputVal = $(this).val();
                        $(this).val(inputVal.replace(/[^a-zA-Z\s]/gi,''));    
                    }
                });
            }
            
        	function isNotUploadedAllFiles() {
        		var successCount = 0;
        		if($("#levelGroupingsSection").find("#originalStudentName").length > 0) {
        			successCount++;
        		}
        		if($("#timetableTable").find("tbody").find(".text-center").length > 0) {
        			successCount++;
        		}
        		if($("#scheduleTable").find("tbody").find(".text-center").length > 0) {
        			successCount++;
        		}
        		
        		if (successCount < 3) {
					alert("You have to finish to upload all files first.");
	        		return true;
				}
				return false;
        	}
        	
            
			function getDetailData() {
				var branchSeq = getUrlParameter("branchSeq");
				var campusSeq = getUrlParameter("campusSeq");
				var termDetailSeq = getUrlParameter("termDetailSeq");
				var studySeq = getUrlParameter("studySeq");
				if (!studySeq || !campusSeq || !termDetailSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}
				
				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termDetailSeq + "/studies/" + studySeq; 
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
	            		$("#branchSeq").val($data.branchSeq);
	        			$("#detailCampusDiv").html($data.campus);
	            		$("#campusSeq").val($data.campusSeq);
		        		$("#detailTermDiv").html($data.term);
	            		$("#termDetailSeq").val($data.termDetailSeq);
	            		
	            		gridLevelGroupings($data);
	            		gridTimetables($data);
	            		gridSchedules($data);
	            		gridFailedLevelGroupings($data.unknownStudents);
	            		if ($data.unknownStudents.length > 0) {
	            			$("#scheduleUploadButton").parent().addClass("disabled");
	            			$("#scheduleUploadButton").attr("disabled", "disabled");
	            			$("#scheduleUploadButton").css("cursor", "no-drop");
	            			$("#informingDiv").css("display", "");
	            		} else {
	            			$("#scheduleUploadButton").parent().removeClass("disabled");
	            			$("#scheduleUploadButton").removeAttr("disabled");
	            			$("#scheduleUploadButton").css("cursor", "pointer");
	            			$("#informingDiv").css("display", "none");
	            		}
					}
        		} else if (response.head.status == 401) {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]", function() {
						window.location.replace("/login.jsp");
					});
				} else {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]");
				}
        	}
            
            function gridLevelGroupings(data) {
           		var html = "";
           		var course = "";
           		$("#levelGroupingsSection").empty();
            		
				html = "<div class=\"clearfix page-header\"></div>";
				html += "<div class=\"col-md-12\" style=\"float: left\">";
				html += "<h4 style=\"color: red\">** You can see the student's schedule like what he sees when you click his name.</h4>";
				html += "</div>";
				$("#levelGroupingsSection").append(html);
            		
           		$.each(data.studentLevels, function (index, item) {
            		html = "";
           			if (index > 1) {
   	            		html = "<div class=\"clearfix\"></div>";
					}
            		html += "<h4 class=\"page-header\">" + item.levelName + "</h4>";
            		html += "<div class=\"clearfix\">";
	            		
            		if (item.studentNames.length > 0) {
	            		$.each(item.studentNames, function (subIndex, subItem) {
		            		//html = "";
		            		course = subItem.course;
		            		if (course == "") {
			            		course = subItem.requestCourse;
		            		}
		            		html += "    <div class=\"col-md-3 col-sm-4\" id=\"originalStudentName\">";
		            		html += "        <i class=\"fa fa-angle-right\"></i> <span studentId=\"" + subItem.studentId + "\">" + subItem.studentName; // + " (" + course + ")</span>";
		            		html += "    </div>";
	            		});
					} else {
						html = "";
					}
	            		
            		$("#levelGroupingsSection").append(html);

           		});
            		
           		$("[id=originalStudentName]").click(function() {
           			getClassTimeTable($(this).find("span").attr("studentId"));
           		});
            }
            
            function gridFailedLevelGroupings(data) {
           		var html = "";
           		var course = "";
           		$("#failedLevelGroupingsSection").empty();
           		
           		//console.log(data);
           		html = "<h4 class=\"page-header\">Unmatched Students (* You can copy name of unknown student when you click it.)</h4>";
           		html += "<div class=\"clearfix\">";
           		$.each(data, function (key, val) {
            		//html = "";
            		//console.log(key, val.level);
            		$.each(val.students, function (idx, subVal) {
	            		//html = "";
	            		html += "    <div class=\"col-md-3 col-sm-4\">";
	            		html += "        <i class=\"fa fa-angle-right\"></i> <span>" + subVal.studentName + "</span> (" + val.level + ")";
	            		html += "    </div>";
            		});
            		
           		});
            		
           		if (data.length < 1) {
           			html += "None.";	
				}
            		
           		html += "</div>";
           		$("#failedLevelGroupingsSection").append(html);

           		$("#failedLevelGroupingsSection .clearfix div").click(function() {
           			copyToClipboard($(this).find("span"));
           		});
            }

            function gridTimetables(data) {
            		//console.log(data);
            		//console.log(data.studentTimetables);
            		var html = "";
            		var theadHtml = "";
            		$("#timetableTable tbody").empty();
            		$("#timetableTable thead").empty();

            		$.each(data.studentTimetables, function(index, item) {
            			if (index == 0) {
            				theadHtml += "<tr>";
		            		//console.log(item.details);
		            		$.each(item.details, function(subIndex, subItem) {
		            			if (subIndex == 0) {
		            				theadHtml += "<th class=\"col-sm-1 text-center\">Level \\ Time</th>";
		            			}
		            			theadHtml += "<th class=\"col-sm-1 text-center\">" + subItem.studyTime + "</th>";
		            		});
		            		theadHtml += "</tr>";
		            		$("#timetableTable thead").append(theadHtml);
						}
            			
            			html = "<tr>";
	            		$.each(item.details, function(subIndex, subItem) {
	            			if (subIndex == 0) {
	            				html += "<td class=\"text-center\">" + item.levelName + "</td>";
	            			}
	            			html += "<td class=\"text-center\">" + subItem.subject + "</td>";
	            		});
	            		html += "</tr>";
	            		$("#timetableTable tbody").append(html);
            		});
            }

            function gridSchedules(data) {
        		//console.log(data);
        		//console.log(data.studentStudySchedules);
        		var html = "";
        		var theadHtml = "";
           		$("#scheduleTable tbody").empty();
           		$("#scheduleTable thead").empty();
           		
           		if (data.studentStudySchedules.length < 1) {
					return false;
				}
	        		
        		// grid times
           		$.each(data.studentTimetables, function(index, item) {
           			if (index == 0) {
           				theadHtml += "<tr>";
	            		$.each(item.details, function(subIndex, subItem) {
	            			if (subIndex == 0) {
	            				theadHtml += "<th class=\"col-sm-1 text-center\">Room \\ Time</th>";
	            			}
	            			theadHtml += "<th class=\"col-sm-1 text-center\">" + subItem.studyTime + "</th>";
	            		});
	            		theadHtml += "</tr>";
	            		$("#scheduleTable thead").append(theadHtml);
					} else {
						return;
					}
           		});
            		
       			var $TIME_HEAD = $("#scheduleTable thead").find("th");
       			var widthCellTotalCount = $TIME_HEAD.length;
       			var studyRoomsTotalCount = data.studentStudySchedules.length;
       			var rowTotalCount = 0;
           		//console.log("widthCellTotalCount : ", widthCellTotalCount, "studyRoomsTotalCount : ", studyRoomsTotalCount);
            		
         		// grid cells with studyroom
        		$.each(data.studentStudySchedules, function(index, item) {
        			html = "<tr>";
       				html += "<th class=\"text-center\">" + item.studyRoom + "</td>";
	        			
           			for (var GRID_CELL_I = 1; GRID_CELL_I < widthCellTotalCount; GRID_CELL_I++) {
           				html += "<td class=\"text-center\"></td>";
					}
            		html += "</tr>";
            		$("#scheduleTable tbody").append(html);
        		});

       			var $STUDYROOM_ROW = $("#scheduleTable tbody").find("tr");
        		var ROOMS = new Array();
        		$.each($STUDYROOM_ROW, function(idx, val) {
        			ROOMS.push($(this).find("th").text());
        		});
	        		
        		var ROOM_INDEX = 0;
        		var ROOM_TOTAL_CNT = ROOMS.length;
        		
        		var nextTECHERNAME = "";
        		var nextSTUDYTIME = "";
        		var groupStudentNames = "";
        		var DETAILS;
        		$.each(data.studentStudySchedules, function(index, item) {
        			for (var i = 0; i < ROOM_TOTAL_CNT; i++) {
        				if (ROOMS[i] == item.studyRoom) {
        					$.each(item.details, function(subIndex, subItem) {
     	            			for (var GRID_CELL_I = 1; GRID_CELL_I < widthCellTotalCount; GRID_CELL_I++) {
    	            				if ($TIME_HEAD.eq(GRID_CELL_I).text() == subItem.studyTime) {
    	            					if (subItem.studyMember > 1) {
	    	            					if (subIndex != $(item.details).length - 1) {
		    	            					nextTECHERNAME = $(item.details).eq(subIndex+1).prop("teacherName");
		    	            					nextSTUDYTIME = $(item.details).eq(subIndex+1).prop("studyTime");
											} else if (subIndex == $(item.details).length -1) {
		    	            					nextTECHERNAME = $(item.details).eq(subIndex-1).prop("teacherName");
		    	            					nextSTUDYTIME = $(item.details).eq(subIndex-1).prop("studyTime");
											}
	    	            					
											//console.log(subIndex, subItem);
	    	            					if (nextTECHERNAME == subItem.teacherName) {
	    	            						if (nextSTUDYTIME == subItem.studyTime) {
		    	            						groupStudentNames = groupStudentNames + subItem.studentName + "<BR>";
		    	            						if (subIndex == $(item.details).length -1) {
				    	            					$STUDYROOM_ROW.eq(ROOM_INDEX).children().eq(GRID_CELL_I).html(subItem.teacherName + "<br/><br/>" + groupStudentNames);
				    	            					groupStudentNames = "";
													}
	    	            							continue;
												}
	    	            						else {
		    	            						groupStudentNames = groupStudentNames + subItem.studentName;
			    	            					$STUDYROOM_ROW.eq(ROOM_INDEX).children().eq(GRID_CELL_I).html(subItem.teacherName + "<br/><br/>" + groupStudentNames);
			    	            					groupStudentNames = "";
												}
											} else {
												if (groupStudentNames) {
		    	            						groupStudentNames = groupStudentNames + subItem.studentName;
			    	            					$STUDYROOM_ROW.eq(ROOM_INDEX).children().eq(GRID_CELL_I).html(subItem.teacherName + "<br/><br/>" + groupStudentNames);
			    	            					groupStudentNames = "";
												} else {
			    	            					$STUDYROOM_ROW.eq(ROOM_INDEX).children().eq(GRID_CELL_I).html(subItem.teacherName + "<br/><br/>" + subItem.studentName);
			    	            					groupStudentNames = "";
												}
											}
										} else {
	    	            					$STUDYROOM_ROW.eq(ROOM_INDEX).children().eq(GRID_CELL_I).html(subItem.teacherName + "<br/><br/>" + subItem.studentName);
	    	            					groupStudentNames = "";
										}
	    	            					
	    							} else {
    		            				continue;
	    							}
	    						}
        					});
        					ROOM_INDEX++;
						}
        			}
        		});
            }
            
            function uploadLevelFile() {
        		if (!$("#levelUploadButton")[0].files[0]) {
					return false;
				}
        		
        		$("#failedLevelGroupingsSection").empty();
	        		
				var branchSeq = getUrlParameter("branchSeq");
				var campusSeq = getUrlParameter("campusSeq");
				var termDetailSeq = getUrlParameter("termDetailSeq");
				var studySeq = getUrlParameter("studySeq");
				if (!studySeq || !campusSeq || !termDetailSeq || !branchSeq) {
					alert("lack of data.");
					return false;
				}

				var formData = new FormData();
				formData.append("file", $("#levelUploadButton")[0].files[0]);

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termDetailSeq + "/studies/" + studySeq + "/levels";
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
								getDetailData();
								closeWindowByMask();
							});
		        		} else if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
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
					},
					complete : function(jqXHR, textStatus) {
						$("#levelUploadButton").val("");
					}
            	});
            }

            function showTimetableFormat() {
           		$("#timetableFormatDiv").modal("show");
           		//uploadTimetableFile();
            }
            
            function showALevelTimetableFormat() {
           		$("#timetableFormatDiv").modal("hide");
           		$("#timetableUploadButton").attr("api", "/timetable/timebase");
           		$("#timetableUploadButton").trigger("click");
            }
            
            function showATimeTimetableFormat() {
           		$("#timetableFormatDiv").modal("hide");
           		$("#timetableUploadButton").attr("api", "/timetable");
           		$("#timetableUploadButton").trigger("click");
            }
            
            function uploadTimetableFile() {
        		if ($("#levelGroupingsSection").children().find("i").length < 1) {
        			alert("Students' level should be uploaded first.");
        			$("#timetableUploadButton").val("");
					return false;
				}
        		
        		if (!$("#timetableUploadButton")[0].files[0]) {
					return false;
				}
        		
				var branchSeq = getUrlParameter("branchSeq");
				var campusSeq = getUrlParameter("campusSeq");
				var termDetailSeq = getUrlParameter("termDetailSeq");
				var studySeq = getUrlParameter("studySeq");
				if (!studySeq || !campusSeq || !termDetailSeq || !branchSeq) {
					alert("lack of data.");
					return false;
				}

				var formData = new FormData();
				formData.append("file", $("#timetableUploadButton")[0].files[0]);

				var api = $("#timetableUploadButton").attr("api");
				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termDetailSeq + "/studies/" + studySeq + api;
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
								getDetailData();
								closeWindowByMask();
							});
		        		} else if (data.head.status == 10001) {
							console.log(data);
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]\n" + data.body.data, function (){
								closeWindowByMask();
							});
		        		} else if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
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
					},
					complete : function(jqXHR, textStatus) {
						$("#timetableUploadButton").val("");
					}
            	});
            }
            
            function uploadScheduleFile() {
        		if ($("#levelGroupingsSection").children().find("i").length < 1) {
        			alert("Students' level should be uploaded first.");
        			$("#timetableUploadButton").val("");
					return false;
				}
	        		
        		if ($("#timetableTable tbody").children().find("td").length < 1) {
        			alert("Timetable should be uploaded first.");
        			$("#scheduleUploadButton").val("");
					return false;
				}
        		
        		if (!$("#scheduleUploadButton")[0].files[0]) {
					return false;
				}
        		
				var branchSeq = getUrlParameter("branchSeq");
				var campusSeq = getUrlParameter("campusSeq");
				var termDetailSeq = getUrlParameter("termDetailSeq");
				var studySeq = getUrlParameter("studySeq");
				if (!studySeq || !campusSeq || !termDetailSeq || !branchSeq) {
					alert("lack of data.");
					return false;
				}

				var formData = new FormData();
				formData.append("file", $("#scheduleUploadButton")[0].files[0]);

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termDetailSeq + "/studies/" + studySeq + "/schedule";
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
		        			if (data.body.totalCount > 0) {
								openSwal("Automatically download the file of detail of errors", "Please check the file \n which automatically download file. \n(The file's name is Schedule_failed_list.txt)", function() {
									window.location = "<%=SERVER_URL%>/filedownload?filePath="+data.body.data+"&fileName="+encodeURI(encodeURIComponent("Schedule_failed_list"));
									closeWindowByMask();
								});
							} else {
								openSwal(data.head.message, "", function() {
									getDetailData();
									closeWindowByMask();
								});
							}
		        		} else if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
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
					},
					complete : function(jqXHR, textStatus) {
						$("#scheduleUploadButton").val("");
					}
            	});
            }
            
            function deleteDetail() {
				var branchSeq = getUrlParameter("branchSeq");
				var campusSeq = getUrlParameter("campusSeq");
				var termDetailSeq = getUrlParameter("termDetailSeq");
				var studySeq = getUrlParameter("studySeq");
				if (!studySeq || !campusSeq || !termDetailSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termDetailSeq + "/studies/" + studySeq;
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
								window.history.back(1);
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
            
            function saveNewStduentName() {
				var branchSeq = getUrlParameter("branchSeq");
				var studentId = $("#changeStudentNameDiv").attr("studentId");
				var studentName = $("#newStudentName").val();
				if (!branchSeq || !studentId || !studentName) {
					alert("lack of data.");
					return false;
				}
				
				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/students/" + studentId + "/change/name";
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "PUT",
            		data : JSON.stringify({"studentName" : studentName}),
            		dataType : "json",
            		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
            		success : function(data, textStatus, jqXHR) {
		        		if (data.head.status == 200) {
							openSwal(data.head.message, "", function() {
								$("#changeStudentNameDiv").modal("hide");
								getDetailData();
								closeWindowByMask();
							});
		        		} else if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
							});
						} else {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
							$("#changeStudentNameDiv").modal("hide");
							closeWindowByMask();
						}
            		},
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
						$("#changeStudentNameDiv").modal("hide");
						closeWindowByMask();
					}
            	});
            }
            
			function getClassTimeTable(studentId) {
				var termDetailSeq = getUrlParameter("termDetailSeq");
				$.ajax({
					headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
					url : "<%=SERVER_URL%>/students/" + studentId + "/studies/schedule/"+termDetailSeq,
					type : "GET",
					dataType : "json",
					contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
					success : function(data, textStatus, jqXHR) {
						if (data.head.status == 200) {
							var $results = data.body.data;
							console.log("getClassTimeTable : ", $results);
							
 							var html = "";
							var printSubject = "";
							$("#studentSchedule").children().remove();
							
							if ($results.length > 0) {
								$.each($results, function(index, item) {
									if (item.studyMember > 0) {
										printSubject = "[" + item.studyMember + ":1] " + item.subject; 
									} else {
										printSubject = item.subject; 
									}
									html = "<tr>";
									html += "<td class=\"text-center\">" + item.time + "</td>";
									html += "<td class=\"text-left\">" + item.studyRoom + "</td>";
									if (item.studyMember > 0) {
										html += "<td class=\"text-left\">" + printSubject + "</td>";
									} else {
										html += "<td class=\"text-left\"></td>";
									}									
									html += "<td class=\"text-left\">" + item.teacher + "</td>";
									html += "</tr>";
									
									$("#studentSchedule").append(html);
								});
							} else {
								html = "<tr>";
								html += "<td colspan=\"4\">";
								html += "<div class=\"contentNone\" >";
								html += "<p style=\"text-align:center\" class=\"text-center\">None.</p>";
								html += "</div>";
								html += "</td>";
								html += "</tr>";
								
								$("#studentSchedule").append(html);
							} 

							$("#studentScheduleDiv").modal("show");
						} else if (data.head.status == 204) {
							console.log("getClassTimeTable : none.");
						} else {
							console.log("ERROR -----------\n ", data);
						}
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log("error", jqXHR, textStatus, errorThrown);
					},
					complete : function(jqXHR, textStatus) {
						closeWindowByMask();
					}
				});
			}

            function showSendMessage() {
    			if (isNotUploadedAllFiles()) {
					return false;
				}
    			
            	var branch = "<b>Branch</b> : " + $("#detailBranchDiv").html();
    			var campus = "<b>Campus</b> : " + $("#detailCampusDiv").html();
    			var term = "<b>Term of Schedule</b> : " + $("#detailTermDiv").html();
            	$("#rangesDiv").html(branch + "<br>" + campus + "<br>" + term);
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
					studySeq : getUrlParameter("studySeq"),
					message : $("#sendMessageMessage").val(),
					site : $("#sendMessageSiteUrl").val(),
					menu : "Academy > Class Schedule"
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
