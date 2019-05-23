<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/22 0022
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="css/indexcss.css">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
      <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
  </head>
  <body class="container-fluid">
  <table border="1px" class="table table-bordered"  >
    <thead>
      <th>id</th>
      <th>用户名</th>
      <th>密码</th>
      <th></th>
      <th></th>
    </thead>
    <c:forEach var="user" items="${users}">
      <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.psw}</td>
        <td><a style="color: white" href="show.do?id=${user.id}&username=${user.username}&psw=${user.psw}"><button class="btn btn-primary" >修改</button></a></td>
        <td><a style="color: white" href="delete.do?id=${user.id}"><button  type="submit" class="btn btn-danger">删除</button></a></td>
      </tr>
    </c:forEach>

  </table>
  </body>
</html>
