$(function() {
	window.onload = function (){
		$("#number").val(getCookie("number"));
		$("#password").val(getCookie("password"));
	}
	$("#cancle").bind("click",function (){
		clear("number","password");
	})
	/*注册按钮*/
	$("#go-register").bind("click",function (){
		window.location.href = "register.html";
	})
	// 登录验证
	$("#log_in").bind("click", function() {
		$("#log_in").toggle();
		$("#loading").fadeToggle(1000);
		if (check("number","password")){
			if(getFormAllData("../login","form1")){
				window.location.href = "index.html";
			}
		}
	})
	windowResize()
	// 监听窗口尺寸变化
	window.addEventListener('resize', windowResize);
})

// 页面初始化
function initialize(divId) {
	var div = document.getElementById(divId);
	// 生成头像部分
	var p = document.createElement("div");
	p.id = "divhead";
	div.appendChild(p);
	div.innerHTML += "<br>";
	div.innerHTML += "<br>";
	// 生成学号
	var numberLable = document.createElement("label");
	numberLable.innerText = "学号";
	numberLable.id = "numberLable";
	div.appendChild(numberLable);
	// 学号输入框
	var number = document.createElement("input");
	number.type = "text";
	number.id = "studentId";
	number.name = "studentId";
	number.setAttribute("placeholder", "请输入学号");
	div.appendChild(number);
	var message1 = document.createElement("span");
	message1.className = "message";
	message1.id = "me1";
	message1.innerText = "*";
	div.appendChild(message1);
	div.innerHTML += "<br>"
	// 生成密码
	var pwdl2 = document.createElement("label");
	pwdl2.innerText = "密码";
	div.appendChild(pwdl2);
	// 密码输入框
	var pwd = document.createElement("input");
	pwd.type = "password";
	pwd.id = "password";
	pwd.name = "password";
	pwd.setAttribute("placeholder", "请输入密码");
	div.appendChild(pwd);
	var message2 = document.createElement("span");
	message2.className = "message";
	message2.id = "me2";
	message2.innerText = "*";
	div.appendChild(message2);
	div.innerHTML = div.innerHTML + "<br>";
	// 生成两个按钮
	var btn1 = document.createElement("input");
	btn1.type = "button";
	btn1.id = "log_in";
	btn1.value = "登录";
	div.appendChild(btn1);
	var btn2 = document.createElement("input");
	btn2.type = "button";
	btn2.id = "cancle";
	btn2.value = "取消";
	div.appendChild(btn2);
	/*生成注册链接*/
	var registerLink = document.createElement("a");
	registerLink.href = "./register.html";
	registerLink.innerText = "去注册";
	div.appendChild(registerLink);
}
// 判空
function check(inputId1,inputId2) {
	var flage = true;
	if ($("#"+inputId1).val() == null){
		$("#"+inputId1).focus();
		alert("请输入账号");
		flage =false;
	}
	if ($("#"+inputId2).val() == null){
		$("#"+inputId2).focus();
		alert("请输入密码");
		flage =false;
	}
	return flage;
}

function clear(inputId1,inputId2) {
	document.getElementById(inputId1).value = " ";
	document.getElementById(inputId2).value = " ";
	document.getElementById("me1").style.color = "red";
	document.getElementById("me2").style.color = "red";
}