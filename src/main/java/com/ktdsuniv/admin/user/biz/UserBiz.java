package com.ktdsuniv.admin.user.biz;

import java.util.List;

import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface UserBiz {

	public void addInstructor(InstructorsSchema instructors);

	public void addAdmin(AdminsSchema admins);

	public AdminsSchema adminSignIn(UsersSchema user);



}
