package com.ktdsuniv.admin.user.biz.impl;

import com.ktdsuniv.admin.user.biz.UserBiz;
import com.ktdsuniv.admin.user.dao.UserDao;

public class UserBizImpl implements UserBiz {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
