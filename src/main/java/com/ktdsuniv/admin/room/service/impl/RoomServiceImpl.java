package com.ktdsuniv.admin.room.service.impl;

import java.util.List;

import com.ktdsuniv.admin.room.biz.RoomBiz;
import com.ktdsuniv.admin.room.service.RoomService;

import common.mongo.biz.CommonBiz;
import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.Pager;
import common.util.pager.PagerFactory;
import room.schema.RoomsSchema;

public class RoomServiceImpl implements RoomService {

	private RoomBiz roomBiz;
	private CommonBiz commonBiz;

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}

	
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

	

	
}
