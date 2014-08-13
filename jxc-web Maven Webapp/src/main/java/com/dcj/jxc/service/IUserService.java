package com.dcj.jxc.service;

import com.dcj.basic.model.Pager;
import com.dcj.jxc.model.User;

public interface IUserService {

	/**
	 * 更具username，password获取
	 * @param username
	 * @param password
	 * @return
	 */
	User loadUser(String username, String password);
	
	Pager<User> queryUserList(int pageSize, int pageNo);

	boolean checkUserNameRepeat(String username);

	void updateUser(User user);

	void addUser(User user) throws Exception;

	User loadUser(int userId);
}
