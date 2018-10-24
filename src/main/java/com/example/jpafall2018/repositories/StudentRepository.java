package com.example.jpafall2018.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.jpafall2018.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
