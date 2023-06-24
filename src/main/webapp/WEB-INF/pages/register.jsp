<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style.css" rel="stylesheet" />
<title>Register</title>
</head>
<body>
	<h2>Register</h2>
	<div class="nav">
		<a href="${pageContext.request.contextPath}/booklist">Books</a>
		<a href="${pageContext.request.contextPath}/comicslist">Comics</a>
		<a id="a-cart" href="${pageContext.request.contextPath}/cart">Cart (0 items)</a>
		<a id="a-login">Login</a>
	</div>
	<form action="/lab7/register" method="post">
		<input type="text" name="name" placeholder="Name" value="${name}" />
		<input type="email" name="email" placeholder="Email" value="${email}" />
		<input type="password" name="password" placeholder="Password" />
		<input type="submit" value="Register" />
		<p>${message}</p>
	</form>
	<p>Already have account? <a href="/lab7/login">Login</a></p>
</body>
</html>