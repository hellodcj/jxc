package com.dcj.jxc.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcj.basic.model.Pager;
import com.dcj.jxc.model.Material;
import com.dcj.jxc.model.User;
import com.dcj.jxc.service.ISystemService;


@Controller
@RequestMapping("system")
public class SystemController {
	
	private ISystemService sysService;
	
	
	@Inject
	public void setSysService(ISystemService sysService) {
		this.sysService = sysService;
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
		Pager<User> pr = sysService.queryUserList(pageSize, pageNo);
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
		boolean ret = sysService.checkUserNameRepeat(username);
		return String.valueOf(!ret);
	}
	
	/**
	 * 新增或者修改用户信息
	 * @param request
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user_saveOrUpdate")
	public String userSaveOrUpdate(HttpServletRequest request, ModelMap model, User user) {
		Integer id = user.getId();
		if (id>0) {
			sysService.updateUser(user);
		} else { // save
			sysService.addUser(user);
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
			User user = sysService.loadUser(userId); // 根据id查询用户，返回到页面上,dao里面目前还没有根据id查询的方法，先写死
			model.put("user", user);
		}
		return "/system/user_update";
	}
	
	
	/**
	 * 物料列表
	 */
	@RequestMapping(value="/material_list")
	public String materialList(Model model,@RequestParam(value="pageSize",defaultValue="15") int pageSize,@RequestParam(value="pageNo",defaultValue="1") int pageNo){
		Pager<Material> pr = sysService.queryMaterialList(pageSize,pageNo);
		model.addAttribute("pr", pr);
		return "/system/material_list";
	}
	
	/**
	 * 添加物料的跳转
	 */
	@RequestMapping(value="/material_add")
	public String materialAdd(){
		return "/system/material_add";
	}
	
	/**
	 * 编辑物料的跳转
	 */
	//TODO 试一下requestParam
	@RequestMapping(value="/material_update")
	public String materialEdit(ModelMap model,@RequestParam(defaultValue="-1",value="materialId") int materialId){
		if (materialId!= -1){
			Material material = sysService.loadMaterial(materialId);
			model.put("material", material);
		}
		return "/system/material_update";
	}
	
	/**
	 * 添加或者更新物料信息
	 */
	@RequestMapping(value="/saveOrUpdateMaterial")
	public String saveOrUpdateMaterial(Material material){
		if(material.getId()>0){
			sysService.updateMaterial(material);
		}else{
			sysService.saveMaterial(material);
		}
		return "redirect:material_list";
	}
}
