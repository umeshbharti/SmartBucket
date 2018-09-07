package com.cg.smartbucket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.smartbucket.repository.UserRepository;

@Service
public class ServiceProvider {

	@Autowired
	private UserRepository userRepository;
	
}
