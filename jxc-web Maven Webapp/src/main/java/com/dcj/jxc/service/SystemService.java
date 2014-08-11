package com.dcj.jxc.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dcj.basic.dao.IBaseDao;
import com.dcj.basic.model.PageResult;
import com.dcj.basic.model.Pager;
import com.dcj.jxc.model.User;

@Service
public class SystemService implements ISystemService {
	private IBaseDao<User> userDao;
	
	@Inject
	public void setUserDao(IBaseDao<User> userDao) {
		this.userDao = userDao;
	}


	@Override
	public Pager<User> queryUserList(int pageSize, int pageNo) {
		String hql = "from User ";
		return userDao.find(hql);
	}


	/**
	 * @return 表中已有返回true；表中没有返回false
	 */
	@Override
	public boolean checkUserNameRepeat(String username) {
		User u = (User) userDao.queryObject("from User u where u.username=?", username);
		if(u!=null) return true;
		return false;
	}


	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}


	@Override
	public void addUser(User user) {
		userDao.add(user);
	}


	@Override
	public User loadUser(int userId) {
		return userDao.load(userId);
	}

}
