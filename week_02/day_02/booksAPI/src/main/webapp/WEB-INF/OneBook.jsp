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
<title>Show One book</title>
</head>
<body>
	<div class="container">
        <h1>Book Details</h1>
        <hr />
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${thisBook.title}</h5>
                <p class="card-text">Description: ${thisBook.description}</p>
                <p class="card-text">Language: ${thisBook.language}</p>
                <p class="card-text">Number of Pages: ${thisBook.numberOfPages}</p>
            </div>
        </div>
    </div>
</body>
</html>