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

	public void insertLike(ActLike actLike) {
		super.getSqlSession().insert(super.getNs()+".insertLike" , actLike);
	}

	public void deleteLikeById(Serializable id) {
		super.getSqlSession().delete(super.getNs()+".deleteLikeById" , id);
	}

}
