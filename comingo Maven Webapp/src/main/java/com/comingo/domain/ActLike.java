package com.comingo.domain;

import java.sql.Timestamp;
import java.util.Date;

public class ActLike {
	private String actId;
	private String userId;
	private Date actLikeCreateTime;
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getActLikeCreateTime() {
		return actLikeCreateTime;
	}
	public void setActLikeCreateTime(Date actLikeCreateTime) {
		this.actLikeCreateTime = actLikeCreateTime;
	}

}
