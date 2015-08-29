package com.imraazrally.autoshop.tests.login;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.imraazrally.autoshop.model.login.Key;
import com.imraazrally.autoshop.model.login.KeyGen;
import com.imraazrally.autoshop.model.login.LoginConsts;
import com.imraazrally.autoshop.model.login.LoginDb;
import com.imraazrally.autoshop.model.login.User;
import com.imraazrally.autoshop.model.login.KeyVerifier;
public class LoginTest{	
	User user;
	Key key;
	Connection dbConnection;
	
	@Test	
	public void main() throws SQLException{
		UserAndKeyObjects();
		KeyGen();
		KeyVerifier();
	}
	
	// Test Objects [User, Key, LoginDb]
	private void UserAndKeyObjects() throws SQLException{
		//Creating Database Connection and making sure that it's connected 
		dbConnection=new LoginDb().getConnection(LoginConsts.DB_URL, LoginConsts.DB_USER,LoginConsts.DB_PASS);
		assertNotNull(dbConnection);
		
		// Creating a user object (fact: This user has admin previlages)
		String username="imraaz";
		String password="1234";
		user=new User(username,password,dbConnection);

		//Creating key object
		key=new Key(user);
		assertEquals(username, key.getUsername());
		assertEquals(password, key.getPassword());		
		assertEquals(LoginConsts.ADMIN,key.getRole()); // Imraaz has admin level permission
	}
	
	// Test Objects [KeyGen]
	private void KeyGen(){
		//Using a keyGen service to spawn a key for the same user and comparing it to the current key.
		//if the roles match, it means the keyGen is generating proper keys.
		KeyGen keygen=new KeyGen();
		Key keyFromKeyGen=keygen.getKey(user);
		assertEquals(key.getRole(),keyFromKeyGen.getRole());
	}
	
	//Test Objects[Key Verifier]
	private void KeyVerifier(){
		@SuppressWarnings("serial")
		ArrayList<Integer> permissions=new ArrayList<Integer>(){{
			add(LoginConsts.GUEST);
			add(LoginConsts.BLOCKED);
		}};
		
		KeyVerifier verifier=new KeyVerifier(key, permissions);
		
		//We passed in an admin level key. but the only GUEST & BLOCKED are allowed. Which means the verifier.verify() should return false
		assertEquals(false,verifier.verify());
	}
}
