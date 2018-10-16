package com.example.jpafall2018;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpafall2018.models.Faculty;
import com.example.jpafall2018.repositories.FacultyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFaculty {

	@Autowired
	FacultyRepository fr;
	
	@Test
	public void testCreateFaculty() {
		Faculty tim = new Faculty("tim", "tim", "Tim", "Birns Lee", "A101", true);
		fr.save(tim);
	}

}
