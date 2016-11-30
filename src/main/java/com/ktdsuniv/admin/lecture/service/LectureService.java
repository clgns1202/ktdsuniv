package com.ktdsuniv.admin.lecture.service;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import lecture.schema.LecturesSchema;

public interface LectureService {

	public boolean addLecture(LecturesSchema lecturesSchema);

	public boolean deleteLecture(String letureId);

	public PageListVO getlectureList(SearchVO searchVO);

	public LecturesSchema getDetailLecture(String letureId);

	public boolean updateModifyLecture(LecturesSchema lecturesSchema);

}
