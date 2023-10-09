<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1 class="text-primary">Omikuji form</h1>
		<form action="/omikuji/show" method="post">
			<div class="form-group">
				<label for="luckyNumber">Pick any number from 5 to 25:</label> <input
					type="number" class="form-control" id="luckyNumber"
					name="luckyNumber">
			</div>
			<div class="form-group">
				<label for="cityName">Enter the name of any city:</label> <input
					type="text" class="form-control" id="cityName" name="cityName">
			</div>
			<div class="form-group">
				<label for="personName">Enter the name of any real person:</label> <input
					type="text" class="form-control" id="personName" name="personName">
			</div>
			<div class="form-group">
				<label for="endeavor">Enter professional endeavor or hobby:</label>
				<input type="text" class="form-control" id="endeavor"
					name="endeavor">
			</div>
			<div class="form-group">
				<label for="livingThing">Enter any type of living thing:</label> <input
					type="text" class="form-control" id="livingThing"
					name="livingThing">
			</div>
			<div class="form-group">
				<label for="somethingNice">Say something nice to someone:</label>
				<textarea class="form-control" id="somethingNice"
					name="somethingNice" rows="4"></textarea>
			</div>
			<div class="form-group">
				Send and Show a friend
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>

	</div>
</body>
</html>