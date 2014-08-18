package com.dcj.jxc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dcj.basic.model.Pager;
import com.dcj.jxc.dao.ICustomDao;
import com.dcj.jxc.model.Custom;
import com.dcj.jxc.model.Material;

@Service("customService")
public class CustomService implements ICustomService {
	private ICustomDao customDao;
	
	@Inject
	public void setCustomDao(ICustomDao customDao) {
		this.customDao = customDao;
	}

	@Override
	public List<Custom> listCustom() {
		String hql = "from Custom";
		return customDao.list(hql);
	}

	@Override
	public Pager<Custom> queryCustomList(int pageSize, int pageNo) {
		String hql = "from Custom";
		Pager<Custom> pr = customDao.find(hql);
		return pr;
	}

	@Override
	public Custom loadCustom(int customId) {
		return customDao.load(customId);
	}

	@Override
	public void saveCustom(Custom custom) {
		customDao.add(custom);
	}

	@Override
	public void updateCustom(Custom custom) {
		customDao.update(custom);
	}

}
