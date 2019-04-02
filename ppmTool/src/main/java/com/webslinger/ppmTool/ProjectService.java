package com.webslinger.ppmTool;

import java.util.Optional;

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
	
	public Optional<Project> getProductById(Long Id) {
		Optional<Project> retProjectById = projectRepository.findById(Id);
		return retProjectById;
	}
	
	public Optional<Project> findProjectByIdentifier(String projectId) {
	Optional<Project> projectIdentifier1 = projectRepository.findByProjectIdentifier(projectId);
		return projectIdentifier1;
	}
	
}
