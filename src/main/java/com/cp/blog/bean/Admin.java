/**
 * chenPeng
 * com.cp.blog.bean
 * Admin.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午8:27:39 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.bean;

/**
 * 管理员
 * Admin
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午8:27:39 
 * @version 1.0.0
 * 
 */
public class Admin {
	private Integer id;
	private String username;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
