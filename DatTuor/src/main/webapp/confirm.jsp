<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 11/16/2023
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
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
<h1>Xem lại thông tin đặt tour</h1>
<hr>

<p>Ngày khởi hành: <fmt:formatDate value="${booking.departureDate}" pattern="dd/MM/yyyy" /></p>
<table style="width: 100%">
    <thead>
    <td><h3>Thông tin khách hàng</h3></td>
    <td><h3>Thông tin về tour đã đặt</h3></td>
    </thead>
    <tbody>
    <tr>
        <td>
            <b>Tên khách hàng:</b> ${booking.customer.name}
        </td>
        <td>
            <b>Tên tour:</b> ${booking.tour.description}
        </td>
    </tr>
    <tr>
        <td>
            <b>Địa chỉ:</b> ${booking.customer.address}
        </td>
        <td>
            <b>Số ngày:</b> ${booking.tour.days} ngày
        </td>
    </tr>
    <tr>
        <td>
            <b>Email:</b> ${booking.customer.email}
        </td>
        <td>
            <b>Phương tiện di chuyển:</b> ${booking.tour.transportation}
        </td>
    </tr>
    <tr>
        <td>
            <b>Số điện thoại:</b> ${booking.customer.phone}
        </td>
        <td>
            <b>Lịch trình:</b> ${booking.tour.departureSchedule}
        </td>
    </tr>
    <tr>
        <td></td>
        <td><b>Giá:</b> ${booking.tour.price} VNĐ</td>
    </tr>
    </tbody>
</table>

<c:if test="${not empty booking.tour.details}">
    <h2>Lịch trình:</h2>
    ${booking.tour.details}
</c:if>

<b>Cảm ơn quý khách đã sử dụng dịch vụ!</b>
<br><br><br>
<a href="list-tour">VỀ TRANG ĐẶT TOUR</a>
</body>
</html>
