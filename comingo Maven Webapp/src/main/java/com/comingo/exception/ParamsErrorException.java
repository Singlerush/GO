package com.comingo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.comingo.domain.StatusCode;

public class ParamsErrorException extends Exception {
	StatusCode sc = new StatusCode(10000, "invalid parameters!");

	public StatusCode getSc() {
		return sc;
	}
}
