<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 11/14/2023
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>Bid List</title>
    <style>
        table, td, th {
            border: 1px solid #000;
            border-collapse: collapse;
        }

    </style>
</head>
<body>
<jsp:include page="Welcome.jsp"></jsp:include>
<h1>Danh sách mục đấu giá</h1>
<table>
    <thead>
    <th>Mặt hàng</th>
    <th>Giá</th>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">
        <tr>
            <td><a href="show-topic?topic-id=${item.id}">${item.description}</a></td>
                <%--            href="show-topic?topic-id=${item}"--%>
            <td>
                <p>Giá khởi đầu: ${item.initialPrice}</p>
                <c:if test="${not empty item.bids}">
                    <p>Giá hiện tại: ${item.currentPrice}</p>
                    <p>(có ${fn:length(item.bids)} lời đặt giá)</p>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
