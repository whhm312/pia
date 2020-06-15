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
                            <li class="active"><a href="/request/requestList.jsp">Request</a></li>
                            <li><a href="/notice/noticeList.jsp">Notice</a></li>
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
                    <h3 class="title">Request</h3> 
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right ">
								<button type="button" class="btn btn-default m-b-5" id="historyBackButton">Back</button>
								<button type="button" class="btn btn-default m-b-5" id="sendMessageButton">Send Message</button>		                           
								<button type="button" class="btn btn-default m-b-5" id="showProgressFormButton">Start Progress</button>
								<button type="button" class="btn btn-default m-b-5" id="showFinishFormButton">Finish Request</button>
                            </div>
                            
                            <div class="panel-body">
                            <form class="cmxform form-horizontal tasi-form" role="form" id="detailRequestForm" novalidate="novalidate">
	                            <div class="panel-heading">
	                                <h3 class="panel-title" id="writerInfo"></h3>
	                            </div>
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Student's ID</label>
                                        <div class="col-md-7 control-label" id="studentId" style="text-align:left;margin-left:10px">
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Branch</label>
                                        <div class="col-md-7 control-label" id="branch" style="text-align:left;margin-left:10px">
                                        </div>
                                    </div> <!-- form-group -->
                                </div>

                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Status</label>
                                        <div class="col-md-7 control-label" id="status" style="text-align:left;margin-left:10px">
                                        </div>
                                    </div> <!-- form-group -->
                                </div>

                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Request Type</label>
                                        <div class="col-md-7 control-label" id="requestType" style="text-align:left;margin-left:10px">
                                        </div>
                                    </div> <!-- form-group -->
                                </div>

                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Request Date</label>
                                        <div class="col-md-7 control-label" id="requestDate" style="text-align:left;margin-left:10px">
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Request Content</label>
                                        <div class="col-md-7 control-label" id="content" style="text-align:left;margin-left:10px">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Translate Site</label>
                                        <div class="col-md-7 control-label" style="text-align:left;margin-left:10px">
                                        <button type="button" class="btn btn-default m-b-5" id="openTranslateSiteButton">Open Translate Site</button>
                                        </div>
                                    </div>
                                </div>
							</form>
                            </div> <!-- panel-body -->
                        </div>
                    </div>
                </div>
                <!-- end row -->
                
                <form class="cmxform form-horizontal tasi-form" role="form" id="detailProgressForm" novalidate="novalidate" style="display: none">
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading text-right ">
								<button type="button" class="btn btn-default m-b-5" id="progressSaveButton">Save</button>
							</div>
							
							<div class="panel-body">
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Starting Date</label>
										<div class="col-md-7 control-label" id="progressDate" style="text-align:left;margin-left:10px"></div>
									</div>
								</div>
								
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Response processor</label>
										<div class="col-md-7 control-label" id="progressStaff" style="text-align:left;margin-left:10px"></div>
									</div>
								</div>
								
								<div class="row">                                                     
									<div class="form-group">
										<label class="col-md-2 control-label">Progress Message</label>
										<div class="col-md-9">
											<textarea class="form-control" rows="5" id="progressDetail" required maxlength="5000"></textarea>
										</div>
									</div>
								</div>	
							</div>
						</div>
					</div>
				</div>
				</form>
                <!-- end row -->
                
                <form class="cmxform form-horizontal tasi-form" role="form" id="detailFinishForm" novalidate="novalidate" style="display: none">
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading text-right ">
								<button type="button" class="btn btn-default m-b-5" id="finishSaveButton">Save</button>
							</div>
							
							<div class="panel-body">
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Answer Date</label>
										<div class="col-md-7 control-label" id="replyDate" style="text-align:left;margin-left:10px"></div>
									</div>
								</div>
								
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Answer Staff</label>
										<div class="col-md-7 control-label" id="staff" style="text-align:left;margin-left:10px"></div>
									</div>
								</div>
								
								<div class="row">                                                     
									<div class="form-group">
										<label class="col-md-2 control-label">Answer Message</label>
										<div class="col-md-9">
											<textarea class="form-control" rows="5" id="reply" required maxlength="5000"></textarea>
										</div>
									</div>
								</div>							
							</div>
						</div>
					</div>
				</div>
				</form>
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
				<h4 class="modal-title">Send a Message to the student</h4> 
			</div> 
			<div class="modal-body">
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-3" class="col-md-2 control-label">Student's Name</label> 
							<div class="col-md-8 radio-inline">
								<p id="sendMessageStudentName"></p>
							</div>
						</div> 
					</div> 
				</div>
				<div class="row">
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-4" class="col-md-2 control-label">Message</label> 
							<div class="col-md-10 radio-inline">
								<input type="text" placeholder="" class="form-control" id="sendMessageMessage" required maxlength="50" value="Please check our reply from your request.">
								<input type="hidden" id="isCanPushMessage">
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
        <script src="/js/jquery.twbsPagination.js"></script>

        <script src="/assets/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>

        <!--form validation -->
        <script src="/assets/jquery.validate/jquery.validate.js"></script>
        
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
                $("#progressSaveButton").on("click", progressRequest);
                $("#finishSaveButton").on("click", finishRequest);
                $("#showProgressFormButton").on("click", showProgressForm);
                $("#showFinishFormButton").on("click", showFinishForm);
                $("#openTranslateSiteButton").on("click", openTranslateSite);
                $("#detailDeleteButton").on("click", deleteDetail);
                $("#sendMessageButton").on("click", showSendMessage);
                $("#sendMessageSendButton").on("click", sendMessage);
                
           		getDetailData();
            });

            function progressRequest() {
           		var firstCheck = $("#detailProgressForm").valid();
           		if (!firstCheck) {
					return false;	
				}
           		
				var branchSeq = getUrlParameter("branchSeq");
				var requestSeq = getUrlParameter("requestSeq");
				if (!requestSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/students/requests/" + requestSeq + "/progress";
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "POST",
            		data : getProgressJsonData(),
            		dataType : "json",
            		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
            		success : function(data, textStatus, jqXHR) {
		        		if (data.head.status == 200) {
							openSwal(data.head.message, "");
							getDetailData();
		        		} else if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
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

			function getProgressJsonData() {
				return JSON.stringify({
					detail : $("#progressDetail").val()
				});
			}

            function finishRequest() {
           		var firstCheck = $("#detailFinishForm").valid();
           		if (!firstCheck) {
					return false;	
				}
           		
				var branchSeq = getUrlParameter("branchSeq");
				var requestSeq = getUrlParameter("requestSeq");
				if (!requestSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/students/requests/" + requestSeq + "/reply";
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "POST",
            		data : getReplyJsonData(),
            		dataType : "json",
            		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
            		success : function(data, textStatus, jqXHR) {
		        		if (data.head.status == 200) {
							openSwal(data.head.message, "");
							getDetailData();
		        		} else if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
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

			function getReplyJsonData() {
				return JSON.stringify({
					reply : $("#reply").val()
				});
			}
			
			function showProgressForm() {
				$("#detailProgressForm").show();
			}
			
			function showFinishForm() {
				$("#detailFinishForm").show();
			}
            
			function getDetailData() {
				var branchSeq = getUrlParameter("branchSeq");
				var requestSeq = getUrlParameter("requestSeq");
				if (!requestSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}
				
				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/students/requests/" + requestSeq;
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
			
            function deleteDetail() {
				var branchSeq = getUrlParameter("branchSeq");
				var requestSeq = getUrlParameter("requestSeq");
				if (!requestSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/students/requests/" + requestSeq + "";
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

            function openTranslateSite() {
           		var pageUrl = "https://translate.google.com/";
           		window.open(pageUrl, "Translate Site", "height=400,width=900");
            }
            
            function getDetailSuccessFnc(response) {
   				console.log(response);
        		if (response.head.status == 200) {
        			var $data = response.body.data;
        			if (response.body.totalCount > 0) {
    					//console.log($data);
    					$("#writerInfo").text($data.nationality + " / " + $data.student + " (" + $data.birthday + ") / " + $data.sex);
    					$("#studentId").text($data.studentId);
    					$("#branch").text($data.branch);
    					$("#status").text($data.status);
    					$("#requestDate").text($data.registerDate);
    					$("#requestType").text($data.type);
    					$("#content").html($data.detail);
     					$("#isCanPushMessage").val(getBoolean($data.isCanPushMessage));
    					$("#sendMessageStudentName").text($data.student);
    					
    					if ($data.progressDate) {
	     					$("#progressDate").text($data.progressDate);
	     					$("#progressDetail").text($data.progressDetail);
	     					$("#progressStaff").text($data.progressStaffId);
	     					
	     					showProgressForm();
	     					showSendMessageButton();
						}
	    					
	   					if ($data.replyDate) {
	    					$("#replyDate").text($data.replyDate);
	    					$("#staff").text($data.staff);
	    					$("#reply").text($data.reply);
	    					
	    					showFinishForm();
	     					showSendMessageButton();
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
            
            function showSendMessageButton() {
            	$("#sendMessageButton").show();
            }

            function showSendMessage() {
            	if (!getBoolean($("#isCanPushMessage").val())) {
            		alert("The student did not install pines portal application on his phone, so you cannot send a messsage.");
					return false;
				}
            	
           		$("#sendMessageStudentName").text($("#name").val());
           		$("#sendMessageDiv").modal();
            }
            
            function sendMessage() {
   	    		var studentId = $("#studentId").text();
   	    		if (!studentId) {
   	    			openSwal("Failed.", "[Lack of Data.]");
					return false;
				}

        		var firstCheck = $("#sendMessageForm").valid();
	       		if (!firstCheck) {
					return false;	
				}

				var params = {
					requestSeq : getUrlParameter("requestSeq"), 
					message : $("#sendMessageMessage").val(),
					menu : "Campus > Request",
					site : "<%=PORTAL_URL%>/02_04_00_campus.html"
				};
				var jsonParams = JSON.stringify(params);
        		var url = "<%=SERVER_URL%>/students/" + studentId + "/push";
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
        				
        				openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function () {
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
