package com.example.jpafall2018.models.inheritance.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="JOINED_TRUE_OR_FALSE_QUESTION")
public class TrueOrFalseQuestionJoined
  extends BaseQuestionJoined {
  @Column(name = "IS_TRUE", nullable = false)
  private Boolean isTrue;

public Boolean getIsTrue() {
	return isTrue;
}

public void setIsTrue(Boolean isTrue) {
	this.isTrue = isTrue;
}
}
