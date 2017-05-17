package com.comingo.controller;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comingo.domain.OrgInfo;
import com.comingo.domain.StatusCode;
import com.comingo.domain.UserInfo;
import com.comingo.exception.ExistenceException;
import com.comingo.exception.LoginFailedException;
import com.comingo.exception.MySQLException;
import com.comingo.exception.ParamsErrorException;
import com.comingo.exception.QueryFailedException;
import com.comingo.service.OrgInfoService;
import com.comingo.service.UserInfoService;

@Controller
public class OrgInfoController extends BaseController {
	@Resource
	OrgInfoService orgInfoService;
	@Resource
	UserInfoService userInfoService;

	final private StatusCode successcode = new StatusCode(200, "OK");

	/**
	 * 组织用户注册
	 * @param userinfo
	 * @param orginfo
	 * @return
	 */
	@RequestMapping(value = "/orginfo", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject sayPOST(UserInfo userInfo, OrgInfo orgInfo)  {
		JSONObject json = new JSONObject();
		try {
			String email = userInfo.getEmail();
			orgInfo.setUserInfo(userInfo);
			if(orgInfoService.findOrgByEmail(email)!=null){
				throw new ExistenceException();
			}
			orgInfoService.insert(orgInfo);
			orgInfoService.sendEmail("http://shnuecp.com/active.jsp?id="+userInfo.getUserId(), email);
			json.putAll(json.fromObject(successcode));
			return json;
		} catch (MySQLException sqle) {
			return json.fromObject(new StatusCode(10001, "Database Error"));
		} catch(ExistenceException e){
			return json.fromObject(new StatusCode(10009,"Already Existence"));
		} catch (Exception e) {
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}
	/**
	 * 组织用户信息获取
	 * 
	 * @param orginfo
	 * @return
	 */
	@RequestMapping(value = "/orginfo", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject OrgInfo(String orgId) {
		JSONObject json = new JSONObject();
		try {
			//根据id查找用户
			UserInfo userInfo = userInfoService.findUserById(orgId);
			if(userInfo==null){
				throw new QueryFailedException();
			}
			if (orgId == null){
				throw new ParamsErrorException();
			}
			OrgInfo orgInfo = orgInfoService.findOrgByOrgId(orgId);
			orgInfo.setUserInfo(userInfo);
			if (orgInfo == null){
				throw new QueryFailedException();
			}
			json.putAll(json.fromObject(successcode));
			json.put("orgInfo", orgInfo);
			return json;
		} catch (ParamsErrorException e) {
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
	JSONObject UserLogin(String email, String password) {
		JSONObject json = new JSONObject();
		try {
			if (email == null || password == null)
				throw new ParamsErrorException();
			if (true)
				json.putAll(json.fromObject(successcode));
			else
				throw new LoginFailedException();
			return json;
		} catch (ParamsErrorException e) {
			return json.fromObject(e.getSc());
		} catch (LoginFailedException e) {
			return json.fromObject(e.getSc());
		}
	}
	/**
	 * 组织用户激活
	 */
	@RequestMapping(value = "/orgActive", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject orgActive(String orgId) {
		JSONObject json = new JSONObject();
		try {
			OrgInfo orgInfo = orgInfoService.findOrgByOrgId(orgId);
			orgInfoService.changeActivateState(orgInfo);
			json.putAll(json.fromObject(successcode));
			return json; 
		} catch (Exception e) {
			return json.fromObject(new StatusCode(10001, "Database Error"));
		}
	}

}
