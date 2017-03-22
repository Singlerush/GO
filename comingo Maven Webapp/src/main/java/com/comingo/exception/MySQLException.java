package com.comingo.exception;

import com.comingo.domain.StatusCode;

public class MySQLException extends Exception {
		//无效的参数 
		//错误码:10000 错误信息：invalid parameters
		StatusCode sc = new StatusCode(10001, "database error");

		public MySQLException(){
		}
		
		public MySQLException(String msg){
			sc.setMsg(msg);
		}
		
		public StatusCode getSc() {
			return sc;
		}
}
