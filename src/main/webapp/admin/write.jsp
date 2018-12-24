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
    
    <title>创造中心</title>
    <jsp:include page="../config.jsp" flush="true"/>
    <script type="text/javascript" src="${basePath }/js/jquery-3.3.1.min.js" ></script>
	<style type="text/css">
		.ck-editor__editable {
		    min-height: 400px;
		}
	</style>
  </head>
  
	<body data-type="widgets">
		<script src="${basePath }/admin/assets/js/theme.js"></script>
		<div class="am-g tpl-g">
			<!-- 头部 -->
			<header>
				<!-- logo -->
				<div class="am-fl tpl-header-logo">
					<a href="javascript:;"><img src="${basePath }/admin/assets/img/logo.png" alt=""></a>
				</div>
				<!-- 右侧内容 -->
				<div class="tpl-header-fluid">
					<!-- 侧边切换 -->
					<div class="am-fl tpl-header-switch-button am-icon-list"></div>
					<!-- 其它功能-->
					<div class="am-fr tpl-header-navbar">
						<ul>
							<!-- 欢迎语 -->
							<li class="am-text-sm tpl-header-navbar-welcome">
								<a href="javascript:;">欢迎你, <span>${admin.username }</span> </a>
							</li>

							<!-- 退出 -->
							<li class="am-text-sm">
								<a href="javascript:;">
									<span class="am-icon-sign-out"></span> 退出
								</a>
							</li>
						</ul>
					</div>
				</div>
			</header>
			<!-- 风格切换 -->
			<div class="tpl-skiner">
				<div class="tpl-skiner-toggle am-icon-cog">
				</div>
				<div class="tpl-skiner-content">
					<div class="tpl-skiner-content-title">
						选择主题
					</div>
					<div class="tpl-skiner-content-bar">
						<span class="skiner-color skiner-white" data-color="theme-white"></span>
						<span class="skiner-color skiner-black" data-color="theme-black"></span>
					</div>
				</div>
			</div>
			<!-- 侧边导航栏 -->
			<div class="left-sidebar">
				<!-- 菜单 -->
				<ul class="sidebar-nav">
					<li class="sidebar-nav-link">
						<a href="${basePath }/admin/index" >
							<i class="am-icon-home sidebar-nav-link-logo"></i> 首页
						</a>
					</li>
					<li class="sidebar-nav-link">
						<a href="${basePath }/admin/tables">
							<i class="am-icon-table sidebar-nav-link-logo"></i> 管理
						</a>
					</li>
					<li class="sidebar-nav-link">
						<a href="${basePath }/admin/calendar">
							<i class="am-icon-calendar sidebar-nav-link-logo"></i> 日历
						</a>
					</li>
					<li class="sidebar-nav-link">
						<a href="${basePath }/admin/write"  class="active">
							<i class="am-icon-wpforms sidebar-nav-link-logo"></i> 创造中心
	
						</a>
					</li>
					<li class="sidebar-nav-link">
						<a href="${basePath }/admin/chart">
							<i class="am-icon-bar-chart sidebar-nav-link-logo"></i> 统计
	
						</a>
					</li>
	
				</ul>
			</div>

			<!-- 内容区域 -->
			<div class="tpl-content-wrapper">

				<div class="container-fluid am-cf">
					<div class="row">
						<div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
							<div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 创造中心 <small>写博客</small></div>
						</div>
					</div>

				</div>

				<div class="row-content am-cf">

					<div class="row">

						<div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
							<div class="widget am-cf">
								<form action="${basePath }/admin/writedo" method="post">
									<div class="widget-head am-cf">
										<div class="am-g">
											<div class="am-u-sm-6">
												<label>标题</label>
												<input type="text" class="am-form-field am-round" name="title" id="" value="" />
											</div>
											<div class="am-u-sm-3">
												<label>作者</label>
												<input type="text" class="am-form-field am-round" name="author" value="" />
											</div>
											<div class="am-u-sm-3">
												<label>日期</label>
												<input type="text" class="am-form-field am-round" name="time" id="dates" value="" />
											</div>
										</div>
									</div>
									<div class="widget-head am-cf">
										<div class="am-g">
											<div class="am-u-sm-5">
												<label>类别</label> 
												<select name="sortId" id="sortId" data-am-selected="{btnWidth: '100%', btnSize: 'sm', btnStyle: 'secondary'}" >
													<option value="">请选择</option>
													<c:forEach items="${sortList }" var="sort">
														<option value="${sort.id }">${sort.name }</option>
													</c:forEach>
												</select>
											</div>
											<div class="am-u-sm-5">
												<label>标签</label>
												<select name="labelId" id="labelId" data-am-selected="{btnWidth: '100%', btnSize: 'sm', btnStyle: 'warning'}" >
													
												</select>
											</div>
											<div class="am-u-sm-2">
												<label>添加标签</label>
												<button type="button" class="am-btn am-btn-default am-round am-btn-block" data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0, width: 400}">
													  添加
												</button>
											</div>
										</div>
									</div>
										<script type="text/javascript">
											/* 更具选中的来展示标签数据 */
											$("#sortId").change(function(){
												var sortId = $("#sortId").val();
												$.ajax({
													type:"post",
													url:"${basePath}/admin/write/getLabel",
													data: {"sortId":sortId},
													success:function(data){
														val = eval(data);
														var htmls = '';
														for(i in val){
															htmls += '<option value="'+val[i].id+'">'+val[i].name+'</option>';
														}
														$("#labelId *").remove();
														$("#labelId").html(htmls);
													}
												});
											});
											
										</script>
									<div class="widget-body am-fr">
										<textarea name="texts" id="editor" ></textarea>
									</div>
									<input type="text" name="nub" style="display: none" id="nub"/>
									<button type="submit" onclick="getNub();" class="am-btn am-btn-default am-round" style="float: right;">提交</button>
									<br /><br /><br />
								</form>
								<script type="text/javascript">
									getNub = function(){
										var editor=window.editor;
										var htmlStr=editor.getData();
										htmlStr=htmlStr.replace(/<[^>]*>/ig,"");
										htmlStr=htmlStr.replace(/&nbsp;/ig,"");
										$("#nub").val(htmlStr.length);
									}
								</script>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		</div>
		<!-- 弹窗 -->
	<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">
				添加标签<a href="javascript: void(0)" id="addN1"
					class="am-close am-close-spin" data-am-modal-close>&times;</a>
			</div>
			<script type="text/javascript">
				function sub() {  
	        		$.ajax({
	        			type: "post",
	        			url: "${basePath }/admin/write/addLab",
	        			data: {"sortId": $("#addSirtId").val(),"labelName": $("#addLabName").val()},
	        			success:function(data){
	        				
	        			}
	        		});
	        		$("#addN1").click();
	    		}
			</script>
			<form  id="addLabFrom" method="post" >
				<div class="am-modal-bd" >
					<label>类别</label> 
					<select name="sortId" id="addSirtId" data-am-selected="{btnWidth: '100%', btnSize: 'sm', btnStyle: 'secondary'}" >
						<c:forEach items="${sortList }" var="sort">
							<option value="${sort.id }">${sort.name }</option>
						</c:forEach>
					</select>
				</div>
				<div class="am-modal-bd" >
					<label>标签</label>
					<input type="text" id="addLabName" class="am-form-field am-round" name="labelName" value="" />
				</div>
				<br /><br />
				<button type="button" class="am-btn am-btn-default am-round" onclick="sub()">提交</button>
			</form>
			
		</div>
	</div>

	
		<jsp:include   page="../configEnd.jsp" flush="true"/>
		<script type="text/javascript" src="${basePath }/js/ckeditor.js" ></script>
		<script src="${basePath }/js/translations/zh-cn.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath }/laydate/laydate.js"></script>
		<script type="text/javascript">
		
			ClassicEditor
		    .create( document.querySelector( '#editor' ) ,{
		    		highlight: {
			            options: [
			                {model: 'greenMarker',class: 'marker-green',title: 'Green marker',color: 'var(--ck-highlight-marker-green)',type: 'marker'},
			                {model: 'redPen',class: 'pen-red',title: 'Red pen',color: 'var(--ck-highlight-pen-red)',type: 'pen'},
			                {model: 'yellowMarker',class: 'pen-yellow',title: 'Yellow pen',color: 'var(--ck-highlight-pen-yellow)',type: 'pen'},
			                {model: 'blue Marker',class: 'pen-blue ',title: 'Blue pen',color: 'var(--ck-highlight-pen-blue)',type: 'pen'}
			            ]
			        },
					fontSize : {
						options : [
							9,11,13,17,19,21,28
						]
					},
					toolbar: ["undo", "redo", "|", 'insertTable', "|",'fontSize',"|","pasteFromOffice",
		    				'alignment:left', 'alignment:right', 'alignment:center', 'alignment:justify', '|', 
		    				 "bold", "italic", "highlight","|",
		    				 "blockQuote", "imageTextAlternative", "imageUpload", 
		    				"heading", "link", "numberedList", "bulletedList","|",
							"mediaEmbed","|",
							"Underline","Strikethrough","Code","Subscript","Superscript"
					],
		    	table: {
		            contentToolbar: [ 'tableColumn', 'tableRow', 'mergeTableCells' ]
		        },
		    	ckfinder:{
    						uploadUrl: "${basePath}/admin/write/upimg"
		    	},
		    	mediaEmbed: {
		            removeProviders: [ 'instagram', 'twitter', 'googleMaps', 'flickr', 'facebook' ]
		       }
		    }) 
		    .then( editor => {
		  	    window.editor = editor;
				data = editor.getData();
		        console.log( editor );
		    } )
		    .catch( error => {
		        console.error( error );
		    } );
		   
		</script>
		<script type="text/javascript">
			var mydate = new Date();
			laydate.render({
	  			elem: '#dates', //指定元素
	  			type:'datetime',
	  			value:new Date()
			});
		</script>
	</body>
