package com.ktdsuniv.admin.room.biz.impl;

import com.ktdsuniv.admin.room.biz.SeatBiz;
import com.ktdsuniv.admin.room.dao.SeatDao;

public class SeatBizImpl implements SeatBiz {

	private SeatDao seatDao;
	
	public void setSeatDao(SeatDao seatDao) {
		this.seatDao = seatDao;
	}
	
}
