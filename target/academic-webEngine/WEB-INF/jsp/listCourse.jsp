
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course List</title>
</head>
<body>
	<table align="center">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Description</td>
			<td>Start Date</td>
			<td>End Date</td>
			<td>Fee</td>
			<td>Extra Charges</td>
			<td>Prerequisite</td>
			<td>Add Assignment</td>
			<td>View Assignment</td>
		</tr>
		<c:if test="${ not empty courseList  }">
			<c:forEach items="${courseList }" var="course">
				<tr>
					<td>${course.id}</td>
					<td>${course.courseName}</td>
					<td>${course.description}</td>
					<td>${course.startDate}</td>
					<td>${course.endDate}</td>
					<td>${course.fee}</td>
					<td>${course.extraCharges}</td>
					<td>${course.prerequisite}</td>
					<td><a href="assignment?id=${course.id}">Add</a></td>
					<td><a href="viewAssignment?id=${course.id}">View</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty courseList}">
			<tr>
				<td colspan="10">No records found</td>
			</tr>
		</c:if>
	</table>
</body>
</html>