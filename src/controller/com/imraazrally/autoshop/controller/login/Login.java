package com.imraazrally.autoshop.controller.login;

import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.imraazrally.autoshop.model.login.Key;
import com.imraazrally.autoshop.model.login.KeyGen;
import com.imraazrally.autoshop.model.login.LoginConsts;
import com.imraazrally.autoshop.model.login.LoginDb;

/*
 This controller recieves request from the login page. The goal is to 
 forward the user to the homepage. The task of this controller is to determine which page to forward to (based on login credentials).
 For example, Admins will be forwarded to a differrent homepage as opposed to guests....
 */

@Controller
public class Login {
	@RequestMapping("/login")
	public ModelAndView authenticate(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, 
			HttpServletRequest request) 
	{
		// Target homepage that we will forward our user to
		ModelAndView target = new ModelAndView();
		
		// Using the LoginDb Service to get a handle on a database connection
		Connection dbConnection = new LoginDb().getConnection(LoginConsts.DB_URL, LoginConsts.DB_USER,LoginConsts.DB_PASS);
		request.getSession().setAttribute("dbConnection", dbConnection);
		
		// Hibernate Configs
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		request.getSession().setAttribute("sessionFactory", sessionFactory);
		
		// Passing the database connection to a KeyGen service and generate a
		Key key = new KeyGen(sessionFactory.openSession()).getKey(username, password);
		request.getSession().setAttribute("key", key);
		target.addObject("key", key);

		// Based on the KEY's roleID, we forward to user to appropriate view.
		target.setViewName(LoginConsts.roleIdToView.get(key.getRole()));
		return target;
	}
}
