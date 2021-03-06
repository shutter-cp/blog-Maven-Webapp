<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>404</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${basePath }/admin/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${basePath }/admin/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="${basePath }/admin/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="${basePath }/admin/assets/css/amazeui.min.css" />
    <script src="${basePath }/admin/assets/js/jquery.min.js"></script>
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
	</style>
  </head>
  
<body data-type="widgets">
    <script src="assets/js/theme.js"></script>
    
       <!-- 内容区域 -->
	<div class="am-panel am-panel-default" id="main">
		<div class="am-panel-bd">
			<img src="img/404.png" class="am-img-responsive" alt="" id="imgs"/>
		</div>
		<button type="button" class="am-btn am-btn-primary am-btn-block" id="go" onclick="goBack();">返回</button>
	</div>
    <script src="${basePath }/admin/assets/js/amazeui.min.js"></script>
    <script type="text/javascript" src="${basePath }/js/cp.js"></script>
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
