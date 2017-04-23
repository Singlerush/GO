package com.comingo.controller;


import java.net.URLDecoder;
import java.sql.SQLException;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comingo.domain.Activity;
import com.comingo.domain.OrgInfo;
import com.comingo.domain.StatusCode;
import com.comingo.domain.Test;
import com.comingo.exception.MySQLException;
import com.comingo.exception.ParamsErrorException;
import com.comingo.exception.QueryFailedException;
import com.comingo.service.ActivityService;
import com.comingo.service.TestService;

@Controller
public class ActivityController extends BaseController {
	@Resource
	ActivityService activityService;
	
	final private StatusCode successcode = new StatusCode(200, "OK");
	
	
	/**
	 * 查看活动详情
	 * 返回活动详情，点赞数，评论数，用户是否已参与，用户是否已点赞
	 * @param actId, userId
	 * @return activity
	 */
	@RequestMapping(value = "/activity", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject getActivityDetails(String actId, String userId) {
		Activity activity = null;
		JSONObject json = new JSONObject();  
		try{
			if(actId==null) throw new ParamsErrorException();
			activity = activityService.get(actId);
			if(activity==null) throw new QueryFailedException();
			json.putAll(json.fromObject(successcode));
			json.put("activity",activity);
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
//	@RequestMapping(value = "/activitylist", method = RequestMethod.GET)
//	public @ResponseBody
//	JSONObject sayPOST(String userId){
//		JSONObject json = new JSONObject();  
//		try{
//			//activityService.insertActivity(activity);
//			json.putAll(json.fromObject(successcode));
//			return json;
//		}catch(MySQLException sqle){
//			return json.fromObject(new StatusCode(10001, "Database Error"));
//		}
//	}
	
	
	/**
	 * 按关键词查询活动
	 * @param userId，keyword
	 * @return
	 */
//	@RequestMapping(value = "/activitylist", method = RequestMethod.POST)
//	public @ResponseBody
//	JSONObject sayPOST(String userId, String keyword){
//		JSONObject json = new JSONObject();  
//		try{
//			activityService.insertActivity(activity);
//			json.putAll(json.fromObject(successcode));
//			return json;
//		}catch(MySQLException sqle){
//			return json.fromObject(new StatusCode(10001, "Database Error"));
//		}
//	}
	
	/**
	 * 参加活动
	 * @param actId, userId
	 * @return
	 */
//	@RequestMapping(value = "/activityparticipate", method = RequestMethod.POST)
//	public @ResponseBody
//	JSONObject sayPOST(String actId, String userId){
//		JSONObject json = new JSONObject();  
//		try{
//			activityService.insertActivity(activity);
//			json.putAll(json.fromObject(successcode));
//			return json;
//		}catch(MySQLException sqle){
//			return json.fromObject(new StatusCode(10001, "Database Error"));
//		}
//	}
	
	/**
	 * 活动点赞
	 * @param actId, userId
	 * @return
	 */
//	@RequestMapping(value = "/activitylike", method = RequestMethod.POST)
//	public @ResponseBody
//	JSONObject sayPOST(String actId, String userId){
//		JSONObject json = new JSONObject();  
//		try{
//			activityService.insertActivity(activity);
//			json.putAll(json.fromObject(successcode));
//			return json;
//		}catch(MySQLException sqle){
//			return json.fromObject(new StatusCode(10001, "Database Error"));
//		}
//	}

	/**
	 * 评论活动
	 * @param actId, userId, comment
	 * @return
	 */
//	@RequestMapping(value = "/activitycomment", method = RequestMethod.POST)
//	public @ResponseBody
//	JSONObject sayPOST(String actId, String userId, String comment){
//		JSONObject json = new JSONObject();  
//		try{
//			activityService.insertActivity(activity);
//			json.putAll(json.fromObject(successcode));
//			return json;
//		}catch(MySQLException sqle){
//			return json.fromObject(new StatusCode(10001, "Database Error"));
//		}
//	}
	
	/**
	 * 查看活动评论
	 * @param actId
	 * @return
	 */
//	@RequestMapping(value = "/activitycomment", method = RequestMethod.GET)
//	public @ResponseBody
//	JSONObject sayPOST(String actId, String userId){
//		JSONObject json = new JSONObject();  
//		try{
//			activityService.insertActivity(activity);
//			json.putAll(json.fromObject(successcode));
//			return json;
//		}catch(MySQLException sqle){
//			return json.fromObject(new StatusCode(10001, "Database Error"));
//		}
//	}
}	
