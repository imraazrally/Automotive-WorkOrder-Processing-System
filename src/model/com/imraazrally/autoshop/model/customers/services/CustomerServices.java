package com.imraazrally.autoshop.model.customers.services;

import com.imraazrally.autoshop.model.customers.AddCustomerAction;
import com.imraazrally.autoshop.model.customers.CustomerAction;

public interface CustomerServices {
	public boolean execute(CustomerAction action);
}
