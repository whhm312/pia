<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<%@ include file="/include/head.jsp" %>
    <style type="text/css">
		#table-wrapper {
		  position:relative;
		}
		#table-scroll {
		  height:200px;
		  overflow:auto;  
		}
		#table-wrapper table {
		  width:100%;
		}
		#table-wrapper table thead th .text {
		  position:absolute;   
		  top:-20px;
		  z-index:2;
		  height:20px;
		  width:35%;
		  border:1px solid red;
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
                            <li><a href="/exam/examList.jsp">Examination & Results</a></li>
                            <li class="active"><a href="/attendance/attendanceList.jsp">Attendance</a></li>
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
                    <h3 class="title">Attendance</h3> 
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right ">
                                <button type="button" class="btn btn-default m-b-5" id="searchButton">Search</button>
                                <button type="button" class="btn btn-default m-b-5" id="newButton">New</button>
                            </div>
			                
                            <div class="panel-body">
                                <form class="form-horizontal" role="form">

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
                                        <label class="col-md-2 control-label">Date</label>
                                        <div class="col-md-10">
			                                <div class="col-md-3 input-group" style="margin-left: 20px;">
			                                    <input type="text" class="form-control input-sm" id="classDate" name="classDate" required aria-required="true">
			                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                                </div><!-- input-group -->                                        
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-sm-8 ">
                                        <div class="col-sm-12 text-left">
                                        <label class="control-label" id="totalResult">Result : 0 </label>
                                        </div>
                                        </div>
                                        <div class="col-sm-4">
                                        <div class="col-sm-6 pull-right">
                                            <select class="form-control input-sm" id="offset">
                                                <option>10</option>
                                                <option>20</option>
                                                <option>30</option>
                                            </select>
                                        </div>
                                        </div>
                                    </div> <!-- form-group -->
                                </div> 
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <table class="table table-hover" id="listTable">
                                            <thead>
                                                <tr>
                                                    <th class="text-center" width="5%">No</th>
                                                    <th class="text-center" width="8%">Branch</th>
                                                    <th class="text-center" width="8%">Campus</th>
                                                    <th class="text-center" width="8%">Class Time</th>
                                                    <th class="text-center" width="7%">Type</th>
                                                    <th class="text-center" width="15%">Name of Student</th>
                                                    <th class="text-center" width="5%">E/U</th>
                                                    <th class="text-center" width="20%">Memo</th>
                                                    <th class="text-center" width="5%">X</th>
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

<form id="newAttandanceForm">
<div id="newAttandance" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
	<div class="modal-dialog modal-lg"> 
		<div class="modal-content"> 
			<div class="modal-header"> 
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> 
				<h4 class="modal-title">Search Student</h4> 
			</div> 
			<div class="modal-body">
				<div class="row"> 
					<div class="col-md-12"> 
						<div class="form-group"> 
							<label for="field-1" class="col-md-2 control-label">Date</label>
							<div class="col-md-10">
								<div class="col-md-3 input-group" style="margin-left: 20px;">
									<input type="text" class="form-control input-sm" id="newClassDate" name="newClassDate" required aria-required="true">
									<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
								</div><!-- input-group -->          
							</div> 
						</div> 
					</div> 
				</div>
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-2" class="col-md-2 control-label">Branch</label>
							<div class="col-md-10" id="newBranchesDiv"></div> 
						</div> 
					</div> 
				</div>
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-3" class="col-md-2 control-label">Campus</label> 
							<div class="col-md-10" id="newCampusesDiv"></div> 
						</div> 
					</div> 
				</div>
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-4" class="col-md-2 control-label">Level</label> 
							<div class="col-md-10" id="newLevelsDiv"></div> 
						</div> 
					</div> 
				</div>
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-4" class="col-md-2 control-label">Class Time</label> 
							<div class="col-md-10" id="newTimetablesDiv"></div> 
						</div> 
					</div> 
				</div>
			</div> 
			<div class="modal-footer">
				<div class="row" id="table-wrapper">
					<div class="col-md-12 col-sm-12 col-xs-12" id="table-scroll">
						<table class="table table-hover">
							<thead>
								<tr>
									<th class="text-center" width="5%">#</th>
									<th class="text-center" width="20%">Student's Name</th>
									<th class="text-center" width="15%">Attendance</th>
									<th class="text-center" width="15%">Excused</th>
									<th class="text-center" width="10%">Save</th>
								</tr>
							</thead>
							<tbody id="newStudentsTbody">
							</tbody>
						</table>
					</div>
				</div>			
			</div> 
		</div> 
	</div>
