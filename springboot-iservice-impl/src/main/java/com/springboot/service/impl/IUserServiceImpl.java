package com.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.springboot.dao.UserMapper;

import org.springboot.beans.vo.User;

import org.springboot.iservice.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class IUserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User findUser() {	
		return userMapper.selectUser().get(0);
	}
	@Override
	public String sayHello(String str) {
		
		return str;
	}
}
