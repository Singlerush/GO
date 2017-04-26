package com.comingo.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.comingo.domain.Activity;
import com.comingo.domain.OrgInfo;
import com.comingo.domain.Participant;

public interface ParticipantDao extends BaseDao<Participant> {
	public void insertParticipant(Participant participant);

	public Participant findParticipate(Map map);
}