<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Assignment</title>
</head>
<body>

<h4> Add Assignment</h4>
	<form:form action="addAssignment" method="POST"
		modelAttribute="assignmentForm">
		<form:hidden path="courseId" />
		<form:input path="description" />
		<br />
		<form:input path="notice" />
		<br />
		<input type="submit" value="Add">
		<input type="reset" value="Reset">
	</form:form>



</body>
</html>