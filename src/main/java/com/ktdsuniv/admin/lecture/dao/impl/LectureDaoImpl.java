package com.ktdsuniv.admin.lecture.dao.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ktdsuniv.admin.lecture.dao.LectureDao;

import common.pageVO.SearchVO;
import common.support.mongo.MongoTemplateSupport;
import lecture.schema.LecturesSchema;

public class LectureDaoImpl extends MongoTemplateSupport implements LectureDao {

	@Override
	public int addLecture(LecturesSchema lecturesSchema) {
		getMongo().insert(lecturesSchema);
		return 1;
	}
	
	@Override
	public int deleteLecture(String letureId) {
		Query query = new Query(new Criteria("_id").is(letureId));
		getMongo().remove(query);
		return 1;
	}

	@Override
	public int getlectureCount(SearchVO searchVO) {
		Criteria criteria = new Criteria();
		Query query = new Query();
		if(searchVO.getSearchKeyword() != null && searchVO.getSearchKeyword().length()>0){
			if(searchVO.getSearchType()==1){
				criteria = new Criteria("lectureName");
				criteria.regex(searchVO.getSearchKeyword());
				query = new Query(criteria);
				
			}
			else if(searchVO.getSearchType()==2){
				criteria = new Criteria("instructor.user.userName");
				criteria.regex(searchVO.getSearchKeyword());
				query = new Query(criteria);
			}
		}
		return (int) getMongo().count(query, "lectures");
	}

	@Override
	public List<LecturesSchema> getlectureList(SearchVO searchVO) {
		
		Criteria criteria = new Criteria();
		Query query = new Query();
		if(searchVO.getSearchKeyword() != null && searchVO.getSearchKeyword().length()>0){
			if(searchVO.getSearchType()==1){
				criteria = new Criteria("lectureName");
				criteria.regex(searchVO.getSearchKeyword());
				query = new Query(criteria);
				
			}
			else if(searchVO.getSearchType()==2){
				criteria = new Criteria("instructor.user.userName");
				criteria.regex(searchVO.getSearchKeyword());
				query = new Query(criteria);
			}
		}
		
		query.with(new Sort(Sort.Direction.DESC,"_id"));
		query.skip(searchVO.getStartNumber());
		query.limit(searchVO.getEndNumber());
		
		return getMongo().find(query, LecturesSchema.class);
	}
	
	@Override
	public LecturesSchema getDetailLecture(String letureId) {
		return getMongo().findById(letureId, LecturesSchema.class);
	}
	
	@Override
	public int updateModifyLecture(LecturesSchema lecturesSchema) {
		Criteria criteria = new Criteria("_id");
		criteria.is(lecturesSchema.getId());
		
		Query query = new Query(criteria);
		
		LecturesSchema originalSchema = getMongo().findOne(query, LecturesSchema.class);
		originalSchema.setLectureName(lecturesSchema.getLectureName());
		originalSchema.setStartDate(lecturesSchema.getStartDate());
		originalSchema.setEndDate(lecturesSchema.getEndDate());
		originalSchema.setStartTime(lecturesSchema.getStartTime());
		originalSchema.setEndTime(lecturesSchema.getEndTime());
		originalSchema.setUser(lecturesSchema.getUser());
		originalSchema.setInstructor(lecturesSchema.getInstructor());
		originalSchema.setAdmin(lecturesSchema.getAdmin());
		originalSchema.setRoom(lecturesSchema.getRoom());
		
		getMongo().save(originalSchema);
		
		return 1;
	}
	
}
