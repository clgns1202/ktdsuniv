package com.ktdsuniv.admin.board.biz.impl;

import com.ktdsuniv.admin.board.biz.BoardBiz;
import com.ktdsuniv.admin.board.dao.BoardDao;

public class BoardBizImpl implements BoardBiz {

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
}
