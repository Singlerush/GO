package com.comingo.domain;

public class StatusCode {
	private int errorcode;	//·µ»Ø´íÎóÂë
	private String msg;		//´íÎóÐÅÏ¢
	
	public StatusCode(int errorcode, String msg) {
		this.errorcode = errorcode;
		this.msg = msg;
	}
	
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
