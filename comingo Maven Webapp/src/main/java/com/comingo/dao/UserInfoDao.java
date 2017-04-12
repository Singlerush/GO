package com.comingo.dao;

import java.util.Map;

import com.comingo.domain.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo> {
	UserInfo findUserByUsernameAndPSW(Map map);
}	