</div><!-- /.modal -->
</form>


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
        <script src="/js/jquery.nicescroll.js"></script>

        <!-- sweet alerts -->
        <script src="/assets/sweet-alert/sweet-alert.min.js"></script>
        <script src="/assets/sweet-alert/sweet-alert.init.js"></script>

        <script src="/js/jquery.app.js"></script>
        <script src="/js/jquery.twbsPagination.js"></script>
        
        <script src="/assets/timepicker/bootstrap-datepicker.js"></script>
        
        <script src="/assets/jquery.validate/jquery.validate.js"></script>

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
                initPaging();

                gridSearchBranchesWithoutChecked();
                $("input:radio[name='branch']").click(function() {
                		$("#searchCampusesDiv").empty();
                		var branchSeq = $("input:radio[name='branch']:checked").val();
		        		gridSearchCampuses(branchSeq, "searchCampusesDiv", "campus", function() {
		        			$("input:radio[name='campus']").eq(0).attr("checked", true);
		        		});
                });
                $("input:radio[name='branch']").eq(0).attr("checked", true).trigger("click");
                
                $("#searchButton").on("click", search);
                $("#newButton").on("click", openNew);
                $("#offset").change(getListData);
            });

            function initPlugins() {
        			$("#classDate").datepicker({"format" : "yyyy/mm/dd"}).on("changeDate", function(e){
        			    $(this).datepicker("hide");
        			});
                $("#classDate").datepicker("setDate", new Date());
                
        			$("#newClassDate").datepicker({"format" : "yyyy/mm/dd"}).on("changeDate", function(e){
        			    $(this).datepicker("hide");
        			});
                $("#newClassDate").datepicker("setDate", new Date());

	    	        $("#newAttandanceForm").validate({
	    	        	 	errorPlacement: function(error, element) {
	    	        	 		if (element.attr("name") == 'newReason') {
	    	        	 			error.insertAfter($("[name=newReason]"));
	    	        	 		}
	    	            },
	    	            highlight: function (element, required) {
	    	            		$(element).parent().parent().parent().css("background-color", "#FBEFF2");
		    	        	}
	    	        });
            }
            
            function gridSearchCampuses(branchSeq, divId, elId, completeFunc) {
            		if (!branchSeq) {
					closeWindowByMask();
					return false;
				}

		    		$("#"+divId).empty();
		    		$("#newLevelsDiv").empty();
		    		$("#newTimetablesDiv").empty();
		    		$("#newStudentsTbody").empty();
            		
	            	var url = "<%=SERVER_URL%>/conditions/" + branchSeq + "/campuses";
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
	    	            			gridCookieData(JSON.stringify(data.body.data), "radio", elId, $("#"+divId));
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
    						if (completeFunc) {
    							completeFunc();
						}
    						
    						closeWindowByMask();
    					}
                	});
            }

            function paginSearch() {
            		getListData();
            }
            
            function search() {
            		paramSelectedPage = 1;
            		getListData();
            }

			var totalCount = 0;
			var paramSelectedPage = 1;
            function getListData() {
            		var branchSeq = $("input:radio[name='branch']:checked").val();
            		var campusSeq = $("input:radio[name='campus']:checked").val();
            		if (!branchSeq || !campusSeq) {
            			closeWindowByMask();
					return false;		
				}
            		
	        		var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/attendances?" + getParams();
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		type : "GET",
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
                		beforeSend : function (jqXHR, settings) {
    						wrapWindowByMask();
                		},
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
	        			var $data = response.body.data;
	        			totalCount = response.body.totalCount;
	        			
	        			$("#totalResult").text("Result : " + totalCount);
	        			no = totalCount;
	        			console.log("totalCount : ", totalCount, "data : ", $data);
	
	        			var html = "";
	        			var no = totalCount - ((paramSelectedPage -1) * $("#offset option:selected").text());
	        			$.each($data, function(index, item) {
		        			//console.log("index : ", index, ", item : ", item);
	        				html = "";
	        				html += "<tr>"; 
	        				html += "<td class=\"text-center\">" + (no--) + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.branch + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.campus + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.classTime + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.attendanceType + "</td>";
	        				html += "<td class=\"text-center\">" + item.studentName + "</td>"; 
	        				if (getBoolean(item.isExcused)) {
		        				html += "<td class=\"text-center\">E</td>"; 
						} else {
		        				html += "<td class=\"text-center\">UE</td>"; 
						}
	        				html += "<td>" + item.memo + "</td>"; 
	        				html += "<td class=\"text-center\" style=\"cursor:pointer\" branchSeq=\"" + item.branchSeq + "\" campusSeq=\"" + item.campusSeq + "\" attendanceSeq=\"" + item.attendanceSeq + "\" onClick=\"deleteAttendance(this);\">X</td>"; 
	        				html += "</tr>"; 
		        			$("#listTable tbody").append(html);
	        			});
	        			
	        			if ($data.length < 1) {
	        				html = "<tr><td class=\"text-center\" colspan=\"8\">None.</td></tr>";	
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
				var paramClassDate = $("#classDate").val();
        			var params = {
        					selectedPage : paramSelectedPage,
        					offset : paramOffset,
        					classDate : paramClassDate
        			};
        			
        			return $.param(params);
			}
			
			function openNew() {
				$("#newBranchesDiv").empty();
       			$("#newCampusesDiv").empty();
				$("#newLevelsDiv").empty();
				$("#newTimetablesDiv").empty();
				$("#newStudentsTbody").empty();
				
				gridBranches("radio", "newBranch", $("#newBranchesDiv"));
                $("input:radio[name='newBranch']").change(function() {
            			$("#newCampusesDiv").empty();
            			
            			var branchSeq = $("input:radio[name='newBranch']:checked").val();
		        		gridSearchCampuses(branchSeq, "newCampusesDiv", "newCampus", function() {
						$("input:radio[name='newCampus']").click(function() {
							gridNewLevels();
						});
		        		});
	            });
				$("#newAttandance").modal();
			}

		    function gridNewLevels() {
		    		var branchSeq = $("[name='newBranch']:checked").val();
		    		var campusSeq = $("[name='newCampus']:checked").val();
		    		
		    		$("#newLevelsDiv").empty();
		    		$("#newTimetablesDiv").empty();
		    		$("#newStudentsTbody").empty();
		    		
		        	var url = "<%=SERVER_URL%>/conditions/" + branchSeq + "/campuses/" + campusSeq + "/levels";
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		type : "GET",
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
					success : function(data, textStatus, jqXHR) {
						if (data.head.status == 200) {
			        			var $data = data.body.data;
			        			//console.log($data);
			        			
			        			var html = "";
			        			html += "<div class=\"col-sm-5\" style=\"margin-left:10px\">";
			        			html += "<select class=\"form-control input-sm\" name=\"newLevel\" id=\"newLevel\" required>";
			        			html += "<option value=\"\">Select..</option>";
			        			$.each($data, function(index, item) {
			            			html += "<option value=\"" + item.seq + "\">" + item.name + "</option>";
			        			});
			        			html += "</select>";
			        			html += "</div>";
			        			$("#newLevelsDiv").append(html);
			        			
			        			$("#newLevel").change(function() {
			        				gridNewSchedules();
			        				gridNewStudents();
			        			});
			        			
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

		    function gridNewSchedules() {
		    		var branchSeq = $("[name='newBranch']:checked").val();
		    		var campusSeq = $("[name='newCampus']:checked").val();
		    		var levelSeq = $("[name='newLevel']").val();
		    		
		    		$("#newTimetablesDiv").empty();
		    		$("#newStudentsTbody").empty();
		    		
		        	var url = "<%=SERVER_URL%>/conditions/" + branchSeq + "/campuses/" + campusSeq + "/levels/" + levelSeq + "/timetable";
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		type : "GET",
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
					success : function(data, textStatus, jqXHR) {
						if (data.head.status == 200) {
			        			var $data = data.body.data;
			        			//console.log($data);
			        			
			        			var html = "";
			        			html += "<div class=\"col-sm-5\" style=\"margin-left:10px\">";
			        			html += "<select class=\"form-control input-sm\" name=\"newTimetable\" id=\"newTimetable\" required>";
			        			html += "<option value=\"\">Select..</option>";
			        			$.each($data, function(index, item) {
			            			html += "<option value=\"" + item.seq + "\">" + item.name + "</option>";
			        			});
			        			html += "</select>";
			        			html += "</div>";
			        			$("#newTimetablesDiv").append(html);
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

		    function gridNewStudents() {
		    		var branchSeq = $("[name='newBranch']:checked").val();
		    		var campusSeq = $("[name='newCampus']:checked").val();
		    		var levelSeq = $("[name='newLevel']").val();
		    		
        			$("#newStudentsTbody").empty();
        			
		        	var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/students/levels/" + levelSeq;
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
			        			var $data = data.body.data;
			        			var html = "";
			        			var no = data.body.totalCount;
			        			if (no < 1) {
			        				$("#newStudentsTbody").append("<tr><td colspan=\"5\" class=\"text-center\">None.</td></tr>");
			        				return false;
							}
			        			
			        			//console.log($data);
			        			$.each($data, function(index, item) {
			        				html += "<tr>";
			        				html += "<td class=\"text-center\"> " + (no--) + "</td>";
			        				html += "<td class=\"text-center\">" + item.name + "</td>";
			        				html += "<td class=\"text-center\">";
			        				html += "<div class=\"radio-inline\" style=\"padding-left:0px\">";
			        				html += "<label class=\"cr-styled\">";
			        				html += "<input type=\"radio\" name=\"newAttendanceType_" + index + "\" id=\"newAttendanceType\" value=\"lateness\" required aria-required=\"true\"> <i class=\"fa\"></i>L</label>";
			        				html += "</div>";
			        				html += "<div class=\"radio-inline\" style=\"padding-left:0px\">";
			        				html += "<label class=\"cr-styled\">";
			        				html += "<input type=\"radio\" name=\"newAttendanceType_" + index + "\" id=\"newAttendanceType\" value=\"absence\" required aria-required=\"true\"> <i class=\"fa\"></i>A</label>";
			        				html += "</div>";
			        				html += "</td>";
			        				html += "<td class=\"text-center\">";
			        				html += "<div class=\"radio-inline\" style=\"padding-left:0px\">";
			        				html += "<label class=\"cr-styled\">";
			        				html += "<input type=\"radio\" name=\"newExcusedType_" + index + "\" id=\"newExcusedType\" value=\"excused\" required aria-required=\"true\"> <i class=\"fa\"></i>E</label>";
			        				html += "</div>";
			        				html += "<div class=\"radio-inline\" style=\"padding-left:0px\">";
			        				html += "<label class=\"cr-styled\">";
			        				html += "<input type=\"radio\" name=\"newExcusedType_" + index + "\" id=\"newExcusedType\" value=\"unexcused\" required aria-required=\"true\"> <i class=\"fa\"></i>U</label>";
			        				html += "</div>";
			        				html += "</td>";
			        				html += "<td class=\"text-center\">";
			        				html += "<button type=\"button\" class=\"btn btn-block btn-xs btn-purple\" studentId=\"" + item.studentId + "\" name=\"newAttendanceButton\">Save</button>";
			        				html += "</td>";
			        				html += "</tr>";
			        				
 			        				html += "<tr id=\"reasonTr\" style=\"display:none;\">";
			        				html += "<td colspan=\"5\">";
			        				html += "<div class=\"form-group\">";
			        				html += "<label class=\"col-md-2 control-label\">Memo : </label>";
			        				html += "<div class=\"col-md-10\">";
			        				html += "<div class=\"col-md-12\">";
			        				html += "<input type=\"text\" class=\"form-control input-sm\" value=\"\" placeholder=\"\" name=\"newReason\" id=\"newReason\" aria-required=\"false\" required=\"false\">";
			        				html += "</div>";
			        				html += "</div>";
			        				html += "</div>";
			        				html += "</td>";
			        				html += "</tr>";
			        			});
			        			$("#newStudentsTbody").append(html);
			        			
			        			initValidateRadioButtonsById(["newAttendanceType", "newExcusedType"]);
			        			$("[id=newExcusedType]").click(function() {
			        				if ($(this).val() == "excused") {
			        					$(this).parents("tr").next().show();
			        					$(this).parents("tr").next().find("#newReason").attr("required", true);
								} else {
									$(this).parents("tr").next().hide();
									$(this).parents("tr").next().find("#newReason").val("");
									$(this).parents("tr").next().find("#newReason").attr("required", false);
								}
			        			});
			        			
			        			$("[name=newAttendanceButton]").click(function() {
			               		if (checkValid($(this))) {
				    					$("#newAttendanceType").parent().parent().parent().css("background-color", "");
				    					$("#newExcusedType").parent().parent().parent().css("background-color", "");
				    					var data = getSaveNewAttendanceParams($(this));
				    					saveStudentAttendance(data);
				    				} else {
				    					return false;	
				    				}
			        			});
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
		    
			function checkValid(el) {
				var choseIndex = $(el).index();
				var paramStudentId = $(el).attr("studentId");
				var paramNewAttendanceType = $("[id=newAttendanceType]:checked").eq(choseIndex).val();
				var paramNewExcusedType = $("[id=newExcusedType]:checked").eq(choseIndex).val();
				var paramNewReason = $("[id=newReason]").eq(choseIndex).val();
				var paramNewTimetableSeq = $("#newTimetable").val();
				var paramNewClassDate = $("#newClassDate").val();
				var paramNewBranchSeq = $("[name='newBranch']:checked").val();
				var paramNewCampusSeq = $("[name='newCampus']:checked").val();
				
				//console.log("choseIndex : ", choseIndex, ", paramStudentId : ", paramStudentId, ", paramNewAttendanceType : ", paramNewAttendanceType, ", paramNewExcusedType : ", paramNewExcusedType, ", paramNewReason : ", paramNewReason);
				//console.log("paramNewTimetableSeq : ", paramNewTimetableSeq, ", paramNewClassDate : ", paramNewClassDate, ", paramNewBranchSeq : ", paramNewBranchSeq, ", paramNewCampusSeq : ", paramNewCampusSeq);
				
				var result = true;
				if (!paramStudentId) {
					alert("Error : Stduent's information is empty.");
					result = false;
				}
				
				if (!paramNewAttendanceType) {
					$("[id=newAttendanceType]").eq(choseIndex).parents("td").css("background-color", "#FBEFF2");
					alert("Lack of Attendance Type data.");
					result = false;
				} else {
					$("[id=newAttendanceType]").eq(choseIndex).parents("td").css("background-color", "");
				}
				
				if (paramNewExcusedType != "excused" && paramNewExcusedType != "unexcused") {
					$("[id=newExcusedType]").eq(choseIndex).parents("td").css("background-color", "#FBEFF2");
					paramNewExcusedType = $("[id=newExcusedType]:checked").eq(choseIndex).val() == "excused";
					alert("Lack of Excused Type data.");
					result = false;
				} else {
					$("[id=newExcusedType]").eq(choseIndex).parents("td").css("background-color", "");
					paramNewExcusedType = $("[id=newExcusedType]:checked").eq(choseIndex).val() == "excused";
				}
				
				if (!paramNewReason && paramNewExcusedType) {
					$("[id=newReason]").eq(choseIndex).css("border","1px solid red");
					$("[id=newReason]").eq(choseIndex).focus();
					alert("Lack of Reason of excused data.");
					result = false;
				} else {
					$("[id=newReason]").eq(choseIndex).css("border","");
				}
				
				if (!paramNewTimetableSeq) {
					alert("Lack of Class Time data.");
					$("#newTimetable").css("border","1px solid red");
					result = false;
				} else {
					$("#newTimetable").css("border", "");
				}
				
				if (!paramNewClassDate) {
					alert("Lack of Class Date data.");
					$("#newClassDate").css("border","1px solid red");
					result = false;
				} else {
					$("#newClassDate").css("border", "");
				}
				
				if (!paramNewBranchSeq) {
					alert("Lack of Branch data.");
					result = false;
				}
				
				if (!paramNewCampusSeq) {
					alert("Lack of Campus data.");
					result = false;
				}
				return result;
			}
		    
		    function saveStudentAttendance(newData) {
	    			var newBranchSeq = $("[name='newBranch']:checked").val();
	    			var newCampusSeq = $("[name='newCampus']:checked").val();
		        	var url = "<%=SERVER_URL%>/branches/" + newBranchSeq + "/campuses/" + newCampusSeq + "/attendances";
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		type : "POST",
	            		data : newData,
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
					success : function(data, textStatus, jqXHR) {
	        				if (data.head.status == 200) {
	        	            		paramSelectedPage = 1;
	        	            		getListData();
        	            		
	        					openSwal(data.head.message, "");
	        				} else {
	        					openSwal(data.head.message, "[Status Code : " + data.head.status + "]", closeWindowByMask);
	        				}
		    	        	},
	            		error : function(jqXHR, textStatus, errorThrown) {
   						$("#newAttandance").modal("hide");
   						$("body").removeClass("modal-open");
   						$(".modal-backdrop").remove();
	            			console.log(jqXHR, textStatus, errorThrown);
						closeWindowByMask();
	            		}
	            	});
		    }
		    
			function getSaveNewAttendanceParams(el) {
		    		var choseIndex = $(el).index();
		    		var paramStudentId = $(el).attr("studentId");
		    		var paramNewAttendanceType = $("[id=newAttendanceType]:checked").eq(choseIndex).val();
		    		var paramNewExcusedType = $("[id=newExcusedType]:checked").eq(choseIndex).val() == "excused";
		    		var paramNewReason = $("[id=newReason]").eq(choseIndex).val();
		    		var paramNewTimetableSeq = $("#newTimetable").val();
		    		var paramNewClassDate = $("#newClassDate").val();
		    		var paramNewBranchSeq = $("[name='newBranch']:checked").val();
		    		var paramNewCampusSeq = $("[name='newCampus']:checked").val();
		    		
        			var params = {
        					studentId : paramStudentId,
        					attendanceType : paramNewAttendanceType,
        					isExcused : paramNewExcusedType,
        					memo : paramNewReason,
        					classDate : paramNewClassDate,
        					timetableSeq : paramNewTimetableSeq,
        					branchSeq : paramNewBranchSeq,
        					campusSeq : paramNewCampusSeq
        			};
        			
    				return JSON.stringify(params);
			}
			
		    function deleteAttendance(el) {
    				var branchSeq = $(el).attr("branchSeq");
    				var campusSeq = $(el).attr("campusSeq");
    				var attendanceSeq = $(el).attr("attendanceSeq");
		        	var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/attendances/"+attendanceSeq;
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		type : "DELETE",
	            		data : getSaveNewAttendanceParams(el),
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
					success : function(data, textStatus, jqXHR) {
	        				if (data.head.status == 200) {
	        	            		paramSelectedPage = 1;
	        	            		getListData();
	        					openSwal(data.head.message, "");
	        				} else {
	        					openSwal(data.head.message, "[Status Code : " + data.head.status + "]", closeWindowByMask);
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
