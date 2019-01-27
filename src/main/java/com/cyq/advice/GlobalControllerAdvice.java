package com.cyq.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyq.exception.CustomException;
import com.cyq.response.Response;
import com.cyq.response.ResponseCode;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
    public Response<Object> exceptionHandler(HttpServletRequest request, Exception e) {
		Response<Object> response = new Response<>();
		response.setCode(ResponseCode.EXCEPTION.getCode());
		response.setMsg(e.toString());
        return response;
    }
	
	@ExceptionHandler(value = CustomException.class)
	@ResponseBody
    public Response<Object> customExceptionHandler(HttpServletRequest request, CustomException e) {
		Response<Object> response = new Response<>();
		response.setCode(e.getCode());
		response.setMsg(e.getMsg());
        return response;
    }
	
//	@ExceptionHandler(value = Exception.class)
//    public String viewExceptionHandler(HttpServletRequest request, Exception e) {
//		Response<Object> response = new Response<>();
//		response.setCode(ResponseCode.EXCEPTION);
//		response.setMsg(e.toString());
//		
//        return "error";
//    }
	
	
}
