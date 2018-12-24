/**
 * chenPeng
 * com.cp.blog.bean
 * Page.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午8:28:38 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.bean;

/**
 * 页面
 * Page
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午8:28:38 
 * @version 1.0.0
 * 
 */
public class Page {
	private Integer id;
	private String title;
	private String time;
	private String author;
	private Integer labelId;
	private String mainText;
	private Integer textNumber;
	private String viewNumber;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getLabelId() {
		return labelId;
	}
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	public String getMainText() {
		return mainText;
	}
	public void setMainText(String mainText) {
		this.mainText = mainText;
	}
	public Integer getTextNumber() {
		return textNumber;
	}
	public void setTextNumber(Integer textNumber) {
		this.textNumber = textNumber;
	}
	public String getViewNumber() {
		return viewNumber;
	}
	public void setViewNumber(String viewNumber) {
		this.viewNumber = viewNumber;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
