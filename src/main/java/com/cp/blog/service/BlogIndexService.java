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

import com.cp.blog.bean.Comment;
import com.cp.blog.bean.Label;
import com.cp.blog.bean.Page;
import com.cp.blog.bean.User;
import com.cp.blog.bean.my.IndexCom;
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

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPage
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午3:12:00 
	 * 手机:17673111810
	 * @param i
	 * @return Page
	 * @exception 
	 * @since  1.0.0
	*/
	public Page getPage(Integer pageId) {
		// TODO Auto-generated method stub
		return blogIndexDao.getPage(pageId);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getCommentList
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午3:13:59 
	 * 手机:17673111810
	 * @param i
	 * @return List<Comment>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<IndexCom> getCommentList(Integer pageId) {
		// TODO Auto-generated method stub
		return blogIndexDao.getComList(pageId);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLabelLists
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午5:22:14 
	 * 手机:17673111810
	 * @return List<Label>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Label> getLabelLists() {
		// TODO Auto-generated method stub
		return blogIndexDao.getLabelLists();
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageLists
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午5:31:06 
	 * 手机:17673111810
	 * @param i
	 * @return List<Page>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Page> getPageLists(Integer no) {
		// TODO Auto-generated method stub
		no = (no-1)*12;
		return  blogIndexDao.getPageLists(no);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageNos
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午5:31:15 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getPageNos() {
		// TODO Auto-generated method stub
		return blogIndexDao.getPageNos();
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：login
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午6:20:05 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return User
	 * @exception 
	 * @since  1.0.0
	*/
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		return blogIndexDao.login(user);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：add
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午6:36:58 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @param email void
	 * @exception 
	 * @since  1.0.0
	*/
	public String add(String username, String password, String email) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		
		try {
			blogIndexDao.add(user);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "注册失败";
		}
		return "success";
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：addCom
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午6:44:20 
	 * 手机:17673111810
	 * @param comMsg
	 * @param userId 
	 * @param pageId 
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	public String addCom(String comMsg, Integer pageId, Integer userId) {
		// TODO Auto-generated method stub
		Comment comment = new Comment();
		comment.setMainText(comMsg);
		comment.setPageId(pageId);
		comment.setUserId(userId);
		
		try {
			blogIndexDao.addCom(comment);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "注册失败";
		}
		return "success";
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getPageListFond
	 * 创建人：chenPeng
	 * 时间：2018年12月25日-下午11:34:04 
	 * 手机:17673111810
	 * @param fondMsg
	 * @return List<Page>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Page> getPageListFond(String fondMsg) {
		// TODO Auto-generated method stub
		return blogIndexDao.getPageListFond("%"+fondMsg+"%");
	}

}
