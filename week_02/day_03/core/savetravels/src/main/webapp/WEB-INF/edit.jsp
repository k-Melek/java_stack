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
    <title>Edit Travel</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
 		<h1>Update Travel</h1>
 	<div class="container">
 	<form:form action="/edit/${travel.id }" method="post" modelAttribute="travel" class="form">
 	
 	<input type="hidden" name="_method" value="put" /> 
 	
        <div class="form-group">
            <form:label path="expense">Expense</form:label>
            <form:errors path="expense" />
            <form:input path="expense" class="form-control" />
        </div>
        <div class="form-group">
            <form:label path="vendor">Vendor</form:label>
            <form:errors path="vendor" />
            <form:input path="vendor" class="form-control" />
        </div>
        <div class="form-group">
            <form:label path="amount">Amount</form:label>
            <form:errors path="amount" />
            <form:input type="text" path="amount" class="form-control" />
        </div>
        <div class="form-group">
            <form:label path="description">Description</form:label>
            <form:errors path="description" />
            <form:textarea path="description" class="form-control" />
        </div>
        <button type="submit" class="btn btn-primary mt-2">Submit</button>
    </form:form>
 	</div>
</body>
</html>