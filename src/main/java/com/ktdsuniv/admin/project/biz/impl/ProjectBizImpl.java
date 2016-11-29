package com.ktdsuniv.admin.project.biz.impl;

import com.ktdsuniv.admin.project.biz.ProjectBiz;
import com.ktdsuniv.admin.project.dao.ProjectDao;

public class ProjectBizImpl implements ProjectBiz {

	private ProjectDao projectDao;
	
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	
}
