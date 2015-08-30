package com.imraazrally.autoshop.model.login;

import java.util.ArrayList;

public class KeyVerifier {
	private Key key;
	private PermissionWallet permissions;
	
	public KeyVerifier(Key key, PermissionWallet permissions){
		this.key=key;
		this.permissions=permissions;
	}
	
	public boolean verify(){
		try{
			if (permissions.hasPermit(new KeyToPermissionAdaptor(key))) return true;
		}catch(Exception e){e.printStackTrace();}
		return false;
	}
}
