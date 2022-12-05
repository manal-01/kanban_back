package org.rygn.kanban.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.rygn.kanban.domain.Developer;
import org.rygn.kanban.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController

public class DevelopperController {
	
	@Autowired
	private DeveloperService developerService;
	@GetMapping("/developers")
	
	
	List<Developer> findAllDevelopers() {
		return this.developerService.findAllDevelopers();
	}

	@GetMapping("/developers/{id}")
	
	Developer findDeveloper(@PathVariable Long id) {
		return developerService.findDeveloperById(id).get();
		
	}


}