package com.imraazrally.autoshop.model.login.services;

import com.imraazrally.autoshop.model.login.Key;
import com.imraazrally.autoshop.model.login.User;

public interface KeyGenService {
	abstract Key getKey(User user);
}
