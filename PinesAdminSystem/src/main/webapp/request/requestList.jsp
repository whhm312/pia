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
                                <button type="button" class="btn btn-default m-b-5" id="searchButton">Search</button>
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
                                        <label class="col-md-2 control-label">Status</label>
                                        <div class="col-md-10">
                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="checkbox" name="status" value="Request">
                                                    <i class="fa"></i> 
                                                    Request
                                                </label>
                                                <label class="cr-styled">
                                                    <input type="checkbox" name="status" value="In Progress">
                                                    <i class="fa"></i> 
                                                    In Progress
                                                </label>
                                                <label class="cr-styled">
                                                    <input type="checkbox" name="status" value="Finished">
                                                    <i class="fa"></i> 
                                                    Finished
                                                </label>
                                            </div>
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Type of Request</label>
                                        <div class="col-md-10">
                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="checkbox" name="requestType" value="Room Facilities">
                                                    <i class="fa"></i> 
                                                    Room Facilities
                                                </label>
                                                <label class="cr-styled">
                                                    <input type="checkbox" name="requestType" value="Classroom Facilities">
                                                    <i class="fa"></i> 
                                                    Classroom Facilities
                                                </label>
                                                <label class="cr-styled">
                                                    <input type="checkbox" name="requestType" value="Consultation">
                                                    <i class="fa"></i> 
                                                    Consultation
                                                </label>
                                                <label class="cr-styled">
                                                    <input type="checkbox" name="requestType" value="Study">
                                                    <i class="fa"></i> 
                                                    Study
                                                </label>
                                                <label class="cr-styled">
                                                    <input type="checkbox" name="requestType" value="Other">
                                                    <i class="fa"></i> 
                                                    Other
                                                </label>
                                            </div>
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Staff</label>
                                        <div class="col-md-10">
	                                        <div class="col-md-5">
	                                            <input type="text" class="form-control input-sm" value="" placeholder="" id="staff">
	                                        </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Student</label>
                                        <div class="col-md-10">
	                                        <div class="col-md-5">
	                                            <input type="text" class="form-control input-sm" value="" placeholder="" id="student">
	                                        </div>
                                        </div>
                                    </div>
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
                                                    <th class="text-center" width="8%">No</th>
                                                    <th class="text-center" width="8%">Campus</th>
                                                    <th class="text-center" width="12%">Type</th>
                                                    <th class="text-center" width="22%">Student</th>
                                                    <th class="text-center" width="14%">Staff</th>
                                                    <th class="text-center" width="7%">Status</th>
                                                    <th class="text-center" width="8%">Date Requested</th>
                                                    <th class="text-center" width="8%">Date Responded</th>
                                                    <th class="text-center" width="8%">Date Finished</th>
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
        <script src="/js/jquery.nicescroll.js"></script>

        <!-- sweet alerts -->
        <script src="/assets/sweet-alert/sweet-alert.min.js"></script>
        <script src="/assets/sweet-alert/sweet-alert.init.js"></script>

        <script src="/js/jquery.app.js"></script>
        <script src="/js/jquery.twbsPagination.js"></script>

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
                initPaging();

	        		gridSearchBranches();
                gridSearchCampuses();
                
                $("#searchButton").on("click", search);
	    			
                $("#offset").change(getListData);
                
                setEnterKeyEvent($("#staff"), search);
                setEnterKeyEvent($("#student"), search);
                
                search();
            });

            function gridSearchCampuses() {
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
	    	            			gridCookieData(JSON.stringify(data.body.data), "radio", "campus", $("#searchCampusesDiv"));
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
            		//console.log(getParams());
	            	var branchSeq = $("input:radio[name='branch']:checked").val();
	        		var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/students/requests?" + getParams();
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
                		},
    					complete : function(jqXHR, textStatus) {
    						closeWindowByMask();
    					}
                	});
            }
            
            function getListSuccessFnc(response) {
            		//console.log(response);
	    			$("#listTable tbody").empty();
	        		if (response.head.status == 200) {
	        			var $data = response.body.data;
	        			totalCount = response.body.totalCount;
	        			
	        			$("#totalResult").text("Result : " + totalCount);
	        			console.log("totalCount : ", totalCount, "data : ", $data);
	
	        			var html = "";
	        			var no = totalCount - ((paramSelectedPage -1) * $("#offset option:selected").text());
	        			$.each($data, function(index, item) {
		        			//console.log("index : ", index, ", item : ", item);
	        				html = "";
	        				html += "<tr onClick=\"openDetail(" + item.requestSeq + ");\" style=\"cursor:pointer\">"; 
	        				html += "<td class=\"text-center\">" + (no--) + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.campus + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.type + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.student + "</td>";
	        				if (item.staff) {
		        				html += "<td class=\"text-center\">" + item.staff + "</td>"; 
						} else {
		        				html += "<td class=\"text-center\">" + item.progressStaffId + "</td>"; 
						}
	        				html += "<td class=\"text-center\">" + item.status + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.registerDate + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.progressDate + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.replyDate + "</td>"; 
	        				html += "</tr>"; 
		        			$("#listTable tbody").append(html);
	        				//console.log(html);
	        			});
	        			
	        			gridPage(totalCount);
	        			
	        		} else if (response.head.status == 401) {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]", function() {
						window.location.replace("/login.jsp");
					});
				} else {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]");
				}
	        	}

			function getParams() {
				var paramOffset = $("#offset option:selected").text();
				var paramStatus = getCheckedValues("status"); // ['Reqeust', 'In Progress', 'Finished']
				var paramType = getCheckedValues("requestType"); // [1, 2, 3]
				var paramCampus = $("input:radio[name='campus']:checked").val();
				var paramStaff = $("#staff").val();
				var paramStudent = $("#student").val();
				
        			var params = {
        					selectedPage : paramSelectedPage,
        					offset : paramOffset,
        					type : paramType,
        					status : paramStatus, 
        					campusSeq : paramCampus, 
        					staff : encodeURI(paramStaff),
        					student : encodeURI(paramStudent)
        			};
        			
        			return $.param(params);
			}
			
            function openDetail(requestSeq) {
	            	var branchSeq = $("input:radio[name='branch']:checked").val();
            		window.location.href = "requestDetail.jsp?branchSeq="+ branchSeq +"&requestSeq=" + requestSeq;
            }
            
            setStaffNameOnHeader();
        </script>
    

    </body>
</html>
