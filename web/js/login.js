/*登录界面js,@anthor zhangsenlin,2018-06-27*/

var totalNumber;//验证码加数和

/*登录事件*/
function logining() {
    var username = document.getElementById("stu_username_hide").value;
    var password = document.getElementById("stu_password_hide").value;
    console.log("u:"+username);
    console.log("p:"+password);
    if (!login_validate(username,password)){
       return ;
    }
    loginAjax(username,password);
    document.getElementById("stu_username_hide").value = "";
    document.getElementById("stu_password_hide").value = "";
}

/*登录验证*/
function login_validate(username,password) {
    if (username == null || username == ""){
        alert("请输入账号");
        return false;
    }

    if (password == null || password == ""){
        alert("请输入密码");
        return false;
    }

    var number = document.getElementById("input_val").value;
    if (number != totalNumber){
        alert("验证码错误");
        document.getElementById("input_val").value = "";
        return false;
    }

    return true;
}

/*登录请求*/
function loginAjax(username,password){
    debugger;
    //创建ajax
    var ajax = new XMLHttpRequest();
    //servlet地址
    var url="login";
    ajax.open("POST", url, true);
    //ajax处理事件,异步
    ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
            //在这里进行相关处理,通过xhr.responseText获取后台反馈的文本
           var success = ajax.responseText;
           console.log("su:"+success);
           if (success == "true"){
               window.location = "index.html";
           } else  {
               alert("账号或密码错误");
           }
        }
    };
    ajax.send(username+","+password);
}

/*生成验证码*/
function validateCode() {
    var number1 = parseInt(Math.random()*30 + 1);
    var number2 = parseInt(Math.random()*30 + 1);
    var calculate = parseInt(Math.random()*2 + 1);
    if (calculate == 1){
        document.getElementById("show_add").innerText = number1+" + "+number2+" = ?";
        totalNumber = number1 + number2;
    } else {
        document.getElementById("show_add").innerText = number1+" - "+number2+" = ?";
        totalNumber = number1 - number2;
    }
}

