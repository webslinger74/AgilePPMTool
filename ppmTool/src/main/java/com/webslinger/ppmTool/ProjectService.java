package com.webslinger.ppmTool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Iterable<Project> findProjects() {
		Iterable<Project> myinstances = projectRepository.findAll();
		return myinstances;
	}
	
	public Project saveOrUpdateProject(Project entity) {
		Project myproject = projectRepository.save(entity);
		return myproject;
	}
	
}
