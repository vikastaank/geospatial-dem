package com.vt.demo.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vt.demo.core.basic.ResponseConstants;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ValidationException extends GeospatialBusinessException {
	private static final long serialVersionUID = -6670205543401848920L;

	public ValidationException(String message) {
		super(message);
		super.code = ResponseConstants.CONSTRAINT_VIOLATION_MSG;
		super.httpStatus = HttpStatus.PRECONDITION_FAILED.value();
	}

	public ValidationException(String code, String message) {
		super(code, message);
		super.httpStatus = HttpStatus.PRECONDITION_FAILED.value();
	}

	public ValidationException(String code, String message, HttpStatus httpStatus) {
		super(code, message, httpStatus.value());
	}

}