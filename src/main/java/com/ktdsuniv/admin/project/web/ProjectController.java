package com.ktdsuniv.admin.project.web;

import org.springframework.stereotype.Controller;

import com.ktdsuniv.admin.project.service.ProjectService;

@Controller
public class ProjectController {

	private ProjectService projectService;
	
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
}
