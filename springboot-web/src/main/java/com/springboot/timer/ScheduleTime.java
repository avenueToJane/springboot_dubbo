package com.springboot.timer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.springboot.controller.UserController;

/**
 * 
* <p>Title: ScheduleTime </p>
* <p>Description: 定时器类</p>
* <p>Company: xxx</p> 
* @author Mr.yang
* @date 2018年9月28日 下午4:49:47
 */
@Component
@Configurable
@EnableScheduling
public class ScheduleTime {
	
	// 在使用到的类中声明log以及输出log信息。
		private static Logger logger = Logger.getLogger(UserController.class);
	
	// 每整5分钟执行一次
	@Scheduled(cron = "0 0/5 * * * ? ")
	public void test01() {
		logger.info("每5分钟执行一次");
	}

	/**
	 * 每个整点执行一次
	 */
	@Scheduled(cron = "0 0 0/1 * * ? ")
	public void test02() {
		logger.info("每个整点执行一次");
		
	}

	/**
	 * 每天晚上23点59分59秒执行一次
	 */
	@Scheduled(cron = "59 59 23 * * ?")
	public void test03() {
		logger.info("每天晚上23点59分59秒执行一次");
		
	}

}
