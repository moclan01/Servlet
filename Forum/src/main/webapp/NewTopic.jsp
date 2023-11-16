<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 11/16/2023
  Time: 5:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chủ đề mới</title>
</head>
<body>
    <jsp:include page="Welcome.jsp"></jsp:include>

    <form action="new-topic" method="post">
        <h2>Tiêu đề</h2>
        <input type="text" name="title" style="width: 400px">
        <h2>Nội dung</h2>
        <textarea name="contemt" style="width: 500px; height: 200px"></textarea>
    </form>

    <button onclick="document.querySelector('form').submit()">Gởi</button>
    <a href="list-topic">Hủy bỏ</a>
</body>
</html>
