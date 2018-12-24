<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>错误页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="icon" type="image/png" href="admin/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="admin/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="admin/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="admin/assets/css/amazeui.min.css" />
    <script src="admin/assets/js/jquery.min.js"></script>
	<style type="text/css">
		#main{
		  	margin: 50px 200px;
		  	border-radius: 10px;
		 	box-shadow: 0px 80px 30px 5px rgba(0, 0, 0, 0.3);
		}
		#go{
			width: 80%;
			margin: 0 auto;
			margin-top: 10px;
			border-radius: 10px;
		}
		.myButton{
			min-height: 40px;
		}
	</style>
  </head>
  
<body data-type="widgets">
    <script src="assets/js/theme.js"></script>
    
       <!-- 内容区域 -->
    <button type="button" class="am-btn am-btn-warning am-btn-block myButton" >error:${errorMsg }</button>
	<div class="am-panel am-panel-default" id="main">
	
		<div class="am-panel-bd">
			<img src="img/error.png" class="am-img-responsive" alt="" id="imgs"/>
		</div>
		<button type="button" class="am-btn am-btn-primary am-btn-block" id="go" onclick="goBack();">返回</button>
	</div>
	
    <script src="admin/assets/js/amazeui.min.js"></script>
    <script type="text/javascript" src="js/cp.js"></script>
</body>
	<script type="text/javascript">
	$(document).ready(function() {
		var windowHeight = $(window).height();
		var windowWidth =  $(window).width();
		$("#main").height(windowWidth/3);
		$("#imgs").height(windowWidth/4);
		$("#imgs").css("margin","0 auto");
	})
	</script>
</html>