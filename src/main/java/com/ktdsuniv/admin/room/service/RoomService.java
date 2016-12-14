package com.ktdsuniv.admin.room.service;

import java.util.List;

import room.schema.RoomsSchema;

public interface RoomService {

	public void addRoom(RoomsSchema room);

	public List<RoomsSchema> roomList();

}
