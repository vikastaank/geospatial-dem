package com.vt.demo.core.basic;

import org.springframework.http.HttpStatus;

public class ResponseConstants {
	public static final Integer HTTP_STATUS_SUCCESS_CODE = HttpStatus.OK.value();
	public static final Integer HTTP_STATUS_FAILURE_CODE = HttpStatus.BAD_REQUEST.value();
	public static final Integer HTTP_STATUS_INTERNAL_SERVER_ERROR_CODE = HttpStatus.INTERNAL_SERVER_ERROR.value();
	public static final Integer HTTP_STATUS_CONSTRAINT_VIOLATION_CODE = HttpStatus.PRECONDITION_FAILED.value();

	public static final String SUCCESS_MSG = "done.sucess";
	public static final String FAILURE_MSG = "error.failure";
	public static final String INTERNAL_SERVER_ERROR_MSG = "internal.server.error";
	public static final String CONSTRAINT_VIOLATION_MSG = "constraint.violation";
}
