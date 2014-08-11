package com.dcj.jxc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcj.basic.model.PageResult;
import com.dcj.basic.model.Pager;
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


	@RequestMapping(value="/userList")
	public String userList(Model model,@RequestParam(value="pageSize",defaultValue="15") int pageSize,@RequestParam(value="pageNo",defaultValue="1") int pageNo){
		Pager<User> pr = sysService.queryUserList(pageSize, pageNo);
		model.addAttribute("pr", pr);
		return "/system/user_list";
		
	}
	
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
	
	@RequestMapping(value = "/user_saveOrupdate")
	public String userSaveOrUpdate(HttpServletRequest request, ModelMap model, User user) {
		Integer id = user.getId();
		if (id>0) {
			sysService.updateUser(user);
		} else { // save
			sysService.addUser(user);
		}
		return "redirect:userList";
	}
	
	@RequestMapping(value = "/user_edit")
	public String userEdit(ModelMap model, @RequestParam(value = "id", defaultValue="-1") int userId) {
		if (userId != -1) {
			User user = sysService.loadUser(userId); // 根据id查询用户，返回到页面上,dao里面目前还没有根据id查询的方法，先写死
			model.put("user", user);
		}
		return "/system/user_update";
	}
}
