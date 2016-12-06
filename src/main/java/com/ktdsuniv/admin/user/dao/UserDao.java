package com.ktdsuniv.admin.user.dao;

import java.util.List;

import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface UserDao {

	public void addInstructor(InstructorsSchema instructors);

	public void addAdmin(AdminsSchema admins);

	public String getSalt(UsersSchema user);

	public AdminsSchema adminSignIn(UsersSchema user);

	public int doModifyUserInfo(UsersSchema usersSchema);

	public int doModifyInstructorInfo(InstructorsSchema instructor);


}
