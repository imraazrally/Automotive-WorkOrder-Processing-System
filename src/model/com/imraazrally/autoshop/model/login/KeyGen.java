package com.imraazrally.autoshop.model.login;

import com.imraazrally.autoshop.model.login.services.KeyGenService;
import java.sql.*;

/*
 	A KeyGen is a service that spaws a Key for a given user. (A Key holds permissions)
 	The KeyGen indirectely connects to the database and checks the user role in the database.
 	Based on the user permissions, the getKey() will return a Key.
 */

public class KeyGen implements KeyGenService {
	public Key getKey(User user) {
		return new Key(user);
	}
}
