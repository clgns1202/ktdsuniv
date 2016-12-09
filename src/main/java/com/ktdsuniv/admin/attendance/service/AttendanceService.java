package com.ktdsuniv.admin.attendance.service;

import java.util.List;

import attendance.schema.AttendanceSchema;

public interface AttendanceService {

	public List<AttendanceSchema> getAttendanceList();

	public boolean check(AttendanceSchema attendanceSchema);

}
