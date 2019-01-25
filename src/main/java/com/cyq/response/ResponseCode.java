package com.cyq.response;

public enum ResponseCode {

	/** 通用 返回成功*/
	SUCCESS(200, "操作成功"),
	
	/** 通用 操作失败*/
	FAIL(-200, "操作失败"),

	/** 发生异常*/
	EXCEPTION(-400, "发生异常");

	private Integer code;
	private String message;

	ResponseCode(Integer code, String message) {
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
