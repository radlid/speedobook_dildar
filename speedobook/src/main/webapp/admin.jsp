<%@page import="java.util.List"%>
<%@page import="com.speedobook.bean.DoctorBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<DoctorBean> doctors = (List<DoctorBean>) request.getAttribute("DOCTORS"); %>
<table>
<% for(DoctorBean p : doctors) { %>

<tr>
<form action="Admin">
	<td><%= p.getCode() %></td>
	<td><%= p.getName() %></td>
	<td><%= p.getCharge() %></td>
	<td><input name="limit" value=<%=p.getLimit() %>><input type="hidden" name="code" value="<%=p.getCode() %>">
		<button type="submit">Update</button></td>
		

</form>
</tr>
<% } %>

<td><a href="adddoctor.jsp">Add Doctor</a></td>
<td> <a  href="User.fm?logout=yes">Logout</a></td>
</body>
</html>