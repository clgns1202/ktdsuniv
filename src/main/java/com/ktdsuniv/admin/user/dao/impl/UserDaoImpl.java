package com.ktdsuniv.admin.user.dao.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ktdsuniv.admin.user.dao.UserDao;

import common.support.mongo.MongoTemplateSupport;
import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public class UserDaoImpl extends MongoTemplateSupport implements UserDao {

	@Override
	public List<UsersSchema> getAllUsers() {
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC, "_id"));
		
		return getMongo().find(query, UsersSchema.class);
	}

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
	
}
