package com.example.jpafall2018;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jpafall2018.models.Faculty;
import com.example.jpafall2018.models.Student;
import com.example.jpafall2018.models.User;

public class UserDao {
	private static UserDao instance = null;
	private UserDao() {}
	private static UserDao getInstance() {
		if(instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet results = null;
	private final String DB_URL = "jdbc:mysql://localhost:3306/jpa_fall_2018";
	private final String USERNAME = "cs5200";
	private final String PASSWORD = "cs5200";
	private final String FIND_ALL_USERS = "SELECT * FROM USER";
	public List<User> findAllUsers() {
		List<User> userList = new ArrayList<User>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			results = statement.executeQuery(FIND_ALL_USERS);
			while(results.next()) {
				int id = results.getInt("id");
				String firstName = results.getString("first_name");
				String lastName  = results.getString("last_name");
				String office = results.getString("office");
				Boolean tenure = results.getBoolean("tenure");
				int graduatingYear = results.getInt("graduating_year");
				Boolean hasGrant = results.getBoolean("has_grant");
				String dtype = results.getString("dtype");
				if(dtype.equals("Faculty")) {
					Faculty faculty = new Faculty(id, firstName, lastName, office, tenure);
					userList.add(faculty);
				} else if(dtype.equals("Student")) {
					Student student = new Student(id, firstName, lastName, graduatingYear, hasGrant);
					userList.add(student);
				} else if(dtype.equals("Faculty")) {
					User user = new User(id, firstName, lastName);
					userList.add(user);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	public static void main(String[] args) {
		UserDao dao = UserDao.getInstance();
		List<User> userList = dao.findAllUsers();
		for(User user: userList) {
			System.out.println(user);
		}
	}
}