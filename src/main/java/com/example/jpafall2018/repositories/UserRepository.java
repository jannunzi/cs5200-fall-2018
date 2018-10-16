package com.example.jpafall2018.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.jpafall2018.models.User;

public interface UserRepository
	extends CrudRepository<User, Integer> {
	
	@Query("SELECT user FROM User user WHERE user.username=:username")
	public User findUserByUsername(
			@Param("username") String username);

	@Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
	public User findUserByCredentials(
			@Param("username") String username,
			@Param("password") String password);
}
