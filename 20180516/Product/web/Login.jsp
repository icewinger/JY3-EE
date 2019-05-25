<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/25 0025
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body class="container">
<form action="Login.do" method="post">
    <div class="form-group">
        <label for="username">用户名</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
    </div>
    <div class="form-group">
        <label for="psw">密码</label>
        <input type="password" class="form-control" id="psw"  name="psw" placeholder="密码">
    </div>
    <button type="submit" class="btn btn-default">登陆</button>
</form>
</body>
</html>
