package com.ktdsuniv.admin.lecture.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.admin.lecture.service.LectureService;

import common.pageVO.PageListVO;
import common.pageVO.SearchVO;
import common.util.pager.ClassicPageExplorer;
import common.util.pager.PageExplorer;
import lecture.schema.LecturesSchema;

@Controller
public class LectureController {

	private LectureService lectureService;
	
	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}
	
	/*
	 * 강의 추가 페이지 보여주기
	 * 유저 목록, 강사 목록, 룸 목록, 담당자 목록을 가져와야 한다.
	 */
	@RequestMapping("/lecture/addLecture")
	public ModelAndView viewAddLecturePage(){
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/lecture/addLecture");
		
		return view;
	}
	
	/*
	 * 강의 추가 작동 
	 */
	@RequestMapping("/lecture/doAddLectureAction")
	public ModelAndView doAddLectureAction(LecturesSchema lecturesSchema){
		ModelAndView view = new ModelAndView();
		
		boolean isSuccess = lectureService.addLecture(lecturesSchema);
		
		view.setViewName("redirect:/lecture/list");
		return view;
	}
	
	/*
	 *  강의 삭제, PathVariable로 아이디를 불러와 삭제 
	 */
	@RequestMapping("/lecture/doDeleteLectureAction/{letureId}")
	public ModelAndView doDeleteLectureAction(@PathVariable String letureId){
		ModelAndView view = new ModelAndView();
		boolean isSuccess = lectureService.deleteLecture(letureId);
		view.setViewName("redirect:/lecture/list");
		return view;
	}
	
	
	/*
	 * 강의 리스트를 불러온다.
	 */
	@RequestMapping("/lecture/list")
	public ModelAndView viewLectureListPage(SearchVO searchVO){
		ModelAndView view = new ModelAndView();
		
		PageListVO lectureList = lectureService.getlectureList(searchVO);
		PageExplorer pageExplorer = new ClassicPageExplorer(lectureList.getPager());
		String pager = pageExplorer.getPagingList("pageNumber", "[@]", "<<", ">>", "searchForm");
		view.addObject("paging", pager);
		view.addObject("lectureList", lectureList);
		view.setViewName("lecture/list");
		return view;
	}
	
	@RequestMapping("/lecture/detail/{letureId}")
	public ModelAndView viewDetailLecurePage(@PathVariable String letureId){
		ModelAndView view = new ModelAndView();
		LecturesSchema lecture = lectureService.getDetailLecture(letureId);
		view.addObject("lecture", lecture);
		view.setViewName("lecture/detail");
		return view;
	}
	
	/*
	 * 수정페이지 보기
	 */
	@RequestMapping("/lecture/modify/{letureId}")
	public ModelAndView viewModifyPage(@PathVariable String letureId){
		ModelAndView view = new ModelAndView();
		LecturesSchema lecture = lectureService.getDetailLecture(letureId);
		view.addObject("lecture", lecture);
		view.setViewName("lecture/modify");
		return view;
	}
	/*
	 * 수정페이지 처리
	 */
	@RequestMapping("/lecture/doModifyLectureAction")
	public ModelAndView doModifyLecture(LecturesSchema lecturesSchema){
		ModelAndView view = new ModelAndView();
		boolean isSuccess = lectureService.updateModifyLecture(lecturesSchema);
		view.setViewName("redirect:/lecture/detail"+lecturesSchema.getId());
		return view;
	}
	
}
