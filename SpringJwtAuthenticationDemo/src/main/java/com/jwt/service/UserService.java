package com.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.model.Users;

@Service
public class UserService {
	
	private List<Users> store=new ArrayList<>();

	public UserService() {
		store.add(new Users(UUID.randomUUID().toString(),"D Dhanush","dhanu@gmail.com"));
		store.add(new Users(UUID.randomUUID().toString(), "Alice Smith", "alice.smith@example.com"));
		store.add(new Users(UUID.randomUUID().toString(), "Bob Johnson", "bob.johnson@example.com"));
		store.add(new Users(UUID.randomUUID().toString(), "Catherine Lee", "catherine.lee@example.com"));
		store.add(new Users(UUID.randomUUID().toString(), "David Kim", "david.kim@example.com"));
		store.add(new Users(UUID.randomUUID().toString(), "Emily Davis", "emily.davis@example.com"));
	
	}

	public List<Users> getUsers() {
		return this.store;
	}

	public void setStore(List<Users> store) {
		this.store = store;
	}
	
	
	

}
