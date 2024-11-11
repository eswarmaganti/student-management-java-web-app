package Beans;

import java.io.Serializable;
import java.sql.Timestamp;


public class Student implements Serializable {
	
	private static final long serialVersionUID = -3834606671335993806L;
	
	private String firstname, lastname, email, bio;
	private Timestamp created_at;
	private int id;
	
	public void setID(int id) {
		this.id = id;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
	public void setCreatedAt(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	public String getBio() {
		return bio;
	}
	public Timestamp getCreatedAt() {
		return created_at;
	}
}
