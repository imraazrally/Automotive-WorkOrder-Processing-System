package com.imraazrally.autoshop.model.login;

import java.sql.Connection;
import java.sql.DriverManager;

import com.imraazrally.autoshop.model.login.services.DbService;

public class LoginDb implements DbService {
	public Connection getConnection(String url, String username, String password) {
		// We want to make sure that we initialize a new connection only if none
		// is previously initialized
		if (dbConnection == null)
			return init(url, username, password);
		// Each subsequent request, we return the same connection
		return dbConnection;
	}

	public Connection getConnection() {
		return dbConnection;
	}

	private Connection init(String url, String username, String password) {
		// Creating a new connection
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Retruning the connection
		return dbConnection;
	}
}
