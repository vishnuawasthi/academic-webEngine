<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Flat Login Form 3.0</title>


<style>
html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline
}

article, aside, details, figcaption, figure, footer, header, hgroup,
	menu, nav, section {
	display: block
}

body {
	line-height: 1;
}

ol, ul {
	list-style: none
}

blockquote, q {
	quotes: none
}

blockquote:before, blockquote:after, q:before, q:after {
	content: '';
	content: none
}

table {
	border-collapse: collapse;
	border-spacing: 0
}

body {
	background: #e9e9e9;
	color: #666666;
	font-family: 'RobotoDraft', 'Roboto', sans-serif;
	font-size: 14px;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	background-image: url('../resources/images/Brick_bldg.jpg');
}

/* Pen Title */
.pen-title {
	padding: 50px 0;
	text-align: center;
	letter-spacing: 2px;
}

.pen-title h1 {
	margin: 0 0 20px;
	font-size: 48px;
	font-weight: 300;
}

.pen-title span {
	font-size: 12px;
}

.pen-title span .fa {
	color: #33b5e5;
}

.pen-title span a {
	color: #33b5e5;
	font-weight: 600;
	text-decoration: none;
}

/* Form Module */
.form-module {
	position: relative;
	background: #ffffff;
	max-width: 320px;
	width: 100%;
	border-top: 5px solid #33b5e5;
	box-shadow: 0 0 3px rgba(0, 0, 0, 0.1);
	margin: 0 auto;
}

.form-module .toggle {
	cursor: pointer;
	position: absolute;
	top: -0;
	right: -0;
	background: #33b5e5;
	width: 30px;
	height: 30px;
	margin: -5px 0 0;
	color: #ffffff;
	font-size: 12px;
	line-height: 30px;
	text-align: center;
}

.form-module .toggle .tooltip {
	position: absolute;
	top: 5px;
	right: -65px;
	display: block;
	background: rgba(0, 0, 0, 0.6);
	width: auto;
	padding: 5px;
	font-size: 10px;
	line-height: 1;
	text-transform: uppercase;
}

.form-module .toggle .tooltip:before {
	content: '';
	position: absolute;
	top: 5px;
	left: -5px;
	display: block;
	border-top: 5px solid transparent;
	border-bottom: 5px solid transparent;
	border-right: 5px solid rgba(0, 0, 0, 0.6);
}

.form-module .form {
	display: block;
	padding: 40px;
}

.form-module .form:nth-child(2) {
	display: block;
}

.form-module h2 {
	margin: 0 0 20px;
	color: #33b5e5;
	font-size: 18px;
	font-weight: 400;
	line-height: 1;
}

.form-module input {
	outline: none;
	display: block;
	width: 100%;
	border: 1px solid #d9d9d9;
	margin: 0 0 20px;
	padding: 10px 15px;
	box-sizing: border-box;
	font-wieght: 400;
	-webkit-transition: 0.3s ease;
	transition: 0.3s ease;
}

.form-module input:focus {
	border: 1px solid #33b5e5;
	color: #333333;
}

.form-module button {
	cursor: pointer;
	background: #33b5e5;
	width: 100%;
	border: 0;
	padding: 10px 15px;
	color: #ffffff;
	-webkit-transition: 0.3s ease;
	transition: 0.3s ease;
}

.form-module button:hover {
	background: #178ab4;
}

.form-module .cta {
	background: #f2f2f2;
	width: 100%;
	padding: 15px 40px;
	box-sizing: border-box;
	color: #666666;
	font-size: 12px;
	text-align: center;
}

.form-module .cta a {
	color: #333333;
	text-decoration: none;
}
</style>

</head>

<body>


	<!-- Form Mixin-->
	<!-- Input Mixin-->
	<!-- Button Mixin-->
	<!-- Pen Title-->
	<div class="pen-title">
		<h1>Flat Login Form</h1>
		<span>Pen <i class='fa fa-paint-brush'></i> + <i
			class='fa fa-code'></i> by <a href='http://andytran.me'>Andy Tran</a></span>
	</div>
	<!-- Form Module-->
	<div class="module form-module">
		<div class="toggle">
			<i class="fa fa-times fa-pencil"></i>
			<div class="tooltip">Click Me</div>
		</div>


		<div class="form">
		<h2>Login to your account</h2>
			<div style="padding-top: 10px;padding-bottom:10px;">
				<c:if test="${ not empty error }">
					<span style="color: red"> ${error} </span>
				</c:if>

				<c:if test="${ not empty msg }">
					<span style="color: green"> ${msg } </span>
				</c:if>
			</div>
			
			<form name='loginForm' action="login" method='POST'>
				<input type="text" placeholder="Username" name="username" /> <input
					type="password" name="password" placeholder="Password" />
				<button>Login</button>
			</form>
		</div>

		<div class="cta">
			<a href="http://andytran.me">Forgot your password?</a>
		</div>
	</div>
</body>
</html>
