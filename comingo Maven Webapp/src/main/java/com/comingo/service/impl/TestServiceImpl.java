package com.comingo.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.comingo.dao.TestDao;
import com.comingo.domain.Test;
import com.comingo.exception.MySQLException;
import com.comingo.pagination.Page;
import com.comingo.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Resource
	TestDao testDao;
	
	public List<Test> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Test> find(Map paraMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public Test get(Serializable id) {
		System.out.println(this.getClass().toString()+"--->"+"get");
		return testDao.get(id);
	}

	public void insert(Test test) throws MySQLException {
		System.out.println(this.getClass().toString()+"-->"+"insert");
		test.setId(UUID.randomUUID().toString());
		test.setCreateTime(new Timestamp(new Date().getTime()));
		testDao.insert(test);
	}

	public void update(Test test) {
		testDao.update(test);
	}

	public void deleteById(Serializable id) throws MySQLException {
		testDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub

	}

	public Test findByName(String username) {
		return testDao.findByName(username);
	}

}
