<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:if test="${not empty success }">
	<h4 style="color: green;">${success}</h4>
</c:if>
<c:if test="${not empty failure }">
	<h1 style="color: red;">${failure }</h1>
</c:if>
<div class="wrapper  form-color">
	<form:form action="register" method="POST"
		modelAttribute="registrationForm"
		class="form-horizontal" role="form">

		<div class="form-group">
			<label class="control-label col-sm-4 col-md-4" for="role"><spring:message
					code="label.registrationForm.role"></spring:message></label>
			<div class="col-sm-6 col-md-6">
				<form:select id="role" path="role" class="form-control">
					<form:option value="NONE" label="Please select role"></form:option>
					<form:options items="${userRoles}" />
				</form:select>
				<form:errors class="error-message" path="role"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for=""><spring:message
					code="label.registrationForm.firstName"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="firstName" id="firstName" class="form-control" />
				<form:errors class="error-message" path="firstName"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="lastName"><spring:message
					code="label.registrationForm.lastName"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="lastName" id="lastName" class="form-control" />
				<form:errors class="error-message" path="lastName"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="email"><spring:message
					code="label.registrationForm.email"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="email" id="email" class="form-control" />
				<form:errors class="error-message" path="email"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="contactNumber"><spring:message
					code="label.registrationForm.contact"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="mobile" id="mobile" class="form-control" />
				<form:errors class="error-message" path="mobile"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="username"><spring:message
					code="label.registrationForm.username"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="username" id="username" class="form-control" />
				<form:errors class="error-message" path="username"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="password"><spring:message
					code="label.registrationForm.password"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="password" id="password" class="form-control" />
				<form:errors class="error-message" path="password"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="confirmPassword"><spring:message
					code="label.registrationForm.confirmPassword"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="confirmPassword" id="confirmPassword" readonly="readOnly" class="form-control" />
				<form:errors class="error-message" path="confirmPassword"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="addressLine1"><spring:message
					code="label.registrationForm.addressLine1"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="addressLine1" id="addressLine1"
					class="form-control" />
				<form:errors class="error-message" path="addressLine1"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="addressLine2"><spring:message
					code="label.registrationForm.addressLine2"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="addressLine2" id="addressLine2"
					class="form-control" />
				<form:errors class="error-message" path="addressLine2"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="city"><spring:message
					code="label.registrationForm.pincode"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="city" id="city" class="form-control" />
				<form:errors class="error-message" path="city"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="pincode"><spring:message
					code="label.registrationForm.city"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="pincode" id="pincode" class="form-control" />
				<form:errors class="error-message" path="pincode"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="state"><spring:message
					code="label.registrationForm.state"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="state" id="state" class="form-control" />
				<form:errors class="error-message" path="state"></form:errors>
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="country"><spring:message
					code="label.registrationForm.country"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="country" id="country" class="form-control" />
				<form:errors class="error-message" path="country"></form:errors>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-md-offset-4 col-sm-6 col-md-6">
				<div class="checkbox">
					<form:checkbox path="termsAndConditions" />
					<spring:message code="label.registrationForm.t&c"></spring:message>
				</div>
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