package com.imraazrally.autoshop.model.login;

import java.util.HashMap;
import java.util.Map;

public class LoginConsts {
	// Database Login information
	public static final String DB_URL = "jdbc:mysql://localhost:3306/autoshop";
	public static final String DB_USER = "root";
	public static final String DB_PASS = "1234";

	// Users table info
	public static final String CHECK_CREDENTIALS_QUERY = "SELECT * FROM users WHERE username='%s' and password='%s'";
	public static final String ROLE_ID_COL = "role";

	// Home Page Views and RoleIds
	public static final int BLOCKED = 0;
	public static final int ADMIN = 1;
	public static final int GUEST = 2;

	@SuppressWarnings("serial")
	public static Map<Integer, String> roleIdToView = new HashMap<Integer, String>() {
		{
			put(BLOCKED, "loginFailurePage");
			put(ADMIN, "adminPage");
			put(GUEST, "guestPage");
		}
	};

	private LoginConsts() {
	}
}
