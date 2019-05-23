<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/23 0023
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid">
<form action="change.do" method="post">
    <div class="form-group">
        <input type="hidden" name="id" value="${user.id}">
        <label for="exampleInputEmail1">用户名</label>
        <input style="width: 500px" type="text" class="form-control" id="exampleInputEmail1" name="username" value="${user.username}">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">新密码</label>
        <input style="width: 500px" type="text" class="form-control" id="exampleInputPassword1" name="password" value="${user.psw}">
    </div>
    <button type="submit" class="btn btn-default">确认</button>
</form>
</body>
</html>
