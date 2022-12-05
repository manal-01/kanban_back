package org.rygn.kanban.service;

import java.util.List;
import java.util.Optional;

import org.rygn.kanban.domain.Developer;

public interface DeveloperService {

	public List<Developer> findAllDevelopers();

	Optional<Developer> findDeveloperById(Long id);
	}

