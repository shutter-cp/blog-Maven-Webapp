/**
 * chenPeng
 * com.cp.blog.web.admin
 * ChartWeb.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午10:15:53 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cp.blog.service.admin.ChartSerivce;

/**
 * 
 * ChartWeb
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午10:15:53 
 * @version 1.0.0
 * 
 */
@Controller
public class ChartWeb {
	@Autowired
	private ChartSerivce chartSerivce;
	
	@GetMapping("/admin/chart")
	public ModelAndView initCalendar(){
		ModelAndView andView = new ModelAndView();
		
		//得到摄影数据
		List<Integer> photoList = chartSerivce.getDateList("photo");
		//得到编程数据
		List<Integer> codeList = chartSerivce.getDateList("code");
		//得到思考数据
		List<Integer> thinkList = chartSerivce.getDateList("think");
		
		
		//得到浏览数据
		List<Integer> viewList = chartSerivce.getViewList();
		//得到评论数据
		List<Integer> comList = chartSerivce.getComList();
		//得到创造数据
		List<Integer> wirteList = chartSerivce.getWirteList();
		
		
		andView.addObject("photoList", photoList);
		andView.addObject("codeList", codeList);
		andView.addObject("thinkList", thinkList);
		
		andView.addObject("viewList", viewList);
		andView.addObject("comList", comList);
		andView.addObject("wirteList", wirteList);
		
		andView.setViewName("admin/chart");
		return andView;
	}
}
