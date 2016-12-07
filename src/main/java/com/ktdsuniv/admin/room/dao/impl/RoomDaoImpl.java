package com.ktdsuniv.admin.room.dao.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

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

}
