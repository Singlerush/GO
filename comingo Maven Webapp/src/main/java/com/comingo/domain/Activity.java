package com.comingo.domain;

import java.sql.Timestamp;

public class Activity {
	private String act_id;
	private String user_id;
	private Timestamp act_beginTime;
	private Timestamp act_endTime;
	private Timestamp applyDateLine;
	private String act_label;
	private String act_title;
	private String act_desc;
	private String act_pic;
	private double act_longitude;
	private double act_latitude;
	private Timestamp publishTime;
	private String contact_name;
	private String contact_tel;
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
	public Timestamp getAct_beginTime() {
		return act_beginTime;
	}
	public void setAct_beginTime(Timestamp act_beginTime) {
		this.act_beginTime = act_beginTime;
	}
	public Timestamp getAct_endTime() {
		return act_endTime;
	}
	public void setAct_endTime(Timestamp act_endTime) {
		this.act_endTime = act_endTime;
	}
	public Timestamp getApplyDateLine() {
		return applyDateLine;
	}
	public void setApplyDateLine(Timestamp applyDateLine) {
		this.applyDateLine = applyDateLine;
	}
	public String getAct_label() {
		return act_label;
	}
	public void setAct_label(String act_label) {
		this.act_label = act_label;
	}
	public String getAct_title() {
		return act_title;
	}
	public void setAct_title(String act_title) {
		this.act_title = act_title;
	}
	public String getAct_desc() {
		return act_desc;
	}
	public void setAct_desc(String act_desc) {
		this.act_desc = act_desc;
	}
	public String getAct_pic() {
		return act_pic;
	}
	public void setAct_pic(String act_pic) {
		this.act_pic = act_pic;
	}
	public double getAct_longitude() {
		return act_longitude;
	}
	public void setAct_longitude(double act_longitude) {
		this.act_longitude = act_longitude;
	}
	public double getAct_latitude() {
		return act_latitude;
	}
	public void setAct_latitude(double act_latitude) {
		this.act_latitude = act_latitude;
	}
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getContact_tel() {
		return contact_tel;
	}
	public void setContact_tel(String contact_tel) {
		this.contact_tel = contact_tel;
	}
	
	
}
