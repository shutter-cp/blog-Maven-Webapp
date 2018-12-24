/**
 * chenPeng
 * com.cp.blog.web.admin
 * Tables.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午10:10:29 
 * 2018陈鹏-版权所有
 */

package com.cp.blog.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cp.blog.bean.Page;
import com.cp.blog.bean.Sort;
import com.cp.blog.bean.User;
import com.cp.blog.bean.my.AdminComm;
import com.cp.blog.bean.my.UpDateWrite;
import com.cp.blog.service.admin.TablesService;
import com.cp.blog.service.admin.WriteSerivce;

import net.sf.json.JSONArray;

/**
 * 
 * Tables
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午10:10:29 
 * @version 1.0.0
 * 
 */
@Controller
public class TablesWeb {
	@Autowired
	private TablesService tablesService;
	@Autowired
	private WriteSerivce writeSerivce;
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 初始化
	 * 方法名：initCalendar
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:07:22 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/admin/tables")
	public ModelAndView initCalendar(){
		ModelAndView andView = new ModelAndView();
		
		//得到全部的用户
		List<User> userList = tablesService.getUserList(0);
		Integer userNub = tablesService.getUserNub();
		//得到全部的评论
		List<AdminComm> commentList = tablesService.getComList(0);
		Integer comNub = tablesService.getComNub();
		//得到全部的文章
		List<Page> pageList = tablesService.getPageList(0);
		Integer pageNub = tablesService.getPageNub();
		

		andView.addObject("userNub", userNub-1);
		andView.addObject("comNub", comNub-1);
		andView.addObject("pageNub", pageNub-1);
		andView.addObject("userList", userList);
		andView.addObject("commentList", commentList);
		andView.addObject("pageList", pageList);
		
		andView.setViewName("admin/tables");
		return andView;
	}
	
	/**
	 * 分页
	 * 方法名：getMsg
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:07:05 
	 * 手机:17673111810
	 * @param str
	 * @param no
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping(value = "/admin/tebles/getMsg",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String getMsg(String str,Integer no){
		JSONArray json = new JSONArray();
		
		if (str.equals("user")) {
			List<User> userList = tablesService.getUserList(no);
			for (User user : userList) {
				json.add(user);
			}
		}else if(str.equals("com")){
			List<AdminComm> commentList = tablesService.getComList(no);
			for (AdminComm adminComm : commentList) {
				json.add(adminComm);
			}
		}else if(str.equals("page")){
			List<Page> pageList = tablesService.getPageList(no);
			for (Page page : pageList) {
				json.add(page);
			}
		}
		return json.toString();
	}
	
	/**
	 * 修改删除等
	 * 方法名：userUp
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:36:05 
	 * 手机:17673111810
	 * @param id
	 * @param state
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/admin/tebles/userUp")
	@ResponseBody
	public String userUp(Integer id,Integer state){
		tablesService.userUp(id,state);
		return "success";
	}
	
	@PostMapping("/admin/tebles/userDelete")
	@ResponseBody
	public String userDelete(Integer id){
		tablesService.userDelete(id);
		return "success";
	}
	
	@PostMapping("/admin/tebles/commUp")
	@ResponseBody
	public String commUp(Integer id,Integer state){
		tablesService.commUp(id,state);
		return "success";
	}
	
	@PostMapping("/admin/tebles/commDelete")
	@ResponseBody
	public String commDelete(Integer id){
		tablesService.commDelete(id);
		return "success";
	}
	
	@PostMapping("/admin/tebles/pageUp")
	@ResponseBody
	public String pageUp(Integer id,Integer state){
		tablesService.pageUp(id,state);
		return "success";
	}
	
	@PostMapping("/admin/tebles/pageDelete")
	@ResponseBody
	public String pageDelete(Integer id){
		tablesService.pageDelete(id);
		return "success";
	}
	
	@PostMapping("/admin/tebles/reTextSubmt")
	@ResponseBody
	public String reTextSubmt(Integer id,String reText){
		tablesService.reTextSubmt(id,reText);
		return "success";
	}
	
	/**
	 * 修改页面
	 * 方法名：upDatePage
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-上午1:35:39 
	 * 手机:17673111810
	 * @param id
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/admin/tables/upDatePage")
	public ModelAndView upDatePage(Integer id){
		ModelAndView andView = new ModelAndView();
		
		//拿到页面全部 信息
		UpDateWrite page = tablesService.getPage(id);
		
		List<Sort> sortList = writeSerivce.getSortList();
		
		andView.addObject("id", id);
		andView.addObject("page", page);
		andView.addObject("sortList", sortList);
		andView.setViewName("admin/upDateWrite");
		return andView;
	}
	
	@PostMapping("/admin/write/upDateDo")
	public ModelAndView upDateDo(String title,
			String author,
			String time,
			Integer labelId,
			String texts,
			Integer nub,
			Integer id
		){
		if (author.equals("")||
				time.equals("")||
				labelId.equals("")||
				texts.equals("")) {
			re.getSession().setAttribute("errorMsg", "请将信息填写完整");
			return new ModelAndView("redirect:/error.jsp");
		}
		try {
			tablesService.upDateDo(title, author, time, labelId, texts, nub, id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			re.getSession().setAttribute("errorMsg", "写入错误");
			return new ModelAndView("redirect:/error.jsp");
		}
		
		return new ModelAndView("redirect:/admin/tables");
	}
}
