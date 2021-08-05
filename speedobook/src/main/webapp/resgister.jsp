<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="register.css" type="text/css"> 
</head>
<body>
    <h1>Welcome To SpeedoBook</h1>
 <div class="main">

    <div class="register">
      <h2>Register Here</h2>
<form action="User.fm" method="post">
 <label for="email">Email id</label>
        <br>
        <input type="text" name="email" id="email" placeholder="enter your email" required >
        <br>
        <br>
        <label for="password">Password</label>
        <br>
        <input type="password" name="password" id="password" placeholder="new password" required>
        <br><br>
        <label for="name">Name</label>
        <br>
        <input type="text" name="name" id="name" placeholder="enter your full name" required>
        <br>
        <br>
        <label for="age">Age</label>
          <br>
          <input type="number" name="age" id="age" placeholder="Enter your age" required>
          <br>
          <br>
          <label for="gender">Gender</label>
          <br>
          &nbsp;&nbsp;&nbsp;
          <input type="radio" name="gender" id="male" checked>
          &nbsp;
          <span id="male">Male</span>
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input type="radio" name="gender" id="female">
           &nbsp;
           <span id="female">Female</span>
           <br><br>
           <label for="city">City</label>
           <br>
           <input type="text" name="city" id="city" placeholder="enter your city" required>
           <br>
           <br>
           <label for="mobile">Mobile</label>
           <br>
           <input type="text" name="mobile" id="mobile" placeholder="enter your mobile number" required>
           <br>
           <br>
           <input id="btn" type="submit" value="Confirm">
           <br>
           <br>
           <input id="btk" type="reset" value="Cancel">
</form>
</div>
    </div>
</body>
</html>