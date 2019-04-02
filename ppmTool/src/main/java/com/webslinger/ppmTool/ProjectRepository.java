package com.webslinger.ppmTool;

import java.util.Optional;
import com.webslinger.ppmTool.Project;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	public Optional<Project> findByProjectIdentifier(String projectId);
		
}
