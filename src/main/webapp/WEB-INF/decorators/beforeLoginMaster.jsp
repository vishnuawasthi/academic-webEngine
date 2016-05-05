<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	
	<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />

	<link href="resources/css/style.css" rel="stylesheet"
	type="text/css" />

<link href="resources/css/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css" />
	
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css"
	media="all">



<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
</head>
<body id="top">
	<%@include file="/WEB-INF/jsp/commons/header.jsp"%>
	<sitemesh:write property='body' />
	<%@include file="/WEB-INF/jsp/commons/footer.jsp"%>
	<script src="layout/scripts/jquery.min.js"></script>
	<script src="layout/scripts/jquery.fitvids.min.js"></script>
	<script src="layout/scripts/jquery.mobilemenu.js"></script>
	<script src="layout/scripts/tabslet/jquery.tabslet.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#logout").click(function(){
			alert("Logout");
			$("#logoutForm").submit();
		});
	});
	</script>
</body>
</html>