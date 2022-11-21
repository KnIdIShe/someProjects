<%--
  Created by IntelliJ IDEA.
  User: lchROXis
  Date: 2022/01/11
  Time: 下午 05:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<h3>traditional file upload</h3>--%>

<%--<form action="user/fileUpload01" method="post" enctype="multipart/form-data">--%>
<%--    选择文件: <input type="file" name="upload"><br>--%>
<%--    <input type="submit" value="upload">--%>
<%--</form>--%>

<%--<h3>SpringMVC file upload</h3>--%>

<%--<form action="user/fileUpload02" method="post" enctype="multipart/form-data">--%>
<%--    选择文件: <input type="file" name="upload"><br>--%>
<%--    <input type="submit" value="upload">--%>
<%--</form>--%>

<h3>跨服务器 file upload</h3>

<form action="user/fileUpload03" method="post" enctype="multipart/form-data">
    选择文件: <input type="file" name="upload"><br>
    <input type="submit" value="upload">
</form>

</body>
</html>
