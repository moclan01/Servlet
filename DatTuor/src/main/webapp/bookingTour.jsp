<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 11/16/2023
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
<h1>
    Đặt tour <b>${tour.description}</b> ${tour.days}
</h1>

<p style="color: red;">${error}</p>

<form action="book-tour" method="post">
    <table>
        <thead>
        <th>Thông tin khách hàng</th>
        <th></th>
        </thead>
        <tbody>
        <tr>
            <td>Họ tên: (*)</td>
            <td><input type="text" name="full-name" id="full-name"
            ></td>
        </tr>
        <tr>
            <td>Địa chỉ:</td>
            <td><input type="text" name="address" id="address"></td>
        </tr>
        <tr>
            <td>Email: (*)</td>
            <td><input type="email" name="email" id="email">
            </td>
        </tr>
        <tr>
            <td>Điện thoại:</td>
            <td><input type="tel" name="phone" id="phone"></td>
        </tr>
        </tbody>
    </table>


    <table>
        <thead>
        <th>Thông tin chuyến đi</th>
        <th></th>
        </thead>
        <tbody>
        <tr>
            <td>Ngày khởi hành: (*)</td>
            <td><input type="text" name="departure-date"
                       id="departure-date"> dd/mm/yyyy
            </td>
        </tr>
        <tr>
            <td>Số người lớn: (*):</td>
            <td><input type="number" min="0" name="adults"
                       id="adults"></td>
        </tr>
        <tr>
            <td>Số trẻ em:</td>
            <td><input type="number" min="0" name="children-persons"
                       id="children"></td>
        </tr>

        <tr>
            <td><input type="hidden" name="tour-id" value="${tour.id}"></td>
            <td><input
                    type="submit" value="Gửi"></td>
        </tr>
        </tbody>
    </table>
</form>
<span><a href="list-tour"><button>Huỷ</button></a></span>
</body>
</html>
