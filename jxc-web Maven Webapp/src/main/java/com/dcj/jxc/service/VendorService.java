package com.dcj.jxc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dcj.basic.model.Pager;
import com.dcj.jxc.dao.IVendorDao;
import com.dcj.jxc.model.Material;
import com.dcj.jxc.model.Vendor;

@Service("vendorService")
public class VendorService implements IVendorService {
	private IVendorDao vendorDao ;
	
	@Inject
	public void setVendorDao(IVendorDao vendorDao) {
		this.vendorDao = vendorDao;
	}

	@Override
	public List<Vendor> listVendor() {
		return vendorDao.list("from Vendor");
	}


	@Override
	public Pager<Vendor> queryVendorList(int pageSize, int pageNo) {
		String hql = "from Vendor";
		Pager<Vendor> pr = vendorDao.find(hql);
		return pr;
	}


	@Override
	public Vendor loadVendor(int vendorId) {
		return vendorDao.load(vendorId);
	}


	@Override
	public void updateVendor(Vendor vendor) {
		vendorDao.update(vendor);
	}


	@Override
	public void saveVendor(Vendor vendor) {
		vendorDao.add(vendor);
	}

}
