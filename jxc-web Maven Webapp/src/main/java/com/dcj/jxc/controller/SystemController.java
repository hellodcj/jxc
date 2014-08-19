package com.dcj.jxc.controller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcj.basic.model.Pager;
import com.dcj.jxc.model.Custom;
import com.dcj.jxc.model.Material;
import com.dcj.jxc.model.User;
import com.dcj.jxc.model.Vendor;
import com.dcj.jxc.service.ICustomService;
import com.dcj.jxc.service.IMaterialService;
import com.dcj.jxc.service.IUserService;
import com.dcj.jxc.service.IVendorService;


@Controller
@RequestMapping("/system")
public class SystemController {
	
	private IMaterialService matService;
	private IUserService userService;
	private IVendorService vendorService;
	private ICustomService customService;
	
	@Inject
	public void setMatService(IMaterialService matService) {
		this.matService = matService;
	}
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@Inject
	public void setVendorService(IVendorService vendorService) {
		this.vendorService = vendorService;
	}
	@Inject
	public void setCustomService(ICustomService customService) {
		this.customService = customService;
	}
	/**
	 * 用户列表
	 * @param model
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value="/userList")
	public String userList(Model model,@RequestParam(value="pageSize",defaultValue="15") int pageSize,@RequestParam(value="pageNo",defaultValue="1") int pageNo){
		Pager<User> pr = userService.queryUserList(pageSize, pageNo);
		model.addAttribute("pr", pr);
		return "/system/user_list";
		
	}
	
	/**
	 * 添加用户
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user_create")
	public String userCreate(ModelMap model) {
		return "/system/user_add";
	}
	
	/**
	 * 检查是否用户名已经存在
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/check_username", produces = "text/html;charset=UTF-8")
	public @ResponseBody String checkUserNameRepeat(@RequestParam(value="username", defaultValue="") String username) {
		boolean ret = userService.checkUserNameRepeat(username);
		return String.valueOf(!ret);
	}
	
	/**
	 * 新增或者修改用户信息
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/user_saveOrUpdate")
	public String userSaveOrUpdate(User user) throws Exception {
		Integer id = user.getId();
		if (id>0) {
			userService.updateUser(user);
		} else { // save
			userService.addUser(user);
		}
		return "redirect:userList";
	}
	
	/**
	 * 编辑用户
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/user_edit")
	public String userEdit(ModelMap model, @RequestParam(value = "id", defaultValue="-1") int userId) {
		if (userId != -1) {
			User user = userService.loadUser(userId); // 根据id查询用户，返回到页面上,dao里面目前还没有根据id查询的方法，先写死
			model.put("user", user);
		}
		return "/system/user_update";
	}
	
	/**
	 * 物料库存的跳转
	 */
	@RequestMapping(value="/storage_list")
	public String storageList(ModelMap model,@RequestParam(value="pageSize",defaultValue="15") int pageSize,@RequestParam(value="pageNo",defaultValue="1") int pageNo){
		Pager<Material> pr = matService.queryMaterialList(pageSize,pageNo);
		model.addAttribute("pr", pr);
		return "/system/storage_list";
	}
	/**
	 * 物料列表
	 */
	@RequestMapping(value="/material_list")
	public String materialList(ModelMap model,@RequestParam(value="pageSize",defaultValue="15") int pageSize,@RequestParam(value="pageNo",defaultValue="1") int pageNo){
		Pager<Material> pr = matService.queryMaterialList(pageSize,pageNo);
		model.addAttribute("pr", pr);
		return "/system/material_list";
	}
	
	/**
	 * 添加物料的跳转
	 */
	@RequestMapping(value="/material_create")
	public String materialAdd(ModelMap model){
		List<String> categoryList = matService.queryExistMaterialCategory();
		model.put("categoryList", categoryList);
		return "/system/material_create";
	}
	
	/**
	 * 编辑物料的跳转
	 */
	@RequestMapping(value="/material_update")
	public String materialEdit(ModelMap model,@RequestParam(defaultValue="-1",value="materialId") int materialId){
		if (materialId!= -1){
			Material material = matService.loadMaterial(materialId);
			model.put("material", material);
		}
		return "/system/material_update";
	}
	
	/**
	 * 添加或者更新物料信息
	 */
	@RequestMapping(value="/material_saveOrUpdate")
	public String saveOrUpdateMaterial(Material material){
		Integer materialId = material.getId();
		if(materialId>0){
			matService.updateMaterial(material);
		}else{
			matService.saveMaterial(material);
		}
		return "redirect:material_list";
	}
	
	
	/**
	 * 供应商列表
	 */
	@RequestMapping(value="/vendor_list")
	public String vendorList(ModelMap model,@RequestParam(value="pageSize",defaultValue="15") int pageSize,@RequestParam(value="pageNo",defaultValue="1") int pageNo){
		Pager<Vendor> pr = vendorService.queryVendorList(pageSize,pageNo);
		model.addAttribute("pr", pr);
		return "/system/vendor_list";
	}
	
	/**
	 * 添加供应商的跳转
	 */
	@RequestMapping(value="/vendor_create")
	public String vendorAdd(){
		return "/system/vendor_create";
	}
	
	/**
	 * 编辑供应商的跳转
	 */
	@RequestMapping(value="/vendor_update")
	public String vendorEdit(ModelMap model,int vendorId){
		Vendor vendor = vendorService.loadVendor(vendorId);
		model.put("vendor", vendor);
		return "/system/vendor_update";
	}
	
	/**
	 * 添加或者更新供应商信息
	 */
	@RequestMapping(value="/vendor_saveOrUpdate")
	public String saveOrUpdateVendor(Vendor vendor){
		Integer vendorId = vendor.getId();
		if(vendorId>0){
			vendorService.updateVendor(vendor);
		}else{
			vendorService.saveVendor(vendor);
		}
		return "redirect:vendor_list";
	}
	
	/**
	 * 客户列表
	 */
	@RequestMapping(value="/custom_list")
	public String customList(ModelMap model,@RequestParam(value="pageSize",defaultValue="15") int pageSize,@RequestParam(value="pageNo",defaultValue="1") int pageNo){
		Pager<Custom> pr = customService.queryCustomList(pageSize,pageNo);
		model.addAttribute("pr", pr);
		return "/system/custom_list";
	}
	
	/**
	 * 添加客户的跳转
	 */
	@RequestMapping(value="/custom_create")
	public String customAdd(){
		return "/system/custom_create";
	}
	
	/**
	 * 编辑客户的跳转
	 */
	@RequestMapping(value="/custom_update")
	public String customEdit(ModelMap model,int customId){
		Custom custom = customService.loadCustom(customId);
		model.put("custom", custom);
		return "/system/custom_update";
	}
	
	/**
	 * 添加或者更新客户信息
	 */
	@RequestMapping(value="/custom_saveOrUpdate")
	public String saveOrUpdatecustom(Custom custom){
		Integer customId = custom.getId();
		if(customId>0){
			customService.updateCustom(custom);
		}else{
			customService.saveCustom(custom);
		}
		return "redirect:custom_list";
	}
}
