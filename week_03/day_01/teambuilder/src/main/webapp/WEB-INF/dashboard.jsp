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
<title>Dashboard</title>
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
			<h1 class="p-5">Welcome,${user.firstName }</h1>
			<div>
				<a class="btn btn-danger m-3" href="/logout">Logout</a>
			</div>
		</div>
		<div>
			<div class="d-flex justify-content-between">
				<h2>All Projects</h2>
				<div>
					<a href="/teams/new" class="btn btn-primary">Create Team</a>
				</div>
			</div>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Team Name</th>
						<th scope="col">Game Day</th>
						<th>Rating</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${teamsList }" var="oneTeam">
						<tr>
							<td><a href="/teams/${oneTeam.id }">${oneTeam.teamName }</a></td>
							<td>${oneTeam.gameDay }</td>
							<td>${oneTeam.skillLevel }</td>
							<c:if test="${oneTeam.leader.id == user.id}">
								<td><a href="/teams/edit/${oneTeam.id}">Edit Team</a></td>
							</c:if>
							<c:if test="${oneTeam.leader.id != user.id}">
								<td><a href="/teams/${oneTeam.id}">Join Team</a></td>
							</c:if>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>