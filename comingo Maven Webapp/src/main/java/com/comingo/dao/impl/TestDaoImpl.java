package com.comingo.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.comingo.dao.TestDao;
import com.comingo.domain.Test;
import com.comingo.pagination.Page;

@Repository
public class TestDaoImpl extends BaseDaoImpl<Test> implements TestDao {
	public TestDaoImpl(){
		//设置命名空间
		super.setNs("com.comingo.mapper.TestMapper");
	}

}
