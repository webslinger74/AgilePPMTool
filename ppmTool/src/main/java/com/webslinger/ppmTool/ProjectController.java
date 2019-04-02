package com.webslinger.ppmTool;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("")
	public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult result) {
			System.out.println("the back has been seen!");
		if(result.hasErrors()) {
			System.out.println(result + " there are errors!");
				return new ResponseEntity<String>("Invalid object passed", HttpStatus.BAD_REQUEST);
			}
		
		System.out.println("there are no errors");
		Project myproject1 = projectService.saveOrUpdateProject(project);
		return new ResponseEntity<Project>(myproject1, HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<?> getProjects(){
	Iterable<Project> allProjects =	projectService.findProjects();
		
		return new ResponseEntity<Iterable<Project>>(allProjects, HttpStatus.ACCEPTED);	
	}
	
	@GetMapping("/Id")
	public ResponseEntity<?> getProjectById(@RequestParam Long id){
		
		 Optional<Project> getprojectById = projectService.getProductById(id);
		 System.out.println(getprojectById);
		 if(!getprojectById.isPresent()) {
			 return new ResponseEntity<String>("Object with id of " + id + " not fund", HttpStatus.BAD_REQUEST);
		 }
		 return new ResponseEntity<Optional<Project>>(getprojectById, HttpStatus.ACCEPTED); 
		}
	
	@GetMapping("/{Identifier}")
	public ResponseEntity<?> getProjectByIdentifier(@PathVariable String Identifier){
		 Optional<Project> getprojectByIdentifier = projectService.findProjectByIdentifier(Identifier);
		 if(!getprojectByIdentifier.isPresent()) {
			 return new ResponseEntity<String>("Object with an Identifier of " + Identifier + " not fund", HttpStatus.BAD_REQUEST);
		 }
		 return new ResponseEntity<Optional<Project>>(getprojectByIdentifier, HttpStatus.ACCEPTED); 
		}
	}

	

