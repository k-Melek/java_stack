<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <title>Books 📚</title>
</head>
<body>
    <div class="container">
        <h1>Books 📚</h1>
        <hr />
        <a href="/books/new">Create a new book</a>
        <hr />
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Language</th>
                    <th>Pages</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${booksList}" var="oneBook">
                    <tr>
                        <td><a href="/books/${oneBook.id }">${oneBook.title}</a></td>
                        <td>${oneBook.description}</td>
                        <td>${oneBook.language}</td>
                        <td>${oneBook.numberOfPages}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
