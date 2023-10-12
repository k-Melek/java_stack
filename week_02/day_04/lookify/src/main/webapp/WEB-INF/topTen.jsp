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
<title>Top 10 Songs</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<h1>
		Songs by
		<c:out value="${searchTerm}"></c:out>
	</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="song" items="${topTen}">
				<tr>
					<td><a href="/songs/${song.id}"><c:out
								value="${song.name}"></c:out></a></td>
					<td><c:out value="${song.rating}"></c:out></td>
					<td>
						<form action="/songs/${song.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete" />
							<button>delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="/dashboard">Dashboard</a>
	</p>
</body>
</html>