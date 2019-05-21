<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/21 0021
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        span
        {
            color: red;
           display: none;
        }
    </style>
    <script>
        function x() {
            var psw2 = document.getElementById("psw2").value;
            var psw3 = document.getElementById("psw3").value;
            var psw4 = document.getElementById("psw4");
            if (psw2!=psw3)
            {
                psw4.style.display = "block";
            }else
            {
                psw4.style.display = "none";
            }
        }

        function sub() {
            var psw2 = document.getElementById("psw2").value;
            var psw3 = document.getElementById("psw3").value;
            var psw4 = document.getElementById("psw4");
            if (psw2!=psw3)
            {
                return false;
            }else
            {
                return true;
            }
        }
    </script>
</head>
<body>
    <form action="change.do" method="post" onsubmit="return sub()">
        用户名:<input type="text" name="username"/>
        <br>
        旧密码:<input type="text" name="psw">
        <br>
        新密码:<input type="password" name="psw2" id="psw2">
        <br>
        确认密码:<input type="password" name="psw3" id="psw3" onblur="x()">
        <br>
        <span id="psw4">两次密码不一致</span>
        <input type="submit" value="确认">
    </form>
</body>
</html>
