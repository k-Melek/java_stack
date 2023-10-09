<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
	<h1>Form</h1>
	<hr />
	<h2>Login</h2>
	<form action="/processForm" method="POST">
    <div>
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" />
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" />
    </div>
    <button type="submit">Submit</button>
</form>

</body>
</html>