package com.cyq;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cyq.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTest1 {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@Test
	public void contextLoads() {
		// 级别由低到高 trace<debug<info<warn<error
        logger.trace("这是一个trace日志...");
        logger.debug("这是一个debug日志...");
        // SpringBoot默认是info级别，只会输出info及以上级别的日志
        logger.info("这是一个info日志...");
        logger.warn("这是一个warn日志...");
        logger.error("这是一个error日志...");
		Map<String, Object> user = userService.getUser("1");
		System.out.println(user);
	}

}
