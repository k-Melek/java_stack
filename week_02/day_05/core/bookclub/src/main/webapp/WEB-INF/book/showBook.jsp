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
		<div class="d-flex justify-content-around m-3">
			<h1>${book.title }</h1>
			<div>
				<a href="/books" class="btn btn-primary p-2">Back to the shelves</a>
			</div>
		</div>
		<div class="m-3">

			<%--  <h3><span class="text-danger">${LoggedUser.firstName }</span> read <span class="text-primary"> ${book.title }</span> by <span class="text-success">${book.postedBy.firstName }</span></h3> --%>
			<div>
				<c:if test="${LoggedUser.id == book.postedBy.id}">
					<h3>
						You read <span class="text-primary">${book.title }</span>
					</h3>
				</c:if>
				<c:if test="${LoggedUser.id != book.postedBy.id}">
					<h3>
						<span class="text-danger">${book.postedBy.firstName }</span> read
						<span class="text-primary">${book.title }</span> by <span
							class="text-success">${book.author }</span>
					</h3>
				</c:if>
			</div>

			<div>
				<c:if test="${LoggedUser.id == book.postedBy.id}">
					<h3>Here are your thoughts</h3>
				</c:if>
				<c:if test="${LoggedUser.id != book.postedBy.id}">
					<h3>Here are ${book.postedBy.firstName }'s thoughts</h3>
				</c:if>
			</div>
			<hr />
			<blockquote class="blockquote">
				<p class="mb-0">${book.thoughts }</p>
			</blockquote>
			<hr />
		</div>
		<c:if test="${LoggedUser.id == book.postedBy.id}">
			<div class="d-flex justify-content-end m-3">
				<div>
					<form action="/books/${book.id }" method="post">
					<input type="hidden" name="_method" value="delete"/>
					<button class="btn btn-danger ms-3">delete</button>
					</form>
				</div>
				<a href="/edit/${book.id }" class="btn btn-primary ms-3">Edit</a>
			</div>
		</c:if>
	</div>
</body>
</html>