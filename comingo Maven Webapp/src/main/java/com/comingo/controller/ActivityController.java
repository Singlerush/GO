package com.comingo.controller;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comingo.domain.ActComment;
import com.comingo.domain.Activity;
import com.comingo.domain.StatusCode;
import com.comingo.domain.UserInfo;
import com.comingo.exception.MySQLException;
import com.comingo.exception.ParamsErrorException;
import com.comingo.exception.QueryFailedException;
import com.comingo.service.ActivityService;
import com.comingo.service.UserInfoService;

@Controller
public class ActivityController extends BaseController {
	@Resource
	ActivityService activityService;
	@Resource
	UserInfoService userInfoService;
	
	final private StatusCode successcode = new StatusCode(200, "OK");
	
	
	/**
	 * 查看活动详情
	 * 返回活动详情，点赞数，评论数，用户是否已参与，用户是否已点赞(0：否，1：是)
	 * @param actId, userId
	 * @return activity
	 */
	@RequestMapping(value = "/activity", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject getActivityDetails(String actId, String userId) {
		Activity activity = null;
		int actLikeCount = 0;
		int actCommentCount = 0;
		JSONObject json = new JSONObject();  
		try{
			if(actId==null) throw new ParamsErrorException();
			activity = activityService.get(actId);
			actLikeCount = activityService.findActLikeCountByActId(actId);
			actCommentCount = activityService.findActCommentCountByActId(actId);
//			boolean isActLike = activityService.isActLike(userId);
			if(activity==null) throw new QueryFailedException();
			json.putAll(json.fromObject(successcode));
			json.put("activity",activity);
			json.put("actLikeCount",actLikeCount);
			json.put("actCommentCount",actCommentCount);
			return json;
		}catch(ParamsErrorException e){
			return json.fromObject(e.getSc());
		}catch (QueryFailedException e) {
			return json.fromObject(e.getSc());
		}
	} 
	
	/**
	 * 添加新的活动
	 * @param activity
	 * @return
	 */
	@RequestMapping(value = "/activity", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject addActivity(Activity activity){
		JSONObject json = new JSONObject();  
		try{
			activityService.insertActivity(activity);
			json.putAll(json.fromObject(successcode));
			return json;
		}catch(MySQLException sqle){
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}
	
	/**
	 * 获取活动列表
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/activityList", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject getActivityList(String userId){
		JSONObject json = new JSONObject();  
		try{
			List<Activity> actList = activityService.findActList(userId);
			json.putAll(json.fromObject(successcode));
			json.put("actList", actList);
			return json;
		}catch(MySQLException sqle){
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}
	
	
	/**
	 * 按关键词查询活动
	 * @param userId，keyword
	 * @return
	 */
	@RequestMapping(value = "/activityList", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject getActListByKeyword(String userId, String keyword){
		JSONObject json = new JSONObject();  
		try{
			List<Activity> actList= activityService.findActByKeyword(userId,keyword);
			System.out.println(actList.size());
			json.putAll(json.fromObject(successcode));
			json.put("actList", actList);
			return json;
		}catch(MySQLException sqle){
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}
	
	/**
	 * 参加活动
	 * @param actId, userId
	 * @return
	 */
	@RequestMapping(value = "/activityparticipate", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject insertParticipant(String actId, String userId){
		JSONObject json = new JSONObject();  
		try{
			activityService.insertParticipant(actId,userId);
			json.putAll(json.fromObject(successcode));
			return json;
		}catch(MySQLException sqle){
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}
	
	/**
	 * 活动点赞
	 * @param actId, userId
	 * @return
	 */
	@RequestMapping(value = "/activitylike", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject addActLike(String actId, String userId){
		JSONObject json = new JSONObject();  
		try{
			activityService.insertActLike(actId,userId);
			json.putAll(json.fromObject(successcode));
			return json;
		}catch(MySQLException sqle){
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}

	/**
	 * 评论活动
	 * @param actId, userId, comment
	 * @return
	 */
	@RequestMapping(value = "/activitycomment", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject addActComment(String actId, String userId, String actCommentDesc){
		JSONObject json = new JSONObject();  
		try{
			activityService.insertActComment(actId,userId,actCommentDesc);
			json.putAll(json.fromObject(successcode));
			return json;
		}catch(MySQLException sqle){
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}
	
	/**
	 * 查看活动评论(内容,日期，头像)
	 * @param actId
	 * @return
	 */
	@RequestMapping(value = "/activitycomment", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject showActCommentDesc(String actId,String userId){
		JSONObject json = new JSONObject();
		UserInfo userInfo = userInfoService.get(userId);
		Map actCommentMap = new HashMap();
		Map actCommentDetail = new HashMap();
		try{
			
			List<ActComment> actCommentList = activityService.findActCommentDesc(actId);
			for(int i=0 ; i<actCommentList.size(); i++){
				actCommentDetail.put("actCommentDesc", actCommentList.get(i).getActCommentDesc());
				actCommentDetail.put("actCommentCreateTime",actCommentList.get(i).getActCommentCreateTime().toLocaleString());
				actCommentDetail.put("userInfoImg", userInfo.getProfilePic());
				actCommentMap.put("actCommentDetai_"+i,actCommentDetail);
			}
			json.putAll(json.fromObject(successcode));
			json.put("actCommentMap", actCommentMap);
			return json;
		}catch(MySQLException sqle){
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}
}	
