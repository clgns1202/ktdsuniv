package com.ktdsuniv.admin.lecture.biz.impl;

import java.util.List;

import com.ktdsuniv.admin.lecture.biz.LectureBiz;
import com.ktdsuniv.admin.lecture.dao.LectureDao;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.Pager;
import common.util.pager.PagerFactory;
import lecture.schema.LecturesSchema;

public class LectureBizImpl implements LectureBiz {

	private LectureDao lectureDao;
	
	public void setLectureDao(LectureDao lectureDao) {
		this.lectureDao = lectureDao;
	}
	
	@Override
	public boolean addLecture(LecturesSchema lecturesSchema) {
		return lectureDao.addLecture(lecturesSchema)>0;
	}
	
	@Override
	public boolean deleteLecture(String letureId) {
		return lectureDao.deleteLecture(letureId)>0;
	}
	
	@Override
	public PageListVO getlectureList(SearchVO searchVO) {
		
		int totalCount = lectureDao.getlectureCount(searchVO);
		Pager pager = PagerFactory.getPager(Pager.OTHER);
		pager.setTotalArticleCount(totalCount);
		pager.setPageNumber(searchVO.getPageNumber());
		pager.setStartArticleNumber(searchVO.getStartNumber());
		pager.setEndArticleNumber(searchVO.getEndNumber());
		
		List<LecturesSchema> lectureList = lectureDao.getlectureList(searchVO);
		PageListVO pageList = new PageListVO();
		pageList.setPageList(lectureList);
		pageList.setPager(pager);
		
		return pageList;
	}
	
	@Override
	public LecturesSchema getDetailLecture(String letureId) {
		return lectureDao.getDetailLecture(letureId);
	}
	
	@Override
	public boolean updateModifyLecture(LecturesSchema lecturesSchema) {
		return lectureDao.updateModifyLecture(lecturesSchema)>0;
	}
	
}
