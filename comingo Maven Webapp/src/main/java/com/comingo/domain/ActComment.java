package com.comingo.domain;

import java.sql.Timestamp;
import java.util.Date;

public class ActComment {
	private String actId;
	private String userId;
	private String actCommentDesc;
	private Date actCommentCreateTime;
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
	public String getActCommentDesc() {
		return actCommentDesc;
	}
	public void setActCommentDesc(String actCommentDesc) {
		this.actCommentDesc = actCommentDesc;
	}
	public Date getActCommentCreateTime() {
		return actCommentCreateTime;
	}
	public void setActCommentCreateTime(Date actCommentCreateTime) {
		this.actCommentCreateTime = actCommentCreateTime;
	}
}
