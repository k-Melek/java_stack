<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="container">
		<div class="row my-2">
			<div class="col-12">
				<a href="/songs/new" class="btn btn-primary">Add Song</a> <a
					href="/search/topTen" class="btn btn-primary">Top 10 songs</a>
			</div>
		</div>
		<div class="row my-2">
			<div class="col-12">
				<form action="dashboard" method="post" class="form-inline">
					<div class="form-group">
						<input id="artist" name="artist" class="form-control"
							placeholder="Search" />
					</div>
					<button type="submit" class="btn btn-primary">Search</button>
				</form>
			</div>
		</div>
		<div class="row my-2">
			<div class="col-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th>Rating</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="song" items="${songs}">
							<tr>
								<td><a href="/songs/${song.id}"><c:out
											value="${song.name}" /></a></td>
								<td><c:out value="${song.rating}" /></td>
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
			</div>
		</div>
	</div>
</body>
</html>
