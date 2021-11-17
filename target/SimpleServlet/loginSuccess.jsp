<%--
  Created by IntelliJ IDEA.
  User: xfzxl
  Date: 17-11-2021
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Login Success</title>
    <link rel="stylesheet" href="loginHome.css">
</head>
<body>
    <main class="container">
        <h1 class="title">Hi <%= request.getAttribute("user") %>, Login successful.</h1>
        <a class="link" href="login.html">Log Out</a>
    </main>
</body>
</html>
