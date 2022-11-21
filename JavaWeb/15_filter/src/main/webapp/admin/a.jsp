<%--
  Created by IntelliJ IDEA.
  User: lchROXis
  Date: 19/1/2022
  Time: 下午1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% if (session.getAttribute("user") == null) {
    request.getRequestDispatcher("/login.jsp").forward(request, response);
    return;
} %>
</body>
</html>
