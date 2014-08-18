package com.dcj.jxc.dao;


import org.springframework.stereotype.Repository;

import com.dcj.basic.dao.BaseDao;
import com.dcj.jxc.model.Custom;
import com.dcj.jxc.dao.ICustomDao;

@Repository("customDao")
public class CustomDao extends BaseDao<Custom> implements ICustomDao {

}
