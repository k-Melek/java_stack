<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Fruity Loops</title>
</head>
<body>
	<h1>Fruit Store</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${fruits}" var="fruit">
            <tr>
                <td>${fruit.name}</td>
                <td>${fruit.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>