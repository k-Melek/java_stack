<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
 <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
 <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
<title>Create Book</title>
</head>
<body>
	<div class="container">
        <h1>Create Book</h1>
        <hr />
        <form action="/processBook" method="post">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description" class="form-control" rows="4" required></textarea>
            </div>
            <div class="form-group">
                <label for="language">Language:</label>
                <input type="text" id="language" name="language" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="numberOfPages">Number of Pages:</label>
                <input type="number" id="numberOfPages" name="numberOfPages" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Create Book</button>
        </form>
    </div>
</body>
</html>