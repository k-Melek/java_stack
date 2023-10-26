<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
  <div class="container">
 <div>
<h1>Class Details</h1>
 <a href="/classes">Back to Dashboard</a>
 </div>

<table class="table table-stripped table-bordered border">
    <tbody>
    	<tr>
            <td>Class Name: <c:out value="${yoga.name}"></c:out></td>
        </tr>
        
        <tr>
            <td>Cost: $<c:out value="${yoga.price}"></c:out></td>
        </tr>
        
        <tr>
            <td>Description: <c:out value="${yoga.description}" ></c:out></td>
        </tr>
        <tr>
            <td>Time: <c:out value="${yoga.time}" ></c:out></td>
        </tr>
    </tbody>
</table>

 
 
 </div>
</body>
</html>