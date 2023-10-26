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
<title>Courses Platform</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<h1 class="text-primary text-center">Course Platform - Instructors</h1>
		<div class="row">
			<!-- REGISTER A NEW USER -->
			<div class="col-md-6">
				<div class="login-reg-main border-round give-me-space-up-down">
					<h3>New Instructor:</h3>
					<form:form action="/register" method="post"
						modelAttribute="newUser">
						<div class="form-group">
							<label>First Name:</label>
							<form:input path="firstName" class="form-control" />
							<form:errors path="firstName" class="text-danger" />
						</div>
						<div class="form-group">
							<label>Last Name:</label>
							<form:input path="lastName" class="form-control" />
							<form:errors path="lastName" class="text-danger" />
						</div>
						<div class="form-group">
							<label>Email:</label>
							<form:input path="email" class="form-control" />
							<form:errors path="email" class="text-danger" />
						</div>
						<div class="form-group">
							<label>Password:</label>
							<form:password path="password" class="form-control" />
							<form:errors path="password" class="text-danger" />
						</div>
						<div class="form-group">
							<label>Confirm Password:</label>
							<form:password path="confirm" class="form-control" />
							<form:errors path="confirm" class="text-danger" />
						</div>
						<input type="submit" value="Register" class="btn btn-primary m-2" />
					</form:form>
				</div>
			</div>

			<!-- LOGIN -->
			<div class="col-md-6">
				<div class="login-reg-main border-round">
					<h3>Log In:</h3>
					<form:form action="/login" method="post" modelAttribute="newLogin">
						<div class="form-group">
							<label>Email:</label>
							<form:input path="email" class="form-control" />
							<form:errors path="email" class="text-danger" />
						</div>
						<div class="form-group">
							<label>Password:</label>
							<form:password path="password" class="form-control" />
							<form:errors path="password" class="text-danger" />
						</div>
						<input type="submit" value="Login" class="btn btn-success m-2" />
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>