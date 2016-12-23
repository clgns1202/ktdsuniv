package com.ktdsuniv.admin.room.service.impl;

import java.util.List;

import com.ktdsuniv.admin.room.biz.RoomBiz;
import com.ktdsuniv.admin.room.biz.SeatBiz;
import com.ktdsuniv.admin.room.service.RoomService;

import common.mongo.biz.CommonBiz;
import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.Pager;
import common.util.pager.PagerFactory;
import room.schema.RoomsSchema;
<<<<<<< HEAD
import room.schema.Seats;
=======
>>>>>>> 4384d6ab4839f5e5581f56202ccc9c86ec4ce2fb

public class RoomServiceImpl implements RoomService {

	private RoomBiz roomBiz;
	private CommonBiz commonBiz;

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}

<<<<<<< HEAD
	
	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}



	@Override
	public void addRoom(RoomsSchema room) {
		roomBiz.addRoom(room);
		
	}


	@Override
	public PageListVO getRoomList(SearchVO searchVO) {
		  Pager pager = PagerFactory.getPager(Pager.OTHER);
	      return commonBiz.getMongoList(searchVO, pager, RoomsSchema.class);
	}


	@Override
	public RoomsSchema getRoomById(String id) {
		return roomBiz.getRoomById(id);
	}

	@Override
	public void modifyRoom(RoomsSchema room, List<Boolean> isComputer, List<Boolean> isMouse, List<Boolean> isMonitor,
			List<Boolean> isChair, List<Boolean> isDesk, List<Boolean> isKeyboard) {

		roomBiz.modifyRoom(room, isComputer, isMouse, isMonitor, isChair, isDesk, isKeyboard );
		
	}
	@Override
	public void deleteRoom(String id) {
		roomBiz.deleteRoom(id);
		
	}


	@Override
	public boolean checkDuplicateRoomNumber(String roomNumber) {
		return roomBiz.checkDuplicateRoomNumber(roomNumber);
	}


	


	


	
=======
	
	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}


	@Override
	public void addRoom(RoomsSchema room) {
		roomBiz.addRoom(room);
		
	}


	@Override
	public PageListVO getRoomList(SearchVO searchVO) {
		  Pager pager = PagerFactory.getPager(Pager.OTHER);
	      return commonBiz.getMongoList(searchVO, pager, RoomsSchema.class);
	}


	@Override
	public void deleteRoom(String id) {
		roomBiz.deleteRoom(id);
		
	}

	
>>>>>>> 4384d6ab4839f5e5581f56202ccc9c86ec4ce2fb

	
}
