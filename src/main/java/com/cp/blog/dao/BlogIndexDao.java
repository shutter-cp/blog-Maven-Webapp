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

import com.cp.blog.bean.Comment;
import com.cp.blog.bean.Label;
import com.cp.blog.bean.Logs;
import com.cp.blog.bean.Page;
import com.cp.blog.bean.User;
import com.cp.blog.bean.my.IndexCom;

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

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPage
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午3:12:39 
	 * 手机:17673111810
	 * @param pageId
	 * @return Page
	 * @exception 
	 * @since  1.0.0
	*/
	Page getPage(Integer pageId);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getComList
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午3:14:30 
	 * 手机:17673111810
	 * @param pageId
	 * @return List<Comment>
	 * @exception 
	 * @since  1.0.0
	*/
	List<IndexCom> getComList(Integer pageId);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLabelLists
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午5:22:30 
	 * 手机:17673111810
	 * @return List<Label>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Label> getLabelLists();

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageLists
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午5:32:41 
	 * 手机:17673111810
	 * @param no
	 * @return List<Page>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Page> getPageLists(Integer no);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageNos
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午5:35:21 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	Integer getPageNos();

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：login
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午6:21:18 
	 * 手机:17673111810
	 * @param user
	 * @return User
	 * @exception 
	 * @since  1.0.0
	*/
	User login(User user);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：add
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午6:38:59 
	 * 手机:17673111810
	 * @param user void
	 * @exception 
	 * @since  1.0.0
	*/
	void add(User user);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：addCom
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午6:50:01 
	 * 手机:17673111810
	 * @param comment void
	 * @exception 
	 * @since  1.0.0
	*/
	void addCom(Comment comment);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageListFond
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午11:35:34 
	 * 手机:17673111810
	 * @param string
	 * @return List<Page>
	 * @exception 
	 * @since  1.0.0
	*/
	List<Page> getPageListFond(String string);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：addVersion
	 * 创建人：chenPeng
	 * 时间：2018年12月26日-上午12:40:30 
	 * 手机:17673111810
	 * @param logs void
	 * @exception 
	 * @since  1.0.0
	*/
	void addVersion(Logs logs);

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：addViewNub
	 * 创建人：chenPeng
	 * 时间：2018年12月26日-上午2:27:02 
	 * 手机:17673111810
	 * @param pageId void
	 * @exception 
	 * @since  1.0.0
	*/
	void addViewNub(Integer pageId);
	
}
