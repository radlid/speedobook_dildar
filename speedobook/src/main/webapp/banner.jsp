<%@page import="com.speedobook.bean.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<%	RegisterBean user = (RegisterBean) session.getAttribute("USER");%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#" style="font-size:38pt">SpeedoBook</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
		      <ul class="navbar-nav nav-pills mb-2 mb-lg-0">
		        <li class="nav-item">
		        	<span class="nav-link" style="font-size	:22pt;margin-right:1rem">Hello, <%=user.getName() %> </span>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" aria-current="page" href="Appointment">Doctors</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="User.fm?logout=yes">Logout</a>
		        </li>        
		      </ul>
		    </div>
		  </div>
		</nav>
</body>
</html>