package com.ktdsuniv.admin.room.biz;

import java.util.List;

import room.schema.RoomsSchema;

public interface RoomBiz {

	public void addRoom(RoomsSchema room);

	public List<RoomsSchema> roomList();

	public void deleteRoom(String id);

<<<<<<< HEAD
	public RoomsSchema getRoomById(String id);

	public void modifyRoom(RoomsSchema room, List<Boolean> isComputer, List<Boolean> isMouse, List<Boolean> isMonitor, List<Boolean> isChair, List<Boolean> isDesk, List<Boolean> isKeyboard);

	public boolean checkDuplicateRoomNumber(String roomNumber);

=======
>>>>>>> 4384d6ab4839f5e5581f56202ccc9c86ec4ce2fb
}
