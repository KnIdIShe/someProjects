<%--
  Created by IntelliJ IDEA.
  User: lchROXis
  Date: 2022/01/10
  Time: 下午 02:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="account/findAll">测试查询</a>
<br>
<h3>测试保存</h3>

<form action="account/save" method="post">
    name: <input type="text" name="name"><br>
    money: <input type="number" name="money"><br>
    <input type="submit" value="submit">
</form>
</body>
</html>
