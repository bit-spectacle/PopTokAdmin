<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<!-- Bootstrap core CSS-->
	<link href="${pageContext.request.contextPath }/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom fonts for this template-->
	<link href="${pageContext.request.contextPath }/assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<!-- Page level plugin CSS-->
	<link href="${pageContext.request.contextPath }/assets/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
	<!-- Custom styles for this template-->
	<link href="${pageContext.request.contextPath }/assets/css/sb-admin.css" rel="stylesheet">
		
	<script src="${pageContext.request.contextPath }/assets/vendor/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/vendor/bootpag/jquery.bootpag.min.js"></script>
	
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<tiles:insertAttribute name="header"/>
	<div class="content-wrapper">
		<div class="container-fluid">
			<ol class="breadcrumb">
				<c:if test="${not empty category }">
					<li class="breadcrumb-item">${category}</li>
				</c:if>
				<c:if test="${not empty title }">
					<li class="breadcrumb-item">${title}</li>
				</c:if>
			</ol>
			<tiles:insertAttribute name="body" />
			<tiles:insertAttribute name="footer" />
			<tiles:insertAttribute name="modal" />
		</div>
	</div>
   	
	<script src="${pageContext.request.contextPath }/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Page level plugin JavaScript-->
	<script src="${pageContext.request.contextPath }/assets/vendor/chart.js/Chart.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/vendor/datatables/jquery.dataTables.js"></script>
	<script src="${pageContext.request.contextPath }/assets/vendor/datatables/dataTables.bootstrap4.js"></script>
	<!-- Custom scripts for all pages-->
	<script src="${pageContext.request.contextPath }/assets/js/sb-admin.min.js"></script>
	<!-- Custom scripts for this page-->
	<script src="${pageContext.request.contextPath }/assets/js/sb-admin-datatables.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/sb-admin-charts.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/paging.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/modal.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/util.js"></script>
</body>
</html>
