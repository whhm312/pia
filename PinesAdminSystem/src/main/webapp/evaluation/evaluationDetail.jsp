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
	                           <button type="button" class="btn btn-default m-b-5" id="detailSaveButton">Save</button>
	                           <button type="button" class="btn btn-default m-b-5" id="detailDeleteButton">Delete</button>
                            </div>
	                            <div class="panel-body">
	                                <div class="clearfix"></div>
	                                <div class="row">
	                                		<div class="form-group">
	                                        <label class="col-md-2 control-label">Branch</label>
	                                        <div class="col-md-7 control-label" id="detailBranchSpan" style="text-align:left;margin-left:10px"></div> 
											<input type="hidden" name="branchSeq" id="branchSeq"/>
											<input type="hidden" name="evaluationSeq" id="evaluationSeq"/>
	                                    </div> <!-- form-group -->
	                                </div>
	                                
	                                <div class="row">
	                                		<div class="form-group">
	                                        <label class="col-md-2 control-label">Summary</label>
	                                        <div class="col-md-7 control-label" style="text-align:left;margin-left:10px">
												<input class="col-md-12" type="text" name="summary" id="summary"/>
	                                        </div>
	                                    </div>
	                                </div>
	                                <div class="row">
	                                		<div class="form-group">
	                                        <label class="col-md-2 control-label">Date Requested</label>
	                                        <div class="col-md-7 control-label" id="detailRegisterDateSpan" style="text-align:left;margin-left:10px"></div>
		                                	</div>
	                                </div>
	                                <div class="row">
	                                		<div class="form-group">
	                                        <label class="col-md-2 control-label">Writer</label>
	                                        <div class="col-md-7 control-label" id="detailWriterSpan" style="text-align:left;margin-left:10px"></div>
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
        		
        		$("#detailSaveButton").on("click", saveDetail);
        		$("#detailDeleteButton").on("click", deleteDetail);
        		$("#newYesNoButton").click(gridNewYesNoItem);
        		$("#newNumberButton").click(gridNewNumberItem);
        		$("#newOpinionButton").click(gridNewOpinionItem);

        		getDetailData();
       		});

            function initPlugins() {
            }
            
			function gridNewYesNoItem() {
				if ($("[id=newItemDiv]").length > 0) {
					$("[id=newItemDiv]").last().after(evaluationYesNoDiv);
				} else {
					$("#addItemsButton").after(evaluationYesNoDiv);
				}
				
				$("[id=newItemDiv]").last().find("#newOrderNo").val(++EVALUATION_GROUP_SEQ);
				gridLanguageSelect();
				
				$("[id=newItemDiv]").last().find("#addNewLanguageItemButton").click(function() {
					$(this).parent().parent().append(evaluationYesNoRowDiv);
					$(this).parents("#newItemDiv").last().attr("hasNew", true);
					$(this).parents("#newItemDiv").last().attr("optionType", "YESNO");
						
					var parentOrderNo = $(this).parent().parent().find("[id=newOrderNo]").first().val();
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
					$(this).parents("[id=newItemDiv]").remove();
				});
				
				$("[id=newItemDiv]").last().find("[id=deleteOneItemButton]").eq(0).remove();
				$("[id=newItemDiv]").last().attr("isNew", true);
				$("[id=newItemDiv]").last().attr("optionType", "YESNO");
			}  

			function gridNewNumberItem() {
				if ($("[id=newItemDiv]").length > 0) {
					$("[id=newItemDiv]").last().after(evaluationNumberDiv);
				} else {
					$("#addItemsButton").after(evaluationNumberDiv);
				}
			
				$("[id=newItemDiv]").last().find("[id=deleteOneItemButton]").eq(0).remove();
				$("[id=newItemDiv]").last().find("#newOrderNo").val(++EVALUATION_GROUP_SEQ);
				gridLanguageSelect();
			
				$("[id=newItemDiv]").last().find("#addNewLanguageItemButton").click(function() {
					$(this).parent().parent().append(evaluationNumberRowDiv);
					$(this).parents("#newItemDiv").last().attr("hasNew", true);
					$(this).parents("#newItemDiv").last().attr("optionType", "NUMBER");
			
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
					$(this).parents("[id=newItemDiv]").remove();
				});
				
				$("[id=newItemDiv]").last().find("#newOptionDeleteButton").click(function() {
					$(this).parents("tr").remove();
				});
			
				$("[id=newItemDiv]").last().find("#newAddOptionButton").click(function() {
					$(this).parents("table").find("#newOptionTBody").append(evaluationNumberOptionDiv);
					$(this).parents("#newItemDiv").attr("hasNew", true);
					$(this).parents("#newItemDiv").attr("optionType", $(this).parents("#newItemDiv").find("#newItemTBody").attr("optionType"));
					$(this).parents("table").find("#newOptionTBody").children().last().find("[id=newOptionDeleteButton]").click(function() {
						$(this).parents("tr").remove();
					});
				});
				$("[id=newItemDiv]").last().attr("isNew", true);
				$("[id=newItemDiv]").last().attr("optionType", "NUMBER");
			}
			
			function gridNewOpinionItem() {
				if ($("[id=newItemDiv]").length > 0) {
					$("[id=newItemDiv]").last().after(evaluationOpinionDiv);
				} else {
					$("#addItemsButton").after(evaluationOpinionDiv);
				}
			
				$("[id=newItemDiv]").last().find("#newOrderNo").val(++EVALUATION_GROUP_SEQ);
				gridLanguageSelect();
			
				$("[id=newItemDiv]").last().find("#addNewLanguageItemButton").click(function() {
					var $el = $(this).parent().next().last();
					$el.after(evaluationOpinionRowDiv);
					$(this).parents("#newItemDiv").last().attr("hasNew", true);
					$(this).parents("#newItemDiv").last().attr("optionType", "OPINION");
				
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
					$(this).parents("[id=newItemDiv]").remove();
				});
			
				$("[id=newItemDiv]").last().find("[id=deleteOneItemButton]").eq(0).remove();
				$("[id=newItemDiv]").last().attr("isNew", true);
				$("[id=newItemDiv]").last().attr("optionType", "OPINION");
			}
			
			function getDetailData() {
				var branchSeq = getUrlParameter("branchSeq");
				var evaluationSeq = getUrlParameter("evaluationSeq");
				if (!evaluationSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}
				
				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/evaluations/" + evaluationSeq; 
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
						
						$("#detailBranchSpan").html($data.branch);
						$("#summary").val($data.summary);
						$("#detailRegisterDateSpan").html($data.registerDate);
						$("#detailWriterSpan").html($data.writer);
						$("#branchSeq").val($data.branchSeq);
						$("#evaluationSeq").val($data.evaluationSeq);
						
						var optionHtml = "";
						var itemHtml = "";
						var isSameGroup = false;
						var html = "";
						var optionType= "";
						
						$.each($data.items, function(idx, val) {
							optionType = val.optionType;
							if (idx > 0) {
								var preEvaluationGroupSeq = $("[id=newItemDiv]").last().find("#addNewLanguageItemButton").attr("evaluationGroupSeq");
								var preEvaluationSeq = $("[id=newItemDiv]").last().find("#addNewLanguageItemButton").attr("evaluationSeq");
								var preOptionType = $("[id=newItemDiv]").last().find("#addNewLanguageItemButton").attr("optionType");
								if (preEvaluationGroupSeq == val.evaluationGroupSeq && preEvaluationSeq == $data.evaluationSeq && preOptionType == optionType) {
									isSameGroup = true;
								}
							}
		           			
							if (isSameGroup) {
								if (optionType == "YESNO") {
									html = getYesNoDiffLangItem(val.evaluationGroupSeq, val.evaluationItemSeq, val.orderNo, val.language, val.itemContent, val.options[0].optionSeq, val.options[0].optionContent, val.options[1].optionSeq, val.options[1].optionContent);
								} else if (optionType == "NUMBER") {
									html = getNumberDiffLangItem(val.evaluationGroupSeq, val.evaluationItemSeq, val.orderNo, val.language, val.itemContent, val.options);
								} else if (optionType == "OPINION") {
									html = getOpinionDiffLangItem(val.evaluationGroupSeq, val.evaluationItemSeq, val.orderNo, val.language, val.itemContent);
								}
								
								$("[id=itemRowDiv]").last().after(html);
								
								var $el = $("[id=itemRowDiv]").last();
								$el.find("#deleteOneItemButton").click(function() {
									var index = $("[id=deleteOneItemButton]").index(this);
									if (index > 0) {
										$("[id=itemRowDiv]").eq(index).remove();
									}
								});
							} else {
								if (optionType == "YESNO") {
									html = getYesNoItem(val.evaluationGroupSeq, $data.evaluationSeq, val.evaluationItemSeq, val.orderNo, val.language, val.itemContent, val.options[0].optionSeq, val.options[0].optionContent, val.options[1].optionSeq, val.options[1].optionContent);
								} else if (optionType == "NUMBER") {
									html = getNumberItem(val.evaluationGroupSeq, $data.evaluationSeq, val.evaluationItemSeq, val.orderNo, val.language, val.itemContent, val.options);
								} else if (optionType == "OPINION") {
									html = getOpinionItem(val.evaluationGroupSeq, $data.evaluationSeq, val.evaluationItemSeq, val.orderNo, val.language, val.itemContent);
								}
							
								if ($("[id=newItemDiv]").length > 0) {
									$("[id=newItemDiv]").last().after(html);
								} else {
									$("#addItemsButton").after(html);
								}
							}
							
							html = "";
							optionType = "";
							isSameGroup = false;
		          			EVALUATION_GROUP_SEQ = val.orderNo;
		         		});
					}

					$("[id=newAddOptionButton]").click(function() {
						$(this).parents("table").find("#newOptionTBody").append(evaluationNumberOptionDiv);
						$(this).parents("table").find("#newOptionTBody").children().last().find("#newOptionDeleteButton").click(fncDeleteOption);
						$(this).parents("#newItemDiv").attr("hasNew", true);
						$(this).parents("#newItemDiv").attr("optionType", $(this).parents("#newItemDiv").find("#newItemTBody").attr("optionType"));
					});
     			
					$("[id=deleteEvaludationItem]").click(function() {
						var index = $("[id=deleteEvaludationItem]").index(this);
						$("[id=itemRowDiv]").eq(index).remove();
						deleteEvaluationItemSeqs.push($(this).attr("evaluationItemSeq"));
						//console.log("deleteEvaluationItemSeqs", deleteEvaluationItemSeqs);
					});
     			
					$("[id=deleteOption]").click(fncDeleteOption);
					$("[id=deleteOneItemButton]").click(function() {
						$(this).parents("#itemRowDiv").remove();
					});

					$("[id=addNewLanguageItemButton]").on("click", function() {
						var index = $("[id=addNewLanguageItemButton]").index(this);
						var $ITEM_ROW_DIV = $("[id=newItemDiv]").eq(index).find("[id=itemRowDiv]").last();
						if (!$ITEM_ROW_DIV.is("div")) {
							$ITEM_ROW_DIV = $(this).parent();
							
							if ($(this).attr("optionType") == "NUMBER") {
								$ITEM_ROW_DIV.append(evaluationNumberRowDiv);
							} else if ($(this).attr("optionType") == "YESNO") {
								$ITEM_ROW_DIV.append(evaluationYesNoRowDiv);
							} else if ($(this).attr("optionType") == "OPINION") {
								$ITEM_ROW_DIV.append(evaluationOpinionRowDiv);
							}
							
							$ITEM_ROW_DIV = $ITEM_ROW_DIV.children().last();
						} else {
							if ($(this).attr("optionType") == "NUMBER") {
								$ITEM_ROW_DIV.after(evaluationNumberRowDiv);
							} else if ($(this).attr("optionType") == "YESNO") {
								$ITEM_ROW_DIV.after(evaluationYesNoRowDiv);
							} else if ($(this).attr("optionType") == "OPINION") {
								$ITEM_ROW_DIV.after(evaluationOpinionRowDiv);
							}
							
							$ITEM_ROW_DIV = $ITEM_ROW_DIV.parent().children().last();
							$ITEM_ROW_DIV.parents("#newItemDiv").attr("optionType", $(this).attr("optionType"));
						}

						var preItemOrderNo = $ITEM_ROW_DIV.prev().find("#newItemTBody tr td").first().html();
						if (!$.isNumeric(preItemOrderNo)) {
							preItemOrderNo = $ITEM_ROW_DIV.prev().find("#newOrderNo").val();
						}
						
						gridLanguageSelect($ITEM_ROW_DIV.find("select"));
						$ITEM_ROW_DIV.find("#newOrderNo").prop("disabled", true);
						$ITEM_ROW_DIV.find("#newOrderNo").val(preItemOrderNo);
						$ITEM_ROW_DIV.parents("#newItemDiv").attr("hasNew", true);
						
						$("[id=newAddOptionButton]").click(function() {
							$(this).parents("table").find("#newOptionTBody").append(evaluationNumberOptionDiv);
							$(this).parents("table").find("#newOptionTBody").children().last().find("[id=newOptionDeleteButton]").click(fncDeleteOption);
							$(this).parents("#newItemDiv").attr("hasNew", true);
							$(this).parents("#newItemDiv").attr("optionType", $(this).parents("#newItemDiv").find("#newItemTBody").attr("optionType"));
						});

						$ITEM_ROW_DIV.find("#deleteEvaludationItem").click(function() {
							var index = $("[id=deleteEvaludationItem]").index(this);
							$("[id=newItemDiv]").eq(index).find("[id=itemRowDiv]").remove();
						});

						$ITEM_ROW_DIV.find("#deleteOneItemButton").click(function() {
							$(this).parents("#itemRowDiv").remove();
						});
						
						$("[id=newOptionDeleteButton]").click(fncDeleteOption);
					});
					
					wrapWindowByMask();
         		
				} else if (response.head.status == 401) {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]", function() {
						window.location.replace("/login.jsp");
					});
				} else {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]");
				}
			}
        
            function fncDeleteOption() {
				$(this).parent().parent().remove();
				if ($(this).attr("optionSeq") && $(this).attr("optionSeq") > 0) {
					deleteOptionSeqs.push($(this).attr("optionSeq"));
				}
				//console.log("deleteOptionSeqs", deleteOptionSeqs);
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
            
            var deleteOptionSeqs = new Array();
            var deleteEvaluationItemSeqs = new Array();
            function saveDetail() {
           		console.log(getJsonData());
           		//return false;
            		
				var branchSeq = getUrlParameter("branchSeq");
				var evaluationSeq = getUrlParameter("evaluationSeq");
				if (!evaluationSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/evaluations/" + evaluationSeq;
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "PUT",
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
								location.reload();
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
				var items = getChangeItems();
				return JSON.stringify({
					summary : $("#summary").val(),
					addItems : getNewItems(),
					changeItems : items,
					deleteItems : deleteEvaluationItemSeqs,
					deleteOptionSeqs : deleteOptionSeqs
				});
			}

            function getChangeItems() {
            	
            }
            
            function getNewItems() {
				var items = new Array();
				var options = new Array();
				var item;
				var evaluationGroupSeq = 0;
				var temporaryOrderNo = 1;
				var optionType = "";
				
				$.each($("[id=newItemDiv]"), function(idx, val) {
					if ($(this).attr("isNew") == "true" || $(this).attr("hasNew") == "true") {
						evaluationGroupSeq = $(this).find("#addNewLanguageItemButton").attr("evaluationGroupSeq");
						if (!evaluationGroupSeq) {
							evaluationGroupSeq = 0;
						}
						optionType = $(this).attr("optionType");
						if (optionType == "YESNO") {
							$.each($(this).find("[id=itemRowDiv]"), function(rowIdx, rowVal) {
								if (!$(this).find("#newOptionContent").val()) {
									return true;
								}
								
								$.each($(this).find("[id=newOptionTBody]").children("tr"), function(iIdx, iVal) {
									options.push({
										"orderNo" : temporaryOrderNo++,
										"optionNo" : 0,
										"optionContent" : $(this).find("#newOptionContent").val()
									});
								});
								temporaryOrderNo = 1;
								
								item = {
										"evaluationGroupSeq" : evaluationGroupSeq,
										"languageSeq" : $(this).find("#newLanguage").val(),
										"orderNo" : $(this).find("#newOrderNo").val(),
										"itemContent" : $(this).find("#newItemContent").val(),
										"optionType" : optionType,
										"options" : options
								}
								
								items.push(item);
								options = new Array();
							});
							
						} else if (optionType == "NUMBER") {
							$.each($(this).find("[id=itemRowDiv]"), function(rowIdx, rowVal) {
								if (!$(this).find("#newOptionContent").val()) {
									return true;
								}
								
								$.each($(this).find("[id=newOptionTBody]").children("tr"), function(iIdx, iVal) {
									if (!$(this).find("#newOptionContent").val()) {
										return true;
									}
									options.push({
										"orderNo" : $(this).find("#newOptionOrderNo").val(),
										"optionNo" : $(this).find("#newOptionNumber").val(),
										"optionContent" : $(this).find("#newOptionContent").val()
									});
								});							
								item = {
										"evaluationGroupSeq" : evaluationGroupSeq,
										"evaluationItemSeq" : $(this).attr("evaluationItemSeq"),
										"languageSeq" : $(this).find("#newLanguage").val(),
										"orderNo" : $(this).find("#newOrderNo").val(),
										"itemContent" : $(this).find("#newItemContent").val(),
										"optionType" : optionType,
										"options" : options
								}
								items.push(item);
								options = new Array();
							});
						} else if ($(this).attr("optionType") == "OPINION") {
							item = {
									"evaluationGroupSeq" : evaluationGroupSeq,
									"languageSeq" : $(this).find("#newLanguage").val(),
									"orderNo" : $(this).find("#newOrderNo").val(),
									"itemContent" : $(this).find("#newItemContent").val(),
									"optionType" : optionType,
									"options" : options
							}
							items.push(item);
							options = new Array();
						}
					}
				});
				
				console.log("getNewItemDivItems : ", items);
				return items;
            }
			
            function deleteDetail() {
				var branchSeq = getUrlParameter("branchSeq");
				var evaluationSeq = getUrlParameter("evaluationSeq");
				if (!evaluationSeq || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/evaluations/" + evaluationSeq;
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
								closeWindowByMask();
								window.history.back(1);
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

            setStaffNameOnHeader();
            
        </script>
    </body>
</html>
