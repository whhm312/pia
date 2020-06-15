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
	                           <button type="button" class="btn btn-default m-b-5" id="historyBackButton">Back</button>
	                           <button type="button" class="btn btn-default m-b-5" id="newSaveButton">Save</button>
                            </div>
                            
							<form class="cmxform form-horizontal tasi-form" role="form" id="newForm" novalidate="novalidate">
	                            <div class="panel-body">
	                                <div class="clearfix"></div>
	                                <div class="row">
	                                		<div class="form-group">
	                                        <label class="col-md-2 control-label">Branch</label>
	                                        <div class="col-md-10" id="newBranchDiv">
	                                        </div>
	                                    </div> <!-- form-group -->
	                                </div>
	                                
	                                <div class="row" id="forAllStudentDiv">
	                                		<div class="form-group">
	                                        <label class="col-md-2 control-label"></label>
	                                        <div class="col-md-10">
	                                            <div class="radio-inline">
	                                                <label class="cr-styled">
	                                                    <input type="checkbox" id="isForAll" value="true" required aria-required="true"> 
	                                                    <i class="fa"></i> For All Students
	                                                </label>
	                                            </div>
	                                        </div>
	                                    </div> <!-- form-group -->
	                                </div>
	                                
	                                <div class="row">
	                                    <div class="form-group">
	                                        <div class="col-md-2 ionicon-list text-right">
	                                    			<label class="control-label">Language </label>
	                                    			<!-- <i class="ion-plus-circled" style="cursor:pointer"></i> -->
	                                    		</div>
	                                        <div class="col-md-10" id="newLanguageDiv">
	                                        </div>
	                                        <input type="hidden" name="languageSeq"/>
	                                    </div> <!-- form-group -->
	                                </div>
	                                
	                                <div class="row">
	                                    <div class="form-group">
	                                        <label class="col-md-2 control-label">Top of List</label>
	                                        <div class="col-md-10">
	                                            <div class="radio-inline">
	                                                <label class="cr-styled">
	                                                    <input type="radio" name="isTopOfList" value="true" required aria-required="true"> 
	                                                    <i class="fa"></i>
	                                                    Top 
	                                                </label>
	                                            </div>
	                                            <div class="radio-inline">
	                                                <label class="cr-styled">
	                                                    <input type="radio" name="isTopOfList" value="false" required aria-required="true"> 
	                                                    <i class="fa"></i> 
	                                                    General
	                                                </label>
	                                            </div>
	                                        </div>
	                                    </div> <!-- form-group -->
	                                </div>
	                                
	                                <div class="row">
	                                    <div class="form-group">
	                                        <label class="col-md-2 control-label">Type</label>
	                                        <div class="col-md-10">
	                                            <div class="radio-inline">
	                                                <label class="cr-styled">
	                                                    <input type="radio" name="isPopup" id="isPopup" value="true" required aria-required="true"> 
	                                                    <i class="fa"></i>
	                                                    Popup 
	                                                </label>
	                                            </div>
	                                            <div class="radio-inline">
	                                                <label class="cr-styled">
	                                                    <input type="radio" name="isPopup" id="isPopup" value="false" required aria-required="true"> 
	                                                    <i class="fa"></i> 
	                                                    General
	                                                </label>
	                                            </div>
	                                        </div>
	                                    </div> <!-- form-group -->
	                                </div>
	                                <div class="row" id="popupPeriodDiv">
	                                		<div class="form-group">
	                                        <label class="col-md-2 control-label">Popup Period</label>
	                                        <div class="col-md-10 form-inline" style="padding-left:20px">
				                                <div class="col-md-3 input-group">
				                                    <input type="text" class="form-control input-sm" placeholder="mm/dd/yyyy" id="popupStartDate" name="popupStartDate" required aria-required="true">
				                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                                </div><!-- input-group -->
				                                ~
				                                <div class="col-md-3 input-group">
				                                    <input type="text" class="form-control input-sm" placeholder="mm/dd/yyyy" id="popupEndDate" name="popupEndDate" required aria-required="true">
				                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				                                </div><!-- input-group -->
	                                        </div>
	                                    </div> <!-- form-group -->
	                                </div>
	                                
	                                <div class="row">
	                                		<div class="form-group">
	                                        <label class="col-md-2 control-label">Title</label>
	                                        <div class="col-md-10">
		                                        <div class="col-md-12">
		                                            <input type="text" class="form-control input-sm" value="" placeholder="" name="title" id="title" required aria-required="true">
		                                        </div>
	                                        </div>
	                                    </div>
	                                </div>
	                                
	                                <div class="row">
	                                		<div class="form-group">
	                                        <label class="col-md-2 control-label">Attachement</label>
	                                        <div class="col-md-10">
		                                        <div class="col-md-12 icon-list" id="attachmentDiv">
		                                        		<input type="file" name="attachmentFile" class="form-control input-sm"/>
		                                        </div>
	                                        </div>
	                                        <input type="hidden" name="isDeleteAttachment" value="false"/>
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
	                                    		<label id="contentNote-error" class="error" for="contentNote"></label>
	                                    </div>
					                    <div class="col-sm-12">
			                                <div class="summernote" id="contentNote"></div>
					                    </div>
					                </div>
	                            </div>
		                 </form>
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
    			$("#newSaveButton").on("click", newDetail);
               
    			gridBranches("radio", "branch", $("#newBranchDiv"));
    			gridLanguage("radio", "language", $("#newLanguageDiv"));
    			
    			$("[name=language]").change(function() {
    				var languageText = $(this).parent().text().trim();
    				if (languageText == "English") {
    					$("#isForAll").prop('checked', true);
					} else {
    					$("#isForAll").prop('checked', false);
					}
    			});
    			
    			$("#isForAll").change(function() {
    				if ($(this).prop("checked")) {
    					$.each($("#newLanguageDiv").find(".radio-inline"), function(idx, val) {
    						$(this).addClass("disabled");
    						
    						$(this).find("label").css("cursor", "not-allowed");
    						$(this).find("label").find("i").css("cursor", "not-allowed");
    						$(this).find("label").addClass("disabled");
    						$(this).find("input:radio").prop('checked', false);
    						$(this).find("input:radio").closest("label").removeClass("active");
    						
    						$(this).prop("disabled", true);
    						$(this).find("label").prop("disabled", true);
    						$(this).find("input:radio").prop('disabled', true);
    					});

               			var language = "";
               			$.each($("[name=language]"), function(idx, val) {
               				language = $(this).parent().text().trim();
               				if (language == "English") {
               					$(this).prop('checked', true);
   							}
               			});
               			
					} else {
    					$.each($("#newLanguageDiv").find(".radio-inline"), function(idx, val) {
    						$(this).removeClass("disabled");
    						
    						$(this).find("label").css("cursor", "");
    						$(this).find("label").find("i").css("cursor", "");
    						$(this).find("label").removeClass("disabled");
    						
    						$(this).removeAttr("disabled");
    						$(this).find("label").removeAttr("disabled");
    						$(this).find("input:radio").removeAttr('disabled');
    					});
					}
    			});
    			
    			$("[name=isPopup]").change(function () {
    				if (getBoolean($(this).val())) {
	        			$("#popupPeriodDiv").css("display", "");
		        		$("#popupStartDate").attr("required", true);
		        		$("#popupEndDate").attr("required", true);
					} else {
        				$("#popupPeriodDiv").css("display", "none");
		        		$("#popupStartDate").datepicker("setDate", "");
		        		$("#popupEndDate").datepicker("setDate", "");
		        		$("#popupStartDate").attr("required", false);
		        		$("#popupEndDate").attr("required", false);
					}
    			});
                
                initPlugins();
            });
            
            function initPlugins() {
    	        $("#newForm").validate({
    	            errorPlacement: function(error, element) {
   	            		if (element.attr("name") == 'branch') {
   	            			error.insertBefore($("[name=branch]").first().parent().parent());
   	            		} else if (element.attr("name") == 'language') {
   	            			error.insertBefore($("[name=language]").first().parent().parent());
   	            		} else if (element.attr("name") == 'isTopOfList') {
   	            			error.insertBefore($("[name=isTopOfList]").first().parent().parent());
   	            		} else if (element.attr("name") == 'isPopup') {
   	            			error.insertBefore($("[name=isPopup]").first().parent().parent());
   	            		} else if (element.attr("name") == 'popupStartDate') {
   	            			error.insertAfter($("[name=popupStartDate]").parent());
   	            		} else if (element.attr("name") == 'popupEndDate') {
   	            			error.insertAfter($("[name=popupEndDate]").parent());
    					} else {
    		                error.insertBefore(element);
    					}
    	            }
    	        });
    	        
    	        initValidateRadioButtons(["branch", "language" ,"isTopOfList", "isPopup"]);
           		
           		var defaultDetepickerOptions = {format : "yyyy/mm/dd"};
        		$("#popupStartDate").datepicker(defaultDetepickerOptions).on("changeDate", function(e){
       			    $(this).datepicker("hide");
       			});
        		$("#popupEndDate").datepicker(defaultDetepickerOptions).on("changeDate", function(e){
       			    $(this).datepicker("hide");
       			});
        		
        		$("#popupStartDate").change(function() {
	        		$(this).valid();
        		});
        		$("#popupEndDate").change(function() {
	        		$(this).valid();
        		});
        		
        		$("#contentNote").summernote({
	            	onChange: function() {
	        	    	$("label[for=contentNote]").append("");
	        	    	$("label[for=contentNote]").css("display", "none");
	        	    	$("label[for=contentNote]").parent().css("display", "none");
		            },
		            height: 400,                 // set editor height
		            minHeight: null,             // set minimum height of editor
		            maxHeight: null,             // set maximum height of editor
		            focus: true                 // set focus to editable area after initializing summernote
		        });
            }
            
            function newDetail() {
           		var firstCheck = $("#newForm").valid();
           		var secodCheck = newNoticeValidate(); 
           		if (!firstCheck || !secodCheck) {
					return false;	
				}
           		
        		var branchSeq = $("[name=branch]:checked").val();
				if (!branchSeq) {
					alert("lack of data.");
					return false;	
				}

				if ($("[name=attachmentFile]")[0] && $("[name=attachmentFile]")[0].files[0]) {
					if (isNotAcceptableFileSize('<%=MAXIMUM_FILE_UPLOAD_SIZE%>', $("[name=attachmentFile]")[0].files[0].size)) {
						alert("Too Large Size of the File.");
						$(this).val("");
						return false;
					}
				}
				
                var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/notices";
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "POST",
            		data : getFormData("newForm"),
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

            function newNoticeValidate() {
            	var returnVal = true;
            	if (!$("#contentNote").code()) {
            		$("label[for=contentNote]").append("This field is required.");
            		$("label[for=contentNote]").css("display", "");
            		$("label[for=contentNote]").parent().css("display", "");
            		returnVal = false;
            	}
            	return returnVal;
            }

            function getFormData(formName) {
				var formData = new FormData();
				formData.append("languageSeq", $("[name=language]:checked").val());
				formData.append("title", $("#title").val());
				formData.append("isTopOfList", $("[name=isTopOfList]:checked").val());
				formData.append("isForAll", $("#isForAll").prop("checked"));
				
				if (getBoolean($("[name=isPopup]:checked").val())) {
					formData.append("isPopup", true);
					formData.append("popupStartDate", $("#popupStartDate").val());
					formData.append("popupEndDate", $("#popupEndDate").val());
				} else {
					formData.append("isPopup", false);
					formData.append("popupStartDate", "");
					formData.append("popupEndDate", "");
				}
				
				if ($("[name=attachmentFile]")[0]) {
					if ($("[name=attachmentFile]")[0].files[0]) {
						formData.append("attachment", $("[name=attachmentFile]")[0].files[0]);
						formData.append("hasAttachment", true);
					}
				} else {
					formData.append("hasAttachment", false);
				}
				
				formData.append("content", $("#contentNote").code());
				return formData;
            }
            
            setStaffNameOnHeader();
        </script>
    </body>
</html>
