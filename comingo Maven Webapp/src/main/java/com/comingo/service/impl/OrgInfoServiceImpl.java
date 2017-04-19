package com.comingo.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comingo.dao.OrgInfoDao;
import com.comingo.dao.UserInfoDao;
import com.comingo.domain.OrgInfo;
import com.comingo.domain.Test;
import com.comingo.domain.UserInfo;
import com.comingo.exception.LoginFailedException;
import com.comingo.exception.MySQLException;
import com.comingo.pagination.Page;
import com.comingo.service.OrgInfoService;
import com.comingo.util.MD5Util;

@Service
public class OrgInfoServiceImpl implements OrgInfoService {

	@Resource
	OrgInfoDao orgInfoDao;
	@Resource
	UserInfoDao userInfoDao;
	
	/**
	 * 添加社团账号
	 */
	public void insert(OrgInfo orgInfo) {
		UserInfo userInfo = new UserInfo();
		String userId = UUID.randomUUID().toString();
		userInfo.setUserId(userId);
		userInfo.setUsername(userInfo.getUsername());
		String md5Pwd = MD5Util.makeMD5(userInfo.getPassword());
		userInfo.setPassword(md5Pwd);
		userInfo.setProfilePic(userInfo.getProfilePic());
		userInfo.setBirthday(userInfo.getBirthday());
		userInfo.setEmail(userInfo.getEmail());
		if((userInfoDao.findUserByMobile(userInfo.getMobile())!=null)){
			throw new RuntimeException("该手机号已经被注册");
		}
		userInfo.setMobile(userInfo.getMobile());
		userInfo.setUserType(0);
		userInfo.setRegisterTime(new Timestamp(new Date().getTime()));
		//将社团中的个人信息加入到个人信息表中
		userInfoDao.insert(userInfo);
		//将个人信息作为一个属性，插入社团中
		orgInfo.setUserInfo(userInfo);
		
		orgInfo.setOrgId(userId);
		orgInfo.setOrgDesc(orgInfo.getOrgDesc());
		orgInfo.setLeader(orgInfo.getLeader());
		orgInfo.setLeaderMobile(orgInfo.getLeaderMobile());
		orgInfo.setAuthImg1(orgInfo.getAuthImg1());
		orgInfo.setAuthImg2(orgInfo.getAuthImg2());
		orgInfo.setActivateState(0);
		orgInfo.setVerifyState(0);
		
		orgInfoDao.insert(orgInfo);
	}

	public List<OrgInfo> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 根据邮箱和密码查找社团
	 */
	public OrgInfo findOrgByEMailAndPSW(Map paraMap) {
		
		return orgInfoDao.findOrgByEMailAndPSW(paraMap);
	}

	public OrgInfo get(Serializable id) {
		
		return null;
	}

	public void update(OrgInfo orgInfo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(Serializable id) throws MySQLException {
		// TODO Auto-generated method stub
		
	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

	public List<OrgInfo> find(Map paraMap) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
