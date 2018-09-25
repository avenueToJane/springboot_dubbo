package org.springboot.iservice.user;

import org.springboot.beans.vo.User;

/**
 * 
* <p>Title: IUserService </p>
* <p>Description: 通用服务层</p>
* <p>Company: xxx</p> 
* @author Mr.yang
* @date 2018年9月17日 下午3:42:14
 */
public interface IUserService {
	
	User findUser();//查询所有用户信息
	
	String sayHello(String str);

	int addUser(User user);

}
