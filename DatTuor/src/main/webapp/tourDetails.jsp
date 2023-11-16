<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 11/16/2023
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
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
<a href="book-tour?tour-id=${tour.id}"><img
        src="<c:url value='/resources/imgs/dat-tour.png'/>" alt="Dat tour" /></a>
<h3>${tour.description}</h3>
<p>
    <b>Số ngày: </b> ${tour.days}. <b>Phương tiện: </b>
    ${tour.transportation}. <b>Lịch khởi hành: </b>
    ${tour.departureSchedule}
</p>
<br>

<c:if test="${not empty tour.details}">
    <h1>Chương trình chi tiết:</h1>
    <br> ${tour.details} <br>
    <br>
</c:if>

<table style="width: 100%;">
    <tr>
        <td style="text-align: left"><a href="book-tour?tour-id=${tour.id}"><img
                src="<c:url value='/resources/imgs/dat-tour.png'/>" alt="Dat tour" /></a>
        </td>
        <td style="text-align: right"><a href="list-tour">CHƯƠNG TRÌNH TOUR</a></td>
    </tr>
</table>
</body>
</html>
