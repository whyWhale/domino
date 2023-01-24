package com.assign.domino.exception.custom;

import com.assign.domino.exception.protocal.ErrorCode;

public class NotFoundResourceException extends BusinessException {

	public NotFoundResourceException(String message) {
		super(ErrorCode.NOT_FOUND_RESOURCES, message);
	}
}
