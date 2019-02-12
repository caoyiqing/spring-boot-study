package com.cyq.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.cyq.response.Response;

@Configuration
@Aspect
@EnableAspectJAutoProxy
public class ResponseAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Pointcut("execution(* com.cyq.controller..*.*(..))")
	public void pointcut() {

	}
	
	@Around("pointcut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("{} Around start", pjp.getSignature().toString());
		Object object = pjp.proceed();
		logger.info("{} Around end", pjp.getSignature().toString());
		return new Response<Object>(object);
	}
	
}
