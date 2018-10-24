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
import com.example.jpafall2018.models.Faculty;
import com.example.jpafall2018.repositories.CourseRepository;
import com.example.jpafall2018.repositories.FacultyRepository;

@RestController
public class CourseService {
	List<Course> myCourses = new ArrayList<Course>();
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	FacultyRepository fr;

	@GetMapping("/api/faculty/{fid}/course")
	public List<Course> findCoursesForFaculty(
			@PathVariable("fid") int fid) {
		Faculty faculty = fr.findById(fid).get();
		return faculty.getAuthoredCourses();
	}

	@PutMapping("/api/faculty/{fid}/course/{cid}")
	public List<Course> addCourseToFaculty(
			@PathVariable("fid") int fid,
			@PathVariable("cid") int cid) {
		Faculty faculty = fr.findById(fid).get();
		Course course = courseRepository.findById(cid).get();
		course.setAuthor(faculty);
		courseRepository.save(course);
		return faculty.getAuthoredCourses();
	}
	@PostMapping("/api/faculty/{fid}/course")
	public List<Course> createCourseForFaculty(
			@PathVariable("fid") int fid,
			@RequestBody Course course) {
		Faculty faculty = fr.findById(fid).get();
		course.setAuthor(faculty);
		course = courseRepository.save(course);
		return faculty.getAuthoredCourses();
	}
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
