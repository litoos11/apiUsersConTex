package com.litoos11.backUsers.util;

public class RestResponse {

	private Integer code;
	private String message;
	
	public RestResponse(Integer code) {
		super();
		this.code = code;
	}

	public RestResponse(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
