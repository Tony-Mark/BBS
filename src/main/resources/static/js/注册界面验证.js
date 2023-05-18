// 验证各项数据的有效性和完整性，
// 如用户名不能少于3个字符，密码不能少于6个字符，电话为11位手机等。
// 数据不合理时，动态使用DIV弹出提示。

// 验证码
function changeCode() {
    var arrays = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z'];
    code = ''; //重新初始化验证码
    var checkCode = document.getElementById("checkCode");
    //alert(arrays.length);
    //随机从数组中获取四个元素组成验证码
    for (var i = 0; i < 4; i++) {
        //随机获取一个数组的下标
        var r = parseInt(Math.random() * arrays.length);
        code += arrays[r];
    }
    if (checkCode) {
        //为验证码区域添加样式名
        checkCode.className = "code";
        //将生成验证码赋值到显示区
        checkCode.innerHTML = code;
    }
}
// 验证码校验
//检查验证码是否正确
function validateCode() {
    // 先清除提示信息
    remove_text_code();
    //获取显示区生成的验证码
    var checkCode = document.getElementById("checkCode").innerHTML;
    //获取输入的验证码
    var inputCode = document.getElementById("codeInput").value;
    // 创建用于提示信息的span
    var text = document.createElement("span");
    text.className = "span_code";
    text.setAttribute('id', 'text_code');
    var div0 = document.getElementById("code_div");
    if (inputCode.length <= 0) {
        text.innerText = "请输入验证码";
    } else if(inputCode.toUpperCase() !== checkCode.toUpperCase()) {
        text.innerText = "验证码输入错误，请重新输入";
        changeCode();
    }
    div0.appendChild(text);
}

// 重复密码
function text_repetition_password() {
    var flag = true;
    if (document.getElementById("text")){
        document.getElementById("text").remove();
    }
    var re_pwd = document.getElementById("user_re_password");
    var pwd = document.getElementById("user_password");
    re_pwd.removeAttribute('style', 'border-color:red');
    if (re_pwd.value.toString() !== pwd.value.toString()) {
        var pop_div = document.getElementById("re_password");
        var span0 = document.createElement("span");
        span0.setAttribute('id', 'text');
        span0.innerText = "密码输入不正确，请再次输入";
        pop_div.appendChild(span0);
        re_pwd.value = "";
        re_pwd.setAttribute('style', 'border-color:red');
        console.log("重复密码验证！");
        flag = false;
    }
    return flag;
}
// 提示电话信息
function text_phone_out(T) {
    var flag = true;
    var phone_number = document.getElementById(T);
    var div_phone = document.getElementById("div_phone");
    var ss = /^0*(13|15|18|19)\d{9}$/;
    var rg = new RegExp(ss);
    var bo = rg.test(phone_number.value.toString());
    if (!bo) {
        var text = document.createElement("span");
        text.className = "span_phone";
        text.setAttribute('id', 'phone_format')
        text.innerText = "请正确输入电话号码格式,如:13118129605";
        div_phone.appendChild(text);
        phone_number.value = "";
        phone_number.setAttribute('style', 'border-color: red')
        console.log("电话验证！");
        flag = false;
    }
    return flag;
}
function text_phone_in() {
    var phone_number = document.getElementById("phone");
    var span = document.getElementById("phone_format")
    // 判断元素是否存在
    if (span) {
        span.parentElement.removeChild(span);
        phone_number.removeAttribute('style');
    }
}
// 重新输入验证码时，提示信息清除
function remove_text_code() {
    // 获取该元素
    var text_code = document.getElementById("text_code");
    if (text_code) {
        text_code.remove();
    }
}