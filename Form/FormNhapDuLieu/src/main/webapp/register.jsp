<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 4/29/2024
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Register</h1>
    <form action="register" method="post">
        <label for="username">Username: </label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">Password: </label>
        <input type="password" id="password" name="password" required>
        <br>
        <label for="name">Name: </label>
        <input type="text" id="name" name="name" required>
        <br>
        <label for="email">Email: </label>
        <input type="email" id="email" name="email" required>
        <br>
        <input type="submit" value="Đăng ký">
    </form>
</body>
</html>
