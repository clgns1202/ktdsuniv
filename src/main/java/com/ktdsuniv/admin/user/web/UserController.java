package com.ktdsuniv.admin.user.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.admin.user.service.UserService;

import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

@Controller
public class UserController {

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/admin/adminMain")
	public String test(){
		return "/adminMain";
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
		return "redirect:/admin/adminMain";
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
	
	@RequestMapping("/admin/adminSignOut")
	public String doSignOutAction(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/adminSignIn";
	}
}
