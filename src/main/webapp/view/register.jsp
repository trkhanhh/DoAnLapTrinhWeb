<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Register</title>

        <!-- Bootstrap Core CSS -->
        <link href="<c:url value ="/style/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">

        <!-- MetisMenu CSS -->
        <link href="<c:url value ="/style/css/metisMenu.min.css"/>" type="text/css">

        <!-- Custom CSS -->
        <link href="<c:url value ="/style/css/startmin.css"/>" type="text/css">

        <!-- Custom Fonts -->
        <link href="<c:url value ="/style/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <div class="container" style="margin-top: 120px !important;">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Register</h3>
                        </div>
                        <div class="panel-body">
                            <form name="register" id="register"
                                  action="${pageContext.request.contextPath}/register" onsubmit="return validateForm()"
                                  method="post">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="User name" name="name" id="name" type="text" required autofocus>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="E-mail" name="email" id="email" type="email"required autofocus>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="password" id="password" type="password" required value="">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Re Password" name=""  id="repassword" type="password" required value="">
                                    </div>
                                    <!-- Change this to a button or input when using this as a form -->
                                    <button type="submit" class="btn btn-lg btn-success btn-block">Register</button>
                                    <br />
                                    <a href="login.jsp">Click here to login</a>
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

    </body>



</html>
<script>
    function validateForm() {
        const password = $('#password').val();
        const repassword = $('#repassword').val();
        const name = $('#name').val();
        const email = $('#email').val();

        if (password != repassword) {
            alert("Re-password not matching with password");
            return false;
        }
        if (name.length < 3 || name.length > 30) {
            alert("Name must be more than 3 characters and less than 30 characters");
            return false;
        }
        if (email.length < 5 || email.length > 50) {
            alert("Email must be more than 5 characters and less than 50 characters");
            return false;
        }
        if (password.length < 8 || password.length > 30) {
            alert("Password must be more than 8 characters and less than 30 characters");
            return false;
        }
        return true;
    }
</script>
