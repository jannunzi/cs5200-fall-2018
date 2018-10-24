package com.example.jpafall2018.models.inheritance.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="JOINED_FILL_IN_THE_BLANK_QUESTION")
public class FillInTheBlankQuestionJoined
  extends BaseQuestionJoined {
  @Column(name = "VARIABLES", nullable = false)
  private String variables;

public String getVariables() {
	return variables;
}

public void setVariables(String variables) {
	this.variables = variables;
}
}
