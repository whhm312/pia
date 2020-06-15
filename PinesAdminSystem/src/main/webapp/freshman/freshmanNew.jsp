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
                            </div>
                            
                            <div class="panel-body">
							<form class="cmxform form-horizontal tasi-form" role="form" id="detailForm" novalidate="novalidate">
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-md-2 ionicon-list text-right">
                                    			<label class="control-label">Branch </label>
                                    			<!-- <i class="ion-plus-circled" style="cursor:pointer"></i> -->
                                    		</div>
                                        <div class="col-md-10" id="detailBranchDiv">
                                        </div>
		                           		<input type="hidden" name="branchSeq" id="branchSeq"/>
                                    </div> <!-- form-group -->
                                </div>
		                       
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-md-2 ionicon-list text-right">
                                    			<label class="control-label">Nationality </label>
                                    			<!-- <i class="ion-plus-circled" style="cursor:pointer"></i> -->
                                    		</div>
                                        <div class="col-md-10" id="detailNationalityDiv">
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
	    		$("#detailSaveButton").on('click', newDetail);

	 		gridBranches("radio", "branch", $("#detailBranchDiv"));
	    		gridSearchNationality("radio", $("#detailNationalityDiv"));
    			
	    		$("[name='branch']").eq(0).attr("checked", true);
	    		$("[name='branch']").change(function() {
	    			$("#detailGroupDiv").empty();
	    			gridNewFormGroups($("#detailGroupDiv"));
	    		});
	    		
    			gridNewFormGroups($("#detailGroupDiv"));
    			
    			$("#attachmentDiv").append("<input type=\"file\" name=\"attachmentFile\" class=\"form-control input-sm\"/>");
	    });
        
	    function initPlugins() {
	        $("#detailForm").validate({
	            errorPlacement: function(error, element) {
	            		if (element.attr("name") == 'branch') {
	            			error.insertBefore($("[name=branch]").first().parent().parent());
	            		} else if (element.attr("name") == 'nationality') {
	            			error.insertBefore($("[name=nationality]").first().parent().parent());
					} else {
		                error.insertBefore(element);
					}
	            }
	        });
	        
	        initValidateRadioButtons(["branch", "nationality"]);
	        
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
	    	        			gridCookieData(JSON.stringify(data.body.data), inputType, "nationality", $gridDiv);
	    	        			
 	    	            		$("input[type=radio][name='nationality']").change(function() {
	    	            			$("#nationalitySeq").val($("[name='nationality']:checked").val());
	    	            		});
	    	        		}
	    	        	},
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
            			closeWindowByMask();
            		}
            	});
	    }
	    
	    function gridNewFormGroups($gridDiv) {
	    		var branchSeq = $("[name='branch']:checked").val();
	        	var url = "<%=SERVER_URL%>/conditions/" + branchSeq + "/groups";
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "GET",
            		dataType : "json",
            		contentType : "application/json; charset=UTF-8",
				success : function(data, textStatus, jqXHR) {
					if (data.head.status == 200) {
	        				gridGroupsFnc(data.body.data, $gridDiv, false);
	        			}
	    	        	},
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
            		},
				complete : function(jqXHR, textStatus) {
					initPlugins();
					closeWindowByMask();
				}
            	});
	    }
	    
	    function gridGroupsFnc(response, $gridDiv, isWithAll) {
			var $data = response;
			//console.log($data);
			
			var html = "";
			html += "<div>";
			html += "<select class=\"form-control input-sm\" name=\"group\" id=\"group\" required>";
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
	    
	    function newDetail() {
	    		var firstCheck = $("#detailForm").valid();
	    		var secodCheck = freshmanValidate();
	   		if (!firstCheck || !secodCheck) {
				return false;	
			}

	    		var branchSeq = $("[name=branch]:checked").val();
			if (!branchSeq) {
				alert("lack of data.");
				window.history.back(1);
			}

			if ($("[name=attachmentFile]")[0] && $("[name=attachmentFile]")[0].files[0]) {
				if (isNotAcceptableFileSize('<%=MAXIMUM_FILE_UPLOAD_SIZE%>', $("[name=attachmentFile]")[0].files[0].size)) {
					alert("Too Large Size of the File.");
					$(this).val("");
					return false;
				}
			}
			
	        var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/freshman/guides";
	        	$.ajax({
	        		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	        		url : url,
	        		type : "POST",
	        		data : getNewFormData(),
	        		dataType : "json",
	        		enctype: 'multipart/form-data',
	        		processData: false,
	        		contentType: false,
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
	
	
	    function getNewFormData() {
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
			formData.append("nationalitySeq", $("#nationalitySeq").val())
			formData.append("studentGroupSeq", $("#group").val())
			
			return formData;
	    }
	    
	    function resetAttachmentDiv() {
			$("#attachmentDiv").empty();
			$("#attachmentDiv").append("<input type=\"file\" name=\"attachmentFile\" class=\"form-control input-sm\"/>");
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
        
        setStaffNameOnHeader();
	    
        </script>
    </body>
</html>
