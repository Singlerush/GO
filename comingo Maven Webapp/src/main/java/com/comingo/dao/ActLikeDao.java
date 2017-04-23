package com.comingo.dao;

import java.io.Serializable;
import java.util.Map;

import com.comingo.domain.ActLike;
import com.comingo.domain.Activity;
import com.comingo.domain.OrgInfo;

public interface ActLikeDao extends BaseDao<ActLike> {
	public void insertLike(ActLike actLike);
	public void deleteLikeById(Serializable id);
}	
