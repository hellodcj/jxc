package com.dcj.jxc.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dcj.basic.model.Pager;
import com.dcj.jxc.dao.IMaterialDao;
import com.dcj.jxc.dao.IUserDao;
import com.dcj.jxc.model.Material;
import com.dcj.jxc.model.User;

@Service
public class SystemService implements ISystemService {
	private IUserDao userDao;
	private IMaterialDao materialDao;
	
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	@Inject
	public void setMaterialDao(IMaterialDao materialDao) {
		this.materialDao = materialDao;
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
		String hql = "from Material";
		Pager<Material> pr = materialDao.find(hql);
		return pr;
	}


	@Override
	public Material loadMaterial(int materialId) {
		return materialDao.load(materialId);
	}


	@Override
	public void updateMaterial(Material material) {
		materialDao.update(material);
	}


	@Override
	public void saveMaterial(Material material) {
		materialDao.add(material);
	}

	@Override
	public List<String> queryExistMaterialCategory() {
		List<Material> ml = materialDao.list("from Material");
		//用来存放，物料中不同的类别
		List<String> sl = new ArrayList<String>();
		for (Material m :ml){
			if (sl.contains(m.getCategory())) continue;
			sl.add(m.getCategory());
		}
		return sl;
	}

}
