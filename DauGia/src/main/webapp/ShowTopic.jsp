<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 11/15/2023
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Thông tin đấu giá</title>
</head>
<body>
<jsp:include page="Welcome.jsp"></jsp:include>
<c:set var="item" value="${auctionItem}"/>
<h1>${item.description}</h1>
    <table>
      <thead>
        <th></th>
        <th><h1>Thông tin người bán</h1></th>
      </thead>
    <tbody>
    <tr>
        <td>Giá hiện tại: ${item.currentPrice}</td>
        <td>Tên tài khoản: ${item.seller.username}</td>
    </tr>
    <tr>
        <c:set var="newestBid" value="${item.bids[fn:length(item.bids) - 1]}"/>
        <td>Người đặt: ${newestBid.bidder.username} (có ${fn:length(item.bids)} đặt giá)</td>
        <td>Tên cửa hàng: ${item.seller.fullName}</td>
    </tr>
    <tr>
        <td>Giá khởi điểm: ${item.initialPrice}</td>
        <td>Điện thoại: ${item.seller.phone}</td>
    </tr>
    <tr>
        <td>Bước giá: ${item.priceStep}</td>
        <td>Email: <a href="mailto:${item.seller.email}">${item.seller.email}</a></td>
    </tr>
    <tr>
        <td>Bắt đầu lúc: <fmt:formatDate value="${item.startDate.time}" pattern="HH:mm:ss" /> Ngày <fmt:formatDate value="${item.startDate.time}" pattern="dd/mm/yyyy" /></td>
        <td>Địa chỉ: ${item.seller.address}</td>
    </tr>
    <tr>
        <td>Kết thúc lúc: <fmt:formatDate value="${item.endDate.time}"/>Ngày<fmt:formatDate value="${item.endDate.time}" pattern="dd/mm/yyyy"/></td>
        <td></td>
    </tr>
    <tr>
        <td>Thời gian còn:  ${item.duration.days } ngày ${item.duration.hours } giờ ${item.duration.minutes } phút ${item.duration.seconds} giây</td>
        <td></td>
    </tr>
    <tr>
        <td>
            <form action="bid" method="post">
                <table>
                    <tr>
                        <td>Giá đặt</td>
                        <td><input type="number" name="bid-price"> >= ${item.priceStep + item.currentPrice}</td>
                    </tr>
                    <tr>
                        <td><input type="hidden" value="${item.id}" name="item-id"></td>
                        <td><input type="submit" value="Đặt giá">
                            <p>${bidError}</p>
                        </td>
                    </tr>
                </table>
            </form>
        </td>
        <td></td>
    </tr>
    </tbody>
</table>
<a href="list-items"> Danh sách đấu giá</a>
</body>
</html>
