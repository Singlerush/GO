package com.comingo.domain;

public class StatusCode {
	private int statuscode;	
	private String msg;		
	
	public StatusCode(int statuscode, String msg) {
		this.statuscode = statuscode;
		this.msg = msg;
	}
	
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
