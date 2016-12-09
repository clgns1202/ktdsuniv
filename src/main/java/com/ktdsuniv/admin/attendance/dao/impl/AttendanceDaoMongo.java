package com.ktdsuniv.admin.attendance.dao.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SortOperation;

import com.ktdsuniv.admin.attendance.dao.AttendanceDao;

import attendance.schema.AttendanceSchema;
import common.support.mongo.MongoTemplateSupport;

public class AttendanceDaoMongo extends MongoTemplateSupport implements AttendanceDao {
	Logger logger = LoggerFactory.getLogger(AttendanceDaoMongo.class);
	@Override
	public List<AttendanceSchema> getAttendanceList() {
		SortOperation sort = Aggregation.sort(Sort.Direction.DESC,"checkedDateTime");
		Aggregation aggregation = Aggregation.newAggregation(sort);
		
		AggregationResults<AttendanceSchema> result = getMongo().aggregate(aggregation, "attendanceList", AttendanceSchema.class);
		
		return result.getMappedResults();
	}
	
	@Override
	public boolean check(AttendanceSchema attendanceSchema) {
		getMongo().insert(attendanceSchema);
		logger.info("출석되었습니다.");
		return true;
	}
}
