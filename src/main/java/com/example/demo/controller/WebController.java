package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	protected Logger logger;
	public WebController() {
		logger = LoggerFactory.getLogger(getClass());
	}
    @RequestMapping(value="/")
    public String home(){
    	logger.debug("access home page!");
        return "home";
    }
   
    @RequestMapping(value="/user")
    public String user(){
    	logger.debug("access user page!");
        return "user";
    }
  
    @RequestMapping(value="/admin")
    public String admin(){
    	logger.debug("access admin page!");
        return "admin";
    }
   
    @RequestMapping(value="/login")
    public String login(){
    	logger.debug("access login page!");
        return "login";
    }
   
    @RequestMapping(value="/403")
    public String Error403(){
    	logger.debug("access 403 page!");
        return "403";
    }
}