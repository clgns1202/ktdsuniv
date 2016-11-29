package com.ktdsuniv.admin.room.service.impl;

import com.ktdsuniv.admin.room.biz.SeatBiz;
import com.ktdsuniv.admin.room.service.SeatService;

public class SeatServiceImpl implements SeatService {

	private SeatBiz seatBiz;
	
	public void setSeatBiz(SeatBiz seatBiz) {
		this.seatBiz = seatBiz;
	}
	
}
