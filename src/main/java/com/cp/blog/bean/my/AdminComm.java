/**
 * chenPeng
 * com.cp.blog.bean.my
 * AdminComm.java
 * 创建人:chenpeng
 * 时间：2018年12月23日-下午6:47:49 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.bean.my;

import com.cp.blog.bean.Comment;

/**
 * 
 * AdminComm
 * 创建人:chenPeng
 * 时间：2018年12月23日-下午6:47:49 
 * @version 1.0.0
 * 
 */
public class AdminComm extends Comment{
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
