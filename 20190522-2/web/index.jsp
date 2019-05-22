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
  </head>
  <body>
  <table border="1px" >
    <thead>
      <th>id</th>
      <th>用户名</th>
      <th>密码</th>
      <th></th>
      <th></th>
    </thead>
    <c:forEach var="user" items="${users}">
      <form action="delete.do" method="post">
      <tr>
        <td><input value="${user.id}" name="id"></td>
        <td>${user.username}</td>
        <td>${user.psw}</td>
        <td><button><a href="ChangePsw.jsp">修改</a></button></td>
        <td><button type="submit">删除</button></td>
      </tr>
      </form>
    </c:forEach>

  </table>
  </body>
</html>
