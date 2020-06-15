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
            <%@ include file="/include/menu.jsp" %>

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
                    <h3 class="title">In/Out</h3> 
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
                                                    <th class="text-center" width="15%">No</th>
                                                    <th class="text-center" width="15%">Seq</th>
                                                    <th class="text-center" width="15%">St. ID</th>
                                                    <th class="text-center" width="20%">St. Name</th>
                                                    <th class="text-center" width="20%">Date/Time</th>
                                                    <th class="text-center" width="15%">Type</th>
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
            	console.log('ready');
            	//wrapWindowByMask();
            	console.log('ready1');
                initPaging();
                console.log('ready2');
                
                $("#searchButton").on("click", search);
                //$("#newButton").on("click", openNew);
	    			console.log('ready3');
                $("#offset").change(getListData);
                console.log('ready4');
                setEnterKeyEvent($("#searchName"), search);
            });
           
            function paginSearch() {
            	console.log('paginSearch');
            		wrapWindowByMask();
            		
            		getListData();
            }
            
            function search() {
            	console.log('search');
            		wrapWindowByMask();
            		
            		paramSelectedPage = 1;
            		getListData();
            }

			var totalCount = 0;
			var paramSelectedPage = 1;
            function getListData() {
            	console.log('getListData');
        			console.log(getParams());
	        		var url = "<%=SERVER_URL%>/pos/inOutList?" + getParams();
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		type : "GET",
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
	            		success : getListSuccessFnc,
	            		error : function(jqXHR, textStatus, errorThrown) {
	            			console.log("error");
	            			console.log(jqXHR, textStatus, errorThrown);
	            			closeWindowByMask();
					}
	            	});
            }
            
            function getListSuccessFnc(response) {
            	
            	console.log("getListSuccessFnc");
            	
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
	        				html = "<tr>";
	        				//html += "<tr onClick=\"openDetail('" + item.branchSeq + "', '" + item.staffId + "');\" style=\"cursor:pointer\">";
	        				html += "<td class=\"text-center\">" + (no--) + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.seq + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.user_no + "</td>";
	        				html += "<td class=\"text-center\">" + item.name + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.dt + "</td>"; 
	        				html += "<td class=\"text-center\">" + item.state + "</td>"; 
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
				var paramName = $("#searchName").val();
				
        			var params = {
        					selectedPage : paramSelectedPage,
        					name : encodeURI(paramName)
        			};
        			
        			return $.param(params);
			}
			
            //function openDetail(branchSeq, staffId) {
	        		//window.location.href = "staffDetail.jsp?branchSeq="+ branchSeq + "&staffId=" + staffId;
            //}

            //function openNew() {
	        		//window.location.href = "inOutNew.jsp";
            //}
            
            setStaffNameOnHeader();
             
        </script>
    

    </body>
</html>
