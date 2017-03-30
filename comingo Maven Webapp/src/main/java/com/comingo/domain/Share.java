package com.comingo.domain;

import java.sql.Timestamp;

public class Share {
	private String share_id;
	private String share_desc;
	private Timestamp share_create_time;
	private String share_pic1;
	private String share_pic2;
	private String share_pic3;
	public String getShare_id() {
		return share_id;
	}
	public void setShare_id(String share_id) {
		this.share_id = share_id;
	}
	public String getShare_desc() {
		return share_desc;
	}
	public void setShare_desc(String share_desc) {
		this.share_desc = share_desc;
	}
	public Timestamp getShare_create_time() {
		return share_create_time;
	}
	public void setShare_create_time(Timestamp share_create_time) {
		this.share_create_time = share_create_time;
	}
	public String getShare_pic1() {
		return share_pic1;
	}
	public void setShare_pic1(String share_pic1) {
		this.share_pic1 = share_pic1;
	}
	public String getShare_pic2() {
		return share_pic2;
	}
	public void setShare_pic2(String share_pic2) {
		this.share_pic2 = share_pic2;
	}
	public String getShare_pic3() {
		return share_pic3;
	}
	public void setShare_pic3(String share_pic3) {
		this.share_pic3 = share_pic3;
	}
	
	
}
