package com.ktdsuniv.admin.attendance.biz.impl;

import java.util.List;

import com.ktdsuniv.admin.attendance.biz.AttendanceBiz;
import com.ktdsuniv.admin.attendance.dao.AttendanceDao;

import attendance.schema.AttendanceSchema;

public class AttendanceBizImpl implements AttendanceBiz {

	private AttendanceDao attendanceDao;

	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}

	@Override
	public List<AttendanceSchema> getAttendanceList() {
		return attendanceDao.getAttendanceList();
	}

	@Override
	public boolean check(AttendanceSchema attendanceSchema) {
		return attendanceDao.check(attendanceSchema);
	}
	
	
	
}
