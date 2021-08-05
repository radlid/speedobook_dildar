<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2> Add doctor </h2>

<form action="Admin" method="post">
 <label for="code">Doctor Code</label>
        <br>
        <input type="number" name="code" id="code" placeholder="enter doctor code" required >
        <br>
        <br>
        <label for="name">Name</label>
        <br>
        <input type="text" name="name" id="name" placeholder="enter doctor name" required>
        <br><br>
        <label for="department">Department</label>
        <br>
        <input type="text" name="department" id="department" placeholder="enter Doctors department" required>
        <br>
        <br>
        <label for="charge">Charge</label>
          <br>
          <input type="number" name="charge" id="charge" placeholder="Enter Doctor's fee" required>
          <br>
          <br>
           <label for="limit">Limit</label>
           <br>
           <input type="number" name="limit" id="limit" placeholder="enter limit" required>
           <br>
           <br>
           <label for="image">Image url</label>
           <br>
           <input type="text" name="image" id="image" placeholder="enter image url" required>
           <br>
           <br>
           <input id="btn" type="submit" value="Confirm">
           <br>
           <br>
           <input id="btk" type="reset" value="Cancel">
           
</form>
 <td><a  href="User.fm?logout=yes">Logout</a></td>
 

</body>
</html>