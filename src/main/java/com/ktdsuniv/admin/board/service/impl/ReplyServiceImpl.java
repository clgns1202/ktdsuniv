package com.ktdsuniv.admin.board.service.impl;

import com.ktdsuniv.admin.board.biz.ReplyBiz;
import com.ktdsuniv.admin.board.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {

	private ReplyBiz replyBiz;
	
	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}
	
}
