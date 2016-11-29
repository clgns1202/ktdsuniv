package com.ktdsuniv.admin.lecture.service.impl;

import com.ktdsuniv.admin.lecture.biz.LectureBiz;
import com.ktdsuniv.admin.lecture.service.LectureService;

public class LectureServiceImpl implements LectureService {

	private LectureBiz lectureBiz;
	
	public void setLectureBiz(LectureBiz lectureBiz) {
		this.lectureBiz = lectureBiz;
	}
	
}
