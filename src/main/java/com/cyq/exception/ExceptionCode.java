package com.cyq.exception;

public enum ExceptionCode {
	
	/** 没有登陆*/
	NO_LOGIN(-200, "没有登陆"),

	/** 发生异常*/
	EXCEPTION(-400, "发生异常");

	private Integer code;
	private String message;

	ExceptionCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public final Integer getCode() {
		return this.code;
	}

	public final String getMessage() {
		return this.message;
	}
	
}
