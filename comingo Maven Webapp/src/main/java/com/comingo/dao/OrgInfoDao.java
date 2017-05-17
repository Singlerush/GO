package com.comingo.dao;

import java.util.Map;

import com.comingo.domain.OrgInfo;

public interface OrgInfoDao extends BaseDao<OrgInfo> {
	public OrgInfo findOrgByEMailAndPSW(Map paraMap);

	public Object findOrgByEmail(String email);
	
	public OrgInfo findOrgByOrgId(String orgId);

	public void changeActivateState(OrgInfo orgInfo);

}	
