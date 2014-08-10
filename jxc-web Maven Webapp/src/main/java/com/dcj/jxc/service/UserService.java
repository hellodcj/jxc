package com.dcj.jxc.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dcj.basic.dao.BaseDao;
import com.dcj.basic.dao.IBaseDao;
import com.dcj.jxc.model.User;

@Service(value="userService")
public class UserService implements IUserService {
	private IBaseDao<User> userDao;
	
	@Inject
	public void setUserDao(IBaseDao<User> userDao) {
		this.userDao = userDao;
	}

	public IBaseDao<User> getUserDao() {
		return userDao;
	}

	@Override
	public User loadUser(String username, String password) {
		String hql = "from User u where u.username=? and u.password=?";
		Object[] param = new Object[]{username,password};
		return (User) userDao.queryObject(hql, param);
	}

}
