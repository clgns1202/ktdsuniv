package com.ktdsuniv.admin.user.biz.impl;

import java.util.List;

import com.ktdsuniv.admin.user.biz.UserBiz;
import com.ktdsuniv.admin.user.dao.UserDao;

import common.util.SHA256Util;
import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public class UserBizImpl implements UserBiz {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addInstructor(InstructorsSchema instructors) {
		String salt = SHA256Util.generateSalt();
		instructors.getUser().setUserSalt(salt);
		
		String password = instructors.getUser().getUserPassword();
		password = SHA256Util.getEncrypt(password, salt);
		
		instructors.getUser().setUserPassword(password);
		userDao.addInstructor(instructors);
		
	}

	@Override
	public void addAdmin(AdminsSchema admins) {
		String salt = SHA256Util.generateSalt();
		admins.getUser().setUserSalt(salt);
		
		String password = admins.getUser().getUserPassword();
		password = SHA256Util.getEncrypt(password, salt);
		
		admins.getUser().setUserPassword(password);
		userDao.addAdmin(admins);
		
	}

	@Override
	public AdminsSchema adminSignIn(UsersSchema user) {
		String salt = userDao.getSalt(user);
		user.setUserSalt(salt);
		
		String password = user.getUserPassword();
		password = SHA256Util.getEncrypt(password, salt);
		
		user.setUserPassword(password);
		
		return userDao.adminSignIn(user);
	}
	
	@Override
	public boolean doModifyUserInfo(UsersSchema usersSchema) {
		
		String salt = SHA256Util.generateSalt();
		usersSchema.setUserSalt(salt);
		
		String password = usersSchema.getUserPassword();
		password = SHA256Util.getEncrypt(password, salt);
		
		usersSchema.setUserPassword(password);
		
		
		return userDao.doModifyUserInfo(usersSchema)>0;
	}
	
	@Override
	public boolean doModifyInstructorInfo(InstructorsSchema instructor) {
		String salt = SHA256Util.generateSalt();
		instructor.getUser().setUserSalt(salt);
		
		String password = instructor.getUser().getUserPassword();
		password = SHA256Util.getEncrypt(password, salt);
		
		instructor.getUser().setUserPassword(password);
		
		
		return userDao.doModifyInstructorInfo(instructor)>0;
	}
}
