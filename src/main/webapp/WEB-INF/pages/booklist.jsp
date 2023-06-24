<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="style.css" rel="stylesheet" />
    <title>Booklist</title>
</head>
<body>
<h2>Booklist</h2>
<div class="nav">
    <a href="${pageContext.request.contextPath}/booklist">Books</a>
    <a href="${pageContext.request.contextPath}/comicslist">Comics</a>
    <a id="a-cart" href="${pageContext.request.contextPath}/cart">Cart (${k} items)</a>
    <a id="a-login">Login</a>
</div>
<div class="product-all">
    <c:forEach var="elem" items="${booklist}" varStatus="loop">
        <div class="product">
            <div>
                <h3>${elem.name}</h3>
                <h4>Author</h4>${elem.authorName}<br>
                <div style="display: inline-grid"><h5>Pages:</h5>${elem.pages}</div>
                <div style="display: inline-grid"><h5>Words</h5>${elem.words}</div>
            </div>
            <div>
                <button class="add-to-cart-btn" value="${elem.id}">${elem.price}$</button>
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
<div id="added-to-cart">
    <h3>Added to cart!</h3>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="script.js"></script>
</body>
</html>