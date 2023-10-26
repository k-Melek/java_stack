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
		<div class="form">
			<h1>
				<c:out value="${team.teamName}" />
			</h1>
			<a href="/teams" class="btn btn-link">Dashboard</a>
			<p>
				<strong>Team Name:</strong>
				<c:out value="${team.teamName}" />
			</p>
			<p>
				<strong>Skill Level:</strong>
				<c:out value="${team.skillLevel}" />
			</p>
			<p>
				<strong>Game Day:</strong>
				<c:out value="${team.gameDay}" />
			</p>

			<c:if test="${user_id == team.leader.id}">
				<a href="/teams/edit/${team.id}" class="btn btn-primary">Edit</a>
				<form action="/teams/${team.id}" method="post"
					style="display: inline;">
					<input type="hidden" name="_method" value="delete">
					<button type="submit" class="btn btn-danger">Delete</button>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>