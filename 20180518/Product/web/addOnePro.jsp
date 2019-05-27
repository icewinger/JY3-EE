<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/24 0024
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body class="container">
<form  method="post" action="add.do" enctype="multipart/form-data">
    <div class="form-group" >
        <label for="proName">商品名称</label>
        <input type="text" class="form-control" id="proName" placeholder="商品名称" name="proName">
    </div>
    <div class="form-group">
        <label for="proPrice">商品价格</label>
        <input type="number" class="form-control" id="proPrice" placeholder="商品价格" min="1.00" max="99999999.99" name="proPrice">
    </div>
    <div class="form-group">
        <label for="file1">商品图片</label>
        <input type="file" id="file1" accept="image/jpeg" name="file1">
        <p class="help-block">请选择图片</p>
    </div>
    <div class="form-group">
        <label for="proPrice">商品详情</label>
        <br>
       <textarea placeholder="请输入商品详细信息" style="width: 100%" id="proDes" name="proDes"></textarea>
    </div>
    <div class="form-group">
        <label for="proStock">商品库存</label>
        <input type="number" class="form-control" id="proStock" name="proStock" placeholder="商品库存" min="0" max="9999">
    </div>
    <div class="form-group">
        <label for="proCateId">类别ID</label>
        <input type="number" class="form-control" id="proCateId" name="proCateId" placeholder="商品类别ID" min="1" max="999">
    </div>
    <div class="form-group">
        <label for="proFac">生产厂家</label>
        <input type="text" class="form-control" id="proFac" name="proFac" placeholder="生产厂家" >
    </div>
    <button type="submit" class="btn btn-default">确认提交</button>
</form>
</body>
</html>
