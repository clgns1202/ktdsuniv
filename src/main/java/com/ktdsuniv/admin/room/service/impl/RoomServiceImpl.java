package com.ktdsuniv.admin.room.service.impl;

import java.util.List;

import com.ktdsuniv.admin.room.biz.RoomBiz;
import com.ktdsuniv.admin.room.service.RoomService;

import room.schema.RoomsSchema;

public class RoomServiceImpl implements RoomService {

	private RoomBiz roomBiz;

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}

	@Override
	public void addRoom(RoomsSchema room) {
		roomBiz.addRoom(room);
		
	}

	@Override
	public List<RoomsSchema> roomList() {
		return roomBiz.roomList();
	}
	
	
}
