package com.imraazrally.autoshop.controller.login;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.imraazrally.autoshop.model.login.Key;
import com.imraazrally.autoshop.model.login.KeyVerifier;
import com.imraazrally.autoshop.model.login.LoginConsts;

@Controller
public class Customers {
	@RequestMapping("/customers")
	public ModelAndView verifyCredentials(HttpServletRequest request) {
		//Getting Key from session
		Key key = (Key) request.getSession().getAttribute("key");
		
		//Creating a list of allowed permission
		@SuppressWarnings("serial")
		ArrayList<Integer> permission=new ArrayList<Integer>(){{ 
			//This page requries users to have Admin level Permission
			add(LoginConsts.ADMIN);
		}};
				
		// Verifying if user has admin level permission
		KeyVerifier verifier=new KeyVerifier(key,permission);
		if(verifier.verify())return doTask();
	
		// If user is not Admin or Key is not found
		return new ModelAndView(LoginConsts.roleIdToView.get(LoginConsts.BLOCKED));
	}

	private ModelAndView doTask() {
		// This method will be called only if user posses ADMIN level permission
		// forward user to customer page
		return new ModelAndView("customers/customers");
	}
}