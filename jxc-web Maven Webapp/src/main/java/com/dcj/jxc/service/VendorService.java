package com.dcj.jxc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dcj.jxc.dao.IVendorDao;
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

}
