package com.ktdsuniv.admin.user.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * 愿�由ъ옄 硫붿씤 �럹�씠吏�
	 * �씪諛섑쉶�썝, 媛뺤궗, ��, �봽濡쒖젥�듃, 寃뚯떆�뙋, �샇�떎, 媛뺤쓽 �벑 遺덈윭�삱 �닔 �엳�뒗 由ъ뒪�듃�뒗 �떎 遺덈윭���꽌 理쒖떊 3媛쒕쭔 蹂댁뿬 二쇱떊 �떇�쑝濡� 吏꾪뻾
	 * 愿�由� 湲곕뒫�쓽 寃쎌슦 媛� 由ъ뒪�듃蹂꾨줈 遺꾨━�빐�꽌 吏꾪뻾
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
	
	@RequestMapping("/instructor/instructorRegister")
	public ModelAndView viewInstructorRegisterPage() {		
		ModelAndView view = new ModelAndView();
		view.setViewName("/instructor/instructorRegister");
		return view;		
	}
	
	@RequestMapping("/instructor/instructorDoRegister")
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
	

	/*
	 * �쑀�� 由ъ뒪�듃 
	 * �셿�꽦
	 */
	@RequestMapping("/user/list")
	public ModelAndView viewUserList(SearchVO search){
		ModelAndView view = new ModelAndView();
		PageListVO userList = userService.getUserList(search);
		PageExplorer pageExplorer = new ClassicPageExplorer(userList.getPager());
		String pager = pageExplorer.getPagingList("pageNumber", "[@]", "<<", ">>", "searchForm");
		view.addObject("paging", pager);
		view.addObject("search", search);
		view.addObject("userList", userList);
		view.setViewName("user/list");
		return view;
	}
	
	/*
	 * �쑀�� �긽�꽭蹂닿린
	 * �셿�꽦
	 */
	@RequestMapping("/user/detail/{userId}")
	public ModelAndView viewDetailUserPage(@PathVariable String userId){
		ModelAndView view = new ModelAndView();
		UsersSchema user = userService.getUserById(userId);
		view.addObject("user", user);
		view.setViewName("user/detail");
		return view;
	}
	
	/*
	 * �쑀�� �젙蹂� �닔�젙
	 * �셿�꽦
	 */
	@RequestMapping("/user/modify/{userId}")
	public ModelAndView viewModifyUserPage(@PathVariable String userId){
		ModelAndView view = new ModelAndView();
		UsersSchema user = userService.getUserById(userId);
		view.addObject("user", user);
		view.setViewName("user/modify");
		return view;
	}
	
	/*
	 * �쑀���젙蹂� �닔�젙 泥섎━
	 * 留뚮벉
	 */
	@RequestMapping("/user/doModify")
	public ModelAndView doModifyUserInfo(UsersSchema usersSchema){
		ModelAndView view = new ModelAndView();
		boolean isSuccess = userService.doModifyUserInfo(usersSchema);
		view.setViewName("redirect:/user/detail/"+usersSchema.getId());
		return view;
	}
	
	/*
	 * �쑀���젙蹂� �궘�젣
	 * �셿�꽦
	 */
	@RequestMapping("/user/doDelete")
	public ModelAndView doDeleteUserInfo(@RequestParam List<String> users){
		ModelAndView view = new ModelAndView();
		boolean isSuccess = userService.doDeleteUserInfo(users);
		view.setViewName("redirect:/user/list");
		return view;
	}
	
	/*
	 * 媛뺤궗 由ъ뒪�듃
	 */
	@RequestMapping("/instructor/list")
	public ModelAndView viewInstructorList(SearchVO search){
		ModelAndView view = new ModelAndView();
		PageListVO instructorList = userService.getInstructorList(search);
		PageExplorer pageExplorer = new ClassicPageExplorer(instructorList.getPager());
		String pager = pageExplorer.getPagingList("pageNumber", "[@]", "<<", ">>", "searchForm");
		view.addObject("paging", pager);
		view.addObject("search", search);
		view.addObject("instructorList", instructorList);
		view.setViewName("instructor/list");
		return view;
	}
	
	/*
	 * 媛뺤궗 �뵒�뀒�씪
	 */
	@RequestMapping("/instructor/detail/{istructorId}")
	public ModelAndView viewDetaiInstructorPage(@PathVariable String istructorId){
		ModelAndView view = new ModelAndView();
		InstructorsSchema instructor = userService.getInstructorById(istructorId);
		view.addObject("instructor", instructor);
		view.setViewName("instructor/detail");
		return view;
	}
	
	/*
	 * 媛뺤궗 �닔�젙
	 */
	@RequestMapping("/instructor/modify/{istructorId}")
	public ModelAndView viewModifyinstructorPage(@PathVariable String istructorId){
		ModelAndView view = new ModelAndView();
		InstructorsSchema instructor = userService.getInstructorById(istructorId);
		view.addObject("instructor", instructor);
		view.setViewName("instructor/modify");
		return view;
	}
	
	/*
	 * 媛뺤궗 �닔�젙 泥섎━
	 */
	@RequestMapping("/instructor/doModify")
	public ModelAndView doModifyInstructorInfo(UsersSchema user, @RequestParam String agency){
		ModelAndView view = new ModelAndView();
		InstructorsSchema instructor = new InstructorsSchema();
		instructor.setAgency(agency);
		instructor.setUser(user);
		
		boolean isSuccess = userService.doModifyInstructorInfo(instructor);
		view.setViewName("redirect:/instructor/detail/"+instructor.getId());
		return view;
	}
	
	/*
	 * 媛뺤궗�젙蹂� �궘�젣
	 */
	@RequestMapping("/instructor/doDelete")
	public ModelAndView doDeleteInstructorInfo(@RequestParam List<String> users){
		ModelAndView view = new ModelAndView();
		boolean isSuccess = userService.doDeleteInstructorInfo(users);
		view.setViewName("redirect:/instructor/list");
		return view;
	}
	
	
	@RequestMapping("/admin/adminSignOut")
	public String doSignOutAction(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/adminSignIn";
	}
	
	@RequestMapping("/index")
	public ModelAndView viewIndexPage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("admin/index");
		return view;
	}
	
}
