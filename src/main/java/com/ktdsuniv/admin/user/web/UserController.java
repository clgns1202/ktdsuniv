package com.ktdsuniv.admin.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktdsuniv.admin.user.service.UserService;

@Controller
public class UserController {

	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/test")
	public String test(){
		return "/test";
	}
	
}
