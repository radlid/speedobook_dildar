<%@page import="com.speedobook.bean.DoctorBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="doctors.css">

</head>

<body>
 <jsp:include page="banner.jsp"/>
<h1>Welcome To The List of Doctors</h1>
<% List<DoctorBean> doctors = (List<DoctorBean>) request.getAttribute("DOCTORS"); %>
<div class="main">
	<% for(DoctorBean p : doctors) { %>
	<div class="container">
		<div >
			<img src=<%=p.getImage()%> height="200" width="200">
		</div>

		<div>
			<p>
				Name:
				<%=p.getName()%></p>
				<p>
				Department: <%=p.getDepartment()%>
				</p>
			<p>
				Charge $<%=p.getCharge()%></p>
			<p>
				Appointment left:
				<%=p.getLimit()%></p>
				<p>
			<%
			if (p.getLimit() != 0) {
			%>
			<a id="btn" href="Appointment?code=<%=p.getCode()%>">Book</a>
			<%
			} else {
			%>
			<h3>Not Available</h3>
			<% } %>
			</p>
		</div>
	</div>
	<%
	}
	%>
	</div>

			
</body>
</html>