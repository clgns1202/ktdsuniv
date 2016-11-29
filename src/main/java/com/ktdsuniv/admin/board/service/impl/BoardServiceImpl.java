package com.ktdsuniv.admin.board.service.impl;

import com.ktdsuniv.admin.board.biz.BoardBiz;
import com.ktdsuniv.admin.board.service.BoardService;

public class BoardServiceImpl implements BoardService {

	private BoardBiz boardBiz;
	
	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}
	
}
