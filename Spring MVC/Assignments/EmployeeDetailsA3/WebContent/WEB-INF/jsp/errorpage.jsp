<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error page</title>
</head>
<body>
<h1>Employee id ${id} doesn't exists, Check the id and try again</h1>
<jsp:include page="/index.jsp"></jsp:include>
</body>
</html>