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
<title>Classes Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">

		<div class="d-flex justify-content-between">
			<h1 class="p-5">Namaste ,${user.firstName }</h1>
			<div>
				<a class="btn btn-danger m-3" href="/logout">Logout</a>
			</div>
		</div>
		<div>
			<div class="d-flex justify-content-between">
				<h2>All Projects</h2>
				<div>
					<a href="/classes/new" class="btn btn-primary">+ new course</a>
				</div>
			</div>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Class Name</th>
						<th scope="col">Instructor</th>
						<th>WeekDay</th>
						<th>Price</th>
						<th>Time</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${classesList }" var="oneClass">
						<tr>
							<td><a href="/classes/${oneClass.id }">${oneClass.name }</a>
								<c:if test="${oneClass.postedBy.id == user.id}">
									<a class="btn btn-primary" href="/classes/edit/${oneClass.id }">Edit</a>
								</c:if></td>
							<td>${oneClass.postedBy.firstName }</td>
							<td>${oneClass.day }</td>
							<td><span>$</span>${oneClass.price }</td>
							<td>${oneClass.time}</td>


						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>