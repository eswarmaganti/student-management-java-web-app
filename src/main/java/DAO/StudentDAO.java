package DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import Beans.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class StudentDAO {
	private String dbUrl;
	private String dbUsername;
	private String dbPassword;

	public StudentDAO(String dbUrl, String dbUsername, String dbPassword) {
		this.dbUrl = dbUrl;
		this.dbPassword = dbPassword;
		this.dbUsername = dbUsername;
	}

	// method to return the connection object
	private Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			System.out.println("*** Success: Successfully connected to PostgreSQL Database ***");
			return conn;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	public Map saveStudentDetails(Student student) {
		
		Map<String,String> result = new HashMap<String,String>();
		try {
			Connection conn = this.getConnection();
			
			if (conn == null) {
				throw new Exception("Unable to connect to database, try again later");
			}
			
			
			// Validate the email id 
			PreparedStatement getStudentPS = conn.prepareStatement("SELECT * FROM students WHERE email=?");
			getStudentPS.setString(1,student.getEmail());
			
			ResultSet studentRS = getStudentPS.executeQuery();
			
			
			if (studentRS.next()) {
				
				String email = studentRS.getString("email");
				
				if (email.equals(student.getEmail())) {					
					result.put("message","Student with email address "+student.getEmail()+" is already existed");
					result.put("status","error");
					return result;
				}
			}
			
			
			// insert new record if no records found
			PreparedStatement ps = conn.prepareStatement("INSERT INTO students(firstname, lastname, email, bio) VALUES(?,?,?,?)");
			
			// assigning the values to prepares statement
			
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getBio());
			
			System.out.println(ps);
			
			int rowsEffected = ps.executeUpdate();
			
			System.out.println(rowsEffected);
			conn.close();
			result.put("message","Student Registered Successfully");
			result.put("status","success");
			
			return result;
			
		}catch(Exception e) {
			System.out.println("*** Error: Runtime exception occured while saving student details: "+e.getMessage()+" ***");
			System.out.println("*** Error: Runtime exception occured while saving student details: "+e.toString()+" ***");
			e.printStackTrace();
			result.put("message", e.getMessage());
			result.put("status", "error");
			return result;
		}
	}
	
	public List<Student> getStudentsDetails() {
		try {
			Connection conn = this.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
			
			ResultSet resultSet = ps.executeQuery();
			
			List<Student> students = new ArrayList<Student>();
			
			while (resultSet.next()) {
				Student student = new Student();
				
				student.setID(resultSet.getInt("id"));
				student.setFirstName(resultSet.getString("firstname"));
				student.setLastName(resultSet.getString("lastname"));
				student.setEmail(resultSet.getString("email"));
				student.setBio(resultSet.getString("bio"));
				student.setCreatedAt(resultSet.getTimestamp("created_at"));
				
				students.add(student);
			}
			
			return students;
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
