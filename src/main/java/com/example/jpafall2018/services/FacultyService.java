package com.example.jpafall2018.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpafall2018.models.Faculty;
import com.example.jpafall2018.repositories.FacultyRepository;

@RestController
public class FacultyService {
	@Autowired
	FacultyRepository fr;
	@GetMapping("/api/faculty")
	public List<Faculty> findAllFaculty() {
		return (List<Faculty>) fr.findAll();
	}
}
