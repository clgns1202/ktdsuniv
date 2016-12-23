package com.ktdsuniv.admin.room.dao;

import java.util.List;

import room.schema.RoomsSchema;
<<<<<<< HEAD
import room.schema.Seats;
=======
>>>>>>> 4384d6ab4839f5e5581f56202ccc9c86ec4ce2fb

public interface RoomDao {

	public void addRoom(RoomsSchema room);

	public List<RoomsSchema> roomList();

	public void deleteRoom(String id);

<<<<<<< HEAD
	public RoomsSchema getRoomById(String id);

	public void modifyRoom(RoomsSchema originalRoom);

	public int checkDuplicateRoomNumber(String roomNumber);


=======
>>>>>>> 4384d6ab4839f5e5581f56202ccc9c86ec4ce2fb
}
