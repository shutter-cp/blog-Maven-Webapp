/**
 * chenPeng
 * com.cp.blog.bean
 * WritrLog.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午8:30:35 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.bean;

/**
 * 撰写记录
 * WritrLog
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午8:30:35 
 * @version 1.0.0
 * 
 */
public class WritrLog {
	private Integer id;
	private String time;
	private Integer pageId;
	private Integer adminId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	
}
