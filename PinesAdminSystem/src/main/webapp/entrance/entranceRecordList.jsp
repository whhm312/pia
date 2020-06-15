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
                            <li><a href="/notice/noticeList.jsp">Notice</a></li>
                            <li><a href="/freshman/freshmanList.jsp">Freshman's Guide</a></li>
                            <!-- <li><a href="/meal/meal.jsp">Meal Schedule</a></li> -->
                            <li><a href="/emergency/emergency.jsp">Emergency Contact</a></li>
                            <li class="active"><a href="/entrance/entranceRecordList.jsp">Entrance Records</a></li>
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
                    <h3 class="title">Entrance Records</h3> 
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right ">
                                <button type="button" class="btn btn-default m-b-5" id="searchButton">Search</button>
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
                                        <label class="col-md-2 control-label">Entrance</label>
                                        <div class="col-md-5" id="searchEntranceDiv"></div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Search Type</label>
                                        <div class="col-md-10">
                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="radio" value="CURFEW" id="searchSection" name="searchSection">
                                                    <i class="fa"></i> 
                                                    Curfew
                                                </label>
                                            </div>

                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="radio" value="ORVERTIME" id="searchSection" name="searchSection" checked="checked">
                                                    <i class="fa"></i> 
                                                    Overtime
                                                </label>
                                            </div>
                                            
                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="radio" value="INCOMPLETE" id="searchSection" name="searchSection">
                                                    <i class="fa"></i> 
                                                    Incomplete Record
                                                </label>
                                            </div>
                                            
                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="radio" value="OUTING" id="searchSection" name="searchSection">
                                                    <i class="fa"></i> 
                                                    Only Going Out Record
                                                </label>
                                            </div>
                                            
                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="radio" value="RECORD" id="searchSection" name="searchSection">
                                                    <i class="fa"></i> 
                                                    A Student's Record
                                                </label>
                                            </div>
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                
                                <!-- Curfew Condition Start -->
                                <div id="curfewConditionDiv" style="display: none;">
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Search Date</label>
                                        <div class="col-md-10">
			                                <div class="col-md-3 input-group" style="margin-left: 20px;">
			                                    <input type="text" class="form-control input-sm" id="curfewSearchDate" name="curfewSearchDate">
			                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                                </div><!-- input-group -->                                        
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Curfew Time</label>
                                        <div class="col-md-10">
			                                <div class="col-md-10 form-inline" style="margin-left: 10px;">
			                                <input type="number" class="form-control text-right" value="21" placeholder="" name="curfewLimitedHour" id="curfewLimitedHour" min="0" max="23"> Hour
			                                <input type="number" class="form-control text-right" value="30" placeholder="" name="curfewLimitedMinute" id="curfewLimitedMinute" min="0" max="59"> Minute
			                                </div><!-- input-group -->                                        			                                
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Maximum Going out Minute</label>
                                        <div class="col-md-10">
			                                <div class="col-md-4 form-inline" style="margin-left: 10px;">
			                                <input type="number" class="form-control text-right" value="15" placeholder="" name="curfewMaximumMinute" id="curfewMaximumMinute" min="0"> Minute
			                                </div><!-- input-group -->                                        
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                </div>
                                <!-- Curfew Condition End -->
                                
                                <!-- Overtime Condition Start -->
                                <div id="overtimeConditionDiv" style="display: none;">
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Search Period</label>
                                        <div class="col-md-10 form-inline" style="padding-left:30px">
			                                <div class="col-md-3 input-group">
			                                    <input type="text" class="form-control input-sm" placeholder="yyyy/mm/dd" id="overtimeStartDate" name="overtimeStartDate">
			                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                                </div><!-- input-group -->
			                                ~
			                                <div class="col-md-3 input-group">
			                                    <input type="text" class="form-control input-sm" placeholder="yyyy/mm/dd" id="overtimeEndDate" name="overtimeEndDate">
			                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                                </div><!-- input-group -->
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Exception Search Times</label>
                                        <div class="col-md-10">
			                                <div class="col-md-10 form-inline" style="margin-left: 10px;" id="overtimeExceptionDiv">
			                                <input type="number" class="form-control text-right" style="width: 70px" value="12" placeholder="" name="overtimeExceptionStartHour" id="overtimeExceptionStartHour" min="0" max="23"> :
			                                <input type="number" class="form-control text-right" style="width: 70px" value="00" placeholder="" name="overtimeExceptionStartMinute" id="overtimeExceptionStartMinute" min="0" max="59"> 
			                                ~ 
			                                <input type="number" class="form-control text-right" style="width: 70px" value="13" placeholder="" name="overtimeExceptionEndHour" id="overtimeExceptionEndHour" min="0" max="23"> :
			                                <input type="number" class="form-control text-right" style="width: 70px" value="00" placeholder="" name="overtimeExceptionEndMinute" id="overtimeExceptionEndMinute" min="0" max="59">
			                                <button class="form-control" style="width: 50px;margin-left: 5px" name="buttonAddOvertimeExceptionTime" id="buttonAddOvertimeExceptionTime">+</button>
			                                <button class="form-control" style="width: 50px" name="buttonDelOvertimeExceptionTime" id="buttonDelOvertimeExceptionTime">-</button>
			                                </div><!-- input-group --> 
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Maximum Going out Minute</label>
                                        <div class="col-md-10">
			                                <div class="col-md-4 form-inline" style="margin-left: 10px;">
			                                <input type="number" class="form-control text-right" value="15" placeholder="" name="overtimeMaximumMinute" id="overtimeMaximumMinute" min="0"> Minute
			                                </div><!-- input-group -->                                        
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                </div>
                                <!-- Overtime Condition End -->
                                
                                <!-- Incomplete Condition Start -->
                                <div id="incompleteConditionDiv" style="display: none;">
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Search Period</label>
                                        <div class="col-md-10 form-inline" style="padding-left:30px">
			                                <div class="col-md-3 input-group">
			                                    <input type="text" class="form-control input-sm" placeholder="yyyy/mm/dd" id="incompleteStartDate" name="incompleteStartDate">
			                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                                </div><!-- input-group -->
			                                ~
			                                <div class="col-md-3 input-group">
			                                    <input type="text" class="form-control input-sm" placeholder="yyyy/mm/dd" id="incompleteEndDate" name="incompleteEndDate">
			                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                                </div><!-- input-group -->
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                </div>
                                <!-- Incomplete Condition End -->
                                
                                <!-- Outing Condition Start -->
                                <div id="outingConditionDiv" style="display: none;">
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Room</label>
                                        <div class="col-md-10">
	                                        <div class="col-md-2" style="margin-left: 10px;">
	                                            <input type="text" class="form-control" value="" placeholder="" name="outingRoom" id="outingRoom">
	                                        </div>
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                </div>
                                <!-- Outing Condition End -->
                                
                                <!-- Student Record Condition Start -->
                                <div id="studentRecordConditionDiv" style="display: none;">
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Search Period</label>
                                        <div class="col-md-10 form-inline" style="padding-left:30px">
			                                <div class="col-md-3 input-group">
			                                    <input type="text" class="form-control input-sm" placeholder="yyyy/mm/dd" id="studentRecordStartDate" name="studentRecordStartDate">
			                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                                </div><!-- input-group -->
			                                ~
			                                <div class="col-md-3 input-group">
			                                    <input type="text" class="form-control input-sm" placeholder="yyyy/mm/dd" id="studentRecordEndDate" name="studentRecordEndDate">
			                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			                                </div><!-- input-group -->
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                </div>
                                <!-- Student Record Condition End -->
                                
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label input-sm text-right">
                                        	<select class="form-control input-sm" name="searchType" id="searchType" style="direction: rtl">
                                        		<option value="STUDENT_NAME">Student's Name</option>
                                        		<option value="STUDENT_ID_CARD">Student's ID Card</option>
                                        		<option value="STUDENT_ID">Student's ID</option>
                                        	</select>
                                        </label>
                                        <div class="col-md-10">
	                                        <div class="col-md-5" style="margin-left: 10px;">
	                                            <input type="text" class="form-control" value="" placeholder="" name="searchValue" id="searchValue">
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
													<option>10</option>
													<option>20</option>
													<option>30</option>
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
                                                    <th class="text-center" width="5%">batch</th>
                                                    <th class="text-center" width="10%">level</th>
                                                    <th class="text-center" width="8%">Room</th>
                                                    <th class="text-center">Student's Name</th>
                                                    <th class="text-center" width="8%">birthday</th>
                                                    <th class="text-center" width="15%">Date of Out</th>
                                                    <th class="text-center" width="15%">Date of In</th>
                                                    <th class="text-center" width="5%">Overtime</th>
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
        
        <script src="/assets/timepicker/bootstrap-datepicker.js"></script>
        <script src="/assets/jquery.validate/jquery.validate.js"></script>
        
        <script src="/js/jquery.session.js"></script>
        <script src="/js/jquery.cookie.js"></script>
        <script src="/custom/pia-ajaxs.js"></script>
        <script src="/custom/pia-tools.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function() {
                initPaging();
                initPlugins();

        		gridSearchBranches();
        		gridSearchCampuses();

                $("input:radio[name='branch']").change(function() {
               		wrapWindowByMask();
               		
               		$("#searchCampusesDiv").empty();
	        		gridSearchCampuses();
        			
        			closeWindowByMask();
                });
                
                $("[name=searchSection]").click(toggleSearchCondition);
                $("#downloadButton").click(function() {
    				if (checkValidation()) {
    					return false;
    				}                	
               		var branchSeq = $("[name='branch']:checked").val();
               		var campusSeq = $("[name='campus']:checked").val();
                    var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/entrances/records/download?" + getParams("excel");
                		window.location = url;
               	});

                $("#offset").change(function() {
    				if (checkValidation()) {
    					return false;
    				}
    				
            		wrapWindowByMask();
                	search();
            	});
                
                $("#searchButton").click(function() {
    				if (checkValidation()) {
    					return false;
    				}
    				
               		wrapWindowByMask();
                	search();
               	});
                
                setEnterKeyEvent($("#searchValue"), function() {
    				if (checkValidation()) {
    					return false;
    				}
   				
            		wrapWindowByMask();
                	search();
            	});
                
                $("#buttonAddOvertimeExceptionTime").click(appendAddOvertimeExceptionTime);
                $("#buttonDelOvertimeExceptionTime").click(resetOvertimeExceptionTime);
            });

            function resetOvertimeExceptionTime() {
           		$("#overtimeExceptionStartHour").val("");
           		$("#overtimeExceptionStartMinute").val("");
           		$("#overtimeExceptionEndHour").val("");
           		$("#overtimeExceptionEndMinute").val("");
            }
            
            function appendAddOvertimeExceptionTime() {
        		var html = "<br/>";
        		html += "<div class=\"col-md-10 form-inline\" style=\"margin-left: 10px; margin-top: 10px\">";
        		html += "<input type=\"number\" class=\"form-control text-right\" style=\"width: 70px\" value=\"\" placeholder=\"\" name=\"overtimeExceptionStartHour\" id=\"overtimeExceptionStartHour\"> : ";
        		html += "<input type=\"number\" class=\"form-control text-right\" style=\"width: 70px\" value=\"\" placeholder=\"\" name=\"overtimeExceptionStartMinute\" id=\"overtimeExceptionStartMinute\">";
        		html += " ~ ";
        		html += "<input type=\"number\" class=\"form-control text-right\" style=\"width: 70px\" value=\"\" placeholder=\"\" name=\"overtimeExceptionEndHour\" id=\"overtimeExceptionEndHour\"> : ";
        		html += "<input type=\"number\" class=\"form-control text-right\" style=\"width: 70px\" value=\"\" placeholder=\"\" name=\"overtimeExceptionEndMinute\" id=\"overtimeExceptionEndMinute\">";
        		html += "<button class=\"form-control\" style=\"width: 50px; margin-left: 8px\" name=\"buttonDelOvertimeExceptionTime\" id=\"buttonDelOvertimeExceptionTime\">-</button>";
        		html += "</div>";
        		
            	$("#overtimeExceptionDiv").parent().append(html);
            	$("[name=buttonDelOvertimeExceptionTime]").last().click(function() {
            		$(this).parent().parent().find("br").remove();
            		$(this).parent().remove();
            	});
	        }
            
            function initPlugins() {
        		var defaultDetepickerOptions = {format : "yyyy/mm/dd"};
        		$("#curfewSearchDate").datepicker(defaultDetepickerOptions).on("changeDate", function(e){
    			    $(this).datepicker("hide");
    			});
        		$("#overtimeStartDate").datepicker(defaultDetepickerOptions).on("changeDate", function(e){
    			    $(this).datepicker("hide");
    			});
        		$("#overtimeEndDate").datepicker(defaultDetepickerOptions).on("changeDate", function(e){
    			    $(this).datepicker("hide");
    			});
        		$("#incompleteStartDate").datepicker(defaultDetepickerOptions).on("changeDate", function(e){
    			    $(this).datepicker("hide");
    			});
        		$("#incompleteEndDate").datepicker(defaultDetepickerOptions).on("changeDate", function(e){
    			    $(this).datepicker("hide");
    			});
        		$("#studentRecordStartDate").datepicker(defaultDetepickerOptions).on("changeDate", function(e){
    			    $(this).datepicker("hide");
    			});
        		$("#studentRecordEndDate").datepicker(defaultDetepickerOptions).on("changeDate", function(e){
    			    $(this).datepicker("hide");
    			});
        		
        		var date = new Date();
        		var days = 3;
        		$("#overtimeStartDate").datepicker("setDate", new Date(date.getTime() - (days * 24 * 60 * 60 * 1000)))
        		$("#overtimeEndDate").datepicker("setDate", date)
        		$("#incompleteStartDate").datepicker("setDate", new Date(date.getTime() - (days * 24 * 60 * 60 * 1000)))
        		$("#incompleteEndDate").datepicker("setDate", date)
        		
        		$("#curfewSearchDate").change(function() {
	        		$(this).valid();
        		});
        		$("#overtimeStartDate").change(function() {
	        		$(this).valid();
        		});
        		$("#overtimeEndDate").change(function() {
	        		$(this).valid();
        		});            	
        		$("#incompleteStartDate").change(function() {
	        		$(this).valid();
        		});
        		$("#incompleteEndDate").change(function() {
	        		$(this).valid();
        		});            	
        		$("#studentRecordStartDate").change(function() {
	        		$(this).valid();
        		});
        		$("#studentRecordEndDate").change(function() {
	        		$(this).valid();
        		});            	
            }
            
            function paginSearch() {
				if (checkValidation()) {
					return false;
				}
				
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
				var campusSeq = $("[name='campus']:checked").val();
                var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/entrances/records?" + getParams();
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
			
			function checkValidation() {
				var campusSeq = $("[name='campus']:checked").val();
				if (!campusSeq || campusSeq < 0) {
					alert("Please choose Campus.");
					return true;
				}
				
				var searchSection = $("[name='searchSection']:checked").val();
				if (searchSection == "CURFEW") {
					if (!$("#curfewSearchDate").val()) {
						alert("Please put Search Date.");
						return true;
					}
					
					if (!$("#curfewLimitedHour").val() || $("#curfewLimitedHour").val() < 1) {
						alert("Please put Curfew Hour.");
						return true;
					}
					if (!$("#curfewLimitedMinute").val() || $("#curfewLimitedMinute").val() < 0) {
						alert("Please put Curfew Minute.");
						return true;
					}
					if (!$("#curfewMaximumMinute").val() || $("#curfewMaximumMinute").val() < 10) {
						alert("Please choose Maximum Going out Minute. (Over 10minutes.)");
						return true;
					}
				} else if (searchSection == "ORVERTIME") {
					if (!$("#overtimeStartDate").val()) {
						alert("Please put Start Date.");
						return true;
					}
					
					if (!$("#overtimeEndDate").val()) {
						alert("Please put End Date.");
						return true;
					}
					
					if (!$("#overtimeMaximumMinute").val() || $("#overtimeMaximumMinute").val() < 10) {
						alert("Please put Maximum Going out Minute. (Over 10minutes.)");
						return true;
					}
					
					var overtimeExceptionStartTimes = [];
					var overtimeExceptionEndTimes = [];
					$("[name=overtimeExceptionStartHour]").each(function(idx, obj) {
						if ($(obj).val() && $(obj).val() >= 0) {
							overtimeExceptionStartTimes.push($(obj).val() + ":" + $("[name=overtimeExceptionStartMinute]").eq(idx).val());
						}
					});
					$("[name=overtimeExceptionEndHour]").each(function(idx, obj) {
						if ($(obj).val() && $(obj).val() >= 0) {
							overtimeExceptionEndTimes.push($(obj).val() + ":" + $("[name=overtimeExceptionEndMinute]").eq(idx).val());
						}
					});
					if (overtimeExceptionStartTimes.length != overtimeExceptionEndTimes.length) {
						alert("Exception Search Times are not pair.");
						return true;
					}
					
				} else if (searchSection == "INCOMPLETE") {
					if (!$("#incompleteStartDate").val()) {
						alert("Please put Start Date.");
						return true;
					}
					
					if (!$("#incompleteEndDate").val()) {
						alert("Please put End Date.");
						return true;
					}
				} else if (searchSection == "OUTING") {
				} else if (searchSection == "RECORD") {
					if (!$("#studentRecordStartDate").val()) {
						alert("Please put Start Date.");
						return true;
					}
					if (!$("#studentRecordEndDate").val()) {
						alert("Please put End Date.");
						return true;
					}
					if (!$("#searchValue").val()) {
						alert("Please put a Student's Name or ID card or ID.");
						return true;
					}
				}
			}

			function getParams(type) {
				var paramOffset = $("#offset option:selected").text();
				var paramEntranceSeq = $("#entranceSeq").val() ? $("#entranceSeq").val() : 0;
				var paramSearchSection = $("[name='searchSection']:checked").val();
				var paramSearchType = $("#searchType").val();
				var paramSearchValue = $.trim($("#searchValue").val());
				var paramRoom;
				
				var paramSearchDate, paramStartDate, paramEndDate;
				var paramLimitedHour, paramLimitedMinute, paramMaximumMinute; 
				var paramOvertimeExceptionStartTimes = [];
				var paramOvertimeExceptionEndTimes = [];
				if (paramSearchSection == "CURFEW") {
					paramSearchDate = $("#curfewSearchDate").val();
					paramLimitedHour = $("#curfewLimitedHour").val();
					paramLimitedMinute = $("#curfewLimitedMinute").val();
					paramMaximumMinute = $("#curfewMaximumMinute").val();
				} else if (paramSearchSection == "ORVERTIME") {
					paramStartDate = $("#overtimeStartDate").val();
					paramEndDate = $("#overtimeEndDate").val();
					paramMaximumMinute = $("#overtimeMaximumMinute").val();
					
					$("[name=overtimeExceptionStartHour]").each(function(idx, obj) {
						if ($(obj).val() && $(obj).val() >= 0) {
							paramOvertimeExceptionStartTimes.push($(obj).val() + ":" + $("[name=overtimeExceptionStartMinute]").eq(idx).val());
						}
					});
					$("[name=overtimeExceptionEndHour]").each(function(idx, obj) {
						if ($(obj).val() && $(obj).val() >= 0) {
							paramOvertimeExceptionEndTimes.push($(obj).val() + ":" + $("[name=overtimeExceptionEndMinute]").eq(idx).val());
						}
					});
					
				} else if (paramSearchSection == "INCOMPLETE") {
					paramStartDate = $("#incompleteStartDate").val();
					paramEndDate = $("#incompleteEndDate").val();
				} else if (paramSearchSection == "OUTING") {
					paramRoom = $("#outingRoom").val();
				} else if (paramSearchSection == "RECORD") {
					paramStartDate = $("#studentRecordStartDate").val();
					paramEndDate = $("#studentRecordEndDate").val();
				}
				
       			var params = {
       					selectedPage : paramSelectedPage,
       					offset : paramOffset,
       					entranceSeq : paramEntranceSeq,
       					searchDate : paramSearchDate,
       					startDate : paramStartDate,
       					endDate : paramEndDate,
       					limitedHour : paramLimitedHour,
       					limitedMinute : paramLimitedMinute,
       					maximumMinute : paramMaximumMinute,
       					overtimeExceptionStartTimes : paramOvertimeExceptionStartTimes,
       					overtimeExceptionEndTimes : paramOvertimeExceptionEndTimes,
       					searchSection : paramSearchSection,
       					searchType : paramSearchType,
       					searchValue : encodeURI(paramSearchValue),
       					searchRoom : paramRoom,
       					isExcelDownload : type == "excel"
       			};
       			
       			return $.param(params);
			}
            
            function getListSuccessFnc(response) {
    			$("#listTable tbody").empty();
        		if (response.head.status == 200) {
        			var paramOffset = $("#offset option:selected").text();
        			var $data = response.body.data;
        			totalCount = response.body.totalCount;
        			
        			$("#totalResult").text("Result : " + totalCount);
        			console.log("totalCount : ", totalCount, "data : ", $data);
        			
        			var html = "";
        			var no = totalCount - ((paramSelectedPage -1) * $("#offset option:selected").text());
        			$.each($data, function(index, item) {
	        			//console.log("index : ", index, ", item : ", item);
        				html = "";
        				html += "<tr>"; 
        				//html += "<tr onClick=\"openDetail('" + item.branchSeq + "', '" + item.consultSeq + "');\" style=\"cursor:pointer\">"; 
        				html += "<td class=\"text-center\">" + (no--) + "</td>"; 
        				html += "<td class=\"text-center\">" + item.term + "</td>"; 
        				html += "<td class=\"text-center\">" + item.level + "</td>"; 
        				html += "<td class=\"text-center\">" + item.room + "</td>"; 
        				html += "<td class=\"text-center\">" + item.studentName + " (" + item.nationality + ")" + "</td>"; 
        				html += "<td class=\"text-center\">" + item.birthday + "</td>"; 
        				html += "<td class=\"text-center\">" + item.outDate + addWeekendsCss(getWeek(item.outDate)) + "</td>"; 
        				html += "<td class=\"text-center\">" + item.inDate + addWeekendsCss(getWeek(item.inDate)) + "</td>"; 
        				html += "<td class=\"text-center\">" + item.overtime + "</td>";
        				if (item.consultSeq > 0) {
	        				//html += "<td class=\"text-center\">Consulted</td>"; 
        				} else {
	        				//html += "<td class=\"text-center\">Yet</td>"; 
        				}
        				html += "</tr>"; 
	        			$("#listTable tbody").append(html);
        				//console.log(html);
        			});
        			
        			if (totalCount < 1) {
        				resultIsNone();
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

            function getWeek(date) {
           		var week = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
           		var dayOfWeek = week[new Date(date).getDay()];
           		return dayOfWeek ? dayOfWeek : "";
            }

            function addWeekendsCss(weekend) {
           		if (weekend == "") return "";
           		if (weekend == "Sun") {
           			return "(<span style=\"color:red\">" + weekend + "</span>)";
           		} else if (weekend == "Sat") {
           			return "(<span style=\"color:blue\">" + weekend + "</span>)";
           		}
           		return "(" + weekend + ")";
            }

            function resultIsNone() {
				var html = "<tr>"; 
				html += "<td colspan=\"9\" class=\"text-center\">";
				html += "None."; 
				html += "</td>"; 
				html += "</tr>";
				
       			$("#listTable tbody").empty();
   				$("#listTable tbody").append(html);
            }
            
            function openDetail(branchSeq, studentId) {
       			window.location.href = "studentDetail.jsp?branchSeq="+ branchSeq +"&studentId=" + studentId;
            }

            function gridSearchCampuses() {
           		var branchSeq = $("input:radio[name='branch']:checked").val();
           		if (!branchSeq) {
					return false;		
				}

           		var url = "<%=SERVER_URL%>/conditions/" + branchSeq + "/entrances/campuses";
               	$.ajax({
               		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
               		url : url,
               		type : "GET",
               		dataType : "json",
               		contentType : "application/json; charset=UTF-8",
   					success : function(data, textStatus, jqXHR) {
                   		if (data.head.status == 200) {
                   			gridCookieData(JSON.stringify(data.body.data), "radio", "campus", $("#searchCampusesDiv"));

							$("input:radio[name='campus']").change(function() {
								wrapWindowByMask();
								
								$("#searchEntranceDiv").empty();
								getSearchEntrances();
								
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
            
            function getSearchEntrances() {
           		var branchSeq = $("input:radio[name='branch']:checked").val();
           		var campusSeq = $("input:radio[name='campus']:checked").val();
           		
            	var url = "<%=SERVER_URL%>/conditions/" + branchSeq + "/campuses/" + campusSeq + "/entrances";
               	$.ajax({
               		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
               		url : url,
               		type : "GET",
               		dataType : "json",
               		contentType : "application/json; charset=UTF-8",
   					success : function(data, textStatus, jqXHR) {
   	            		if (data.head.status == 200) {
   	            			gridSearchEntrances(data.body.data);
   		        		}
                   	},
               		error : function(jqXHR, textStatus, errorThrown) {
               			console.log(jqXHR, textStatus, errorThrown);
   						closeWindowByMask();
   					}
               	});
            }

            function gridSearchEntrances(response) {
       			var $data = response;
       			//console.log($data);
       			
       			var html = "";
       			html += "<div class=\"col-sm-5\" style=\"margin-left: 10px;\">";
       			html += "<select class=\"form-control input-sm\" name=\"entranceSeq\" id=\"entranceSeq\">";
       			html += "<option value=\"\">All</option>";
       			$.each($data, function(index, item) {
           			html += "<option value=\"" + item.seq + "\">" + item.name + "</option>";
       			});
       			html += "</select>";
       			html += "</div>";
       			html += "";
       			$("#searchEntranceDiv").append(html);
        	}

            function toggleSearchCondition() {
           		resultIsNone();
           		if ($("[name='searchSection']:checked").val() == "CURFEW") {
            		$("#curfewConditionDiv").show();
            		$("#overtimeConditionDiv").hide();
            		$("#incompleteConditionDiv").hide();
            		$("#outingConditionDiv").hide();
            		$("#studentRecordConditionDiv").hide();
				} else if ($("[name='searchSection']:checked").val() == "ORVERTIME") {
            		$("#overtimeConditionDiv").show();
            		$("#curfewConditionDiv").hide();
            		$("#incompleteConditionDiv").hide();
            		$("#outingConditionDiv").hide();
            		$("#studentRecordConditionDiv").hide();
				} else if ($("[name='searchSection']:checked").val() == "INCOMPLETE") {
            		$("#incompleteConditionDiv").show();
            		$("#overtimeConditionDiv").hide();
            		$("#curfewConditionDiv").hide();
            		$("#outingConditionDiv").hide();
            		$("#studentRecordConditionDiv").hide();
				} else if ($("[name='searchSection']:checked").val() == "OUTING") {
            		$("#outingConditionDiv").show();
            		$("#incompleteConditionDiv").hide();
            		$("#overtimeConditionDiv").hide();
            		$("#curfewConditionDiv").hide();
            		$("#studentRecordConditionDiv").hide();
				} else if ($("[name='searchSection']:checked").val() == "RECORD") {
            		$("#outingConditionDiv").hide();
            		$("#incompleteConditionDiv").hide();
            		$("#overtimeConditionDiv").hide();
            		$("#curfewConditionDiv").hide();
            		$("#studentRecordConditionDiv").show();
				}
            }
            
            setStaffNameOnHeader();
        </script>
    

    </body>
</html>
