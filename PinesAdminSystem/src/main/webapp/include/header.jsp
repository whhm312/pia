<header class="top-head container-fluid" style="height:61px">
    <button type="button" class="navbar-toggle pull-left">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    
    <!-- Right navbar -->
	<ul class="nav navbar-nav navbar-right top-menu top-right-menu">  
	    <!-- user login dropdown start-->
		<li class="dropdown text-center">
		    <a data-toggle="dropdown" class="dropdown-toggle" href="#" style="margin-top:1px">
		        <span class="username" id="loginStaffName">John Deo </span> <span class="caret"></span>
		    </a>
		    <ul class="dropdown-menu pro-menu fadeInUp animated" tabindex="5003" style="overflow: hidden; outline: none;">
		        <li><a href="javascript:signOut();"><i class="fa fa-sign-out"></i> Log Out</a></li>
		    </ul>
		</li>
	<!-- user login dropdown end -->       
	</ul>
	<!-- End right navbar -->

</header>
<script type="text/javascript">
function signOut() {
	$.session.set("x-auth-token-id", "");
	$.session.set("x-auth-token-pw", "");
	$.session.set("x-auth-token", "")
	window.location.replace("/index.jsp");
}
</script>