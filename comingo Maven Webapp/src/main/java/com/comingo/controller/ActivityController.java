package com.comingo.controller;

import java.net.URLDecoder;
import java.sql.SQLException;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

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
	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public @ResponseBody
//	JSONObject sayGET(String id) {
//		Test test = null;
//		JSONObject json = new JSONObject();  
//		try{
//			if(id==null) throw new ParamsErrorException();
//			test = testService.get(id);
//			if(test==null) throw new QueryFailedException();
//			json.putAll(json.fromObject(successcode));
//			json.put("test",test);
//			return json;
//		}catch(ParamsErrorException e){
//			return json.fromObject(e.getSc());
//		}catch (QueryFailedException e) {
//			return json.fromObject(e.getSc());
//		}
//	} 
	/**
	 * 添加新的活动
	 * @param activity
	 * @return
	 */
	@RequestMapping(value = "/activity", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject sayPOST(Activity activity){
		JSONObject json = new JSONObject();  
		try{
			activityService.insertActivity(activity);
			json.putAll(json.fromObject(successcode));
			return json;
		}catch(MySQLException sqle){
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}
	
//	@RequestMapping(value = "/test", method = RequestMethod.DELETE)
//	public @ResponseBody
//	JSONObject sayDEL(String id){
//		Test test = null;
//		JSONObject json = new JSONObject();  
//		try{
//			if(id==null) throw new ParamsErrorException();
//			test = testService.get(id);
//			if(test==null) throw new QueryFailedException("id不存在");
//			testService.deleteById(id);
//			json.putAll(json.fromObject(successcode));
//			return json;
//		}catch(MySQLException e){
//			return json.fromObject(e.getSc());
//		}catch(ParamsErrorException e){
//			return json.fromObject(e.getSc());
//		}catch (QueryFailedException e) {
//			return json.fromObject(e.getSc());
//		}
//	}
//	
//	@RequestMapping(value = "/test", method = RequestMethod.PUT)
//	public @ResponseBody
//	JSONObject sayPUT(Test test){
//		JSONObject json = new JSONObject();  
//
//		testService.update(test);
//		json.putAll(json.fromObject(successcode));
//		return json;
//	}
//	
//	@RequestMapping(value = "/testget", method = RequestMethod.GET)
//	public @ResponseBody
//	JSONObject testGET(String username) {
//		Test test = null;
//		JSONObject json = new JSONObject();  
//		try{
//			if(username==null) throw new ParamsErrorException();
//			test = testService.findByName(username);
//			if(test==null) throw new QueryFailedException();
//			json.putAll(json.fromObject(successcode));
//			json.put("test",test);
//			return json;
//		}catch(ParamsErrorException e){
//			return json.fromObject(e.getSc());
//		}catch (QueryFailedException e) {
//			return json.fromObject(e.getSc());
//		}
//	} 
}	
