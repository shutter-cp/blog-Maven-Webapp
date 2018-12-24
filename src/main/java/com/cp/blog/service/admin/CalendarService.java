/**
 * chenPeng
 * com.cp.blog.service.admin
 * CalendarService.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午10:13:44 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.service.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.blog.bean.Calendar;
import com.cp.blog.dao.admin.CalendarDao;

/**
 * 
 * CalendarService
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午10:13:44 
 * @version 1.0.0
 * 
 */
@Service
public class CalendarService {
	@Autowired
	private CalendarDao calendarDao;
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：add
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午2:02:20 
	 * 手机:17673111810
	 * @param id
	 * @param title
	 * @param start
	 * @param end
	 * @return String
	 * @exception 
	 * @since  1.0.0
	*/
	public String add(String id, String title, String start, String end) {
		// TODO Auto-generated method stub
		Calendar calendar = new Calendar();
		
		int r = (int) (Math.random()*255);
		int g = (int) (Math.random()*255);
		int b = (int) (Math.random()*255);
		
		calendar.setId(id);
		calendar.setTitle(title);
		/*calendar.setStart(cpDate.getTimeFormat("yyyy-MM-dd HH:mm", Long.parseLong(start)));
		calendar.setEnd(cpDate.getTimeFormat("yyyy-MM-dd HH:mm", Long.parseLong(end)));*/
		calendar.setStart(Long.parseLong(start));
		calendar.setEnd(Long.parseLong(end));
		calendar.setColor("RGB("+r+","+g+","+b+")");
		
		try {
			System.out.println(calendar.getTitle()+calendar.getId());
			calendarDao.add(calendar);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "error";
			// TODO: handle exception
		}
		return "success";
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getMsg
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午3:01:21 
	 * 手机:17673111810
	 * @param start
	 * @param end
	 * @return List<Calendar>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Calendar> getMsg() {
		// TODO Auto-generated method stub
		try {
			return calendarDao.getMsg();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			re.getSession().setAttribute("errorMsg", "读取日历失败！请重试！");
			return null;
		}
	}

	/**
	 * 删除
	 * 方法名：delete
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午5:04:50 
	 * 手机:17673111810
	 * @param dateId void
	 * @exception 
	 * @since  1.0.0
	*/
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		try {
			calendarDao.delete(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			re.getSession().setAttribute("errorMsg", "删除失败！");
			return false;
		}
	}

	/**
	 * 修改
	 * 方法名：upData
	 * 创建人：chenPeng
	 * 时间：2018年12月23日-下午5:12:29 
	 * 手机:17673111810
	 * @param dateId
	 * @param title
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	*/
	public boolean upData(String id, String title) {
		// TODO Auto-generated method stub
		Calendar calendar = new Calendar();
		try {
			calendar.setId(id);
			calendar.setTitle(title);
			calendarDao.upData(calendar);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			re.getSession().setAttribute("errorMsg", "删除失败！");
			return false;
		}
	}

}
