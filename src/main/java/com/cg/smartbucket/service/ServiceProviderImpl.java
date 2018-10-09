package com.cg.smartbucket.service;

import java.util.Base64;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		user.setPassword(new BCryptPasswordEncoder().encode((user.getPassword())));
		return userRepository.save(user)!=null?true:false;
	}

	public boolean validateUser(Login loginDetails){
		User loggedUser = getUser(loginDetails.getEmail()); 
		if(loggedUser == null){
			logger.info("User not found");
			return false;
		}

		if(loggedUser!=null && (new BCryptPasswordEncoder().matches(loginDetails.getPassword().trim(),loggedUser.getPassword().trim()))){
			logger.info("Login successful");
			return true;
		}
		return false;

	}
	private User getUser(String email){
		return userRepository.findByEmail(email);
	}

	private String encodePassword(String password){
		return Base64.getEncoder().encodeToString(password.toString().getBytes());
	}

	private String decodePassword(String encodedPassword){
		return Base64.getDecoder().decode(encodedPassword).toString();
	}

}