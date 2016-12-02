package com.ktdsuniv.admin.user.service;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;

public interface UserService {

	public PageListVO getUserList(SearchVO search);

	public PageListVO getInstructorList(SearchVO search);

}
