<%@ page import="jakarta.servlet.http.HttpSession" %><%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 5/1/2024
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>

</head>
<body>
    <form action="add-product" method="post">
        <label for="name-product">Name Product</label>
        <input type="text" id="name-product" name="name-product">
        <br>
        <label for="type-product">Type Product</label>
        <input type="text" id="type-product" name="type-product">
        <br>
        <label for="quantity-product">Quantity Product</label>
        <input type="number" id="quantity-product" name="quantity-product">
        <br>
        <label for="price-product">Price Product</label>
        <input type="number" id="price-product" name="price-product" step="0.0001">
        <br>
        <input type="submit" value="Thêm sản phẩm">
    </form>
    <%
        HttpSession httpSession = request.getSession(false);
        String username = (String) httpSession.getAttribute("username");
        if(session == null || username == null){

    %>
    <p>Bạn chưa đăng nhập</p>
    <%
        } else {
            String successMessage = (String) request.getAttribute("success");
            if (successMessage != null) {
    %>
        <p><%=successMessage%></p>
    <%
            }
        }%>
</body>
</html>
