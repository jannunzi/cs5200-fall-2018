package com.example.jpafall2018.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpafall2018.models.Course;
import com.example.jpafall2018.repositories.CourseRepository;

@RestController
public class CourseService {
	List<Course> myCourses = new ArrayList<Course>();
	
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/api/course")
	public List<Course> createCourse(
			@RequestBody Course course) {
		myCourses.add(course);
		return myCourses;
	}
	
	@GetMapping("/api/course")
	public List<Course> findAllCourse() {
		return (List<Course>) courseRepository.findAll();
	}
	
	@GetMapping("/api/course/{courseId}")
	public Course findCourseById(
			@PathVariable("courseId") int id
			) {
		return courseRepository.findById(id).get();
	}
	
	@PutMapping("/api/course/{courseId}")
	public List<Course> updateCourse(
			@PathVariable("courseId") int courseId,
			@RequestBody Course newCourse) {
		Course course = courseRepository.findById(courseId).get();
		course.setTitle(newCourse.getTitle());
		courseRepository.save(course);
		return (List<Course>) courseRepository.findAll();
	}

	@DeleteMapping("/api/course/{courseId}")
	public List<Course> deleteCourse(
			@PathVariable("courseId") int id) {
		courseRepository.deleteById(id);
		return (List<Course>) courseRepository.findAll();
	}

	@GetMapping("/api/myCourse")
	public Course getMeACourse() {
		Course course = new Course();
		course.setId(123);
		course.setTitle("CS5200");
		return course;
	}
}
