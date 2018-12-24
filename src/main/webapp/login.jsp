<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
		-->
	
	  <!-- Set render engine for 360 browser -->
	  <meta name="renderer" content="webkit">
	
	  <!-- No Baidu Siteapp-->
	  <meta http-equiv="Cache-Control" content="no-siteapp"/>
	
	  <link rel="icon" type="image/png" href="assets/i/favicon.png">
	
	  <!-- Add to homescreen for Chrome on Android -->
	  <meta name="mobile-web-app-capable" content="yes">
	  <link rel="icon" sizes="192x192" href="assets/i/app-icon72x72@2x.png">
	
	  <!-- Add to homescreen for Safari on iOS -->
	  <meta name="apple-mobile-web-app-capable" content="yes">
	  <meta name="apple-mobile-web-app-status-bar-style" content="black">
	  <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
	  <link rel="apple-touch-icon-precomposed" href="admin/assets/i/app-icon72x72@2x.png">
	
	  <!-- Tile icon for Win8 (144x144 + tile color) -->
	  <meta name="msapplication-TileImage" content="admin/assets/i/app-icon72x72@2x.png">
	  <meta name="msapplication-TileColor" content="#0e90d2">
	
	  <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
	  <!--
	  <link rel="canonical" href="http://www.example.com/">
	  -->
	  <link rel="stylesheet" href="admin/assets/css/amazeui.min.css">
	  <link rel="stylesheet" href="css/login.css">
  </head>
  
<body>
<header>
  <div class="log-header">
      <h1><a href="">Amaze UI</a></h1>
  </div>    
</header>

<div class="log"> 
  <div class="am-g">
  <div class="am-u-lg-3 am-u-md-6 am-u-sm-8 am-u-sm-centered log-content">
    <h1 class="log-title am-animation-slide-top">ChenPeng_blog</h1>
    <br>
    <form class="am-form" id="log-form" action="${basePath }/admin/loginDo" method="post">
      <div class="am-input-group am-radius am-animation-slide-left">       
        <input name="username" type="text" id="doc-vld-email-2-1" class="am-radius" data-validation-message="请输入正确用户名" placeholder="用户名" required/>
        <span class="am-input-group-label log-icon am-radius"><i class="am-icon-user am-icon-sm am-icon-fw"></i></span>
      </div>      
      <br>
      <div class="am-input-group am-animation-slide-left log-animation-delay">       
        <input name="password" type="text" class="am-form-field am-radius log-input" placeholder="密码" minlength="6" required>
        <span class="am-input-group-label log-icon am-radius"><i class="am-icon-lock am-icon-sm am-icon-fw"></i></span>
      </div>      
      <br>
      <button type="submit" class="am-btn am-btn-primary am-btn-block am-btn-lg am-radius am-animation-slide-bottom log-animation-delay">登 录</button>
      <div class="am-btn-group  am-animation-slide-bottom log-animation-delay-b">
      </div>
    </form>
  </div>
  </div>
  <footer class="log-footer">   
    © Copyright © 2018.looc All rights reserved.
  </footer>
</div>


<!--[if (gte IE 9)|!(IE)]><!-->
<script src="admin/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="admin/assets/js/amazeui.min.js"></script>
<script src="admin/assets/js/app.js"></script>
</body>
</html>