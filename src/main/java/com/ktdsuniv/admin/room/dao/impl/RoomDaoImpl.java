package com.ktdsuniv.admin.room.dao.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ktdsuniv.admin.room.dao.RoomDao;

import common.support.mongo.MongoTemplateSupport;
import room.schema.RoomsSchema;

public class RoomDaoImpl extends MongoTemplateSupport implements RoomDao {

	@Override
	public void addRoom(RoomsSchema room) {
		getMongo().save(room);
	}

	@Override
	public List<RoomsSchema> roomList() {
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC,"_id"));
		return getMongo().find(query, RoomsSchema.class);
	}

	@Override
	public void deleteRoom(String id) {
		Criteria criteria = new Criteria("_id");
		criteria.is(id);
		
		Query query = new Query(criteria);
		
		getMongo().remove(query, RoomsSchema.class);
		
		
	}

}
