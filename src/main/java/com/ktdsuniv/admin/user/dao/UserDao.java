package com.ktdsuniv.admin.user.dao;

import java.util.List;

import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface UserDao {

	public List<UsersSchema> getAllUsers();

	public void addInstructor(InstructorsSchema instructors);

	public void addAdmin(AdminsSchema admins);


}
