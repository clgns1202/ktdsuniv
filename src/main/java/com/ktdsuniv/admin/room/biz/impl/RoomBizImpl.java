package com.ktdsuniv.admin.room.biz.impl;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

=======
import java.util.List;

>>>>>>> 4384d6ab4839f5e5581f56202ccc9c86ec4ce2fb
import com.ktdsuniv.admin.room.biz.RoomBiz;
import com.ktdsuniv.admin.room.dao.RoomDao;

import room.schema.RoomsSchema;
<<<<<<< HEAD
import room.schema.Seats;
=======
>>>>>>> 4384d6ab4839f5e5581f56202ccc9c86ec4ce2fb

public class RoomBizImpl implements RoomBiz {

	private RoomDao roomDao;
	private Logger logger = LoggerFactory.getLogger(RoomBizImpl.class);
	
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	

	@Override
	public void addRoom(RoomsSchema room) {
	
	
		int seatCount = room.getSeatCount();
		List<Seats> seats = new ArrayList<Seats>();
		
		for (int i = 0; i <= seatCount-1; i++) {
			Seats seat = new Seats();
			seat.setSeatNumber(i);
			seat.setChair(true);
			seat.setComputer(true);
			seat.setDesk(true);
			seat.setKeyboard(true);
			seat.setMonitor(true);
			seat.setMouse(true);
			seats.add(seat);
		}
		room.setSeat(seats);
		roomDao.addRoom(room);
	}

	@Override
	public List<RoomsSchema> roomList() {
		return roomDao.roomList();
	}
	
	@Override
	public RoomsSchema getRoomById(String id) {
		
		return roomDao.getRoomById(id);
	}
	
	

	@Override
	public void modifyRoom(RoomsSchema room, List<Boolean> isComputer, List<Boolean> isMouse, List<Boolean> isMonitor,
			List<Boolean> isChair, List<Boolean> isDesk, List<Boolean> isKeyboard) {
		
		int seatCount = room.getSeatCount();
		//좌석 전체 리스트 
		List<Seats> seats = new ArrayList<Seats>();
		
		for (int i = 0; i <= seatCount-1; i++) {
			Seats seat = new Seats();
			seat.setSeatNumber(i);
			seat.setComputer(isComputer.get(i));
			seat.setChair(isChair.get(i));
			seat.setDesk(isDesk.get(i));
			seat.setKeyboard(isKeyboard.get(i));
			seat.setMonitor(isMonitor.get(i));
			seat.setMouse(isMouse.get(i));
			seats.add(seat);
		}
		
		room.setSeat(seats);
		roomDao.modifyRoom(room);
	}

	@Override
	public void deleteRoom(String id) {
		roomDao.deleteRoom(id);
	}


	@Override
	public boolean checkDuplicateRoomNumber(String roomNumber) {
		if (roomDao.checkDuplicateRoomNumber(roomNumber) > 0) {
			return true;
		}
		return false;
	}


	



	@Override
	public void addRoom(RoomsSchema room) {
		roomDao.addRoom(room);
		
	}

	@Override
	public List<RoomsSchema> roomList() {
		return roomDao.roomList();
	}

	@Override
	public void deleteRoom(String id) {
		roomDao.deleteRoom(id);
	}

}
