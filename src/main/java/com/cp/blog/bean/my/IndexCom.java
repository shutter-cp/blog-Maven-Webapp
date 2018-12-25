/**
 * chenPeng
 * com.cp.blog.bean.my
 * IndexCom.java
 * 创建人:chenpeng
 * 时间：2018年12月25日-下午3:43:30 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.bean.my;

import com.cp.blog.bean.Comment;

/**
 * 
 * IndexCom
 * 创建人:chenPeng
 * 时间：2018年12月25日-下午3:43:30 
 * @version 1.0.0
 * 
 */
public class IndexCom extends Comment{
	private String username;
	private String times;
	

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
