package com.dcj.jxc.service;

import java.util.List;

import com.dcj.basic.model.Pager;
import com.dcj.jxc.model.Vendor;


public interface IVendorService {

	List<Vendor> listVendor();

	Pager<Vendor> queryVendorList(int pageSize, int pageNo);

	Vendor loadVendor(int vendorId);

	void updateVendor(Vendor vendor);

	void saveVendor(Vendor vendor);

}
