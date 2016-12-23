package com.ktdsuniv.admin.user.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ktdsuniv.admin.user.biz.UserBiz;
import com.ktdsuniv.admin.user.service.UserService;

import common.constants.Session;
import common.mongo.biz.CommonBiz;
import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.Pager;
import common.util.pager.PagerFactory;
import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public class UserServiceImpl implements UserService {

	private UserBiz userBiz;
	private CommonBiz commonBiz;
	
	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	
	@Override
	public PageListVO getUserList(SearchVO search) {
		Pager pager = PagerFactory.getPager(Pager.OTHER);
		if(search.getSearchType()==1){
			search.setSearchKeyName("userId");
		}
		else if(search.getSearchType()==2) {
			search.setSearchKeyName("userName");
		}
		return commonBiz.getMongoList(search, pager, UsersSchema.class);
	}
	
	@Override
	public PageListVO getInstructorList(SearchVO search) {
		Pager pager = PagerFactory.getPager(Pager.OTHER);
		if(search.getSearchType()==1){
			search.setSearchKeyName("user.userId");
		}
		else if(search.getSearchType()==2) {
			search.setSearchKeyName("user.userName");
		}
		return commonBiz.getMongoList(search, pager, InstructorsSchema.class);
	}

	@Override
	public void addInstructor(InstructorsSchema instructors) {
		//instructors.getUser().setBirthday(new Date(instructors.getUser().getBirthday().getTime() + (long) ( 1000 * 60 * 60 * 9 )));
		userBiz.addInstructor(instructors);
	}

	@Override
	public void addAdmin(AdminsSchema admins) {
		//admins.getUser().setBirthday(new Date(admins.getUser().getBirthday().getTime() + (long) ( 1000 * 60 * 60 * 9 )));
		userBiz.addAdmin(admins);
	}

	@Override
	public boolean adminSignIn(UsersSchema user, HttpSession session) {
		AdminsSchema signedAdmin = userBiz.adminSignIn(user);
		
		if(signedAdmin != null) {
			session.setAttribute(Session.ADMIN, signedAdmin);
			return true;
		}
		return false;
	}
	
	@Override
	public UsersSchema getUserById(String userId) {
		return commonBiz.getUserById(userId);
	}
	
	@Override
	public boolean doModifyUserInfo(UsersSchema usersSchema) {
		return userBiz.doModifyUserInfo(usersSchema);
	}
	
	@Override
	public InstructorsSchema getInstructorById(String istructorId) {
		return commonBiz.getMongoById("_id", istructorId, InstructorsSchema.class);
	}
	
	@Override
	public boolean doModifyInstructorInfo(InstructorsSchema instructor) {
		return userBiz.doModifyInstructorInfo(instructor);
	}
	
	@Override
	public boolean doDeleteUserInfo(List<String> users) {
		return userBiz.doDeleteUserInfo(users);
	}
	
	@Override
	public boolean doDeleteInstructorInfo(List<String> users) {
		return userBiz.doDeleteInstructorInfo(users);
	}

}
