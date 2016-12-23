package com.ktdsuniv.admin.user.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.admin.user.dao.UserDao;

import common.support.mongo.MongoTemplateSupport;
import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public class UserDaoImpl extends MongoTemplateSupport implements UserDao {

	@Override
	public void addInstructor(InstructorsSchema instructors) {
		getMongo().insert(instructors);
	}

	@Override
	public void addAdmin(AdminsSchema admins) {
		getMongo().insert(admins);
	}

	@Override
	public String getSalt(UsersSchema user) {
		Criteria criteria = new Criteria("user.userId");
		criteria.is(user.getUserId());
		
		Query query = new Query(criteria);
		query.fields().include("user.userSalt");
		
		AdminsSchema admins = getMongo().findOne(query, AdminsSchema.class, "admins");
		return admins.getUser().getUserSalt();
	}
	
	@Override
	public AdminsSchema adminSignIn(UsersSchema user) {
		Criteria criteria = new Criteria("userId");
		criteria.is(user.getUserId());
		criteria = criteria.and("userPassword");
		criteria.is(user.getUserPassword());
		
		Query query = new Query(criteria);
		
		return getMongo().findOne(query, AdminsSchema.class, "admins");
	}
	
	@Override
	public int doModifyUserInfo(UsersSchema usersSchema) {
		Criteria criteria = new Criteria("_id");
		criteria.is(usersSchema.getId());
		
		Query query = new Query(criteria);
		
		/*
		 * 생성일과 아이디빼고 수정 하기
		 */
		UsersSchema originalUser = getMongo().findOne(query, UsersSchema.class, "users");
		originalUser.setAddress(usersSchema.getAddress());
		//originalUser.setBirthday(usersSchema.getBirthday());
		originalUser.setGender(usersSchema.getGender());
		originalUser.setModifiedDate(new Date());
		originalUser.setPhoneNumber(usersSchema.getPhoneNumber());
		originalUser.setUserName(usersSchema.getUserName());
		if(usersSchema.getUserPassword() != null){
			originalUser.setUserPassword(usersSchema.getUserPassword());
			originalUser.setUserSalt(usersSchema.getUserSalt());
		}
		
		getMongo().save(originalUser);
		
		return 1;
	}
	
	@Override
	public int doModifyInstructorInfo(InstructorsSchema instructor) {
		Criteria criteria = new Criteria("user._id");
		criteria.is(instructor.getUser().getId());
		Query query = new Query(criteria);
		
		InstructorsSchema originalInstructor = getMongo().findOne(query, InstructorsSchema.class, "instructors");
		originalInstructor.setAgency(instructor.getAgency());
		originalInstructor.getUser().setAddress(instructor.getUser().getAddress());
		//originalInstructor.getUser().setBirthday(instructor.getUser().getBirthday());
		originalInstructor.getUser().setGender(instructor.getUser().getGender());
		originalInstructor.getUser().setModifiedDate(new Date());
		originalInstructor.getUser().setPhoneNumber(instructor.getUser().getPhoneNumber());
		originalInstructor.getUser().setUserName(instructor.getUser().getUserName());
		if(instructor.getUser().getUserPassword() != null){
			originalInstructor.getUser().setUserPassword(instructor.getUser().getUserPassword());
			originalInstructor.getUser().setUserSalt(instructor.getUser().getUserSalt());
		}
		
		getMongo().save(originalInstructor);
		
		return 1;
	}
	
	@Override
	public int doDeleteUserInfo(List<String> users) {

		for (String user : users) {
			Criteria criteria = new Criteria("id");
			criteria.is(user);
			
			Query query = new Query(criteria);
			getMongo().remove(query, UsersSchema.class, "users");
		}
		
		return 1;
	}
	
	@Override
	public int doDeleteInstructorInfo(List<String> users) {
		for (String user : users) {
			Criteria criteria = new Criteria("user.id");
			criteria.is(user);
			
			Query query = new Query(criteria);
			getMongo().remove(query, InstructorsSchema.class, "instructors");
		}
		
		return 1;
	}
	
}
