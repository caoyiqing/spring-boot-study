package com.cyq.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;

/**
 * 重试的AOP切面
 * @author admin
 *
 */
@Configuration
@Aspect
@EnableAspectJAutoProxy
public class RetryAspect implements Ordered {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 最多再尝试多少次
	 */
	private static final int DEFAULT_MAX_RETRIES = 2;

    private int maxRetries = DEFAULT_MAX_RETRIES;
    private int order = 1;

	public void setMaxRetries(int maxRetries) {
		this.maxRetries = maxRetries;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	@Around("@annotation(idempotentRetry)")
	public Object doConcurrentOperation(ProceedingJoinPoint pjp, IdempotentRetry idempotentRetry) throws Throwable {
		int numAttempts = 0;
		Exception exception;
		do {
			numAttempts++;
			logger.info("{} 尝试第{}次", pjp.toString(), numAttempts);
			try {
				return pjp.proceed();
			} catch (Exception ex) {
				exception = ex;
			}
		} while (numAttempts <= this.maxRetries);
		logger.info("{} 尝试{}次均失败, 抛出异常", pjp.toString(), numAttempts);
		throw exception;
	}

	@Override
	public int getOrder() {
		return this.order;
	}

}
