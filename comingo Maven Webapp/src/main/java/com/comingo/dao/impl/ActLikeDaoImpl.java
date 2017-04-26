package com.comingo.dao.impl;


import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.comingo.dao.ActLikeDao;
import com.comingo.dao.ActivityDao;
import com.comingo.dao.OrgInfoDao;
import com.comingo.domain.ActLike;
import com.comingo.domain.Activity;
import com.comingo.domain.OrgInfo;

@Repository
public class ActLikeDaoImpl extends BaseDaoImpl<ActLike> implements ActLikeDao {
	
	public ActLikeDaoImpl(){
		//设置命名空间
		super.setNs("com.comingo.mapper.ActLikeMapper");
	}

	public void insertActLike(ActLike actLike) {
		super.getSqlSession().insert(super.getNs()+".insertActLike" , actLike);
	}

	public void deleteLikeById(Serializable id) {
		super.getSqlSession().delete(super.getNs()+".deleteLikeById" , id);
	}

	public int findActLikeCountByActId(Serializable id) {
		return super.getSqlSession().selectOne(super.getNs()+".findActLikeCountByActId", id);
	}

	public ActLike findActLike(Map map) {
		return super.getSqlSession().selectOne(super.getNs()+".findActLike", map);
	}



}
