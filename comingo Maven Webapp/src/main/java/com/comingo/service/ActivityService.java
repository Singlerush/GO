package com.comingo.service;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.comingo.domain.ActComment;
import com.comingo.domain.ActLike;
import com.comingo.domain.Activity;
import com.comingo.domain.OrgInfo;
import com.comingo.domain.Participant;
import com.comingo.domain.Test;
import com.comingo.domain.UserInfo;
import com.comingo.exception.MySQLException;
import com.comingo.pagination.Page;

public interface ActivityService {
	public List<Activity> findPage(Page page);		//分页查询
	public List<Activity> find(Map paraMap);		//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public Activity get(Serializable id);			//只查询一个，常用于修改
	
	public void insertActivity(Activity activity) throws MySQLException;			//插入，用实体作为参数
	public void update(Activity activity);			//修改，用实体作为参数
	public void deleteById(Serializable id) throws MySQLException;		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);			//批量删除；支持整数型和字符串类型ID
	
	public int findActLikeCountByActId(Serializable id); //根据活动id查找活动的点赞数
	public int findActCommentCountByActId(Serializable id); //根据活动id查找活动的评论数
	public List<Activity> findActList(String userId) throws MySQLException;//查询活动的列表
	public List<Activity> findActByKeyword(String userId, String keyword)throws MySQLException; //根据关键字查询活动
	public void insertActLike(String actId, String userId) throws MySQLException;//活动点赞
	public void insertActComment(String actId, String userId, String actComment) throws MySQLException;//添加点赞
	public List<ActComment> findActCommentDesc(String actId) throws MySQLException;//查找具体的活动评论
	public void insertParticipant(String actId,String userId) throws MySQLException;//将actId和userId关联
	public ActLike findActLike(String actId,String userId);//根据actId和userId查找点赞，确定用户有没有点赞
	public Participant findParticipate(String actId, String userId);//根据actId和userId查找参与活动的状态，确定用户有没有参加活动
	public List<Activity> findActScheduleList(String userId) throws MySQLException;//获取活动日程
}
