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
<title>Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<h1>List of travel expenses</h1>
	<hr />
	<div class="container">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listOfTravels }" var="oneTravel">
					<tr>
						<td>${oneTravel.expense }</td>
						<td>${oneTravel.vendor }</td>
						<td><span>$</span>${oneTravel.amount }</td>
						<td>
							<div class="btn-group" role="group"
								aria-label="Edit and Delete Buttons">
								
								<form action="/travels/${oneTravel.id}" method="post">
									<input type="hidden" name="_method" value="Delete">
									<button class="btn btn-danger mx-2">Delete</button>
								</form>
								
								<a href="/edit/${oneTravel.id}" class="btn btn-primary">Edit</a>
							</div>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr />
		<form:form action="/travels" method="post" modelAttribute="travel"
			class="form">
			<div class="form-group">
				<form:label path="expense">Expense</form:label>
				<form:errors path="expense" />
				<form:input path="expense" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="vendor">Vendor</form:label>
				<form:errors path="vendor" />
				<form:input path="vendor" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="amount">Amount</form:label>
				<form:errors path="amount" />
				<form:input type="text" path="amount" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="description">Description</form:label>
				<form:errors path="description" />
				<form:textarea path="description" class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary mt-2">Submit</button>
		</form:form>
	</div>
</body>
</html>