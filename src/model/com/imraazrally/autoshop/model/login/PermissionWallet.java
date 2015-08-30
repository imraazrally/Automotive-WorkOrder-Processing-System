package com.imraazrally.autoshop.model.login;

import java.util.ArrayList;

public class PermissionWallet {
	private ArrayList<Permission> permissions;
	
	public PermissionWallet(){
		permissions=new ArrayList<Permission>();
	}
	
	public void addPermission(Permission permission){
		permissions.add(permission);
	}
	
	public boolean hasPermit(Permission permission){
		for (Permission p:permissions){
			if (p.getPermission()==permission.getPermission()) return true;
		}
		return false;
	}
}
