package com.comingo.domain;

import java.sql.Timestamp;

public class ActLike {
	private String act_id;
	private String user_id;
	private Timestamp act_like_create_time;
	public String getAct_id() {
		return act_id;
	}
	public void setAct_id(String act_id) {
		this.act_id = act_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Timestamp getAct_like_create_time() {
		return act_like_create_time;
	}
	public void setAct_like_create_time(Timestamp act_like_create_time) {
		this.act_like_create_time = act_like_create_time;
	}

}
