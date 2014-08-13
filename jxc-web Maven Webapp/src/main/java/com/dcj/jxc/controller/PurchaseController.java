package com.dcj.jxc.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dcj.jxc.model.Material;
import com.dcj.jxc.model.Vendor;
import com.dcj.jxc.service.IMaterialService;
import com.dcj.jxc.service.IVendorService;


@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	private IMaterialService matService;
	private IVendorService vendorService;
	
	@Inject
	public void setMatService(IMaterialService matService) {
		this.matService = matService;
	}

	@Inject
	public void setVendorService(IVendorService vendorService) {
		this.vendorService = vendorService;
	}



	/**
	 * 添加采购单的跳转
	 * @return
	 */
	@RequestMapping(value="/add")
	public String add(ModelMap model){
		//1.获得供应商的列表信息
		List<Vendor> vl = vendorService.listVendor();
		//2.获得物料的信息列表
		List<Material> ml = matService.listMaterial();
		//3.将信息放入model
		model.addAttribute("vl", vl);
		model.addAttribute("ml", ml);
		return "/purchase/add";
	}
}
