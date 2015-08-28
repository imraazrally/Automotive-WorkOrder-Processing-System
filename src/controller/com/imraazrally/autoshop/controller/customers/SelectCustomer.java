package com.imraazrally.autoshop.controller.customers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imraazrally.autoshop.model.login.Key;
import com.imraazrally.autoshop.model.login.KeyVerifier;
import com.imraazrally.autoshop.model.login.LoginConsts;

@Controller
public class SelectCustomer {
	@RequestMapping("/selectCustomerUsingPhone")
	public ModelAndView verifyCredentials(HttpServletRequest request){
		//Getting Key from session
		Key key = (Key) request.getSession().getAttribute("key");

		//Creating a list of allowed permission
		@SuppressWarnings("serial")
		ArrayList<Integer> permission=new ArrayList<Integer>(){{ 
			//This page requries users to have at least GUEST level permission
			add(LoginConsts.ADMIN);
			add(LoginConsts.GUEST);
		}};
		
		// Verifying if user has gust+ level permission
		KeyVerifier verifier=new KeyVerifier(key,permission);
		if(verifier.verify())return doTask();
		
		//If user does not satisfy required permissions,
		return new ModelAndView(LoginConsts.roleIdToView.get(LoginConsts.BLOCKED));
	}
	
	private ModelAndView doTask(){
		return new ModelAndView("customers/selectCustomerPhone");
	}
}
