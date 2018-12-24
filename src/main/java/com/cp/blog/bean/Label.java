/**
 * chenPeng
 * com.cp.blog.bean
 * Label.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午8:28:05 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.bean;

/**
 * 标签
 * Label
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午8:28:05 
 * @version 1.0.0
 * 
 */
public class Label {
	private Integer id;
	private Integer sortId;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSortId() {
		return sortId;
	}
	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
