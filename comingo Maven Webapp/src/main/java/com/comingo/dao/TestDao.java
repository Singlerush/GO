package com.comingo.dao;

import com.comingo.domain.Test;

public interface TestDao extends BaseDao<Test> {
	public Test findByName(String username);
}	
