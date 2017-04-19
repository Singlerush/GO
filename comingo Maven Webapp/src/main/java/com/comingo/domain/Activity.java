package com.comingo.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Activity {
	private String actId;
	private String userId;
	private Date actBeginTime;
	private Date actEndTime;
	private Date applyDateLine;
	private String actLabel;
	private String actTitle;
	private String actDesc;
	private String actPic;
	private double actLongitude;
	private double actLatitude;
	private Date publishTime;
	private String contactName;
	private String contactTel;
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
	public Date getActBeginTime() {
		return actBeginTime;
	}
	public void setActBeginTime(Date actBeginTime) {
		this.actBeginTime = actBeginTime;
	}
	public Date getActEndTime() {
		return actEndTime;
	}
	public void setActEndTime(Date actEndTime) {
		this.actEndTime = actEndTime;
	}
	public Date getApplyDateLine() {
		return applyDateLine;
	}
	public void setApplyDateLine(Date applyDateLine) {
		this.applyDateLine = applyDateLine;
	}
	public String getActLabel() {
		return actLabel;
	}
	public void setActLabel(String actLabel) {
		this.actLabel = actLabel;
	}
	public String getActTitle() {
		return actTitle;
	}
	public void setActTitle(String actTitle) {
		this.actTitle = actTitle;
	}
	public String getActDesc() {
		return actDesc;
	}
	public void setActDesc(String actDesc) {
		this.actDesc = actDesc;
	}
	public String getActPic() {
		return actPic;
	}
	public void setActPic(String actPic) {
		this.actPic = actPic;
	}
	public double getActLongitude() {
		return actLongitude;
	}
	public void setActLongitude(double actLongitude) {
		this.actLongitude = actLongitude;
	}
	public double getActLatitude() {
		return actLatitude;
	}
	public void setActLatitude(double actLatitude) {
		this.actLatitude = actLatitude;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	
	
}
