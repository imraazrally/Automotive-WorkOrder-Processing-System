package com.imraazrally.autoshop.model.login;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="users")
public class Key {
	@Id
	private String username;
	private String password;
	private int role;

	public Key(){}
	
	public Key(int role, String username, String password) {
		this.role = role;
		this.username = username;
		this.password = password;
	}
	
	public Key(String username){
		this.username=username;
	}

	public void setRole(int role){
		this.role=role;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public int getRole() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
