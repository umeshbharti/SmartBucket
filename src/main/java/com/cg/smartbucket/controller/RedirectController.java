package com.cg.smartbucket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cg.smartbucket.model.Login;
import com.cg.smartbucket.model.User;
import com.cg.smartbucket.service.ServiceProviderImpl;

@Controller
@RequestMapping("/")
public class RedirectController {
	
	@Autowired
	ServiceProviderImpl provider;
	
	@RequestMapping(value="/signuppage")
	public String signUpPage(){	
		return "newsignup";
	}
	
	@RequestMapping(value="/signupUser",method = RequestMethod.POST)
	public String userSignUp(@ModelAttribute User user){
		if(provider.addUser(user)== true)
		return "signupsuccess";
		else
		return "newsignup";
	}
	
/*	@RequestMapping(value = "/error")
	public void handleerror() {
		System.out.println("This is error");
	}*/
	
	@RequestMapping(value="/loginUser",method = RequestMethod.POST)
	public String login(@ModelAttribute Login loginDetails, HttpServletRequest request){
		if(provider.validateUser(loginDetails)){
			request.getSession().setMaxInactiveInterval(60);
			return "loginsuccess";
		}
		return "index";
	}
		
	
	@RequestMapping(value="/admin")
	public String adminTest() {
		return "adminPage";
	}
	
	@RequestMapping(value="/")
	public String loginReturn(){
		return "index";
	}
	
	@RequestMapping(value="/adminLoginSuccess")
	public String adminLogin(){
		return "loginsuccess";
	}
	
	@RequestMapping(value="/invalidate")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}
