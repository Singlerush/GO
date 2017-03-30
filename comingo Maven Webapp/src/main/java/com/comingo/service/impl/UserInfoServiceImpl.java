package com.comingo.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comingo.dao.OrgInfoDao;
import com.comingo.dao.UserInfoDao;
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

	public Test get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(UserInfo userInfo) {
		userInfo.setUserId(UUID.randomUUID().toString());
		userInfo.setNickname(userInfo.getNickname());
		String md5Pwd = MD5Util.makeMD5(userInfo.getPassword());
		userInfo.setPassword(md5Pwd);
		String profilePicPath = "#";
		userInfo.setProfilePic(profilePicPath);
		userInfo.setBirthday(userInfo.getBirthday());
		userInfo.setEmail(userInfo.getEmail());
		userInfo.setMobile(userInfo.getMobile());
		userInfo.setUserType(0);
		userInfo.setRegisterTime(new Timestamp(new Date().getTime()));
		String msg = "";
		if (userInfo.getNickname() != null) {
			msg = "改用户名已经存在！";
		}
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

}
