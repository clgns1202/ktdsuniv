package com.ktdsuniv.admin.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.admin.user.service.UserService;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.ClassicPageExplorer;
import common.util.pager.PageExplorer;

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
	
	@RequestMapping("/user/list")
	public ModelAndView viewUserList(SearchVO search){
		ModelAndView view = new ModelAndView();
		PageListVO userList = userService.getUserList(search);
		PageExplorer pageExplorer = new ClassicPageExplorer(userList.getPager());
		String pager = pageExplorer.getPagingList("pageNumber", "[@]", "<<", ">>", "searchForm");
		view.addObject("paging", pager);
		view.addObject("userList", userList);
		view.setViewName("user/list");
		return view;
	}
	
	@RequestMapping("/instructor/list")
	public ModelAndView viewInstructorList(SearchVO search){
		ModelAndView view = new ModelAndView();
		PageListVO instructorList = userService.getInstructorList(search);
		PageExplorer pageExplorer = new ClassicPageExplorer(instructorList.getPager());
		String pager = pageExplorer.getPagingList("pageNumber", "[@]", "<<", ">>", "searchForm");
		view.addObject("paging", pager);
		view.addObject("instructorList", instructorList);
		view.setViewName("instructor/list");
		return view;
	}
