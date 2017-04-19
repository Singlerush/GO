package com.comingo.dao.impl;


import java.util.Map;

import org.springframework.stereotype.Repository;

import com.comingo.dao.UserInfoDao;
import com.comingo.domain.OrgInfo;
import com.comingo.domain.UserInfo;

@Repository
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao {
	
	public UserInfoDaoImpl(){
		//设置命名空间
		super.setNs("com.comingo.mapper.UserInfoMapper");
	}

	public UserInfo findUserByMobileAndPSW(Map map) {
		return super.getSqlSession().selectOne(super.getNs()+".findUserByMobileAndPSW", map);
	}

	public UserInfo findUserByMobile(String mobile) {
		return super.getSqlSession().selectOne(super.getNs()+".findUserByMobile", mobile);
	}

}