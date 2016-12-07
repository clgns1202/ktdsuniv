package com.ktdsuniv.admin.room.biz;

import java.util.List;

import room.schema.RoomsSchema;

public interface RoomBiz {

	public void addRoom(RoomsSchema room);

	public List<RoomsSchema> roomList();

}
