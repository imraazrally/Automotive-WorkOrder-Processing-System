package com.imraazrally.autoshop.model.customers;

public class CustomerConsts {

	public static final String ADD_CUSTOMER_QUERY = "INSERT INTO customer_info  VALUES (NULL,'%s', '%s', '%s', '%s', '%s')";
	public static final String GET_CUSTOMER_USING_PHONE_QUERY="SELECT * FROM customer_info WHERE phone='%s'";
	public static final String GET_CUSTOMER_USING_NAME_QUERY="SELECT * FROM customer_info WHERE fName='%s' and lName='%s'";	
	public static final String RETRIEVE_CUSTOMER_USING_ID_QUERY="SELECT * FROM customer_info WHERE customerId=%s";	
	public static final String ADD_CUSTOMER_SUCCESS_MESSAGE = "<b>Thank You</b>, Successfully Added Customer! ";
	public static final String ADD_CUSTOMER_FAIL_MESSAGE = "<b>Sorry</b>, Could not add customer...";

}
