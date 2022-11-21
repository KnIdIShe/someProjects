<%--
  Created by IntelliJ IDEA.
  User: lchROXis
  Date: 18/1/2022
  Time: 下午7:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/13_cookie_session_war_exploded/loginServlet" method="get">
    username: <input type="text" name="username" value="${cookie.username.value}"><br>
    password: <input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
