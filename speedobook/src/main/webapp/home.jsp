<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="home.css">
</head>
<body>

	
		<% if(request.getParameter("invalid") != null) { %>
			<span id="err">Invalid Email ID/Password</span>
		<% } %>
		<form action="User.fm">
		<div class="login-box">
		<h1>Login</h1>
		<div class="textbox">
		<input type="text" placeholder="Email Id" name="email">
		</div>
		<div class="textbox">
		<input type="password" placeholder="Password" name="password">
		</div>
		<input class="btn" type="submit" value="Login">
		</div>
		</form>
	
</body>
</html>