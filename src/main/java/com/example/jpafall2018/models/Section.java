package com.example.jpafall2018.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Section {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title; 
	@ManyToMany(mappedBy="enrolledSections")
	private List<Student> enrolledStudents;
	
	public void enrollStudent(Student student) {
	   this.enrolledStudents.add(student);
	   if(!student.getEnrolledSections().contains(this)) {
	       student.getEnrolledSections().add(this);
	   }
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}
	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
}
