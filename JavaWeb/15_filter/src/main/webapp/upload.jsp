<%--
  Created by IntelliJ IDEA.
  User: lchROXis
  Date: 20/1/2022
  Time: 上午10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/15_filter_war_exploded/uploadServlet" method="post" enctype="multipart/form-data">
    username: <input type="text" name="username"><br>
    photo: <input type="file" name="photo"><br>
    <input type="submit">
</form>
</body>
</html>
