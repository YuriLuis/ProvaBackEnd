package com.provabackend.provabackend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.provabackend.provabackend.classes.Area;
import com.provabackend.provabackend.repositories.AreaRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/areas")
public class AreaController {
	


	@Autowired
	private AreaRepository repository;
	
	@GetMapping
	public List<Area> findAll(){
		
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid Area area) {	
			
			return  ResponseEntity.ok(repository.save(area));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Integer id){
		
		Optional<Area> area = repository.findById(id);
		
		if (area.isPresent()) {
			
			return ResponseEntity.ok(area.get());		
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
