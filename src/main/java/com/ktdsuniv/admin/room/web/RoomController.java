package com.ktdsuniv.admin.room.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.admin.room.service.RoomService;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.ClassicPageExplorer;
import common.util.pager.PageExplorer;
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
	 public ModelAndView viewLectureListPage(SearchVO searchVO){
        ModelAndView view = new ModelAndView();
        
        PageListVO roomList = roomService.getRoomList(searchVO);
        PageExplorer pageExplorer = new ClassicPageExplorer(roomList.getPager());
        String pager = pageExplorer.getPagingList("pageNumber", "[@]", "<<", ">>", "searchForm");
        view.addObject("paging", pager);
        view.addObject("roomList", roomList);
        view.setViewName("room/roomList");
        return view;
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
		return "redirect:/room/roomList";
	}
	
	@RequestMapping("/room/delete/{id}")
	public String doDeleteAction(@PathVariable String id){
		roomService.deleteRoom(id);
		return "redirect:/room/roomList";
	}
	
}
