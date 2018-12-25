/**
 * chenPeng
 * com.cp.blog.dao.admin
 * ChartDao.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午10:16:12 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.dao.admin;

import java.util.List;
import java.util.Map;

import com.cp.blog.bean.Logs;

/**
 * 
 * ChartDao
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午10:16:12 
 * @version 1.0.0
 * 
 */
public interface ChartDao {

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getDateList
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午9:02:23 
	 * 手机:17673111810
	 * @param map
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getDateList(Map<String, Integer> map);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getView
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午10:06:06 
	 * 手机:17673111810
	 * @param i
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getView(Integer i);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getCom
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午10:08:09 
	 * 手机:17673111810
	 * @param i
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getCom(Integer i);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getWirte
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午10:08:38 
	 * 手机:17673111810
	 * @param i
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getWirte(Integer i);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLogsList
	 * 创建人：chenPeng
	 * 时间：2018年12月26日-上午12:55:30 
	 * 手机:17673111810
	 * @return List<Logs>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Logs> getLogsList();
	
}
