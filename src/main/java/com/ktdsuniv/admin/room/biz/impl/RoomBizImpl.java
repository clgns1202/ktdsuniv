package com.ktdsuniv.admin.room.biz.impl;

import java.util.List;

import com.ktdsuniv.admin.room.biz.RoomBiz;
import com.ktdsuniv.admin.room.dao.RoomDao;

import room.schema.RoomsSchema;

public class RoomBizImpl implements RoomBiz {

	private RoomDao roomDao;

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public void addRoom(RoomsSchema room) {
		roomDao.addRoom(room);
		
	}

	@Override
	public List<RoomsSchema> roomList() {
		return roomDao.roomList();
	}

}
