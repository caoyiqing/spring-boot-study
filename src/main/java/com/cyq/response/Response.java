package com.cyq.response;

import java.io.Serializable;

public class Response<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5061669293595276510L;
	
	private T result;
	
	private String msg;
	
	private Integer code;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
}
