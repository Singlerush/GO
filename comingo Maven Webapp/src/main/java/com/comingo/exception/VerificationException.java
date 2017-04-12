package com.comingo.exception;

import com.comingo.domain.StatusCode;

public class VerificationException {
		//无效的参数 
		//错误码:10003 错误信息：verification failed
		StatusCode sc = new StatusCode(10003, "verification failed");

		public VerificationException(){
		}
		
		public VerificationException(String msg){
			sc.setMsg(msg);
		}
		
		public StatusCode getSc() {
			return sc;
		}
}
