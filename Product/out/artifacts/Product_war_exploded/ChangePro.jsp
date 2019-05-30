<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/29 0029
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body class="container">
<form action="change.do" method="post">
    <div class="form-group" >
        <label for="proName">商品名称</label>
        <input type="text" class="form-control" id="proName" placeholder="商品名称" name="proName" value="${product.pro_name}">
    </div>
    <div class="form-group" >
        <label for="proprice">商品价格</label>
        <input type="text" class="form-control" id="proprice" placeholder="商品价格" name="proprice" value="${product.pro_price}">
    </div>
    <div class="form-group" >
        <label for="prodes">商品详情</label>
        <input type="text" class="form-control" id="prodes" placeholder="商品详情" name="prodes" value="${product.pro_des}" >
    </div>
    <div class="form-group" >
        <label for="prostock">商品库存</label>
        <input type="text" class="form-control" id="prostock" placeholder="商品库存" name="prostock" value="${product.pro_stock}" >
    </div>
    <div class="form-group" >
        <label for="profactory">生产厂家</label>
        <input type="text" class="form-control" id="profactory" placeholder="生产厂家" name="profactory" value="${product.pro_factory}" >
        <input type="hidden" value="${product.pro_id}" name="id">
        <button type="submit" >确认</button>
    </div>

</form>
</body>
</html>
