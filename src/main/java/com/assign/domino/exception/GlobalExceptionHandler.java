package com.assign.domino.exception;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.assign.domino.exception.custom.BusinessException;
import com.assign.domino.exception.protocal.ErrorCode;
import com.assign.domino.exception.protocal.ErrorModel;
import com.assign.domino.exception.protocal.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse<ErrorModel>> handleBusinessException(BusinessException e) {
		log.error("Business exception occurred : {}", e.toString(), e);

		return createResponse(e.errorModel());
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponse<ErrorModel>> handleDataIntegrityViolationException(
		DataIntegrityViolationException e) {
		log.warn("DataIntegrityViolation exception occurred : {}", e.toString(), e);

		return createResponse(ErrorCode.DATA_INTEGRITY_VIOLATION);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse<ErrorModel>> handleConstraintViolation(ConstraintViolationException e) {
		log.warn("Constraint violation exception occurred: {}", e.toString(), e);

		return createResponse(ErrorCode.CONSTRAINT_VIOLATION);
	}

	@ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
	public ResponseEntity<ErrorResponse<ErrorModel>> handleBindException(BindException e) {
		log.warn("parameter binding exception occurred: {}", e.toString(), e);

		return createResponse(ErrorCode.BINDING_ERROR);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorResponse<ErrorModel>> handleConversionException(MethodArgumentTypeMismatchException e) {
		log.warn("argument exception occurred: {}", e.toString(), e);

		return createResponse(ErrorCode.ILLEGAL_ARGUMENT_ERROR);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse<ErrorModel>> handleInternalException(RuntimeException e) {
		log.warn("internal server error occurred: {}", e.toString(), e);

		return createResponse(ErrorCode.FATAL_ERROR);
	}

	private ResponseEntity<ErrorResponse<ErrorModel>> createResponse(ErrorModel errorCode) {
		ErrorResponse<ErrorModel> errorResponse = new ErrorResponse<>(errorCode);

		return new ResponseEntity<>(errorResponse, errorCode.getStatus());
	}
}
