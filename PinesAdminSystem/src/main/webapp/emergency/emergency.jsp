<!DOCTYPE html>
<html lang="en">
<%@ include file="/include/head.jsp"%>
<body>

	<!-- Aside Start-->
	<aside class="left-panel">

		<!-- brand -->
		<%@ include file="/include/brand.jsp"%>
		<!-- / brand -->

		<!-- Navbar Start -->
		<nav class="navigation">
			<ul class="list-unstyled">
				<li class="has-submenu active"><a href="#"><i
						class="zmdi zmdi-view-dashboard"></i> <span class="nav-label">Campus</span></a>
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
						<li class="active"><a href="/emergency/emergency.jsp">Emergency Contact</a></li>
						<li><a href="/entrance/entranceRecordList.jsp">Entrance Records</a></li>
					</ul></li>
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
				<li class="has-submenu"><a href="/student/studentList.jsp"><i
						class="zmdi zmdi-accounts"></i> <span class="nav-label">Student</span></a>
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
		<%@ include file="/include/header.jsp"%>
		<!-- Header Ends -->



		<!-- Page Content Start -->
		<!-- ================== -->

		<div class="wraper container-fluid">

			<div class="panel">
				<div class="panel-title col-md-12">
					<h3 class="title col-md-6">Emergency Contact</h3>
				</div>

				<div class="panel-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<form class="cmxform form-horizontal tasi-form" role="form" id="formInput" name="formInput" novalidate="novalidate">
								<table class="table table-striped">
									<thead>
										<tr>
											<th class="text-center" width="30%">Staff</th>
											<th class="text-center" width="20%">Contact</th>
											<th class="text-center" width="15%">Order</th>
											<th class="text-center" width="15%">Shown</th>
											<th width="20%"></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<select class="form-control input-sm" id="staff" name="staff" required>
												</select>
												<input type="hidden" id="emergencySeq">
											</td>
											<td>
												<input type="text" class="form-control input-sm" value="" placeholder="Contact" id="contact" name="contact" required maxlength="20">
											</td>
											<td>
												<input type="text" class="form-control input-sm" value="" placeholder="Order Number" id="orderNo" name="orderNo" required maxlength="3" onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
											</td>
											<td class="text-center">
												<div class="checkbox-inline">
													<label class="cr-styled">
														<input type="checkbox" id="isShown" name="isShown" value="false"> 
														<i class="fa"></i> Shown
													</label>
												</div>
											</td>
											<td>
												<button type="button" class="btn btn-primary" id="saveButton">Save</button>
												<button type="button" class="btn btn-primary" id="resetButton">Reset</button>
											</td>
										</tr>
									</tbody>
								</table>
							</form>
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
								<div class="col-sm-3 pull-right">
								</div>
							</div>
						</div>
						<!-- form-group -->
					</div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<table class="table table-striped" id="listTable">
								<thead>
									<tr>
										<th class="text-center" width="30%">Staff</th>
										<th class="text-center" width="20%">Contact</th>
										<th class="text-center" width="15%">Order</th>
										<th class="text-center" width="15%">Shown</th>
										<th width="20%"></th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- end: page -->

			</div>
			<!-- end Panel -->


		</div>
		<!-- Page Content Ends -->
		<!-- ================== -->

		<!-- Footer Start -->
		<%@ include file="/include/footer.jsp"%>
		<!-- Footer Ends -->



	</section>
	<div id="api_mask"></div>
	<!-- Main Content Ends -->

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/js/jquery.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/pace.min.js"></script>
	<script src="/js/modernizr.min.js"></script>
	<script src="/js/wow.min.js"></script>
	<script src="/js/jquery.nicescroll.js" type="text/javascript"></script>


	<script src="/js/jquery.app.js"></script>
	<script src="/js/jquery.twbsPagination.js"></script>

	<!-- sweet alerts -->
	<script src="/assets/sweet-alert/sweet-alert.min.js"></script>
	<script src="/assets/sweet-alert/sweet-alert.init.js"></script>

	<!-- Examinationples -->
	<script src="/assets/magnific-popup/magnific-popup.js"></script>
	<script src="/assets/jquery-datatables-editable/jquery.dataTables.js"></script>
	<script src="/assets/datatables/dataTables.bootstrap.js"></script>

	<script src="/assets/jquery.validate/jquery.validate.js"></script>

	<script src="/js/jquery.session.js"></script>
	<script src="/js/jquery.cookie.js"></script>
	<script src="/custom/pia-ajaxs.js"></script>
	<script src="/custom/pia-tools.js"></script>
	<script type="text/javascript">
            jQuery(document).ready(function() {
            		initPlugins();

                $("#saveButton").on("click", isNewOrEdit);
                $("#resetButton").on("click", resetForm);
				$("#contact").keyup(function(e) {
					var reg = /[^0-9]\-/gi;
					var v = $(this).val();
					if (reg.test(v)) {
						$(this).val(v.replace(reg, ''));
						$(this).focus();
					}
				});
                
                wrapWindowByMask();
                getStaffList();
                search();
            });
            
			var totalCount = 0;
            var FORM_INPUT;
            function initPlugins() {
            		FORM_INPUT = $("#formInput").validate();
            }
            
            function getStaffList() {
				var url = "<%=SERVER_URL%>/branches/" + $.cookie("branchSeq") + "/contacts/emergency/staffs"
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		type : "GET",
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
	            		success : getStaffListSuccessFnc,
	            		error : function(jqXHR, textStatus, errorThrown) {
	            			console.log(jqXHR, textStatus, errorThrown);
	            		}
	            	});
            }

            function getStaffListSuccessFnc(response) {
	    			$("#staff").empty();
	        		if (response.head.status == 200) {
	        			var $data = response.body.data;
	        			//console.log("totalCount : ", totalCount, "data : ", $data);
	        			
	        			var html = "";
	        			$("#staff").append("<option value=\"\">select</option>");
	        			$.each($data, function(index, item) {
	        				html = "<option value=\"" + item.staffId + "\" contact=\"" + item.contact + "\">" + item.name + " (" + item.nationality+ ")</option>"; 
		        			$("#staff").append(html);
	        			});
	        			
	        			$("#staff").change(function() {
	        				$("#contact").val($("#staff option:selected").attr("contact"));
	        				FORM_INPUT.element("#staff");
	        				FORM_INPUT.element("#contact");
	        			});
	        		} else if (response.head.status == 401) {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]", function() {
						window.location.replace("/login.jsp");
					});
				} else {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]");
				}
            }
            
            function search() {
				var url = CONTACT_BASE_DOMAIN();
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
	        			console.log("totalCount : ", totalCount, "data : ", $data);
	        			
	        			var html = "";
	        			$.each($data, function(index, item) {
		        			//console.log("index : ", index, ", item : ", item);
	        				html = "";
	        				html += "<tr onClick=\"setInput(this);\" style=\"cursor:pointer\" emergencySeq=\"" + item.contactSeq + "\">"; 
	        				html += "<td class=\"text-center\" style=\"vertical-align: middle;\">" + item.title + " "+ item.name + " (" + item.nationality + ")</td>"; 
	        				html += "<td class=\"text-center\" style=\"vertical-align: middle;\">" + item.contact + "</td>"; 
	        				html += "<td class=\"text-center\" style=\"vertical-align: middle;\">" + item.orderNo + "</td>";
	        				if (getBoolean(item.isShown)) {
		        				html += "<td class=\"text-center\" style=\"vertical-align: middle;\">" + "Shown" + "</td>"; 
						} else {
		        				html += "<td class=\"text-center\" style=\"vertical-align: middle;\">" + "Hidden" + "</td>"; 
						}
	        				html += "<td class=\"text-center\"><button type=\"button\" class=\"btn btn-primary\" onclick=\"deleteItem(" + item.contactSeq + ")\">Delete</button></td>"; 
	        				html += "<input type=\"hidden\" value=\"" + item.staffId + "\">"; 
	        				html += "</tr>"; 
		        			$("#listTable tbody").append(html);
	        				//console.log(html);
	        			});
	        		} else if (response.head.status == 401) {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]", function() {
						window.location.replace("/login.jsp");
					});
				} else {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]");
				}
	        		
	        		closeWindowByMask();
            }
            
            function isNewOrEdit() {
    	       		if ($("#formInput #emergencySeq").val() > 0) {
    	       			saveEidt();
				} else {
					saveNew();
				}
            	
            }
            
            function saveNew() {
            		var firstCheck = $("#formInput").valid();
    	       		if (!firstCheck) {
    					return false;	
    				}

   				var url = CONTACT_BASE_DOMAIN();
    	            	$.ajax({
    	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
    	            		url : url,
    	            		type : "POST",
    	            		data : getJsonData(),
    	            		dataType : "json",
    	            		contentType : "application/json; charset=UTF-8",
    					beforeSend : function (jqXHR, settings) {
    						wrapWindowByMask();
    					},
    	            		success : function(data, textStatus, jqXHR) {
    	   		        		if (data.head.status == 200) {
	   						openSwal(data.head.message, "", function () {
		   	   	            		resetForm();
		   	   	            		search();
	   						});
    	   		        		} else if (data.head.status == 401) {
  							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
  								window.location.replace("/login.jsp");
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
					staffId : $("#formInput #staff").val(),
					contact : $("#formInput #contact").val(),
					orderNo : $("#formInput #orderNo").val(),
					isShown : $("#formInput #isShown").is(":checked")
				});
			}
			
            function saveEidt() {
            		var firstCheck = $("#formInput").valid();
    	       		if (!firstCheck) {
    					return false;	
    				}

   				var url = CONTACT_BASE_DOMAIN() + "/" + $("#formInput #emergencySeq").val();
    	            	$.ajax({
    	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
    	            		url : url,
    	            		type : "PUT",
    	            		data : getEditJsonData(),
    	            		dataType : "json",
    	            		contentType : "application/json; charset=UTF-8",
    					beforeSend : function (jqXHR, settings) {
    						wrapWindowByMask();
    					},
    	            		success : function(data, textStatus, jqXHR) {
    	   		        		if (data.head.status == 200) {
	   						openSwal(data.head.message, "", function () {
		   	   	            		resetForm();
		   	   	            		search();
	   						});
    	   		        		} else if (data.head.status == 401) {
  							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
  								window.location.replace("/login.jsp");
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
            
			function getEditJsonData() {
				return JSON.stringify({
					contact : $("#formInput #contact").val(),
					orderNo : $("#formInput #orderNo").val(),
					isShown : $("#formInput #isShown").is(":checked")
				});
			}
            
            function resetForm() {
            		FORM_INPUT.resetForm();
            		$("#formInput").clearForm();
            		$("#staff").val("");
            		$("#emergencySeq").val("0");
            }
            
            function confirmDeleteItem(contactSeq) {
            		deleteItem(contactSeq);
            }
            
            function deleteItem(contactSeq) {
                swal({   
                    title: "Are you sure?",   
                    text: "You will not be able to recover this imaginary file!",   
                    type: "warning",   
                    showCancelButton: true,   
                    confirmButtonColor: "#DD6B55",   
                    confirmButtonText: "Yes, delete it!",   
                    closeOnConfirm: false 
                }, function(){
	                	var url = CONTACT_BASE_DOMAIN() + "/" + contactSeq;
		            	$.ajax({
		            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
		            		url : url,
		            		type : "DELETE",
		            		dataType : "json",
		            		contentType : "application/json; charset=UTF-8",
						beforeSend : function (jqXHR, settings) {
							wrapWindowByMask();
						},
		            		success : deleteSuccessFnc,
		            		error : function(jqXHR, textStatus, errorThrown) {
		            			console.log(jqXHR, textStatus, errorThrown);
		            			closeWindowByMask();
		            		}
		            	});
                });
            }
            
            function deleteSuccessFnc (response) {
	        		closeWindowByMask();
				if (response.head.status == 200) {
			        swal({   
			            title: "Deleted!",   
			            text: "Your imaginary file has been deleted.",   
			            type: "success",   
			        }, function() {
			        		search();
			        });
				} else {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]");
				}
			}

            function setInput(item) {
            		resetForm();
            	
            		var $tds = $(item).children("td"); 
            		$("#formInput #emergencySeq").val($(item).attr("emergencySeq"));
            		$("#formInput #staff").val($(item).children("input").val());
            		$("#formInput #contact").val($tds.eq(1).text());
            		$("#formInput #orderNo").val($tds.eq(2).text());
            		if ($tds.eq(3).text() == "Shown") {
	            		$("#formInput #isShown").prop("checked", true);
				} else {
	            		$("#formInput #isShown").prop("checked", false);
				}
            }
            
            function CONTACT_BASE_DOMAIN() {
	        		return "<%=SERVER_URL%>/branches/" + $.cookie("branchSeq") + "/emergency/contacts";
			}
            
            setStaffNameOnHeader();
	</script>


</body>
</html>
