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
    <title>管理员</title>
	<jsp:include page="../config.jsp" flush="true"/>
  </head>
  
<body data-type="index">
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
				<div class="am-fl tpl-header-switch-button am-icon-list men" style="height: 55px;"></div>
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
					<a href="${basePath }/admin/index"  class="active">
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
                        <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 首页 <small>welcome</small></div>
                    </div>
                </div>
            </div>

            <div class="row-content am-cf">
                <div class="row  am-cf">
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                        <div class="widget widget-purple am-cf">
                            <div class="widget-statistic-header">
                           		本月写博客量
                            </div>
                            <div class="widget-statistic-body">
                                <div class="widget-statistic-value">
                                    ${blogWrite }
                                </div>
                                <div class="widget-statistic-description">
                                      本月比上月多 <strong>${blogWrite-blogWriteL }</strong>篇
                                </div>
                               <span class="widget-statistic-icon am-icon-support"></span>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                        <div class="widget widget-primary am-cf">
                            <div class="widget-statistic-header">
                           		本月访问量
                            </div>
                            <div class="widget-statistic-body">
                                <div class="widget-statistic-value">
                                    ${blogRead }
                                </div>
                                <div class="widget-statistic-description">
                                      本月比上月多浏览 <strong>${blogRead-blogReadL }</strong>次
                                </div>
                                <span class="widget-statistic-icon am-icon-support"></span>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                        <div class="widget widget-purple am-cf">
                            <div class="widget-statistic-header">
                                                         本月评论量                           
                            </div>
                            <div class="widget-statistic-body">
                                <div class="widget-statistic-value">
                                   	  ${blogCom }
                                </div>
                                <div class="widget-statistic-description">
                                   	 本月比上月多评论<strong>${blogCom-blogComL }</strong>次
                                </div>
                                <span class="widget-statistic-icon am-icon-support"></span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row am-cf">
                    <div class="am-u-sm-12 am-u-md-8">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">博客书写周统计</div>
                            </div>
                            <div class="widget-body-md widget-body tpl-amendment-echarts am-fr" id="tpl-echarts">
                            </div>
                        </div>
                    </div>

                    <div class="am-u-sm-12 am-u-md-4">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">创造时间</div>
                            </div>
                            <div class="widget-body widget-body-md am-fr">
                                <div class="am-progress-title">凌晨<span class="am-fr am-progress-title-more">${blogRScale.get(0)}% / 100%</span></div>
                                <div class="am-progress">
                                    <div class="am-progress-bar" style="width: ${blogRScale.get(0)}%"></div>
                                </div>
                                <div class="am-progress-title">上午<span class="am-fr am-progress-title-more">${blogRScale.get(1)}% / 100%</span></div>
                                <div class="am-progress">
                                    <div class="am-progress-bar  am-progress-bar-warning" style="width: ${blogRScale.get(1)}%"></div>
                                </div>
                                <div class="am-progress-title">下午<span class="am-fr am-progress-title-more">${blogRScale.get(2)}% / 100%</span></div>
                                <div class="am-progress">
                                    <div class="am-progress-bar am-progress-bar-danger" style="width: ${blogRScale.get(2)}%"></div>
                                </div>
                                <div class="am-progress-title">晚间<span class="am-fr am-progress-title-more">${blogRScale.get(3)}% / 100%</span></div>
                                <div class="am-progress">
                                    <div class="am-progress-bar am-progress-bar-danger" style="width: ${blogRScale.get(3)}%"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row am-cf">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-4 widget-margin-bottom-lg ">
                        <div class="tpl-user-card am-text-center widget-body-lg">
                            <div class="tpl-user-card-title">
                                陈鹏
                            </div>
                            <div class="achievement-subheading">
                                一个会摄影的程序员
                            </div>
                            <img class="achievement-image" src="${basePath }/img/user.png" alt="">
                            <div class="achievement-description">
                                陈鹏
                                <strong>30天内</strong> 发表了
                                <strong>${nub }</strong>篇文章。
                            </div>
                        </div>
                    </div>

                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-8 widget-margin-bottom-lg">

                        <div class="widget am-cf widget-body-lg">

                            <div class="widget-body  am-fr">
                                <div class="am-scrollable-horizontal ">
                                    <table width="100%" class="am-table am-table-compact am-text-nowrap tpl-table-black " id="example-r">
                                        <thead>
                                            <tr>
                                                <th>文章标题</th>
                                                <th>作者</th>
                                                <th>时间</th>
                                                <th>浏览量</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${pageList }" var="page">
	                                        	<tr class="gradeX">
	                                                <td><a href="${basePath }/index/page/${page.id}">${page.title }</a></td>
	                                                <td>${page.author }</td>
	                                                <td>${page.time }</td>
	                                                <td>${page.viewNumber }</td>
	                                            </tr>
                                        	</c:forEach>
                                            <!-- more data -->
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
   <jsp:include   page="../configEnd.jsp" flush="true"/>
	<script type="text/javascript">
        $('#example-r').DataTable({
	        bInfo: false, //页脚信息
	        dom: 'ti'
        });
        // ==========================
        // 百度图表A http://echarts.baidu.com/
        // ==========================

        var echartsA = echarts.init(document.getElementById('tpl-echarts'));
        option = {
            tooltip: {
                trigger: 'axis'
            },
            grid: {
                top: '3%',
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                boundaryGap: false,
                data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
            }],
            yAxis: [{
                type: 'value'
            }],
            textStyle: {
                color: '#838FA1'
            },
            series: [{
                name: '字数',
                type: 'line',
                stack: '总量',
                areaStyle: { normal: {} },
                data: [${blogRWord.get(0)}, 
		                ${blogRWord.get(1)}, 
		                ${blogRWord.get(2)}, 
		                ${blogRWord.get(3)}, 
		                ${blogRWord.get(4)}, 
		                ${blogRWord.get(5)}, 
		                ${blogRWord.get(6)}],
                itemStyle: {
                    normal: {
                        color: '#1cabdb',
                        borderColor: '#1cabdb',
                        borderWidth: '2',
                        borderType: 'solid',
                        opacity: '1'
                    },
                    emphasis: {

                    }
                }
            }]
        };
        echartsA.setOption(option);
	</script>
</body>

</html>
