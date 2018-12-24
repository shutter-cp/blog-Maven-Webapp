/**
 * chenPeng
 * com.cp.blog.web.admin
 * CalendarWeb.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午10:14:00 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cp.blog.bean.Calendar;
import com.cp.blog.bean.my.GoBackCalendar;
import com.cp.blog.core.CpDate;
import com.cp.blog.service.admin.CalendarService;

import net.sf.json.JSONArray;

/**
 * 日历页面
 * CalendarWeb
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午10:14:00 
 * @version 1.0.0
 * 
 */
@Controller
public class CalendarWeb {
	@Autowired
	private CalendarService calendarService;
	/**
	 * 
	 * 初始化页面
	 * 方法名：initCalendar
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午12:03:49 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/admin/calendar")
	public ModelAndView initCalendar(){
		ModelAndView andView = new ModelAndView();
		
		JSONArray json = new JSONArray();
		CpDate cpDate = new CpDate();
		GoBackCalendar backCalendar = new GoBackCalendar(); 
		List<Calendar> calList = calendarService.getMsg();
		if (calList==null) {
			andView.setViewName("error");
			return andView;
		}
		for (Calendar calendar : calList) {
			backCalendar.setId(calendar.getId());
			backCalendar.setTitle(calendar.getTitle());
			backCalendar.setStart(cpDate.getTimeFormat("yyyy-MM-dd HH:mm", calendar.getStart()));
			backCalendar.setEnd(cpDate.getTimeFormat("yyyy-MM-dd HH:mm", calendar.getEnd()));
			backCalendar.setColor(calendar.getColor());
			json.add(backCalendar);
		}
		
		andView.addObject("dateMsg", json.toString());
		
		andView.setViewName("admin/calendar");
		return andView;
	}
	
	/**
	 * 
	 * 添加日历
	 * 方法名：add
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午1:59:55 
	 * 手机:17673111810
	 * @param id
	 * @param title
	 * @param start
	 * @param end
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/admin/calendar/add")
	@ResponseBody
	public String add(String id,
			String title,
			String start,
			String end
			){
		return calendarService.add(id,title,start,end);
	}
	
	/**
	 * 删除
	 * 方法名：delete
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午5:11:01 
	 * 手机:17673111810
	 * @param dateId
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/admin/calendar/delete")
	public ModelAndView delete(String id){
		if(calendarService.delete(id)){
			return new ModelAndView("redirect:/admin/calendar");
		}
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	
	/**
	 * 修改 
	 * 方法名：upData
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午5:27:13 
	 * 手机:17673111810
	 * @param id
	 * @param title
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/admin/calendar/upData")
	public ModelAndView upDatas(String id,String title){
		if(calendarService.upData(id,title)){
			return new ModelAndView("redirect:/admin/calendar");
		}
		ModelAndView andView = new ModelAndView();
		andView.setViewName("error");
		return andView;
	}
	
/*	未实现  通过获取全部来实现
 * @PostMapping("/admin/calendar/getMsg")
	@ResponseBody
	public JSONArray getMsg(String start,String end,String _){
		JSONArray json = new JSONArray();
		CpDate cpDate = new CpDate();
		System.out.println(_);
		GoBackCalendar backCalendar = new GoBackCalendar(); 
		List<Calendar> calList = calendarService.getMsg(start,end);
		for (Calendar calendar : calList) {
			backCalendar.setId(calendar.getId());
			backCalendar.setTitle(calendar.getTitle());
			backCalendar.setStart(cpDate.getTimeFormat("yyyy-MM-dd HH:mm", calendar.getStart()));
			backCalendar.setEnd(cpDate.getTimeFormat("yyyy-MM-dd HH:mm", calendar.getEnd()));
			backCalendar.setColor(calendar.getColor());
			json.add(backCalendar);
		}
		System.out.println(json);
		return json;
	}*/
}
