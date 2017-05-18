package com.comingo.domain;

import java.sql.Timestamp;
import java.util.Date;

public class ActivityVo {
	private String actId;
	private String userId;
	private String publishUsername;
	private Date actBeginTime;
	private Date actEndTime;
	private Date applyDateLine;
	private String actTitle;
	private String actPic;
	private double actLongitude;
	private double actLatitude;
	private String actLocation;
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
	public String getPublishUsername() {
		return publishUsername;
	}
	public void setPublishUsername(String publishUsername) {
		this.publishUsername = publishUsername;
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
	public String getActTitle() {
		return actTitle;
	}
	public void setActTitle(String actTitle) {
		this.actTitle = actTitle;
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
	public String getActLocation() {
		return actLocation;
	}
	public void setActLocation(String actLocation) {
		this.actLocation = actLocation;
	}
	
}
