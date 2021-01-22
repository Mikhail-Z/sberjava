<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="com">
<head>
    <title>Users</title>
    <style>
        .error {
            color: red;
        }
        .others-message {
            background-color: azure;
            border: 5px black;
            border-radius: 5px;
            padding: 20px;
            margin: 30px
        }
        .my-messages {
            background-color: antiquewhite;
            border: 5px black;
            border-radius: 5px;
            padding: 20px;
            margin: 30px
        }
        .new-message-form {
            display: inline-block;
        }
        #new-message-input {
            height: 250px;
        }
    </style>
</head>
<body>

<jsp:useBean id="currentUser" type="com.company.chat.model.User" scope="session"/>

<div style="text-align: right">
    <form method="get" action="${pageContext.request.contextPath}/auth/login">
        <span>${currentUser.name}</span>
        <button type="submit">Sign out</button>
    </form>
</div>
<div>
    <c:choose>
        <c:when test="${errorMessage != null}">
            <div class="error">
                ${errorMessage}
            </div>
        </c:when>
        <c:otherwise>
            <c:forEach items="${messages}" var="message">
                <jsp:useBean id="message" type="com.company.chat.model.Message" scope="page"/>
                <div class="message-row">
                    <div class="${message.senderUser.id.equals(currentUser.id) ? 'my-messages' : 'others-message'}">
                        <div>
                            ${message.senderUser.name}
                        </div>
                        <div>
                                ${message.text}
                        </div>
                        <div style="text-align: right">
                            <fmt:parseDate value="${message.createDt}" pattern="y-M-dd'T'H:m" var="parsedDate"/>
                            <fmt:formatDate value="${parsedDate}" pattern="dd.MM.YYYY HH:mm"/>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
<div style="text-align: center; margin: 20px">
    <textarea name="newMessage" form="new-message-form" rows="5" style="width: 500px"></textarea>
    <form method="post" id="new-message-form">
        <button type="submit">Send</button>
    </form>
</div>
</body>
</html>