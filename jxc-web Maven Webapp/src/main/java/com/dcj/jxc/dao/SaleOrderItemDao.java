package com.dcj.jxc.dao;

import org.springframework.stereotype.Repository;

import com.dcj.basic.dao.BaseDao;
import com.dcj.jxc.model.SaleOrderItem;

@Repository("saleOrderItemDao")
public class SaleOrderItemDao extends BaseDao<SaleOrderItem> implements
		ISaleOderItemDao {

}
