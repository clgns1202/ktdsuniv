package com.ktdsuniv.admin.user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface UserService {

	public void addInstructor(InstructorsSchema instructors);

	public void addAdmin(AdminsSchema admins);

	public boolean adminSignIn(UsersSchema user, HttpSession session);

	public PageListVO getUserList(SearchVO search);

	public PageListVO getInstructorList(SearchVO search);


}
