package com.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springboot.beans.vo.User;
import org.springboot.iservice.user.IUserService;

@Service(version = "1.0.0")
public class IUserServiceImpl implements IUserService {

	@Override
	public User findUser() {
		User user=new User();
		user.setAccount("123456");
		user.setName("张三");
		return null;
	}

	@Override
	public String sayHello(String str) {
		
		return str;
	}

	

   
}
