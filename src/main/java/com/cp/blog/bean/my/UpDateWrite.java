/**
 * chenPeng
 * com.cp.blog.bean.my
 * UpDateWrite.java
 * 创建人:chenpeng
 * 时间：2018年12月24日-上午1:48:39 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.bean.my;

import com.cp.blog.bean.Page;

/**
 * 
 * UpDateWrite
 * 创建人:chenPeng
 * 时间：2018年12月24日-上午1:48:39 
 * @version 1.0.0
 * 
 */
public class UpDateWrite extends Page{
	private Integer sortId;
	private String sortName;
	private String name;
	public Integer getSortId() {
		return sortId;
	}
	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
