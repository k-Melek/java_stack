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
<div class="container p-3">
		<h1>Edit Project 📰</h1>
		<form:form action="/projects/edit/${project.id}" method="post" modelAttribute="project"
			class="col-3">
			<input type="hidden" name="_method" val="put" />
			<form:errors path="*" />

			<p>
				<form:label path="title" class="form-label">Title</form:label>
				<form:input class="form-control" path="title" />
			</p>
			
			<p>
				<form:label path="description" class="form-label">Description</form:label>
				<form:textarea path="description" class="form-control" name="description" id="description"></form:textarea>
			</p>
			
			<p>
				<form:label path="dueDate" class="form-label">Due Date</form:label>
				<form:input type="date" class="form-control" path="dueDate" />
			</p>
			
			<div class="d-flex justify-content-end">
			<button class="btn btn-success">Submit</button>
			<a href="/dashboard"  class="btn btn-danger mx2">Cancel</a>
			</div>
			
	
	</form:form>
	</div>
</body>
</html>