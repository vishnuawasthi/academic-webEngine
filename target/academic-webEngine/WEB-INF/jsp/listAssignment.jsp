<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Assignment</title>
</head>
<body>
	<table>
		<tr>
			<td>Id</td>
			<td>Course Name</td>
			<td>Assignment</td>
		</tr>
		<c:if test="${not empty courseDTO}">
			<tr>
				<td>${courseDTO.id }</td>
				<td>${courseDTO.courseName }</td>
				<td>
					<ul>
						<c:forEach items="${courseDTO.assignments}" var="assignment">
							<li>${ assignment.id}</li>
							<li>${ assignment.description}</li>
							<li>${ assignment.notice}</li>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</c:if>
	</table>
</body>
</html>