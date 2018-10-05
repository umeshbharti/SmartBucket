package com.cg.smartbucket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_details")
public class User {

	@Id
	@GenericGenerator(name="ref",strategy="identity")
	@GeneratedValue(generator="ref")
	@Column(name="id",nullable=false,unique=true)
	private int id;
	
	@Column(name="username",nullable=false)
	private String name;
	
	@Column(name="email",nullable=false,unique=true)
	private String email;
	
	@Column(name="contactnumber",nullable=false,unique=true)
	private long number;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Transient
	private String repeatPassword;
	
	@OneToOne
	@JoinColumn(name="role_id")
	private UserRole role = new UserRole(1,"USER");
	
	@Column(name="enabled")
	private boolean enabled=true;
	
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
	
	public UserRole getUserrole() {
		return role;
	}

	public void setUserrole(UserRole role) {
		this.role = role;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
