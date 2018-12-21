/**
 * chenPeng
 * com.cp.blog.web
 * Test.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-上午1:20:00 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cp.blog.bean.TestUser;
import com.cp.blog.dao.TestDao;

/**
 * 
 * Test
 * 创建人:chenPeng
 * 时间：2018年12月21日-上午1:20:00 
 * @version 1.0.0
 * 
 */
@Controller
public class TestWeb {
	@Autowired
	private TestDao testDao;
	
	@GetMapping("/test")
	public ModelAndView testtWeb(){
		ModelAndView andView = new ModelAndView();
		System.out.println(1);
		List<TestUser> userList = testDao.tests();
		for (TestUser testUser : userList) {
			System.out.println(testUser.getUsername());
		}
		return andView;
	}
}
