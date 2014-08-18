package com.dcj.jxc.dao;

import org.springframework.stereotype.Repository;

import com.dcj.basic.dao.BaseDao;
import com.dcj.jxc.model.SaleOrder;

@Repository("saleOrderDao")
public class SaleOrderDao extends BaseDao<SaleOrder> implements ISaleOrderDao {

}
