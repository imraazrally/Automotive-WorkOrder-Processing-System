package com.imraazrally.autoshop.model.login;

public class KeyToPermissionAdaptor extends Permission {
	public KeyToPermissionAdaptor(Key key) {
		super(key.getRole());
	}
}
