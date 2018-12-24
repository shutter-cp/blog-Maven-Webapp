/**
 * chenPeng
 * com.cp.blog.dao.admin
 * WriteDao.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午10:15:17 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.dao.admin;

import java.util.List;

import com.cp.blog.bean.Label;
import com.cp.blog.bean.Page;
import com.cp.blog.bean.Sort;

/**
 * 
 * WriteDao
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午10:15:17 
 * @version 1.0.0
 * 
 */
public interface WriteDao {

	/**
	 * 拿到页面
	 * 方法名：getSortList
	 * 创建人：chenPeng
	 * 时间：2018年12月21日-下午11:34:16 
	 * 手机:17673111810
	 * @return List<Sort>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Sort> getSortList();

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLabel
	 * 创建人：chenPeng
	 * 时间：2018年12月22日-上午12:00:57 
	 * 手机:17673111810
	 * @param sortId
	 * @return List<Label>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Label> getLabel(Integer sortId);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：addLabel
	 * 创建人：chenPeng
	 * 时间：2018年12月22日-上午12:15:15 
	 * 手机:17673111810
	 * @param label void
	 * @exception 
	 * @since  1.0.0
	*/
	public void addLabel(Label label);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：writeDo
	 * 创建人：chenPeng
	 * 时间：2018年12月22日-上午1:40:53 
	 * 手机:17673111810
	 * @param page void
	 * @exception 
	 * @since  1.0.0
	*/
	public void writeDo(Page page);

}
