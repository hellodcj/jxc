package com.dcj.jxc.dao;

import org.springframework.stereotype.Repository;

import com.dcj.basic.dao.BaseDao;
import com.dcj.jxc.model.Material;

@Repository("materialDao")
public class MaterialDao extends BaseDao<Material> implements IMaterialDao {


}
