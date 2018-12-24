/**
 * chenPeng
 * com.cp.blog.service
 * AdminLoginService.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午7:48:28 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.service.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cp.blog.bean.Admin;
import com.cp.blog.dao.admin.LoginDao;

/**
 * 
 * AdminLoginService
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午7:48:28 
 * @version 1.0.0
 * 
 */
@Service
public class LoginService {
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 登陆
	 * 方法名：login
	 * 创建人：chenPeng
	 * 时间：2018年12月21日-下午8:55:27 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	*/
	public ModelAndView login(String username, String password) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setPassword(password);
		admin.setUsername(username);
		
		Admin rAdmin = loginDao.login(admin);
		
		
		re.getSession().setAttribute("admin", rAdmin);
		
		return new ModelAndView("redirect:/admin/index");
	}

}
