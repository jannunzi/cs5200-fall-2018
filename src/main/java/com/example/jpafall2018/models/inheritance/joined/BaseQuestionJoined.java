package com.example.jpafall2018.models.inheritance.joined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "JOINED_BASE_QUESTION")
@Inheritance(strategy=InheritanceType.JOINED)
public class BaseQuestionJoined {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private int points;
  private String title, description, instructions;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPoints() {
	return points;
}
public void setPoints(int points) {
	this.points = points;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getInstructions() {
	return instructions;
}
public void setInstructions(String instructions) {
	this.instructions = instructions;
}
  
}
