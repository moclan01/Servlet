<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 11/14/2023
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        .form-container {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<form action="login" method="post" class="form-container">
    <table>
        <tr>
            <td align="center" colspan="2">Đăng nhập</td>
        </tr>
        <tr>
            <td>Tên đăng nhập</td>
            <td><input type="text" name="username" id="username" size="30"></td>
        </tr>
        <tr>
            <td>Mật khẩu</td>
            <td><input type="password" name="password" id="password" size="30"></td>
        </tr>
        <tr>
            <td align="center" colspan="2"><input type="submit" value="Đăng nhập"></td>
        </tr>
        <tr>
            <td align="center" colspan=""> ${errorLogin}</td>
        </tr>
    </table>
</form>
</body>
</html>
