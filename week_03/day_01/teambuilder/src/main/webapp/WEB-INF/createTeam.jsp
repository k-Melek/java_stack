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
        <h1>New Team</h1>
        <a href="/teams" class="btn btn-link">Dashboard</a>
        <hr />
        <!-- Form to create a Team -->
        <form:form action="/teams/new" method="post" modelAttribute="team">
            <form:errors class="text-danger" path="*"/>
            <div class="form-group">
                <form:label path="teamName">Team Name</form:label>
                <form:input path="teamName" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="skillLevel">Skill Level</form:label>
                <form:input type="number" path="skillLevel" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="gameDay">Game Day</form:label>
                <form:input path="gameDay" class="form-control"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</body>
</html>