package com.comingo.dao.impl;


import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.comingo.dao.ActivityDao;
import com.comingo.dao.OrgInfoDao;
import com.comingo.domain.Activity;
import com.comingo.domain.OrgInfo;

@Repository
public class ActivityDaoImpl extends BaseDaoImpl<Activity> implements ActivityDao {
	
	public ActivityDaoImpl(){
		//设置命名空间
		super.setNs("com.comingo.mapper.ActivityMapper");
	}

	public void insertActivity(Activity activity) {
		super.getSqlSession().insert(super.getNs() + ".insertActivity", activity);
	}

	public List<Activity> findActList(String userId) {
		return super.getSqlSession().selectList(super.getNs() + ".findActList", userId);
	}

	public List<Activity> findActByKeyword(Map map) {
		return super.getSqlSession().selectList(super.getNs() + ".findActByKeyword", map);
	}

	public List<Activity> findActScheduleList(Map map) {
		return super.getSqlSession().selectList(super.getNs() + ".findActScheduleList", map);
	}

	public List<Activity> findActByUserId(String userId) {
		return super.getSqlSession().selectList(super.getNs() + ".findActByUserId", userId);
	}
}
