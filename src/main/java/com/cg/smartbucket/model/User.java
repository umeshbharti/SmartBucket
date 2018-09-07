package com.cg.smartbucket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User {

	@Id
	@Column(name="id",nullable=false,unique=true)
	private int id;
	@Column(name="username",nullable=false)
	private String name;
	@Column(name="email",nullable=false,unique=true)
	private String email;
	@Column(name="contactnumber",nullable=false,unique=true)
	private long number;
	@Column(name="password",nullable=false,unique=true)
	private String password;
	@Column(name="isAdmin",nullable=false,unique=true)
	private boolean isAdmin=false;
	
	public User() {
		super();
	}

	public User(String name, String email, long number, String password) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}	
}
