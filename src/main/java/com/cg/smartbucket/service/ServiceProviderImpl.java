package com.cg.smartbucket.service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.smartbucket.model.Login;
import com.cg.smartbucket.model.User;
import com.cg.smartbucket.repository.UserRepository;

@Service
public class ServiceProviderImpl {

	Logger logger = Logger.getLogger(ServiceProviderImpl.class.getName());
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean addUser(User user){
		return userRepository.save(user)!=null?true:false;
	}
	
	public void validateUser(Login loginDetails){
		User loggedUser = getUser(loginDetails.getEmail()); 
		if(loggedUser == null){
			logger.info("User not found");
		}
		 if(loggedUser!=null && (loggedUser.getPassword().trim().equals(loginDetails.getPassword().trim()))){
			 logger.info("Login successful");
		 }
		
	}
	private User getUser(String email){
		return userRepository.findByEmail(email);
	}
	
}
