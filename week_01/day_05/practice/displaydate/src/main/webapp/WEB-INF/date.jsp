<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current Date</title>
</head>
<body>
	 <h1>Current Date</h1>
    <p><c:out value="${formatedDate}"></c:out></p>
    
    <script type="text/javascript" src="/js/date.js"></script>
</body>
</html>