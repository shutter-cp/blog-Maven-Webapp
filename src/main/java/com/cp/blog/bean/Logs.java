/**
 * chenPeng
 * com.cp.blog.bean
 * Logs.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午8:28:16 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.bean;

/**
 * 访问日志
 * Logs
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午8:28:16 
 * @version 1.0.0
 * 
 */
public class Logs {
	private Integer id;
	private String ip;
	private String time;
	private String device;
	private String browser;
	private Integer pageId;
	private String allMsg;
	
	public String getAllMsg() {
		return allMsg;
	}
	public void setAllMsg(String allMsg) {
		this.allMsg = allMsg;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

}
