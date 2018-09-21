package com.springboot.controller;
import com.alibaba.dubbo.config.annotation.Reference;

import org.apache.log4j.Logger;
import org.springboot.beans.vo.User;
import org.springboot.iservice.user.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
	//在使用到的类中声明log以及输出log信息。
	private static Logger logger=Logger.getLogger(UserController.class);
	
    @Reference(version = "1.0.0")
    private IUserService iUserService;

    @GetMapping("hello")
    public String hello() {
        return iUserService.sayHello("Hello springboot and dubbo!");
    }

    @GetMapping("user")
    public User user() {
    	User user=iUserService.findUser();
    	logger.info("用户的信息"+user);
        return user;
    }
}
