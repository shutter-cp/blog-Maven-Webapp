/**
 * chenPeng
 * com.cp.blog.web
 * BlogIndex.java
 * 创建人:chenpeng
 * 时间：2018年12月24日-下午11:24:16 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cp.blog.bean.Label;
import com.cp.blog.bean.Page;
import com.cp.blog.service.BlogIndexService;

import net.sf.json.JSONArray;

/**
 * 
 * BlogIndex
 * 创建人:chenPeng
 * 时间：2018年12月24日-下午11:24:16 
 * @version 1.0.0
 * 
 */
@Controller
public class BlogIndexWeb {
	@Autowired
	private BlogIndexService blogIndexService;
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 初始化页面
	 * 方法名：initIndex
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-上午1:05:59 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/index")
	public ModelAndView initIndex(){
		ModelAndView andView = new ModelAndView();
		//拿到部分页面
		List<Page> pageList = blogIndexService.getPageList(1,1);
		//拿到页码
		Integer pageNo = blogIndexService.getPageNo(1);
		//拿到标签
		List<Label> labelList = blogIndexService.getLabelList(1);
		
		re.getSession().setAttribute("sortId", 1);
		
		if ((int)pageNo%12 != 0) {
			pageNo = pageNo/12;
			pageNo++;
		}else{
			pageNo--;
		}
		andView.addObject("pageNo", pageNo);
		andView.addObject("pageList", pageList);
		andView.addObject("labelList", labelList);
		
		andView.setViewName("index");
		return andView;
	}
	
	/**
	 * 动态刷标签
	 * 方法名：labeal
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-上午1:06:17 
	 * 手机:17673111810
	 * @param id
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping(value="/index/labeal",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String labeal(Integer id){
		JSONArray json = new JSONArray();
		List<Page> pageList = blogIndexService.getLPageList(id);
		
		for (Page page : pageList) {
			json.add(page);
		}
		return json.toString();
	}
	
	/**
	 * 分页
	 * 方法名：labeal
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-上午1:50:40 
	 * 手机:17673111810
	 * @param id
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping(value="/index/fy",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String fy(Integer no){
		JSONArray json = new JSONArray();
		//拿到分类
		Integer sortId = (Integer) re.getSession().getAttribute("sortId");
		//拿到部分页面
		List<Page> pageList = blogIndexService.getPageList(sortId,no);
		
		for (Page page : pageList) {
			json.add(page);
		}
		return json.toString();
	}
	
	@PostMapping(value="/index/sort",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String sort(Integer sortId){
		re.getSession().setAttribute("sortId", sortId);
		JSONArray json = new JSONArray();
		if (sortId<=5) {
			JSONArray label = new JSONArray();
			JSONArray page = new JSONArray();
			JSONArray nub = new JSONArray();
			//拿到部分页面
			List<Page> pageList = blogIndexService.getPageList(sortId,1);
			//拿到页码
			Integer pageNo = blogIndexService.getPageNo(sortId);
			//拿到标签
			List<Label> labelList = blogIndexService.getLabelList(sortId);
			
			for (Page page2 : pageList) {
				page.add(page2);
			}
			for (Label label2 : labelList) {
				label.add(label2);
			}
			
			if ((int)pageNo%12 != 0) {
				pageNo = pageNo/12;
				pageNo++;
			}else{
				pageNo--;
			}
			
			nub.add(pageNo);
			
			json.add(label);
			json.add(page);
			json.add(nub);
		}
		
		
		return json.toString();
	}
	
}
