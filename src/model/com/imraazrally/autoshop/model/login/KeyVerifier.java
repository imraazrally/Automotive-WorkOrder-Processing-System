package com.imraazrally.autoshop.model.login;

import java.util.ArrayList;

public class KeyVerifier {
	private Key key;
	private ArrayList<Integer> permissions;
	
	public KeyVerifier(Key key, ArrayList<Integer> permissions){
		this.key=key;
		this.permissions=permissions;
	}
	
	public boolean verify(){
		try{
			if (permissions.contains(key.getRole())) return true;
		}catch(Exception e){e.printStackTrace();}
		return false;
	}
}
