/**
 * chenPeng
 * com.cp.blog.dao
 * BlogIndexDao.java
 * 创建人:chenpeng
 * 时间：2018年12月24日-下午11:25:03 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.dao;

import java.util.List;
import java.util.Map;

import com.cp.blog.bean.Label;
import com.cp.blog.bean.Page;

/**
 * 
 * BlogIndexDao
 * 创建人:chenPeng
 * 时间：2018年12月24日-下午11:25:03 
 * @version 1.0.0
 * 
 */
public interface BlogIndexDao {

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageList
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-上午12:00:36 
	 * 手机:17673111810
	 * @param map
	 * @return List<Page>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Page> getPageList(Map<String, Integer> map);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageNo
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-上午12:28:08 
	 * 手机:17673111810
	 * @param i
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getPageNo(int labelId);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLabelList
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-上午12:44:19 
	 * 手机:17673111810
	 * @param sortId
	 * @return List<Label>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Label> getLabelList(int sortId);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLPageList
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-上午1:09:30 
	 * 手机:17673111810
	 * @param id
	 * @return List<Page>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Page> getLPageList(Integer id);
	
}
