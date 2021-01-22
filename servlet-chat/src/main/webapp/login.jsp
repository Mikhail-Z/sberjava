<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h2>Login</h2>
<div>
    <form method="post">
        <input name="login" type="text" maxlength="16" placeholder="enter login...">
        <input name="password" type="password" placeholder="enter password...">
        <button type="submit">Log in</button>
        <span class="error">
            ${errorMessage}
        </span>
    </form>
</div>

<div>
    <button>
        <a href="${pageContext.request.contextPath}/auth/signup">Sign up</a>
    </button>
</div></body>
</html>
