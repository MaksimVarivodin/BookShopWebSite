<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="style.css" rel="stylesheet" />
	<title>Order</title>
</head>
<body>
<h2>Order</h2>
<div class="nav">
	<a href="${pageContext.request.contextPath}/booklist">Books</a>
	<a href="${pageContext.request.contextPath}/comicslist">Comics</a>
	<a id="a-cart" href="${pageContext.request.contextPath}/cart">Cart (0 items)</a>
	<a id="a-login">Login</a>
</div>

<form id="form-order" action="${pageContext.request.contextPath}/order" method="post">
	<h2>Order</h2>
	<label for="card-order">Credit card:</label>
	<c:if test="${message == null}">
		<input type="number" id="card-order" name="card">
	</c:if>
	<c:if test="${message != null}">
		<input type="number" id="card-order" name="card" disabled>
	</c:if>
	<label for="cvv-order">CVV:</label>
	<c:if test="${message == null}">
		<input type="number" id="cvv-order" name="cvv">
	</c:if>
	<c:if test="${message != null}">
		<input type="number" id="cvv-order" name="cvv" disabled>
	</c:if>
	<p id="msg-order">${message}</p>
	<h3>Total price: ${cartCost}$</h3>
	<c:if test="${message == null}">
		<input id="btn-order" type="submit" value="Buy all">
	</c:if>
	<c:if test="${message != null}">
		<input id="btn-order" type="submit" value="Buy all" disabled>
	</c:if>
</form>

<div id="form-login">
	<h2>Login</h2>
	<label for="email-login">Email:</label>
	<input type="text" id="email-login">
	<label for="password-login">Password:</label>
	<input type="password" id="password-login">
	<p id="msg-login"></p>
	<button id="btn-login">Log in</button>
	<a id="anthr-login">I don`t have an account</a>
	<a id="close-login">Close</a>
</div>
<div id="form-register">
	<h2>Register</h2>
	<label for="name-register">Name:</label>
	<input type="text" id="name-register">
	<label for="email-register">Email:</label>
	<input type="text" id="email-register">
	<label for="password-register">Password:</label>
	<input type="password" id="password-register">
	<p id="msg-register"></p>
	<button id="btn-register">Register</button>
	<a id="anthr-register">I already have an account</a>
	<a id="close-register">Close</a>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="script.js"></script>
</body>
</html>