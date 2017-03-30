package com.comingo.domain;

import java.sql.Timestamp;

public class Participant {
	private String user_id;
	private String act_id;
	private Timestamp participate_time;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAct_id() {
		return act_id;
	}
	public void setAct_id(String act_id) {
		this.act_id = act_id;
	}
	public Timestamp getParticipate_time() {
		return participate_time;
	}
	public void setParticipate_time(Timestamp participate_time) {
		this.participate_time = participate_time;
	}
	
}
