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
    
    <title>管理</title>
    <jsp:include page="../config.jsp" flush="true"/>
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
					<a href="${basePath }/admin/index">
						<i class="am-icon-home sidebar-nav-link-logo"></i> 首页
					</a>
				</li>
				<li class="sidebar-nav-link">
					<a href="${basePath }/admin/tables"  class="active">
						<i class="am-icon-table sidebar-nav-link-logo"></i> 管理
					</a>
				</li>
				<li class="sidebar-nav-link">
					<a href="${basePath }/admin/calendar">
						<i class="am-icon-calendar sidebar-nav-link-logo"></i> 日历
					</a>
				</li>
				<li class="sidebar-nav-link">
					<a href="${basePath }/admin/write">
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
                        <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 管理 <small>用户,评论,文章</small></div>
                    </div>
                </div>
            </div>

            <div class="row-content am-cf">


                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-6">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">用户</div>
                            </div>
                            <div class="widget-body  widget-body-lg am-fr">

                                <table width="100%" class="am-table am-table-compact am-table-bordered am-table-radius am-table-striped tpl-table-black " id="example-r">
                                    <thead>
                                        <tr>
                                            <th>用户ID</th>
                                            <th>用户名</th>
                                            <th>email</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="userTable">
                                       	<c:forEach items="${userList }" var="users">
	                                        <tr class="gradeX">
                                        		<td>${users.id }</td>
	                                            <td>${users.username }</td>
	                                            <td>${users.email }</td>
	                                            <td>
	                                                <div class="tpl-table-black-operation">
	                                                    <a  onclick="userUp(${users.id },${users.status });">
	                                                    	<c:if test="${users.status == 1 }">
		                                                        <i class="am-icon-pencil" ></i>禁用
	                                                    	</c:if>
	                                                    	<c:if test="${users.status == 0 }">
		                                                        <i class="am-icon-pencil"></i>启用
	                                                    	</c:if>
	                                                    </a>
	                                                    <a onclick="userDelete(${users.id});" class="tpl-table-black-operation-del">
	                                                        <i class="am-icon-trash"></i> 删除
	                                                    </a>
	                                                </div>
    	                                        </td>
	                                        </tr>
                                       	</c:forEach>
                                        <!-- more data -->
                                    </tbody>
                                </table>
								<ul class="am-pagination">
									<li><a onclick="prev('user')"><span class="am-icon-angle-double-left"></span></a></li>
									<li><span id="userNo">第1页</span></li>
									<li><a onclick="next('user')"><span class="am-icon-angle-double-right"></span></a></li>
								</ul>
						</div>
                        </div>
                    </div>
					<script type="text/javascript">
						userUp = function(id,sta){
							if(confirm("是否进行操作！")){
								$.ajax({
									type:"post",
									url:"${basePath}/admin/tebles/userUp",
									data:{"id":id,"state":sta},
									success:function(date){
										if(date == 'success'){
											getMsg('user',userNo);
										}
									}									
								});						
							}
						}
						userDelete = function(id){
							if(confirm("是否进行操作！")){
								$.ajax({
									type:"post",
									url:"${basePath}/admin/tebles/userDelete",
									data:{"id":id},
									success:function(date){
										if(date == 'success'){
											getMsg('user',userNo);
										}
									}									
								});						
							}
						}
						
					</script>


                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-6">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">评论</div>
                            </div>
                            <div class="widget-body  widget-body-lg am-fr">

                                <table width="100%" class="am-table am-table-compact am-table-bordered am-table-radius am-table-striped tpl-table-black " id="example-r">
                                    <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>用户</th>
                                            <th>内容</th>
                                            <th>回复</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="comTable">
                                       	<c:forEach items="${commentList }" var="comm">
	                                        <tr class="gradeX">
                                        		<td>${comm.pageId }</td>
	                                            <td>${comm.username }</td>
	                                            <td>${comm.mainText }</td>
	                                            <td>${comm.reText }</td>
	                                            <td>
	                                                <div class="tpl-table-black-operation">
	                                                    <a onclick="commUp(${comm.id},${comm.status })">
	                                                       	<c:if test="${comm.status == 1 }">
		                                                        <i class="am-icon-pencil"></i>禁用
	                                                    	</c:if>
	                                                    	<c:if test="${comm.status == 0 }">
		                                                        <i class="am-icon-pencil"></i>启用
	                                                    	</c:if>
	                                                    </a>
	                                                    <a onclick="commRe(${comm.id})" data-am-modal="{target: '#doc-modal-11', closeViaDimmer: 0}" class="tpl-table-black-operation-del">
	                                                       回复
	                                                    </a>
	                                                    <a onclick="commDelete(${comm.id})" class="tpl-table-black-operation-del">
	                                                        <i class="am-icon-trash"></i> 删除
	                                                    </a>
	                                                </div>
	                                            </td>
 	                                       </tr>
                                       	</c:forEach>
                                        <!-- more data -->
                                    </tbody>
                                </table>
                               <ul class="am-pagination">
									<li><a onclick="prev('com')"><span class="am-icon-angle-double-left"></span></a></li>
									<li><span id="comNo">第1页</span></li>
									<li><a onclick="next('com')"><span class="am-icon-angle-double-right"></span></a></li>
								</ul>
                            </div>
                        </div>
                    </div>
                </div>
              
				<script type="text/javascript">
					commUp = function(id,sta){
						if(confirm("是否进行操作！")){
							$.ajax({
								type:"post",
								url:"${basePath}/admin/tebles/commUp",
								data:{"id":id,"state":sta},
								success:function(date){
									if(date == 'success'){
										getMsg('com',comNo);
									}
								}									
							});						
						}
					}
					commDelete = function(id){
						if(confirm("是否进行操作！")){
							$.ajax({
								type:"post",
								url:"${basePath}/admin/tebles/commDelete",
								data:{"id":id},
								success:function(date){
									if(date == 'success'){
										getMsg('com',comNo);
									}
								}									
							});						
						}
					}
					commRe = function(id){
						$("#reTextId").val(id);
					}
				</script>

                <div class="row" style="margin:0 20px 30px 20px">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">文章</div>
                            </div>
                            <div class="widget-body  widget-body-lg am-fr">

                                <table width="100%" class="am-table am-table-compact am-table-bordered am-table-radius am-table-striped tpl-table-black " id="example-r">
                                    <thead>
                                        <tr>
                                            <th>文章标题</th>
                                            <th>作者</th>
                                            <th>时间</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="pageTable">
                                    	<c:forEach items="${pageList }" var="page">
	                                        <tr class="gradeX">
	                                            <td>${page.title }</td>
	                                            <td>${page.author }</td>
	                                            <td>${page.time }</td>
	                                            <td>
	                                                <div class="tpl-table-black-operation">
	                                                    <a onclick="pageUp(${page.id},${page.status })">
	                                                       	<c:if test="${page.status == 1 }">
		                                                        <i class="am-icon-pencil"></i>禁用
	                                                    	</c:if>
	                                                    	<c:if test="${page.status == 0 }">
		                                                        <i class="am-icon-pencil"></i>启用
	                                                    	</c:if>
	                                                    </a>
	                                                    <a onclick="pageUpdate(${page.id})" class="tpl-table-black-operation-del" >
	                                                        修改
	                                                    </a>
	                                                    <a onclick="pageDelete(${page.id})" class="tpl-table-black-operation-del">
	                                                        <i class="am-icon-trash"></i> 删除
	                                                    </a>
	                                                </div>
	                                            </td>
	                                        </tr>
                                    	</c:forEach>
                                        <!-- more data -->
                                    </tbody>
                                </table>
                               <ul class="am-pagination">
									<li><a onclick="prev('page');"><span class="am-icon-angle-double-left"></span></a></li>
									<li><span id="pageNo">第1页</span></li>
									<li><a onclick="next('page');"><span class="am-icon-angle-double-right"></span></a></li>
								</ul>
                            </div>
                            <script type="text/javascript">
                            	pageUp = function(id,sta){
									if(confirm("是否进行操作！")){
										$.ajax({
											type:"post",
											url:"${basePath}/admin/tebles/pageUp",
											data:{"id":id,"state":sta},
											success:function(date){
												if(date == 'success'){
													getMsg('page',pageNo);
												}
											}									
										});						
									}
								}
								pageDelete = function(id){
									if(confirm("是否进行操作！")){
										$.ajax({
											type:"post",
											url:"${basePath}/admin/tebles/pageDelete",
											data:{"id":id},
											success:function(date){
												if(date == 'success'){
													getMsg('page',pageNo);
												}
											}									
										});						
									}
								}
								pageUpdate = function(pageId){
									post('${basePath}/admin/tables/upDatePage',{id:pageId})
								}
                            </script>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
     <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-11">
	  <div class="am-modal-dialog">
	    <div class="am-modal-hd">回复
	      <a href="javascript: void(0)" id="reClose" class="am-close am-close-spin" data-am-modal-close>&times;</a>
	    </div>
	    <div class="am-modal-bd">
	    	<form class="am-form">
		      	<div class="am-form-group">
		      		<input type="text" id="reTextId" style="display: none"/>
		      	  	<label for="doc-ta-1">回复内容</label>
		      		<textarea class="" rows="5" id="reTexts"></textarea>
	    		</div>
			    <p><button type="button" onclick="reTextSubmt();" class="am-btn am-btn-default">提交</button></p>
			 </form>
	    </div>
	  </div>
	</div>
	 <script type="text/javascript">
   		reTextSubmt = function(){
   			var reTexts = $("#reTexts").val();
   			var id = $("#reTextId").val();
   			$.ajax({
   				type:"post",
   				url:"${basePath}/admin/tebles/reTextSubmt",
   				data:{"id":id,"reText":reTexts},
   				success:function(date){
					$("#reClose").click();			
   					getMsg('com',comNo);
   				}
   			});
   		}
    </script>
    <script type="text/javascript">
		var userNo = 0;
		$("#userNo").html("");
		$("#userNo").html('第'+(userNo+1)+'页');
		
		var comNo = 0;
		$("#comNo").html("");
		$("#comNo").html('第'+(comNo+1)+'页');
		
		var pageNo = 0;
		$("#pageNo").html("");
		$("#pageNo").html('第'+(pageNo+1)+'页');
		
		var backHtml; 
		
		getMsg = function(str,no){
			$.ajax({
				type:"post",
				url:"${basePath}/admin/tebles/getMsg",
				data:{"str":str,"no":no},
				success:function(date){
					val = eval(date);
					if(str == 'user'){
						var userHtml = '';
						for(i in val){
							userHtml+=' <tr class="gradeX">'+
                                      '		<td>'+val[i].id+'</td>'+
                                      '      <td>'+val[i].username+'</td>'+
                                      '      <td>'+val[i].email+'</td>'+
                                      '      <td>'+
                                      '          <div class="tpl-table-black-operation">'+
                                      '              <a  onclick="userUp('+val[i].id+','+val[i].status+');">';
                            if(val[i].status == 1){
                            	userHtml+='            <i class="am-icon-pencil" ></i>禁用';
                            }else if(val[i].status == 0){
                            	userHtml+='            <i class="am-icon-pencil" ></i>启用';
                            }
                           userHtml+= '              </a>'+
                                      '              <a onclick="userDelete('+val[i].id+');" class="tpl-table-black-operation-del">'+
                                      '                  <i class="am-icon-trash"></i> 删除'+
                                      '              </a>'+
                                      '          </div>'+
   	                                  '      </td>'+
                                      '  </tr>';
						}
						$("#userTable").html("");
						$("#userTable").html(userHtml);
						
						
					}else if(str == 'com'){
						var comHtml = '';
						for(i in val){
							comHtml+='<tr class="gradeX">'+
                                      '	   <td>'+val[i].pageId+'</td>'+
                                      '    <td>'+val[i].username+'</td>'+
                                      '    <td>'+val[i].mainText+'</td>'+
                                      '    <td>'+val[i].reText+'</td>'+
                                      '    <td>'+
                                      '        <div class="tpl-table-black-operation">'+
                                      '            <a onclick="commUp('+val[i].id+','+val[i].status+')">';
                            if(val[i].status == 1){
                            	comHtml+='            <i class="am-icon-pencil" ></i>禁用';
                            }else if(val[i].status == 0){
                            	comHtml+='            <i class="am-icon-pencil" ></i>启用';
                            }
                            comHtml+='            </a>'+
                                      '            <a onclick="commRe('+val[i].id+')" data-am-modal="{target: '+"'#doc-modal-11'"+', closeViaDimmer: 0}" class="tpl-table-black-operation-del">'+
                                      '               回复'+
                                      '            </a>'+
                                      '            <a onclick="commDelete('+val[i].id+')" class="tpl-table-black-operation-del">'+
                                      '                <i class="am-icon-trash"></i> 删除'+
                                      '            </a>'+
                                      '        </div>'+
                                      '    </td>'+
                                      '</tr>';
						}
						$("#comTable").html("");
						$("#comTable").html(comHtml);
						
						
					}else if(str == 'page'){
						var pageHtml = '';
						for(i in val){
							pageHtml+='<tr class="gradeX">'+
	                                  '      <td>'+val[i].title+'</td>'+
	                                  '      <td>'+val[i].author+'</td>'+
	                                  '      <td>'+val[i].time+'</td>'+
	                                  '      <td>'+
	                                  '          <div class="tpl-table-black-operation">'+
	                                  '              <a onclick="pageUp('+val[i].id+','+val[i].status+')">';
	                        if(val[i].status == 1){
                            	pageHtml+='            <i class="am-icon-pencil" ></i>禁用';
                            }else if(val[i].status == 0){
                            	pageHtml+='            <i class="am-icon-pencil" ></i>启用';
                            }
	                        pageHtml+='              </a>'+
	                                  '              <a onclick="pageUpdate('+val[i].id+')" class="tpl-table-black-operation-del" >'+
	                                  '                  修改'+
	                                  '              </a>'+
	                                  '              <a onclick="pageDelete('+val[i].id+')" class="tpl-table-black-operation-del">'+
	                                  '                  <i class="am-icon-trash"></i> 删除'+
	                                  '              </a>'+
	                                  '          </div>'+
	                                  '      </td>'+
	                                  '  </tr>';
						}
						$("#pageTable").html("");
						$("#pageTable").html(pageHtml);
					}
					
				}
			})
		}
		
		
		
		prev = function(str){
			if(str == 'user'){
				if(userNo-1>=0){
					userNo = userNo-1;
					getMsg('user',userNo);
					$("#userNo").html("");
					$("#userNo").html('第'+(userNo+1)+'页');
				}else{
					alert('翻不了了！');
				}
			}else if(str == 'com'){
				if(comNo-1>=0){
					comNo = comNo-1;
					getMsg('com',comNo);
					$("#comNo").html("");
					$("#comNo").html('第'+(comNo+1)+'页');
				}else{
					alert('翻不了了！');
				}
			}else if(str == 'page'){
				if(pageNo-1>=0){
					pageNo = pageNo-1;
					getMsg('page',pageNo);
					$("#pageNo").html("");
					$("#pageNo").html('第'+(pageNo+1)+'页');
				}else{
					alert('翻不了了！');
				}
			}
		};
		
		next = function(str){
			if(str == 'user'){
				if((userNo+1)*10<=parseInt(${userNub})){
					userNo = userNo+1;
					getMsg('user',userNo);
					$("#userNo").html("");
					$("#userNo").html('第'+(userNo+1)+'页');
				}else{
					alert('翻不了了！');
				}
			}else if(str == 'com'){
				if((comNo+1)*10<=parseInt(${comNub})){
					comNo = comNo+1;
					getMsg('com',comNo);
					$("#comNo").html("");
					$("#comNo").html('第'+(comNo+1)+'页');
				}else{
					alert('翻不了了！');
				}
			}else if(str == 'page'){
				if((pageNo+1)*10<= parseInt(${pageNub})){
					pageNo = pageNo+1;
					getMsg('page',pageNo);
					$("#pageNo").html("");
					$("#pageNo").html('第'+(pageNo+1)+'页');
				}else{
					alert('翻不了了！');
				}
			}
		};  	
	</script>

	
	<jsp:include  page="../configEnd.jsp" flush="true"/>
	<script type="text/javascript" src="${basePath }/js/cp.js"></script>
</body>

</html>