package com.example.jpafall2018;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpafall2018.models.Course;
import com.example.jpafall2018.models.Faculty;
import com.example.jpafall2018.repositories.CourseRepository;
import com.example.jpafall2018.repositories.FacultyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCourses {

	  @Autowired
	  CourseRepository courseRepository;
	  @Autowired
	  FacultyRepository facultyRepository;
	  
	  @Test
	  public void testAuthoredCourse() {
		   Faculty faculty = facultyRepository.findById(1).get();
		   Course course   = courseRepository.findById(1).get();
//		   course.setAuthor(faculty);
//		   courseRepository.save(course);
		   faculty.authoredCourse(course);
		   facultyRepository.save(faculty);
		}

	  
	  
//	  @Test
	  public void testCreateCourse() {
	     Course course = new Course();
	     course.setTitle("CS5500");
	     courseRepository.save(course);
	}

}
