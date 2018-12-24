/**
 * chenPeng
 * com.cp.blog.service
 * BlogIndexService.java
 * 创建人:chenpeng
 * 时间：2018年12月24日-下午11:24:50 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.blog.bean.Label;
import com.cp.blog.bean.Page;
import com.cp.blog.dao.BlogIndexDao;

/**
 * 
 * BlogIndexService
 * 创建人:chenPeng
 * 时间：2018年12月24日-下午11:24:50 
 * @version 1.0.0
 * 
 */
@Service
public class BlogIndexService {
	@Autowired
	private BlogIndexDao blogIndexDao;
	
	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageList
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午11:59:25 
	 * 手机:17673111810
	 * @param i
	 * @param no 
	 * @return List<Page>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Page> getPageList(int sortId, int no) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("sortId", sortId);
		map.put("no", (no-1)*12);
		return blogIndexDao.getPageList(map);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageNo
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-上午12:24:54 
	 * 手机:17673111810
	 * @param i
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getPageNo(int labelId) {
		// TODO Auto-generated method stub
		return blogIndexDao.getPageNo(labelId);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLabelList
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-上午12:41:36 
	 * 手机:17673111810
	 * @param i
	 * @return List<Label>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Label> getLabelList(int sortId) {
		// TODO Auto-generated method stub
		return blogIndexDao.getLabelList(sortId);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLPageList
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-上午1:09:11 
	 * 手机:17673111810
	 * @param id
	 * @return List<Page>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Page> getLPageList(Integer id) {
		// TODO Auto-generated method stub
		return blogIndexDao.getLPageList(id);
	}

}
