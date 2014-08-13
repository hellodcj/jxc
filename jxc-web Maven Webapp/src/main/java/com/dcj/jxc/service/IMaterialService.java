package com.dcj.jxc.service;

import java.util.List;

import com.dcj.basic.model.Pager;
import com.dcj.jxc.model.Material;

public interface IMaterialService {
	Pager<Material> queryMaterialList(int pageSize, int pageNo);

	Material loadMaterial(int materialId);

	void updateMaterial(Material material);

	void saveMaterial(Material material);

	List<String> queryExistMaterialCategory();

	List<Material> listMaterial();
}
