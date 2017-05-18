package com.comingo.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comingo.domain.ActComment;
import com.comingo.domain.ActLike;
import com.comingo.domain.Activity;
import com.comingo.domain.Participant;
import com.comingo.domain.StatusCode;
import com.comingo.domain.UserInfo;
import com.comingo.exception.MySQLException;
import com.comingo.exception.ParamsErrorException;
import com.comingo.exception.QueryFailedException;
import com.comingo.service.ActivityService;
import com.comingo.service.UserInfoService;
import com.comingo.util.JsonDateValueProcessor;

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
		int actLikeCount = 0;//活动点赞数
		int actCommentCount = 0;//活动评论数
		int isActLikeFlag = 0;//是否点赞，默认没有
		int isParticipateFlag = 0;//是否参与活动，默认没有
		JSONObject json = new JSONObject();  
		try{
			if(actId==null) throw new ParamsErrorException();
			activity = activityService.get(actId);
			
			JsonConfig config = new JsonConfig();  
	        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
	        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);  
	        JSONArray array = new JSONArray();  
	        array = array.fromObject(activity,config);  
			
			actLikeCount = activityService.findActLikeCountByActId(actId);
			actCommentCount = activityService.findActCommentCountByActId(actId);
			ActLike actLike = activityService.findActLike(actId,userId);
			if(actLike!=null){
				isActLikeFlag = 1;
			}
			Participant participate =activityService.findParticipate(actId,userId);
			if(participate!=null){
				isParticipateFlag= 1;
			}
			if(activity==null) throw new QueryFailedException();
			json.putAll(json.fromObject(successcode));
			json.put("activity",array.toString());
			json.put("actLikeCount",actLikeCount);
			json.put("actCommentCount",actCommentCount);
			json.put("isActLikeFlag",isActLikeFlag);
			json.put("isParticipateFlag",isParticipateFlag);
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
		String username = "";//用户昵称
		JSONObject json = new JSONObject();  
		try{
			List<Activity> actList = activityService.findActList(userId);
			username = userInfoService.findUsernameByUserId(userId);
			
			JsonConfig config = new JsonConfig();  
	        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
	        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);  
	        JSONArray array = new JSONArray();  
	        array = array.fromObject(actList,config);  

	        json.putAll(json.fromObject(successcode));
	        json.put("actList", array.toString());
	        json.put("username", username);
			
			return json;
		}catch(MySQLException sqle){
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}
	/**
	 * 获取活动日程
	 * @param userId
	 * @param actBeginTime
	 * @return
	 */
	@RequestMapping(value = "/actSchedule", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject getActScheduleList(String userId){
		JSONObject json = new JSONObject();  
		try{
			List<Activity> activities = activityService.findActByUserId(userId);
			List<Activity> actScheduleList = activityService.findActScheduleList(userId);
			
			JsonConfig config = new JsonConfig();  
	        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
	        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);  
	        JSONArray array = new JSONArray();  
	        array = array.fromObject(actScheduleList,config);  
			
			json.putAll(json.fromObject(successcode));
			json.put("actScheduleList", array.toString());
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
			
			JsonConfig config = new JsonConfig();  
	        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
	        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);  
	        JSONArray array = new JSONArray();  
	        array = array.fromObject(actList,config);  
			
			System.out.println(actList.size());
			json.putAll(json.fromObject(successcode));
			json.put("actList", array.toString());
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
