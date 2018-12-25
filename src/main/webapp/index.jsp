<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<script type="text/javascript" src="${basePath }/js/clipboard.min.js" ></script>
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
		<a class="item active" onclick="pageList(1)" id="a1"><i class="camera retro icon"></i>摄影</a>
			<a class="item" onclick="pageList(2)" id="a2"><i class="chrome icon"></i>前端</a>
			<a class="item" onclick="pageList(3)" id="a3"><i class="code icon"></i>编程</a>
			<a class="item" onclick="pageList(4)" id="a4"><i class="home icon"></i>思考</a>
			<a class="item" onclick="pageList(5)" id="a5"><i class="lightbulb outline icon"></i>想法</a>
			<a class="item" onclick="pageList(6)" id="a6"><i class="tags icon"></i>标签</a>
			<a class="item" onclick="pageList(7)" id="a7"><i class="archive icon"></i>归档</a>
			<a class="item" onclick="pageList(8)" id="a8"><i class="info circle icon"></i>关于我</a>
		</div>
		<script type="text/javascript">
			var sortIdTemp = 0;
			var userIdTemp = 0;
			var pageIdTemp = 0;
			var myUrl = 'blog.looc.site';
			pageList = function(sortId){
				$("#myMenu a").removeClass();
				$("#myMenu a").addClass('item');
				$("#a"+sortId).addClass('active');
				$.ajax({
					type: "post",
					url:"${basePath}/index/sort",
					data:{"sortId":sortId},
					success:function(date){
						var fydHtml = '<div class="ui circular labels">'+
											'<a class="ui label" onclick="pageLeft();">&lt;&lt;</a>'+
											'<span id="fys"></span>'+
											'<a class="ui label" onclick="pageRight();">&gt;&gt;</a>'+
										'</div>';
									
						if(sortId<=5||sortId==8){
							var dates = eval(date);
							var nub = dates[2];
							var label = eval(dates[0]);
							var page = eval(dates[1]);
							
							var labelHtml = '';
							for(var i in label){
								labelHtml+='<button onclick="labeal('+label[i].id +');" '+
									   		'class="button button-square button-tiny">'+label[i].name +'</button>';
							}
							$("#Id_label").html("");
							$("#Id_label").html(labelHtml);
							
							var pageHtml = '';
							for(var i in page){
								pageHtml+='<a style="font-size: 14px;" onclick="pageMain('+page[i].id+');" >'+page[i].title +'</a><br />';
							}
							$("#mPageList").html("");
							$("#mPageList").html(pageHtml);
							sortIdTemp = 0;
							
							$(".myFY").html("");
							$(".myFY").html(fydHtml);
							pageIn = pageInaTion('<a class="ui label" onclick="javascript:fy(','</a>','#fys',5,nub);
							pageIn.inits();
						}else if(sortId == 6){
							var dates = eval(date);
							var labelHtml = '';
							for(var i in dates){
								labelHtml+='<a style="font-size: 14px;" onclick="labeal('+dates[i].id+');" >'+dates[i].name +'</a><br />';
							}
							$("#Id_label").html("");
							$("#mPageList").html("");
							$("#mPageList").html(labelHtml);
							sortIdTemp = 0;
						}else if(sortId == 7){
							var dates = eval(date);
							var nub = dates[1];
							var page = eval(dates[0]);
							
							$("#Id_label").html("");
							
							var pageHtml = '';
							for(var i in page){
								pageHtml+='<a style="font-size: 8px;" onclick="pageMain('+page[i].id+');" >'+page[i].time+'__'+page[i].title +'</a><br />';
							}
							$("#mPageList").html("");
							$("#mPageList").html(pageHtml);
							
							sortIdTemp = 1;
							
							$(".myFY").html("");
							$(".myFY").html(fydHtml);
							pageIn = pageInaTion('<a class="ui label" onclick="javascript:fy(','</a>','#fys',5,nub);
							pageIn.inits();
						}
						
					}
				});
			}
		</script>
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
								<div class="ui label" onclick="fond();">查询</div>
								<input id="fondId" type="text" placeholder="">
							</div>
							<script type="text/javascript">
								fond = function(){
									var fondId = $("#fondId").val();
									if(fondId==""){
										alert("查询不能为空！");
									}else{
										$.ajax({
											type: "post",
											url:"${basePath}/index/fond",
											data:{"fondMsg":fondId},
											success: function(date){
												var page = eval(date);
												var pageHtml = '';
												for(var i in page){
													pageHtml+='<a style="font-size: 14px;" onclick="pageMain('+page[i].id+');" >'+page[i].title +'</a><br />';
												}
												$("#mPageList").html("");
												$("#mPageList").html(pageHtml);
												sortIdTemp = 0;
											}
										});
									}
								}
							</script>
							<div class="fondButton" id="Id_label">
								<c:forEach items="${labelList }" var="label">
								   <button onclick="labeal(${label.id });" 
								   		class="button button-square button-tiny">${label.name }</button>
								</c:forEach>
								<script type="text/javascript">
									labeal = function(id){
										$.ajax({
											type: "post",
											url:"${basePath}/index/labeal",
											data:{"id":id},
											success:function(date){
												val = eval(date);
												var dHtml = '';
												for(i in val){
													dHtml+= '<a style="font-size: 14px;"  onclick="pageMain('+val[i].id+');">'+val[i].title+'</a><br />';
												}
												$("#mPageList").html("");
												$("#mPageList").html(dHtml);
												$(".myFY").html("");
											}
										});
									}
								</script>
							</div>
						</div>
						<div class="ui divider"></div>
						<!--列表-->
						<div class="myList">
							<div class="ui segment center aligned vertical basic">
								<nav class="cl-effect-21" id="mPageList">
									<c:forEach items="${pageList }" var="page">
										<a style="font-size: 14px;"  onclick="pageMain(${page.id});">${page.title }</a><br />
									</c:forEach>
								</nav>
							</div>
						</div>
						<script type="text/javascript">
							pageMain = function(pageId){
								$.ajax({
									type:"post",
									url:"${basePath}/index/page",
									data:{"pageId":pageId},
									success:function(date){
										var val = eval(date);
										var pageMsg = eval(val[0]);
										var comMsg = eval(val[1]);
										var comHtml='';
										var pageHtml = '<div class="ui huge center aligned header">'+pageMsg[0].title+'</div>'+
														'<p class="ui right floated header">'+
														'	'+pageMsg[0].time+' <br />'+
														'</p>'+
														'<p>阅读量：'+pageMsg[0].viewNumber+'&nbsp;&nbsp;&nbsp;&nbsp;'+
														'	文章字数：'+pageMsg[0].textNumber+
														'</p>';
										$(".mainText").html("");
										$(".mainText").html(pageMsg[0].mainText);
										pageIdTemp = pageMsg[0].id;
										$("#share").removeAttr("data-clipboard-text");
										var tempAttr = myUrl+'${basePath}/page/'+pageMsg[0].id;
										$("#share").attr("data-clipboard-text",tempAttr);
										
										$(".mainText img").addClass("ui bordered image");
										$("#mainMsgs").html("");
										$("#mainMsgs").html(pageHtml);
										
										for(var i in comMsg){
											comHtml+='<div class="comment">'+
													'	<a class="avatar">'+
													'		<img style="height: 35px" src="${basePath }/img/matt.jpg">'+
													'	</a>'+
													'	<div class="content">'+
													'		<a class="author">'+comMsg[i].username+'</a>'+
													'		<div class="metadata">'+
													'			<div class="date">'+comMsg[i].times+'</div>'+
													'		</div>'+
													'		<div class="text">'+
													'			'+comMsg[i].mainText+
													'		</div>'+
													'		<div class="actions">'+
													'			<a class="reply">'+
													'				Reply：'+comMsg[i].reText+
													'			</a>'+
													'		</div>'+
													'	</div>'+
													'</div>';
										}
										$("#comMsgs").html("");
										$("#comMsgs").html(comHtml);
										
										if(windwWidth<700){
											$("#menuButton").click();
										}
									}
								});
							}
						</script>
						<!--分页-->
						<div class="myFY">
							<div class="ui circular labels">
								<a class="ui label" onclick="pageLeft();">&lt;&lt;</a>
								<span id="fys"></span>
								<a class="ui label" onclick="pageRight();">&gt;&gt;</a>
							</div>
						</div>
						<script type="text/javascript">
							fy = function(obj){
								$.ajax({
									type: "post",
									url:"${basePath}/index/fy",
									data:{"no":obj},
									success:function(date){
										val = eval(date);
										var dHtml = '';
										if(sortIdTemp==1){
											for(i in val){
												dHtml+= '<a style="font-size: 8px;" onclick="pageMain('+val[i].id+');" >'+val[i].time+'__'+val[i].title +'</a><br />';
											}
										}else{
											for(i in val){
												dHtml+= '<a style="font-size: 14px;"  onclick="pageMain('+val[i].id+');">'+val[i].title+'</a><br />';
											}
										}
										$("#mPageList").html("");
										$("#mPageList").html(dHtml);
									}
								});
							}
						</script>
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
							<div class="ui segment vertical" id="mainMsgs">
								<div class="ui huge center aligned header">${page.title }</div>
								<p class="ui right floated header">
									${page.time } <br />
								</p>
								<p>阅读量：${page.viewNumber }&nbsp;&nbsp;&nbsp;&nbsp;
									文章字数：${page.textNumber }
								</p>
							</div>
							<div class="mainText">
								${page.mainText }
							</div>
							<br /><br />
							<div id="share" style="float: right;" data-clipboard-text='blog.looc.site${basePath }/page/${pageId}'>
								<div class="ui labeled button" tabindex="0">
								  <div class="ui basic blue button">
								    <i class="fork icon"></i><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">分享
								  </font></font></div>
								</div>
							</div><br />
							<script type="text/javascript">
								$(".mainText img").addClass("ui bordered image");
							</script>
							<!--评论-->
							<h4 class="ui horizontal divider header"><i class="bullhorn icon"></i>评论</h4>
							<div class="myCom" >
								<div class="ui comments" style="margin: 0 auto;">
									<div class="ui segment" id="comMsgs">
										<c:forEach items="${commentList }" var="com">
											<div class="comment">
												<a class="avatar">
													<img style="height: 35px" src="${basePath }/img/matt.jpg">
												</a>
												<div class="content">
													<a class="author">${com.username }</a>
													<div class="metadata">
														<div class="date">${com.times }</div>
													</div>
													<div class="text">
														${com.mainText }
													</div>
													<div class="actions">
														<a class="reply">
															Reply：${com.reText }
														</a>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
									<div class="ui segment">
										<form class="ui reply form">
											<div class="field">
												<textarea id="comText"></textarea>
											</div>
											<div onclick="comAdd();" class="ui primary submit labeled icon button">
												<i class="icon edit"></i> 
												提交 
											</div>
										</form>
										<script type="text/javascript">
											comAdd = function(){
												if(userIdTemp!=0){
													var comText = $("#comText").val();
													$.ajax({
														type:"post",
														url:"${basePath}/user/addCom",
														data:{"comMsg":comText},
														success:function(date){
															if(date=="success"){
																alert("评论成功！需管理员审核后才能显示")
															}else{
																alert("评论失败！");
															}
														}
													});
												}else{
													alert("请登录！");
													showLogin();
												}
											}
											
										</script>
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
		<c:if test="${user != null}">
			<script type="text/javascript">
				userIdTemp = ${user.id};
				$("#login").removeAttr("onclick");
				$("#login").attr("onclick","loginOut()");
				$("#login").html("");
				$("#login").html('<i class="sign-out icon"></i>');
			</script>
		</c:if>
		<script type="text/javascript">
			
			login = function(){
				var username = $("#lUserName").val();
				var password = $("#lPassWord").val();
				if(username==""||password==""){
					alert("请将信息填写完整！");
					return 1;
				}
				$.ajax({
					type:"post",
					url:"${basePath}/login",
					data:{"username":username,"password":password},
					success:function(date){
						if(date=="error"){
							alert("登录失败！");
						}else{
							userIdTemp = parseInt(date);
							$(".close.icon").click();
							$("#login").removeAttr("onclick");
							$("#login").attr("onclick","loginOut()");
							$("#login").html("");
							$("#login").html('<i class="sign-out icon"></i>');
							
						}
					}			
				});
			}
			
			addUser = function(){
				var username = $("#aUserName").val();
				var password = $("#aPassWord").val();
				var passwords = $("#aPassWords").val();
				var email = $("#aEmail").val();
				if(username==""||password==""||passwords==""||email==""){
					alert("请将信息填写完整！");
					return 1;
				}
				if(password != passwords){
					alert("两次密码不同！");
					return 1;
				}
				$.ajax({
					type:"post",
					url:"${basePath}/add",
					data:{"username":username,"password":password,"email":email},
					success:function(date){
						if(date=="success"){
							loginForm();
						}else{
							alert("注册失败！");
						}
					}			
				});
			}
			loginOut = function(){
				alert("是否退出登录！");
				$.ajax({
					type:"post",
					url:"${basePath}/loginOut",
					data:{},
					success:function(date){
						$("#login").removeAttr("onclick");
						$("#login").attr("onclick","login()");
						$("#login").html("");
						$("#login").html('<i class="user icon"></i>');
					}			
				});
			}
		</script>
		
		<script src="${basePath }/js/index.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath }/js/pagination.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			var clipboard = new ClipboardJS('#share');
			clipboard.on('success', function(e) {
				alert("链接复制成功！");
			});
			
			//导航栏个数
			var numbers = ${pageNo};
			
			//分页
			var pageIn = pageInaTion('<a class="ui label" onclick="javascript:fy(','</a>','#fys',5,numbers);
			pageIn.inits();
			pageLeft = function(){
				pageIn.pageLeft();
			}
			pageRight = function(){
				pageIn.pageRight();
			}
			
			$(".mainText img").addClass("ui bordered image");
		</script>
		
		<script type="text/javascript" src="${basePath }/js/semantic.min.js" ></script>
		<script  type="text/javascript" color="0,0,0" opacity='0.5' zIndex="-1" src="${basePath }/js/canvas-nest.js"></script>
		<script src="${basePath }/js/jquery.pin.min.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
