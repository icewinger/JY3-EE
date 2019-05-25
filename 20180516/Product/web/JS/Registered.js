window.onload = function () {
    var username =/^[a-zA-Z0-9]{6,10}$/;
    var password =/^[a-zA-Z0-9]{6,10}$/;
    var usernameht =document.getElementById("userName");
    var passwordht1 = document.getElementById("psw");
    var check = document.getElementById("code");
    var btn1 = document.getElementById("btn1");
    var p = document.getElementById("p1");
    var p2 = document.getElementById("p2");
    usernameht.onblur =function () {
        var var1 =username.test(usernameht.value);
        if (var1==true)
        {
            p.innerText = "格式正确";
        }else {
            p.innerText = "格式不正确请重新输入";
        }
    }
    passwordht1.onblur =function () {
        var var2 =password.test(passwordht1.value);
        if (var2==true)
        {
            p2.innerText = "格式正确";
        }else {
            p2.innerText = "格式不正确请重新输入";
        }
    }
    var code = null;
    check.onfocus = function () {
        code = makecode();
        var num = document.getElementById("p3");
        num.innerText = code;
    }
    btn1.onclick = function () {
        var b = checkcode(code);

    }
}
function makecode() {
    var code = "";
    var allnum = "ZXCVBNMASDFGHJKLQWERTYUIOPzxcvbnmasdfghjklqwertyuiop1234567890";
    for (var i = 0;i<4;i++)
    {    var index = Math.floor(Math.random()*62);
        code +=allnum[index];
    }
    return code;
}
function checkcode(code) {
    var check = document.getElementById("code");
    var check1 = check.value.toUpperCase();
    var num1 = code.toUpperCase();
    if (check1==num1)
    {
        return true;
    }else {
        return false;
    }

}