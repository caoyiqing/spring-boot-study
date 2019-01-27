package com.cyq.exception;

public class CustomException extends RuntimeException {
	
	private ExceptionCode exceptionCode;

	/**
	 * 
	 */
	private static final long serialVersionUID = 4671180560687074587L;
	
	public CustomException(ExceptionCode exceptionCode) {
		this.exceptionCode = exceptionCode;
		this.code = exceptionCode.getCode();
		this.msg = exceptionCode.getMessage();
	}

	private Integer code;
	
	private String msg;

	public ExceptionCode getExceptionCode() {
		return exceptionCode;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return "CustomException [exceptionCode=" + exceptionCode + ", code=" + code + ", msg=" + msg + "]";
	}
	
}
