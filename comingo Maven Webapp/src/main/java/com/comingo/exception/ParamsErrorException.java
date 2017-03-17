package com.comingo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="invalid paramters")
public class ParamsErrorException extends Exception {
	
}
