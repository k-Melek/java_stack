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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
        <div class="bg-primary border border-dark rounded p-5 m-5">
            <p>
                Here are the values you submitted:

            </p>
            <ul>
                <li><strong>Lucky Number:</strong> <c:out value="${luckyNumber}" /></li>
                <li><strong>City Name:</strong> <c:out value="${cityName}" /></li>
                <li><strong>Person Name:</strong> <c:out value="${personName}" /></li>
                <li><strong>Endeavor or Hobby:</strong> <c:out value="${endeavor}" /></li>
                <li><strong>Living Thing:</strong> <c:out value="${livingThing}" /></li>
                <li><strong>Something Nice:</strong> <c:out value="${somethingNice}" /></li>
            </ul>
            
        </div>
        <p>
            <a href="/omikuji" class="btn btn-primary mt-5">Go Back to Omikuji Form</a>
        </p>
    </div>
</body>
</html>