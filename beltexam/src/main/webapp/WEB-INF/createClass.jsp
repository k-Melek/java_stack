<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tacos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1>Create a course</h1>
		<a href="/classes" class="btn btn-link">Back to Dashboard</a>
		<hr />
		<!-- Form to create a Course -->
		<form:form action="/classes/new" method="post" modelAttribute="yoga">
			<form:errors class="text-danger" path="*" />
			<div class="form-group">
				<form:label path="name">Name</form:label>
				<form:input path="name" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="day">Day of week</form:label>
				<form:input path="day" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="price">Price</form:label>
				<form:input type="number" path="price" class="form-control" />
			</div>

			<!-- Test time -->
			<div class="form-group">
				<form:label path="time">Time</form:label>
				<form:input path="time" type="time" class="form-control" />
			</div>
			<!-- Test time -->

			<div class="form-group">
				<form:label path="description" class="form-label">Description</form:label>
				<form:textarea path="description" class="form-control"
					name="description" id="description"></form:textarea>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>