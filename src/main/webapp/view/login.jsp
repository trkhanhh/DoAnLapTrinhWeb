<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Login</title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value ="/style/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css">

<!-- MetisMenu CSS -->
<link href="<c:url value ="/style/css/metisMenu.min.css"/>"
	type="text/css">

<!-- Custom CSS -->
<link href="<c:url value ="/style/css/startmin.css"/>" type="text/css">

<!-- Custom Fonts -->
<link href="<c:url value ="/style/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	String userName = "", password = "", rememberVal = "";
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("cookuser")) {
				userName = cookie.getValue();
			}
			if (cookie.getName().equals("cookpass")) {
				password = cookie.getValue();
			}
			if (cookie.getName().equals("cookrem")) {
				rememberVal = cookie.getValue();
			}
		}
	}
%>
	<div class="container" style="margin-top: 120px !important;">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form role="form" id="login"
							action="${pageContext.request.contextPath}/login" method="post">
							<c:if test="${alert != null}">
								<p class="alert alert-danger">${alert}</p>
							</c:if>

							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Email" id ="email"
										name="email" type="email" value = "<%=userName%>"
												   required autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password" id="pass"
										name="password" type="password" value = "<%=password%>"required value="">
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
												   value="1"
										<%="1".equals(rememberVal.trim()) ? "checked=\"checked\"" : ""%>>Remember Me
									</label>
								</div>
								<!-- Change this to a button or input when using this as a form -->
								<button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
								<br /> <a href="register.jsp">Click here to register</a>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="../js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../js/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../js/startmin.js"></script>
<script>
	function validateForm() {
		const title = $('#email').val();
		const brief =  $('#pass').val();

		if (title == "" || brief == "" || content == "") {
			alert("All the profile must be filled in");
			return false;
		} else {
			if (title.length < 5 || title.length > 50) {
				alert("Email mnust be more than 5 characters and less than 50 characters");
				return false;
			}
			if (brief.length < 8 || brief.length > 30) {
				alert("Password mnust be more than 8 characters and less than 30 characters");
				return false;
			}
		}
		return true;
	}
</script>
</body>
</html>
