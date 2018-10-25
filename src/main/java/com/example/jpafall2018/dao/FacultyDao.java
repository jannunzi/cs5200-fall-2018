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
	private static ConnectionPool connectionPool = null;
	private FacultyDao() {}
	private static FacultyDao getInstance() {
		if(instance == null) {
			instance = new FacultyDao();
			connectionPool = ConnectionPool.getInstance();
		}
		return instance;
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet results = null;
	private final String FIND_ALL_FACULTY = "SELECT * FROM USER WHERE dtype='Faculty'";
	public List<Faculty> findAllFaculty() {
		List<Faculty> facultyList = new ArrayList<Faculty>();
		try {
			connection = connectionPool.getConnection();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectionPool.closeConnection();
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
