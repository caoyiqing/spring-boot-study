package com.cyq.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.cyq.response.Response;

@Configuration
@Aspect
@EnableAspectJAutoProxy
public class HandleAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Around("target(com.cyq.handle.MessageHandler)")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("{} Around start", pjp.getSignature().toString());
		Object object = pjp.proceed();
		logger.info("{} Around end", pjp.getSignature().toString());
		return new Response<Object>(object);
	}

}
