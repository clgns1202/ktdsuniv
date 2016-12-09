package com.ktdsuniv.admin.attendance.biz;

import java.util.List;

import attendance.schema.AttendanceSchema;

public interface AttendanceBiz {

	public List<AttendanceSchema> getAttendanceList();

	public boolean check(AttendanceSchema attendanceSchema);

}
