/**
 * chenPeng
 * com.cp.blog.service.admin
 * TablesService.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午10:13:04 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.blog.bean.Comment;
import com.cp.blog.bean.Page;
import com.cp.blog.bean.User;
import com.cp.blog.bean.my.AdminComm;
import com.cp.blog.bean.my.UpDateWrite;
import com.cp.blog.dao.admin.TablesDao;

/**
 * 
 * TablesService
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午10:13:04 
 * @version 1.0.0
 * 
 */
@Service
public class TablesService {
	@Autowired
	private TablesDao tablesDao;
	
	/**
	 * 得到全部的用户
	 * 方法名：getUserList
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午6:13:58 
	 * 手机:17673111810
	 * @return List<User>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<User> getUserList(Integer no) {
		// TODO Auto-generated method stub
		return tablesDao.getUserList(no*10);
	}

	/**
	 * 得到用户数量
	 * 方法名：getUserNub
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午6:14:13 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getUserNub() {
		// TODO Auto-generated method stub
		return tablesDao.getUserNub();
	}

	/**
	 * (得到全部的评论
	 * 方法名：getComList
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午6:14:42 
	 * 手机:17673111810
	 * @return List<Comment>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<AdminComm> getComList(Integer no) {
		// TODO Auto-generated method stub
		return tablesDao.getComList(no*10);
	}

	/**
	 * 得到评论数量
	 * 方法名：getComNub
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午6:14:53 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getComNub() {
		// TODO Auto-generated method stub
		return tablesDao.getComNub();
	}

	/**
	 * 得到全部的文章
	 * 方法名：getPageList
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午6:15:12 
	 * 手机:17673111810
	 * @return List<Page>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Page> getPageList(Integer no) {
		// TODO Auto-generated method stub
		return tablesDao.getPageList(no*10);
	}

	/**
	 * 得到文章数量
	 * 方法名：getPageNub
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午6:15:27 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getPageNub() {
		// TODO Auto-generated method stub
		return tablesDao.getPageNub();
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：userUp
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:14:54 
	 * 手机:17673111810
	 * @param id
	 * @param state void
	 * @exception 
	 * @since  1.0.0
	*/
	public void userUp(Integer id, Integer state) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setStatus((state==1)? 0:1);
		user.setId(id);
		
		tablesDao.userUp(user);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：userDelete
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:25:50 
	 * 手机:17673111810
	 * @param id void
	 * @exception 
	 * @since  1.0.0
	*/
	public void userDelete(Integer id) {
		// TODO Auto-generated method stub
		tablesDao.userDelete(id);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：commUp
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:37:06 
	 * 手机:17673111810
	 * @param id
	 * @param state void
	 * @exception 
	 * @since  1.0.0
	*/
	public void commUp(Integer id, Integer state) {
		// TODO Auto-generated method stub
		Comment comment = new Comment();
		comment.setStatus((state==1)? 0:1);
		comment.setId(id);
		
		tablesDao.commUp(comment);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：commDelete
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:37:12 
	 * 手机:17673111810
	 * @param id void
	 * @exception 
	 * @since  1.0.0
	*/
	public void commDelete(Integer id) {
		// TODO Auto-generated method stub
		tablesDao.commDelete(id);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：pageUp
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:42:29 
	 * 手机:17673111810
	 * @param id
	 * @param state void
	 * @exception 
	 * @since  1.0.0
	*/
	public void pageUp(Integer id, Integer state) {
		// TODO Auto-generated method stub
		Page page = new Page();
		page.setStatus((state==1)? 0:1);
		page.setId(id);
		
		tablesDao.pageUp(page);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：pageDelete
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午11:42:33 
	 * 手机:17673111810
	 * @param id void
	 * @exception 
	 * @since  1.0.0
	*/
	public void pageDelete(Integer id) {
		// TODO Auto-generated method stub
		tablesDao.pageDelete(id);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：reTextSubmt
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-上午12:15:11 
	 * 手机:17673111810
	 * @param id
	 * @param reText void
	 * @exception 
	 * @since  1.0.0
	*/
	public void reTextSubmt(Integer id, String reText) {
		// TODO Auto-generated method stub
		Comment comment = new Comment();
		comment.setId(id);
		comment.setReText(reText);
		
		tablesDao.reTextSubmt(comment);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPage
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-上午1:39:45 
	 * 手机:17673111810
	 * @param id
	 * @return Page
	 * @exception 
	 * @since  1.0.0
	*/
	public UpDateWrite getPage(Integer id) {
		// TODO Auto-generated method stub
		return tablesDao.getPage(id);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：upDateDo
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-上午2:13:01 
	 * 手机:17673111810
	 * @param title
	 * @param author
	 * @param time
	 * @param labelId
	 * @param texts
	 * @param nub
	 * @param id void
	 * @exception 
	 * @since  1.0.0
	*/
	public void upDateDo(String title, String author, String time, Integer labelId, String texts, Integer nub,
			Integer id) {
		// TODO Auto-generated method stub
		Page page = new Page();
		page.setTitle(title);
		page.setTime(time);
		page.setAuthor(author);
		page.setLabelId(labelId);
		page.setMainText(texts);
		page.setTextNumber(nub);
		page.setId(id);
		
		tablesDao.upDateDo(page);
	}
	

}
