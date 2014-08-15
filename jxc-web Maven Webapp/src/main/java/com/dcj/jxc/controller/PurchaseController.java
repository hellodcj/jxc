package com.dcj.jxc.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcj.dto.PurchaseDto;
import com.dcj.jxc.model.Material;
import com.dcj.jxc.model.PurchaseOrder;
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
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saves(PurchaseDto dto){
		purchaseService.savePurchase(dto);
		return "redirect:/purchase/add";
	}
	
	/**
	 * 按月进行历史采购的跳转
	 * @return
	 */
	@RequestMapping(value="/listByMonth",method=RequestMethod.GET)
	public String listByMonthPage(){
		return "/purchase/list";
	}
	
	/**
	 * 按月进行历史采购的列表显示
	 */
	@RequestMapping(value="/listByMonth",method=RequestMethod.POST)
	public String listByMonth(String month,ModelMap model){
		List<PurchaseOrder> pol = purchaseService.listByMonth(month);
		model.addAttribute("pol", pol);
		return "/purchase/list";
	}
}
