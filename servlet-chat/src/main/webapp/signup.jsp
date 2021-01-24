<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sign up</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h2>Sign up</h2>
<div>
    <form method="post">
        <input name="login" type="text" maxlength="16" placeholder="enter login...">
        <input name="password" type="password" placeholder="enter password...">
        <label for="is-admin-input">I'm admin</label>
        <input id="is-admin-input" name="isAdmin" type="checkbox">
        <button type="submit">Sign up</button>
        <span>
            ${errorMessage}
        </span>
    </form>
</div>

<div>
    <button>
        <a href="${pageContext.request.contextPath}/auth/login">Log in</a>
    </button>
</div></body>
</html>