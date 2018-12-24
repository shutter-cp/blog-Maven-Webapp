/**
 * chenPeng
 * com.cp.blog.dao.admin
 * CalendarDao.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午10:13:33 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.dao.admin;

import java.util.List;

import com.cp.blog.bean.Calendar;

/**
 * 日历
 * CalendarDao
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午10:13:33 
 * @version 1.0.0
 * 
 */
public interface CalendarDao {

	/**
	 * 添加
	 * 方法名：add
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午2:12:17 
	 * 手机:17673111810
	 * @param calendar void
	 * @exception 
	 * @since  1.0.0
	*/
	public void add(Calendar calendar);

	/**
	 * 查询出全部的
	 * 方法名：getMsg
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午3:09:47 
	 * 手机:17673111810
	 * @param times
	 * @return List<Calendar>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Calendar> getMsg();

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：delete
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午5:08:07 
	 * 手机:17673111810
	 * @param dateId void
	 * @exception 
	 * @since  1.0.0
	*/
	public void delete(String id);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：upData
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午5:13:41 
	 * 手机:17673111810
	 * @param calendar void
	 * @exception 
	 * @since  1.0.0
	*/
	public void upData(Calendar calendar);

}
