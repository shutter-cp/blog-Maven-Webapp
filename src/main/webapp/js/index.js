//窗口高度
var windowHeight;
//窗口宽度
var windwWidth;
//状态
var temp = 0;
var tt = 0;
//按钮
var openButton = function(){
	if(temp==0){
		phone();
		temp = 1;
	}else{
		if(windwWidth>700){
			wind();
			temp = 0;
		}else{
			phoneWind();
			temp = 0;
		}
	}
}
//收起
var phone = function(){
	$("#myMenu").width(0);
	$("#myMenu").css('display','none');
	$("#myMain").css('margin-left','0px');
	
	$("#myMain-left").css('display','none');
	$("#myMain-left").css('width','0');
	$("#myMain-right").css('display','block');
	$("#myMain-right").css('width','100%');
	$("#main-right").width(windwWidth-10);
}
//展开
var wind = function(){
	$("#myMenu").width(120);
	$("#myMenu").css('display','block');
	$("#myMain").css('margin-left','120px');
	
	$("#myMain-left").css('display','block');
	$("#myMain-left").css('width','30%');
	$("#myMain-right").css('display','block');
	$("#myMain-right").css('width','70%');
	$("#main-right").width($("#myMain-right").width()-10);
}
var phoneWind = function(){
	wind();
	$("#myMain-right").css('width','0');
	$("#myMain-right").css('display','none');
	$("#myMain-left").css('width','100%');
	$("#main-left").width(windwWidth-120);
}
//调整核心
var view = function(){
	$(document).ready(function() {
		windwWidth = $(window).width();
		//调整窗口大小
		windowHeight = $(window).height();
		if(windwWidth>700){
			$("#main-right").height(windowHeight);
			$("#main-right").width($("#myMain-right").width()-10);
		
			$("#main-left").height(windowHeight);
			$("#main-left").width($("#myMain-left").width());
		}
		//响应手机
		if(tt!=windwWidth){
			if(windwWidth<700){
				//alert(1);
				phoneWind();
			}else{
				//alert(2);
				wind();
			}
		}
	})
}
view();
window.onresize=function(){
	tt = windwWidth;
  	view();
}

//登录层弹出
showLogin = function(){
	$('.ui.modal').modal('show');
	$('#loginHTML').html("");
	$('#loginHTML').html(loginHtml);
}

//登录注册之间转换
loginHtml = '<i class="close icon"></i>'+
			'<div class="header">'+
			'	登录'+
			'</div>'+
			'<div class=" content">'+
			'	<div class="description">'+
			'		<div class="loginDiv">'+
			'			<form class="ui form" id="loginForm">'+
			'				<div class="field">'+
			'					<label>用户名</label>'+
			'					<input id="lUserName" type="text" name="f" placeholder="用户名">'+
			'				</div>'+
			'				<div class="field">'+
			'					<label>密码</label>'+
			'					<input id="lPassWord" type="text" name="last-name" placeholder="密码">'+
			'				</div>'+
			'			</form>'+
			'		</div>'+
			'	</div>'+
			'</div>'+
			'<div class="actions">'+
			'	<div class="ui  button" onclick="addForm();">'+
			'		注册'+
			'	</div>'+
			'	<div onclick="login();" class="ui green right labeled icon button">'+
			'		登录'+
			'		<i class="checkmark icon"></i>'+
			'	</div>'+
			'</div>';
addHtml = '<i class="close icon"></i>'+
			'<div class="header">'+
			'	注册'+
			'</div>'+
			'<div class=" content">'+
			'	<div class="description">'+
			'		<div class="loginDiv">'+
			'			<form class="ui form" id="loginForm">'+
			'				<div class="field">'+
			'					<label>用户名</label>'+
			'					<input id="aUserName" type="text" name="first-name" placeholder="用户名">'+
			'				</div>'+
			'				<div class="field">'+
			'					<label>密码</label>'+
			'					<input id="aPassWord" type="text" name="last-name" placeholder="密码">'+
			'				</div>'+
			'				<div class="field">'+
			'					<label>再次输入密码</label>'+
			'					<input id="aPassWords" type="text" name="last-name" placeholder="再次输入密码">'+
			'				</div>'+
			'				<div class="field">'+
			'					<label>email</label>'+
			'					<input id="aEmail" type="text" name="last-name" placeholder="email">'+
			'				</div>'+
			'			</form>'+
			'		</div>'+
			'	</div>'+
			'</div>'+
			'<div class="actions">'+
			'	<div class="ui button" onclick="loginForm();">'+
			'		登录'+
			'	</div>'+
			'	<div onclick="addUser()" class="ui green right labeled icon button">'+
			'		注册'+
			'		<i class="checkmark icon"></i>'+
			'	</div>'+
			'</div>';
loginForm = function(){
	$('#loginHTML').html("");
	$('#loginHTML').html(loginHtml);
}

addForm = function(){
	$('#loginHTML').html("");
	$('#loginHTML').html(addHtml);
}
