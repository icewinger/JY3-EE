<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/22 0022
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="change.do" method="post">
        <input type="hidden" name="id" value="${user.id}">
        用户名<input type="text" name="username" value="${user.username}" />
        <br>
        新密码<input type="password" name="password" value="${user.psw}"/>
        <br>
        <input type="submit" value="确认"/>
    </form>
</body>
</html>
