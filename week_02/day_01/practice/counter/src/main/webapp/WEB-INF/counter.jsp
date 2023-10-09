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
<!-- <script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
<title>Counter</title>
</head>
<body>
	<h1 class="text-danger">tEST</h1>
	<p>
		the number of time you've been to <a href="/">Index</a> is :
		<c:out value="${count }"></c:out>
		times
	</p>
	<a href="/">Test another visit?</a>
	<a href="/reset" class="btn btn-danger">Reset Count</a>
</body>
</html>