package com.imraazrally.autoshop.controller.customers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.imraazrally.autoshop.model.customers.AddCustomerAction;
import com.imraazrally.autoshop.model.customers.Customer;
import com.imraazrally.autoshop.model.customers.CustomerAction;
import com.imraazrally.autoshop.model.customers.CustomerConsts;
import com.imraazrally.autoshop.model.customers.CustomerServices;
import com.imraazrally.autoshop.model.customers.PrintAjaxResponse;
import com.imraazrally.autoshop.model.login.LoginConsts;
import com.imraazrally.autoshop.model.login.LoginDb;

@Controller
public class AddCustomer {
	@RequestMapping("addCustomer")
	// Getting customer information from request parameters and building a
	// Customer Object
	// And Adding the customer to database
	public void buildCustomer(

			@RequestParam(value = "fName") String fName, @RequestParam(value = "lName") String lName,
			@RequestParam(value = "email") String email, @RequestParam(value = "phone") String phone,
			@RequestParam(value = "address") String address, HttpServletRequest request, HttpServletResponse response

	) throws IOException {
		// 0. Prerequesites
		SessionFactory sessionFactory=(SessionFactory)request.getSession().getAttribute("sessionFactory");
				
		PrintWriter ajaxResponseWriter = response.getWriter();

		// 1. Creating Customer Object
		Customer customer = new Customer(fName, lName, email, phone, address);

		// 2. Creating Customer Services Object
		CustomerServices customerServices = new CustomerServices();

		// 3. Actions to perform
		CustomerAction addCustomer = new AddCustomerAction(customer,sessionFactory.openSession());
		CustomerAction printAjaxSuccessResponse = new PrintAjaxResponse(ajaxResponseWriter,
				CustomerConsts.ADD_CUSTOMER_SUCCESS_MESSAGE);
		CustomerAction printAjaxFailureResponse = new PrintAjaxResponse(ajaxResponseWriter,
				CustomerConsts.ADD_CUSTOMER_FAIL_MESSAGE);

		// 3. Adding Customer to database and printing ajax response message
		if (customerServices.execute(addCustomer)) {
			customerServices.execute(printAjaxSuccessResponse);
		} else {
			customerServices.execute(printAjaxFailureResponse);
		}
	}

}
