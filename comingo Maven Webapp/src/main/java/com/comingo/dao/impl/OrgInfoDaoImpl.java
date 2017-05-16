package com.comingo.dao.impl;


import java.util.Map;

import org.springframework.stereotype.Repository;

import com.comingo.dao.OrgInfoDao;
import com.comingo.domain.OrgInfo;

@Repository
public class OrgInfoDaoImpl extends BaseDaoImpl<OrgInfo> implements OrgInfoDao {
	
	public OrgInfoDaoImpl(){
		//设置命名空间
		super.setNs("com.comingo.mapper.OrgInfoMapper");
	}

	public OrgInfo findOrgByEMailAndPSW(Map map) {
		return super.getSqlSession().selectOne(super.getNs()+".findUserByEMailAndPSW", map);
	}

	public OrgInfo findOrgByEmail(String email) {
		return super.getSqlSession().selectOne(super.getNs()+".findUserByEmail",email);
	}
	
	public OrgInfo findOrgByOrgId(String orgId){
		return super.getSqlSession().selectOne(super.getNs()+".findOrgByOrgId",orgId);
	}
}
