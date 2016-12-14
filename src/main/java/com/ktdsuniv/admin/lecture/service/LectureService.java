package com.ktdsuniv.admin.lecture.service;

import java.util.List;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import lecture.schema.LecturesSchema;
import room.schema.RoomsSchema;
import user.schema.AdminsSchema;
import user.schema.InstructorsSchema;
import user.schema.UsersSchema;

public interface LectureService {

	public boolean addLecture(LecturesSchema lecturesSchema);

	public boolean deleteLecture(String letureId);

	public PageListVO getlectureList(SearchVO searchVO);

	public LecturesSchema getDetailLecture(String letureId);

	public boolean updateModifyLecture(LecturesSchema lecturesSchema);

	public PageListVO getInstructorList(SearchVO search);

	public PageListVO getRoomsList(SearchVO search);

	public PageListVO getAdminsList(SearchVO search);

}
