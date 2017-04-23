package com.comingo.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.comingo.dao.ActCommentDao;
import com.comingo.domain.ActComment;

@Repository
public class ActCommentDaoImpl extends BaseDaoImpl<ActComment> implements ActCommentDao {
	
	public ActCommentDaoImpl(){
		//设置命名空间
		super.setNs("com.comingo.mapper.ActCommentMapper");
	}

	public void insertComment(ActComment actComment) {
		super.getSqlSession().insert(super.getNs()+".insertComment" , actComment);		
	}

	public void deleteCommentById(Serializable id) {
		super.getSqlSession().delete(super.getNs()+".deleteCommentById" , id);
	}

}
