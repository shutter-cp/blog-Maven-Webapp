/**
 * chenPeng
 * com.cp.blog.bean
 * Calendar.java
 * 创建人:chenpeng
 * 时间：2018年12月23日-下午2:06:50 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.bean;

/**
 * 日历
 * Calendar
 * 创建人:chenPeng
 * 时间：2018年12月23日-下午2:06:50 
 * @version 1.0.0
 * 
 */
public class Calendar {
	private String id;
	private String title;
	private Long start;
	private Long end;
	private String color;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start;
	}
	public Long getEnd() {
		return end;
	}
	public void setEnd(Long end) {
		this.end = end;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	

}
