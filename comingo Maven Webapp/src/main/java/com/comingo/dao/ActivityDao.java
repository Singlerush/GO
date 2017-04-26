package com.comingo.dao;

import java.util.List;
import java.util.Map;

import com.comingo.domain.Activity;
import com.comingo.domain.OrgInfo;

public interface ActivityDao extends BaseDao<Activity> {
	public void insertActivity(Activity activity);

	public List<Activity> findActList(String userId);

	public List<Activity> findActByKeyword(Map map);
}