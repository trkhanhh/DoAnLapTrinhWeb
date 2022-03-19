<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value ="/style/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value ="/style/css/metisMenu.min.css"/>" type="text/css">
<link href="<c:url value ="/style/css/startmin.css"/>" type="text/css">
<link href="<c:url value ="/style/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">View Content</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-15">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        View content list
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <c:if test="${role eq  'admin'}">
                                        <th>User</th>
                                    </c:if>

                                    <th>Title</th>
                                    <th>Brief</th>
                                    <th>Content</th>
                                    <th>Created date</th>
                                    <th>Options</th>
                                </tr>
                                <c:forEach items="${contents}" var="l">
                                    <tr>
                                        <form name="eidtcontent" id="eidtcontent"
                                              action="${pageContext.request.contextPath}/edit-content" method="post">
                                            <td><input id="id" type="text" value="${l.id}" name="id" required/>
                                                <c:if test="${role eq  'admin'}">
                                            <td>${name}</td>
                                            </c:if>
                                            <td><input id="title" type="text" value="${l.title}" name="title" required/>
                                            </td>
                                            <td><input id="brief" type="text" value="${l.brief}" name="brief" required/>
                                            </td>
                                            <td><input id="content" type="text" value="${l.content}" name="content"
                                                       required/></td>
                                            <c:if test="${role eq  'admin'}">
                                                <td>${name}</td>
                                            </c:if>

                                            <td>
                                                <button type="submit">Edit</button>
                                                <button><a
                                                        href="${pageContext.request.contextPath}/delete-content?id=${l.id}"
                                                        title="delete" class="delete"
                                                        onclick="return confirm('Are you sure you want to delete this item')">Delete</a>
                                                </button>
                                            </td>
                                        </form>
                                    </tr>
                                </c:forEach>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <div class="pagination">
                                <button onclick="pagingHandle(${pageIndex}, '${searchCode}')"
                                        class="btn-success rounded-50">Preview
                                </button>
                                <span id="pagination-index">${pageIndex +1}</span>
                                <button onclick="pagingHandle(${pageIndex}, '${searchCode}', ${maxPage})"
                                        class="btn-success rounded-50">Next
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value ="/style/js/jquery.min.js"/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value ="/style/js/bootstrap.min.js"/>"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<c:url value ="/style/js/metisMenu.min.js"/>"></script>

<!-- DataTables JavaScript -->
<script src="<c:url value ="/style/js/dataTables/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value ="/style/js/dataTables/dataTables.bootstrap.min.js"/>"></script>

<!-- Custom Theme JavaScript -->
<script src="<c:url value ="/style/js/startmin.js"/>"></script>

<script>
    window.onload = function () {
        document.getElementById("search").value = '${searchCode}';
    }
    $(document).ready(function () {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });

    const contextPath = "<%=request.getContextPath()%>";
    const pageIndex = document.getElementById("pagination-index").textContent;
    const searchCode = document.getElementById("search").value.trim();

    function pagingHandle(index, code, max) {
        document.getElementById("search").value = code;
        console.log(searchCode);
        if (typeof max === 'undefined') {
            index = index - 1;
        } else {
            ++index;
        }
        let url = contextPath + "/search-content?index=" + index + "&value=" + code
        window.location.href = url.toString();
    }
</script>
