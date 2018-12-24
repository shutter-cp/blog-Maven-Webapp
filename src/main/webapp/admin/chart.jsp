<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>统计</title>
  	<jsp:include page="../config.jsp" flush="true"/>
  </head>
  
<body data-type="chart">
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
					<a href="${basePath }/admin/chart"  class="active">
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
                        <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 图表 <small>统计</small></div>
                    </div>
                </div>
            </div>

            <div class="row-content am-cf">
                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">访问量</div>
                    </div>
                    <div class="widget-body am-fr">
                        <div style="height: 400px" class="" id="tpl-echarts-A">

                        </div>
                    </div>
                </div>


                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">浏览设备雷达</div>
                    </div>
                    <div class="widget-body am-fr">
                        <div style="height: 400px" id="tpl-echarts-B">

                        </div>
                    </div>
                </div>


                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">时间统计</div>
                    </div>
                    <div class="widget-body am-fr">
                        <div style="height: 400px" id="tpl-echarts-C">
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    </div>
    <jsp:include   page="../configEnd.jsp" flush="true"/>
	<script type="text/javascript">
		// ==========================
        // 百度图表A http://echarts.baidu.com/
        // ==========================

        var echartsC = echarts.init(document.getElementById('tpl-echarts-C'));


        optionC = {
            tooltip: {
                trigger: 'axis'
            },

            legend: {
                data: ['浏览', '评论', '创作']
            },
            xAxis: [{
                type: 'category',
                data: ['0-2点', '2-4点', '4-6点', '6-8点', '8-10点', '10-12点', '12-14点', '14-16点', '16-18点', '18-20点', '20-22点', '22-24点']
            }],
            yAxis: [{
                    type: 'value',
                    name: '次数',
                    axisLabel: {
                        formatter: '{value} 次'
                    }
                },
                {
                    type: 'value',
                    name: '篇数',
                    axisLabel: {
                        formatter: '{value} 篇'
                    }
                }
            ],
            series: [{
                    name: '浏览',
                    type: 'bar',
                    data: [${viewList.get(0)}, 
	                    ${viewList.get(1)}, 
	                    ${viewList.get(2)}, 
	                    ${viewList.get(3)}, 
	                    ${viewList.get(4)}, 
	                    ${viewList.get(5)}, 
	                    ${viewList.get(6)}, 
	                    ${viewList.get(7)}, 
	                    ${viewList.get(8)}, 
	                    ${viewList.get(9)}, 
	                    ${viewList.get(10)}, 
	                    ${viewList.get(11)}]
                },
                {
                    name: '评论',
                    type: 'bar',
                    data: [${comList.get(0)}, 
	                    ${comList.get(1)}, 
	                    ${comList.get(2)}, 
	                    ${comList.get(3)}, 
	                    ${comList.get(4)}, 
	                    ${comList.get(5)}, 
	                    ${comList.get(6)}, 
	                    ${comList.get(7)}, 
	                    ${comList.get(8)}, 
	                    ${comList.get(9)}, 
	                    ${comList.get(10)}, 
	                    ${comList.get(11)}]
                },
                {
                    name: '创作',
                    type: 'line',
                    yAxisIndex: 1,
                    data: [${wirteList.get(0)}, 
	                    ${wirteList.get(1)}, 
	                    ${wirteList.get(2)}, 
	                    ${wirteList.get(3)}, 
	                    ${wirteList.get(4)}, 
	                    ${wirteList.get(5)}, 
	                    ${wirteList.get(6)}, 
	                    ${wirteList.get(7)}, 
	                    ${wirteList.get(8)}, 
	                    ${wirteList.get(9)}, 
	                    ${wirteList.get(10)}, 
	                    ${wirteList.get(11)}]
                }
            ]
        };

        echartsC.setOption(optionC);

        var echartsB = echarts.init(document.getElementById('tpl-echarts-B'));
        optionB = {
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                x: 'center',
                data: ['设备浏览量', '软件浏览量']
            },
            radar: [{
                    indicator: [
                        { text: '苹果', max: 100 },
                        { text: '安卓', max: 100 },
                        { text: '电脑', max: 100 },
                        { text: '其他未知', max: 100 }
                    ],
                    center: ['25%', '50%'],
                    radius: 80
                },
                {
                    indicator: [
                        { text: '百度浏览器', max: 100 },
                        { text: '谷歌浏览器', max: 100 },
                        { text: 'qq浏览器', max: 100 },
                        { text: 'uc浏览器', max: 100 },
                        { text: '360浏览器', max: 100 },
                        { text: 'IE浏览器', max: 100 }
                    ],
                    radius: 80,
                    center: ['75%', '50%'],
                }
            ],
            series: [{
                    type: 'radar',
                    tooltip: {
                        trigger: 'item'
                    },
                    itemStyle: { normal: { areaStyle: { type: 'default' } } },
                    data: [{
                        value: [60, 73, 85, 40],
                        name: '设备浏览量'
                    }]
                },
                {
                    type: 'radar',
                    radarIndex: 1,
                    data: [{
                            value: [85, 90, 90, 95, 95, 10],
                            name: '软件浏览量'
                        }
                    ]
                }
            ]
        };
        echartsB.setOption(optionB);
        var echartsA = echarts.init(document.getElementById('tpl-echarts-A'));
        option = {

            tooltip: {
                trigger: 'axis',
            },
            legend: {
                data: ['摄影', '编程', '思考']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                boundaryGap: true,
                data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
            }],

            yAxis: [{
                type: 'value'
            }],
            series: [{
                    name: '摄影',
                    type: 'line',
                    stack: '总量',
                    areaStyle: { normal: {} },
                    data: [${photoList.get(1)}, 
		                    ${photoList.get(2)}, 
		                    ${photoList.get(3)}, 
		                    ${photoList.get(4)}, 
		                    ${photoList.get(5)}, 
		                    ${photoList.get(6)}, 
		                    ${photoList.get(0)}],
                    itemStyle: {
                        normal: {
                            color: '#59aea2'
                        },
                        emphasis: {

                        }
                    }
                },
                {
                    name: '编程',
                    type: 'line',
                    stack: '总量',
                    areaStyle: { normal: {} },
                    data: [${codeList.get(1)}, 
		                    ${codeList.get(2)}, 
		                    ${codeList.get(3)}, 
		                    ${codeList.get(4)}, 
		                    ${codeList.get(5)}, 
		                    ${codeList.get(6)}, 
		                    ${codeList.get(0)}],
                    itemStyle: {
                        normal: {
                            color: '#e7505a'
                        }
                    }
                },
                {
                    name: '思考',
                    type: 'line',
                    stack: '总量',
                    areaStyle: { normal: {} },
                    data: [${thinkList.get(1)}, 
		                    ${thinkList.get(2)}, 
		                    ${thinkList.get(3)}, 
		                    ${thinkList.get(4)}, 
		                    ${thinkList.get(5)}, 
		                    ${thinkList.get(6)}, 
		                    ${thinkList.get(0)}],
                    itemStyle: {
                        normal: {
                            color: '#32c5d2'
                        }
                    }
                }
            ]
        };
        echartsA.setOption(option);
	</script>
</body>

</html>