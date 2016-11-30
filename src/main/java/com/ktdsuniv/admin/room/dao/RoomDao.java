package com.ktdsuniv.admin.room.dao;

import java.util.List;

import room.schema.RoomsSchema;

public interface RoomDao {

	public void addRoom(RoomsSchema room);

	public List<RoomsSchema> roomList();

}
