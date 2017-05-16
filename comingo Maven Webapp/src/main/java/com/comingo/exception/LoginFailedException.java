package com.comingo.exception;

import com.comingo.domain.StatusCode;

public class LoginFailedException extends Exception {
	//查询失败
	//错误码:10004  错误信息：query failed
	StatusCode sc = new StatusCode(10004, "login failed");

	public LoginFailedException(){
	}
	
	public LoginFailedException(String msg){
		sc.setMsg(msg);
	}
	
	public StatusCode getSc() {
		return sc;
	}
}
