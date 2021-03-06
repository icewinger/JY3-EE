<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/30 0030
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<style>
    td
    {
        height: 100px;
        width: 200px;
    }
    img
    {
        height: 100%;
        width: 100%;
    }
</style>
<body class="container-fluid">
<table>
    <thead>
    <th>商品名</th>
    <th>商品价格</th>
    <th>商品图片</th>
    <th>商品详情</th>
    <th>商品库存</th>
    <th>商品上架日期</th>
    <th>生产厂家</th>
    </thead>
    <c:forEach items="${query}" var="query">
        <tr> <td>${query.pro_name}</td>
            <td>${query.pro_price}</td>
            <td><img src="/imgs/${query.pro_image}" alt="图片被吃掉了"></td>
            <td>${query.pro_des}</td>
            <td>${query.pro_stock}</td>
            <td>${query.pro_date}</td>
            <td>${query.pro_factory}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
