package com.imraazrally.autoshop.controller.customers;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.imraazrally.autoshop.model.customers.Customer;
import com.imraazrally.autoshop.model.customers.CustomerAction;
import com.imraazrally.autoshop.model.customers.CustomerProfile;
import com.imraazrally.autoshop.model.customers.CustomerServices;
import com.imraazrally.autoshop.model.customers.RetrieveCustomerUsingId;
import com.imraazrally.autoshop.model.vehicle.Vehicle;
import com.imraazrally.autoshop.model.vehicle.VehicleInfo;
import com.imraazrally.autoshop.model.vehicle.VehicleStorage;

@Controller
public class Profile {
	
	@RequestMapping("/customerProfile")
	public ModelAndView customerProfileHome(
	
			@RequestParam (value="id") String id,
			HttpServletRequest request
	
	){
		//Which view to forward the customer to ?
		ModelAndView target=new ModelAndView("customers/customerProfile");
		//Retrieving Database Connection from Session
		Connection dbConnection = (Connection) request.getSession().getAttribute("dbConnection");
		//Building Customer based on Input parameter from request (customerId)
		Customer customer=new RetrieveCustomerUsingId(dbConnection,id).getCustomer();
		//Building a Profile
		CustomerProfile profile=new CustomerProfile(customer,new VehicleStorage());
		//Forwarind Page
		target.addObject("profile",profile);
		return target;
	}
}