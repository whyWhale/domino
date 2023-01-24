package com.assign.domino.exception.protocal;

import org.springframework.http.HttpStatus;

public interface ErrorModel {
	String getCode();

	String getMessage();

	HttpStatus getStatus();
}