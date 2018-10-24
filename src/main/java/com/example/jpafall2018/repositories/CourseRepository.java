package com.example.jpafall2018.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.jpafall2018.models.Course;

public interface CourseRepository
	extends CrudRepository<Course, Integer> {

}
