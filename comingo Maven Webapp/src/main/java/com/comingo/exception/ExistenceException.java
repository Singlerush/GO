package com.comingo.exception;

import com.comingo.domain.StatusCode;

public class ExistenceException extends Exception {
	// 查询失败
	// 错误码:10009 错误信息：Already Existence
	StatusCode sc = new StatusCode(10009, "Already Existence");

	public ExistenceException() {
	}

	public ExistenceException(String msg) {
		sc.setMsg(msg);
	}

	public StatusCode getSc() {
		return sc;
	}
}
