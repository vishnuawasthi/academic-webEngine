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

	<div class="control-label col-sm-4 col-md-4">Update User PerSonal Information</div>
<div class="alert alert-success">${success}</div>


	<form:form action="updateUserDetail" method="POST"
		modelAttribute="registrationForm"
		class="form-horizontal" role="form">
			
		<div class="form-group top-margin">
		<form:hidden path="id" id="id"  value="${userDetail.id }" class="form-control"/>
		
			<label class="control-label col-sm-4 col-md-4" for=""><spring:message
					code="label.registrationForm.firstName"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="firstName" id="firstName" value="${userDetail.firstName}" class="form-control" />
				
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="lastName"><spring:message
					code="label.registrationForm.lastName"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="lastName" id="lastName" value="${userDetail.lastName}" class="form-control" />
				
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="email"><spring:message
					code="label.registrationForm.email"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="email" id="email" value="${userDetail.email}" class="form-control" />
				
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="contactNumber"><spring:message
					code="label.registrationForm.contact"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="mobile" id="mobile" value="${userDetail.mobile}" class="form-control" />
				
			</div>
		</div>
		
		
		
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="addressLine1"><spring:message
					code="label.registrationForm.addressLine1"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="addressLine1" id="addressLine1" value="${userDetail.addressLine1}"	class="form-control" />
			
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="addressLine2"><spring:message
					code="label.registrationForm.addressLine2"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="addressLine2" id="addressLine2" value="${userDetail.addressLine2}"
					class="form-control" />
				
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="city"><spring:message
					code="label.registrationForm.pincode"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="pincode" id="pincode"  value="${userDetail.pincode}" class="form-control" />
				
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="pincode"><spring:message
					code="label.registrationForm.city"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="city" id="city" value="${userDetail.city}" class="form-control" />
			
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="state"><spring:message
					code="label.registrationForm.state"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="state" id="state"  value="${userDetail.state}" class="form-control" />
				
			</div>
		</div>
		<div class="form-group top-margin">
			<label class="control-label col-sm-4 col-md-4" for="country"><spring:message
					code="label.registrationForm.country"></spring:message></label></label>
			<div class="col-sm-6 col-md-6">
				<form:input path="country" id="country" value="${userDetail.country}" class="form-control" />
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