package com.cyq.advice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	/**
	 * 
	* @Title: methodArgumentNotValidExceptionHandler
	* @Description: 处理请求对象属性不满足校验规则的异常信息
	* @param request
	* @param exception
	* @return Response<Object>    返回类型
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public Response<Object> methodArgumentNotValidExceptionHandler(HttpServletRequest request,
			MethodArgumentNotValidException exception) {
		BindingResult result = exception.getBindingResult();
		final List<FieldError> fieldErrors = result.getFieldErrors();
		StringBuilder builder = new StringBuilder();

		for (FieldError error : fieldErrors) {
			builder.append(error.getDefaultMessage() + "\n");
		}
		return new Response<>(ResponseCode.EXCEPTION.getCode(), builder.toString());
	}
	
	/**
	 * 
	* @Title: constraintViolationExceptionHandler
	* @Description: 处理请求单个参数不满足校验规则的异常信息
	* @param request
	* @param exception
	* @return Response<Object>    返回类型
	 */
	@ExceptionHandler(value = ConstraintViolationException.class)
	public Response<Object> constraintViolationExceptionHandler(HttpServletRequest request,
			ConstraintViolationException exception) {
		return new Response<>(ResponseCode.EXCEPTION.getCode(), exception.getMessage());
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
