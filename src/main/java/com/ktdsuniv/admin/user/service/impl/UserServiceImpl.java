package com.ktdsuniv.admin.user.service.impl;

import java.util.Date;
import java.util.List;

import com.ktdsuniv.admin.user.biz.UserBiz;
import com.ktdsuniv.admin.user.service.UserService;

import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public class UserServiceImpl implements UserService {

	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	@Override
	public List<UsersSchema> getAllUsers() {
		return userBiz.getAllUsers();
	}

	@Override
	public void addInstructor(InstructorsSchema instructors) {
		instructors.getUser().setBirthday(new Date(instructors.getUser().getBirthday().getTime() + (long) ( 1000 * 60 * 60 * 9 )));
		userBiz.addInstructor(instructors);
	}

	@Override
	public void addAdmin(AdminsSchema admins) {
		admins.getUser().setBirthday(new Date(admins.getUser().getBirthday().getTime() + (long) ( 1000 * 60 * 60 * 9 )));
		userBiz.addAdmin(admins);
	}

}
