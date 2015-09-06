package com.imraazrally.autoshop.model.login;

import java.sql.*;

import org.hibernate.Query;
import org.hibernate.Session;

/*
 	A KeyGen is a service that spaws a Key for a given user. (A Key holds permissions)
 	The KeyGen indirectely connects to the database and checks the user role in the database.
 	Based on the user permissions, the getKey() will return a Key.
 */

public class KeyGen {
	private Session session;
	
	public KeyGen(Session session){
		this.session=session;
	}
	
	public Key getKey(String username, String password){
		String SQL=String.format(LoginConsts.CHECK_CREDENTIALS_QUERY, username,password);
		try{
			Query query=session.createSQLQuery(SQL).addEntity(Key.class);
			return (Key)query.list().get(0);
		}catch(Exception e){e.printStackTrace();}
		return new Key(LoginConsts.BLOCKED, "", "");
	}
}
