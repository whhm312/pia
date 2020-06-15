<!DOCTYPE html>
<html lang="en">
	<%@ include file="/include/head.jsp" %>
    <body>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="/js/jquery.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="/js/pace.min.js"></script>
        <script src="/js/wow.min.js"></script>
        <script src="/js/jquery.nicescroll.js" type="text/javascript"></script>
            

        <!--common script for all pages-->
        <script src="/js/jquery.app.js"></script>
        <script src="/js/jquery.session.js"></script>

		<script>
			$(document).ready(function() {
				if ($.session.get("x-auth-token")) {
					window.location.replace("/request/requestList.jsp");
				} else {
					window.location.replace("/login.jsp");
				}
			});
		</script>
    </body>
</html>
