package com.dcj.jxc.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dcj.basic.model.Pager;
import com.dcj.jxc.dao.IUserDao;
import com.dcj.jxc.model.Material;
import com.dcj.jxc.model.User;

@Service
public class SystemService implements ISystemService {
	private IUserDao userDao;
	
	@Inject
	public void setUserDao(IUserDao userDao) {
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


	@Override
	public Pager<Material> queryMaterialList(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Material loadMaterial(int materialId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateMaterial(Material material) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void saveMaterial(Material material) {
		// TODO Auto-generated method stub
		
	}

}
