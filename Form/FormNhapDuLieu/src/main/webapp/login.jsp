<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 4/29/2024
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
    <label for="username">Username: </label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="password">Password: </label>
    <input type="password" id="password" name="password" required>
    <br>
    <input type="submit" value="Đăng nhập">
</form>
<%--    java--%>
<%
    String error = (String) request.getAttribute("error");
    String fail = (String) request.getAttribute("fail");
    if (fail != null && !fail.isEmpty()) {
%>
<p style="color: red"><%=fail%>
</p>
<%} else if (error != null && !error.isEmpty()) {%>
<p style="color: red"><%=error%>
</p>
<%}%>
</body>
</html>
