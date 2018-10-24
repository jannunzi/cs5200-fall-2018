package com.example.jpafall2018.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpafall2018.models.User;
import com.example.jpafall2018.repositories.UserRepository;

@RestController
public class UserService {
	@Autowired
	UserRepository ur;
	/**
	 * Returns list of all users of the correct type,
	 * i.e., Faculty instances will have all faculty properties,
	 * and Student instances will have all student properties
	 */
	@GetMapping("/api/user")
	public List<User> findAllUsers() {
		return (List<User>) ur.findAll();
	}
}
