package com.ktdsuniv.admin.attendance.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.admin.attendance.service.AttendanceService;

import attendance.schema.AttendanceSchema;

@Controller
public class AttendanceController {
	private AttendanceService attendanceService;
	
	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	
	@RequestMapping("/attendance/attendanceList")
	public ModelAndView viewAttendanceListPage(){
		List<AttendanceSchema> attendanceList = attendanceService.getAttendanceList();
		
		ModelAndView view = new ModelAndView();
		view.addObject("attendanceList", attendanceList);
		view.setViewName("/attendance/attendanceList");
		return view;
	}
	
	/**
	 * dateTime
	 * lecturesSchema
	 * classification
	 * usersSchema
	 * etc
	 * @return
	 */
	@RequestMapping("/attendance/check")
	@ResponseBody
	public boolean checkAttendancePage(AttendanceSchema attendanceSchema){		
		attendanceSchema.setUser(null);
		attendanceSchema.setCheckedDateTime(new Date());
		attendanceSchema.setLecture(null);
		attendanceSchema.setClassification(null);
		boolean isChecked = attendanceService.check(attendanceSchema);
		return isChecked;
	}
}
