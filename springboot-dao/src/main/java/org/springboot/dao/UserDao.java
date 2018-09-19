package org.springboot.dao;

import java.util.List;

import org.springboot.beans.vo.User;

public interface UserDao {
	
	List<User> selectUser();//查询所有用户信息

}
