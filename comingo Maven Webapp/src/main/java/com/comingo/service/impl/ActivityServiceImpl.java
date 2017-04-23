package com.comingo.service.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comingo.dao.ActCommentDao;
import com.comingo.dao.ActLikeDao;
import com.comingo.dao.ActivityDao;
import com.comingo.dao.OrgInfoDao;
import com.comingo.dao.UserInfoDao;
import com.comingo.domain.Activity;
import com.comingo.domain.OrgInfo;
import com.comingo.domain.Test;
import com.comingo.domain.UserInfo;
import com.comingo.exception.LoginFailedException;
import com.comingo.exception.MySQLException;
import com.comingo.pagination.Page;
import com.comingo.service.ActivityService;
import com.comingo.service.OrgInfoService;
import com.comingo.util.MD5Util;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Resource
	ActivityDao activityDao;
	@Resource
	ActCommentDao actCommentDao;
	@Resource 
	ActLikeDao actLikeDao;
	
	
	public List<Activity> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 查找所有的活动
	 */
	public List<Activity> find(Map paraMap) {
		return activityDao.find(paraMap);
	}
	/**
	 * 根据活动id查找活动
	 */
	public Activity get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 添加新的活动
	 */
	public void insertActivity(Activity activity) throws MySQLException{
		activity.setActId(UUID.randomUUID().toString());
		activity.setUserId(activity.getUserId());
		activity.setActBeginTime(activity.getActBeginTime());
		activity.setActEndTime(activity.getActEndTime());
		activity.setApplyDateLine(activity.getApplyDateLine());
		activity.setActLabel(activity.getActLabel());
		activity.setActTitle(activity.getActTitle());
		activity.setActDesc(activity.getActDesc());
		activity.setActPic(activity.getActPic());
		activity.setActLongitude(activity.getActLongitude());
		activity.setActLatitude(activity.getActLatitude());
		activity.setPublishTime(activity.getPublishTime());
		activity.setContactName(activity.getContactName());
		activity.setContactTel(activity.getContactTel());
		
		activityDao.insertActivity(activity);
	}
	/**
	 * 更新活动信息
	 */
	public void update(Activity activity) {
		activityDao.update(activity);
	}
	/**
	 * 根据活动id删除活动
	 */
	public void deleteById(Serializable id) throws MySQLException {
		activityDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
	}
	

	
}
