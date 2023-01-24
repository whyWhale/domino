package com.assign.domino.exception.protocal;

import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode implements ErrorModel {
	//COMMON
	FATAL_ERROR("C001", "[fatal] Internal Server error", HttpStatus.INTERNAL_SERVER_ERROR),

	//VALIDATION
	BINDING_ERROR("V001", "Biding error", HttpStatus.BAD_REQUEST),
	CONSTRAINT_VIOLATION("V002", "Validation error", HttpStatus.BAD_REQUEST),
	DATA_INTEGRITY_VIOLATION("V003", "Data integrity violation", HttpStatus.BAD_REQUEST),
	ILLEGAL_ARGUMENT_ERROR("V004", "Argument error", HttpStatus.BAD_REQUEST),

	// BUSINESS
	NOT_FOUND_RESOURCES("NF001", "not found resources", HttpStatus.NOT_FOUND);

	private final String code;
	private final String message;
	private final HttpStatus httpStatus;

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public HttpStatus getStatus() {
		return httpStatus;
	}

}
