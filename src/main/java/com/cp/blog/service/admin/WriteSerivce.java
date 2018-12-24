/**
 * chenPeng
 * com.cp.blog.service.admin
 * WriteSerivce.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午10:15:08 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.blog.bean.Label;
import com.cp.blog.bean.Page;
import com.cp.blog.bean.Sort;
import com.cp.blog.dao.admin.WriteDao;

/**
 * 
 * WriteSerivce
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午10:15:08 
 * @version 1.0.0
 * 
 */
@Service
public class WriteSerivce {
	@Autowired
	private WriteDao writeDao;
	
	/**
	 * 拿到页面
	 * 方法名：getSortList
	 * 创建人：chenPeng
	 * 时间：2018年12月21日-下午11:32:58 
	 * 手机:17673111810
	 * @return List<Sort>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Sort> getSortList() {
		// TODO Auto-generated method stub
		return writeDao.getSortList();
	}

	/**
	 * 查询出标签
	 * 方法名：getLabel
	 * 创建人：chenPeng
	 * 时间：2018年12月22日-上午12:00:39 
	 * 手机:17673111810
	 * @param sortId
	 * @return List<Label>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Label> getLabel(Integer sortId) {
		// TODO Auto-generated method stub
		return writeDao.getLabel(sortId);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：addLabel
	 * 创建人：chenPeng
	 * 时间：2018年12月22日-上午12:13:31 
	 * 手机:17673111810
	 * @param sortId
	 * @param labelId void
	 * @exception 
	 * @since  1.0.0
	*/
	public void addLabel(Integer sortId, String labelName) {
		// TODO Auto-generated method stub
		Label label = new Label();
		label.setSortId(sortId);
		label.setName(labelName);
		writeDao.addLabel(label);
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：writeDo
	 * 创建人：chenPeng
	 * 时间：2018年12月22日-上午1:10:33 
	 * 手机:17673111810
	 * @param title
	 * @param author
	 * @param time
	 * @param labelId
	 * @param texts void
	 * @param nub 
	 * @exception 
	 * @since  1.0.0
	*/
	public void writeDo(String title, String author, String time, Integer labelId, String texts, Integer nub) {
		// TODO Auto-generated method stub
		Page page = new Page();
		page.setTitle(title);
		page.setTime(time);
		page.setAuthor(author);
		page.setLabelId(labelId);
		page.setMainText(texts);
		page.setTextNumber(nub);
		
		writeDao.writeDo(page);
	}

}
