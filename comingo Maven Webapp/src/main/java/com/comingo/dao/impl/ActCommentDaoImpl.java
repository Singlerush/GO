package com.comingo.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.comingo.dao.ActCommentDao;
import com.comingo.domain.ActComment;

@Repository
public class ActCommentDaoImpl extends BaseDaoImpl<ActComment> implements ActCommentDao {
	
	public ActCommentDaoImpl(){
		//设置命名空间
		super.setNs("com.comingo.mapper.ActCommentMapper");
	}

	public void insertActComment(ActComment actComment) {
		super.getSqlSession().insert(super.getNs()+".insertActComment" , actComment);		
	}

	public void deleteCommentById(Serializable id) {
		super.getSqlSession().delete(super.getNs()+".deleteCommentById" , id);
	}

	public int findActCommentCountByActId(Serializable id) {
		return super.getSqlSession().selectOne(super.getNs()+".findActCommentCountByActId" , id);
	}

	public List<ActComment> findActCommentDesc(String actId) {
		return super.getSqlSession().selectList(super.getNs()+".findActCommentDesc" , actId);
	}

}
