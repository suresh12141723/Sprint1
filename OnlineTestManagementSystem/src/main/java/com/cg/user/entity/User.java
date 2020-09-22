package com.cg.user.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="lpu_exam_user")
public class User {
	@Id
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name", length=25)
	private String userName;
	@Column(name="password", length=25)
	private String password;
	@Column(name="role", length=25)
	private String role;
	
	
	// @ManyToOne
	 
	// @JoinColumn(name="movie_id", referencedColumnName="movie_id") 
	// private Movie movie;
	
	//@ManyToOne
	//@JoinColumn(name="theaterId", referencedColumnName = "theaterId")
	//private Theater theater;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	


	public User(int userId, String userName, String password, String role) {
		super();
		this.userId=userId;
		this.userName=userName;
		this.password=password;
		this.role=role;
		//this.theater=theater;
	}
	public User() {
		
	}

}
//Run the command on SQL to see the Table
//SELECT * FROM User1.lpu_exam_user;
//Postman Commands
//http://localhost:8080/getuser            //To Getuser
//http://localhost:8080/update/4001        //To Update user ById
//http://localhost:8080/delete/4001        //To Delete user ById