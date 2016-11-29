package com.ktdsuniv.admin.user.service.impl;

import com.ktdsuniv.admin.user.biz.UserBiz;
import com.ktdsuniv.admin.user.service.UserService;

public class UserServiceImpl implements UserService {

	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
}
