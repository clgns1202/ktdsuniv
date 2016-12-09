package com.ktdsuniv.admin.attendance.service.impl;

import java.util.List;

import com.ktdsuniv.admin.attendance.biz.AttendanceBiz;
import com.ktdsuniv.admin.attendance.service.AttendanceService;

import attendance.schema.AttendanceSchema;

public class AttendanceServiceImpl implements  AttendanceService{

	private AttendanceBiz attendanceBiz;

	public void setAttendanceBiz(AttendanceBiz attendanceBiz) {
		this.attendanceBiz = attendanceBiz;
	}

	@Override
	public List<AttendanceSchema> getAttendanceList() {
		return attendanceBiz.getAttendanceList();
	}

	@Override
	public boolean check(AttendanceSchema attendanceSchema) {
		return attendanceBiz.check(attendanceSchema);
	}
	
	
	
}
