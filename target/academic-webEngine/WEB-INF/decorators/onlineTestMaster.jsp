<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
<script src="resources/script/angular.js"></script>
<script src="resources/script/angular.min.js"></script>
<script src="resources/script/app.js"></script>
<script src="resources/script/common.js"></script>

</head>
<body>
	<%@include file="/WEB-INF/jsp/commons/header.jsp"%>
	<h1>All the best !!!</h1>
	<hr>
	<sitemesh:write property='body' />
	<hr>
	<%@include file="/WEB-INF/jsp/commons/footer.jsp"%>
</body>
</html>