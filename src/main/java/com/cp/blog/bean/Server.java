/**
 * chenPeng
 * com.cp.blog.bean
 * Server.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午8:29:35 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.bean;

/**
 * 服务器记录
 * Server
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午8:29:35 
 * @version 1.0.0
 * 
 */
public class Server {
	private Integer id;
	private String sumTime;
	private String bTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSumTime() {
		return sumTime;
	}
	public void setSumTime(String sumTime) {
		this.sumTime = sumTime;
	}
	public String getbTime() {
		return bTime;
	}
	public void setbTime(String bTime) {
		this.bTime = bTime;
	}
}
