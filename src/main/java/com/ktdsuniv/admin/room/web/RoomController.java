package com.ktdsuniv.admin.room.web;

import org.springframework.stereotype.Controller;

import com.ktdsuniv.admin.room.service.RoomService;

@Controller
public class RoomController {

	
	private RoomService roomService;

	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	

	
}
