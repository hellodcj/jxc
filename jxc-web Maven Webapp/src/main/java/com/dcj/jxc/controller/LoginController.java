package com.dcj.jxc.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcj.jxc.model.User;
import com.dcj.jxc.service.IUserService;

@Controller
public class LoginController {
	
	private IUserService userService;
	
	
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "/admin/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,Model model,HttpSession session) {
		//1.到userservice获取用户
		User u = userService.loadUser(username,password);
		//2.如果有用户信息，跳转到首页，将用户信息存入session
		if (u!=null){
			session.setAttribute("user", u);
			return "/admin/index";
		}
		//3.没有用户信息，跳转到登陆页面
		model.addAttribute("error", "用户名密码错误！");
		return "/admin/login";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "/admin/login";
	}
}
