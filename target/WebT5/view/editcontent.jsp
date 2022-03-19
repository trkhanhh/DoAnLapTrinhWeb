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
                <h1 class="page-header">Edit Content</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">Content Form Elements</div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form name="editcontent" id="editcontent"
                                      action="${pageContext.request.contextPath}/update-content"
                                      onsubmit="return validateForm()"
                                      method="post">
                                    <div class="form-group">
                                        <input class="form-control"
                                               placeholder="Enter the title" value="${id}"
                                               name="id" id="id" type="hidden">
                                    </div>
                                    <div class="form-group">
                                        <label>Title</label> <input class="form-control"
                                                                    placeholder="Enter the title" value="${title}"
                                                                    name="title" id="titleValue">
                                    </div>
                                    <div class="form-group">
                                        <label>Brief</label>
                                        <textarea class="form-control" rows="3" name="brief"
                                                  id="briefValue">${brief}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Content</label>
                                        <textarea class="form-control" rows="8" name="content"
                                                  id="contentValue">${content}</textarea>
                                    </div>
                                    <button type="submit" class="btn btn-default">Submit
                                        Button
                                    </button>
                                    <button type="reset" onclick="refreshPage()" class="btn btn-default">Reset
                                        Button
                                    </button>
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
        const title = $('#titleValue').val();
        const brief = $('#briefValue').val();
        const content = $('#contentValue').val();

        if (title == "" || brief == "" || content == "") {
            alert("All the content must be filled in");
            return false;
        } else {
            if (title.length < 10 || title.length > 200) {
                alert("Title mnust be more than 10 characters and less than 200 characters");
                return false;
            }
            if (brief.length < 30 || brief.length > 150) {
                alert("Brief mnust be more than 30 characters and less than 150 characters");
                return false;
            }
            if (content.length < 50 || content.length > 1000) {
                alert("Content mnust be more than 50 characters and less than 1000 characters");
                return false;
            }
        }
        return true;
    }

    function refreshPage() {
        window.location.reload();
    }
</script>