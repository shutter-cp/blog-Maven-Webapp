/**
 * chenPeng
 * com.cp.blog.service.admin
 * ChartSerivce.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午10:16:04 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.service.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.blog.bean.Logs;
import com.cp.blog.dao.admin.ChartDao;

/**
 * 
 * ChartSerivce
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午10:16:04 
 * @version 1.0.0
 * 
 */
@Service
public class ChartSerivce {
	@Autowired
	private ChartDao chartDao;
	/**
	 * 得到分类阅读数量
	 * 方法名：getDateList
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午6:33:46 
	 * 手机:17673111810
	 * @param string
	 * @return List<Integer>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Integer> getDateList(String string) {
		// TODO Auto-generated method stub
		if (string.equals("photo")) {
			List<Integer> list = new ArrayList<>();
			
			Map<String, Integer> map = null;
			
			for (int i = 0; i <= 6; i++) {
				map = new HashMap<>();
				map.put("sortId", 1);
				map.put("week", i);
				list.add(chartDao.getDateList(map));
			}
			
			return list;
		}else if(string.equals("code")){
			List<Integer> list = new ArrayList<>();
			
			Map<String, Integer> map = null;
			Map<String, Integer> map2 = null;
			for (int i = 0; i <= 6; i++) {
				map = new HashMap<>();
				map.put("sortId", 2);
				map.put("week", i);
				map2 = new HashMap<>();
				map2.put("sortId", 3);
				map2.put("week", i);
				list.add(chartDao.getDateList(map)+chartDao.getDateList(map2));
			}
			return list;
		}else{
			List<Integer> list = new ArrayList<>();
			
			Map<String, Integer> map = null;
			Map<String, Integer> map2 = null;
			for (int i = 0; i <= 6; i++) {
				map = new HashMap<>();
				map.put("sortId", 4);
				map.put("week", i);
				map2 = new HashMap<>();
				map2.put("sortId", 5);
				map2.put("week", i);
				list.add(chartDao.getDateList(map)+chartDao.getDateList(map2));
			}
			return list;
		}
	}
	
	/**
	 * 得到浏览数据
	 * 方法名：getViewList
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午9:52:12 
	 * 手机:17673111810
	 * @return List<Integer>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Integer> getViewList() {
		// TODO Auto-generated method stub
		List<Integer> msgList = new ArrayList<>();
		
		for (int i = 0; i < 12; i++) {
			msgList.add(chartDao.getView(i));
		}
		return msgList;
	}
	
	/**
	 * 得到评论数据
	 * 方法名：getComList
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午9:52:19 
	 * 手机:17673111810
	 * @return List<Integer>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Integer> getComList() {
		// TODO Auto-generated method stub
		List<Integer> comList = new ArrayList<>();
		
		for (int i = 0; i < 12; i++) {
			comList.add(chartDao.getCom(i));
		}
		return comList;
	}
	
	/**
	 * 得到创造数据
	 * 方法名：getWirteList
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午9:52:26 
	 * 手机:17673111810
	 * @return List<Integer>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Integer> getWirteList() {
		// TODO Auto-generated method stub
		List<Integer> wirteList = new ArrayList<>();
		
		for (int i = 0; i < 12; i++) {
			wirteList.add(chartDao.getWirte(i));
		}
		return wirteList;
	}

	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getLogsList
	 * 创建人：chenPeng
	 * 时间：2018年12月26日-上午12:55:16 
	 * 手机:17673111810
	 * @return List<Logs>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Logs> getLogsList() {
		// TODO Auto-generated method stub
		return chartDao.getLogsList();
	}
}
