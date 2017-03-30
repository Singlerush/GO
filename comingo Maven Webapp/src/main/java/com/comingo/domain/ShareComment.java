package com.comingo.domain;

import java.sql.Timestamp;

public class ShareComment {
	private String share_id;
	private String user_id;
	private String comment_desc;
	private Timestamp comment_create_time;
	public String getShare_id() {
		return share_id;
	}
	public void setShare_id(String share_id) {
		this.share_id = share_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getComment_desc() {
		return comment_desc;
	}
	public void setComment_desc(String comment_desc) {
		this.comment_desc = comment_desc;
	}
	public Timestamp getComment_create_time() {
		return comment_create_time;
	}
	public void setComment_create_time(Timestamp comment_create_time) {
		this.comment_create_time = comment_create_time;
	}
	
}
