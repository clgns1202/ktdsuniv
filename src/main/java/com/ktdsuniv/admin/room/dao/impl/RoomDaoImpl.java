package com.ktdsuniv.admin.room.dao.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ktdsuniv.admin.room.dao.RoomDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.support.mongo.MongoTemplateSupport;
import room.schema.RoomsSchema;

public class RoomDaoImpl extends MongoTemplateSupport implements RoomDao {
	
	private Logger logger = LoggerFactory.getLogger(RoomDaoImpl.class);
	
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
	
	@Override
	public RoomsSchema getRoomById(String id) {
		Criteria criteria = new Criteria("_id");
		criteria.is(id);
		
		Query query = new Query(criteria);
		return getMongo().findOne(query, RoomsSchema.class);
	}
	
	@Override
	public void modifyRoom(RoomsSchema originalRoom) {
		getMongo().save(originalRoom);
	}

	@Override
	public int checkDuplicateRoomNumber(String roomNumber) {
		Criteria criteria = new Criteria("roomNumber");
		criteria.is(roomNumber);
		
		Query query = new Query(criteria);
		
		return (int) getMongo().count(query, RoomsSchema.class);
		
	}

	

}
