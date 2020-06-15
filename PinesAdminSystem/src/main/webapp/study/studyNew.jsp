<!DOCTYPE html>
<html lang="en">
	<%@ include file="/include/head.jsp" %>
	<style>
		.table > tbody > tr > td {
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
	                           <button type="button" class="btn btn-default m-b-5" id="historyBackButton">Back</button>
	                           <button type="button" class="btn btn-default m-b-5" id="saveButton">Save</button>
                            </div>
							<div class="panel-body form-horizontal">
								<div class="row">
									<div class="form-group">
                                        <label class="col-md-2 control-label">Branch</label>
                                        <div class="col-md-10" id="branchesDiv">
                                        </div>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
                                        <label class="col-md-2 control-label">Campus</label>
                                        <div class="col-md-10" id="campusesDiv">
                                        </div>
                                        <input type="hidden" name="campusSeq" id="campusSeq"/>
									</div>
								</div>
								<div class="row">
									<div class="form-group">
                                        <label class="col-md-2 control-label">Term of Schedule</label>
                                        <div class="col-md-10" id="termsDiv">
                                        </div>
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
	        		
	        		$("#saveButton").on("click", newDetail);

	    			gridBranches("radio", "branch", $("#branchesDiv"));
		    		$("[name='branch']").change(function() {
		    			$("#campusesDiv").empty();
		    			getCampuses();
		    		});
		    		
		    		//$("[name='branch']").eq(0).attr("checked", true);
            });

            function initPlugins() {
            }

            function getCampuses() {
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
    					beforeSend : function (jqXHR, settings) {
    						wrapWindowByMask();
    					},
    					success : function(data, textStatus, jqXHR) {
                    		if (data.head.status == 200) {
                    			gridCookieData(JSON.stringify(data.body.data), "radio", "campus", $("#campusesDiv"));
        	        			} else if (data.head.status == 401) {
        						openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
        							window.location.replace("/login.jsp");
        						});
                    		}
                    		
                    		getTerms();
                    	},
                		error : function(jqXHR, textStatus, errorThrown) {
                			console.log(jqXHR, textStatus, errorThrown);
    						closeWindowByMask();
    					}
                	});
            }

            function getTerms() {
            		var branchSeq = $("input:radio[name='branch']:checked").val();
            		if (!branchSeq) {
						return false;
				}
            		
	            	var url = "<%=SERVER_URL%>/conditions/" + branchSeq + "/terms/details";
                	$.ajax({
                		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
                		url : url,
                		type : "GET",
                		dataType : "json",
                		contentType : "application/json; charset=UTF-8",
    					success : function(data, textStatus, jqXHR) {
    						if (data.head.status == 200) {
    							gridTerms(data.body.data);
			    	        		closeWindowByMask();
    						} else if (data.head.status == 204) {
			    	        		closeWindowByMask();
    		        			} else if (data.head.status == 401) {
    							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
    								window.location.replace("/login.jsp");
    							});
                    		} else {
                    			openSwal(data.head.message, "[Status Code : " + data.head.status + "]", closeWindowByMask);
                    		}
    					},
                		error : function(jqXHR, textStatus, errorThrown) {
                			console.log(jqXHR, textStatus, errorThrown);
                			closeWindowByMask();
                		},
    					complete : function(jqXHR, textStatus) {
    						closeWindowByMask();
    					}
                	});
            }
            
            function gridTerms(response) {
	    			var $data = response;
	    			//console.log($data);
	    			
	    			var html = "";
	    			html += "<div class=\"col-sm-5\">";
	    			html += "<select class=\"form-control input-sm\" name=\"termDetailSeq\" id=\"termDetailSeq\" required>";
	    			$.each($data, function(index, item) {
	        			html += "<option value=\"" + item.seq + "\">" + item.name + "</option>";
	    			});
	    			html += "</select>";
	    			html += "</div>";
	    			html += "";
	    			
	    			$("#termsDiv").empty();
	    			$("#termsDiv").append(html);
	        	}
        
            function newDetail() {
            		var branchSeq = $("input:radio[name='branch']:checked").val();
            		var campusSeq = $("input:radio[name='campus']:checked").val();
            		var termDetailSeq = $("#termDetailSeq").val();
            		if (!branchSeq || !campusSeq || !termDetailSeq) {
					return false;
				}
            		
	        		var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/campuses/" + campusSeq + "/terms/" + termDetailSeq + "/studies";
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		type : "POST",
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
	            		success : function(data, textStatus, jqXHR) {
	   		        		if (data.head.status == 200) {
							openSwal(data.head.message, "", function() {
								closeWindowByMask();
								var studySeq = data.body.data.studySeq;
								window.location.replace("studyDetail.jsp?branchSeq="+ branchSeq +"&campusSeq=" + campusSeq +"&termDetailSeq=" + termDetailSeq + "&studySeq=" + studySeq + "&backPage=list");
							});
	   		        		} else if (data.head.status == 401) {
   							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
   								window.location.replace("/login.jsp");
   							});
						} else {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", closeWindowByMask);
						}
	            		},
	            		error : function(jqXHR, textStatus, errorThrown) {
	            			console.log(jqXHR, textStatus, errorThrown);
	            		}
	            	});            	
            }

            setStaffNameOnHeader();
        </script>
    </body>
</html>
