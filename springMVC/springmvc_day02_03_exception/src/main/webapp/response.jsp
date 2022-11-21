<%--
  Created by IntelliJ IDEA.
  User: lchROXis
  Date: 2022/01/11
  Time: 下午 05:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

    <script>
        // 页面加载, 绑定单击事件
        $(function () {
            $("#btn").click(function () {
                // alert("hello, btn.");

                // 发送 Ajax 请求
                $.ajax({
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username":"tom", "password":"123", "age":12}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        // data: 服务器返回的数据
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);

                    }
                });
            });
        });
    </script>
</head>
<body>

<%--<a href="user/testString">testString</a>--%>

<%--<a href="user/testVoid">testVoid</a>--%>

<%--<a href="user/testModelAndView">testModelAndView</a>--%>

<%--<a href="user/testForwardOrRedirect">testForwardOrRedirect</a>--%>

<button id="btn">发送 ajax 请求</button>


</body>
</html>
