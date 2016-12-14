package com.ktdsuniv.admin.room.service;

import java.util.List;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import room.schema.RoomsSchema;

public interface RoomService {

	public void addRoom(RoomsSchema room);


	public PageListVO getRoomList(SearchVO searchVO);


	public void deleteRoom(String id);

}
