<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<div class="wrapper row0">
	<div id="topbar" class="clear">
		<nav>
			<ul>
				<li><a href="landing">Home</a></li>
				<li><a href="contact-us">Contact Us</a></li>
				<li><a href="#">A - Z Index</a></li>
				<li><a href="register">Not a member register ToDay</a></li>
				<li><a href="#"   id="logout">Logout</a>
			</ul>
		</nav>
	</div>
</div>
<div class="wrapper row1">
	<header id="header" class="clear">
		<div id="logo" class="fl_left">
			<h1>
				<a href="index.html">Academic Web Engine  V1.0</a>
			</h1>
			<p>A Way to success</p>
		</div>
		<div class="fl_right">
			<form class="clear" method="post" action="#">
				<fieldset>
					<legend>Search:</legend>
					<input type="text" value="" placeholder="Search Here">
					<button class="fa fa-search" type="submit" title="Search">
						<em>Search</em>
					</button>
				</fieldset>
			</form>
		</div>
	</header>
</div>
<!-- Menu bar start -->
<div class="wrapper row2">
	<div class="rounded">
		<nav id="mainav" class="clear">
			<ul class="clear">
				<li class="active"><a href="landing">Home    </a></li>
				<li><a class="drop" href="#">Dash Board</a>
					<ul>
						<li><a href="viewUserDetails">View Details</a></li>
						<li><a href="editUserDetail?id=${userDetals.id}">Update Details</a></li>
						<li><a href="changePassword">Change password</a></li>
						<li><a href="contact-us">Contact us</a></li>
						
						<%-- <security:authorize ifAnyGranted="ROLE_ADMIN"> --%>
						<li><a href="pages/sidebar-left-2.html">Deactivate Profile</a></li>
						<%-- </security:authorize> --%>
						<li><a href="#" id="logout2">Logout</a>
						<form action="logout" method="post" id="logoutForm">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form></li>
					</ul></li>
				<li><a class="drop" href="#">Online Example</a>
					<ul>
						<li><a href="#">Level 2</a></li>
						<li><a class="drop" href="#">Level 2 + Drop</a>
							<ul>
								<li><a href="#">Level 3</a></li>
								<li><a href="#">Level 3</a></li>
							</ul></li>
					</ul></li>
				<li><a href="#">Link Text</a></li>
				<li><a href="#">Another Link Text</a></li>
				<li><a href="#">This a very long link</a></li>
				<li><a href="#">This is the last</a></li>
			</ul>
		</nav>
	</div>
</div>

