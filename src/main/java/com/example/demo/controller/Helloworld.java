package com.example.demo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ForbiddenException;

@RestController
public class Helloworld {
	private static final Logger LOGGER = LoggerFactory.getLogger(Helloworld.class);
	@RequestMapping("/")
	public String handleRequest() throws RuntimeException {
		LOGGER.debug("This is homepage");
		return "hello world";
	  }
	@RequestMapping("/admin")
	  public void handleAdminRequest() throws ForbiddenException {
	      throw new ForbiddenException("The requested page is forbidden");
	  }
}
