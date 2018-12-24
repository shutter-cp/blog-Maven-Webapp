/**
 * chenPeng
 * com.cp.blog.dao
 * AdminIndexDao.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午9:52:31 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.dao.admin;

import java.util.List;
import java.util.Map;

import com.cp.blog.bean.Page;

/**
 * 
 * AdminIndexDao
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午9:52:31 
 * @version 1.0.0
 * 
 */
public interface IndexDao {

	/**
	 * 得到博客量
	 * 方法名：getBlogWrite
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午2:37:26 
	 * 手机:17673111810
	 * @param map
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getBlogWrite(Map<String, Integer> map);

	/**
	 * 得访问量
	 * 方法名：getBlogRead
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午2:44:57 
	 * 手机:17673111810
	 * @param map
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getBlogRead(Map<String, Integer> map);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getBlogCom
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午2:47:37 
	 * 手机:17673111810
	 * @param map
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getBlogCom(Map<String, Integer> map);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getSumNub
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午3:30:58 
	 * 手机:17673111810
	 * @param map
	 * @return List<Integer>
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getSumNub(Map<String, Integer> map);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getWriteTime
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午4:10:06 
	 * 手机:17673111810
	 * @param hashMap
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getWriteTime(Map<String, Integer> map);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getNub
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午4:56:20 
	 * 手机:17673111810
	 * @param map
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getNub(Map<String, Integer> map);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageList
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午5:08:33 
	 * 手机:17673111810
	 * @return List<Page>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Page> getPageList();
	
}
