package com.example.jpafall2018.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jpafall2018.models.Faculty;

public class FacultyDao {
	private static FacultyDao instance = null;
	private FacultyDao() {}
	private static FacultyDao getInstance() {
		if(instance == null) {
			instance = new FacultyDao();
		}
		return instance;
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet results = null;
	private final String DB_URL = "jdbc:mysql://localhost:3306/jpa_fall_2018";
	private final String USERNAME = "cs5200";
	private final String PASSWORD = "cs5200";
	private final String FIND_ALL_FACULTY = "SELECT * FROM USER WHERE dtype='Faculty'";
	public List<Faculty> findAllFaculty() {
		List<Faculty> facultyList = new ArrayList<Faculty>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			results = statement.executeQuery(FIND_ALL_FACULTY);
			while(results.next()) {
				int id = results.getInt("id");
				String firstName = results.getString("first_name");
				String lastName  = results.getString("last_name");
				String office = results.getString("office");
				Boolean tenure = results.getBoolean("tenure");
				Faculty faculty = new Faculty(id, firstName, lastName, office, tenure);
				facultyList.add(faculty);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facultyList;
	}
	public static void main(String[] args) {
		FacultyDao dao = FacultyDao.getInstance();
		List<Faculty> facultyList = dao.findAllFaculty();
		for(Faculty faculty: facultyList) {
			System.out.println(faculty);
		}
	}
}
