package com.cyq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyq.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/getUserById")
	public Object getUserById(String id) {
		return userService.getUser(id);
	}

}
