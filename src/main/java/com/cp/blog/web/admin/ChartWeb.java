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

import com.cp.blog.bean.Logs;
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
		
		//得到访问记录
		List<Logs> logsList = chartSerivce.getLogsList();
		
		//记录设备
		Integer[] deviceList = {0,0,0,0};
		//记录浏览器
		Integer[] browserList = {0,0,0,0,0,0};
		
		for (Logs logs : logsList) {
			String browse = logs.getBrowser();
			String device = logs.getDevice();
			System.out.println(browse);
			System.out.println(device);
			if(browse == null){
				browserList[5]++;
			}else if(browse.equals("CHROME")) {
				browserList[0]++;
			}else if(browse.equals("FIREFOX")){
				browserList[1]++;
			}else if(browse.equals("IE")||browse.equals("EDGE")){
				browserList[2]++;
			}else if(browse.equals("OPERA")){
				browserList[3]++;
			}else if(browse.equals("SAFARI")){
				browserList[4]++;
			}else{
				browserList[5]++;
			}
			
			if (device == null) {
				deviceList[3]++;
			}else if(device.equals("IPHONE")) {
				deviceList[0]++;
			}else if(device.equals("ANDROID")){
				deviceList[1]++;
			}else if(device.equals("WINDOWS")){
				deviceList[2]++;
			}else{
				deviceList[3]++;
			}
		}
		
		andView.addObject("photoList", photoList);
		andView.addObject("codeList", codeList);
		andView.addObject("thinkList", thinkList);
		
		andView.addObject("viewList", viewList);
		andView.addObject("comList", comList);
		andView.addObject("wirteList", wirteList);
		
		andView.addObject("browserList", browserList);
		andView.addObject("deviceList", deviceList);
		
		andView.setViewName("admin/chart");
		return andView;
	}
}
