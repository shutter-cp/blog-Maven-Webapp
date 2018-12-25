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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cp.blog.bean.Label;
import com.cp.blog.bean.Logs;
import com.cp.blog.bean.Page;
import com.cp.blog.bean.User;
import com.cp.blog.bean.my.IndexCom;
import com.cp.blog.service.BlogIndexService;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
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
	
	public void addVersion(Integer pageId){
		Logs logs = new Logs();
		
		String agentStr = re.getHeader("user-agent");
		UserAgent agent = UserAgent.parseUserAgentString(agentStr);
		Browser browser = agent.getBrowser();
		OperatingSystem os = agent.getOperatingSystem();
		/**
		 * browser
		 */
		logs.setBrowser(browser.getGroup().toString());
		/**
		 * allMSG 
		 */
		logs.setAllMsg(agentStr);
		/**
		 * device
		 */
		logs.setDevice(os.getGroup().toString());
		
		logs.setPageId(pageId);
		/**
		 * ip
		 */
		String fromSource = "X-Real-IP";
		String ip = re.getHeader("X-Real-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = re.getHeader("X-Forwarded-For");
			fromSource = "X-Forwarded-For";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = re.getHeader("Proxy-Client-IP");
			fromSource = "Proxy-Client-IP";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = re.getHeader("WL-Proxy-Client-IP");
			fromSource = "WL-Proxy-Client-IP";
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = re.getRemoteAddr();
			fromSource = "request.getRemoteAddr";
		}
		logs.setIp(ip);
		
		blogIndexService.addVersion(logs);
		blogIndexService.addViewNub(pageId);
	}
	
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
		
		addVersion(1);
		
		ModelAndView andView = new ModelAndView();
		//拿到部分页面
		List<Page> pageList = blogIndexService.getPageList(1,1);
		//拿到页码
		Integer pageNo = blogIndexService.getPageNo(1);
		//拿到标签
		List<Label> labelList = blogIndexService.getLabelList(1);
		//拿到首页内容
		Page page = blogIndexService.getPage(1);
		//得到评论
		List<IndexCom> commentList =  blogIndexService.getCommentList(1);
		
		
		re.getSession().setAttribute("sortId", 1);
		re.getSession().setAttribute("pageId", 1);
		
		if ((int)pageNo%12 != 0) {
			pageNo = pageNo/12;
			pageNo++;
		}else{
			pageNo--;
		}
		andView.addObject("pageNo", pageNo);
		andView.addObject("pageList", pageList);
		andView.addObject("labelList", labelList);
		andView.addObject("page", page);
		andView.addObject("commentList", commentList);
		
		andView.setViewName("index");
		return andView;
	}
	
	@GetMapping("index/page/{no}")
	public ModelAndView getIndex(@PathVariable Integer no){
		addVersion(no);
		ModelAndView andView = new ModelAndView();
		//拿到部分页面
		List<Page> pageList = blogIndexService.getPageList(1,1);
		//拿到页码
		Integer pageNo = blogIndexService.getPageNo(1);
		//拿到标签
		List<Label> labelList = blogIndexService.getLabelList(1);
		//拿到首页内容
		Page page = blogIndexService.getPage(no);
		//得到评论
		List<IndexCom> commentList =  blogIndexService.getCommentList(no);
		
		
		re.getSession().setAttribute("sortId", 1);
		re.getSession().setAttribute("pageId", no);
		
		if ((int)pageNo%12 != 0) {
			pageNo = pageNo/12;
			pageNo++;
		}else{
			pageNo--;
		}
		andView.addObject("pageNo", pageNo);
		andView.addObject("pageList", pageList);
		andView.addObject("labelList", labelList);
		andView.addObject("page", page);
		andView.addObject("commentList", commentList);
		
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
		
		if (sortId == 7) {
			//拿到部分页面
			List<Page> pageList = blogIndexService.getPageLists(no);
			
			for (Page page : pageList) {
				json.add(page);
			}
		}else{
			//拿到部分页面
			List<Page> pageList = blogIndexService.getPageList(sortId,no);
			
			for (Page page : pageList) {
				json.add(page);
			}
		}
		return json.toString();
	}
	
	/**
	 * 查询
	 * 方法名：sort
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午11:30:30 
	 * 手机:17673111810
	 * @param sortId
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping(value="/index/fond",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String fond(String fondMsg){
		JSONArray page = new JSONArray();
		//拿到部分页面
		List<Page> pageList = blogIndexService.getPageListFond(fondMsg);
		
		for (Page page2 : pageList) {
			page.add(page2);
		}
		return page.toString();
	}
	
	
	/**
	 * 点击标题
	 * 方法名：sort
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午11:29:59 
	 * 手机:17673111810
	 * @param sortId
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping(value="/index/sort",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String sort(Integer sortId){
		re.getSession().setAttribute("sortId", sortId);
		JSONArray json = new JSONArray();
		if (sortId<=5||sortId==8) {
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
		}else if (sortId == 6) {
			//拿到标签
			List<Label> labelList = blogIndexService.getLabelLists();
			for (Label label : labelList) {
				json.add(label);
			}
		}else if (sortId == 7) {
			JSONArray page = new JSONArray();
			JSONArray nub = new JSONArray();
			//拿到部分页面
			List<Page> pageList = blogIndexService.getPageLists(1);
			//拿到页码
			Integer pageNo = blogIndexService.getPageNos();
			
			for (Page page2 : pageList) {
				page.add(page2);
			}

			if ((int)pageNo%12 != 0) {
				pageNo = pageNo/12;
				pageNo++;
			}else{
				pageNo--;
			}
			nub.add(pageNo);
			
			json.add(page);
			json.add(nub);
		}
		return json.toString();
	}
	
	/**
	 * 点击页面
	 * 方法名：getPage
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午4:35:06 
	 * 手机:17673111810
	 * @param pageId
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping(value="/index/page",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String getPage(Integer pageId){
		addVersion(pageId);
		re.getSession().setAttribute("pageId", pageId);
		JSONArray json = new JSONArray();
		JSONArray page = new JSONArray();
		JSONArray com = new JSONArray();
		
		Page pageMsg = blogIndexService.getPage(pageId);
		List<IndexCom> commentList =  blogIndexService.getCommentList(pageId);
		
		page.add(pageMsg);
		for (IndexCom indexCom : commentList) {
			com.add(indexCom);
		}
		
		json.add(page);
		json.add(com);
		return json.toString();
	}
	
	/**
	 * 登录
	 * 方法名：login
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午6:34:13 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping(value="/login",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String login(String username,String password){
		if (username.equals("")||password.equals("")) {
			return "error";
		}
	 	User user =  blogIndexService.login(username,password);
	 	if (user!=null) {
	 		re.getSession().setAttribute("user", user);
		}else{
			return "error";
		}
		return user.getId()+"";
	}
	
	/**
	 * 登录
	 * 方法名：add
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午6:41:14 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @param email
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping(value="/add",produces= "application/String; charset=utf-8")
	@ResponseBody
	public String add(String username,String password,String email){
		if (username.equals("")||password.equals("")||email.equals("")) {
			return "请将信息填写完整！";
		}
	 	
		return blogIndexService.add(username,password,email);
	}
	
	@PostMapping(value="/user/addCom",produces= "application/String; charset=utf-8")
	@ResponseBody
	public String addCom(String comMsg){
		if (comMsg.equals("")) {
			return "评论不能为空！";
		}
		Integer pageId = (Integer) re.getSession().getAttribute("pageId");
		Integer userId = ((User)re.getSession().getAttribute("user")).getId();
		return blogIndexService.addCom(comMsg,pageId,userId);
	}
	
	@PostMapping("/loginOut")
	@ResponseBody
	public String loginOut(){
		re.getSession().setAttribute("user", null);
		return "success";
	}
	
}
