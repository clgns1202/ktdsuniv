package com.ktdsuniv.admin.user.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.admin.user.service.UserService;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.ClassicPageExplorer;
import common.util.pager.PageExplorer;
import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;


@Controller
public class UserController {

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	/*
	 * 관리자 메인 페이지
	 * 일반회원, 강사, 팀, 프로젝트, 게시판, 호실, 강의 등 불러올 수 있는 리스트는 다 불러와서 최신 3개만 보여 주신 식으로 진행
	 * 관리 기능의 경우 각 리스트별로 분리해서 진행
	 */
	@RequestMapping("/admin/adminMain")
	public ModelAndView viewMainPage(SearchVO search){
		ModelAndView view = new ModelAndView();
		PageListVO userList = userService.getUserList(search);
		PageListVO instructorList = userService.getInstructorList(search);
		view.addObject("userList", userList);
		view.addObject("instructorList", instructorList);
		view.setViewName("adminMain");
		return view;
	}
	
	@RequestMapping("/admin/instructorRegister")
	public ModelAndView viewInstructorRegisterPage() {		
		ModelAndView view = new ModelAndView();
		view.setViewName("/instructor/instructorRegister");
		return view;		
	}
	
	@RequestMapping("/admin/instructorDoRegister")
	public String doInstructorRegister(UsersSchema users, @RequestParam String agency) {
		InstructorsSchema instructors = new InstructorsSchema();
		instructors.setAgency(agency);
		instructors.setUser(users);
		
		userService.addInstructor(instructors);
		return "redirect:/admin/adminMain";
	}
	
	@RequestMapping("/admin/adminRegister")
	public ModelAndView viewAdminRegisterPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/admin/adminRegister");
		return view;
	}
	
	@RequestMapping("/admin/adminDoRegister")
	public String doAdminRegister(UsersSchema users, @RequestParam String department, @RequestParam String position) {
		AdminsSchema admins = new AdminsSchema();
		admins.setDepartment(department);
		admins.setPosition(position);
		admins.setUser(users);
		
		userService.addAdmin(admins);
		return "redirect:/adminMain";
	}
	
	@RequestMapping("/admin/adminSignIn")
	public ModelAndView viewSignInPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/admin/adminSignIn");
		return view;
	}
	
	@RequestMapping("/admin/doAdminSignIn")
	public String doSignInAction(UsersSchema user, HttpSession session) {
		userService.adminSignIn(user, session);
		return "redirect:/admin/adminMain";
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

	@RequestMapping("/admin/adminSignOut")
	public String doSignOutAction(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/adminSignIn";
	}
}
