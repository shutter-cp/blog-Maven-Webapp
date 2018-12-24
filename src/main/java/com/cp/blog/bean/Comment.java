/**
 * chenPeng
 * com.cp.blog.bean
 * Comment.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午8:27:53 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.bean;

/**
 * 评论
 * Comment
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午8:27:53 
 * @version 1.0.0
 * 
 */
public class Comment {
	private Integer id;
	private String mainText;
	private String reText;
	private Integer pageId;
	private Integer userId;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMainText() {
		return mainText;
	}
	public void setMainText(String mainText) {
		this.mainText = mainText;
	}
	public String getReText() {
		return reText;
	}
	public void setReText(String reText) {
		this.reText = reText;
	}
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
