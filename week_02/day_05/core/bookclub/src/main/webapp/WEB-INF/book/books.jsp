<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
 <div class="container">
 <div class="d-flex justify-content-around">
 	<h1 class="p-5">List of all Books</h1>
 	<div>
 	<a  class="btn btn-danger m-3" href="/logout">Logout</a>
 	</div>
 </div>
 <div class="d-flex justify-content-around">
 	<h3 class="p-2">Books from everyone's shelves</h3>
 	<div>
 	<a  class="btn btn-primary m-3" href="/books/new">+Add a book to my shelve</a>
 	</div>
 </div>
 <table class="table table-striped table-bordered"  >
   <thead>
   <tr>
   <th>ID</th>
   <th scope="col">Title</th>
   <th>Author</th>
   <th>Posted By</th>
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${listOfBooks }" var="oneBook">
   <tr>
		<td>${oneBook.id }</td>     
		<td><a href="/books/${oneBook.id }">${oneBook.title }</a></td>     
		<td>${oneBook.author }</td>   
		<td>${oneBook.postedBy.firstName }</td>

   </tr>
   </c:forEach>
   </tbody>
   </table>
 
 
 </div>
</body>
</html>