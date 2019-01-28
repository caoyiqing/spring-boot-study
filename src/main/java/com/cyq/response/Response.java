package com.cyq.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5061669293595276510L;
	
	private T data;
	
	private Integer code;
	
	private String msg;
	
	private boolean status;
	
	public Response() {
		super();
	}
	
	public Response(T data) {
		this.data = data;
		this.code = ResponseCode.SUCCESS.getCode();
		this.msg = ResponseCode.SUCCESS.getMessage();
	}
	
	public Response(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Response(T data, Integer code, String msg) {
		this.data = data;
		this.code = code;
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
