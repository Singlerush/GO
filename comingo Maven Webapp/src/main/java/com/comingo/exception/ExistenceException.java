package com.comingo.exception;

import com.comingo.domain.StatusCode;

public class ExistenceException extends Exception {
	// 查询失败
	// 错误码:10002 错误信息：query failed
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
