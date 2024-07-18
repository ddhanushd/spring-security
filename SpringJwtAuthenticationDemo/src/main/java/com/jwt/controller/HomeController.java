package com.jwt.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.Users;
import com.jwt.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public String getUser() {
		System.out.println("geeting users");
		return "Users";
	}
	
	@GetMapping("/users")
	public List<Users> getallUsers() {
		System.out.println("geeting users");
		return userService.getUsers();
	}
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal){
		return principal.getName();
		
	}

}
