<!DOCTYPE html>
<html lang="en">
	<%@ include file="/include/head.jsp" %>


    <body>

        <div class="wrapper-page">
            <div class="panel panel-color panel-inverse">
                <div class="panel-heading"> 
                   <h3 class="text-center m-t-10"> Sign In to <strong>PIA Portal</strong> </h3>
                </div> 

                <div class="panel-body">
                    <form class="cmxform form-horizontal m-t-10 p-20 p-b-0 tasi-form" id="commentForm" method="get" novalidate="novalidate">
                        <div class="form-group ">
                            <div class="col-xs-12">
                                <input class=" form-control" id="username" type="text" placeholder="Username"  required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group ">
                            <div class="col-xs-12">
                                <input class="form-control" id="password" type="password" placeholder="Password" required="" aria-required="true">
                            </div>
                        </div>                                            

                        <div class="form-group ">
                            <div class="col-xs-12">
                                <label class="cr-styled">
                                    <input type="checkbox" id="isSaveId">
                                    <i class="fa"></i> 
                                    Remember me
                                </label>
                            </div>
                        </div>
                        
                        <div class="form-group text-right">
                            <div class="col-xs-12">
                                <button class="btn btn-success w-md" type="submit" id="btLogin">Log In</button>
                            </div>
                        </div>
                        <!-- 
                        <div class="form-group m-t-30">
                            <div class="col-sm-7">
                                <a href="pages-recoverpw.html"><i class="fa fa-lock m-r-5"></i> Forgot your password?</a>
                            </div>
                            <div class="col-sm-5 text-right">
                            </div>
                        </div>
                         -->
                    </form>
                </div>

            </div>
        </div>
		<div id="api_mask"></div>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="/js/jquery.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="/js/pace.min.js"></script>
        <script src="/js/wow.min.js"></script>
        <script src="/js/jquery.nicescroll.js"></script>
            
        <!--form validation -->
        <script src="/assets/jquery.validate/jquery.validate.min.js"></script>
        
        <script src="/js/jquery.cookie.js"></script>

        <!--common script for all pages-->
        <script src="/js/jquery.app.js"></script>
        <script src="/js/jquery.session.js"></script>
        <script src="/js/md5.min.js"></script>
        
        <script src="/custom/pia-ajaxs.js"></script>

        <script src="/assets/sweet-alert/sweet-alert.min.js"></script>
        <script src="/assets/sweet-alert/sweet-alert.init.js"></script>
        <script src="/js/base64.js"></script>
		<script>
			$(document).ready(function() {
				$("#username").focus();
				$("#commentForm").validate({
					submitHandler: function(form) {
						login();
					},
					invalidHandler: function(form) {
					}
				});
				
				setScreenByCookies();
			});
			
			function login() {
				if (!$("#username").val() || !$("#password").val()) {
					return;
				}
				
				setCookies();
				//console.log(getJsonData());
				$.ajax({
					url : "<%=SERVER_URL%>/login/staff",
					type : "POST",
					data : getJsonData(),
					dataType : "json",
					contentType : "application/json; charset=UTF-8",
					beforeSend : function (jqXHR, settings) {
						wrapWindowByMask();
					},
					success : function(data, textStatus, jqXHR) {
						console.log(data);
						loginSuccess(data);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log(jqXHR.responseText);
					},
					complete : function(jqXHR, textStatus) {
						closeWindowByMask();
					}
				});
			}
			
			function setScreenByCookies() {
				var cookieIsSaveId = ($.cookie("cookieIsSaveId") == "true");
				if (cookieIsSaveId) {
					$("#isSaveId").attr("checked", cookieIsSaveId);
					
					if ($.cookie("cookieLoginUser")) {
						$("#username").val($.cookie("cookieLoginUser"));
					}
				} else{
					$("#isSaveId").attr("checked", false);
					$("#username").val("");
				}
			}
			
			function setCookies() {
				$.cookie("cookieIsSaveId", $("#isSaveId").is(":checked"));
				
				if ($("#isSaveId").is(":checked")) {
					$.cookie("cookieLoginUser", $("#username").val());
				} else {
					$.cookie("cookieLoginUser", "");
				}
			}

			function getJsonData() {
				return JSON.stringify({
					staffId : $("#username").val(),
					password : md5($("#password").val())
				});
			}

			function loginSuccess(response) {
				if (response.body.totalCount == 1) {
					var token_id = $("#username").val();
					var token_pw = md5($("#password").val());
					var token = "Basic " + Base64.encode(token_id + ":" + token_pw);
					
					$.cookie("staffId", token_id);
					$.cookie("staffName", response.body.data.staffName);
					$.cookie("branchSeq", JSON.stringify(response.body.data.branchSeq));
					$.cookie("branches", JSON.stringify(response.body.data.branches));
					$.cookie("campuses", JSON.stringify(response.body.data.campuses));
					$.cookie("languages", JSON.stringify(response.body.data.languages));
					$.cookie("siteAuthorization", response.body.data.siteAuthorization);
					$.session.set("x-auth-token", token);
					
					window.location.replace("/request/requestList.jsp");
				} else {
					swal("Login Failed!!");
					$("#password").val("");
				}
			}
		</script>
    </body>
</html>
