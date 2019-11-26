package com.provabackend.provabackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.provabackend.provabackend.classes.Project;
import com.provabackend.provabackend.classes.tot.Tot;
import com.provabackend.provabackend.repositories.ProjectRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/projects")
public class ProjectController {
	


	@Autowired
	private ProjectRepository repository;
	
	@GetMapping
	public List<Project> findAll() {
		return repository.findAll(Sort.by("nameProject"));
	}
	
	@GetMapping("/valorTotal")	
	public List<Tot> findTot() {
		return repository.findTot();
	}
	

	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody  Project project) {	

		return  ResponseEntity.ok(repository.save(project));
		
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<?> find(@PathVariable("id") Integer id){
		
		Optional<Project> project = repository.findById(id);
		
		if (project.isPresent()) {
			
			return ResponseEntity.ok(project.get());		
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("{id}")
	public void deletePorId(@PathVariable("id") Integer id) {

		if (repository.findById(id) != null) {
			
			repository.deleteById(id);
		}
	}

}
