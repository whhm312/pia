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
                            <li><a href="/exam/examList.jsp">Examination & Results</a></li>
                            <li><a href="/attendance/attendanceList.jsp">Attendance</a></li>
                            <!--<li><a href="/evaluation/evaluationList.jsp">Evaluation</a></li>-->
                            <!-- <li><a href="#">Weekend Study</a></li>
                            <li><a href="#">Option Class</a></li> -->
                        </ul>
                    </li>
                    <li class="has-submenu active"><a href="/student/studentList.jsp"><i class="zmdi zmdi-accounts"></i> <span class="nav-label">Student</span></a>
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
                    <h3 class="title">Student</h3> 
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right ">
                                <button type="button" class="btn btn-default m-b-5" id="searchButton">Search</button>
								<div class="btn-group">
									<button type="button" class="btn btn-default m-b-5 dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> Upload <span class="caret"></span> </button>
									<ul class="m-b-5 dropdown-menu">
										<li>
			                                <div class="fileUpload btn m-b-5">
			                                    <span>New Students</span>
			                                    <input type="file" class="upload" id="newStudentsFile" accept=".xlsx,.xls"/>
			                                </div>
										</li>
										<li>
			                                <div class="fileUpload btn m-b-5">
			                                    <span>ID Cards</span>
			                                    <input type="file" class="upload" id="idCardsFile" accept=".xlsx,.xls"/>
			                                </div>
										</li>
										<li>
			                                <div class="fileUpload btn m-b-5">
			                                    <span>Change Student's Names</span>
			                                    <input type="file" class="upload" id="newStudentNamesFile" accept=".xlsx,.xls"/>
			                                </div>
										</li>
										<li>
			                                <div class="fileUpload btn m-b-5">
			                                    <span>Rooms</span>
			                                    <input type="file" class="upload" id="roomsFile" accept=".xlsx,.xls"/>
			                                </div>
										</li>
									</ul>
								</div>
                                <button type="button" class="btn btn-default m-b-5" id="downloadButton">Excel Download</button>
								                                
                            </div>
                            
                            <div class="panel-body">
                            <form class="form-horizontal" role="form" onsubmit="return false;">
                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">Branch</label>
                                        <div class="col-md-10" id="searchBranchesDiv">
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">Campus</label>
                                        <div class="col-md-10" id="searchCampusesDiv">
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Nationality</label>
                                        <div class="col-md-10" id="searchNationalityDiv">
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                <!-- 
                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Type of Group</label>
                                        <div class="col-sm-10" id="searchGroupDiv">
                                        </div>
                                    </div>
                                </div>
                                 -->
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Term</label>
                                        <div class="col-md-5" id="searchTermDiv"></div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <!-- 
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Room</label>
                                        <div class="col-md-10">
                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="checkbox" value="none" id="searchRoom" name="searchRoom">
                                                    <i class="fa"></i> 
                                                    None
                                                </label>
                                            </div>

                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="checkbox" value="assigned" id="searchRoom" name="searchRoom">
                                                    <i class="fa"></i> 
                                                    Assigned
                                                </label>
                                            </div>

                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="checkbox" value="stayout" id="searchRoom" name="searchRoom">
                                                    <i class="fa"></i> 
                                                    Stay-out
                                                </label>
                                            </div>
                                        </div>
                                    </div> 
                                </div> -->
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Status</label>
                                        <div class="col-md-10">
                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="checkbox" value="PROGRESS" id="searchStatus" name="searchStatus">
                                                    <i class="fa"></i> 
                                                    Student
                                                </label>
                                            </div>

                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="checkbox" value="GRADUATED" id="searchStatus" name="searchStatus">
                                                    <i class="fa"></i> 
                                                    Graduate
                                                </label>
                                            </div>

