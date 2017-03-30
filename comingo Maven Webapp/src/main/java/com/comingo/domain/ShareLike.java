package com.comingo.domain;

import java.sql.Timestamp;

public class ShareLike {
	private String share_id;
	private String user_id;
	private Timestamp share_like_create_time;
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
	public Timestamp getShare_like_create_time() {
		return share_like_create_time;
	}
	public void setShare_like_create_time(Timestamp share_like_create_time) {
		this.share_like_create_time = share_like_create_time;
	}
	
}
