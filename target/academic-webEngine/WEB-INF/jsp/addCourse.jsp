<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Course</title>
</head>
<body>
	<a href="listCourse">Click here </a>

	<div class="container">
		<form:form action="addCourse" role="form" modelAttribute="courseForm"
			method="POST">
			<div class="form-group">
				<label for="courseName">Course Name:</label>
				<form:input path="courseName" class="form-control" id="courseName" />
			</div>
			<div class="form-group">
				<label for="pwd">Description:</label>
				<form:input path="courseName" class="form-control" id="courseName" />
			</div>
			<div class="form-group">
				<label for="pwd">startDate :</label>
				<form:input path="startDate" class="form-control" id="startDate" />
			</div>

			<div class="form-group">
				<label for="pwd">endDate:</label>
				<form:input path="endDate" class="form-control" id="endDate" />
			</div>
			<div class="form-group">
				<label for="pwd">fee:</label>
				<form:input path="fee" class="form-control" id="fee" />
			</div>
			<div class="form-group">
				<label for="pwd">extraCharges:</label>
				<form:input path="extraCharges" class="form-control"
					id="extraCharges" />
			</div>
			<div class="form-group">
				<label for="pwd">prerequisite:</label>
				<form:textarea path="prerequisite" class="form-control"
					id="prerequisite" />
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>

</body>
</html>