/**
 * chenPeng
 * com.cp.blog.dao
 * AdminLoginDao.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午7:48:40 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.dao.admin;

import com.cp.blog.bean.Admin;

/**
 * 
 * AdminLoginDao
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午7:48:40 
 * @version 1.0.0
 * 
 */
public interface LoginDao {

	/**
	 * 登陆
	 * 方法名：login
	 * 创建人：chenPeng
	 * 时间：2018年12月21日-下午8:57:41 
	 * 手机:17673111810
	 * @param admin
	 * @return Admin
	 * @exception 
	 * @since  1.0.0
	*/
	public Admin login(Admin admin);

}
