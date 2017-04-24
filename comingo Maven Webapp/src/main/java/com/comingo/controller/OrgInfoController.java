package com.comingo.controller;

import java.sql.SQLException;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comingo.domain.OrgInfo;
import com.comingo.domain.StatusCode;
import com.comingo.domain.Test;
import com.comingo.domain.UserInfo;
import com.comingo.exception.LoginFailedException;
import com.comingo.exception.MySQLException;
import com.comingo.exception.ParamsErrorException;
import com.comingo.exception.QueryFailedException;
import com.comingo.service.OrgInfoService;
import com.comingo.service.TestService;
import com.comingo.service.UserInfoService;

@Controller
public class OrgInfoController extends BaseController {
	@Resource
	OrgInfoService orgInfoService;
	
	final private StatusCode successcode = new StatusCode(200, "OK");
	
	/**
	 * 组织用户注册
	 * @param orginfo
	 * @return
	 */
	@RequestMapping(value = "/orginfo", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject sayPOST(UserInfo userInfo, OrgInfo orgInfo){
		JSONObject json = new JSONObject();  
		try{
			orgInfo.setUserInfo(userInfo);
			orgInfoService.insert(orgInfo);
			json.putAll(json.fromObject(successcode));
			return json;
		}catch(MySQLException sqle){
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}
	
	/**
	 * 组织用户信息获取
	 * @param orginfo
	 * @return
	 */
	@RequestMapping(value = "/orginfo", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject UserInfo(String id){
		JSONObject json = new JSONObject(); 
		try{
			if(id==null) throw new ParamsErrorException();
			OrgInfo orgInfo = orgInfoService.get(id);
			if(orgInfo==null) throw new QueryFailedException();
			json.putAll(json.fromObject(successcode));
			json.put("OrgInfo",orgInfo);
			return json;
		}catch (ParamsErrorException e) {
			return json.fromObject(e.getSc());
		} catch (QueryFailedException e) {
			return json.fromObject(e.getSc());
		}
	}
	
	/**
	 * 组织用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/orglogin", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject UserLogin(String username, String password){
		JSONObject json = new JSONObject();  
		try{
			if(username==null||password==null) throw new ParamsErrorException();
			if(true)
				json.putAll(json.fromObject(successcode));
			else
				throw new LoginFailedException();
			return json;
		}catch (ParamsErrorException e) {
			return json.fromObject(e.getSc());
		} catch (LoginFailedException e) {
			return json.fromObject(e.getSc());
		}
	}
}	
