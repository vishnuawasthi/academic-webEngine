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
</head>
<body>

	<%@include file="/WEB-INF/jsp/commons/header.jsp"%>


	<sitemesh:write property='body' />

	<%@include file="/WEB-INF/jsp/commons/footer.jsp"%>

</body>
</html>