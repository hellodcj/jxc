package com.dcj.jxc.dao;

import org.springframework.stereotype.Repository;

import com.dcj.basic.dao.BaseDao;
import com.dcj.basic.dao.IBaseDao;
import com.dcj.jxc.model.Custom;

@Repository("customDao")
public class CustomDao extends BaseDao<Custom> implements IBaseDao<Custom> {

}
