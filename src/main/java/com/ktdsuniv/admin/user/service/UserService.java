package com.ktdsuniv.admin.user.service;

<<<<<<< HEAD
import common.pageVO.PageListVO;
import common.pageVO.SearchVO;

public interface UserService {

	public PageListVO getUserList(SearchVO search);

	public PageListVO getInstructorList(SearchVO search);
=======
import java.util.List;

import javax.servlet.http.HttpSession;

import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface UserService {

	public List<UsersSchema> getAllUsers();

	public void addInstructor(InstructorsSchema instructors);

	public void addAdmin(AdminsSchema admins);

	public boolean adminSignIn(UsersSchema user, HttpSession session);

>>>>>>> 23c256a7ed6502e5ce03ccce796d117e03cb83b1

}
