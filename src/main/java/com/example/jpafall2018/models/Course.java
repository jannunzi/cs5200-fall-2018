package com.example.jpafall2018.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	
	@ManyToOne
	private Faculty author;
	
	public Course(int id, String title) {
		this.id = id;
		this.title = title;
	}
	public Course() {
		// TODO Auto-generated constructor stub
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
	public Faculty getAuthor() {
		return author;
	}
	public void setAuthor(Faculty author) {
		this.author = author;
	     if(!author.getAuthoredCourses()
	    		 .contains(this)) {
    		         author.getAuthoredCourses().add(this);
    		 }
     }
	public String toString() {
		return "\t" + id + ", " + title;
	}
}
