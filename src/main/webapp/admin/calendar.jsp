<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>日历</title>
    <jsp:include page="../config.jsp" flush="true"/>
        <link rel="stylesheet" href="${basePath }/admin/assets/css/fullcalendar.min.css" />
    <link rel="stylesheet" href="${basePath }/admin/assets/css/fullcalendar.print.css" media='print' />
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
					<a href="${basePath }/admin/tables">
						<i class="am-icon-table sidebar-nav-link-logo"></i> 管理
					</a>
				</li>
				<li class="sidebar-nav-link">
					<a href="${basePath }/admin/calendar" class="active">
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
            <div class="row-content am-cf">
                <div class="tpl-calendar-box">
                    <div id="calendar"></div>
                </div>
            </div>
        </div>
    </div>
    </div>


    <!-- 弹出层 -->

    <div class="am-modal am-modal-no-btn" id="boxUpdate">
        <div class="am-modal-dialog tpl-model-dialog">
            <div class="am-modal-hd">
                <a href="javascript: void(0)" class="am-close edit-box-close am-close-spin" data-am-modal-close>&times;</a>
            </div>
            <div class="am-modal-bd tpl-am-model-bd am-cf">
               	<button class="am-btn am-btn-default am-round am-btn-block" onclick="myDelete()">删除</button>
                <form class="am-form tpl-form-border-form">
                    <div class="am-form-group am-u-sm-12">
                        <h1>修改 </h1>
                        <div class="am-u-sm-12">
                        	<label>标题</label>
                            <input type="text" class="tpl-form-input am-margin-top-xs calendar-edit-box-title" id="titleName" value=""/>
                        </div>
                        <button class="am-btn am-btn-default am-round am-btn-block" onclick="myUpDate();">提交</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
   
    
	<jsp:include  page="../configEnd.jsp" flush="true"/>
	<script src="${basePath }/admin/assets/js/moment.js"></script>
    <script src="${basePath }/admin/assets/js/fullcalendar.min.js"></script>
    <script type="text/javascript" src="${basePath }/js/cp.js"></script>
    <script>
    var dateId = "";
        $(document).ready(function() {
            var editBox = $('#calendar-edit-box');
			var upBox = $('#boxUpdate');
			var dateMsg = ${dateMsg};
			
            $('.edit-box-close').on('click', function() {
                $('#calendar').fullCalendar('unselect');
            })
            $('#calendar').fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek,agendaDay'
                },
                monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                monthNamesShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                dayNames: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"],
                dayNamesShort: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"],
                today: ["今天"],
                firstDay: 1,
                buttonText: {
                    today: '本月',
                    month: '月',
                    week: '周',
                    day: '日',
                    prev: '上一月',
                    next: '下一月'
                },
                lang: 'zh-cn',
                navLinks: true, // can click day/week names to navigate views
                selectable: true,
                selectHelper: true,
                select: function(start, end) {
                    var title = prompt('填写你的需要标注的信息:');
                    var eventData;
                    if (title) {
                        eventData = {
                            title: title,
                            start: start,
                            end: end
                        };
                        var sta = start+"";
                        var ends = end+"";
                         //发送form表单 —— 添加
						var time = new Date().getTime()+"";
						$.ajax({
							type:"post",
							url:"${basePath}/admin/calendar/add",
							data:{"id":time,
								  "title":title,
								  "start":sta,
								  "end":ends},
							success:function(date){
								if(date=="success"){
			                        $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
								}else{
									alert("添加错误请重试！")
								}
							}
						});
                    }
                    $('#calendar').fullCalendar('unselect');
                },
                editable: true,
                eventLimit: true, // allow "more" link when too many events
                eventClick: function(event, jsEvent, view) {
                	//此处修改
                    //event.source.events[0].title = '222223333'
                    // 修改数据
                    // 标题
                    //$('.calendar-edit-box-title').val(event.title)
                    //  弹出框
                    
                   // for(int i=0;i<)
                    
                    //alert(event.title);
                    //alert(event.id);
                    //alert(event.start+'’'+event.end);
                    dateId = event.id;
                    upBox.modal();
                   	//window.location.reload();
                },
                events: dateMsg
              
            });
        });
        
        myDelete = function(){
	        post('${basePath}/admin/calendar/delete',{id:dateId});
        }
        
        myUpDate = function(){
        	var titles = $("#titleName").val();
        	post('${basePath}/admin/calendar/upData',{id:dateId,'title':titles});
        }
    </script>
</body>
</html>