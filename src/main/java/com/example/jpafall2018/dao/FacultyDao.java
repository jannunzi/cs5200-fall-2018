package com.example.jpafall2018.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jpafall2018.models.Course;
import com.example.jpafall2018.models.Faculty;

public class FacultyDao {
	private static FacultyDao instance = null;
	private static ConnectionPool connectionPool = null;
	private FacultyDao() {}
	public static FacultyDao getInstance() {
		if(instance == null) {
			instance = new FacultyDao();
			connectionPool = ConnectionPool.getInstance();
		}
		return instance;
	}
	Connection connection = null;
	Statement statement = null;
	PreparedStatement pStatement = null;
	ResultSet results = null;
	private final String FIND_ALL_FACULTY = "SELECT * FROM USER WHERE dtype='Faculty'";
	private final String GET_AUTHORED_COURSES = "SELECT * FROM COURSE WHERE author_id=?";
	public List<Course> getAuthoredCourses(int facultyId) {
		List<Course> courses = new ArrayList<Course>();
		connection = connectionPool.getConnection();
		try {
			pStatement = connection.prepareStatement(GET_AUTHORED_COURSES);
			pStatement.setInt(1, facultyId);
			results = pStatement.executeQuery();
			while(results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				Course course = new Course(id, title);
				courses.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}
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
		return facultyList;
	}
	public static void main(String[] args) {
		FacultyDao dao = FacultyDao.getInstance();
		List<Faculty> facultyList = dao.findAllFaculty();
		for(Faculty faculty: facultyList) {
			System.out.println(faculty);
			List<Course> authoredCourses = faculty.getAuthoredCoursesLazy();
			for(Course course: authoredCourses) {
				System.out.println(course);
			}
		}
	}
}
