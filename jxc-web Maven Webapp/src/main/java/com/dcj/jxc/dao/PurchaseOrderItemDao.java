package com.dcj.jxc.dao;

import org.springframework.stereotype.Repository;

import com.dcj.basic.dao.BaseDao;
import com.dcj.jxc.model.PurchaseOrderItem;

@Repository("purchaseOrderItemDao")
public class PurchaseOrderItemDao extends BaseDao<PurchaseOrderItem> implements
		IPurchaseOderItemDao {

}
