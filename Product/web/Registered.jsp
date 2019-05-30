<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/25 0025
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="JS/Registered.js"></script>
    <script>

        function x() {
            var username = /^[a-zA-Z0-9]{6,10}$/;
            var password = /^[a-zA-Z0-9]{6,10}$/;
            var username1 = document.getElementById("username").value;
            var psw = document.getElementById("psw").value;
            var code = document.getElementById("code").value;
            var psw1 = document.getElementById("psw2").value;
            var p3 = document.getElementById("p3").innerText;
            var check1 = p3.toUpperCase();
            var num1 = code.toUpperCase();

            if (psw == psw1 && check1 == num1) {
                return true;
            } else {
                alert("两次密码不一致或验证码错误")
                return false;
            }

        }


    </script>
</head>
<body class="container">
<form action="/addUser.do" method="post" onsubmit="return x()">
    <div class="form-group">
        <label for="userName">用户名</label>
        <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入六到十位的数字字母组合">
        <span id="p1"></span>
    </div>
    <div class="form-group">
        <label for="psw">密码</label>
        <input type="password" class="form-control" id="psw" name="psw" placeholder="请输入六到十位的数字字母组合">
        <span id="p2"></span>
    </div>
    <div class="form-group">
        <label for="psw2">确认密码</label>
        <input type="password" class="form-control" id="psw2" placeholder="请输入六到十位的数字字母组合">

    </div>
    <div class="form-group">
        <label for="code">验证码</label>
        <input type="text" class="form-control" id="code" name="code" placeholder="忽略大小写">
    </div>
    <div class="form-group">
        <span id="p3" style="font-size: 20px"></span>
    </div>
    <button type="submit" class="btn btn-default" id="btn1">注册</button>
</form>

</body>
</html>
