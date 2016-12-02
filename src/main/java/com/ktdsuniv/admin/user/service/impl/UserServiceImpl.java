package com.ktdsuniv.admin.user.service.impl;

import com.ktdsuniv.admin.user.biz.UserBiz;
import com.ktdsuniv.admin.user.service.UserService;

import common.mongo.biz.CommonBiz;
import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.Pager;
import common.util.pager.PagerFactory;
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
			search.setSearchKeyName("userName");
		}
		else if(search.getSearchType()==2) {
			search.setSearchKeyName("userId");
		}
		return commonBiz.getMongoList(search, pager, UsersSchema.class);
	}
	
	@Override
	public PageListVO getInstructorList(SearchVO search) {
		Pager pager = PagerFactory.getPager(Pager.OTHER);
		if(search.getSearchType()==1){
			search.setSearchKeyName("user.userName");
		}
		else if(search.getSearchType()==2) {
			search.setSearchKeyName("user.userId");
		}
		return commonBiz.getMongoList(search, pager, InstructorsSchema.class);
	}
}
