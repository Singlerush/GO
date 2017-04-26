package com.comingo.dao;

import java.io.Serializable;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.comingo.domain.ActLike;
import com.comingo.domain.Activity;
import com.comingo.domain.OrgInfo;

public interface ActLikeDao extends BaseDao<ActLike> {
	public void deleteLikeById(Serializable id);
	public int findActLikeCountByActId(@Param("actId")Serializable actId);
	public void insertActLike(ActLike actLike);
	public ActLike findActLike(Map map);
}	
