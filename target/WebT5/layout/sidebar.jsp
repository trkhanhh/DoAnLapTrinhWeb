<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Bootstrap Core CSS -->
<link href="<c:url value ="/style/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">

<!-- MetisMenu CSS -->
<link href="<c:url value ="/style/css/metisMenu.min.css"/>" rel="stylesheet" type="text/css">

<!-- Custom CSS -->
<link href="<c:url value ="/style/css/startmin.css"/>" rel="stylesheet" type="text/css">

<!-- Custom Fonts -->
<link href="<c:url value ="/style/css/font-awesome.min.css"/>" rel="stylesheet"
      type="text/css">

<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li class="sidebar-search">
                <form name ="searchcontent" id="searchcontent" action="${pageContext.request.contextPath}/search-content" method="post">
                    <div class="input-group custom-search-form">
                        <input id="search" type="text" class="form-control" placeholder="Search..." name="value" value="${search}">
                        <span class="input-group-btn">
						<button class="btn btn-primary" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</span>
                    </div>
                </form>
            </li>
            <li><a href="${pageContext.request.contextPath}/view-content"><i class="fa fa-table fa-fw"></i>
                View Contents</a></li>
            <li><a href="addcontent.tiles"><i class="fa fa-edit fa-fw"></i> Form
                content</a></li>
        </ul>
    </div>
</div>	