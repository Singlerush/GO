package com.comingo.domain;

import java.sql.Timestamp;

public class ActComment {
	private String act_id;
	private String act_comment_desc;
	private Timestamp act_comment_create_time;
	public String getAct_id() {
		return act_id;
	}
	public void setAct_id(String act_id) {
		this.act_id = act_id;
	}
	public String getAct_comment_desc() {
		return act_comment_desc;
	}
	public void setAct_comment_desc(String act_comment_desc) {
		this.act_comment_desc = act_comment_desc;
	}
	public Timestamp getAct_comment_create_time() {
		return act_comment_create_time;
	}
	public void setAct_comment_create_time(Timestamp act_comment_create_time) {
		this.act_comment_create_time = act_comment_create_time;
	}
	
}
