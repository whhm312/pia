<!DOCTYPE html>
<html lang="en">
	<%@ include file="/include/head.jsp" %>
	<style type="text/css">
		.radio-inline {
			cursor:default;
		}
		*:focus {
			color: initial;
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
                    <li class="has-submenu active"><a href="/student/studentList.jsp"><i class="zmdi zmdi-accounts"></i> <span class="nav-label">Student</span></a>
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
                    <h3 class="title">Student</h3> 
                </div>
                <form class="form-horizontal" role="form">
                
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right ">
								<button type="button" class="btn btn-default m-b-5" id="historyBackButton">Back</button>
								<button type="button" class="btn btn-default m-b-5" id="sendMessageButton">Send Message</button>
								<div class="btn-group">
									<button type="button" class="btn btn-default m-b-5 dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> Change info <span class="caret"></span> </button>
									<ul class="m-b-5 dropdown-menu">
										<li><a href="#" id="registerIdCardButton">Student's ID Card</a></li>
										<li><a href="#" id="changePeriodButton">Period</a></li>
										<li><a href="#" id="changeRoomButton">Room</a></li>
										<li><a href="#" id="changePasswordButton">Password</a></li>
									</ul>
								</div>
                                    								
								<button type="button" class="btn btn-default m-b-5" id="loginBlockButton">Signin Block</button>
								<button type="button" class="btn btn-default m-b-5" id="deleteButton">Delete</button>
                            </div>

							<div class="panel-body">
								<div class="row">
									<div class="col-md-12">
										<h3 class="">Student Academic Information</h3>
									</div>
								</div>
								
								<div class="row">
									<div class="col-sm-6">
										<div class="row">
											<div class="form-group">
												<label class="col-md-5 control-label">Batch</label>
												<div class="radio-inline">
													<p id="term"></p>
												</div>
											</div> <!-- form-group -->
										</div>

										<div class="row">
											<div class="form-group">
												<label class="col-md-5 control-label">Student ID</label>
												<div class="radio-inline">
													<p id="studentId"></p>
												</div>
											</div> <!-- form-group -->
										</div>

										<div class="row">
											<div class="form-group">
												<label class="col-md-5 control-label">Course / Request</label>
												<div class="radio-inline">
													<p id="course"></p>
												</div>
											</div> <!-- form-group -->
										</div>

										<div class="row">
											<div class="form-group">
												<label class="col-md-5 control-label">Period</label>
												<div class="radio-inline">
													<p id="periedDate"></p>
												</div>
											</div> <!-- form-group -->
										</div>
										
										<div class="row">
											<div class="form-group">
												<label class="col-md-5 control-label">Campus</label>
												<div class="radio-inline">
													<p id="campus"></p>
												</div>
											</div> <!-- form-group -->
										</div>
										<div class="row">
											<div class="form-group">
												<label class="col-md-5 control-label">Level</label>
												<div class="radio-inline">
													<p id="level"></p>
												</div>
											</div> <!-- form-group -->
										</div>
										<div class="row">
											<div class="form-group">
												<label class="col-md-5 control-label">Serial Number of Student's ID Card</label>
												<div class="radio-inline">
													<p id="idCardSerialNumber"></p>
												</div>
											</div> <!-- form-group -->
										</div>
										<div class="row">
											<div class="form-group">
												<label class="col-md-5 control-label">Room</label>
												<div class="radio-inline">
													<p id="room"></p>
												</div>
											</div> 
										</div>
									</div> <!-- right div -->
									
									<div class="col-sm-6 text-center">
										<div class="row text-center" id="profileArea">
										</div>
										<div class="row" style="margin-top: 5px">
			                                <div class="fileUpload btn btn-default m-b-5">
			                                    <span>Upload Profile Picture</span>
			                                    <input type="file" class="upload" id="profilePictureFile" accept=".png,.jpg,.jpeg"/>
			                                </div>
										</div>
									</div> <!-- left div -->
								</div> <!-- end row -->
							</div> <!-- end panel body -->
						</div> <!-- end panel panel-default -->
					</div> <!-- end col-md-12 -->
	            </div> <!-- end row -->
	            </form>
	            
	            <form class="form-horizontal" role="form" id="detailForm">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading text-right ">
								<button type="button" class="btn btn-default m-b-5" id="saveButton">Save</button>
								<button type="button" class="btn btn-default m-b-5" id="resetButton">Reset</button>
                            </div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-12">
										<h3 class="">Personal Information</h3>
									</div>
								</div>
								
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Nationality</label>
										<div class="col-md-10">
											<div class="col-md-5" id="nationalityDiv">
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Passport SurName</label>
										<div class="col-md-10">
											<div class="col-md-5">
												<input type="text" class="form-control" value="" placeholder="Surname" id="surname">
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Passport Given Names</label>
										<div class="col-md-10">
											<div class="col-md-5">
												<input type="text" class="form-control" value="" placeholder="Given Names" id="givenNames">
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Name *</label>
										<div class="col-md-10">
											<div class="col-md-5">
												<input type="text" class="form-control" value="" placeholder="Name" id="name" required>
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
								
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Day of Birth *</label>
										<div class="col-md-10">
											<div class="col-md-2 input-group" style="margin-left: 10px">
												<input type="text" class="form-control" placeholder="mm/dd/yyyy" id="datepicker" required>
												<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
											</div><!-- input-group -->
										</div>
									</div> <!-- form-group -->
								</div>

								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Sex</label>
										<div class="col-md-10">
											<div class="radio-inline">
												<label class="cr-styled" for="sex">
													<input type="radio" id="sexF" name="sex" value="F"> 
													<i class="fa"></i>
													Female 
												</label>
											</div>
											<div class="radio-inline">
												<label class="cr-styled" for="sex">
													<input type="radio" id="sexM" name="sex" value="M"> 
													<i class="fa"></i>
													Male 
												</label>
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Local Contact</label>
										<div class="col-md-10">
											<div class="col-md-5">
												<input type="text" placeholder="Local Contact" class="form-control" id="localContact">
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">E-mail</label>
										<div class="col-md-10">
											<div class="col-md-5">
												<input type="email" class="form-control" id="email" placeholder="E-mail">
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Emergency Contact<br>(in their country)</label>
										<div class="col-md-10" style="margin-top:10px;">
											<div class="col-md-5">
												<input type="text" placeholder="Emergency Contact" class="form-control" id="emergencyContact">
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Relationship with the Emergency Contact</label>
										<div class="col-md-10" style="margin-top:10px;">
											<div class="col-md-5">
												<select class="form-control" name="relationshipWithContact" id="relationshipWithContact">
													<option value="family">Family</option>
													<option value="spouse">Spouse</option>
												</select>														
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Messenger</label>
										<div class="col-md-10">
											<div class="col-md-5">
												<select class="form-control" name="messengerType" id="messengerType">
												<option value="kakao">Kakao Talk</option>
												<option value="line">Line</option>
												<option value="wechat">WeChat</option>
												<option value="viber">Viber</option>
												<option value="skype">Skype</option>
												<option value="facebook">Facebook Messenger</option>
												<option value="zalo">Zalo</option>
												</select>		
												<input type="text" class="form-control" value="" placeholder="Messenger ID"  id="messengerId">
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">English Names</label>
										<div class="col-md-10">
											<div class="col-md-5">
												<input type="text" class="form-control" value="" placeholder="English Names" id="englishName">
											</div>
										</div>
									</div> <!-- form-group -->
								</div>
							</div> <!-- end panel-body -->
						</div>
					</div>
				</div> <!-- end row -->

                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-12">
										<h3 class="" id="requestHead">Requests</h3>
									</div>
								</div>
                            
								<div class="row">
									<div class="col-md-12 col-sm-12 col-xs-12">
										<table class="table">
                                            <thead>
                                                <tr>
                                                    <th class="text-center" width="5%">No</th>
                                                    <th class="text-center" width="10%">Date Requested</th>
                                                    <th class="text-center" width="40%">Request</th>
                                                    <th class="text-center" width="40%">Reply</th>
                                                    <th class="text-center" width="5%">Delete</th>
                                                </tr>
                                            </thead>
											<tbody id="requestTbody">
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div> <!-- end row -->
				
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-12">
										<h3 class="">Student's Request</h3>
									</div>
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Room Type</label>
										<div class="col-md-10 radio-inline">
											<p id="requestRoomType"></p>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Cource</label>
										<div class="col-md-10 radio-inline">
											<p id="requestCourse"></p>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Remarks</label>
										<div class="col-md-10 radio-inline">
											<p id="requestMemo"></p>
										</div>
									</div> <!-- form-group -->
								</div>
							</div> <!-- end panel-body -->
						</div>
					</div>
				</div> <!-- end row -->
				
				
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-12">
										<h3 class="">Study Background</h3>
									</div>
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">English Level</label>
										<div class="col-md-10 radio-inline">
											<p id="selfEnglishLevel"></p>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Major in English</label>
										<div class="col-md-10 radio-inline">
											<p id="majorInEnglish"></p>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Official English Test Score</label>
										<div class="col-md-10 radio-inline">
											<p id="officialTestScore"></p>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Experiences in studying English abroad or online</label>
										<div class="col-md-10 radio-inline">
											<p id="studyExperience">None</p>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Plans of Studying Abraod</label>
										<div class="col-md-10 radio-inline">
											<p id="plansOfStudyingAbraod"></p>
										</div>
									</div> <!-- form-group -->
								</div>
                            
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Purpose of Studying</label>
										<div class="col-md-10 radio-inline">
											<p id="purposeOfStudying"></p>
										</div>
									</div> <!-- form-group -->
								</div>
							</div> <!-- end panel-body -->
						</div>
					</div>
				</div> <!-- end row -->

                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-12">
										<h3 class="">Study / Campus Information</h3>
									</div>
								</div>
								
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Mandatory / Option Classes</label>
										<div class="col-md-10 radio-inline">
											<p id="studyExperience">- / -</p>
										</div>
									</div> <!-- form-group -->
								</div>
								
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Violations</label>
										<div class="col-md-10 radio-inline">
											<p id="studyExperience">- / -</p>
										</div>
									</div> <!-- form-group -->
								</div>
								
								<div class="row">
									<div class="form-group">
										<label class="col-md-2 control-label">Trips</label>
										<div class="col-md-10 radio-inline">
											<p id="studyExperience">- / -</p>
										</div>
									</div> <!-- form-group -->
								</div>
							</div> <!-- end panel-body -->
						</div>
					</div>
				</div> <!-- end row -->

				</form>
            </div>
            <!-- Page Content Ends -->
            <!-- ================== -->
            
<form id="registerIdCardForm">
<div id="registerIdCard" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
	<div class="modal-dialog modal-lg"> 
		<div class="modal-content"> 
			<div class="modal-header"> 
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button> 
				<h4 class="modal-title">Register Student's ID Card</h4> 
			</div> 
			<div class="modal-body">
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-2" class="col-md-4 control-label">Student's ID</label>
							<div class="col-md-8 radio-inline">
								<p id="registerIdCardStudentId"></p>
							</div>
						</div> 
					</div> 
				</div>
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-3" class="col-md-4 control-label">Student's Name</label> 
							<div class="col-md-8 radio-inline">
								<p id="registerIdCardStudentName"></p>
							</div>
						</div> 
					</div> 
				</div>
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-4" class="col-md-4 control-label">Serial Number of Student's ID Card</label> 
							<div class="col-md-4 radio-inline">
								<input type="text" placeholder="" class="form-control" id="registerIdCardSerialNumber" required maxlength="50">
							</div>
						</div> 
					</div> 
				</div>
				<div class="row"> 
					<div class="col-md-12"> 
						<div class="form-group"> 
							<label for="field-4" class="col-md-4 control-label">Reason</label>
							<div class="col-md-8" id="registerIdCardReasonDiv">
								<div class="col-md-6">
									<select class="form-control" name="registerIdCardReason" id="registerIdCardReason" style="margin-left: -10px;" required>
									<option value="">Select..</option>
									<option value="New">New</option>
									<option value="Lost">Lost</option>
									<option value="Broken">Broken</option>
									<option value="Etc">Etc</option>
									</select>		
								</div>							
							</div> 
						</div> 
					</div> 
					<div class="col-md-12" id="registerIdCardMemoDiv" style="margin-top:10px;display: none;"> 
						<div class="form-group"> 
							<label for="field-4" class="col-md-4 control-label"></label>
							<div class="col-md-8">
								<input type="text" class="form-control" value="" placeholder=""  id="registerIdCardMemo" required maxlength="1000">
							</div>							
						</div> 
					</div> 
				</div>
			</div> 
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="registerIdCardSaveButton">Save</button>
			</div>			
		</div> 
	</div>
</div><!-- /.modal -->
</form>

<form id="sendMessageForm">
<div id="sendMessageDiv" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
	<div class="modal-dialog modal-lg"> 
		<div class="modal-content"> 
			<div class="modal-header"> 
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button> 
				<h4 class="modal-title">Send a Message to the student</h4> 
			</div> 
			<div class="modal-body">
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-3" class="col-md-2 control-label">Student's Name</label> 
							<div class="col-md-8 radio-inline">
								<p id="sendMessageStudentName"></p>
							</div>
						</div> 
					</div> 
				</div>
				<div class="row">
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-4" class="col-md-2 control-label">Message</label> 
							<div class="col-md-10 radio-inline">
								<input type="text" placeholder="" class="form-control" id="sendMessageMessage" required maxlength="50">
								<input type="hidden" id="isCanPushMessage">
							</div>
						</div> 
					</div> <!-- form-group -->
				</div>
			</div> 
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="sendMessageSendButton">Send</button>
			</div>			
		</div> 
	</div>
</div><!-- /.modal -->
</form>
<form id="changePasswordForm">
<div id="changePassword" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
	<div class="modal-dialog modal-lg"> 
		<div class="modal-content"> 
			<div class="modal-header"> 
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button> 
				<h4 class="modal-title">Change Student's Password</h4> 
			</div> 
			<div class="modal-body">
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-2" class="col-md-2 control-label">Student's ID</label>
							<div class="col-md-8 radio-inline">
								<p id="changePasswordStudentId"></p>
							</div>
						</div> 
					</div> 
				</div>
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-3" class="col-md-2 control-label">Student's Name</label> 
							<div class="col-md-8 radio-inline">
								<p id="changePasswordStudentName"></p>
							</div>
						</div> 
					</div> 
				</div>
				<div class="row">
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-4" class="col-md-2 control-label">New Password</label> 
							<div class="col-md-8 radio-inline">
								<input type="password" placeholder="" class="form-control" id="changeNewPassword" required maxlength="10">
							</div>
						</div> 
					</div> <!-- form-group -->
				</div>
			</div> 
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="changePasswordSaveButton">Save</button>
			</div>			
		</div> 
	</div>
</div><!-- /.modal -->
</form>
<form id="changeRoomForm">
<div id="changeRoom" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
	<div class="modal-dialog modal-lg"> 
		<div class="modal-content"> 
			<div class="modal-header"> 
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button> 
				<h4 class="modal-title">Change Student's Room</h4> 
			</div> 
			<div class="modal-body">
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-2" class="col-md-2 control-label">Student's ID</label>
							<div class="col-md-8 radio-inline">
								<p id="changeRoomStudentId"></p>
							</div>
						</div> 
					</div> 
				</div>
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-3" class="col-md-2 control-label">Student's Name</label> 
							<div class="col-md-8 radio-inline">
								<p id="changeRoomStudentName"></p>
							</div>
						</div> 
					</div> 
				</div>
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-3" class="col-md-2 control-label">Original Room</label> 
							<div class="col-md-8 radio-inline">
								<p id="changeRoomOriginalRoom"></p>
							</div>
						</div> 
					</div> 
				</div>
				<div class="row">
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-4" class="col-md-2 control-label">New Room</label> 
							<div class="col-md-8 radio-inline">
								<input type="text" placeholder="" class="form-control" id="changeRoomNewRoom" required maxlength="10">
							</div>
						</div> 
					</div> <!-- form-group -->
				</div>
			</div> 
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="changeRoomSaveButton">Save</button>
			</div>			
		</div> 
	</div>
</div><!-- /.modal -->
</form>

<form id="changePeriodForm">
<div id="changePeriod" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
	<div class="modal-dialog modal-lg"> 
		<div class="modal-content"> 
			<div class="modal-header"> 
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button> 
				<h4 class="modal-title">Change Student's Study Period</h4> 
			</div> 
			<div class="modal-body">
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-2" class="col-md-2 control-label">Student's ID</label>
							<div class="col-md-8 radio-inline">
								<p id="changePeriodStudentId"></p>
							</div>
						</div> 
					</div> 
				</div>
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-3" class="col-md-2 control-label">Student's Name</label> 
							<div class="col-md-8 radio-inline">
								<p id="changePeriodStudentName"></p>
							</div>
						</div> 
					</div> 
				</div>
				<div class="row"> 
					<div class="col-md-12" style="margin-top:10px"> 
						<div class="form-group"> 
							<label for="field-3" class="col-md-2 control-label">Original Period</label> 
							<div class="col-md-8 radio-inline">
								<p id="changePeriodOriginalPeriod"></p>
							</div>
						</div> 
					</div> 
				</div>
				<div class="row">
					<div class="col-md-12" style="margin-top:10px"> 
						<label class="col-md-2 control-label">New Period</label>
						<div class="col-md-10 form-inline">
							<div class="col-md-3 input-group">
								<input type="text" class="form-control input-sm" placeholder="mm/dd/yyyy" id="newPeriodStartDate" name="newPeriodStartDate" required aria-required="true">
								<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
							</div><!-- input-group -->
							~
							<div class="col-md-3 input-group">
								<input type="text" class="form-control input-sm" placeholder="mm/dd/yyyy" id="newPeriodEndDate" name="newPeriodEndDate" required aria-required="true">
								<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
							</div><!-- input-group -->
						</div>
					</div> <!-- form-group -->
				</div>
			</div> 
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="changePeriodSaveButton">Save</button>
			</div>			
		</div> 
	</div>
</div><!-- /.modal -->
</form>


            <!-- Footer Start -->
	        <%@ include file = "/include/footer.jsp" %>
            <!-- Footer Ends -->



        </section>
        <div id="api_mask"></div>
        <!-- Main Content Ends -->
        <%@ include file = "student-modal.jsp" %>


        <!-- js placed at the end of the document so the pages load faster -->
        <script src="/js/jquery.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="/js/modernizr.min.js"></script>
        <script src="/js/pace.min.js"></script>
        <script src="/js/wow.min.js"></script>
        <script src="/js/jquery.scrollTo.min.js"></script>
        <script src="/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="/assets/chat/moment-2.2.1.js"></script>

        <!--form validation -->
        <script src="/assets/jquery.validate/jquery.validate.js"></script>
        
        <!-- sweet alerts -->
        <script src="/assets/sweet-alert/sweet-alert.min.js"></script>
        <script src="/assets/sweet-alert/sweet-alert.init.js"></script>

        <script src="/js/jquery.app.js"></script>
        <script src="/js/jquery.twbsPagination.js"></script>

        <script src="/assets/bootstrap-inputmask/bootstrap-inputmask.min.js" type="text/javascript"></script>

        <script src="/assets/timepicker/bootstrap-datepicker.js"></script>
        
        <!-- Modal-Effect -->
        <script src="/assets/modal-effect/js/classie.js"></script>
        <script src="/assets/modal-effect/js/modalEffects.js"></script>
        
        <script src="/js/jquery.session.js"></script>
        <script src="/js/jquery.cookie.js"></script>
        <script src="/custom/pia-ajaxs.js"></script>
        <script src="/custom/pia-tools.js"></script>
        <script src="/js/md5.min.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function() {
           		initPlugins();

                getNationalitiesData();
                
                $("#changePasswordButton").on("click", showChangePassword);
                $("#changePasswordSaveButton").on("click", changePassword);
                $("#changeRoomButton").on("click", showChangeRoom);
                $("#changeRoomSaveButton").on("click", changeRoom);
                $("#changePeriodButton").on("click", showChangePeriod);
                $("#changePeriodSaveButton").on("click", changePeriod);
                $("#registerIdCardButton").on("click", showRegisterIdCard);
                $("#registerIdCardSaveButton").on("click", registerIdCard);
                $("#loginBlockButton").on("click", block);
                $("#deleteButton").on("click", deleteStudent);
                $("#sendMessageButton").on("click", showSendMessage);
                $("#sendMessageSendButton").on("click", sendMessage);
                $("#saveButton").on("click", save);
                
                $("#profilePictureFile").change(profilePictureFileUpload);
                $("#registerIdCardReason").change(function() {
               		if ($(this).val() == "Etc") {
                		$("#registerIdCardMemoDiv").show();
                		$("#registerIdCardMemo").focus();
                		$("#registerIdCardMemo").attr("required", true);
					} else {
                		$("#registerIdCardMemoDiv").hide();
                		$("#registerIdCardMemo").attr("required", false);
                		$("#registerIdCardMemo").val("");
					}
                });
                
                $("#sendMessageDiv").on("shown.bs.modal", function () {
                    $("#sendMessageMessage").focus();
                })
                $("#registerIdCard").on("shown.bs.modal", function () {
                    $("#registerIdCardSerialNumber").focus();
                })
                $("#changeRoom").on("shown.bs.modal", function () {
               		$("#changeRoomNewRoom").focus();
                })
                $("#changePassword").on("shown.bs.modal", function () {
               		$("#changeNewPassword").focus();
                })
                
                $("#registerIdCardMemo").keydown(function() {
               		if ($(this).val() == "") {
               			$("#registerIdCardMemo").css("border","1px solid red");
					} else {
               			$("#registerIdCardMemo").css("border","");
					}
                });
            });

            function initPlugins() {
        		var defaultDetepickerOptions = {format : "yyyy/mm/dd"};
        		$("#newPeriodStartDate").datepicker(defaultDetepickerOptions).on("changeDate", fncOnChangeDate);
        		$("#newPeriodEndDate").datepicker(defaultDetepickerOptions).on("changeDate", fncOnChangeDate);
        		$("#datepicker").datepicker(defaultDetepickerOptions).on("changeDate", fncOnChangeDate);
            }
            
            function fncOnChangeDate(e) {
			    $(this).datepicker("hide");
            }
            
            function profilePictureFileUpload() {
        		if (!$("#profilePictureFile")[0].files[0]) {
					return;
				}
	        		
   	    		var studentId = getUrlParameter("studentId");
   	    		if (!studentId) {
   	    			openSwal("Failed.", "[Lack of Data.]");
					return false;
				}
	        		
				var formData = new FormData();
				formData.append("studentName", $("#name").val());
				formData.append("term", $("#term").text());
				formData.append("profile", $("#profilePictureFile")[0].files[0]);
				
	            var url = "<%=SERVER_URL%>/students/" + studentId + "/upload/profile";
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "POST",
            		data : formData,
            		dataType : "json",
            		enctype: 'multipart/form-data',
            		processData: false,
            		contentType: false,
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
            		success : function(data, textStatus, jqXHR) {
        				if (data.head.status == 200) {
        					if (data.body.totalCount > 0) {
        						var alertMessage = "Some Information are Failed to Insert the Database. \n[";
        						var duplicationStudentCount = data.body.data.duplicationStudentCount;
        						var insertFailedStudentCount = data.body.data.insertFailedStudentCount;
        						if (duplicationStudentCount > 0) {
        							alertMessage += "Duplication Students : " + duplicationStudentCount;
								}
        						if (insertFailedStudentCount > 0) {
        							alertMessage += "Insert Failed Students : " + insertFailedStudentCount;
								}
        						alertMessage += "]";

        						console.log("duplicationStudents : ", data.body.data.duplicationStudents);
        						console.log("insertFailedStudents : ", data.body.data.insertFailedStudents);
	        					openSwal("Some Information are Failed to Insert the Database.", alertMessage, search);
							} else {
	        					openSwal(data.head.message, "", function() {
	        						getDetailData();
	        					});
							}
   	        			} else if (data.head.status == 401) {
      						openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
      							window.location.replace("/login.jsp");
      						});
        				} else {
        					openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
        				}
            		},
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
            		},
					complete : function(jqXHR, textStatus) {
						$("#profilePictureFile").val("");
						closeWindowByMask();
					}
            	});
	        }
            
            function showSendMessage() {
            	if (!getBoolean($("#isCanPushMessage").val())) {
            		alert("The student did not install pines portal application on his phone, so you cannot send a messsage.");
					return false;
				}
            	
           		$("#sendMessageStudentName").text($("#name").val());
           		$("#sendMessageDiv").modal();
            }
            
            function sendMessage() {
   	    		var studentId = getUrlParameter("studentId");
   	    		if (!studentId) {
   	    			openSwal("Failed.", "[Lack of Data.]");
					return false;
				}

        		var firstCheck = $("#sendMessageForm").valid();
	       		if (!firstCheck) {
					return false;	
				}

				var params = {
					message : $("#sendMessageMessage").val(),
					menu : "Student > Student Detail",
					site : "<%=PORTAL_URL%>/02_04_00_campus.html"
				};
				var jsonParams = JSON.stringify(params);
        		var url = "<%=SERVER_URL%>/students/" + studentId + "/push";
	           	$.ajax({
	           		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	           		url : url,
	           		data : jsonParams,
	           		type : "POST",
	           		dataType : "json",
	           		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
	   				success : function(data, textStatus, jqXHR) {
        				if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
		   						return false;
							});
       					}
        				
        				openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function () {
        					$("#sendMessageMessage").val("");
        					$("#sendMessageDiv").modal("hide");
        				});
   	        		},
	           		error : function(jqXHR, textStatus, errorThrown) {
	           			console.log(jqXHR, textStatus, errorThrown);
	           		},
	   				complete : function(jqXHR, textStatus) {
       					$("#sendMessageDiv").modal("hide");
	   					closeWindowByMask();
	   				}
	           	});
            }
            
            function showChangePassword() {
           		$("#changePasswordStudentId").text(getUrlParameter("studentId"));
           		$("#changePasswordStudentName").text($("#name").val());
           		$("#changePassword").modal();
            }

            function changePassword() {
   	    		var studentId = getUrlParameter("studentId");
   	    		if (!studentId) {
   	    			openSwal("Failed.", "[Lack of Data.]");
					return false;
				}

        		var firstCheck = $("#changePasswordForm").valid();
	       		if (!firstCheck) {
					return false;	
				}

				var params = {
					newPassword : md5($("#changeNewPassword").val())
				};
				var jsonParams = JSON.stringify(params);
        		var url = "<%=SERVER_URL%>/students/" + studentId + "/change/password";
	           	$.ajax({
	           		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	           		url : url,
	           		data : jsonParams,
	           		type : "POST",
	           		dataType : "json",
	           		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
	   				success : function(data, textStatus, jqXHR) {
        				openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function () {
        					$("#changePassword").modal("hide");
        				});
	        				
        				if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
		   						return false;
							});
       					}
   	        		},
	           		error : function(jqXHR, textStatus, errorThrown) {
	           			console.log(jqXHR, textStatus, errorThrown);
	           		},
	   				complete : function(jqXHR, textStatus) {
       					$("#changePassword").modal("hide");
	   					closeWindowByMask();
	   				}
	           	});
            }
            
            function showChangeRoom() {
           		$("#changeRoomStudentId").text(getUrlParameter("studentId"));
           		$("#changeRoomStudentName").text($("#name").val());
           		$("#changeRoomOriginalRoom").text($("#room").text());
           		$("#changeRoom").modal();
            }

            function changeRoom() {
   	    		var studentId = getUrlParameter("studentId");
   	    		if (!studentId) {
   	    			openSwal("Failed.", "[Lack of Data.]");
					return false;
				}

        		var firstCheck = $("#changeRoomForm").valid();
	       		if (!firstCheck) {
					return false;	
				}
	   	    		
	       		var roomName = $("#changeRoomNewRoom").val();
        		var url = "<%=SERVER_URL%>/students/" + studentId + "/rooms/" + roomName;
	           	$.ajax({
	           		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	           		url : url,
	           		type : "PUT",
	           		dataType : "json",
	           		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
	   				success : function(data, textStatus, jqXHR) {
        				openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function () {
        					getDetailData();
        					$("#changeRoom").modal("hide");
        				});
        				
        				if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
		   						return false;
							});
        				}
   	        		},
	           		error : function(jqXHR, textStatus, errorThrown) {
	           			console.log(jqXHR, textStatus, errorThrown);
	           		},
	   				complete : function(jqXHR, textStatus) {
       					$("#changeRoom").modal("hide");
	   					closeWindowByMask();
	   				}
	           	});
            }

            function showChangePeriod() {
           		$("#changePeriodStudentId").text(getUrlParameter("studentId"));
           		$("#changePeriodStudentName").text($("#name").val());
           		$("#changePeriodOriginalPeriod").text($("#periedDate").text());
           		$("#newPeriodStartDate").datepicker("setDate", "");
           		$("#newPeriodEndDate").datepicker("setDate", "");
           		$("#changePeriod").modal();
            }

            function changePeriod() {
   	    		var studentId = getUrlParameter("studentId");
   	    		if (!studentId) {
   	    			openSwal("Failed.", "[Lack of Data.]");
					return false;
				}

        		var firstCheck = $("#changePeriodForm").valid();
	       		if (!firstCheck) {
					return false;	
				}
	   	    		
        		var url = "<%=SERVER_URL%>/students/" + studentId + "/change/period";
	           	$.ajax({
	           		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	           		url : url,
	           		data : getChangePeriodJson(),
	           		type : "PUT",
	           		dataType : "json",
	           		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
	   				success : function(data, textStatus, jqXHR) {
        				openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function () {
        					getDetailData();
        					$("#changePeriod").modal("hide");
        				});
        				
        				if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
		   						return false;
							});
        				}
    	        	},
	           		error : function(jqXHR, textStatus, errorThrown) {
	           			console.log(jqXHR, textStatus, errorThrown);
	           		},
	   				complete : function(jqXHR, textStatus) {
       					$("#changePeriod").modal("hide");
	   					closeWindowByMask();
	   				}
	           	});
            }

            function getChangePeriodJson() {
				var newPeriodStartDate = $("#newPeriodStartDate").val();
				var newPeriodEndDate = $("#newPeriodEndDate").val();
				var params = {
					newPeriodStartDate : newPeriodStartDate,
					newPeriodEndDate : newPeriodEndDate
				};
    			
				return JSON.stringify(params);
            }
            
            function showRegisterIdCard() {
           		$("#registerIdCardStudentId").text(getUrlParameter("studentId"));
           		$("#registerIdCardStudentName").text($("#name").val());
           		$("#registerIdCardReason").val("");
           		$("#registerIdCardMemo").val("");
           		$("#registerIdCardSerialNumber").val("");
           		$("#registerIdCardMemoDiv").hide();
           		
           		$("#registerIdCard").modal();
            }
            
            function registerIdCard() {
   	    		var studentId = getUrlParameter("studentId");
   	    		if (!studentId) {
   	    			openSwal("Failed.", "[Lack of Data.]");
					return false;
				}

        		var firstCheck = $("#registerIdCardForm").valid();
	       		if (!firstCheck) {
					return false;	
				}
	       		
        		var secondCheck = $("#registerIdCardMemo").attr("required");
        		if (secondCheck && $("#registerIdCardMemo").val() == "") {
        			$("#registerIdCardMemo").css("border","1px solid red");
        			$("#registerIdCardMemo").focus();
					return false;	
				}
	   	    		
        		var url = "<%=SERVER_URL%>/students/" + studentId + "/change/idcard";
	           	$.ajax({
	           		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
	           		url : url,
	           		data : getRegisterIdCardJson(),
	           		type : "PUT",
	           		dataType : "json",
	           		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
	   				success : function(data, textStatus, jqXHR) {
        				openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function () {
        					getDetailData();
        					$("#registerIdCard").modal("hide");
        				});
        				
        				if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
		   						return false;
							});
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
            
            function getRegisterIdCardJson() {
				var idCardSerialNumber = $("#registerIdCardSerialNumber").val();
				var reasonType = $("#registerIdCardReason").val();
				var memo = $("#registerIdCardMemo").val();
				
				var params = {
						idCardSerialNumber : idCardSerialNumber,
						reasonType : reasonType,
						memo : memo
				};
    			
				return JSON.stringify(params);
            }
            
            function deleteStudent() {
   	    		var studentId = getUrlParameter("studentId");
   	    		if (!studentId) {
   	    			openSwal("Failed.", "[Lack of Data.]");
					return false;
				}
	   	    		
        		var url = "<%=SERVER_URL%>/students/" + studentId;
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
	       				openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function () {
	  						window.location.replace("/student/studentList.jsp");
	       				});
	       				
	       				if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
		   						return false;
							});
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
            
            function block() {
           		changeLoginBlocking(true);
            }
            
            function unblock() {
           		changeLoginBlocking(false);
            }
            
            function changeLoginBlocking(isBlock) {
   	    		var studentId = getUrlParameter("studentId");
   	    		if (!studentId) {
   	    			openSwal("Failed.", "[Lack of Data.]");
					return false;
				}
	   	    		
       			var url = "<%=SERVER_URL%>/students/" + studentId;
           		if (isBlock) {
   	        		url += "/state/block";
				} else {
   	        		url += "/state/unblock";
				}
            		
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
       					openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
   						if (data.head.status == 200) {
		        			if (isBlock) {
		        				$("#loginBlockButton").off("click");
		        				$("#loginBlockButton").click(unblock);
		        				$("#loginBlockButton").text("Signin Unblock");
							} else {
		        				$("#loginBlockButton").off("click");
		        				$("#loginBlockButton").click(block);
		        				$("#loginBlockButton").text("Signin Block");
							}
        				} else if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
		   						return false;
							});
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
            
            function save() {
    			var studentId = getUrlParameter("studentId");
  	    		if (!studentId) {
  	    			openSwal("Failed.", "[Lack of Data.]");
					return false;
				}
	   	    		
        		var firstCheck = $("#detailForm").valid();
	       		if (!firstCheck) {
					return false;	
				}

   	    		var url = "<%=SERVER_URL%>/students/" + studentId + "/change";
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
        				openSwal(data.head.message, "[Status Code : " + data.head.status + "]");
        				if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
		   						return false;
							});
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

        	function getJsonData() {
        		return JSON.stringify({
        			"nationality" : $("#nationality option:selected").val(),
        			"name" : $("#name").val(),
        			"passportSurname" : $("#surname").val(),
        			"passportGivennames" : $("#givenNames").val(),
        			"sex" : $("#sex:checked").val(),
        			"dateOfBirth" : $("#datepicker").val(),
        			"emergencyContact" : $("#emergencyContact").val(),
        			"relationshipWithEmergencyContact" : $("#relationshipWithContact").val(),
        			"localContact" : $("#localContact").val(),
        			"email" : $("#email").val(),
        			"messengerType" : $("#messengerType option:selected").val(),
        			"messengerId" : $("#messengerId").val(),
        			"englishName" : $("#englishName").val()
        		});
        	}
	        	
		    function getNationalitiesData() {
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
    	            		gridNationalities(data.body.data)
    	        		}
    	        	},
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
            		},
	   				complete : function(jqXHR, textStatus) {
	   					getDetailData();
	   				}
            	});
		    }
		    
		    function gridNationalities(response) {
				var $data = response;
				//console.log($data);
				
				var html = "";
				html += "<select class=\"form-control\" name=\"nationality\" id=\"nationality\"s>";
				$.each($data, function(index, item) {
	    				html += "<option value=\"" + item.seq + "\">" + item.name + "</option>";
				});
				html += "</select>";
				html += "";
				
				$("#nationalityDiv").append(html);
		    }

            function getDetailData() {
				var branchSeq = getUrlParameter("branchSeq");
				var studentId = getUrlParameter("studentId");
				if (!studentId || !branchSeq) {
					alert("lack of data.");
					window.history.back(1);
				}

				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/students/" + studentId;
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "GET",
            		dataType : "json",
            		contentType : "application/json; charset=UTF-8",
            		success : getDetailSuccessFnc,
            		error : function(jqXHR, textStatus, errorThrown) {
            			console.log(jqXHR, textStatus, errorThrown);
            			closeWindowByMask();
	   				}
            	});
            }

            function getDetailSuccessFnc(response) {
        		if (response.head.status == 200) {
        			var $data = response.body.data;
        			if (response.body.totalCount > 0) {
	        			console.log("data : ", $data);
	        			if (getBoolean($data.isBlocked)) {
	        				$("#loginBlockButton").off("click");
	        				$("#loginBlockButton").click(unblock);
	        				$("#loginBlockButton").text("Signin Unblock");
						} else {
	        				$("#loginBlockButton").off("click");
	        				$("#loginBlockButton").click(block);
	        				$("#loginBlockButton").text("Signin Block");
						}
	        			
	        			$("#term").text($data.term);
	        			setSelecValue("group", $data.groupSeq);
	        			$("#studentId").text($data.studentId);
	        			if ($data.visaRegisteredDate && $data.visaExpireDate) {
		        			$("#visaDates").text("Registered Date : " + $data.visaRegisteredDate + " / Expire Date : " + $data.visaExpireDate);
						}
	        			$("#course").text($data.course + " / " + $data.requestCourse);
	        			$("#periedDate").text($data.termStartDate + " ~ " + $data.termEndDate + " (" + $data.weeks + " Weeks)");
	        			$("#campus").text($data.campus);
	        			$("#level").text($data.level);
	        			$("#idCardSerialNumber").text($data.idCardSerialNumber);
	        			$("#room").text($data.room);
	        			
	        			if ($data.profilePath) {
		        			var imgSrc = "<%=SERVER_URL%>/filedownload?filePath=" + $data.profilePath;
		        			$("#profileArea").empty();
		        			$("#profileArea").append("<img src=\"" + imgSrc + "\" alt=\"\" style=\"width:200px;height:300px\" class=\"br-radius\">");
						}
	        			
	        			setSelecValue("nationality", $data.nationalitySeq);
	        			$("#surname").val($data.surName);
	        			$("#givenNames").val($data.givenNames);
	        			$("#englishName").val($data.englishName);
	        			$("#name").val($data.name);
	        			setRadioValue("sex", $data.sex);
	        			if ($data.dayOfBirth == "0000/00/00") {
						$("#datepicker").datepicker("setDate", "");
						} else {
		        			$("#datepicker").datepicker("setDate", $data.dayOfBirth);
						}
	        			$("#localContact").val($data.localContact);
	        			$("#email").val($data.email);
	        			$("#emergencyContact").val($data.emergencyContact);
	        			$("#relationshipWithContact").val($data.relationshipWithContact);
	        			setSelecValue("messengerType", $data.messengerType);
	        			$("#messengerId").val($data.messengerId);
	        			
	        			$("#requestRoomType").text($data.requestRoomType);
	        			$("#requestCourse").text($data.requestCourse);
	        			$("#requestMemo").text($data.requestMemo);

	        			$("#selfEnglishLevel").text($data.selfEnglishLevel);
	        			$("#majorInEnglish").text($data.englishMajor);
	        			$("#officialTestScore").text($data.officialTestScore);
	        			$("#studyExperience").text($data.beforeStudyExperience);
	        			$("#plansOfStudyingAbraod").text($data.plansOfStudyingAbraod);
	        			$("#purposeOfStudying").text($data.purposeOfStudying);
	        			$("#isCanPushMessage").val(getBoolean($data.isCanPushMessage));

	        			gridRequestDiv($data);
					}
        		} else if (response.head.status == 401) {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]", function() {
						window.location.replace("/login.jsp");
					});
				} else {
					openSwal(response.head.message, "[Status Code : " + response.head.status + "]");
				}
        		
        		closeWindowByMask();
        	}
            
            function gridRequestDiv($data) {
    			var html = "";
    			var requestNo = $data.totalRequests;
    			$("#requestTbody").empty();
    			var countNotYetReply = 0;
    			$.each($data.requests, function (requestIndex, requestItem) {
        			html = "";
        			
        			if (getBoolean(requestItem.isReply)) {
	        			html += "<tr>";
					} else {
	        			html += "<tr class=\"danger\">";
	        			countNotYetReply++;
					}
	        			
        			html += "<td class=\"text-center\" style=\"vertical-align:middle;\">" + (requestNo--) + "</td>";
        			html += "<td class=\"text-center\" style=\"vertical-align:middle;\">" + requestItem.registerDate + "</td>";
        			html += "<td style=\"vertical-align:middle;\"><b>[" + requestItem.requestType + "]</b> " + requestItem.detail + "</td>";
        			
        			if (getBoolean(requestItem.isReply)) {
	        			html += "<td style=\"vertical-align:middle;\">" + requestItem.reply + "</td>";
        			} else {
	        			html += "<td style=\"vertical-align:middle;\">";
	        			//html += "<div class=\"input-group\">";
	        			//html += "<input type=\"text\" class=\"form-control\" id=\"replyDetail\">";
	        			//html += "<span class=\"input-group-addon btn btn-default btn-xs\" name=\"saveReplyButton\">Save</span>";
	        			//html += "<input type=\"hidden\" value=\"" + requestItem.requestSeq + "\"></td>";
	        			//html += "</div>";
	        			html += "</td>";
        			}
        			html += "<td class=\"text-center\" style=\"vertical-align:middle;\"><i class=\"fa fa-trash-o\" style=\"cursor:pointer\" name=\"removeRequestButton\"></i>";
        			html += "<input type=\"hidden\" value=\"" + requestItem.requestSeq + "\"></td>";
        			html += "</tr>";
        			$("#requestTbody").append(html);
    			});
	
    			if ($data.requests.length > 0) {
		            $("[name=saveReplyButton]").on("click", saveReply);
		            $("[name=removeRequestButton]").on("click", removeRequest);
		                
					$("#requestHead").children("span").remove();
	    			if (countNotYetReply > 0) {
	    				$("#requestHead").append("<span class=\"badge bg-primary\" style=\"margin-left:10px\">New</span>");
					} else {
						$("#requestHead").children("span").remove();
					}
				} else {
	    			$("#requestTbody").html("<tr><td colspan=\"5\" class=\"text-center\">None.</td></tr>");
				}
            }

            function saveReply() {
   	    		var branchSeq = getUrlParameter("branchSeq");
   	    		var requestSeq = $(this).next().val();
   	    		
   	    		if (!requestSeq || !branchSeq) {
   	    			alert("lack of data.");
					return false;
				}
	   	    		
				var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/students/requests/" + requestSeq + "/reply";
            	$.ajax({
            		headers : getAjaxHeaders("Authorization", $.session.get("x-auth-token")),
            		url : url,
            		type : "POST",
            		data : getReplyJsonData(),
            		dataType : "json",
            		contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
            		success : function(data, textStatus, jqXHR) {
		        		if (data.head.status == 200) {
							openSwal(data.head.message, "");
							getDetailData();
		        		} else if (data.head.status == 401) {
							openSwal(data.head.message, "[Status Code : " + data.head.status + "]", function() {
								window.location.replace("/login.jsp");
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

			function getReplyJsonData() {
				return JSON.stringify({
					reply : $("#replyDetail").val()
				});
			}
            
            function removeRequest() {
           		console.log($(this).next().val());
           		if (!window.confirm("Do you want to remove information?")) {
					return false;	
				}
   	    		var branchSeq = getUrlParameter("branchSeq");
   	    		var requestSeq = $(this).next().val();
   	    		if (!requestSeq) {
   	    			alert("lack of data.");
					return false;
				}
	   	    		
   	        	var url = "<%=SERVER_URL%>/branches/" + branchSeq + "/students/requests/" + requestSeq;
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
	   					openSwal(data.head.message, "[Status Code : " + data.head.status + "]", getDetailData);
	   					//alert("success.");
	   					//getDetailData();
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
