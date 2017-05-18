package com.comingo.service.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.logging.impl.AvalonLogger;
import org.springframework.stereotype.Service;

import com.comingo.dao.ActCommentDao;
import com.comingo.dao.ActLikeDao;
import com.comingo.dao.ActivityDao;
import com.comingo.dao.ParticipantDao;
import com.comingo.dao.UserInfoDao;
import com.comingo.domain.ActComment;
import com.comingo.domain.ActLike;
import com.comingo.domain.Activity;
import com.comingo.domain.ActivityVo;
import com.comingo.domain.Participant;
import com.comingo.domain.UserInfo;
import com.comingo.exception.MySQLException;
import com.comingo.pagination.Page;
import com.comingo.service.ActivityService;
import com.comingo.util.TimeToStringUtil;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Resource
	ActivityDao activityDao;
	@Resource
	ActCommentDao actCommentDao;
	@Resource 
	ActLikeDao actLikeDao;
	@Resource
	ParticipantDao participantDao;
	@Resource
	UserInfoDao userInfoDao;
	
	
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
		activity.setPublishTime(new Date());
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
		map.put("keyword", "%"+keyword+"%");
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
	/**
	 * 将actId和userId相关联
	 */
	public void insertParticipant(String actId,String userId)
			throws MySQLException {
		Participant participant = new Participant();
		participant.setActId(actId);
		participant.setUserId(userId);
		participant.setParticipateTime(new Date());
		participantDao.insertParticipant(participant);
	}

	public ActLike findActLike(String actId, String userId){
		Map map = new HashMap();
		map.put("actId", actId);
		map.put("userId", userId);
		return actLikeDao.findActLike(map);
	}

	public Participant findParticipate(String actId, String userId) {
		Map map = new HashMap();
		map.put("actId", actId);
		map.put("userId", userId);
		return participantDao.findParticipate(map);
	}


	public List<Activity> findActScheduleList(String userId) throws MySQLException {
		Map map = new HashMap();
		Date todayDate = new Date();
		String todayDateStr = TimeToStringUtil.timeToString(todayDate);
		map.put("todayDateStr", todayDateStr);
		map.put("userId", userId);
		return activityDao.findActScheduleList(map);
	}

	public List<Activity> findActByUserId(String userId) {
		return activityDao.findActByUserId(userId);
	}

	public List<ActivityVo> findActList() {
		List<ActivityVo> activityVos = new ArrayList<ActivityVo>();
		List<Activity> list = activityDao.find(null);
		UserInfo userInfo = new UserInfo();
		
		for(Activity activity : list){
			ActivityVo activityVo = new ActivityVo();
			userInfo = userInfoDao.findUserById(activity.getUserId());
			String publishUsername = userInfo.getUsername();
			String actId = activity.getActId();
			String userId = activity.getUserId();
			Date actBeginTime = activity.getActBeginTime();
			Date actEndTime = activity.getActEndTime();
			Date applyDateLine = activity.getApplyDateLine();
			String actTitle = activity.getActTitle();
			String actPic = activity.getActPic();
			double actLongitude = activity.getActLongitude();
			double actLatitude  = activity.getActLatitude();
			String actLocation = activity.getActLocation();
			
			activityVo.setUserId(userId);
			activityVo.setActId(actId);
			activityVo.setActBeginTime(actBeginTime);
			activityVo.setActEndTime(actEndTime);
			activityVo.setApplyDateLine(applyDateLine);
			activityVo.setActTitle(actTitle);
			activityVo.setActPic(actPic);
			activityVo.setActLocation(actLocation);
			activityVo.setActLatitude(actLatitude);
			activityVo.setActLongitude(actLongitude);
			activityVo.setPublishUsername(publishUsername);
			
			activityVos.add(activityVo);
		}
		return activityVos;
	}
}
