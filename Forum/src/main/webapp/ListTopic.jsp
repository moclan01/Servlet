<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 11/16/2023
  Time: 4:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Danh sách chủ đề</title>
  <style>

  </style>
</head>
<body>
<jsp:include page="Welcome.jsp"/>
<h1>Diễn đàn: Chuyện học phí và các chính sách hỗ trợ học tập</h1>

<c:if test="${not empty sessionScope.loginUser}">
    <a href="NewTopic.jsp">
        <button>Gửi bài mới</button>
    </a>
</c:if>

<table>
    <thead>
        <th>Chủ đề</th>
        <th>Hồi âm</th>
    </thead>
    <tbody>
        <c:forEach var="topic" items="${topics}">
            <tr>
                <td>
                    <a href="show-topic?topic-id=${topic.id}">${topic.title}</a>
                    <c:set var="lastMessenge" value="${topic.messages[fn:length(topic.messages) - 1]}"/>
                    <c:choose>
                        <c:when test="${not empty lastMessage}">
                            <p>Bài mới nhất by ${lastMessage.creator.username}, <fmt:formatDate
                                    value="${lastMessage.createdTime.time}"
                                    pattern="dd/MM/yyyy hh:mm a"/></p>
                        </c:when>
                        <c:otherwise>
                            <p>Bài mới nhất by ${topic.creator.username}, <fmt:formatDate
                                    value="${topic.createdTime.time}"
                                    pattern="dd/MM/yyyy hh:mm a"/></p>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:out value="${fn:length(topic.messages)}"/>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
