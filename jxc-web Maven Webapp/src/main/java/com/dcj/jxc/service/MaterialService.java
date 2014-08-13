package com.dcj.jxc.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dcj.basic.model.Pager;
import com.dcj.jxc.dao.IMaterialDao;
import com.dcj.jxc.dao.IUserDao;
import com.dcj.jxc.model.Material;

@Service("materialService")
public class MaterialService implements IMaterialService {
	private IMaterialDao materialDao;
	
	@Inject
	public void setMaterialDao(IMaterialDao materialDao) {
		this.materialDao = materialDao;
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

	@Override
	public List<Material> listMaterial() {
		List<Material> lm = materialDao.list("from Material");
		return lm;
	}
}
