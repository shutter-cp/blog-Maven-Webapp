/**
 * chenPeng
 * com.cp.blog.dao.admin
 * TablesDao.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午10:13:12 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.dao.admin;

import java.util.List;

import com.cp.blog.bean.Comment;
import com.cp.blog.bean.Page;
import com.cp.blog.bean.User;
import com.cp.blog.bean.my.AdminComm;
import com.cp.blog.bean.my.UpDateWrite;

/**
 * 
 * TablesDao
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午10:13:12 
 * @version 1.0.0
 * 
 */
public interface TablesDao {

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getUserList
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午6:18:09 
	 * 手机:17673111810
	 * @return List<User>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<User> getUserList(Integer no);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getUserNub
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午6:19:06 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getUserNub();

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getComList
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午6:19:12 
	 * 手机:17673111810
	 * @return List<Comment>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<AdminComm> getComList(Integer no);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getComNub
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午6:19:20 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getComNub();

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageList
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午6:19:25 
	 * 手机:17673111810
	 * @param i 
	 * @return List<Page>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Page> getPageList(Integer no);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageNub
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午6:19:30 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getPageNub();

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：userUp
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:16:40 
	 * 手机:17673111810
	 * @param user void
	 * @exception 
	 * @since  1.0.0
	*/
	public void userUp(User user);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：userDelete
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:27:39 
	 * 手机:17673111810
	 * @param id void
	 * @exception 
	 * @since  1.0.0
	*/
	public void userDelete(Integer id);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：commUp
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:37:56 
	 * 手机:17673111810
	 * @param comment void
	 * @exception 
	 * @since  1.0.0
	*/
	public void commUp(Comment comment);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：commDelete
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:38:11 
	 * 手机:17673111810
	 * @param id void
	 * @exception 
	 * @since  1.0.0
	*/
	public void commDelete(Integer id);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：pageUp
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:43:19 
	 * 手机:17673111810
	 * @param page void
	 * @exception 
	 * @since  1.0.0
	*/
	public void pageUp(Page page);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：pageDelete
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:43:24 
	 * 手机:17673111810
	 * @param id void
	 * @exception 
	 * @since  1.0.0
	*/
	public void pageDelete(Integer id);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：reTextSubmt
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-上午12:15:46 
	 * 手机:17673111810
	 * @param comment void
	 * @exception 
	 * @since  1.0.0
	*/
	public void reTextSubmt(Comment comment);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPage
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-上午1:40:06 
	 * 手机:17673111810
	 * @param id
	 * @return Page
	 * @exception 
	 * @since  1.0.0
	*/
	public UpDateWrite getPage(Integer id);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：upDateDo
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-上午2:13:55 
	 * 手机:17673111810
	 * @param page void
	 * @exception 
	 * @since  1.0.0
	*/
	public void upDateDo(Page page);
	
	

}
