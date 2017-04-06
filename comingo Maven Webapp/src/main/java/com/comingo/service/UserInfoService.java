package com.comingo.service;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.comingo.domain.Test;
import com.comingo.domain.UserInfo;
import com.comingo.exception.MySQLException;
import com.comingo.pagination.Page;

public interface UserInfoService {
	public List<UserInfo> findPage(Page page);		//分页查询
	public List<UserInfo> find(Map paraMap);		//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public UserInfo get(Serializable id);			//只查询一个，常用于修改
	
	public void insert(UserInfo userInfo) throws MySQLException;			//插入，用实体作为参数
	public void update(UserInfo userInfo);			//修改，用实体作为参数
	public void deleteById(Serializable id) throws MySQLException;		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);			//批量删除；支持整数型和字符串类型ID
}
