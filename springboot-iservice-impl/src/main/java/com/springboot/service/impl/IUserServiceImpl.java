package com.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.springboot.dao.UserMapper;

import org.apache.log4j.Logger;
import org.springboot.beans.vo.User;

import org.springboot.iservice.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class IUserServiceImpl implements IUserService {
	
	//在使用到的类中声明log以及输出log信息。
	private static Logger logger=Logger.getLogger(IUserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;
	@Override
	public User findUser() {
		User user=userMapper.selectUser().get(0);
		logger.info("core层的日志信息"+user);
		return user;
	}
	@Override
	public String sayHello(String str) {
		
		return str;
	}
}
