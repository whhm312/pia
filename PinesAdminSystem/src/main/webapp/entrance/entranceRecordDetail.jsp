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
                    <li class="has-submenu"><a href="/study/studyList.jsp"><i class="zmdi zmdi-collection-text"></i> <span class="nav-label">Academy</span></a>
                        <ul class="list-unstyled">
                            <li><a href="/study/studyList.jsp">Class Schedule</a></li>
                            <li class=""><a href="/exam/examList.jsp">Examination & Results</a></li>
                            <li><a href="/attendance/attendanceList.jsp">Attendance</a></li>
                            <!--<li><a href="/evaluation/evaluationList.jsp">Evaluation</a></li>-->
                            <!-- <li><a href="#">Weekend Study</a></li>
                            <li><a href="#">Option Class</a></li> -->
                        </ul>
                    </li>
                    <li class="has-submenu"><a href="/student/studentList.jsp"><i class="zmdi zmdi-accounts"></i> <span class="nav-label">Student</span></a>
                    </li>
                    <li class="has-submenu active"><a href="/staff/staffList.jsp"><i class="zmdi zmdi-run"></i> <span class="nav-label">Staff</span></a>
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
                    <h3 class="title">Staff</h3>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right ">
	                           <button type="button" class="btn btn-default m-b-5" id="historyBackButton">Back</button>
	                           <button type="button" class="btn btn-default m-b-5" id="detailSaveButton">Save</button>
	                           <button type="button" class="btn btn-default m-b-5" data-toggle="modal" data-target="#passwordModal">Change Password</button>
	                           <button type="button" class="btn btn-default m-b-5" id="detailDeleteButton">Delete</button>
                            </div>
							<div class="panel-body">
								<form class="form-horizontal" role="form" id="detailForm" onsubmit="return false;">
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">ID</label>
										<div class="col-md-9" id="idDiv" style="margin-top:6px;margin-left:20px">
										</div>
									</div> <!-- form-group -->
								</div>
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Working Area *</label>
										<div class="col-md-10" id="branchDiv">
										</div>
									</div> <!-- form-group -->
								</div>
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Nationality *</label>
										<div class="col-md-10" id="nationalityDiv">
										</div>
									</div> <!-- form-group -->
								</div>
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Real Name *</label>
										<div class="col-md-10">
											<div class="col-md-5">
												<input type="text" class="form-control input-sm" value="" placeholder="" name="realName" id="realName" required>
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Title</label>
										<div class="col-md-10">
											<div class="col-md-5">
												<input type="text" class="form-control input-sm" value="" placeholder="" name="title" id="title">
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Nickname *</label>
										<div class="col-md-10">
											<div class="col-md-5">
												<input type="text" class="form-control input-sm" value="" placeholder="" name="nickName" id="nickName" required>
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Contact *</label>
										<div class="col-md-10">
											<div class="col-md-5">
												<input type="text" class="form-control input-sm" value="" placeholder="" name="cantact" id="cantact" required>
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Authority in the site *</label>
										<div class="col-md-10" id="authorityBranchDiv">
										</div>
									</div> <!-- form-group -->
								</div>
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Status *</label>
										<div class="col-md-10">
											<div class="radio-inline">
												<label class="cr-styled">
													<input type="radio" name="status" id="statusWork" value="Working" required aria-required="true"> 
													<i class="fa"></i>Working 
												</label>
											</div>
											<div class="radio-inline">
												<label class="cr-styled">
													<input type="radio" name="status" id="statusVacation" value="On Leave" required aria-required="true"> 
													<i class="fa"></i>On Leave 
												</label>
											</div>
											<div class="radio-inline">
												<label class="cr-styled">
													<input type="radio" name="status" id="statusQuit" value="Quit" required aria-required="true"> 
													<i class="fa"></i>Quit 
												</label>
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
								</form>
							</div>
                        </div>
                    </div>
                </div>
                <!-- end row -->
            </div>
            
            <!-- /.modal -->
			<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;" id="passwordModal">
				<div class="modal-dialog"> 
					<div class="modal-content"> 
						<div class="modal-header"> 
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> 
							<h4 class="modal-title">Changing Password</h4> 
						</div> 
						<div class="modal-body"> 
							<div class="row"> 
								<div class="col-md-12"> 
									<div class="form-group"> 
										<label for="field-1" class="control-label">New Password</label> 
										<input type="password" class="form-control" id="password"> 
									</div> 
								</div>
						    </div> 
							<div class="modal-footer"> 
								<button type="button" class="btn btn-white" data-dismiss="modal">Close</button> 
								<button type="button" class="btn btn-info" id="changePasswordButton">Save changes</button> 
							</div> 
						</div> 
					</div>
				</div>
			</div><!-- /.modal -->
            
            <!-- Page Content Ends -->
            <!-- ================== -->

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
        <script src="/js/md5.min.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function() {
	        		$("#detailSaveButton").on("click", saveDetail);
	        		$("#detailDeleteButton").on("click", deleteDetail);
	        		$("#changePasswordButton").on("click", changePassword);
	        		$("#passwordModal").on("shown.bs.modal", function (e) {
	        			$("#password").focus();
	        		});
	        		
				$("#cantact").keyup(function(e) {
					var reg = /[^0-9]\-/gi;
					var v = $(this).val();
					if (reg.test(v)) {
						$(this).val(v.replace(reg, ''));
						$(this).focus();
					}
				});
					
	        		gridBranches("checkbox", "authorityBranch", $("#authorityBranchDiv"));
	        		gridBranches("radio", "branch", $("#branchDiv"));
	        		gridNationality();
            });

            function initPlugins() {
	    	        $("#detailForm").validate({
	    	            errorPlacement: function(error, element) {
	    	            		if (element.attr("name") == 'branch') {
	    	            			error.insertBefore($("[name=branch]").first().parent().parent());
	    	            		} else if (element.attr("name") == 'nationality') {
	    	            			error.insertBefore($("[name=nationality]").first().parent().parent());
	    	            		} else if (element.attr("name") == 'status') {
	    	            			error.insertBefore($("[name=status]").first().parent().parent());
	    					} else {
	    		                error.insertBefore(element);
	    					}
	    	            }
	    	        });
	    	        
	        		initValidateRadioButtons(["branch", "nationality" ,"status"]);
            }

            function gridNationality() {
                	var url = "<%=SERVER_URL%>/conditions/nationalities";
                	$.ajax({
                		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
                		url : url,
                		type : "GET",
                		dataType : "json",
                		contentType : "application/json; charset=UTF-8",
    					beforeSend : function (jqXHR, settings) {
    						wrapWindowByMask();
    					},
    					success : function(data, textStatus, jqXHR) {
                    		if (data.head.status == 200) {
                        		gridCookieData(JSON.stringify(data.body.data), "radio", "nationality", $("#nationalityDiv"));
                    		}
                    		
                    		initPlugins();
                    		getDetailData();
                    	},
                		error : function(jqXHR, textStatus, errorThrown) {
                			console.log(jqXHR, textStatus, errorThrown);
    						closeWindowByMask();
    					}
                	});
            }
            
			function getDetailData() {
				var branchSeq = getUrlParameter("branchSeq");
				var staffId = getUrlParameter("staffId");
				if (!staffId || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}
				
				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/staffs/" + staffId; 
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		type : "GET",
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
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
		        			setRadioValue("branch", $data.branchSeq);
		        			setRadioValue("nationality", $data.nationalitySeq);
		        			setRadioValue("status", $data.status);
		        			$("#idDiv").html($data.staffId);
		        			$("#realName").val($data.realName);
		        			$("#title").val($data.title);
		        			$("#nickName").val($data.nickName);
		        			$("#cantact").val($data.contact);
		        			if ($data.authorityBranchSeqs.length > 0) {
		        				$.each($data.authorityBranchSeqs, function(authIdx, authVal) {
		        					setCheckboxValue("authorityBranch", authVal);
		        				});
								
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
            
            function saveDetail() {
				var branchSeq = getUrlParameter("branchSeq");
				var staffId = getUrlParameter("staffId");
				if (!staffId || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/staffs/" + staffId;
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		data : getJsonData(),
	            		type : "PUT",
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
	            		success : function(data, textStatus, jqXHR) {
			        		if (data.head.status == 200) {
							openSwal(data.head.message, "", function() {
								getDetailData();
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

			function getJsonData() {
				return JSON.stringify({
					branchSeq : $("[name=branch]:checked").val(),
					nationalitySeq : $("[name=nationality]:checked").val(),
					realName : $("#realName").val(),
					nickName : $("#nickName").val(),
					title : $("#title").val(),
					contact : $("#cantact").val(),
					staffId : getUrlParameter("staffId"),
					authorityBranchSeqs : getCheckedValues("authorityBranch"), // [1, 2, 3]
					status : $("[name=status]:checked").val()
				});
			}
            
            function deleteDetail() {
				var branchSeq = getUrlParameter("branchSeq");
				var staffId = getUrlParameter("staffId");
				if (!staffId || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/staffs/" + staffId;
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
								window.location.replace("/staff/staffList.jsp");
							});
						} else {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
							closeWindowByMask();
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
            
            function changePassword() {
				var branchSeq = getUrlParameter("branchSeq");
				var staffId = getUrlParameter("staffId");
				var password = $("#password").val();
				if (!staffId || !branchSeq || !password) {
					alert("lack of data.");
					$("#password").focus();
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/staffs/" + staffId + "/password/change";
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		type : "POST",
	            		data : JSON.stringify({password : md5(password)}),
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
	            		success : function(data, textStatus, jqXHR) {
			        		if (data.head.status == 200) {
							openSwal(data.head.message, "", function() {
								$("#passwordModal").modal("hide");
								closeWindowByMask();
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
            
            setStaffNameOnHeader();
        </script>
    </body>
</html>
