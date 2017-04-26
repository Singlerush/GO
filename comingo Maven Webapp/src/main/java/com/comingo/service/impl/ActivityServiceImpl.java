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
import com.comingo.domain.ActComment;
import com.comingo.domain.ActLike;
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
		return activityDao.get(id);
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
		activity.setActLocation(activity.getActLocation());
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
	/**
	 * 根据活动id查询对应点赞数
	 */
	public int findActLikeCountByActId(Serializable id){
		return actLikeDao.findActLikeCountByActId(id);
	}
	/**
	 * 根据活动id查询对应评论数
	 */
	public int findActCommentCountByActId(Serializable id){
		return actCommentDao.findActCommentCountByActId(id);
	}
	public void delete(Serializable[] ids) {
		
	}
	/**
	 * 查询活动列表
	 */
	public List<Activity> findActList(String userId) throws MySQLException {
		return activityDao.findActList(userId);
	}
	/**
	 * 通过关键字查询活动列表
	 */
	public List<Activity> findActByKeyword(String userId,String keyword) throws MySQLException {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("keyword", keyword);
		return activityDao.findActByKeyword(map);
	}
	/**
	 * 添加活动点赞
	 */
	public void insertActLike(String actId, String userId) throws MySQLException{
		ActLike actLike = new ActLike();
		Date actLikeCreateTime = new Date();
		actLike.setActId(actId);
		actLike.setUserId(userId);
		actLike.setActLikeCreateTime(actLikeCreateTime);
		actLikeDao.insertActLike(actLike);
	}
	/**
	 * 添加活动评论
	 */
	public void insertActComment(String actId, String userId, String actCommentDesc)
			throws MySQLException {
		ActComment actComment = new ActComment();
		actComment.setActId(actId);
		actComment.setUserId(userId);
		actComment.setActCommentCreateTime(new Date());
		actComment.setActCommentDesc(actCommentDesc);
		actCommentDao.insertActComment(actComment);
	}
	/**
	 * 查找活动评论
	 */
	public List<ActComment> findActCommentDesc(String actId)
			throws MySQLException {
		return actCommentDao.findActCommentDesc(actId);
	}
	
}
