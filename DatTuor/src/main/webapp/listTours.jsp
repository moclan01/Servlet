<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 11/16/2023
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<jsp:useBean id="toursObj" class="com.example.dattuor.service.TourService" scope="application"/>
<html>
<head>
    <title>Danh sách Tour</title>
    <style>
        table, td, th {
            border: 1px solid #000;
            border-collapse: collapse;
        }

        thead {
            background-color: #ccc;
        }

        tbody > tr:nth-child(even) {
            background-color: #99ffcc;
        }

        tbody > tr:nth-child(odd) {
            background-color: #ccffff;
        }
    </style>
</head>
<body>
<h1>Các Chương trình DU LỊCH</h1>
<table>
    <thead>
    <th>Chương trình</th>
    <th>Lịch khởi hành</th>
    <th>Giá</th>
    <th>Đặt</th>
    </thead>

    <tbody>

    <c:forEach var="tour" items="${toursObj.allTours}">
        <tr>
            <td><a href="tour-details?tour-id=${tour.id}">${tour.description}</a>
                <p>${tour.days }</p></td>
            <td>${tour.departureSchedule}</td>
            <td>
                <fmt:formatNumber type="number" pattern="###.###" value="${tour.price}"/>
            </td>
            <td>
                <a href="book-tour?tour-id=${tour.id}"><img src="<c:url value='/resources/imgs/dat-tour.png'/>" alt="Dat tour"/></a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
