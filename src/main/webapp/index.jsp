<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>陈鹏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" href="${basePath }/css/semantic.min.css" />
	<link rel="stylesheet" type="text/css" href="${basePath }/css/buttons.css"/>
	<link rel="stylesheet" type="text/css" href="${basePath }/css/component.css"/>
	<link rel="stylesheet" type="text/css" href="${basePath }/css/index.css"/>
	<script type="text/javascript" src="${basePath }/js/jquery-3.3.1.min.js" ></script>
	<script type="text/javascript" src="${basePath }/css/anchorHoverEffect.js" ></script>
  </head>
  
	<body>
		<div class="ui left fixed vertical center aligned segment borderless menu" id="myMenu">
			<!--logo-->
			<a class="item">
				<div class="ui image">
					<img class="ui tiny image" src="img/logo.gif" />
				</div>
				<div class="ui image">
					<img class="ui small  image" src="img/logo.png" />
				</div>
			</a>
			<!--menu-->
			<div class="ui divider"></div>
			<a class="item active"><i class="camera retro icon"></i>摄影</a>
			<a class="item"><i class="chrome icon"></i>前端</a>
			<a class="item"><i class="code icon"></i>编程</a>
			<a class="item"><i class="home icon"></i>思考</a>
			<a class="item"><i class="lightbulb outline icon"></i>想法</a>
			<a class="item"><i class="tags icon"></i>标签</a>
			<a class="item"><i class="archive icon"></i>归档</a>
			<a class="item"><i class="sistrix icon"></i>搜索</a>
			<a class="item"><i class="info circle icon"></i>关于我</a>
			
		</div>
		<!---------------------主体---------------------------->
		<!---------------------主体---------------------------->
		<!---------------------主体---------------------------->
		<!---------------------主体---------------------------->
		<div class="ui segment vertical basic" id="myMain">
			<div class="ui grid">
				<!---------------------左边---------------------------->
				<!---------------------左边---------------------------->
				<!---------------------左边---------------------------->
				<!---------------------左边---------------------------->
				<div id="myMain-left">
					<div id="main-left" class="ui segment vertical">
						<!--查询框-->
						<div class="ui segment vertical center aligned basic">
							<div class="ui labeled mini input">
								<div class="ui label">查询</div>
								<input type="text" placeholder="">
							</div>
							<div class="fondButton">
								   <button class="button button-square button-tiny">##</button>
							</div>
						</div>
						<div class="ui divider"></div>
						<!--列表-->
						<div class="myList">
							<div class="ui segment center aligned vertical basic">
								<nav class="cl-effect-21">
									<a style="font-size: 14px;"  href="">应用单元测试的策略与实践</a><br />
									<a style="font-size: 14px;"  href="">应用单元测试的策略与实践</a><br />
									<a style="font-size: 14px;"  href="">应用单元测试的策略与实践</a><br />
									<a style="font-size: 14px;"  href="">应用单元测试的策略与实践</a><br />
									<a style="font-size: 14px;"  href="">应用单元测试的策略与实践</a><br />
									<a style="font-size: 14px;"  href="">应用单元测试的策略与实践</a><br />
									<a style="font-size: 14px;"  href="">应用单元测试的策略与实践</a><br />
									<a style="font-size: 14px;"  href="">应用单元测试的策略与实践</a><br />
								</nav>
							</div>
						</div>
						<!--分页-->
						<div class="myFY">
							<div class="ui circular labels">
								<a class="ui label" onclick="pageLeft();">&lt;&lt;</a>
								<span id="fys"></span>
								<a class="ui label" onclick="pageRight();">&gt;&gt;</a>
							</div>
						</div>
					</div>
				</div>
				<!---------------------右边---------------------------->
				<!---------------------右边---------------------------->
				<!---------------------右边---------------------------->
				<!---------------------右边---------------------------->
				<div id="myMain-right">
					<div id="main-right" class="ui segment vertical">
						<div class="ui raised segment htmlMain" style="margin-bottom: 20px;">
							<!--标题-->
							<div class="ui segment vertical">
									<div class="ui huge center aligned header">巨型标题</div>
									<p class="ui right floated header">日期</p><br />
							</div>
							<div class="mainText">
								沙发舒服沙发舒服沙发舒服沙发舒服沙发舒服沙发舒服沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服沙发舒服沙发舒服沙发舒服沙发舒服沙发舒服沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />
								沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />沙发舒服<br />zuihyih<br />zuihyih<br /><br />
							</div>
							<!--评论-->
							<h4 class="ui horizontal divider header"><i class="bullhorn icon"></i>评论</h4>
							<div class="myCom" >
								<div class="ui comments" style="margin: 0 auto;">
									<div class="ui segment">
										<div class="comment">
											<a class="avatar">
												<img style="height: 35px" src="${basePath }/img/matt.jpg">
											</a>
											<div class="content">
												<a class="author">Joe Henderson</a>
												<div class="metadata">
													<div class="date">1 天以前</div>
												</div>
												<div class="text">
													<p>The hours, minutes and seconds stand as visible reminders that your effort put them all there. </p>
													<p>Preserve until your next run, when the watch lets you see how Impermanent your efforts are.</p><br />
												</div>
												<div class="actions">
													<a class="reply">Reply</a>
												</div>
											</div>
										</div>
									</div>
									<div class="ui segment">
										<form class="ui reply form">
											<div class="field">
												<textarea></textarea>
											</div>
											<div class="ui primary submit labeled icon button"><i class="icon edit"></i> Add Comment </div>
										</form>
									</div>
								</div>
								
							</div>
							
						</div>
					</div>
				</div>
				<!--按钮-->
				<div class="myButton">
					<button id="menuButton" class="ui icon button" onclick="openButton();">
						<i class="list icon"></i>
					</button><br /><br />
					<button id="login" onclick="showLogin();" class="ui icon button">
						<i class="user icon"></i>
					</button>
				</div>
			</div>
		</div>
		
		
		<!--弹出登录-->
		<div class="ui modal" id="loginHTML"></div>
		
		<script src="${basePath }/js/index.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath }/js/pagination.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			//导航栏个数
			var numbers = 6;
			
			//分页
			var pageIn = pageInaTion('<a class="ui label">','</a>','#fys',5,numbers);
			pageIn.inits();
			pageLeft = function(){
				pageIn.pageLeft();
			}
			pageRight = function(){
				pageIn.pageRight();
			}
		</script>
		
		<script type="text/javascript" src="${basePath }/js/semantic.min.js" ></script>
		<script  type="text/javascript" color="0,0,0" opacity='0.5' zIndex="-1" src="${basePath }/js/canvas-nest.js"></script>
		<script src="${basePath }/js/jquery.pin.min.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
