package com.dcj.jxc.dao;

import org.springframework.stereotype.Repository;

import com.dcj.basic.dao.BaseDao;
import com.dcj.jxc.model.PurchaseOrder;

@Repository("purchaseOrderDao")
public class PurchaseOrderDao extends BaseDao<PurchaseOrder> implements IPurchaseOrderDao {

}
