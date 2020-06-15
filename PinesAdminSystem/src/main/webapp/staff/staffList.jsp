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
                                <button type="button" class="btn btn-default m-b-5" id="searchButton">Search</button>
                                <button type="button" class="btn btn-default m-b-5" id="newButton">New</button>
                            </div>
			                
                            <div class="panel-body">
                                <form class="form-horizontal" role="form" onsubmit="return false;">

                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-md-2 control-label">Working Area</label>
                                        <div class="col-md-10" id="searchBranchesDiv">
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
                                                    <th class="text-center" width="10%">Working Area</th>
                                                    <th class="text-center" width="5%">Nationality</th>
                                                    <th class="text-center" width="10%">Staff Id</th>
                                                    <th class="text-center" width="20%">Name</th>
                                                    <th class="text-center" width="10%">Contact Number</th>
                                                    <th class="text-center" width="10%">Status</th>
                                                    <th class="text-center" width="10%">Date Updated</th>
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

        <!-- Modal-Effect -->
        <script src="/assets/modal-effect/js/classie.js"></script>
        <script src="/assets/modal-effect/js/modalEffects.js"></script>
        
        <script src="/js/jquery.session.js"></script>
        <script src="/js/jquery.cookie.js"></script>
        <script src="/custom/pia-ajaxs.js"></script>
        <script src="/custom/pia-tools.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function() {
				wrapWindowByMask();
                initPaging();

	        		gridSearchBranches();
	        		gridSearchNationality();
                
                $("#searchButton").on("click", search);
                $("#newButton").on("click", openNew);
	    			
                $("#offset").change(getListData);
                
                setEnterKeyEvent($("#searchName"), search);
            });

            function gridSearchNationality() {
                	var url = "<%=SERVER_URL%>/conditions/nationalities";
                	$.ajax({
                		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
                		url : url,
                		type : "GET",
                		dataType : "json",
                		contentType : "application/json; charset=UTF-8",
    					success : function(data, textStatus, jqXHR) {
                    		if (data.head.status == 200) {
                        		gridCookieData(JSON.stringify(data.body.data), "checkbox", "nationality", $("#searchNationalityDiv"));
                    		}
                    		getListData();
                    	},
                		error : function(jqXHR, textStatus, errorThrown) {
                			console.log(jqXHR, textStatus, errorThrown);
    						closeWindowByMask();
    					} 
                	});
            }
            
            function paginSearch() {
            		wrapWindowByMask();
            		
            		getListData();
            }
            
            function search() {
            		wrapWindowByMask();
            		
            		paramSelectedPage = 1;
            		getListData();
            }

			var totalCount = 0;
			var paramSelectedPage = 1;
            function getListData() {
        			//console.log(getParams());
	            	var branchSeq = $("input:radio[name='branch']:checked").val();
	        		var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/staffs?" + getParams();
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
	        			var $data = response.body.data;
	        			totalCount = response.body.totalCount;
	        			
	        			$("#totalResult").text("Result : " + totalCount);
	        			no = totalCount;
	        			//console.log("totalCount : ", totalCount, "data : ", $data);
	
	        			var html = "";
	        			var no = totalCount - ((paramSelectedPage -1) * $("#offset option:selected").text());
	        			$.each($data, function(index, item) {
		        			//console.log("index : ", index, ", item : ", item);
	        				html = "";
	        				html += "<tr onClick=\"openDetail('" + item.branchSeq + "', '" + item.staffId + "');\" style=\"cursor:pointer\">"; 
	        				html += "<td class=\"text-center\">" + (no--) + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.branch + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.nationality + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.staffId + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.realName + " (" + item.nickName + ")</td>"; 
	        				html += "<td class=\"text-center\">" + item.contact + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.status + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.updateDate + "</td>"; 
	        				html += "</tr>"; 
		        			$("#listTable tbody").append(html);
	        			});
	        			
	        			if ($data.length < 1) {
	        				html = "<tr><td class=\"text-center\" colspan=\"6\">None.</td></tr>";	
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
				var paramNationality = getCheckedValues("nationality"); // [1, 2, 3]
				var paramName = $("#searchName").val();
				
        			var params = {
        					selectedPage : paramSelectedPage,
        					offset : paramOffset,
        					nationalitySeqs : paramNationality,
        					name : encodeURI(paramName)
        			};
        			
        			return $.param(params);
			}
			
            function openDetail(branchSeq, staffId) {
	        		window.location.href = "staffDetail.jsp?branchSeq="+ branchSeq + "&staffId=" + staffId;
            }

            function openNew() {
	        		window.location.href = "staffNew.jsp";
            }
            
            setStaffNameOnHeader();
        </script>
    

    </body>
</html>
