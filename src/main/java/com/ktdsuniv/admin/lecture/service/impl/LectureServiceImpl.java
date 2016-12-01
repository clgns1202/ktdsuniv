package com.ktdsuniv.admin.lecture.service.impl;

import java.util.List;

import com.ktdsuniv.admin.lecture.biz.LectureBiz;
import com.ktdsuniv.admin.lecture.service.LectureService;
import com.ktdsuniv.admin.room.biz.RoomBiz;

import common.mongo.biz.CommonBiz;
import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.Pager;
import common.util.pager.PagerFactory;
import lecture.schema.LecturesSchema;
import room.schema.RoomsSchema;
import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public class LectureServiceImpl implements LectureService {

	private LectureBiz lectureBiz;
	private CommonBiz commonBiz;
	
	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}
	
	public void setLectureBiz(LectureBiz lectureBiz) {
		this.lectureBiz = lectureBiz;
	}
	
	@Override
	public boolean addLecture(LecturesSchema lecturesSchema) {
		return lectureBiz.addLecture(lecturesSchema);
	}
	
	@Override
	public boolean deleteLecture(String letureId) {
		return lectureBiz.deleteLecture(letureId);
	}
	@Override
	public PageListVO getlectureList(SearchVO searchVO) {
		return lectureBiz.getlectureList(searchVO);
	}
	
	@Override
	public LecturesSchema getDetailLecture(String letureId) {
		return lectureBiz.getDetailLecture(letureId);
	}
	
	@Override
	public boolean updateModifyLecture(LecturesSchema lecturesSchema) {
		return lectureBiz.updateModifyLecture(lecturesSchema);
	}

	@Override
	public PageListVO getInstructorList(SearchVO search) {
		Pager pager = PagerFactory.getPager(Pager.OTHER);
		return commonBiz.getMongoList(search, pager, InstructorsSchema.class);
	}

	@Override
	public PageListVO getRoomsList(SearchVO search) {
		Pager pager = PagerFactory.getPager(Pager.OTHER);
		return commonBiz.getMongoList(search, pager, RoomsSchema.class);
	}

	@Override
	public PageListVO getAdminsList(SearchVO search) {
		Pager pager = PagerFactory.getPager(Pager.OTHER);
		return commonBiz.getMongoList(search, pager, AdminsSchema.class);
	}

}
