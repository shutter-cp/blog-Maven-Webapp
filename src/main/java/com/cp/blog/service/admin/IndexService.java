/**
 * chenPeng
 * com.cp.blog.service
 * AdminIndexService.java
 * 创建人:chenpeng
 * 时间：2018年12月21日-下午9:52:23 
 * 2018陈鹏-版权所有
 */
package com.cp.blog.service.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.blog.bean.Page;
import com.cp.blog.core.CpDate;
import com.cp.blog.dao.admin.IndexDao;

/**
 * 
 * AdminIndexService
 * 创建人:chenPeng
 * 时间：2018年12月21日-下午9:52:23 
 * @version 1.0.0
 * 
 */
@Service
public class IndexService {
	@Autowired
	private IndexDao indexDao;

	/**
	 * 得到本月博客量
	 * 方法名：getBlogWrite
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午1:51:55 
	 * 手机:17673111810
	 * @param month 
	 * @param month2 
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getBlogWrite(Integer year, Integer month) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("year", year);
		map.put("month", month);
		return indexDao.getBlogWrite(map);
	}

	/**
	 * //得到上月博客量
	 * 方法名：getBlogWriteL
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午1:52:05 
	 * 手机:17673111810
	 * @param month 
	 * @param month2 
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getBlogWriteL(Integer year, Integer month) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("year", year);
		map.put("month", month-1);
		return indexDao.getBlogWrite(map);
	}

	/**
	 * //得到本月访问量
	 * 方法名：getBlogRead
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午1:52:18 
	 * 手机:17673111810
	 * @param month 
	 * @param month2 
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getBlogRead(Integer year, Integer month) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("year", year);
		map.put("month", month);
		return indexDao.getBlogRead(map);
	}

	/**
	 * 得到上月访问量
	 * 方法名：getBlogReadL
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午1:52:27 
	 * 手机:17673111810
	 * @param month 
	 * @param month2 
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getBlogReadL(Integer year, Integer month) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("year", year);
		map.put("month", month-1);
		return indexDao.getBlogRead(map);
	}

	/**
	 * 得到本月评论量
	 * 方法名：getBlogCom
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午1:52:34 
	 * 手机:17673111810
	 * @param month 
	 * @param month2 
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getBlogCom(Integer year, Integer month) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("year", year);
		map.put("month", month);
		return indexDao.getBlogCom(map);
	}

	/**
	 * 得到上月评论量
	 * 方法名：getBlogComL
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午1:52:43 
	 * 手机:17673111810
	 * @param month 
	 * @param month2 
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getBlogComL(Integer year, Integer month) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("year", year);
		map.put("month", month-1);
		return indexDao.getBlogCom(map);
	}

	/**
	 * 得到上周每天书写博客的字数
	 * 方法名：getBlogRWord
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午1:52:53 
	 * 手机:17673111810
	 * @param day 
	 * @param week 
	 * @param year 
	 * @param begainYear 
	 * @param begainDay 
	 * @param year 
	 * @param day 
	 * @param week 
	 * @return List<Integer>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Integer> getBlogRWord(Integer year, String week, Integer day) {
		// TODO Auto-generated method stub
		CpDate cpDate = new CpDate();
		Integer weekInt = cpDate.getWeekNub(week);
		weekInt = -(weekInt+6);
		
		Map<String, Integer> map;
	
		List<Integer> sumNubList = new ArrayList<Integer>();
		for (int i = 0; i < 7; i++) {
			Integer begainDay = Integer.parseInt(cpDate.changeTime(weekInt, "dd"));
			Integer begainYear = Integer.parseInt(cpDate.changeTime(weekInt, "yy"));
			map = new HashMap<String, Integer>();
			map.put("begainDay", begainDay);
			map.put("begainYear", begainYear);
			Integer sumNub = indexDao.getSumNub(map) ;
			if (sumNub == null) {
				sumNubList.add(0);
			}else{
				sumNubList.add(sumNub);
			}
			weekInt+=1;
		}
		
		return sumNubList;
	}

	/**
	 * 统计全部的博客时间 分为4组 求比例
	 * 方法名：getBlogRScale
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午1:53:04 
	 * 手机:17673111810
	 * @return List<Integer>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Integer> getBlogRScale() {
		// TODO Auto-generated method stub
		List<Map<String, Integer>> time = new ArrayList<>();
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("begainDay", 0);
		map1.put("endDay", 6);
		time.add(map1);
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("begainDay", 6);
		map2.put("endDay", 12);
		time.add(map2);
		Map<String, Integer> map3 = new HashMap<String, Integer>();
		map3.put("begainDay", 12);
		map3.put("endDay", 18);
		time.add(map3);
		Map<String, Integer> map4 = new HashMap<String, Integer>();
		map4.put("begainDay", 18);
		map4.put("endDay", 24);
		time.add(map4);
		
		List<Integer> blogRScale = new ArrayList<>();
		Integer sum = 0;
		
		for (Map<String, Integer> map : time) {
			Integer rScale = indexDao.getWriteTime(map);
			blogRScale.add(rScale);
			sum+=rScale;
		}
		
		if (sum>0) {
			for (int i = 0; i < 4; i++) {
				blogRScale.set(i, (int) (((blogRScale.get(i)+0.0)/sum)*100));
			}
		}
		
		return blogRScale;
	}
	
	/**
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getNub
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午4:53:20 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	*/
	public Integer getNub() {
		CpDate cpDate = new CpDate();
		Integer begainDay = Integer.parseInt(cpDate.changeTime(-30, "yyMMdd"));
		Integer endDay = Integer.parseInt(cpDate.getTimeFormat("yyMMdd"));
		
		Map<String, Integer> map = new HashMap<>();
		map.put("begainDay", begainDay);
		map.put("endDay", endDay);
		return indexDao.getNub(map);
	}

	/**
	 * 得到最新的几篇文章 课查看文章字数以及浏览量
	 * 方法名：getPageList
	 * 创建人：chenPeng
	 * 时间：2018年12月24日-下午1:53:17 
	 * 手机:17673111810
	 * @return List<Page>
	 * @exception 
	 * @since  1.0.0
	*/
	public List<Page> getPageList() {
		// TODO Auto-generated method stub
		return indexDao.getPageList();
	}

	
}
