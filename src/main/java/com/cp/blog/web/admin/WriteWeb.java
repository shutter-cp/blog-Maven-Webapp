/**
 * chenPeng
 * com.cp.blog.web.admin
 * WriteWeb.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午10:14:55 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cp.blog.bean.Label;
import com.cp.blog.bean.Sort;
import com.cp.blog.service.admin.WriteSerivce;

import net.sf.json.JSONArray;

/**
 * 
 * WriteWeb
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午10:14:55 
 * @version 1.0.0
 * 
 */
@Controller
public class WriteWeb {
	@Autowired
	private WriteSerivce writeSerivce;
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 
	 * 初始化页面
	 * 方法名：initCalendar
	 * 创建人：chenPeng
	 * 时间：2018年12月21日-下午11:46:44 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/admin/write")
	public ModelAndView initCalendar(){
		ModelAndView andView = new ModelAndView();
		//拿到页面
		List<Sort> sortList = writeSerivce.getSortList();
		
		andView.addObject("sortList", sortList);
		andView.setViewName("admin/write");
		return andView;
	}
	
	
	/**
	 * 
	 * 查出标签信息
	 * 方法名：getLabel
	 * 创建人：chenPeng
	 * 时间：2018年12月22日-上午12:11:15 
	 * 手机:17673111810
	 * @param re
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(method=RequestMethod.POST,
			value="/admin/write/getLabel",
			produces = "application/String; charset=utf-8")
	@ResponseBody
	public String getLabel(HttpServletRequest re){
		JSONArray json = new JSONArray();
		Integer sortId = Integer.parseInt(re.getParameter("sortId"));
		List<Label> labelList = writeSerivce.getLabel(sortId);
		
		for (Label label : labelList) {
			json.add(label);
		}
		return json.toString();
	}
	
	/**
	 * 添加标签
	 * 方法名：addLabel
	 * 创建人：chenPeng
	 * 时间：2018年12月22日-上午12:58:15 
	 * 手机:17673111810
	 * @param sortId
	 * @param labelName
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/admin/write/addLab")
	public String addLabel(Integer sortId, String labelName){
		System.out.println(111);
		writeSerivce.addLabel(sortId,labelName);
		return "";
	}
	
	@PostMapping("/admin/writedo")
	public ModelAndView writeDo(String title,
				String author,
				String time,
				Integer labelId,
				String texts,
				Integer nub
			){
		if (author.equals("")||
				time.equals("")||
				labelId.equals("")||
				texts.equals("")) {
			re.getSession().setAttribute("errorMsg", "请将信息填写完整");
			return new ModelAndView("redirect:/error.jsp");
		}
		try {
			writeSerivce.writeDo(title, author, time, labelId, texts, nub);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			re.getSession().setAttribute("errorMsg", "写入错误");
			return new ModelAndView("redirect:/error.jsp");
		}
		
		return new ModelAndView("redirect:/admin/tables");
	}
	
}
