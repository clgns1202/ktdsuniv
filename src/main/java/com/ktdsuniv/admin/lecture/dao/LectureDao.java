package com.ktdsuniv.admin.lecture.dao;

import java.util.List;

import common.pageVO.SearchVO;
import lecture.schema.LecturesSchema;

public interface LectureDao {

	public int addLecture(LecturesSchema lecturesSchema);

	public int deleteLecture(String letureId);

	public int getlectureCount(SearchVO searchVO);

	public List<LecturesSchema> getlectureList(SearchVO searchVO);

	public LecturesSchema getDetailLecture(String letureId);

	public int updateModifyLecture(LecturesSchema lecturesSchema);

}
