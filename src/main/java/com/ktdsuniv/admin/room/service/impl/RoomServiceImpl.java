package com.ktdsuniv.admin.room.service.impl;

import com.ktdsuniv.admin.room.biz.RoomBiz;
import com.ktdsuniv.admin.room.service.RoomService;

public class RoomServiceImpl implements RoomService {

	private RoomBiz roomBiz;

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}
	
	
}
