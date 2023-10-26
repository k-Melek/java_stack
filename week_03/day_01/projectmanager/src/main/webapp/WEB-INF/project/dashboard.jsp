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
			<h1 class="p-5">welcome,${user.firstName }</h1>
			<div>
				<a class="btn btn-danger m-3" href="/logout">Logout</a>
			</div>
		</div>
		<div>
			<div class="d-flex justify-content-between">
				<h2>All Projects</h2>
				<div>
					<a href="/projects/new" class="btn btn-primary">Create project</a>
				</div>
			</div>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Project</th>
						<th scope="col">Team Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${notJoinedProjectsList }" var="oneProject">
						<tr>
							<c:if test="${oneProject.lead.id != user.id}">
								<td><a href="/projects/${oneProject.id }">${oneProject.title }</a></td>
								<td>${oneProject.lead.firstName }</td>
								<td><fmt:formatDate value="${oneProject.dueDate}"
										pattern="MMMM dd" /></td>
								<td><a href="/dashboard/join/${oneProject.id }">Join Team</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<h2>Your Projects</h2>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Project</th>
						<th scope="col">Team Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${joinedProjectsList }" var="oneProject">
						<tr>
							<td><a href="/projects/${oneProject.id }">${oneProject.title }</a></td>
							<td>${oneProject.lead.firstName }</td>
							<td><fmt:formatDate value="${oneProject.dueDate}"
									pattern="MMMM dd" /></td>
							<c:if test="${oneProject.lead.id == user.id}">
								<td><a href="/projects/edit/${oneProject.id}">Edit Project</a></td>
							</c:if>
							<c:if test="${oneProject.lead.id != user.id}">
								<td><a href="/dashboard/leave/${oneProject.id}">Leave Team</a></td>
							</c:if>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>