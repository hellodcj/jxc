package com.dcj.jxc.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dcj.basic.dao.BaseDao;
import com.dcj.basic.dao.IBaseDao;
import com.dcj.basic.model.Pager;
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
	public void addUser(User user) throws Exception {
		//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date createDate = sdf.parse(sdf.format(new Date()));
		user.setCreateDate(createDate);
		userDao.add(user);
	}


	@Override
	public User loadUser(int userId) {
		return userDao.load(userId);
	}
}
