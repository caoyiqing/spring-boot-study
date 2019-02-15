package com.cyq.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author admin
 *
 */
//@Component
//@EnableScheduling
public class QuartzTask {

	/**
	 * 获取日志信息
	 */
	private Logger logger = LoggerFactory.getLogger(QuartzTask.class);
	

	/**
	 * 
	* @Title: doTask
	* @Description: 定时执行
	* @return void    返回类型
	 */
	@Scheduled(fixedDelay = 1*60*1000)//上次调用结束后,隔#{}分钟执行一次
	public void doTask() {
		//读取ftpserver_path路径中的所有文件
		logger.info("{}执行任务开始....", Thread.currentThread().getName());
		
		try {
			Thread.sleep(80000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("{}执行任务结束....", Thread.currentThread().getName());
	}
	
}