package com.cg.smartbucket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class RedirectController {
	
	@RequestMapping(value="/")
	public String loginPage(){	
		return "index";
	}
	
	
	
}
