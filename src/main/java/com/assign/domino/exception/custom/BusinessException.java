package com.assign.domino.exception.custom;

import com.assign.domino.exception.protocal.ErrorModel;

public class BusinessException extends RuntimeException {
	private final ErrorModel errorModel;

	public BusinessException(ErrorModel errorModel, String message) {
		super(message);
		this.errorModel = errorModel;
	}

	public ErrorModel errorModel() {
		return errorModel;
	}

	@Override
	public String toString() {
		return "[BusinessException] " + errorModel;
	}
}
