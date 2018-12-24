/**
 * chenPeng
 * com.cp.blog.test
 * Test.java
 * 创建人:chenpeng
 * 时间：2018年12月24日-下午2:54:00 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.test;

import com.cp.blog.core.CpDate;

/**
 * 
 * Test
 * 创建人:chenPeng
 * 时间：2018年12月24日-下午2:54:00 
 * @version 1.0.0
 * 
 */
public class Test {
	public static void main(String[] args) {
		CpDate cpDate = new CpDate();
		
		System.out.println(cpDate.changeTime(-7,"yyyy-MM-dd","2018-12-23"));
		System.out.println(cpDate.changeTime(-7, "yyyy-MM-dd E"));
	}
}
