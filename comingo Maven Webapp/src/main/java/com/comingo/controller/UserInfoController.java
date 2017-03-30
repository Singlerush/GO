package com.comingo.controller;

import java.sql.SQLException;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comingo.domain.StatusCode;
import com.comingo.domain.Test;
import com.comingo.domain.UserInfo;
import com.comingo.exception.MySQLException;
import com.comingo.exception.ParamsErrorException;
import com.comingo.exception.QueryFailedException;
import com.comingo.service.TestService;
import com.comingo.service.UserInfoService;

@Controller
public class UserInfoController extends BaseController {
	@Resource
	UserInfoService userInfoService;
	
	final private StatusCode successcode = new StatusCode(200, "OK");
	
	/**
	 * 用户注册
	 * @param userinfo
	 * @return
	 */
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject sayPOST(UserInfo userInfo){
		JSONObject json = new JSONObject();  
		try{
			userInfoService.insert(userInfo);
			System.out.println(userInfo.getUserId()+":"+userInfo.getNickname()+".."+userInfo.getBirthday());
			json.putAll(json.fromObject(successcode));
			return json;
		}catch(MySQLException sqle){
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}
}	
