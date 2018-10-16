package com.example.jpafall2018;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpafall2018.models.User;
import com.example.jpafall2018.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser {

	@Autowired
	UserRepository userRepository;
	
	@Test
	public void testFindAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		
		for(User user: users) {
			System.out.println(user.getFirstName());
		}
	}
	
	@Test
	public void testFindUserById() {
		Optional<User> oUser = userRepository.findById(1);
		if(oUser.isPresent()) {
			User user = oUser.get();
			System.out.println(user.getFirstName());
		}
	}

	@Test
	public void testFindUserByUsername() {
	   User user = userRepository.findUserByUsername("bob");
	   System.out.println(user.getFirstName());
	}
	
	@Test
	public void testFindUserByCredentials() {
	   User user = userRepository.findUserByCredentials("charlie", "charlie");
	   System.out.println(user.getFirstName());
	}

	@Test
	public void testCreateUser() {
	   User bob = new User("dan", "dan", "Dan", "Brown");
	   userRepository.save(bob);
	}

	@Test
	public void testUpdateUser() {
		User alice = userRepository.findUserByUsername("alice");
		alice.setFirstName("Alicia");
		userRepository.save(alice);
	}
	
	
	
	
	
}
