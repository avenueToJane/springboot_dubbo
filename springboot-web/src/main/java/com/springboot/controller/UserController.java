package com.springboot.controller;
import com.alibaba.dubbo.config.annotation.Reference;

import org.springboot.beans.vo.User;
import org.springboot.iservice.user.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    @Reference(version = "1.0.0")
    private IUserService iUserService;

    @GetMapping("hello")
    public String hello() {
        return iUserService.sayHello("Hello springboot and dubbo!");
    }

    @GetMapping("user")
    public User user() {
        return iUserService.findUser();
    }
}
