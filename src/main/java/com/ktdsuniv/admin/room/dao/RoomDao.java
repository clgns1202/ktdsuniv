package com.ktdsuniv.admin.room.dao;

import java.util.List;

import room.schema.RoomsSchema;

public interface RoomDao {

	public void addRoom(RoomsSchema room);

	public List<RoomsSchema> roomList();

	public void deleteRoom(String id);


	public RoomsSchema getRoomById(String id);

	public void modifyRoom(RoomsSchema originalRoom);

	public int checkDuplicateRoomNumber(String roomNumber);


}
