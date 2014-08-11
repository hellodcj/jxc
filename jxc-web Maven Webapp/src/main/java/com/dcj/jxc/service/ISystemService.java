package com.dcj.jxc.service;

import com.dcj.basic.model.Pager;
import com.dcj.jxc.model.Material;
import com.dcj.jxc.model.User;

public interface ISystemService {

	Pager<User> queryUserList(int pageSize, int pageNo);

	boolean checkUserNameRepeat(String username);

	void updateUser(User user);

	void addUser(User user);

	User loadUser(int userId);

	Pager<Material> queryMaterialList(int pageSize, int pageNo);

	Material loadMaterial(int materialId);

	void updateMaterial(Material material);

	void saveMaterial(Material material);

}
