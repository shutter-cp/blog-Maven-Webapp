/**
 * chenPeng
 * com.cp.blog.bean
 * User.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午8:30:17 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.bean;

/**
 * 用户
 * User
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午8:30:17 
 * @version 1.0.0
 * 
 */
public class User {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Integer status;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
