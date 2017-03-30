package com.comingo.dao.impl;


import org.springframework.stereotype.Repository;

import com.comingo.dao.OrgInfoDao;
import com.comingo.domain.OrgInfo;

@Repository
public class OrgInfoDaoImpl extends BaseDaoImpl<OrgInfo> implements OrgInfoDao {
	
	public OrgInfoDaoImpl(){
		//设置命名空间
		super.setNs("com.comingo.mapper.OrgInfoMapper");
	}

}
