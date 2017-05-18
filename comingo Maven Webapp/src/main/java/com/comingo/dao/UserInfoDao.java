package com.comingo.dao;

import java.util.Map;

import com.comingo.domain.OrgInfo;
import com.comingo.domain.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo> {
	UserInfo findUserByMobileAndPSW(Map map);

	UserInfo findUserByMobile(String mobile);

	UserInfo findOrgByEmail(String email);
	
	UserInfo findUserById(String id);

	String findUsernameByUserId(String userId);
}	
