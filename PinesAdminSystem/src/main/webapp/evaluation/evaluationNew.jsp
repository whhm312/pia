<!DOCTYPE html>
<html lang="en">
	<%@ include file="/include/head.jsp" %>
	<style>
		.table > tbody > tr > td, .table > tbody > tr > th {
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
                            <li><a href="/study/studyList.jsp">Class Schedule</a></li>
                            <li><a href="/exam/examList.jsp">Examination & Results</a></li>
                            <li><a href="/attendance/attendanceList.jsp">Attendance</a></li>
                            <li class="active"><a href="/evaluation/evaluationList.jsp">Evaluation</a></li>
                            <!-- <li><a href="/evaluation/results/evaluationResultList.jsp">Evaluation Results</a></li> -->
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
                    <h3 class="title">Evaluation</h3>
                </div>
				<form class="cmxform form-horizontal tasi-form" role="form" id="newForm" novalidate="novalidate">
                <div class="row" id="mainInfoDiv">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right ">
	                           <button type="button" class="btn btn-default m-b-5" id="historyBackButton">Back</button>
	                           <button type="button" class="btn btn-default m-b-5" id="newSaveButton">Save</button>
                            </div>
	                            <div class="panel-body">
	                                <div class="clearfix"></div>
	                                <div class="row">
	                                		<div class="form-group">
	                                        <label class="col-md-2 control-label">Branch</label>
	                                        <div class="col-md-10" id="newBranchDiv">
	                                        </div>
	                                    </div> <!-- form-group -->
	                                </div>
	                                
	                                <div class="row">
	                                		<div class="form-group">
	                                        <label class="col-md-2 control-label">Summary</label>
	                                        <div class="col-md-10">
		                                        <div class="col-md-12">
		                                            <input type="text" class="form-control input-sm" value="" placeholder="" name="summary" id="summary" required aria-required="true">
		                                        </div>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
                        </div>
                    </div>
                </div>
                
				<div class="row col-md-12 text-right" style="margin-bottom: 10px" id="addItemsButton">
					<div class="btn-group">
					    <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-expanded="true">Add Item <span class="caret"></span></button>
					    <ul class="dropdown-menu" role="menu">
					        <li><a id="newYesNoButton">YESNO</a></li>
					        <li><a id="newNumberButton">NUMBER</a></li>
					        <li><a id="newOpinionButton">OPINION</a></li>
					    </ul>
					</div>
				</div>
                </form>
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
        <script src="/custom/gridHtml.js"></script>
        <script type="text/javascript">
           	var EVALUATION_GROUP_SEQ = 1;
            jQuery(document).ready(function() {
           		initPlugins();
            	if (!$.cookie("languages")) {
            		alert("Lack of Cookies.");
            		window.location.replace("/login.jsp"); 
            	}
            	
        		$("#newSaveButton").click(newDetail);
        		$("#newYesNoButton").click(gridNewYesNoItem);
        		$("#newNumberButton").click(gridNewNumberItem);
        		$("#newOpinionButton").click(gridNewOpinionItem);
        		
        		gridBranches("radio", "branch", $("#newBranchDiv"));
            });
            
			function gridNewYesNoItem() {
				if ($("[id=newItemDiv]").length > 0) {
					$("[id=newItemDiv]").last().after(evaluationYesNoDiv);
				} else {
					$("#addItemsButton").after(evaluationYesNoDiv);
				}
				
				$("[id=newItemDiv]").last().find("#newOrderNo").val(EVALUATION_GROUP_SEQ++);
				gridLanguageSelect();
				
				$("[id=newItemDiv]").last().find("#addNewLanguageItemButton").click(function() {
					$(this).parent().parent().append(evaluationYesNoRowDiv);
					
					var parentOrderNo = $(this).parent().parent().children().find("[id=newOrderNo]").first().val();
					if (!parentOrderNo) {
						parentOrderNo = EVALUATION_GROUP_SEQ;	
					}
					
					var $el = $(this).parent().parent().children().last();
					$el.find("#newOrderNo").prop("disabled", true);
					$el.find("#newOrderNo").val(parentOrderNo);
					gridLanguageSelect($el.find("select"));
					
					$el.find("#deleteOneItemButton").click(function() {
						var index = $("[id=deleteOneItemButton]").index(this) + 1;
						if (index > 0) {
							$("[id=itemRowDiv]").eq(index).remove();
						} else {
							console.log("deleteOneItemButton", index);
						}
					});
				});
				 			
				$("[id=newItemDiv]").last().find("#newItemsDeleteButton").click(function() {
					var index = $("[id=newItemsDeleteButton]").index(this);
					$("[id=newItemDiv]").eq(index).remove();
				});
				
				$("[id=newItemDiv]").last().find("[id=deleteOneItemButton]").eq(0).remove();
			}
			
			function gridNewNumberItem() {
				if ($("[id=newItemDiv]").length > 0) {
					$("[id=newItemDiv]").last().after(evaluationNumberDiv);
				} else {
					$("#addItemsButton").after(evaluationNumberDiv);
				}
				
				$("[id=newItemDiv]").last().find("[id=deleteOneItemButton]").eq(0).remove();
				$("[id=newItemDiv]").last().find("#newOrderNo").val(EVALUATION_GROUP_SEQ++);
				gridLanguageSelect();
				
				$("[id=newItemDiv]").last().find("#addNewLanguageItemButton").click(function() {
					$(this).parent().parent().append(evaluationNumberRowDiv);
					
					var parentOrderNo = $(this).parent().parent().children().find("[id=newOrderNo]").first().val();
					if (!parentOrderNo) {
						parentOrderNo = EVALUATION_GROUP_SEQ;	
					}
					
					var $el = $(this).parent().parent().children().last();
					$el.find("#newOrderNo").prop("disabled", true);
					$el.find("#newOrderNo").val(parentOrderNo);
					gridLanguageSelect($el.find("select"));
					
					$el.find("#deleteOneItemButton").click(function() {
						var index = $("[id=deleteOneItemButton]").index(this) + 1;
						if (index > 0) {
							$("[id=itemRowDiv]").eq(index).remove();
						}
					});
					
					$el.find("#newAddOptionButton").click(function() {
						$(this).parents("table").find("#newOptionTBody").append(evaluationNumberOptionDiv);
						$(this).parents("table").find("#newOptionTBody").children().last().find("[id=newOptionDeleteButton]").click(function() {
							$(this).parents("tr").remove();
						});
					});
				});
				 			
				$("[id=newItemDiv]").last().find("#newItemsDeleteButton").click(function() {
					var index = $("[id=newItemsDeleteButton]").index(this);
					$("[id=newItemDiv]").eq(index).remove();
				});
				
				$("[id=newItemDiv]").last().find("#newOptionDeleteButton").click(function() {
					$(this).parent().parent().remove();
				});
				
				$("[id=newItemDiv]").last().find("#newAddOptionButton").click(function() {
					$(this).parents("table").find("#newOptionTBody").append(evaluationNumberOptionDiv);
					$(this).parents("table").find("#newOptionTBody").children().last().find("[id=newOptionDeleteButton]").click(function() {
						$(this).parents("tr").remove();
					});
				});
			}

			function gridNewOpinionItem() {
				if ($("[id=newItemDiv]").length > 0) {
					$("[id=newItemDiv]").last().after(evaluationOpinionDiv);
				} else {
					$("#addItemsButton").after(evaluationOpinionDiv);
				}
				
				$("[id=newItemDiv]").last().find("#newOrderNo").val(EVALUATION_GROUP_SEQ++);
				gridLanguageSelect();
				
				$("[id=newItemDiv]").last().find("#addNewLanguageItemButton").click(function() {
					var $el = $(this).parent().next().last();
					$el.after(evaluationOpinionRowDiv);
					
					var parentOrderNo = $(this).parent().next().children().find("[id=newOrderNo]").first().val();
					if (!parentOrderNo) {
						parentOrderNo = EVALUATION_GROUP_SEQ;	
					}
					
					$el.next().find("#newOrderNo").prop("disabled", true);
					$el.next().find("#newOrderNo").val(parentOrderNo);
					gridLanguageSelect($el.next().find("select"));
					
					$el.next().find("#deleteOneItemButton").click(function() {
						var index = $("[id=deleteOneItemButton]").index(this) + 1;
						if (index > 0) {
							$("[id=itemRowDiv]").eq(index).remove();
						}
					});
				});
				
				$("[id=newItemDiv]").last().find("#newItemsDeleteButton").click(function() {
					var index = $("[id=newItemsDeleteButton]").index(this);
					$("[id=newItemDiv]").eq(index).remove();
				});
				
				$("[id=newItemDiv]").last().find("[id=deleteOneItemButton]").eq(0).remove();
			}

            function gridLanguageSelect($el) {
	            	var html = "<option value=\"\">Select..</option>";
	            	var $languages = JSON.parse($.cookie("languages"));
	            	$.each($languages, function(index, item) {
	            		html += "<option value=\"" + item.seq + "\">";
	            		html += item.name;
	            		html += "</option>";
	            	});
	            	if ($el) {
	            		$el.append(html);
				} else {
	            		$("[id=newItemDiv]").last().find("select").append(html);
				}
            }

            function initPlugins() {
            }
            
            function newDetail() {
           		var branchSeq = $("[name=branch]:checked").val();
				if (!branchSeq) {
					alert("lack of data.");
					return false;
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/evaluations";
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
							openSwal(data.head.message, "", function() {
								closeWindowByMask();
								window.location.replace("/evaluation/evaluationList.jsp");
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
            
            function getNewItemDivItems() {
				var items = new Array();
				var options = new Array();
				var item, option;
				var temporaryOrderNo = 1;
				
				$.each($("[id=itemRowDiv]"), function(idx, val) {
					if ($(this).find("[id=newItemTBody]").attr("optionType") == "YESNO") {
						$.each($(this).find("[id=newOptionContent]"), function(iIdx, iVal) {
							options.push({
								"orderNo" : temporaryOrderNo++,
								"optionNo" : 0,
								"optionContent" : $(iVal).val()
							});
						});
						temporaryOrderNo = 1;
					} else if ($(this).find("[id=newItemTBody]").attr("optionType") == "NUMBER") {
						$.each($(this).find("[id=newOptionTBody]").children("tr"), function(iIdx, iVal) {
							options.push({
								"orderNo" : $(this).find("#newOptionOrderNo").val(),
								"optionNo" : $(this).find("#newOptionNumber").val(),
								"optionContent" : $(this).find("#newOptionContent").val()
							});
						});
					} else if ($(this).find("[id=newItemTBody]").attr("optionType") == "OPINION") {
					}
					
					item = {
							"evaluationGroupSeq" : $(this).find("#newOrderNo").val(),
							"languageSeq" : $(this).find("#newLanguage").val(),
							"orderNo" : $(this).find("#newOrderNo").val(),
							"itemContent" : $(this).find("#newItemContent").val(),
							"optionType" : $(this).find("#newItemTBody").attr("optionType"),
							"options" : options
					}
					items.push(item);
					
					options = new Array();
				});
				
				console.log("getNewItemDivItems : ", items);
				return items;
            }

			function getJsonData() {
				return JSON.stringify({
					"summary" : $("#summary").val(),
					"items" : getNewItemDivItems()
				});
			}
			
            setStaffNameOnHeader();
            
        </script>
    </body>
</html>
