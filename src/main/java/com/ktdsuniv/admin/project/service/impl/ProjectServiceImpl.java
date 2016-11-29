package com.ktdsuniv.admin.project.service.impl;

import com.ktdsuniv.admin.project.biz.ProjectBiz;
import com.ktdsuniv.admin.project.service.ProjectService;

public class ProjectServiceImpl implements ProjectService{

	private ProjectBiz projectBiz;
	
	public void setProjectBiz(ProjectBiz projectBiz) {
		this.projectBiz = projectBiz;
	}
	
}
