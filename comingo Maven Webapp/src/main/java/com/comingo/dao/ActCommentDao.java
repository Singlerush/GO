package com.comingo.dao;

import java.io.Serializable;
import java.util.Map;

import com.comingo.domain.ActComment;

public interface ActCommentDao extends BaseDao<ActComment> {
	public void insertComment(ActComment actComment);
	public void deleteCommentById(Serializable id);
}	
