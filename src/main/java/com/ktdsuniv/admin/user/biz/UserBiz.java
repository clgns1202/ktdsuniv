package com.ktdsuniv.admin.user.biz;

import java.util.List;

import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface UserBiz {

	public void addInstructor(InstructorsSchema instructors);

	public void addAdmin(AdminsSchema admins);

	public AdminsSchema adminSignIn(UsersSchema user);

	public boolean doModifyUserInfo(UsersSchema usersSchema);

	public boolean doModifyInstructorInfo(InstructorsSchema instructor);

	public boolean doDeleteUserInfo(List<String> users);

	public boolean doDeleteInstructorInfo(List<String> users);



}
