package com.dcj.jxc.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcj.dto.PurchaseDto;
import com.dcj.jxc.model.Material;
import com.dcj.jxc.model.Vendor;
import com.dcj.jxc.service.IMaterialService;
import com.dcj.jxc.service.IPurchaseService;
import com.dcj.jxc.service.IVendorService;


@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	private IMaterialService matService;
	private IVendorService vendorService;
	private IPurchaseService purchaseService;
	
	@Inject
	public void setMatService(IMaterialService matService) {
		this.matService = matService;
	}

	@Inject
	public void setVendorService(IVendorService vendorService) {
		this.vendorService = vendorService;
	}

	@Inject
	public void setPurchaseService(IPurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	/**
	 * 添加采购单的跳转
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
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
	
	/**
	 * 提交表单，添加采购单
	 * @return
	 */
	//public String save(ModelMap model,PurchaseDto dto){
	@RequestMapping(value="/adds",method=RequestMethod.POST)
	public String saves(PurchaseDto dto){
		//TODO 模拟一个dto
		/*int vendor_id = 1;
		Integer num[]={2,3};
		Integer m_id[]={1,2};
		Float price[]={2.1f,2.3f};
		Date orderDate = new Date();
		dto.setM_id(m_id);
		dto.setNum(num);
		dto.setOrderDate(orderDate);
		dto.setPrice(price);
		dto.setVendor_id(vendor_id);*/
	System.out.println("==========");	
		
		//purchaseService.savePurchase(dto);
		return "/purchase/add";
	}
}
