<%--
  Created by IntelliJ IDEA.
  User: lchROXis
  Date: 2022/01/10
  Time: 下午 02:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>all accounts.</h3>

<c:forEach items="${list}" var="account">
    ${account.toString()}
</c:forEach>


<br/>

</body>
</html>
