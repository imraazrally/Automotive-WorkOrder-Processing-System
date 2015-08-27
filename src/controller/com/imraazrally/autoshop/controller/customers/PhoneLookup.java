package com.imraazrally.autoshop.controller.customers;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.imraazrally.autoshop.model.customers.Customer;
import com.imraazrally.autoshop.model.customers.SelectCustomerUsingPhone;

@Controller
public class PhoneLookup {
	
	@RequestMapping("/phoneLookup")
	public ModelAndView phoneLookup(
			@RequestParam (value="phone") String phoneNo, 
			HttpServletRequest request
		){
		
		//Which view to forward the results to ?
		ModelAndView target=new ModelAndView("customers/phoneLookupResults");
		
		//Getting Database connection from session
		Connection dbConnection=(Connection) request.getSession().getAttribute("dbConnection");
		
		//Given a phone number, getting a List of Customers which matches the phone number
		try{
			ArrayList<Customer> customers=new SelectCustomerUsingPhone(phoneNo,dbConnection).getCustomers();
			//Storing the list of customers as an attribute
			target.addObject("customers", customers);
		}catch(Exception e){e.printStackTrace();}
		
		//Forwaring the user to display selections page
		return target;
	}
}
