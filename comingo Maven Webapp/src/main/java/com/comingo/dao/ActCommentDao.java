package com.comingo.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.comingo.domain.ActComment;

public interface ActCommentDao extends BaseDao<ActComment> {
	public void deleteCommentById(Serializable id);
	public int findActCommentCountByActId(Serializable id);
	public void insertActComment(ActComment actComment);
	public List<ActComment> findActCommentDesc(String actId);
}	
