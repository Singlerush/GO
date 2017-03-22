package com.comingo.exception;

import com.comingo.domain.StatusCode;

public class QueryFailedException extends Exception {
		//查询失败
		//错误码:10002  错误信息：query failed
		StatusCode sc = new StatusCode(10002, "query failed");

		public QueryFailedException(){
		}
		
		public QueryFailedException(String msg){
			sc.setMsg(msg);
		}
		
		public StatusCode getSc() {
			return sc;
		}
}
