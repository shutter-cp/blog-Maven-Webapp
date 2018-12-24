/**
 * chenPeng
 * com.cp.blog.web
 * AdminLoginWeb.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午7:47:46 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cp.blog.service.admin.LoginService;

/**
 * 登录
 * AdminLoginWeb
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午7:47:46 
 * @version 1.0.0
 * 
 */
@Controller
public class LoginWeb {
	@Autowired
	private LoginService loginService;
	
	/**
	 * 初始化管理员登陆页面
	 * 方法名：initAdminLogin
	 * 创建人：chenPeng
	 * 时间：2018年12月21日-下午8:49:03 
	 * 手机:17673111810
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@GetMapping("/admin/login")
	public ModelAndView initAdminLogin(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("login");
		return andView;
	}
	
	/**
	 * 登陆
	 * 方法名：adminLogin
	 * 创建人：chenPeng
	 * 时间：2018年12月21日-下午8:52:52 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@PostMapping("/admin/loginDo")
	public ModelAndView adminLogin(String username,String password){
		return loginService.login(username,password);
	}
	
}
