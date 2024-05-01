<%@ page import="jakarta.servlet.http.HttpSession" %><%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 4/29/2024
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>WELLCOME TO MY WEBSITE</h1>
<%
    HttpSession httpSession = request.getSession(false);
    if (session != null && session.getAttribute("name") != null) {
        String name = (String) session.getAttribute("name");
%>
<h2>Xin chào, <%=name%>
</h2>
<form action="/logout" method="post">
    <input type="submit" value="Logout">
</form>
<%} else {%>
<button><a href="/login">Login</a></button>
<button><a href="/register">Register</a></button>
<%}%>
</body>
</html>
