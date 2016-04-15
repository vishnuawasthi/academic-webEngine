<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="wrapper  form-color">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-6 col-md-6">
			<h3>Change Password</h3>
		</div>



		<div class="col-sm-offset-2 col-sm-6 col-md-6">

			<c:if test="${not empty success }">
				<div class="alert alert-success">${success}</div>
			</c:if>
			<c:if test="${not empty failure }">
				<div class="alert alert-danger">${failure }</div>
			</c:if>

		</div>
	</div>
	<form:form action=" " method="POST"
		modelAttribute="registrationForm" class="form-horizontal" role="form">

		<div class="form-group top-margin">
			<form:hidden path="id" id="id" class="form-control" />

			<label class="control-label col-sm-4 col-md-4" for="">
			<spring:message	code="label.registrationForm.oldPassword"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="password" id="password" class="form-control" />
				<form:errors class="error-message" path="password"></form:errors>

			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="lastName"><spring:message
					code="label.registrationForm.newPassword"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="password" id="password" class="form-control" />
				<form:errors class="error-message" path="password"></form:errors>

			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="email"><spring:message
					code="label.registrationForm.confirmPassword"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="confirmPassword" id="confirmPassword"  class="form-control" />
				<form:errors class="error-message" path="confirmPassword"></form:errors>

			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-6">
				<button type="submit" class="btn btn-default">Submit</button>
				&nbsp;&nbsp;
				<button type="reset" class="btn btn-default">Reset</button>
			</div>
		</div>
	</form:form>
</div>