<!-- 
                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="checkbox" value="HOLDED" id="searchStatus" name="searchStatus">
                                                    <i class="fa"></i> 
                                                    Temporarily stopped
                                                </label>
                                            </div>

                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="checkbox" value="CANCELED" id="searchStatus" name="searchStatus">
                                                    <i class="fa"></i> 
                                                    Cancelled
                                                </label>
                                            </div>
 -->                                            
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label input-sm">Name</label>
                                        <div class="col-md-10">
	                                        <div class="col-md-5">
	                                            <input type="text" class="form-control" value="" placeholder="Name" name="searchName" id="searchName">
	                                        </div>
                                        </div>
                                    </div>
                                </div>

								<br> <br>
								<div class="row">
									<div class="form-group">
										<div class="col-sm-8 ">
											<div class="col-sm-12 text-left">
												<label class="control-label" id="totalResult">Result :
													0 </label>
											</div>
										</div>
                                        <div class="col-sm-4">
                                        <div class="col-sm-6 pull-right">
												<select class="form-control input-sm" id="offset">
													<option>50</option>
													<option>100</option>
												</select>
											</div>
										</div>
									</div>
									<!-- form-group -->
								</div>
		        			
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <table class="table table-hover" id="listTable">
                                            <thead>
                                                <tr>
                                                    <th class="text-center" width="5%">No</th>
                                                    <th class="text-center" width="5%">Nationality</th>
                                                    <th class="text-center" width="5%">Term</th>
                                                    <th class="text-center" width="8%">Campus</th>
                                                    <th class="text-center" width="10%">Level</th>
                                                    <th class="text-center" width="15%">Course / Request</th>
                                                    <th class="text-center" width="8%">Birthdate</th>
                                                    <th class="text-center">Name</th>
                                                    <th class="text-center" width="5%">Sex</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>
										<div class="clear"></div>
										<div class="text-center">
											<nav aria-label="Page navigation">
												<ul class="pagination" id="pagination"></ul>
											</nav>
										</div>
                                    </div>
                                </div>
                                </form>      
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end row -->

            </div>
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
        <script src="/assets/chat/moment-2.2.1.js"></script>

        <!-- sweet alerts -->
        <script src="/assets/sweet-alert/sweet-alert.min.js"></script>
        <script src="/assets/sweet-alert/sweet-alert.init.js"></script>

        <script src="/js/jquery.app.js"></script>
        <script src="/js/jquery.twbsPagination.js"></script>
        
        <script src="/js/jquery.session.js"></script>
        <script src="/js/jquery.cookie.js"></script>
        <script src="/custom/pia-ajaxs.js"></script>
        <script src="/custom/pia-tools.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function() {
                initPaging();

        		gridSearchBranches();
        		gridSearchNationality("checkbox", $("#searchNationalityDiv"));
        		gridSearchCampuses($("#searchCampusesDiv"));
       			getSearchTerms();

                $("input:radio[name='branch']").change(function() {
               		wrapWindowByMask();
               		
               		$("#searchCampusesDiv").empty();
               		$("#searchGroupDiv").empty();
               		
	        		gridSearchCampuses($("#searchCampusesDiv"));
        			
        			closeWindowByMask();
                });
	                
                $("#newStudentsFile").on("change", newStudentsFileUpload);
                $("#idCardsFile").on("change", idCardsFileUpload);
                $("#newStudentNamesFile").on("change", newStudentNamesFileUpload);
                $("#roomsFile").on("change", roomsFileUpload);
                
                $("#downloadButton").on("click", function() {
               		var branchSeq = $("[name='branch']:checked").val();
                    var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/students/download?" + getParams();
               		window.location = url;
               	});

                $("#offset").change(function() {
            		wrapWindowByMask();
                	search();
            	});
                
                $("#searchButton").on("click", function() {
               		wrapWindowByMask();
                	search();
               	});
                
                setEnterKeyEvent($("#searchName"), function() {
            		wrapWindowByMask();
                	search();
            	});
                
                setCheckboxValue("searchStatus", "PROGRESS");
                search();
            });
            
            function newStudentsFileUpload() {
				if (!$("#newStudentsFile")[0].files[0]) {
					return;
				}
				
				var formData = new FormData();
				formData.append("students", $("#newStudentsFile")[0].files[0]);
				
	            var url = "<%=SERVER_URL%>/students/freshmen/upload";
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
								openSwal("Automatically download the file of result of register freshman.", "Please check the file \n which automatically download file. \n(The file's name is Results_of_freshman_registering.txt)", function() {
									window.location = "<%=SERVER_URL%>/filedownload?filePath="+data.body.data+"&fileName="+encodeURI(encodeURIComponent("Results_of_freshman_registering"));
									closeWindowByMask();
								});
							} else {
								openSwal(data.head.message, "", function() {
									search();
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
            		},
					complete : function(jqXHR, textStatus) {
						$("#newStudentsFile").val("");
						closeWindowByMask();
					}
            	});
	        }
            
            function roomsFileUpload() {
           		if (!$("#roomsFile")[0].files[0]) {
					return;
				}
            		
				var formData = new FormData();
				formData.append("rooms", $("#roomsFile")[0].files[0]);
				
	            var url = "<%=SERVER_URL%>/students/rooms/upload";
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
            			//console.log(data);
        				if (data.head.status == 200) {
        					if (data.body.totalCount > 0) {
    							openSwal(data.head.message, "Please check downloaded file.", function() {
    								window.location = "<%=SERVER_URL%>/filedownload?filePath="+data.body.data+"&fileName="+encodeURI(encodeURIComponent("Roomsetting_failed_list"));
    								closeWindowByMask();
    							});
        	        			} else if (data.head.status == 401) {
        						openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
        							window.location.replace("/login.jsp");
        						});		        					
						} else {
	        					openSwal(data.head.message, "", function() {
	        						search();
	        					});
						}
        				} else {
        					openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
        				}
            		},
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
            		},
					complete : function(jqXHR, textStatus) {
						$("#roomsFile").val("");
						closeWindowByMask();
					}
            	});
	        }
            
            function idCardsFileUpload() {
           		if (!$("#idCardsFile")[0].files[0]) {
					return;
				}
            		
				var formData = new FormData();
				formData.append("students", $("#idCardsFile")[0].files[0]);
				
	            var url = "<%=SERVER_URL%>/students/idcard/upload";
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
        						var updateFailedStudents = data.body.data.updateFailedStudents;
        						var alertTitle = "";
        						var alertMessage = "";
        						if (updateFailedStudents > 0) {
        							alertTitle = "Some Information are Failed to Update the system.";
	        						alertMessage = "Some Information are Failed to Update the system. ";
	        						alertMessage += "\n[";
        							alertMessage += "Update Failed Students : " + updateFailedStudents;
	        						alertMessage += "]";
	        						console.log("updateFailedStudents : ", data.body.data.updateFailedStudents);
							} else {
								alertTitle = data.head.message;
								alertMessage = "[Status Code : " + data.head.status + "]";
							}
	        					openSwal(alertTitle, alertMessage, search);

        	        			} else if (data.head.status == 401) {
        						openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
        							window.location.replace("/login.jsp");
        						});		        					
						} else {
	        					openSwal(data.head.message, "", function() {
	        						search();
	        					});
						}
        				} else {
        					openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
        				}
            		},
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
            		},
					complete : function(jqXHR, textStatus) {
						$("#idCardsFile").val("");
						closeWindowByMask();
					}
            	});
	        }
            
            function newStudentNamesFileUpload() {
           		if (!$("#newStudentNamesFile")[0].files[0]) {
					return;
				}
            		
				var formData = new FormData();
				formData.append("students", $("#newStudentNamesFile")[0].files[0]);
				
	            var url = "<%=SERVER_URL%>/students/names/upload";
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
        						var updateFailedStudents = data.body.data.updateFailedStudents;
        						var alertTitle = "";
        						var alertMessage = "";
        						if (updateFailedStudents.length > 0) {
        							alertTitle = "Some Information are Failed to Update the system.";
	        						alertMessage = "Some Information are Failed to Update the system. ";
	        						//alertMessage += "\n[";
        							//alertMessage += "Update Failed Students : " + updateFailedStudents;
	        						//alertMessage += "]";
	        						console.log("updateFailedStudents : ", data.body.data.updateFailedStudents);
							} else {
								alertTitle = data.head.message;
								alertMessage = "[Status Code : " + data.head.status + "]";
							}
	        					openSwal(alertTitle, alertMessage, search);
						} else {
	        					openSwal(data.head.message, "", function() {
	        						search();
	        					});
						}
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
						$("#newStudentNamesFile").val("");
						closeWindowByMask();
					}
            	});
	        }
            
            function paginSearch() {
           		wrapWindowByMask();
        		getListData();
            }
            
            function search() {
        		paramSelectedPage = 1;
        		getListData();
            }
            
			var totalCount = 0;
			var paramSelectedPage = 1;
			function getListData() {
				var branchSeq = $("[name='branch']:checked").val();
                var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/students?" + getParams();
                
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "GET",
            		dataType : "json",
            		contentType : "application/json; charset=UTF-8",
            		success : getListSuccessFnc,
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
            			closeWindowByMask();
            		}
            	});
			}

            function getListSuccessFnc(response) {
    			$("#listTable tbody").empty();
        		if (response.head.status == 200) {
        			var paramOffset = $("#offset option:selected").text();
        			var $data = response.body.data;
        			totalCount = response.body.totalCount;
        			
        			$("#totalResult").text("Result : " + totalCount);
        			//console.log("totalCount : ", totalCount, "data : ", $data);
        			
        			var html = "";
        			var no = totalCount - ((paramSelectedPage -1) * $("#offset option:selected").text());
        			$.each($data, function(index, item) {
	        			//console.log("index : ", index, ", item : ", item);
        				html = "";
        				html += "<tr onClick=\"openDetail('" + item.branchSeq + "', '" + item.studentId + "');\" style=\"cursor:pointer\">"; 
        				html += "<td class=\"text-center\">" + (no--) + "</td>"; 
        				html += "<td class=\"text-center\">" + item.nationality + "</td>"; 
        				html += "<td class=\"text-center\">" + item.term + "</td>"; 
        				html += "<td class=\"text-center\">" + item.campus + "</td>"; 
        				html += "<td class=\"text-center\">" + item.level + "</td>"; 
        				html += "<td class=\"text-center\">" + item.course + " / " + item.requestCourse + "</td>"; 
        				html += "<td class=\"text-center\">" + item.dayOfBirth + "</td>"; 
        				html += "<td class=\"text-center\">" + item.name + "</td>"; 
        				html += "<td class=\"text-center\">" + item.sex + "</td>"; 
        				html += "</tr>"; 
	        			$("#listTable tbody").append(html);
        				//console.log(html);
        			});
	        			
        			if (totalCount < 1) {
        				html += "<tr>"; 
        				html += "<td colspan=\"9\" class=\"text-center\">";
        				html += "None."; 
        				html += "</td>"; 
        				html += "</tr>"; 
	        			$("#listTable tbody").append(html);
					}
	        			
        			gridPage(totalCount);
        		} else if (response.head.status == 401) {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]", function() {
						window.location.replace("/login.jsp");
					});
				} else {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]");
				}
        		
        		closeWindowByMask();
        	}

			function getParams() {
				var paramOffset = $("#offset option:selected").text();
				var paramCampusSeqs = getCheckedValues("campus");
				var paramNationalities = getCheckedValues("nationality"); // [1, 2, 3]
				var paramTermDetail = $("#termDetailSeq").val();
				var paramRoomState = getCheckedValues("searchRoom");
				var paramStatus = getCheckedValues("searchStatus");
				var paramWriter = $.trim($("#searchName").val());
				
       			var params = {
       					selectedPage : paramSelectedPage,
       					offset : paramOffset,
       					campusSeqs : paramCampusSeqs,
       					nationalitySeqs : paramNationalities,
       					termDetailSeq : paramTermDetail,
       					roomState : paramRoomState,
       					status : paramStatus,
       					name : encodeURI(paramWriter)
       			};
       			
       			return $.param(params);
			}
            
            function openDetail(branchSeq, studentId) {
       			window.location.href = "studentDetail.jsp?branchSeq="+ branchSeq +"&studentId=" + studentId;
            }

            function gridSearchNationality(inputType, $gridDiv) {
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
                       		gridCookieData(JSON.stringify(data.body.data), "checkbox", "nationality", $gridDiv);
                   		}
                   	},
               		error : function(jqXHR, textStatus, errorThrown) {
               			console.log(jqXHR, textStatus, errorThrown);
   						closeWindowByMask();
   					}
               	});
            }

            function gridSearchCampuses($gridDiv) {
           		var branchSeq = $("input:radio[name='branch']:checked").val();
           		if (!branchSeq) {
					return false;		
				}
            		
            	var url = "<%=SERVER_URL%>/conditions/" + branchSeq + "/campuses";
               	$.ajax({
               		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
               		url : url,
               		type : "GET",
               		dataType : "json",
               		contentType : "application/json; charset=UTF-8",
   					success : function(data, textStatus, jqXHR) {
                   		if (data.head.status == 200) {
                   			gridCookieData(JSON.stringify(data.body.data), "checkbox", "campus", $("#searchCampusesDiv"));
                   		}
                   	},
               		error : function(jqXHR, textStatus, errorThrown) {
               			console.log(jqXHR, textStatus, errorThrown);
   						closeWindowByMask();
   					}
               	});
            }
            
            function getSearchTerms() {
           		var branchSeq = $("input:radio[name='branch']:checked").val();
            	var url = "<%=SERVER_URL%>/conditions/" + branchSeq + "/terms/details";
               	$.ajax({
               		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
               		url : url,
               		type : "GET",
               		dataType : "json",
               		contentType : "application/json; charset=UTF-8",
   					success : function(data, textStatus, jqXHR) {
    	            		if (data.head.status == 200) {
    	            			gridSeachTerms(data.body.data, $("#searchTermDiv"), true);
    		        		}
                   	},
               		error : function(jqXHR, textStatus, errorThrown) {
               			console.log(jqXHR, textStatus, errorThrown);
   						closeWindowByMask();
   					}
               	});
            }

            function gridSeachTerms(response, $gridDiv, isWithAll) {
       			var $data = response;
       			//console.log($data);
       			
       			var html = "";
       			html += "<div class=\"col-sm-5\">";
       			html += "<select class=\"form-control input-sm\" name=\"termDetailSeq\" id=\"termDetailSeq\">";
       			if (getBoolean(isWithAll)) {
        			html += "<option value=\"\">All</option>";
				}
       			$.each($data, function(index, item) {
           			html += "<option value=\"" + item.seq + "\">" + item.name + "</option>";
       			});
       			html += "</select>";
       			html += "</div>";
       			html += "";
       			$gridDiv.append(html);
        	}
            
            setStaffNameOnHeader();
        </script>
    </body>
</html>
