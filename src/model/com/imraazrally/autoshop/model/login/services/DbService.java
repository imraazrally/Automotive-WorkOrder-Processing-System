package com.imraazrally.autoshop.model.login.services;

import java.sql.Connection;

public interface DbService {
	static Connection dbConnection = null;

	public abstract Connection getConnection(String url, String username, String password);
}
