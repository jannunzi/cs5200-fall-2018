package com.example.jpafall2018.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student extends User {
	private int graduatingYear;
	private boolean hasGrant;
	
	  @ManyToMany
	  @JoinTable(name="ENROLLMENT",
	     joinColumns=@JoinColumn(name="STUDENT_ID",
	     referencedColumnName="ID"),
	     inverseJoinColumns=@JoinColumn(name=
	        "SECTION_ID", referencedColumnName="ID"))
	  private List<Section> enrolledSections;

	  public void enrollSection(Section section) {
		   this.enrolledSections.add(section);
		   if(!section.getEnrolledStudents().contains(this))
		       section.getEnrolledStudents().add(this);
		}

	
	public int getGraduatingYear() {
		return graduatingYear;
	}
	public void setGraduatingYear(int graduatingYear) {
		this.graduatingYear = graduatingYear;
	}
	public boolean isHasGrant() {
		return hasGrant;
	}
	public void setHasGrant(boolean hasGrant) {
		this.hasGrant = hasGrant;
	}


	public List<Section> getEnrolledSections() {
		return enrolledSections;
	}


	public void setEnrolledSections(List<Section> enrolledSections) {
		this.enrolledSections = enrolledSections;
	}
}
