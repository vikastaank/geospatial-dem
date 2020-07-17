package com.vt.demo.core.basic;

public class Response<T> {
	private T result;
	private String status;
	private int statusCode;
	private String statusMsg;

	public Response() {
	}

	public Response(T t) {
		setResult(t);
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
		this.statusCode = ResponseConstants.HTTP_STATUS_SUCCESS_CODE;
		this.statusMsg = ResponseConstants.SUCCESS_MSG;
	}

	public Response(T result, String status, int statusCode, String statusMsg) {
		super();
		this.result = result;
		this.status = status;
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

}
