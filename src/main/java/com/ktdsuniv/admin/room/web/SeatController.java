package com.ktdsuniv.admin.room.web;

import org.springframework.stereotype.Controller;

import com.ktdsuniv.admin.room.service.impl.SeatServiceImpl;

@Controller
public class SeatController {

	private SeatServiceImpl seatService;

	public void setSeatService(SeatServiceImpl seatService) {
		this.seatService = seatService;
	}

}
