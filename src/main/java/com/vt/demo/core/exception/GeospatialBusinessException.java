package com.vt.demo.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vt.demo.core.basic.ResponseConstants;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class GeospatialBusinessException extends RuntimeException {
	private static final long serialVersionUID = -2672657322204353866L;

	protected String code;
	protected int httpStatus;

	public GeospatialBusinessException(String code, String message) {
		super(message);
		this.code = code;
	}

	public GeospatialBusinessException(String code, String message, int httpStatus) {
		super(message);
		this.code = code;
		this.httpStatus = httpStatus;
	}

	public GeospatialBusinessException(String message) {
		super(message);
		this.code = ResponseConstants.INTERNAL_SERVER_ERROR_MSG;
		this.httpStatus = ResponseConstants.HTTP_STATUS_INTERNAL_SERVER_ERROR_CODE.intValue();
	}

	public GeospatialBusinessException(String message, Throwable cause) {
		super(message, cause);
		this.code = ResponseConstants.INTERNAL_SERVER_ERROR_MSG;
		this.httpStatus = ResponseConstants.HTTP_STATUS_INTERNAL_SERVER_ERROR_CODE.intValue();
	}

	public GeospatialBusinessException() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
}
