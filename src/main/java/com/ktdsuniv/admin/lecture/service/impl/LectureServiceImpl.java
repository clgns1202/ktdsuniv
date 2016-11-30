package com.ktdsuniv.admin.lecture.service.impl;

import com.ktdsuniv.admin.lecture.biz.LectureBiz;
import com.ktdsuniv.admin.lecture.service.LectureService;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import lecture.schema.LecturesSchema;

public class LectureServiceImpl implements LectureService {

	private LectureBiz lectureBiz;
	
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
	
}
