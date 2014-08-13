package com.dcj.jxc.dao;

import org.springframework.stereotype.Repository;

import com.dcj.basic.dao.BaseDao;
import com.dcj.jxc.model.Vendor;

@Repository("vendorDao")
public class VendorDao extends BaseDao<Vendor> implements IVendorDao {

}
