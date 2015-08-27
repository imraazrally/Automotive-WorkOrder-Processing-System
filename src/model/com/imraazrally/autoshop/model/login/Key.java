package com.imraazrally.autoshop.model.login;

/*
 A KEY is used to store user pemissions (called roles)
 eg roles: Admin, Guests,...etc
 */
public class Key {
	private final int role;
	private final String username;
	private final String password;

	public Key(User user) {
		this.role = user.getRole();
		this.username = user.getUsername();
		this.password = user.getPassword();
	}

	public int getRole() {
		return role;
	}

	public String getUsername() {
		return new String(username);
	}

	public String getPassword() {
		return new String(password);
	}
}
