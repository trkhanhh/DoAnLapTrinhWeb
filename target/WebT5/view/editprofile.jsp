<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Edit Profile</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Profile Form Elements
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form name="register" id="register"
                                      action="${pageContext.request.contextPath}/update-profile" onsubmit="return validateForm()"
                                      method="post">
                                    <div class="form-group">
                                        <label>First Name</label>
                                        <input id = "fname"class="form-control" placeholder="Enter the first name" name="firstname" value="${firstname}" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Last Name</label>
                                        <input id ="lname"class="form-control" placeholder="Enter your last name" name="lastname" value="${lastname}" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Email</label>
                                        <p class="form-control-static">${email}</p>
                                    </div>
                                    <div class="form-group">
                                        <label>Phone</label>
                                        <input id="phone"class="form-control" placeholder="Enter your phone number" name="phone" value="${phone}" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <textarea class="form-control" rows="3" name="description">${description}</textarea>
                                    </div>
                                    <button type="submit" class="btn btn-default">Submit Button</button>
                                    <button  onclick="refreshPage()" class="btn btn-default">Reset Button</button>
                                </form>
                            </div>
                            <!-- /.col-lg-6 (nested) -->
                            <!-- /.col-lg-6 (nested) -->
                        </div>
                        <!-- /.row (nested) -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->
<!-- jQuery -->
<script src="<c:url value ="/style/js/jquery.min.js"/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value ="/style/js/bootstrap.min.js"/>"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<c:url value ="/style/js/metisMenu.min.js"/>"></script>

<!-- Custom Theme JavaScript -->
<script src="<c:url value ="/style/js/startmin.js"/>"></script>

<script>
    function validateForm() {
        const title = $('#fname').val();
        const brief =  $('#lname').val();
        const content = $('#phone').val();

        if (title == "" || brief == "" || content == "") {
            alert("All the profile must be filled in");
            return false;
        } else {
            if (title.length < 3 || title.length > 30) {
                alert("Firstname mnust be more than 3 characters and less than 30 characters");
                return false;
            }
            if (brief.length < 3 || brief.length > 30) {
                alert("Lastname mnust be more than 3 characters and less than 30 characters");
                return false;
            }
            if (content.length < 9 || content.length > 13) {
                alert("Phone mnust be more than 9 characters and less than 13 characters");
                return false;
            }
        }
        return true;
    }
    function refreshPage(){
        window.location.reload();
    }
</script>