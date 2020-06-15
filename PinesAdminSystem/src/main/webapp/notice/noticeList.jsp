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
                            <li><a href="/request/requestList.jsp">Request</a></li>
                            <li class="active"><a href="/notice/noticeList.jsp">Notice</a></li>
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
                    <h3 class="title">Notice</h3> 
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
                                        <label class="col-md-2 control-label">For All Students</label>
                                        <div class="col-md-10" id="searchforAllStudentDiv">
                                            <div class="radio-inline">
                                                <label class="cr-styled">
                                                    <input type="checkbox" id="isForAll" value="true" required aria-required="true"> 
                                                    <i class="fa"></i>
                                                </label>
                                            </div>
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
	                                                                
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Language</label>
                                        <div class="col-md-10" id="searchLanguageDiv">
                                        </div>
                                    </div> <!-- form-group -->
                                </div>

                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Type</label>
                                        <div class="col-md-10">
                                            <div class="checkbox-inline">
                                                <label class="cr-styled">
                                                    <input type="checkbox" name="isPopup">
                                                    <i class="fa"></i> 
                                                    Popup Type
                                                </label>
                                            </div>
                                        </div>
                                    </div> <!-- form-group -->
                                </div>
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Writer</label>
                                        <div class="col-md-10">
	                                        <div class="col-md-5">
	                                            <input type="text" class="form-control input-sm" value="" placeholder="" id="writer">
	                                        </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                		<div class="form-group">
                                        <label class="col-md-2 control-label">Title/Content</label>
                                        <div class="col-md-10">
	                                        <div class="col-md-5">
	                                            <input type="text" class="form-control input-sm" value="" placeholder="" id="titleContent">
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
                                                    <th class="text-center" width="10%">Branch</th>
                                                    <th class="text-center" width="10%">Language</th>
                                                    <th class="text-center" width="10%">Top Of List</th>
                                                    <th class="text-center" width="10%">Type</th>
                                                    <th class="text-center">Title</th>
                                                    <th class="text-center" width="15%">Writer</th>
                                                    <th class="text-center" width="10%">Date Requested</th>
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
                initPaging();

	        		gridSearchBranches();
	        		gridSearchLanguage();
                
                $("#searchButton").on("click", search);
                $("#newButton").on("click", openNew);
	    			
                $("#offset").change(getListData);
                
                setEnterKeyEvent($("#writer"), search);
                setEnterKeyEvent($("#titleContent"), search);
                
                search();
            });
            
            function paginSearch() {
            		SELECTED_DETAIL_SEQ = 0;
            		getListData();
            }
            
            function search() {
            		paramSelectedPage = 1;
            		SELECTED_DETAIL_SEQ = 0;
            		getListData();
            }

			var totalCount = 0;
			var paramSelectedPage = 1;
            function getListData() {
        			//console.log(getParams());
	            	var branchSeq = $("input:radio[name='branch']:checked").val();
	        		var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/notices";
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url + "?" + getParams(),
	            		type : "GET",
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
	            		success : getListSuccessFnc,
	            		error : function(jqXHR, textStatus, errorThrown) {
	            			console.log(jqXHR, textStatus, errorThrown);
						wrapWindowByMask();
					}
	            	});
            }
            
            function getListSuccessFnc(response) {
	    			$("#listTable tbody").empty();
	        		if (response.head.status == 200) {
	        			var $data = response.body.data;
	        			totalCount = response.body.totalCount;
	        			
	        			$("#totalResult").text("Result : " + totalCount);
	        			//console.log("totalCount : ", totalCount, "data : ", $data);
	
	        			var html = "";
	        			var no = totalCount - ((paramSelectedPage -1) * $("#offset option:selected").text());
	        			$.each($data, function(index, item) {
		        			//console.log("index : ", index, ", item : ", item);
	        				html = "";
	        				html += "<tr onClick=\"openDetail(" + item.noticeSeq + ");\" style=\"cursor:pointer\">"; 
	        				html += "<td class=\"text-center\">" + (no--) + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.branch + "</td>";
	        				if (item.isForAll) {
		        				html += "<td class=\"text-center\">For All(Eng)</td>"; 
						} else {
		        				html += "<td class=\"text-center\">" + item.language + "</td>"; 
						}
	        				html += "<td class=\"text-center\">" + item.topOfList + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.type + "</td>"; 
	        				html += "<td>"; 
	        				if (getBoolean(item.hasAttachment)) {
	        					html += "<i class=\"fa fa-paperclip\" style=\"margin-right:5px;\"></i>";
						}
	        				html += "<input type=\"text\" value=\"" + item.title + "\" style=\"cursor:pointer;width:90%;border:none;border:0px;margin-top:0.5px;background-color:transparent;\" readonly></td>"; 
	        				html += "<td class=\"text-center\">" + item.writer + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.registerDate + "</td>"; 
	        				html += "</tr>"; 
		        			$("#listTable tbody").append(html);
	        				//console.log(html);
	        			});
	        			
	        			gridPage(totalCount);
		        		closeWindowByMask();
	        		} else if (response.head.status == 401) {
		        		closeWindowByMask();
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]", function() {
						window.location.replace("/login.jsp");
					});
				} else {
		        		closeWindowByMask();
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]");
				}
	        	}

			function getParams() {
				var paramOffset = $("#offset option:selected").text();
				var paramIsPopup = $("input:checkbox[name='isPopup']").prop('checked');
				var paramIsForAll = $("#isForAll").prop('checked');
				var paramLangaugeSeqs = getCheckedValues("language"); // [1, 2, 3]
				var paramWriter = $("#writer").val();
				var paramTitleContent = $("#titleContent").val();
				
        			var params = {
        					selectedPage : paramSelectedPage,
        					offset : paramOffset,
        					languageSeqs : paramLangaugeSeqs,
        					writer : encodeURI(paramWriter),
        					titleContent : encodeURI(paramTitleContent),
        					isForAll : paramIsForAll,
        					isPopup : paramIsPopup
        			};
        			
        			return $.param(params);
			}
			
            function openDetail(noticeSeq) {
	            	var branchSeq = $("input:radio[name='branch']:checked").val();
	        		window.location.href = "noticeDetail.jsp?branchSeq="+ branchSeq +"&noticeSeq=" + noticeSeq;
            }

            function openNew() {
	        		window.location.href = "noticeNew.jsp";
            }
            
            setStaffNameOnHeader();
        </script>
    

    </body>
</html>
