package com.ktdsuniv.admin.attendance.dao;

import java.util.List;

import attendance.schema.AttendanceSchema;

/**
 * 추가 
 * 리스트
 * 수정
 * 삭제
 * @author 206-017
 */
public interface AttendanceDao{

	public List<AttendanceSchema> getAttendanceList();
	
	public boolean check(AttendanceSchema attendanceSchema);
}
