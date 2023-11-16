<%--
  Created by IntelliJ IDEA.
  User: Moc Lan
  Date: 11/16/2023
  Time: 8:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Chủ đề : ${topic.title}</title>
</head>
<body>
    <h1>Chủ đề: ${topic.title}</h1>
    <c:set var="lastMessage" value="${topic.messages    [fn:length(topic.messages) - 1]}" />
    <c:choose>
        <c:when test="${not empty topic.messages}">
            <p>Bài mới nhất gửi <fmt:formatDate value="${lastMessage.createdTime.time}" pattern="dd-MM-yyyy hh:mm a"/>
            , do ${lastMessage.creator.username}, ${fn:length(topic.messages)} hồi âm
            </p>
        </c:when>
        <c:otherwise>
            <p>Bài mới nhất gửi <fmt:formatDate value="${topic.createdTime.time}" pattern="dd-MM-yyyy hh:mm a"/>,
                do ${topic.creator.username}. ${fn:length(topic.messages)} hồi
                âm
            </p>
        </c:otherwise>
    </c:choose>

    <table>
        <thead>
        <td colspan="3"><fmt:formatDate value="${topic.createdTime.time}" pattern="dd-MM-yyyy hh:mm a"/></td>
        </thead>
        <tbody>
        <tr>
            <th style="background-color: #e7ffe7; width: 200px;" rowspan="2">
                <p>${topic.creator.username}</p>
                Tham gia
                <fmt:formatDate value="${topic.creator.joinDate}"
                                pattern="dd-MM-yyyy"/>
            </th>
            <td><h3>${topic.title}</h3></td>
            <td style="width: 100px"><a href="reply-topic?topic-id=${topic.id}">Trả lời</a></td>
        </tr>
        <tr>
            <td colspan="3"> ${topic.content}</td>
        </tr>
        </tbody>
    </table>

    <c:if test="${not empty topic.messages}">
        <c:forEach var="message" items="${topic.messages}">

            <br>
            <table>
                <thead>
                    <td colspan="3"><fmt:formatDate value="${message.createdTime.time}" pattern="dd-MM-yyyy hh:mm a"/></td>
                </thead>
                <tbody>
                <tr>
                    <th style="background-color: #e7ffe7; width: 200px;" rowspan="2"><p><b>${message.creator.username}</b>
                    </p>
                        Tham gia
                        <fmt:formatDate value="${message.creator.joinDate}"
                                        pattern="dd-MM-yyyy"/></th>
                    <td><h3>${message.title}</h3></td>
                    <td style="width: 100px;"><a href="reply-topic?topic-id=${topic.id}">Trả lời</a></td>
                </tr>
                <tr>
                    <td colspan="3">${message.content}</td>
                </tr>
                </tbody>
            </table>
        </c:forEach>
    </c:if>
<br>
    <div style="width: 100%; text-align: right">
        <a href="list-topic">Danh sách chủ đề</a>
    </div>
</body>
</html>
