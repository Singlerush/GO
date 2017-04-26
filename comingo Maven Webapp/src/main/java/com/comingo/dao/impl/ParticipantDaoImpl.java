package com.comingo.dao.impl;


import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.comingo.dao.ActivityDao;
import com.comingo.dao.OrgInfoDao;
import com.comingo.dao.ParticipantDao;
import com.comingo.domain.Activity;
import com.comingo.domain.OrgInfo;
import com.comingo.domain.Participant;

@Repository
public class ParticipantDaoImpl extends BaseDaoImpl<Participant> implements ParticipantDao {
	
	public ParticipantDaoImpl(){
		//设置命名空间
		super.setNs("com.comingo.mapper.ParticipantMapper");
	}

	public void insertParticipant(Participant participant) {
		super.getSqlSession().insert(super.getNs()+".insertParticipant",participant);
	}

	public Participant findParticipate(Map map) {
		return super.getSqlSession().selectOne(super.getNs()+".findParticipate",map);
	}

}
