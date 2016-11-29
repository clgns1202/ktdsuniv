package com.ktdsuniv.admin.board.biz.impl;

import com.ktdsuniv.admin.board.biz.ReplyBiz;
import com.ktdsuniv.admin.board.dao.ReplyDao;

public class ReplyBizImpl implements ReplyBiz {

	private ReplyDao replyDao;
	
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	
}
