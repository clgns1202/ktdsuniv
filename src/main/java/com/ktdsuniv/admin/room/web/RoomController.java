package com.ktdsuniv.admin.room.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.admin.room.service.RoomService;

import room.schema.RoomsSchema;

@Controller
public class RoomController {

	
	private RoomService roomService;

	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@RequestMapping("/room/roomList")
	@ResponseBody
	public List<RoomsSchema> viewRoomListPage() {
		return roomService.roomList();
	}

	
	@RequestMapping("/room/addRoom")
	public ModelAndView viewAddRoomPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("room/addRoom");
		return view;
	}
	
	@RequestMapping("/room/doAddRoom")
	public String doAddRoomAction(RoomsSchema room) {
		roomService.addRoom(room);
		return "redirect:/room/addRoom";
	}
	
}
