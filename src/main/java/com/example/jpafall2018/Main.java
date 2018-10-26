package com.example.jpafall2018;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.jpafall2018.models.Course;
import com.example.jpafall2018.repositories.CourseRepository;

@Component
public class Main implements CommandLineRunner {
	@Autowired
	CourseRepository cr;
	public void run(String... args) {
		List<Course> courses = (List<Course>) cr.findAll();
		for(Course course: courses) {
			System.out.println(course);
		}
	}
}
