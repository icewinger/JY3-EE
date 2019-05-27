<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/27 0027
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询界面</title>
</head>
<body>
<form action="query.do" method="post">

    <table>

    <c:forEach items="${query}" var="query">
        <tr> <td>${query.pro_id}</td>
        <td>${query.pro_name}</td>
        <td>${query.pro_price}</td>
        <td><img src="/imgs/${query.pro_image}" alt="图片被吃掉了"></td>
        <td>${query.pro_des}</td>
        <td>${query.pro_stock}</td>
        <td>${query.pro_date}</td>
        <td>${query.pro_category_id}</td>
        <td>${query.pro_factory}</td></tr>
    </c:forEach>

    </table>
</form>
</body>
</html>
