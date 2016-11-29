package com.ktdsuniv.admin.lecture.biz.impl;

import com.ktdsuniv.admin.lecture.biz.LectureBiz;
import com.ktdsuniv.admin.lecture.dao.LectureDao;

public class LectureBizImpl implements LectureBiz {

	private LectureDao lectureDao;
	
	public void setLectureDao(LectureDao lectureDao) {
		this.lectureDao = lectureDao;
	}
	
}
