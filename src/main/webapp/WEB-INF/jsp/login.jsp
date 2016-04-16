<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Spring Security Custom Login Form (Annotation)</h1>
<div id="login-box"     class="wrapper  form-color">

	<h2>Login with Username and Password</h2>

	<c:if test="${error ne null}">  ${error} </c:if>
	<c:if test="${msg ne null }"> ${msg } </c:if>
	<form name='loginForm' action="login" method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan="2"><p>
						<label for="remember-me">Remember Me</label>
					</p> <input type="checkbox" id="remember-me" name="remember-me" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" /></td>
			</tr>
		</table>
	</form>
</div>
