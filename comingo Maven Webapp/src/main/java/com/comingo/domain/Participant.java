package com.comingo.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Participant {
	private String userId;
	private String actId;
	private Date participateTime;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public Date getParticipateTime() {
		return participateTime;
	}
	public void setParticipateTime(Date participateTime) {
		this.participateTime = participateTime;
	}
	
}
