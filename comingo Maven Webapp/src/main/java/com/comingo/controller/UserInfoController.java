package com.comingo.controller;

import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comingo.domain.StatusCode;
import com.comingo.domain.UserInfo;
import com.comingo.exception.ExistenceException;
import com.comingo.exception.LoginFailedException;
import com.comingo.exception.MySQLException;
import com.comingo.exception.ParamsErrorException;
import com.comingo.exception.QueryFailedException;
import com.comingo.service.UserInfoService;
import com.comingo.util.JsonDateValueProcessor;

@Controller
public class UserInfoController extends BaseController {
	@Resource
	UserInfoService userInfoService;

	final private StatusCode successcode = new StatusCode(200, "OK");

	/**
	 * 用户注册
	 * 
	 * @param userinfo
	 * @return
	 */
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject sayPOST(UserInfo userInfo) {
		JSONObject json = new JSONObject();
		try {
			userInfoService.insert(userInfo);
			json.putAll(json.fromObject(successcode));
			return json;
		} catch (MySQLException sqle) {
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}
	/**
	 * 个人用户更新
	 * 
	 * @param userinfo
	 * @return
	 */
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject updateUserInfo(UserInfo userInfo) {
		JSONObject json = new JSONObject();
		try {
			userInfoService.updateUserInfo(userInfo);
			json.putAll(json.fromObject(successcode));
			return json;
		} catch (MySQLException sqle) {
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}

	/**
	 * 用户信息获取
	 * 
	 * @param orginfo
	 * @return
	 */
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject UserInfo(String userId) {
		JSONObject json = new JSONObject();
		try {
			if (userId == null)
				throw new ParamsErrorException();
			UserInfo userInfo = userInfoService.get(userId);
			if (userInfo == null)
				throw new QueryFailedException();

			JsonConfig config = new JsonConfig();  
	        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
	        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);  
	        JSONArray array = new JSONArray();  
	        array = array.fromObject(userInfo,config); 
			
			json.putAll(json.fromObject(successcode));
			json.put("userInfo", array.toString());
			return json;
		} catch (ParamsErrorException e) {
			return json.fromObject(e.getSc());
		} catch (QueryFailedException e) {
			return json.fromObject(e.getSc());
		}
	}

	/**
	 * 用户登录
	 * 
	 * @param moblile
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject UserLogin(String mobile, String password) {
		JSONObject json = new JSONObject();
		try {
			if (mobile == null || password == null)
				throw new ParamsErrorException();
			UserInfo userInfo = userInfoService.findUserByMobileAndPSW(mobile,
					password);
			if (userInfo == null) {
				throw new LoginFailedException();
			}
			if (StringUtils.isNotBlank(userInfo.getUserId())) {
				json.putAll(json.fromObject(successcode));
				json.put("userId", userInfo.getUserId());
			} else
				throw new LoginFailedException();
			return json;
		} catch (ParamsErrorException e) {
			return json.fromObject(e.getSc());
		} catch (LoginFailedException e) {
			return json.fromObject(e.getSc());
		}
	}

	/**
	 * 用户手机检测
	 * 
	 * @param moblile
	 * @return
	 */
	@RequestMapping(value = "/userreg", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject UserRegister(String mobile) {
		JSONObject json = new JSONObject();
		try {
			if (mobile == null)
				throw new ParamsErrorException();
			UserInfo userInfo = userInfoService.findUserByMobile(mobile);
			if (userInfo == null) {
				json.putAll(json.fromObject(successcode));
			} else
				throw new ExistenceException();
			return json;
		} catch (ParamsErrorException e) {
			return json.fromObject(e.getSc());
		} catch (ExistenceException e) {
			return json.fromObject(e.getSc());
		}
	}
}
