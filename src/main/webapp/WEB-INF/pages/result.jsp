<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style.css" rel="stylesheet" />
<title>Result</title>
</head>
<body>
	<h2>Result</h2>
	<div class="nav">
		<a href="${pageContext.request.contextPath}/booklist">Books</a>
		<a href="${pageContext.request.contextPath}/comicslist">Comics</a>
		<a id="a-cart" href="${pageContext.request.contextPath}/cart">Cart (0 items)</a>
		<a id="a-login">Login</a>
	</div>
	<h2>Congratulations, you just made a purchase!</h2>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
	<script src="script.js"></script>
</body>
</html>