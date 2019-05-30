<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>Lowin</title>
	<link rel="stylesheet" href="CSS/auth.css">
	<%@page contentType="text/html;charset=utf-8" language="java" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="JS/Registered.js"></script>

</head>

<body>
	<div class="lowin">
		<div class="lowin-brand">
			<img src="imgs/1.jpg" alt="logo">
		</div>
		<div class="lowin-wrapper">
			<div class="lowin-box lowin-login">
				<div class="lowin-box-inner">
					<form method="post" action="/Login.do" onsubmit="return  true">
						<p>登陆</p>
						<div class="lowin-group">
							<label>用户名</label>
                            <a href="http://baidu.com" class="login-back-link">确认登陆</a>
							<input type="text" autocomplete="email" name="email" class="lowin-input">
						</div>
						<div class="lowin-group password-group">
							<label>密码 </label>
							<input type="password" name="password" autocomplete="current-password" class="lowin-input">
						</div>
						<button class="lowin-btn  " type="submit">
							确认登陆
						</button>

						<div class="text-foot">
							没有账户？ <a href="" class="register-link">注册</a>
						</div>
					</form>
				</div>
			</div>

			<div class="lowin-box lowin-register">
				<div class="lowin-box-inner">
					<form method="post" action="addUser.do" onsubmit="return x()">
						<p>创建账号</p>
						<div class="lowin-group">
							<label>用户名</label>
							<input type="text" name="name" autocomplete="name" id="userName" class="lowin-input" placeholder="请输入六到十位的数字字母组合">
                            <span id="p1"></span>
                        </div>
						<div class="lowin-group">
							<label>密码</label>
							<input type="password" autocomplete="email" name="email" id="psw" class="lowin-input" placeholder="请输入六到十位的数字字母组合">
                            <span id="p2"></span>
                        </div>
						<div class="lowin-group">
                            <label>确认密码 <a href="#" class="forgot-link"></a></label>
							<input type="password" name="password" autocomplete="current-password" class="lowin-input" id="psw2" placeholder="请输入六到十位的数字字母组合">
						</div>
                        <div class="lowin-group">
                            <label>验证码 </label>
                            <input type="text" name="code" autocomplete="current-password" id="code" class="lowin-input">
                            <div class="form-group">
                                <span id="p3" style="font-size: 20px"></span>
                            </div>
                        </div>
						<button class="lowin-btn" type="submit" id="btn1">
							提交
						</button>

						<div class="text-foot">
							已经拥有一个账户？ <a href="" class="login-link">登陆</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	
		<footer class="lowin-footer"><a href="http://www.cssmoban.com/" target="_blank" title="模板之家"></a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
		</footer>
	</div>
    <script>

        function x() {
            var username = /^[a-zA-Z0-9]{6,10}$/;
            var password = /^[a-zA-Z0-9]{6,10}$/;
            var username1 = document.getElementById("userName").value;
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
	<script src="JS/auth.js"></script>
	<script>
        Auth.init({
            login_url: '/new.jsp',
            forgot_url: '#forgot'
        });
    </script>
</body>
</html>