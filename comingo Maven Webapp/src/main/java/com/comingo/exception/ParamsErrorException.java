package com.comingo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.comingo.domain.StatusCode;

public class ParamsErrorException extends Exception {
	//无效的参数 
	//错误码:10000 错误信息：invalid parameters
	StatusCode sc = new StatusCode(10000, "invalid parameters");

	public ParamsErrorException(){
	}
	
	public ParamsErrorException(String msg){
		sc.setMsg(msg);
	}
	
	public StatusCode getSc() {
		return sc;
	}
}
