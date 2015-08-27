package com.imraazrally.autoshop.model.login;

import java.sql.Connection;
import java.sql.ResultSet;

import com.imraazrally.autoshop.model.login.services.Role;

public class User implements Role {
	private final String username;
	private final String password;
	private final Connection dbConnection;

	public User(String username, String password, Connection dbConnection) {
		this.username = username;
		this.password = password;
		this.dbConnection = dbConnection;
	}

	public String getUsername() {
		return new String(username);
	}

	public String getPassword() {
		return new String(password);
	}

	public int getRole() {
		// Formatting Query
		String query = String.format(LoginConsts.CHECK_CREDENTIALS_QUERY, username, password);

		try {
			// Executing Query and getting the role Id
			ResultSet results = dbConnection.createStatement().executeQuery(query);
			// Select the first row (since there can only be one username)
			results.next();
			// returning the role
			return results.getInt(LoginConsts.ROLE_ID_COL);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// If query returned empty or no role id was found, we will return the
		// default blocked state.
		return LoginConsts.BLOCKED;
	}

}
