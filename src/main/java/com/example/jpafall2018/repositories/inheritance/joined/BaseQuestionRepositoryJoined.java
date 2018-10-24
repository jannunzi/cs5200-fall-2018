package com.example.jpafall2018.repositories.inheritance.joined;

import org.springframework.data.repository.CrudRepository;

import com.example.jpafall2018.models.inheritance.joined.BaseQuestionJoined;

public interface BaseQuestionRepositoryJoined
	extends CrudRepository<BaseQuestionJoined, Integer>{}
