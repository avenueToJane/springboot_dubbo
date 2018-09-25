package com.springboot.dao;

import java.util.List;

import org.springboot.beans.vo.User;

public interface UserMapper {
	
	List<User> selectUser();//查询所有用户信息

	int addUser(User user);

}
