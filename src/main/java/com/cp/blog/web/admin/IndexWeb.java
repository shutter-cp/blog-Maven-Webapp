/**
 * chenPeng
 * com.cp.blog.web
 * AdminIndex.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午9:49:14 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cp.blog.bean.Page;
import com.cp.blog.core.CpDate;
import com.cp.blog.service.admin.IndexService;

/**
 * 管理员首页
 * AdminIndex
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午9:49:14 
 * @version 1.0.0
 * 
 */
@Controller
public class IndexWeb {
	@Autowired
	private IndexService indexService;
	
	/**
	 * 
	 * 初始化页面
	 * 方法名：initIndex
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午1:55:28 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/admin/index")
	public ModelAndView initIndex(){
		ModelAndView andView = new ModelAndView();
		CpDate cpDate = new CpDate();
		Integer month = Integer.parseInt(cpDate.getTimeFormat("MM"));
		Integer year = Integer.parseInt(cpDate.getTimeFormat("yy"));
		String week = cpDate.getTimeFormat("E");
		Integer day = Integer.parseInt(cpDate.getTimeFormat("dd"));
		
		//得到本月博客量
		Integer blogWrite = indexService.getBlogWrite(year,month);
		//得到上月博客量
		Integer blogWriteL = indexService.getBlogWriteL(year,month);
		//得到本月访问量
		Integer blogRead = indexService.getBlogRead(year,month);
		//得到上月访问量
		Integer blogReadL = indexService.getBlogReadL(year,month);
		//得到本月评论量
		Integer blogCom = indexService.getBlogCom(year,month);
		//得到上月评论量
		Integer blogComL = indexService.getBlogComL(year,month);
		//得到上周每天书写博客的字数
		List<Integer> blogRWord = indexService.getBlogRWord(year,week,day);
		//统计全部的博客时间 分为4组 求比例
		List<Integer> blogRScale = indexService.getBlogRScale();
		//得到30天内的文章篇数
		Integer nub = indexService.getNub();
		//得到最新的几篇文章 课查看文章字数以及浏览量
		List<Page> pageList =  indexService.getPageList();
		
		
		andView.addObject("blogWrite", blogWrite);
		andView.addObject("blogWriteL", blogWriteL);
		andView.addObject("blogRead", blogRead);
		andView.addObject("blogReadL", blogReadL);
		andView.addObject("blogCom", blogCom);
		andView.addObject("blogComL", blogComL);
		andView.addObject("blogRWord", blogRWord);
		andView.addObject("blogRScale", blogRScale);
		andView.addObject("pageList", pageList);
		andView.addObject("nub", nub);
		
		andView.setViewName("admin/index");
		return andView;
	}
}
