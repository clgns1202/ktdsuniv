package com.ktdsuniv.admin.room.web;

import java.util.List;

<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> 4384d6ab4839f5e5581f56202ccc9c86ec4ce2fb
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
	private Logger logger = LoggerFactory.getLogger(RoomController.class);
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
	
<<<<<<< HEAD
	@RequestMapping("room/detail/{id}")
	public ModelAndView viewDetailRoomPage(@PathVariable String id) {
		ModelAndView view = new ModelAndView();	
		RoomsSchema room = roomService.getRoomById(id);
		view.addObject("room", room );
		view.setViewName("room/roomDetail");
		return view;
		
	}
	
	@RequestMapping("room/modifyRoom/{id}")
	public ModelAndView ViewModifyRoom(@PathVariable String id) {
		ModelAndView view = new ModelAndView();	
		RoomsSchema room = roomService.getRoomById(id);
		view.addObject("room", room );
		view.setViewName("room/modifyRoom");
		return view;
	}
	
	@RequestMapping("room/doModifyRoom/{id}")
	public String doModifyRoom(RoomsSchema room, @RequestParam List<Boolean> isComputer, @RequestParam List<Boolean> isMouse, @RequestParam List<Boolean> isMonitor , @RequestParam List<Boolean> isChair, @RequestParam List<Boolean> isDesk, @RequestParam List<Boolean> isKeyboard) {
		roomService.modifyRoom(room, isComputer, isMouse, isMonitor, isChair, isDesk, isKeyboard );
		return "redirect:/room/detail/{id}";
	}
	
	@RequestMapping("/room/deleteRoom/{id}")
=======
	@RequestMapping("/room/delete/{id}")
>>>>>>> 4384d6ab4839f5e5581f56202ccc9c86ec4ce2fb
	public String doDeleteAction(@PathVariable String id){
		roomService.deleteRoom(id);
		return "redirect:/room/roomList";
	}
	
<<<<<<< HEAD
	@RequestMapping("/room/checkDuplicateRoomNumber")
	@ResponseBody
	public boolean checkDuplicateRoomNumber(@RequestParam String roomNumber ) {
		boolean isSuccess = roomService.checkDuplicateRoomNumber(roomNumber);
		return isSuccess;
	}
	
	
	
=======
>>>>>>> 4384d6ab4839f5e5581f56202ccc9c86ec4ce2fb
}
