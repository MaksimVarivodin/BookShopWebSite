<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="style.css" rel="stylesheet" />
	<title>Cart</title>
</head>
<body>
<h2>Cart</h2>
<div class="nav">
	<a href="${pageContext.request.contextPath}/booklist">Books</a>
	<a href="${pageContext.request.contextPath}/comicslist">Comics</a>
	<a id="a-cart" href="${pageContext.request.contextPath}/cart">Cart (${k} items)</a>
	<a id="a-login">Login</a>
</div>
<div class="product-all-cart">
	<c:if test="${cart == null}">
		<h3>Cart is empty :(</h3>
	</c:if>
	<div id="form-buy">
		<h2>Create order</h2>
		<h3 id="total-p">Total price: ${cartCost}$</h3>
		<h3 id="total-k">Total count: ${k}</h3>
		<a id="btn-buy" href="${pageContext.request.contextPath}/order">Create order</a>
	</div>

	<c:forEach var="elem" items="${cart}" varStatus="loop">
		<div class="product">
			<div>
				<h3>${elem.name}</h3>
				<p>${elem.price}$</p>
			</div>
			<div>
				<button class="remove-from-cart-btn" value="${elem.id}">Remove</button>
			</div>
		</div>
	</c:forEach>
</div>

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