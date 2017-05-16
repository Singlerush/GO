package com.comingo.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.comingo.dao.OrgInfoDao;
import com.comingo.dao.UserInfoDao;
import com.comingo.domain.OrgInfo;
import com.comingo.domain.Test;
import com.comingo.domain.UserInfo;
import com.comingo.exception.MySQLException;
import com.comingo.pagination.Page;
import com.comingo.service.UserInfoService;
import com.comingo.util.MD5Util;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	UserInfoDao userInfoDao;

	public List<UserInfo> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserInfo> find(Map paraMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserInfo get(Serializable id) {
		return userInfoDao.get(id);
		
	}

	public void insert(UserInfo userInfo) {
		userInfo.setUserId(UUID.randomUUID().toString());
		userInfo.setUsername(userInfo.getUsername());
		String md5Pwd = MD5Util.makeMD5(userInfo.getPassword());
		userInfo.setPassword(md5Pwd);
		userInfo.setProfilePic(userInfo.getProfilePic());
		userInfo.setBirthday(userInfo.getBirthday());
		if((userInfoDao.findUserByMobile(userInfo.getMobile())!=null)){
			throw new RuntimeException("该手机号已经被注册");
		}
		userInfo.setEmail(userInfo.getEmail());
		userInfo.setMobile(userInfo.getMobile());
		userInfo.setUserType(0);
		userInfo.setRegisterTime(new Timestamp(new Date().getTime()));
		userInfoDao.insert(userInfo);
	}

	public void update(UserInfo userInfo) {
		// TODO Auto-generated method stub

	}

	public void deleteById(Serializable id) throws MySQLException {
		// TODO Auto-generated method stub

	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub

	}

	public UserInfo findUserByMobile(String mobile) {
		return userInfoDao.findUserByMobile(mobile);
	}
	
	/**
	 * 根据手机号和密码查找用户
	 */
	public UserInfo findUserByMobileAndPSW(String mobile, String password) {
		Map map = new HashMap();
		map.put("mobile", mobile);
		map.put("password", password);
		UserInfo userInfo = userInfoDao.findUserByMobileAndPSW(map);
		if(userInfo==null){
			throw new RuntimeException("找不到用户");
		}
		return userInfo;
	}

	public UserInfo findUserById(String userId) {
		return userInfoDao.findUserById(userId);
	}

}
