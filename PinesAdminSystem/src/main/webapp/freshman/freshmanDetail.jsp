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
                            <li class="active"><a href="/freshman/freshmanList.jsp">Freshman's Guide</a></li>
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
                    <h3 class="title">Freshman's Guide</h3> 
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right ">
	                           <button type="button" class="btn btn-default m-b-5" id="historyBackButton">Back</button>
	                           <button type="button" class="btn btn-default m-b-5" id="detailSaveButton">Save</button>
	                           <button type="button" class="btn btn-default m-b-5" id="detailDeleteButton">Delete</button>
                            </div>
                            
                            <div class="panel-body">
							<form class="cmxform form-horizontal tasi-form" role="form" id="detailForm" novalidate="novalidate">
			                   <div class="panel-body">
			                       <div class="row">
			                       		<div class="form-group">
			                               <label class="col-md-2 control-label">Branch</label>
			                               <div class="col-md-7 control-label" id="detailBranchDiv" style="text-align:left;margin-left:10px">
			                               </div>
			                           </div> <!-- form-group -->
			                           <input type="hidden" name="branchSeq" id="branchSeq"/>
			                       </div>
			                       
			                       <div class="row">
			                           <div class="form-group">
			                       			<label class="col-md-2 control-label">Nationality </label>
			                               <div class="col-md-7 control-label" id="detailNationalityDiv" style="text-align:left;margin-left:10px">
			                               </div>
			                           		<input type="hidden" name="nationalitySeq" id="nationalitySeq"/>
			                           </div> <!-- form-group -->
			                       </div>
			                       
			                       <div class="row">
			                       		<div class="form-group">
			                               <label class="col-md-2 control-label">Title</label>
			                               <div class="col-md-10">
			                                <div class="col-md-12">
			                                    <input type="text" class="form-control input-sm" value="" placeholder="" name="title" id="title" required>
			                                </div>
			                               </div>
			                           </div>
			                       </div>
			                       
			                       <div class="row">
			                       		<div class="form-group">
			                               <label class="col-md-2 control-label">Attachement</label>
			                               <div class="col-md-10">
			                                <div class="col-md-12 icon-list" id="attachmentDiv">
			                                </div>
			                               </div>
			                               <input type="hidden" id="isDeleteAttachment" name="isDeleteAttachment" value="false"/>
			                           </div>
			                       </div>
			                       <div class="row">
			                       		<div class="form-group">
			                               <label class="col-md-2 control-label">**</label>
			                               <div class="col-md-9" style="margin-left: 10px;">
			                               File uploading's Browser Support <br>IE10+ / FIREFOX 4.0+ / CHROME 7.0+ / SAFARI 5+ / OPERA 12+
			                               </div>
			                           </div>
			                       </div>
									<div class="row">
										<div class="" style="display:none">
											<label id="content-error" class="error" for="content"></label>
										</div>
										<div class="col-sm-12">
											<div class="summernote" id="content"></div>
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
	
	        		$("#detailSaveButton").on('click', changeDetail);
	        		$("#detailDeleteButton").on("click", deleteDetail);
	        		
            		getDetailData();
            });
            
			function getDetailData() {
				var branchSeq = getUrlParameter("branchSeq");
				var guideSeq = getUrlParameter("guideSeq");
				if (!guideSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/freshman/guides/" + guideSeq;
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		type : "GET",
	            		dataType : "json",
	            		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
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
		        			
			        		$("#registerDateWriter").text($data.registerDate + " - " + $data.writer);
		        			$("#detailBranchDiv").html($data.branch);
		        			$("#detailNationalityDiv").html($data.nationality);
			        		$("#detailGroupDiv").html($data.groupName);
			        		$("#title").val($data.title);
			        		
		            		$("[name=branchSeq]").val($data.branchSeq);
		            		$("[name=nationalitySeq]").val($data.nationalitySeq);
		            		$("[name=groupSeq]").val($data.groupSeq);
		            		
			        		if(getBoolean($data.hasAttachment)) {
				        		$("#attachmentDiv").html("<i class=\"fa fa-paperclip\"></i> <a href=\"#\" style=\"cursor:pointer\" id=\"attachDownloadButton\" filePath=\"" + $data.fileDownloadUrl + "\">" + $data.downloadFilename + "</a>");
				        		$("#attachmentDiv").append("<i class=\"fa fa-trash-o\" style=\"cursor:pointer\" id=\"removeOriginalFile\"></i>");
				        		
				        		$("#attachDownloadButton").on("click", function() {
				        			fileDownload($(this).attr("filePath"), $(this).text());
				        		});
				        		
				        		$("#removeOriginalFile").on("click", function() {
				            		$("[name=isDeleteAttachment]").val(true);
					        		$("#attachmentDiv").html("<input type=\"file\" name=\"attachmentFile\" class=\"form-control input-sm\"/>");
				        		});
			        		} else {
			        			$("#attachmentDiv").html("<input type=\"file\" name=\"attachmentFile\" class=\"form-control input-sm\"/>");
			        		}
			        		
			        		$("#content").code($data.content);
					}
	        			
				} else {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]");
				}
	        	}

            function initPlugins() {
	    	        $("#detailForm").validate();
	    	        
                $("#content").summernote({
	                	onChange: function() {
			        	    	$("label[for=content]").append("");
			        	    	$("label[for=content]").css("display", "none");
			        	    	$("label[for=content]").parent().css("display", "none");
		            },
                    height: 400,                 // set editor height
                    minHeight: null,             // set minimum height of editor
                    maxHeight: null,             // set maximum height of editor
                    focus: true                 // set focus to editable area after initializing summernote
                });
            }
            
            function changeDetail() {
				var branchSeq = getUrlParameter("branchSeq");
				var guideSeq = getUrlParameter("guideSeq");
				if (!guideSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}
				
	        		var firstCheck = $("#detailForm").valid();
	        		var secodCheck = freshmanValidate();
	       		if (!firstCheck || !secodCheck) {
					return false;	
				}

				if ($("[name=attachmentFile]")[0] && $("[name=attachmentFile]")[0].files[0]) {
					if (isNotAcceptableFileSize('<%=MAXIMUM_FILE_UPLOAD_SIZE%>', $("[name=attachmentFile]")[0].files[0].size)) {
						alert("Too Large Size of the File.");
						$(this).val("");
						return false;
					}
				}
				
				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/freshman/guides/"+guideSeq;
	            	$.ajax({
	            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	            		url : url,
	            		type : "POST",
	            		data : getChangeFormData(),
	            		dataType : "json",
	            		enctype: 'multipart/form-data',
	            		processData: false,
	            		contentType: false,
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
	            		success : function(data, textStatus, jqXHR) {
			        		if (data.head.status == 200) {
							openSwal(data.head.message, "");
							getDetailData();
						} else {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
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

            function freshmanValidate() {
            		var returnVal = true;
	            	if (!$("#content").code()) {
	            		$("label[for=content]").append("This field is required.");
	            		$("label[for=content]").css("display", "");
	            		$("label[for=content]").parent().css("display", "");
	            		returnVal = false;
	            	}
	            	return returnVal;
            }
            
            function getChangeFormData() {
				var formData = new FormData();
				formData.append("title", $("#title").val());
				if ($("[name=attachmentFile]")[0]) {
					if ($("[name=attachmentFile]")[0].files[0]) {
						formData.append("attachment", $("[name=attachmentFile]")[0].files[0]);
						formData.append("hasAttachment", true);
					}
				} else {
					formData.append("hasAttachment", false);
				}
				formData.append("content", $("#content").code());
				formData.append("isDeleteAttachment", getBoolean($("[name=isDeleteAttachment]").val()));
				
				return formData;
            }
            
            function deleteDetail() {
				var branchSeq = getUrlParameter("branchSeq");
				var guideSeq = getUrlParameter("guideSeq");
				if (!guideSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/freshman/guides/"+guideSeq;
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
								window.history.back(1);
							});
						} else {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
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
            
			function FRESHMAN_BASE_DOMAIN(breanchSeq) {
	        		return "<%=SERVER_URL%>/branches/" + breanchSeq + "/freshman/guides"
			}
            
            setStaffNameOnHeader();
        </script>
    

    </body>
</html>
