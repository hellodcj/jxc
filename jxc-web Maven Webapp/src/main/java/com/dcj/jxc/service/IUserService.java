package com.dcj.jxc.service;

import com.dcj.jxc.model.User;

public interface IUserService {

	/**
	 * 更具username，password获取
	 * @param username
	 * @param password
	 * @return
	 */
	User loadUser(String username, String password);
	
}
