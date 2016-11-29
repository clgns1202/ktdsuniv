package com.ktdsuniv.admin.room.biz.impl;

import com.ktdsuniv.admin.room.biz.RoomBiz;
import com.ktdsuniv.admin.room.dao.RoomDao;

public class RoomBizImpl implements RoomBiz {

	private RoomDao roomDao;

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

}
