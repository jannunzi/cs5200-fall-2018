package com.example.jpafall2018;

public class FacultyDao {
	private static FacultyDao instance = null;
	private FacultyDao() {}
	private static FacultyDao getInstance() {
		if(instance == null) {
			instance = new FacultyDao();
		}
		return instance;
	}
}
