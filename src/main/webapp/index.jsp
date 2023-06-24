<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 21.05.2023
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="style.css" rel="stylesheet" />
    <title>Welcome page</title>
</head>
<body>
<h2>Welcome to the shop!</h2>
<div class="nav">
    <a href="${pageContext.request.contextPath}/booklist">Books</a>
    <a href="${pageContext.request.contextPath}/comicslist">Comics</a>
    <a id="a-cart" href="${pageContext.request.contextPath}/cart">Cart (0 items)</a>
    <a id="a-login">Login</a>
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
